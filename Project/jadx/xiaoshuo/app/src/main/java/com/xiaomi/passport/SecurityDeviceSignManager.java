package com.xiaomi.passport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.xiaomi.passport.ISecurityDeviceSignResponse;
import com.xiaomi.passport.ISecurityDeviceSignService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes8.dex */
public class SecurityDeviceSignManager {
    private static final String ACTION_SECURITY_DEVICE_SIGN = "com.xiaomi.account.action.SECURITY_DEVICE_SIGN";
    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    public static final String KEY_CUP_ID = "cpuId";
    public static final String KEY_DEVICE_ID = "deviceId";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_EXTRA_PARAMS_JSON_STRING = "extraParamsJsonStr";
    public static final String KEY_USER_DATA = "userData";
    private static final String PACKAGE_NAME_SERVICE = "com.xiaomi.account";
    private static final String TAG = "SecurityDeviceSignMngr";
    private static final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    private static SecurityDeviceReport sSecurityDeviceReport;

    public interface SecurityDeviceReport {
        void report(Context context, int i, String str, String str2);
    }

    public static abstract class SignServiceFutureTask extends FutureTask<Bundle> implements ServiceConnection {
        private boolean mBind;
        private Context mContext;
        protected ISecurityDeviceSignResponse mResponse;

        public class Response extends ISecurityDeviceSignResponse.Stub {
            private Response() {
            }

            @Override // com.xiaomi.passport.ISecurityDeviceSignResponse
            public void onResult(Bundle bundle) throws RemoteException {
                SignServiceFutureTask.this.set(bundle);
            }
        }

        public SignServiceFutureTask(Context context) {
            super(new Callable<Bundle>() { // from class: com.xiaomi.passport.SecurityDeviceSignManager.SignServiceFutureTask.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Bundle call() throws Exception {
                    throw new IllegalStateException("should not be call here!");
                }
            });
            this.mContext = context;
            this.mResponse = new Response();
        }

        public abstract void callServiceWork(ISecurityDeviceSignService iSecurityDeviceSignService);

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            callServiceWork(ISecurityDeviceSignService.Stub.asInterface(iBinder));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // java.util.concurrent.FutureTask
        public void setException(Throwable th) {
            super.setException(th);
            unbind();
        }

        public SignServiceFutureTask start() {
            Intent intent = new Intent(SecurityDeviceSignManager.ACTION_SECURITY_DEVICE_SIGN);
            intent.setPackage("com.xiaomi.account");
            boolean zBindService = this.mContext.bindService(intent, this, 1);
            this.mBind = zBindService;
            if (!zBindService) {
                setException(new RemoteException("failed to bind service"));
            }
            return this;
        }

        public void unbind() {
            Context context = this.mContext;
            if (context == null || !this.mBind) {
                return;
            }
            context.unbindService(this);
            this.mContext = null;
        }

        @Override // java.util.concurrent.FutureTask
        public void set(Bundle bundle) {
            super.set(bundle);
            unbind();
        }
    }

    static {
        try {
            sSecurityDeviceReport = (SecurityDeviceReport) SecurityDeviceReporter.class.newInstance();
            AccountLogger.log(TAG, "sSecurityDeviceReport init suc");
        } catch (Exception e) {
            AccountLogger.log(TAG, "sSecurityDeviceReport init err:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle blockingSignImpl(final Context context, final String str, final Bundle bundle) {
        String message;
        try {
            Bundle bundle2 = new SignServiceFutureTask(context) { // from class: com.xiaomi.passport.SecurityDeviceSignManager.2
                @Override // com.xiaomi.passport.SecurityDeviceSignManager.SignServiceFutureTask
                public void callServiceWork(final ISecurityDeviceSignService iSecurityDeviceSignService) {
                    SecurityDeviceSignManager.mThreadPool.submit(new Runnable() { // from class: com.xiaomi.passport.SecurityDeviceSignManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ISecurityDeviceSignService iSecurityDeviceSignService2 = iSecurityDeviceSignService;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                ISecurityDeviceSignResponse iSecurityDeviceSignResponse = anonymousClass2.mResponse;
                                String packageName = context.getPackageName();
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                iSecurityDeviceSignService2.sign(iSecurityDeviceSignResponse, packageName, str, bundle);
                            } catch (RemoteException e) {
                                setException(e);
                            }
                        }
                    });
                }
            }.start().get();
            if (bundle2.getInt("errorCode") == 2) {
                reportSecurityDevice(context, 2, bundle2.getString("cpuId", ""), bundle2.getString("deviceId", ""));
            }
            return bundle2;
        } catch (InterruptedException e) {
            message = e.getMessage();
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("booleanResult", false);
            bundle3.putInt("errorCode", 1);
            bundle3.putString("errorMessage", message);
            return bundle3;
        } catch (ExecutionException e2) {
            message = e2.getMessage();
            Bundle bundle32 = new Bundle();
            bundle32.putBoolean("booleanResult", false);
            bundle32.putInt("errorCode", 1);
            bundle32.putString("errorMessage", message);
            return bundle32;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkHasSignService(Context context) {
        Intent intent = new Intent(ACTION_SECURITY_DEVICE_SIGN);
        intent.setPackage("com.xiaomi.account");
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
    }

    public static void reportSecurityDevice(Context context, int i, String str, String str2) {
        SecurityDeviceReport securityDeviceReport = sSecurityDeviceReport;
        if (securityDeviceReport != null) {
            securityDeviceReport.report(context, i, str, str2);
        }
    }

    public static void setSecurityDeviceReport(SecurityDeviceReport securityDeviceReport) {
        sSecurityDeviceReport = securityDeviceReport;
    }

    public static FutureTask<Bundle> sign(final Context context, final String str, final Bundle bundle) {
        if (context == null) {
            throw new IllegalArgumentException("context should not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("input data should not be empty");
        }
        FutureTask<Bundle> futureTask = new FutureTask<>(new Callable<Bundle>() { // from class: com.xiaomi.passport.SecurityDeviceSignManager.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Bundle call() throws Exception {
                if (SecurityDeviceSignManager.checkHasSignService(context)) {
                    return SecurityDeviceSignManager.blockingSignImpl(context, str, bundle);
                }
                SecurityDeviceSignManager.reportSecurityDevice(context, 4, "", "");
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("booleanResult", false);
                bundle2.putInt("errorCode", 4);
                bundle2.putString("errorMessage", "no sign service");
                return bundle2;
            }
        });
        mThreadPool.submit(futureTask);
        return futureTask;
    }

    public static String syncSignStringArray(Context context, String[] strArr, Bundle bundle, long j) {
        FutureTask<Bundle> futureTaskSign = sign(context, TextUtils.join(a.p, strArr), bundle);
        try {
            Bundle bundle2 = j > 0 ? futureTaskSign.get(j, TimeUnit.MILLISECONDS) : futureTaskSign.get();
            boolean z = bundle2.getBoolean("booleanResult", false);
            String string = bundle2.getString("errorMessage");
            if (z) {
                return bundle2.getString("userData");
            }
            AccountLogger.log(TAG, "failed with " + string);
            return null;
        } catch (InterruptedException e) {
            AccountLogger.log(TAG, "syncSignStringArray", e);
            return null;
        } catch (ExecutionException e2) {
            AccountLogger.log(TAG, "syncSignStringArray", e2);
            return null;
        } catch (TimeoutException e3) {
            AccountLogger.log(TAG, "syncSignStringArray", e3);
            return null;
        }
    }
}
