package com.amgcyo.cuttadon.sdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SdkFullVideoActivity extends MyBaseAdActivity implements com.amgcyo.cuttadon.h.f.b {
    private KsFullScreenVideoAd A0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected TTAdNative f4301y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected TTFullScreenVideoAd f4302z0;

    class a implements TTAdNative.FullScreenVideoAdListener {

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.sdk.ui.SdkFullVideoActivity$a$a, reason: collision with other inner class name */
        class C0111a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
            C0111a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                SdkFullVideoActivity.this.p();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                SdkFullVideoActivity.this.n();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
            }
        }

        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            String str2 = "csj FullVideoAd加载错误，错误码" + i2 + " 错误信息：" + str;
            if (i2 < 40004 || i2 > 40042) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(false);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(true);
            }
            com.amgcyo.cuttadon.h.h.c.a("csj_new", "csj full video code:" + i2);
            SdkFullVideoActivity.this.f("csj_new");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            SdkFullVideoActivity sdkFullVideoActivity = SdkFullVideoActivity.this;
            sdkFullVideoActivity.f4302z0 = tTFullScreenVideoAd;
            sdkFullVideoActivity.o();
            SdkFullVideoActivity.this.f4302z0.setFullScreenVideoAdInteractionListener(new C0111a());
            SdkFullVideoActivity sdkFullVideoActivity2 = SdkFullVideoActivity.this;
            TTFullScreenVideoAd tTFullScreenVideoAd2 = sdkFullVideoActivity2.f4302z0;
            if (tTFullScreenVideoAd2 != null) {
                tTFullScreenVideoAd2.showFullScreenVideoAd(sdkFullVideoActivity2);
                SdkFullVideoActivity.this.f4302z0 = null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            SdkFullVideoActivity.this.o();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            SdkFullVideoActivity.this.o();
        }
    }

    class b implements KsLoadManager.FullScreenVideoAdListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i2, String str) {
            System.out.println("ks onError,code:" + i2 + str);
            SdkFullVideoActivity.this.f("ks");
            com.amgcyo.cuttadon.h.h.c.a("ks", "ks full video code:" + i2);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            if (list == null || list.size() <= 0) {
                SdkFullVideoActivity.this.p();
            } else {
                SdkFullVideoActivity.this.A0 = list.get(0);
                SdkFullVideoActivity.this.u();
            }
            SdkFullVideoActivity.this.o();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                return;
            }
            String str = "ks全屏视频广告请求填充个数 " + list.size();
        }
    }

    class c implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            SdkFullVideoActivity.this.n();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            SdkFullVideoActivity.this.p();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            System.out.println("ks onVideoPlayError");
            SdkFullVideoActivity.this.p();
            com.amgcyo.cuttadon.h.h.c.a("ks", "ks onVideoPlayError code:" + i2);
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.ui.SdkFullVideoActivity.e(java.lang.String):void");
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
                if (2 == baseAd2.getStyle()) {
                    baseAd = baseAd2;
                    break;
                }
            }
        }
        if (baseAd == null) {
            p();
            return;
        }
        String platform = baseAd.getPlatform();
        String str4 = "下一个广告平台:" + platform;
        if (this.f4254n0) {
            this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, com.anythink.core.c.e.a);
            if ("csj_new".equals(platform)) {
                this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "l");
            }
        } else {
            this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "f");
            if ("csj_new".equals(platform)) {
                this.f4255o0 = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "m");
            }
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
        Intent intent = new Intent(context, (Class<?>) SdkFullVideoActivity.class);
        Bundle bundle = new Bundle();
        com.amgcyo.cuttadon.utils.otherutils.g.j(0);
        bundle.putBoolean("needStartMainActivity", z2);
        bundle.putString("pos_id", str2);
        bundle.putString("platform", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void q() {
        View viewInflate;
        if (this.mSplashContainer == null || (viewInflate = getLayoutInflater().inflate(R.layout.mk_ac_launcher, (ViewGroup) null)) == null) {
            return;
        }
        viewInflate.findViewById(R.id.rl_root).setVisibility(0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_msg);
        textView.setText("^_^正在努力加载中^_^");
        ProgressWheel progressWheel = (ProgressWheel) viewInflate.findViewById(R.id.progresswheel);
        com.amgcyo.cuttadon.f.o.a(textView, com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), 0, 0, 0);
        com.amgcyo.cuttadon.f.o.a(progressWheel, 0, 0, 0, 0);
        this.mSplashContainer.addView(viewInflate, new FrameLayout.LayoutParams(-1, -1));
    }

    private void r() {
        TTAdManager tTAdManager = MkApplication.getTTAdManager();
        StringBuilder sb = new StringBuilder();
        sb.append("posId: ");
        sb.append(this.f4255o0);
        sb.append(" ttAdManager: ");
        sb.append(tTAdManager != null);
        sb.toString();
        if (tTAdManager == null || TextUtils.isEmpty(this.f4255o0)) {
            p();
            return;
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.r()) {
            boolean zP0 = com.amgcyo.cuttadon.utils.otherutils.g.p0();
            String str = "forceRequestPermission:" + zP0;
            if (zP0) {
                tTAdManager.requestPermissionIfNecessary(this);
                com.amgcyo.cuttadon.utils.otherutils.g.h(true);
            }
        }
        this.f4301y0 = tTAdManager.createAdNative(this);
        s();
    }

    private void s() {
        this.f4301y0.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f4255o0).setSupportDeepLink(true).setExpressViewAcceptedSize(500.0f, 500.0f).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setOrientation(1).build(), new a());
    }

    private void t() {
        com.amgcyo.cuttadon.h.c.d.a(a(), this.f4255o0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.A0;
        if (ksFullScreenVideoAd == null || !ksFullScreenVideoAd.isAdEnable()) {
            p();
        } else {
            this.A0.setFullScreenVideoAdInteractionListener(new c());
            this.A0.showFullScreenVideoAd(this, null);
        }
    }

    @Override // com.amgcyo.cuttadon.h.f.b
    public void AdError(long j2, String str, String str2) {
        if (2003 == j2 || 4001 == j2 || 4003 == j2 || -101 == j2) {
            g0.a().b("ylh_init_error", true);
        } else {
            g0.a().b("ylh_init_error", false);
        }
        com.amgcyo.cuttadon.h.h.c.a(str2, str2 + "  full video code:" + j2);
        f(str2);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.h.f.b
    public void goToMainActivity() {
        p();
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (getIntent() == null) {
            p();
        } else if (TextUtils.isEmpty(this.f4256p0)) {
            p();
        } else {
            e(this.f4256p0);
        }
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    public void loadKsSplashAd() {
        this.A0 = null;
        KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(this.f4255o0).longValue()).screenOrientation(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null || ksSceneBuild == null) {
            p();
        } else {
            loadManager.loadFullScreenVideoAd(ksSceneBuild, new b());
        }
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4301y0 = null;
        this.f4302z0 = null;
        this.A0 = null;
    }
}
