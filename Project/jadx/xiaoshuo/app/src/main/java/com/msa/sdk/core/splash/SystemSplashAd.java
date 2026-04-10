package com.msa.sdk.core.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.miui.systemAdSolution.splashAd.IAdListener;
import com.miui.systemAdSolution.splashAd.ISystemSplashAdService;
import com.msa.sdk.tool.MLog;
import com.msa.sdk.tool.MsaUtils;
import com.msa.sdk.tool.RemoteMethodInvoker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class SystemSplashAd {
    private static final long CONNECTION_SERVICE_TIME_OUT = 500;
    private static final String SYSTEM_SPLASH_AD_SERVICE_ACTION = "miui.intent.action.ad.SYSTEM_SPLASH_AD_SERVICE";
    private static final String TAG = "SystemSplashAd";
    private static volatile SystemSplashAd mInstance;
    private IAdListener mAdListener = null;
    public IAdListener sdkListener = new IAdListener.Stub() { // from class: com.msa.sdk.core.splash.SystemSplashAd.5
        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdClick() throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdClick();
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdDismissed() throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdDismissed();
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdError() throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdError();
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdLoaded() throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdLoaded();
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdShowError(int i) throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdShowError(i);
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onAdSkip() throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onAdSkip();
            }
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public boolean onClickJumpToMiniProgram(long j, String str, String str2) throws RemoteException {
            if (System.currentTimeMillis() >= j || SystemSplashAd.this.mAdListener == null) {
                return false;
            }
            return SystemSplashAd.this.mAdListener.onClickJumpToMiniProgram(j, str, str2);
        }

        @Override // com.miui.systemAdSolution.splashAd.IAdListener
        public void onTransitionAdLoaded(String str) throws RemoteException {
            if (SystemSplashAd.this.mAdListener != null) {
                SystemSplashAd.this.mAdListener.onTransitionAdLoaded(str);
            }
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private SystemSplashAd() {
    }

    public static void cancelRequestAd(Context context) {
        getInstance().doCancelRequestAd(context);
    }

    private void doCancelRequestAd(final Context context) {
        this.mExecutorService.submit(new Runnable() { // from class: com.msa.sdk.core.splash.SystemSplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                new RemoteMethodInvoker<Void, ISystemSplashAdService>(context, ISystemSplashAdService.class) { // from class: com.msa.sdk.core.splash.SystemSplashAd.1.1
                    @Override // com.msa.sdk.tool.RemoteMethodInvoker
                    public Void innerInvoke(ISystemSplashAdService iSystemSplashAdService) throws RemoteException {
                        iSystemSplashAdService.cancelSplashAd(context.getPackageName());
                        return null;
                    }
                }.invoke(SystemSplashAd.this.getServiceIntent(context));
            }
        });
    }

    private void doRequestAd(final Context context, final SplashSdkConfig splashSdkConfig, final IAdListener iAdListener) {
        this.mExecutorService.submit(new Runnable() { // from class: com.msa.sdk.core.splash.SystemSplashAd.4
            @Override // java.lang.Runnable
            public void run() {
                Boolean boolInvoke = new RemoteMethodInvoker<Boolean, ISystemSplashAdService>(context, ISystemSplashAdService.class) { // from class: com.msa.sdk.core.splash.SystemSplashAd.4.1
                    @Override // com.msa.sdk.tool.RemoteMethodInvoker
                    public Boolean innerInvoke(ISystemSplashAdService iSystemSplashAdService) throws RemoteException {
                        if (splashSdkConfig != null) {
                            MLog.i(SystemSplashAd.TAG, "set config " + splashSdkConfig.serialize());
                            iSystemSplashAdService.setSplashAdConfig(context.getPackageName(), splashSdkConfig.serialize());
                        } else {
                            MLog.i(SystemSplashAd.TAG, "set new config " + splashSdkConfig);
                            iSystemSplashAdService.setSplashAdConfig(context.getPackageName(), new SplashSdkConfig().serialize());
                        }
                        MLog.i(SystemSplashAd.TAG, "request splash ad");
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        SystemSplashAd.this.mAdListener = iAdListener;
                        return Boolean.valueOf(iSystemSplashAdService.requestSplashAd(context.getPackageName(), SystemSplashAd.this.sdkListener));
                    }
                }.invoke(SystemSplashAd.this.getServiceIntent(context));
                if (boolInvoke == null || !boolInvoke.booleanValue()) {
                    try {
                        SystemSplashAd.this.sdkListener.onAdError();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void doSetTransitionAnimation(final Context context, final Rect rect) {
        this.mExecutorService.submit(new Runnable() { // from class: com.msa.sdk.core.splash.SystemSplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                new RemoteMethodInvoker<Void, ISystemSplashAdService>(context, ISystemSplashAdService.class) { // from class: com.msa.sdk.core.splash.SystemSplashAd.3.1
                    @Override // com.msa.sdk.tool.RemoteMethodInvoker
                    public Void innerInvoke(ISystemSplashAdService iSystemSplashAdService) throws RemoteException {
                        iSystemSplashAdService.setTransitionAnimation(context.getPackageName(), rect);
                        return null;
                    }
                }.invoke(SystemSplashAd.this.getServiceIntent(context));
            }
        });
    }

    private void doShowRequestAd(final Context context, final Bundle bundle) {
        this.mExecutorService.submit(new Runnable() { // from class: com.msa.sdk.core.splash.SystemSplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                new RemoteMethodInvoker<Void, ISystemSplashAdService>(context, ISystemSplashAdService.class) { // from class: com.msa.sdk.core.splash.SystemSplashAd.2.1
                    @Override // com.msa.sdk.tool.RemoteMethodInvoker
                    public Void innerInvoke(ISystemSplashAdService iSystemSplashAdService) throws RemoteException {
                        iSystemSplashAdService.showSplashAd(context.getPackageName(), bundle);
                        return null;
                    }
                }.invoke(SystemSplashAd.this.getServiceIntent(context));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getAdSplashType(android.content.Context r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "SystemSplashAd"
            r1 = -1
            if (r12 == 0) goto L90
            int r2 = r12.length()
            if (r2 > 0) goto Ld
            goto L90
        Ld:
            r2 = 0
            java.lang.String r3 = "content://com.miui.systemAdSolution.extContentProvider/currentSplash"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            android.content.ContentProviderClient r11 = r11.acquireContentProviderClient(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            r6 = 0
            r8 = 0
            r9 = 0
            r4 = r11
            r7 = r12
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.lang.String r4 = "current_splash"
            int r1 = r3.getInt(r4, r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.close()
            r11.close()
            goto L64
        L36:
            r12 = move-exception
            goto L85
        L38:
            r3 = move-exception
            r10 = r2
            r2 = r11
            r11 = r10
            goto L42
        L3d:
            r12 = move-exception
            r11 = r2
            goto L85
        L40:
            r3 = move-exception
            r11 = r2
        L42:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r4.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "getSplashIsSystem :"
            r4.append(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L81
            r4.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L81
            if (r11 == 0) goto L5f
            r11.close()
        L5f:
            if (r2 == 0) goto L64
            r2.close()
        L64:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "getSplashIsSystem : package "
            r11.append(r2)
            r11.append(r12)
            java.lang.String r12 = " - "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            android.util.Log.i(r0, r11)
            return r1
        L81:
            r12 = move-exception
            r10 = r2
            r2 = r11
            r11 = r10
        L85:
            if (r2 == 0) goto L8a
            r2.close()
        L8a:
            if (r11 == 0) goto L8f
            r11.close()
        L8f:
            throw r12
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.msa.sdk.core.splash.SystemSplashAd.getAdSplashType(android.content.Context, java.lang.String):int");
    }

    private static SystemSplashAd getInstance() {
        if (mInstance == null) {
            synchronized (SystemSplashAd.class) {
                if (mInstance == null) {
                    mInstance = new SystemSplashAd();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getIsSupportPassiveSplashAd(android.content.Context r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "SystemSplashAd"
            r1 = 0
            if (r12 == 0) goto L90
            int r2 = r12.length()
            if (r2 > 0) goto Ld
            goto L90
        Ld:
            r2 = 0
            java.lang.String r3 = "content://com.miui.systemAdSolution.extContentProvider/supportPassive"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            android.content.ContentProviderClient r11 = r11.acquireContentProviderClient(r5)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L40
            r6 = 0
            r8 = 0
            r9 = 0
            r4 = r11
            r7 = r12
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.lang.String r4 = "support_passive"
            boolean r1 = r3.getBoolean(r4, r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.close()
            r11.close()
            goto L64
        L36:
            r12 = move-exception
            goto L85
        L38:
            r3 = move-exception
            r10 = r2
            r2 = r11
            r11 = r10
            goto L42
        L3d:
            r12 = move-exception
            r11 = r2
            goto L85
        L40:
            r3 = move-exception
            r11 = r2
        L42:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r4.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "getIsSupportPassiveSplashAd :"
            r4.append(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L81
            r4.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L81
            if (r11 == 0) goto L5f
            r11.close()
        L5f:
            if (r2 == 0) goto L64
            r2.close()
        L64:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "getIsSupportPassiveSplashAd : package "
            r11.append(r2)
            r11.append(r12)
            java.lang.String r12 = " - "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            android.util.Log.i(r0, r11)
            return r1
        L81:
            r12 = move-exception
            r10 = r2
            r2 = r11
            r11 = r10
        L85:
            if (r2 == 0) goto L8a
            r2.close()
        L8a:
            if (r11 == 0) goto L8f
            r11.close()
        L8f:
            throw r12
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.msa.sdk.core.splash.SystemSplashAd.getIsSupportPassiveSplashAd(android.content.Context, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getServiceIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction(SYSTEM_SPLASH_AD_SERVICE_ACTION);
        intent.setPackage(MsaUtils.getMsaPackageName(context));
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getSplashSystemAdLastShowTime(android.content.Context r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "SystemSplashAd"
            r1 = -2
            if (r13 == 0) goto L91
            int r3 = r13.length()
            if (r3 > 0) goto Le
            goto L91
        Le:
            r3 = 0
            java.lang.String r4 = "content://com.miui.systemAdSolution.extContentProvider/SystemSplashLastTime"
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            android.content.ContentProviderClient r12 = r12.acquireContentProviderClient(r6)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            r7 = 0
            r9 = 0
            r10 = 0
            r5 = r12
            r8 = r13
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            android.os.Bundle r4 = r3.getExtras()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            java.lang.String r5 = "splash_last_time"
            long r1 = r4.getLong(r5, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r3.close()
            r12.close()
            goto L65
        L37:
            r13 = move-exception
            goto L86
        L39:
            r4 = move-exception
            r11 = r3
            r3 = r12
            r12 = r11
            goto L43
        L3e:
            r13 = move-exception
            r12 = r3
            goto L86
        L41:
            r4 = move-exception
            r12 = r3
        L43:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r5.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = "getSplashSystemAdLastShowTime :"
            r5.append(r6)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L82
            r5.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r0, r4)     // Catch: java.lang.Throwable -> L82
            if (r12 == 0) goto L60
            r12.close()
        L60:
            if (r3 == 0) goto L65
            r3.close()
        L65:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r3 = "getSplashSystemAdLastShowTime : package "
            r12.append(r3)
            r12.append(r13)
            java.lang.String r13 = " - "
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            android.util.Log.i(r0, r12)
            return r1
        L82:
            r13 = move-exception
            r11 = r3
            r3 = r12
            r12 = r11
        L86:
            if (r3 == 0) goto L8b
            r3.close()
        L8b:
            if (r12 == 0) goto L90
            r12.close()
        L90:
            throw r13
        L91:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.msa.sdk.core.splash.SystemSplashAd.getSplashSystemAdLastShowTime(android.content.Context, java.lang.String):long");
    }

    public static void requestAd(Context context, IAdListener iAdListener) {
        if (context == null || iAdListener == null) {
            Log.e(TAG, "the params is Invalid!");
            throw new IllegalArgumentException("the params is Invalid!");
        }
        getInstance().doRequestAd(context, null, iAdListener);
    }

    public static void setTransitionAnimation(Context context, Rect rect) {
        getInstance().doSetTransitionAnimation(context, rect);
    }

    public static void showAd(Context context, Bundle bundle) {
        getInstance().doShowRequestAd(context, bundle);
    }

    public static void requestAd(Context context, IAdListener iAdListener, SplashSdkConfig splashSdkConfig) {
        if (context != null && iAdListener != null) {
            getInstance().doRequestAd(context, splashSdkConfig, iAdListener);
        } else {
            Log.e(TAG, "the params is Invalid!");
            throw new IllegalArgumentException("the params is Invalid!");
        }
    }
}
