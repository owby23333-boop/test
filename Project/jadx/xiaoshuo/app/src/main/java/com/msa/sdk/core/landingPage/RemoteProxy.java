package com.msa.sdk.core.landingPage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;
import com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener;
import com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import com.msa.sdk.tool.MsaUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class RemoteProxy {
    private static final String CHANGE_SKIN_SERVICE_ACTION = "miui.intent.action.ad.LANDING_PAGE_SERVICEV2";
    private static final long CONNECTION_SERVICE_TIME_OUT = 1000;
    public static final String TAG = "RemoteProxy";
    private Context mContext;
    private ILandingPageServiceV2 mService;
    private Object mLock = new Object();
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.msa.sdk.core.landingPage.RemoteProxy.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                synchronized (RemoteProxy.this.mLock) {
                    RemoteProxy.this.mService = ILandingPageServiceV2.Stub.asInterface(iBinder);
                    RemoteProxy.this.mLock.notifyAll();
                }
            } catch (Exception e) {
                Log.e(RemoteProxy.TAG, "onServiceConnected", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(RemoteProxy.TAG, "onServiceDisconnected");
            synchronized (RemoteProxy.this.mLock) {
                RemoteProxy.this.mService = null;
            }
        }
    };

    public RemoteProxy(Context context) {
        this.mContext = context;
        ensureService();
    }

    private Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setAction(CHANGE_SKIN_SERVICE_ACTION);
        intent.setPackage(MsaUtils.getMsaPackageName(this.mContext));
        return intent;
    }

    private boolean isConnected() {
        return isServiceBuiltIn(this.mContext) && this.mService != null;
    }

    private boolean isServiceBuiltIn(Context context) {
        List<ResolveInfo> listQueryIntentServices;
        try {
            Intent serviceIntent = getServiceIntent();
            if (context != null && context.getPackageManager() != null && (listQueryIntentServices = context.getPackageManager().queryIntentServices(serviceIntent, 0)) != null && listQueryIntentServices.size() > 0) {
                Log.d(TAG, "find the ad service in systemAdSolution.");
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG, "some exceptions occur when judge if there is the system ad app.", e);
        }
        Log.e(TAG, "there is no a systemAdSolution app.");
        return false;
    }

    private boolean reCheckConnection() throws Exception {
        reConnectionIfNeed();
        if (isConnected()) {
            return true;
        }
        this.mLock.wait(1000L);
        return isConnected();
    }

    private void reConnectionIfNeed() {
        if (this.mService == null) {
            ensureService();
        }
    }

    public void cancelTask(String str) {
        try {
            synchronized (this.mLock) {
                if (reCheckConnection()) {
                    this.mService.cancelTask(str);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "cancelTask e : ", e);
            ensureService();
        }
    }

    public void ensureService() {
        if (isServiceBuiltIn(this.mContext)) {
            try {
                this.mContext.bindService(getServiceIntent(), this.mServiceConnection, 1);
            } catch (Exception e) {
                Log.e(TAG, "could not bind the service.", e);
            }
        }
    }

    public void executeTask(List<Action> list, IActionTaskResultListener iActionTaskResultListener) {
        try {
            synchronized (this.mLock) {
                if (reCheckConnection()) {
                    this.mService.executeTask(list, iActionTaskResultListener);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "executeTask e : ", e);
            ensureService();
        }
    }

    public AppStatus getPackageDownloadStatus(String str) {
        try {
        } catch (Exception e) {
            Log.e(TAG, "cancelTask e : ", e);
            ensureService();
        }
        synchronized (this.mLock) {
            if (!reCheckConnection()) {
                return AppStatus.UNKNOWN;
            }
            return AppStatus.values()[this.mService.getPackageDownloadStatus(str)];
        }
    }

    public int getServiceVersion() {
        try {
            synchronized (this.mLock) {
                if (!reCheckConnection()) {
                    return 0;
                }
                return this.mService.getServiceVersion();
            }
        } catch (Exception e) {
            Log.e(TAG, "getServiceVersion e : ", e);
            ensureService();
            return 0;
        }
    }
}
