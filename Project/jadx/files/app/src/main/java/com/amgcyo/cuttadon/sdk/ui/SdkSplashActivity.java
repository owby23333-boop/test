package com.amgcyo.cuttadon.sdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.h.b.e;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.Iterator;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class SdkSplashActivity extends MyBaseAdActivity implements e.a {
    private boolean B0;
    private boolean C0;
    private boolean D0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private TTAdNative f4303y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f4304z0;
    private final com.amgcyo.cuttadon.h.b.e A0 = new com.amgcyo.cuttadon.h.b.e(this);
    private boolean E0 = false;

    class a implements SplashADListener {
        a() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            SdkSplashActivity.this.n();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            SdkSplashActivity.this.t();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j2) {
            SdkSplashActivity.this.o();
            long jElapsedRealtime = (j2 - SystemClock.elapsedRealtime()) / 1000;
            long j3 = jElapsedRealtime / 60;
            String str = "gdt 加载成功,广告将在:" + j3 + "分" + (jElapsedRealtime - (60 * j3)) + "秒后过期，请在此之前展示";
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j2) {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            SdkSplashActivity.this.f("gdt_new");
            int errorCode = adError.getErrorCode();
            String errorMsg = adError.getErrorMsg();
            String str = "gdt闪屏图片广告加载失败,错误码：" + errorCode + " 错误详情：" + errorMsg;
            if (2003 == errorCode || 4001 == errorCode || 4003 == errorCode) {
                System.out.println("ylh set data true");
                g0.a().b("ylh_init_error", true);
            }
            System.out.println("ylh loaded data failed, error code:" + errorCode + " error msg:" + errorMsg);
            StringBuilder sb = new StringBuilder();
            sb.append("ylh loaded data failed, error code:");
            sb.append(errorCode);
            com.amgcyo.cuttadon.h.h.c.a("gdt_new", sb.toString());
        }
    }

    class b implements TTAdNative.SplashAdListener {

        class a implements TTSplashAd.AdInteractionListener {
            a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdClicked(View view, int i2) {
                SdkSplashActivity.this.n();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdSkip() {
                SdkSplashActivity.this.p();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
            public void onAdTimeOver() {
                SdkSplashActivity.this.p();
            }
        }

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity$b$b, reason: collision with other inner class name */
        class C0112b implements TTAppDownloadListener {
            boolean a = false;

            C0112b() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (this.a) {
                    return;
                }
                SdkSplashActivity.this.showMessage("下载中...");
                this.a = true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                SdkSplashActivity.this.showMessage("下载失败...");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                SdkSplashActivity.this.showMessage("下载暂停...");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
            }
        }

        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        @MainThread
        public void onError(int i2, String str) {
            String str2 = "错误码：" + i2 + " " + str;
            SdkSplashActivity.this.B0 = true;
            if (i2 < 40004 || i2 > 40042) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(false);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(true);
            }
            System.out.println("bytedance loaded data failed, error code:" + i2 + " error msg:" + str);
            SdkSplashActivity.this.f("csj_new");
            StringBuilder sb = new StringBuilder();
            sb.append("bytedance loaded data failed, error code:");
            sb.append(i2);
            com.amgcyo.cuttadon.h.h.c.a("csj_new", sb.toString());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            FrameLayout frameLayout;
            SdkSplashActivity.this.o();
            SdkSplashActivity.this.B0 = true;
            SdkSplashActivity.this.A0.removeCallbacksAndMessages(null);
            if (tTSplashAd == null) {
                return;
            }
            View splashView = tTSplashAd.getSplashView();
            if (splashView == null || (frameLayout = SdkSplashActivity.this.mSplashContainer) == null) {
                SdkSplashActivity.this.p();
            } else {
                frameLayout.removeAllViews();
                SdkSplashActivity.this.mSplashContainer.addView(splashView);
            }
            tTSplashAd.setSplashInteractionListener(new a());
            if (tTSplashAd.getInteractionType() == 4) {
                tTSplashAd.setDownloadListener(new C0112b());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            SdkSplashActivity.this.B0 = true;
            System.out.println("bytedance loaded data timeout");
            com.amgcyo.cuttadon.h.h.c.a("csj_new", "bytedance loaded data timeout");
            SdkSplashActivity.this.f("csj_new");
        }
    }

    class c implements KsLoadManager.SplashScreenAdListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i2, String str) {
            String str2 = "ks开屏广告请求失败：" + i2 + " : " + str;
            SdkSplashActivity.this.f("ks");
            System.out.println("ks loaded data failed, error code:" + i2 + " error msg:" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("ks loaded data failed, error code:");
            sb.append(i2);
            com.amgcyo.cuttadon.h.h.c.a("ks", sb.toString());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i2) {
            String str = "开屏广告广告填充个数：" + i2;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            SdkSplashActivity.this.o();
            if (ksSplashScreenAd != null) {
                SdkSplashActivity.this.a(ksSplashScreenAd);
            } else {
                SdkSplashActivity.this.p();
            }
        }
    }

    class d implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        d() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            SdkSplashActivity.this.n();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            SdkSplashActivity.this.p();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i2, String str) {
            String str2 = "ks onAdShowError " + i2 + " extra " + str;
            SdkSplashActivity.this.p();
            com.amgcyo.cuttadon.h.h.c.a("ks", "ks onAdShowError " + i2);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            SdkSplashActivity.this.p();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity.e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        String str2 = "当前错误平台：" + str;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f4259s0)) {
            p();
            return;
        }
        String str3 = "移除之前ad_unlockAdList:" + this.f4259s0.size();
        BaseAd baseAd = null;
        Iterator<BaseAd> it = this.f4259s0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BaseAd next = it.next();
            if (next instanceof BaseAd) {
                BaseAd baseAd2 = next;
                if (1 == baseAd2.getStyle()) {
                    baseAd = baseAd2;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("nextProtectBean");
        sb.append(baseAd != null);
        sb.toString();
        if (baseAd == null) {
            p();
            return;
        }
        String platform = baseAd.getPlatform();
        String str4 = "下一个广告平台:" + platform;
        if (this.f4254n0) {
            this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "b");
            String str5 = "posId:" + this.f4255o0;
        } else {
            this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "c");
            String str6 = "posId:" + this.f4255o0;
        }
        Iterator<BaseAd> it2 = this.f4259s0.iterator();
        if (it2.hasNext()) {
            try {
                it2.next();
                it2.remove();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f4259s0.clear();
            }
        }
        e(platform);
    }

    public static void launch(Context context, String str, String str2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) SdkSplashActivity.class);
        Bundle bundle = new Bundle();
        com.amgcyo.cuttadon.utils.otherutils.g.j(0);
        bundle.putBoolean("needStartMainActivity", z2);
        bundle.putString("pos_id", str2);
        bundle.putString("platform", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void loadKsSplashAd() {
        KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(this.f4255o0).longValue()).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null || ksSceneBuild == null) {
            p();
        } else {
            loadManager.loadSplashScreenAd(ksSceneBuild, new c());
        }
    }

    private void q() {
        TTAdManager tTAdManager = MkApplication.getTTAdManager();
        StringBuilder sb = new StringBuilder();
        sb.append("ttAdManager: ");
        sb.append(tTAdManager != null);
        sb.append(" posId：");
        sb.append(this.f4255o0);
        sb.toString();
        if (tTAdManager == null || TextUtils.isEmpty(this.f4255o0)) {
            p();
            return;
        }
        this.f4303y0 = tTAdManager.createAdNative(this);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.r()) {
            boolean zP0 = com.amgcyo.cuttadon.utils.otherutils.g.p0();
            String str = "forceRequestPermission:" + zP0;
            if (zP0) {
                tTAdManager.requestPermissionIfNecessary(this);
                com.amgcyo.cuttadon.utils.otherutils.g.h(true);
            }
        }
        r();
        this.A0.sendEmptyMessageDelayed(1, 5500L);
    }

    private void r() {
        String str = this.f4260t0 + " " + this.f4261u0 + " " + this.f4264x0 + " " + this.f4263w0;
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(this.f4255o0).setSupportDeepLink(true).setAdLoadType(TTAdLoadType.LOAD).setExpressViewAcceptedSize(this.f4264x0, this.f4263w0).setImageAcceptedSize(this.f4260t0, this.f4261u0 - this.f4262v0).build();
        StringBuilder sb = new StringBuilder();
        sb.append("mSplashContainer:");
        sb.append(this.mSplashContainer != null);
        sb.toString();
        this.f4303y0.loadSplashAd(adSlotBuild, new b(), 5000);
    }

    private void s() {
        if (TextUtils.isEmpty(this.f4255o0)) {
            p();
        } else {
            new SplashAD(this, this.f4255o0, new a(), 5000).fetchAndShowIn(this.mSplashContainer);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_gromore_fail")
    private void subscribersaveBookChapter(String str) {
        if (TextUtils.isEmpty(str) || com.amgcyo.cuttadon.utils.otherutils.g.a(this.f4259s0)) {
            p();
            return;
        }
        String str2 = this.f4254n0 + " 原来大小：" + this.f4259s0.size();
        Iterator<BaseAd> it = this.f4259s0.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getPlatform())) {
                it.remove();
            }
        }
        String str3 = "移除后大小：" + this.f4259s0.size();
        this.f4304z0 = false;
        f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.E0) {
            p();
        } else {
            this.E0 = true;
        }
    }

    @Override // com.amgcyo.cuttadon.h.b.e.a
    public void handleMsg(Message message) {
        if (message.what != 1 || this.B0) {
            return;
        }
        p();
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (TextUtils.isEmpty(this.f4256p0)) {
            p();
        } else {
            e(this.f4256p0);
        }
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.E0 = false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f4304z0) {
            this.A0.removeCallbacksAndMessages(null);
            p();
        }
        if (this.E0) {
            t();
        }
        this.E0 = true;
        if (this.C0 && this.D0) {
            p();
        }
        this.D0 = false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f4304z0 = true;
        this.D0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsSplashScreenAd ksSplashScreenAd) {
        View view = ksSplashScreenAd.getView(this, new d());
        if (!isFinishing() && view != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.splash_container);
            viewGroup.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(view);
            return;
        }
        p();
    }
}
