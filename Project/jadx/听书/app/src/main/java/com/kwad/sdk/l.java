package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.session.MediaController;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.p;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private long YY;
    private f asA;
    private f asB;
    private f asC;
    private volatile boolean asD;
    private boolean asE;
    private boolean asF;
    private String asG;
    private volatile boolean asp;
    private volatile boolean asq;
    private volatile boolean asr;
    private volatile Boolean ass;
    private String ast;
    private int asu;
    private boolean asv;
    private KsLoadManager asw;
    private long asx;
    private long asy;
    private f asz;

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* synthetic */ l(byte b) {
        this();
    }

    private l() {
        this.asp = false;
        this.asq = false;
        this.asr = false;
        this.ass = null;
        this.ast = "";
        this.asD = true;
        this.asE = true;
        this.asF = false;
    }

    static class a {
        private static final l asL = new l(0);
    }

    public static l Cf() {
        return a.asL;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
                if (!TextUtils.isEmpty(sdkConfig.appId)) {
                    Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.asp);
                    if (this.asp) {
                        com.kwad.sdk.service.b.holderSdkConfig(sdkConfig);
                        return;
                    }
                    com.kwad.sdk.service.b.holderSdkConfig(sdkConfig);
                    ServiceProvider.co(context);
                    if (aP(context)) {
                        Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                        ServiceProvider.Po();
                        j.Be();
                        Cu();
                        this.asp = true;
                    } else {
                        try {
                            n.CO();
                            Ci();
                            n.aS(context);
                        } catch (Throwable th) {
                            Log.e("KSAdSDK", "initSDKModule error", th);
                            String stackTraceString = Log.getStackTraceString(th);
                            n.a(th, stackTraceString);
                            a(sdkConfig, new e(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, stackTraceString));
                            return;
                        }
                    }
                }
            } finally {
            }
            return;
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        a(sdkConfig, e.arV);
    }

    public final synchronized void start() {
        boolean z;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Log.d("KSAdSDK", "KSAdSDK start call");
            if (this.asB == null) {
                this.asB = f.af(this.asx);
            }
            this.asB.report();
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (Cg()) {
                z = false;
            } else {
                b(sDKConfig);
                z = true;
            }
            if (!this.asp) {
                b(sDKConfig, e.arW);
                z = true;
            }
            if (this.asq) {
                b(sDKConfig);
                z = true;
            }
            if (!z) {
                Cj();
                e(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.l.1
                    @Override // com.kwad.sdk.g.a
                    public final void accept(Object obj) {
                    }
                });
                com.kwad.sdk.a.a.c.CU().CW();
                com.kwad.components.core.p.a.se().sf();
                f fVar = this.asz;
                if (fVar != null) {
                    fVar.report();
                }
                f fVar2 = this.asA;
                if (fVar2 != null) {
                    fVar2.report();
                }
                this.asq = true;
                b(sDKConfig);
            }
            com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.l.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.kwad.sdk.core.config.e.Ga()) {
                        com.kwad.sdk.resourceCache.b.cn(l.getContext());
                    }
                }
            }, com.kwad.sdk.core.config.e.Gb(), TimeUnit.SECONDS);
            if (this.asC == null) {
                this.asC = f.ag(SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
            this.asB.report();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public final synchronized boolean Cg() {
        try {
        } catch (Throwable th) {
            Log.e("KSAdSDK", th.getMessage());
            th.printStackTrace();
        }
        if (Ch()) {
            Log.d("KSAdSDK", "enableInitStartMode return false hadLastTimeInitError");
            return false;
        }
        if (this.ass == null) {
            this.ass = Boolean.valueOf(com.kwad.sdk.core.config.e.Cg());
        }
        if (!this.ass.booleanValue()) {
            Log.d("KSAdSDK", "enableInitStartMode return false mConfigEnableInitStart");
            return false;
        }
        if (this.asr) {
            Log.d("KSAdSDK", "enableInitStartMode return true mApiHadStartMethod");
            return true;
        }
        this.asr = Class.forName("com.kwad.sdk.api.core.IKsAdSDK").getDeclaredMethod(TtmlNode.START, new Class[0]) != null;
        Log.d("KSAdSDK", "enableInitStartMode return mApiHadStartMethod: " + this.asr);
        return this.asr;
    }

    private synchronized boolean Ch() {
        return n.aT(getContext());
    }

    private static boolean aP(Context context) {
        String processName = ay.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    private void Ci() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.YY = jElapsedRealtime;
        com.kwad.sdk.service.c.init();
        j.Be();
        Cu();
        Cv();
        boolean zCg = Cg();
        Log.d("KSAdSDK", "initSDKModule enableInitStartMode: " + zCg);
        if (this.asz == null) {
            this.asz = f.ad(this.asx);
        }
        if (!zCg) {
            this.asz.report();
        }
        Cl();
        Cy();
        Cz();
        CF();
        Cr();
        if (!zCg) {
            Cj();
            e((com.kwad.sdk.g.a) null);
        }
        Cn();
        Cp();
        Cq();
        Cw();
        CD();
        CB();
        com.kwad.sdk.o.l.JL();
        Cm();
        com.kwad.sdk.core.h.a.JL();
        if (!zCg) {
            com.kwad.sdk.a.a.c.CU().CW();
            com.kwad.components.core.p.a.se().sf();
        }
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            try {
                com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
            } catch (Exception unused) {
            }
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.sdk.core.d.c.d("KSAdSDK", "KSAdSDK init time:" + jElapsedRealtime2);
        com.kwad.sdk.core.d.c.i("KSAdSDK", "SDK_VERSION_NAME: 4.6.30.1 TK_VERSION_CODE: 6.1.7 BRIDGE_VERSION: 1.3");
        if (this.asA == null) {
            this.asA = f.ae(jElapsedRealtime2);
        }
        if (!zCg) {
            this.asA.report();
        }
        if (Cf().asy > 0) {
            m.al(SystemClock.elapsedRealtime() - Cf().asy);
        }
        a(ServiceProvider.getSDKConfig());
        this.asp = true;
    }

    private void Cj() {
        com.kwad.sdk.mobileid.a.init(getContext());
    }

    private void Ck() {
        try {
            com.kwad.sdk.commercial.b.a(new b.a() { // from class: com.kwad.sdk.l.6
                @Override // com.kwad.sdk.commercial.b.a
                public final boolean CI() {
                    return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.azh);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean CJ() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.azg);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final JSONObject CK() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.azs);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final void j(String str, String str2, boolean z) {
                    com.kwad.components.core.p.a.se().e(str, str2, false);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final String CL() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBH);
                }
            }, this.asv);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void Cl() {
        try {
            com.kwad.sdk.components.c.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Cm() {
        try {
            com.kwad.components.core.proxy.launchdialog.e.sc().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void Cn() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Co() {
        try {
            com.kwad.components.core.d.a.am(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Cp() {
        try {
            com.kwad.sdk.components.d.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Cq() {
        try {
            com.kwad.components.core.o.b.b.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void a(SdkConfig sdkConfig, final e eVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ksInitCallback.onFail(eVar.code, eVar.msg);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void Cr() {
        ag.aj(ServiceProvider.getContext(), this.asG);
        this.asG = null;
    }

    private static void a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bw.b(new Runnable() { // from class: com.kwad.sdk.l.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (l.Cf().asy > 0) {
                                    m.am(SystemClock.elapsedRealtime() - l.Cf().asy);
                                }
                                ksInitCallback.onSuccess();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(SdkConfig sdkConfig, final e eVar) {
        final KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartFail error: " + eVar.msg);
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.9
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ksInitCallback.onFail(eVar.code, eVar.msg);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void b(SdkConfig sdkConfig) {
        final KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartSuccess");
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bw.b(new Runnable() { // from class: com.kwad.sdk.l.10
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ksInitCallback.onSuccess();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void e(final com.kwad.sdk.g.a aVar) {
        try {
            com.kwad.components.core.request.h.a(new h.b() { // from class: com.kwad.sdk.l.11
                @Override // com.kwad.components.core.request.h.b
                public final void st() {
                    try {
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.h.a
                public final void ss() {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onCacheLoaded()");
                    l.this.Cs();
                }

                @Override // com.kwad.components.core.request.h.a
                public final void d(SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        l.this.e(sdkConfigData);
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        try {
            Map<String, String> jSON2MapString = ab.parseJSON2MapString(com.kwad.sdk.core.config.c.aBk.getValue());
            for (String str : jSON2MapString.keySet()) {
                GlobalThreadPools.q(str, Integer.parseInt((String) requireNonNull(jSON2MapString.get(str))));
            }
            GlobalThreadPools.Jl();
            com.kwad.sdk.core.config.c.aBW.getValue().booleanValue();
            GlobalThreadPools.Jj();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        try {
            Co();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("KSAdSDK", Log.getStackTraceString(th));
        }
        Ck();
        Cx();
        com.kwad.sdk.core.config.e.Bi();
        if ((com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.azf) && ay.isInMainProcess(ServiceProvider.Pp())) || com.kwad.framework.a.a.oz.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.Pp());
        }
        if (com.kwad.sdk.core.config.e.FP()) {
            com.kwad.sdk.b.a.init(com.kwad.sdk.o.m.Ta());
        }
        CC();
        bh.init(getContext());
        com.kwad.components.core.a.a.nX().au();
        com.kwad.sdk.utils.g.a(getContext(), MediaController.RELEASE_UNBIND_TIMEOUT_MS, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.l.12
            @Override // com.kwad.sdk.collector.h
            public final void c(JSONArray jSONArray) {
                com.kwad.components.core.p.a.se().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.HF().a(com.kwad.sdk.core.config.e.FQ(), com.kwad.sdk.core.config.e.FR());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bt.a(com.kwad.sdk.core.config.e.FS(), com.kwad.sdk.core.config.e.FT(), ServiceProvider.getContext());
        CE();
        CA();
        com.kwad.components.core.i.a.qn().at(getContext());
        com.kwad.sdk.crash.online.monitor.a.cS(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aAX));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.n.f.cS(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBf));
        ar.QX().cS(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBh));
        com.kwad.sdk.core.threads.c.cS(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBj));
        com.kwad.sdk.j.a.NJ();
        com.kwad.sdk.o.m.z(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.g.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.l.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return f(jSONObject);
            }

            private static Boolean f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.ea(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBB));
        try {
            com.kwad.components.core.webview.tachikoma.g.uP().init();
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
        Ct();
        try {
            com.kwad.sdk.f.a.a.Mq().init(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBg));
        } catch (Throwable th3) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th3);
        }
    }

    private void Ct() {
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.l.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.components.core.c.a.nZ().ob();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w("KSAdSDK", Log.getStackTraceString(e));
                }
            }
        });
    }

    private static void Cu() {
        try {
            com.kwad.sdk.core.d.c.init(ServiceProvider.getSDKConfig().enableDebug);
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Cv() {
        try {
            com.kwad.sdk.o.f.SS().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Cw() {
        try {
            com.kwad.sdk.core.c.b.Ho().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void Cx() {
        try {
            com.kwad.sdk.core.webview.b.a.KT().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void Cy() {
        try {
            com.kwad.sdk.core.network.idc.a.HF().init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void Cz() {
        try {
            com.kwad.sdk.core.download.a.bv(ServiceProvider.getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void CA() {
        try {
            com.kwad.sdk.core.diskcache.a.bu(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void CB() {
        try {
            com.kwad.components.core.t.n.tn().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void CC() {
        com.kwad.components.core.q.b.sy();
        com.kwad.components.core.q.b.f(com.kwad.sdk.core.config.e.Fe(), com.kwad.sdk.core.config.e.Ff());
    }

    private void CD() {
        try {
            bd.init(getContext());
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private static void CE() {
        try {
            com.kwad.sdk.app.b.Dw().init();
        } catch (Throwable th) {
            n.l(th);
        }
    }

    private void CF() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.l.4
                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aAs);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.e.Fh();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final boolean zV() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aAr);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void f(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.HF().h(str, th);
                    }
                }
            });
        } catch (Throwable th) {
            n.l(th);
        }
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.getSDKConfig().enableDebug;
    }

    public static String getAppId() {
        return ServiceProvider.getSDKConfig().appId;
    }

    public static String getAppName() {
        return ServiceProvider.getSDKConfig().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public final boolean Bn() {
        return this.asp;
    }

    public final boolean CG() {
        if (Cg()) {
            return this.asp && this.asq;
        }
        return this.asp;
    }

    public final KsLoadManager getAdManager() {
        if (this.asw == null) {
            this.asw = new com.kwad.components.core.b();
        }
        return this.asw;
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.GR().bx(getContext());
    }

    public final String getApiVersion() {
        return this.ast;
    }

    public final int getApiVersionCode() {
        return this.asu;
    }

    public final void setApiVersion(String str) {
        this.ast = str;
    }

    public final void setApiVersionCode(int i) {
        this.asu = i;
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.GP().delete();
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class clsG = com.kwad.sdk.service.c.g(cls);
            if (clsG == null) {
                if (obj instanceof BaseProxyActivity) {
                    clsG = com.kwad.components.core.proxy.d.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    clsG = com.kwad.components.core.proxy.e.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + Bk() + "--mIsSdkInit:" + Bn() + "--componentClass" + cls));
            }
            return (T) clsG.newInstance();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.c.h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.II();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.IK().toJson();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.IN().toJson();
    }

    public final void setIsExternal(boolean z) {
        this.asv = z;
    }

    public static String getDid() {
        return bd.getDeviceId();
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public final void setPersonalRecommend(boolean z) {
        this.asD = z;
    }

    public final void setProgrammaticRecommend(boolean z) {
        this.asE = z;
    }

    public final void setAdxEnable(boolean z) {
        this.asF = z;
    }

    public final void setAppTag(String str) {
        if (this.asp) {
            ag.aj(ServiceProvider.getContext(), this.asG);
        } else {
            this.asG = str;
        }
    }

    public final void setLaunchTime(long j) {
        this.asx = j;
        p.setLaunchTime(j);
    }

    public final void setInitStartTime(long j) {
        this.asy = j;
        p.setInitStartTime(System.currentTimeMillis());
    }

    public final long CH() {
        return this.YY;
    }

    public final boolean Bk() {
        return this.asv;
    }

    public static void setThemeMode(int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z, int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z, int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public final boolean Bl() {
        return this.asD;
    }

    public final boolean Bm() {
        return this.asE;
    }

    public static void k(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    public static void e(Map<String, String> map) {
        com.kwad.sdk.core.a.d.g(map);
    }

    public static String ck(String str) {
        return com.kwad.sdk.core.a.d.as(str);
    }

    public static String cl(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }

    public static Object f(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.HF().Y(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.b.g((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.Pp() == null) {
                return null;
            }
            if (ay.isInMainProcess(ServiceProvider.Pp()) && com.kwad.framework.a.a.akX.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.getSDKConfig();
    }
}
