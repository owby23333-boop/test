package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.n.e;
import com.kwad.components.core.r.n;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.collector.h;
import com.kwad.sdk.core.download.a;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.l;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.x;
import com.kwai.sodler.kwai.a;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
public class KsAdSDKImpl implements IKsAdSDK {
    private static final String TAG = "KSAdSDK";
    private boolean adxEnable;
    private boolean isExternal;

    @Nullable
    private KsLoadManager mAdRequestManager;
    private int mApiVersionCode;
    private String mApiVersionName;
    private String mAppTag;
    private long mInitTime;
    private volatile boolean mIsSdkInit;
    private long mLaunchTime;
    private volatile boolean personalRecommend;
    private boolean programmaticRecommend;

    static class a {
        private static final KsAdSDKImpl Yj = new KsAdSDKImpl();
    }

    private KsAdSDKImpl() {
        this.mIsSdkInit = false;
        this.mApiVersionName = "";
        this.personalRecommend = true;
        this.programmaticRecommend = true;
        this.adxEnable = false;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.Yj;
    }

    private void initApkClean() {
        try {
            com.kwad.sdk.core.diskcache.a.aT(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initAppTag() {
        x.X(ServiceProvider.getContext(), this.mAppTag);
        this.mAppTag = null;
    }

    private void initCommercialLogger() {
        try {
            KSLoggerReporter.a(new KSLoggerReporter.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final void f(String str, String str2, boolean z2) {
                    com.kwad.components.core.m.a.pr().e(str, str2, false);
                }

                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final boolean sD() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.abI);
                }

                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final JSONObject sE() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.abT);
                }
            });
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initComponents() {
        try {
            com.kwad.sdk.components.b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initComponentsManager() {
        try {
            com.kwad.sdk.components.c.init(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initConfigRequestManager() {
        try {
            com.kwad.components.core.n.e.a(ServiceProvider.getContext(), new e.a() { // from class: com.kwad.sdk.KsAdSDKImpl.4
                @Override // com.kwad.components.core.n.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.b.i(KsAdSDKImpl.TAG, "onConfigRefresh()");
                    try {
                        KsAdSDKImpl.this.initOnConfigRefresh(sdkConfigData);
                    } catch (Throwable th) {
                        com.kwad.components.core.c.a.b(th);
                    }
                }

                @Override // com.kwad.components.core.n.e.a
                public final void oi() {
                    com.kwad.sdk.core.d.b.z(KsAdSDKImpl.TAG, "onCacheLoaded()");
                    com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                }
            });
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initDownload() {
        try {
            com.kwad.sdk.core.download.a.aU(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initExceptionModule() {
        try {
            com.kwad.components.core.c.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initHybrid() {
        try {
            com.kwad.sdk.core.webview.a.a.zl().init(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initIDC() {
        try {
            com.kwad.sdk.core.network.idc.a.wy().init(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initInstalledReceiver() {
        try {
            com.kwad.components.core.r.g.at(getContext()).qf();
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initLifecycleHolder() {
        try {
            com.kwad.sdk.core.b.b.we().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initLottie() {
    }

    private void initOAID() {
        try {
            com.kwad.sdk.core.e.a.initAsync(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initOfflineComponents() {
        try {
            com.kwad.components.core.offline.init.b.init(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOnConfigRefresh(SdkConfigData sdkConfigData) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        initHybrid();
        com.kwad.sdk.core.config.d.sK();
        if (com.kwad.sdk.core.config.d.un() || com.kwad.b.kwai.a.bI.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.getContext());
        }
        com.kwad.components.core.m.a.pr().ao(getContext());
        if (com.kwad.sdk.core.config.d.uX()) {
            com.kwad.sdk.a.a.init(bo.dt(ServiceProvider.getContext()));
        }
        initSpeedLimitConfig();
        aw.init(getContext());
        com.kwad.components.core.kwai.a.mo().fc();
        com.kwad.sdk.utils.f.a(getContext(), 30000L, new h() { // from class: com.kwad.sdk.KsAdSDKImpl.5
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.m.a.pr().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.wy().a(com.kwad.sdk.core.config.d.uY());
        be.a(com.kwad.sdk.core.config.d.uZ(), com.kwad.sdk.core.config.d.va(), ServiceProvider.getContext());
        initInstalledReceiver();
        initApkClean();
        com.kwad.components.core.f.a.nV().ai(getContext());
        com.kwad.sdk.crash.online.monitor.a.cs(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adq));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.ranger.d.cs(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adu));
        com.kwad.sdk.core.threads.d.cs(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adv));
        com.kwad.sdk.f.b.Bo();
    }

    private void initPackCheck() {
        try {
            n.qi().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initPrivateData() {
        try {
            at.init(getContext());
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initSDKModule() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mInitTime = jElapsedRealtime;
        com.kwad.sdk.service.a.init();
        e.sH();
        initCommercialLogger();
        f.E(this.mLaunchTime);
        initComponents();
        initOAID();
        initSdkLog();
        initIDC();
        initDownload();
        initSOLoader();
        initAppTag();
        initConfigRequestManager();
        initExceptionModule();
        initComponentsManager();
        initOfflineComponents();
        initLifecycleHolder();
        initLottie();
        initPrivateData();
        initPackCheck();
        com.kwad.sdk.kwai.kwai.c.tm().to();
        com.kwad.components.core.m.a.pr().ps();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.sdk.core.d.b.d(TAG, "KSAdSDK init time:" + jElapsedRealtime2);
        f.F(jElapsedRealtime2);
        notifyInitSuccess(ServiceProvider.CF());
        com.kwad.sdk.f.a.report();
        this.mIsSdkInit = true;
    }

    private void initSOLoader() {
        try {
            com.kwai.sodler.kwai.a.a(new a.InterfaceC0472a() { // from class: com.kwad.sdk.KsAdSDKImpl.7
                @Override // com.kwai.sodler.kwai.a.InterfaceC0472a
                public final void a(com.kwai.sodler.lib.a.f fVar, File file) throws PluginError.UpdateError {
                    try {
                        com.kwad.sdk.core.download.a.a(fVar.getDownloadUrl(), file, (a.b) null, -1, true);
                    } catch (Throwable th) {
                        if (th instanceof Exception) {
                            com.kwad.sdk.core.network.idc.a.wy().d(fVar.getDownloadUrl(), th);
                        }
                        throw new PluginError.UpdateError(th.getMessage(), -4);
                    }
                }

                @Override // com.kwai.sodler.kwai.a.InterfaceC0472a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.acR);
                }

                @Override // com.kwai.sodler.kwai.a.InterfaceC0472a
                public final boolean sF() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.acQ);
                }
            });
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.d.b.a(ServiceProvider.CF().enableDebug, new com.kwad.sdk.core.d.kwai.a() { // from class: com.kwad.sdk.KsAdSDKImpl.6
                @Override // com.kwad.sdk.core.d.kwai.a
                public final void m(String str, String str2) {
                    l lVar = new l();
                    lVar.ahV = str;
                    KSLoggerReporter.a(lVar, str2);
                }
            });
        } catch (Throwable th) {
            g.d(th);
        }
    }

    private void initSpeedLimitConfig() {
        com.kwad.components.core.o.b.pC();
        com.kwad.components.core.o.b.e(com.kwad.sdk.core.config.d.uq(), com.kwad.sdk.core.config.d.ur());
    }

    private boolean isRemoteService() {
        String processName = ao.getProcessName(ServiceProvider.getContext());
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    public static void notifyInitFail(SdkConfig sdkConfig, final com.kwad.sdk.a aVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bh.postOnUiThread(new av() { // from class: com.kwad.sdk.KsAdSDKImpl.2
                        @Override // com.kwad.sdk.utils.av
                        public final void doTask() {
                            KsInitCallback ksInitCallback2 = ksInitCallback;
                            com.kwad.sdk.a aVar2 = aVar;
                            ksInitCallback2.onFail(aVar2.code, aVar2.msg);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void notifyInitSuccess(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bh.postOnUiThread(new av() { // from class: com.kwad.sdk.KsAdSDKImpl.3
                        @Override // com.kwad.sdk.utils.av
                        public final void doTask() {
                            ksInitCallback.onSuccess();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.kwai.d.d(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        if ("autoRT".equals(str)) {
            return -1;
        }
        if ("getAutoRevertTime".equals(str)) {
            return 10000;
        }
        boolean z2 = false;
        if ("TRANSFORM_API_HOST".equals(str)) {
            return com.kwad.sdk.core.network.idc.a.wy().E(objArr[0].toString(), "api");
        }
        if ("reportDynamicUpdate".equals(str)) {
            KSLoggerReporter.o((JSONObject) objArr[0]);
            return Boolean.TRUE;
        }
        if (!"enableDynamic".equals(str)) {
            return null;
        }
        if (ao.isInMainProcess(ServiceProvider.getContext()) && com.kwad.b.kwai.a.XV.booleanValue()) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.a.a.vE().delete();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.components.core.b();
        }
        return this.mAdRequestManager;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return this.mApiVersionName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        return ServiceProvider.CF().appId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.xA();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return ServiceProvider.CF().appName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        return ServiceProvider.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.xC().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return at.getDeviceId();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.xF().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        return com.kwad.sdk.core.kwai.d.getResponseData(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        return com.kwad.sdk.core.kwai.d.bF(str);
    }

    public long getSDKInitTime() {
        return this.mInitTime;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        return "3.3.38";
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        return 3033800;
    }

    public boolean hasInitFinish() {
        return this.mIsSdkInit;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
                if (!TextUtils.isEmpty(sdkConfig.appId)) {
                    String str = "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.mIsSdkInit;
                    if (this.mIsSdkInit) {
                        ServiceProvider.a(sdkConfig);
                        return;
                    }
                    ServiceProvider.a(sdkConfig);
                    ServiceProvider.bE(context.getApplicationContext());
                    if (isRemoteService()) {
                        String str2 = "intKSRemoteProcess appId=" + sdkConfig.appId;
                        e.sH();
                        initSdkLog();
                        this.mIsSdkInit = true;
                    } else {
                        try {
                            g.te();
                            initSDKModule();
                        } catch (Throwable th) {
                            String stackTraceString = Log.getStackTraceString(th);
                            g.a(th, stackTraceString);
                            notifyInitFail(sdkConfig, new com.kwad.sdk.a(10002, stackTraceString));
                            return;
                        }
                    }
                }
            } finally {
            }
            return;
        }
        notifyInitFail(sdkConfig, com.kwad.sdk.a.XZ);
    }

    public boolean isAdxEnable() {
        return this.adxEnable;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        return ServiceProvider.CF().enableDebug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public boolean isProgrammaticRecommend() {
        return this.programmaticRecommend;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class clsG = com.kwad.sdk.service.a.g(cls);
            if (clsG == null) {
                if (obj instanceof BaseProxyActivity) {
                    clsG = com.kwad.components.core.l.b.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    clsG = com.kwad.components.core.l.c.class;
                }
                com.kwad.components.core.c.a.b(new RuntimeException("--getIsExternal:" + getIsExternal() + "--mIsSdkInit:" + hasInitFinish() + "--componentClass" + cls));
            }
            return (T) clsG.newInstance();
        } catch (Exception e2) {
            com.kwad.components.core.c.a.b(e2);
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.a.h(cls).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                th.printStackTrace();
            }
            com.kwad.components.core.c.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i2, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.kwai.d.a(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z2) {
        this.adxEnable = z2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        this.mApiVersionName = str;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i2) {
        this.mApiVersionCode = i2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        if (this.mIsSdkInit) {
            x.X(ServiceProvider.getContext(), this.mAppTag);
        } else {
            this.mAppTag = str;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z2) {
        this.isExternal = z2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j2) {
        this.mLaunchTime = j2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z2, @RawRes int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z2, @ColorInt int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z2) {
        this.personalRecommend = z2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z2) {
        this.programmaticRecommend = z2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        com.kwad.sdk.core.download.c.vG().aX(getContext());
        com.kwad.components.core.r.g.at(getContext()).qh();
    }
}
