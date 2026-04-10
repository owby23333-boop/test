package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.n;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.j0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.a;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConfig;
import com.bytedance.msdk.api.v2.GMAdConfig;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.IGMLiveTokenInjectionAuth;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static long a;
    private static boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f1739c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Runnable f1740d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static k f1742f;

    static final class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = d.b = true;
            long unused2 = d.a = SystemClock.elapsedRealtime();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(this.a.getApplicationContext());
            g0.a(this.a);
            j0.c();
            q.a(this.a);
            s.a(this.a);
            w.m(this.a);
            h.c().b();
            d.i();
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
                d.e(this.a);
            } else {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().b();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().b();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(true);
            d.f();
            d.l();
            d.g(this.a);
            d.m();
            if (Logger.isDebug()) {
                ThreadHelper.runOnMSDKThread(d.f1740d);
            }
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.a(this.a);
            s.a(this.a);
        }
    }

    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) ThreadHelper.getMSDKExecutor()).getQueue().size());
            ThreadHelper.postDelayOnMSDKThread(d.f1740d, 5000L);
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d$d, reason: collision with other inner class name */
    static final class C0053d implements k.b {
        C0053d() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k.b
        public void a() {
            Logger.d("TTMediationSDK", "--==-- AppStateListener on foreground");
            long unused = d.f1741e = SystemClock.elapsedRealtime();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k.b
        public void b() {
            Logger.d("TTMediationSDK", "--==-- AppStateListener on background");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(SystemClock.elapsedRealtime() - d.f1741e);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1676e = true;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.f1677f = true;
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a();
            } else {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().a();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().a();
            }
        }
    }

    static final class e implements Runnable {
        final /* synthetic */ StackTraceElement[] a;

        e(StackTraceElement[] stackTraceElementArr) {
            this.a = stackTraceElementArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(this.a);
        }
    }

    @Deprecated
    private static void a(TTAdConfig tTAdConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(tTAdConfig.getAppName());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().d(tTAdConfig.isPangleAllowShowNotify());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().e(tTAdConfig.isPangleAllowShowPageWhenScreenLock());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(tTAdConfig.getPangleTitleBarTheme());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getPangleDirectDownloadNetworkType());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getPangleNeedClearTaskReset());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().g(tTAdConfig.isPangleUseTextureView());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f(tTAdConfig.isPanglePaid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f(tTAdConfig.getPublisherDid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().c(tTAdConfig.isOpenAdnTest());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().d(tTAdConfig.getPangleData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getExtraData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getPrivacyConfig());
        o();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getAdapterConfigurationClasses());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().c(tTAdConfig.getMediatedNetworkConfigurations());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().d(tTAdConfig.getRequestOptions());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getUserInfoForSegment(), true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(tTAdConfig.getPanglePluginUpdateConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().e(tTAdConfig.getPangleKeywords());
    }

    @Deprecated
    public static void a(@NonNull TTAdConfig tTAdConfig, Context context) {
        a(null, tTAdConfig, context);
    }

    private static void a(GMAdConfig gMAdConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(gMAdConfig.getAppName());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().d(gMAdConfig.getGMPangleOption().isAllowShowNotify());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().e(gMAdConfig.getGMPangleOption().isAllowShowPageWhenScreenLock());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(gMAdConfig.getGMPangleOption().getTitleBarTheme());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getGMPangleOption().getDirectDownloadNetworkType());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getGMPangleOption().getNeedClearTaskReset());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().g(gMAdConfig.getGMPangleOption().isIsUseTextureView());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f(gMAdConfig.getGMPangleOption().isPaid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().f(gMAdConfig.getPublisherDid());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().c(gMAdConfig.isOpenAdnTest());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().d(gMAdConfig.getGMPangleOption().getData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getGMPangleOption().getExtraData());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getPrivacyConfig());
        o();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getGMConfigUserInfoForSegment(), true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getGMPangleOption().getPluginUpdateConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().e(gMAdConfig.getGMPangleOption().getKeywords());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(gMAdConfig.getLocalExtra());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.isHttps());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b(gMAdConfig.isOpenPangleCustom());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMAdConfig.getCutstomLocalConfig());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().j(gMAdConfig.getGMGdtOption().isWxInstalled());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().c(gMAdConfig.getGMGdtOption().getOpensdkVer());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().h(gMAdConfig.getGMGdtOption().isSupportH265());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().i(gMAdConfig.getGMGdtOption().isSupportSplashZoomout());
        if (gMAdConfig.getGromoreExtra() != null) {
            try {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a((List<String>) gMAdConfig.getGromoreExtra().get(GMAdConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (gMAdConfig.getGMBaiduOption() != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().g(gMAdConfig.getGMBaiduOption().getWxAppId());
        }
        a(gMAdConfig.getGmLiveTokenInjectionAuth());
    }

    public static void a(@NonNull GMAdConfig gMAdConfig, Context context) {
        a(gMAdConfig, null, context);
    }

    private static void a(GMAdConfig gMAdConfig, TTAdConfig tTAdConfig, Context context) {
        d(context);
        if (gMAdConfig != null) {
            a(gMAdConfig);
        } else if (tTAdConfig != null) {
            a(tTAdConfig);
        }
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().q()) {
            f(context);
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().p();
            c(context);
        }
    }

    public static void a(GMPrivacyConfig gMPrivacyConfig) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().a(gMPrivacyConfig);
        o();
    }

    private static void a(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        try {
            Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (mapE == null || mapE.size() <= 0 || (iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName("pangle"))) == null) {
                return;
            }
            iTTAdapterConfiguration.setInjectionAuth(iGMLiveTokenInjectionAuth);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StackTraceElement[] stackTraceElementArr) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            Map<String, String> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().e();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((TTBaseAd) null, (AdSlot) null, u.a(stackTraceElementArr), 1);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(u.a(mapE));
        }
    }

    private static void c(Context context) {
        Logger.e("TTMediationSDK_SDK_Init", "msdk_init v2.............");
        ThreadHelper.runOnThreadPool(new a(context));
    }

    public static void d(Context context) {
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        int i2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(new a.b().a(new l()).a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a.a(i2, i2, bj.f12907e)).a(false).a(new m()).a(n.b).a(), context);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.c();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a(0);
    }

    private static void f(Context context) {
        Logger.e("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        b = true;
        a = SystemClock.elapsedRealtime();
        g0.a(context);
        j0.c();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(context.getApplicationContext());
        ThreadHelper.runOnThreadPool(new b(context));
        w.m(context);
        h.c().b();
        i();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a()) {
            e(context);
        } else {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().b();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().b();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(true);
        f();
        l();
        g(context);
        m();
        if (Logger.isDebug()) {
            ThreadHelper.runOnMSDKThread(f1740d);
        }
    }

    public static String g() {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        try {
            Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (mapE != null && mapE.size() > 0 && (iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName("pangle"))) != null) {
                return iTTAdapterConfiguration.getNetworkSdkPluginVersion();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.d()) {
            Logger.d("TMe", "-----==---- 正常上报sdk_init");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(-1L);
        } else {
            Logger.d("TMe", "-----==---- 延时上报sdk_init");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.e();
        }
        if (c0.c(context)) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a();
        }
    }

    public static long h() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(true);
        } catch (Throwable th) {
            Logger.e("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    public static void j() {
        Context contextD;
        if (f1739c.get()) {
            return;
        }
        Logger.i("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H());
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().H() || (contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) == null) {
            return;
        }
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().a(contextD, true, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a(contextD));
        } catch (Exception unused) {
        }
        f1739c.set(true);
    }

    public static boolean k() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        Application applicationA = a.b.a();
        if (applicationA == null) {
            Logger.d("TTMediationSDK", "AppStateListener注册失败, app = null");
            return;
        }
        Logger.d("TTMediationSDK", "AppStateListener注册成功");
        k kVar = f1742f;
        if (kVar != null) {
            kVar.a(applicationA);
        }
        f1742f = new k();
        f1742f.a(applicationA, new C0053d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().x()) {
            b(stackTrace);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new e(stackTrace), com.anythink.expressad.exoplayer.i.a.f9492f);
        }
    }

    public static void n() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(1);
        if (!f1739c.get()) {
            j();
        }
        Context contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (contextD == null) {
            return;
        }
        try {
            Logger.i("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().a(contextD, false);
        } catch (Exception unused) {
        }
    }

    private static void o() {
        ITTAdapterConfiguration value;
        try {
            Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (mapE == null || mapE.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ITTAdapterConfiguration> entry : mapE.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.setPrivacyConfig(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s());
                }
            }
        } catch (Throwable unused) {
        }
    }
}
