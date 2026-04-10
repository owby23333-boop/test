package com.amgcyo.cuttadon.sdk.gm.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.h.d.e.l;
import com.amgcyo.cuttadon.h.d.e.m;
import com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import java.lang.ref.SoftReference;
import me.jessyan.art.d.d;
import me.jessyan.art.d.f;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class GmSplashActivity extends MyBaseAdActivity {
    private boolean A0 = false;
    private boolean B0 = false;
    private boolean C0 = false;
    private boolean D0 = false;
    GMSplashAdListener E0 = new b();

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private GMSplashAd f4161y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private boolean f4162z0;

    class a implements GMSplashAdLoadCallback {

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.sdk.gm.ui.GmSplashActivity$a$a, reason: collision with other inner class name */
        class C0110a implements l.a {
            C0110a() {
            }

            @Override // com.amgcyo.cuttadon.h.d.e.l.a
            public void a() {
            }

            @Override // com.amgcyo.cuttadon.h.d.e.l.a
            public void onSplashCardClick() {
            }

            @Override // com.amgcyo.cuttadon.h.d.e.l.a
            public void onSplashCardClose() {
                GmSplashActivity.this.goToMainActivity();
            }

            @Override // com.amgcyo.cuttadon.h.d.e.l.a
            public void onSplashClickEyeClick() {
            }
        }

        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onAdLoadTimeout() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadFail(@NotNull AdError adError) {
            String str = "load splash ad error : " + adError.code + ", " + adError.message;
            GmSplashActivity.this.r();
            if (GmSplashActivity.this.f4161y0 != null) {
                String str2 = "ad load infos: " + GmSplashActivity.this.f4161y0.getAdLoadInfoList().toString();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadSuccess() {
            if (GmSplashActivity.this.f4161y0 != null) {
                l lVarC = l.c();
                GmSplashActivity gmSplashActivity = GmSplashActivity.this;
                lVarC.a(gmSplashActivity, gmSplashActivity.f4161y0, ((MyBaseAdActivity) GmSplashActivity.this).mSplashContainer, new C0110a());
                GmSplashActivity.this.f4161y0.showAd(((MyBaseAdActivity) GmSplashActivity.this).mSplashContainer);
                GmSplashActivity gmSplashActivity2 = GmSplashActivity.this;
                gmSplashActivity2.a(gmSplashActivity2.f4161y0, ((MyBaseAdActivity) GmSplashActivity.this).mSplashContainer);
                GmSplashActivity gmSplashActivity3 = GmSplashActivity.this;
                gmSplashActivity3.A0 = gmSplashActivity3.f4161y0.getAdNetworkPlatformId() == 6;
                Logger.e("gm", "adNetworkPlatformId: " + GmSplashActivity.this.f4161y0.getAdNetworkPlatformId() + "   adNetworkRitId：" + GmSplashActivity.this.f4161y0.getAdNetworkRitId() + "   preEcpm: " + GmSplashActivity.this.f4161y0.getPreEcpm());
                StringBuilder sb = new StringBuilder();
                sb.append("ad load infos: ");
                sb.append(GmSplashActivity.this.f4161y0.getAdLoadInfoList());
                sb.toString();
            }
        }
    }

    class b implements GMSplashAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdClicked() {
            GmSplashActivity.this.B0 = true;
            GmSplashActivity.this.e("开屏广告被点击");
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdDismiss() {
            GmSplashActivity.this.e("开屏广告倒计时结束关闭");
            if (GmSplashActivity.this.A0 && GmSplashActivity.this.C0 && GmSplashActivity.this.B0) {
                return;
            }
            GmSplashActivity.this.goToMainActivity();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShow() {
            GmSplashActivity.this.e("开屏广告展示");
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShowFail(@NotNull AdError adError) {
            GmSplashActivity.this.e("开屏广告展示失败");
            GmSplashActivity.this.r();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdSkip() {
            GmSplashActivity.this.e("开屏广告点击跳过按钮");
            GmSplashActivity.this.goToMainActivity();
        }
    }

    public class c implements GMSplashMinWindowListener {
        private SoftReference<Activity> a;
        private GMSplashAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private View f4163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4164d;

        class a implements m.c {
            a() {
            }

            @Override // com.amgcyo.cuttadon.h.d.e.m.c
            public void a() {
                if (c.this.b != null) {
                    c.this.b.splashMinWindowAnimationFinish();
                }
            }

            @Override // com.amgcyo.cuttadon.h.d.e.m.c
            public void a(int i2) {
            }
        }

        c(Activity activity, GMSplashAd gMSplashAd, View view, boolean z2) {
            this.a = new SoftReference<>(activity);
            this.b = gMSplashAd;
            this.f4163c = view;
            this.f4164d = z2;
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener
        public void onMinWindowPlayFinish() {
            if (this.f4164d) {
                m.c().a();
                GmSplashActivity.this.goToMainActivity();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener
        public void onMinWindowStart() {
            m.c().a(true);
            if (this.f4164d) {
                a();
            } else {
                GmSplashActivity.this.goToMainActivity();
            }
        }

        private void a() {
            if (this.a.get() == null || this.b == null || this.f4163c == null) {
                return;
            }
            m mVarC = m.c();
            ViewGroup viewGroup = (ViewGroup) this.a.get().findViewById(R.id.content);
            mVarC.a(this.b, this.f4163c, viewGroup, viewGroup, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMainActivity() {
        FrameLayout frameLayout;
        if (l.c().a()) {
            return;
        }
        if (this.D0 && m.c().b()) {
            return;
        }
        if (this.f4161y0 != null && (frameLayout = this.mSplashContainer) != null && frameLayout.getChildCount() > 0) {
            m.c().a(this.f4161y0, this.mSplashContainer.getChildAt(0), getWindow().getDecorView());
        }
        startActivity(new Intent(getApplicationContext(), (Class<?>) MkMainActivity.class));
        overridePendingTransition(0, 0);
        FrameLayout frameLayout2 = this.mSplashContainer;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
        }
        d.e().a(SdkSplashActivity.class);
        finish();
    }

    public static void launch(Context context, String str, String str2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) GmSplashActivity.class);
        Bundle bundle = new Bundle();
        g.j(0);
        bundle.putBoolean("needStartMainActivity", z2);
        bundle.putString("pos_id", str2);
        bundle.putString("platform", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        m.c().a(false);
        this.f4161y0 = new GMSplashAd(this, this.f4255o0);
        this.f4161y0.setAdSplashListener(this.E0);
        this.f4161y0.loadAd(new GMAdSlotSplash.Builder().setImageAdSize(this.f4260t0, this.f4261u0 - this.f4262v0).setSplashPreLoad(true).setMuted(false).setVolume(1.0f).setTimeOut(3000).setSplashButtonType(1).setDownloadType(1).setSplashShakeButton(true).build(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (g.a(this.f4259s0)) {
            goToMainActivity();
            return;
        }
        f.a().a("gm", "tag_gromore_fail");
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (TextUtils.isEmpty(this.f4256p0) || this.mSplashContainer == null || TextUtils.isEmpty(this.f4255o0)) {
            goToMainActivity();
        } else {
            this.mSplashContainer.post(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.gm.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4168s.q();
                }
            });
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = this.mSplashContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        GMSplashAd gMSplashAd = this.f4161y0;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.C0 = true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        if (this.f4162z0) {
            goToMainActivity();
        }
        if (this.A0 && this.C0 && this.B0) {
            goToMainActivity();
        }
        super.onResume();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f4162z0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GMSplashAd gMSplashAd, ViewGroup viewGroup) {
        if (gMSplashAd == null || viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        gMSplashAd.setMinWindowListener(new c(this, gMSplashAd, viewGroup.getChildAt(0), this.D0));
    }
}
