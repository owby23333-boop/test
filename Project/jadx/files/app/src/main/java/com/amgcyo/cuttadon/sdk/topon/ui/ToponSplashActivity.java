package com.amgcyo.cuttadon.sdk.topon.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.h.i.g.c;
import com.amgcyo.cuttadon.h.i.h.e;
import com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashExListener;
import com.sntech.ads.api.event.SNEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.d.f;

/* JADX INFO: loaded from: classes.dex */
public class ToponSplashActivity extends MyBaseAdActivity implements ATSplashExListener {
    boolean B0;
    boolean C0;
    boolean D0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private ATSplashAd f4250y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private Handler f4251z0 = new Handler(Looper.getMainLooper());
    boolean A0 = false;

    public static void launch(Context context, String str, String str2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) ToponSplashActivity.class);
        Bundle bundle = new Bundle();
        g.j(0);
        bundle.putBoolean("needStartMainActivity", z2);
        bundle.putString("pos_id", str2);
        bundle.putString("platform", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f4250y0 = new ATSplashAd(this, this.f4255o0, this, 5000, "");
        HashMap map = new HashMap();
        ViewGroup.LayoutParams layoutParams = this.mSplashContainer.getLayoutParams();
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(i2));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(i3));
        g0 g0VarA = g0.a();
        g0VarA.b("topon_splash_sizekey_width", i2);
        g0VarA.b("topon_splash_sizekey_height", i3);
        String str = "width: " + i2 + " height: " + i3;
        this.f4250y0.setLocalExtra(map);
        ATSplashAd.entryAdScenario(this.f4255o0, null);
        this.f4250y0.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("开屏", "ToponSplashActivity"));
        if (this.f4250y0.isAdReady()) {
            this.f4251z0.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.topon.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4253s.q();
                }
            }, 10L);
        } else {
            this.f4250y0.loadAd();
        }
    }

    private void s() {
        if (g.a(this.f4259s0)) {
            jumpToMainActivity();
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
            jumpToMainActivity();
            return;
        }
        g0 g0VarA = g0.a();
        g0VarA.b("topon_inter_ad_4_key", false);
        g0VarA.b("topon_splash_ad_1_key", false);
        List<BaseAd> listX0 = h.x0();
        if (g.b(listX0)) {
            Iterator<BaseAd> it = listX0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseAd next = it.next();
                String str = "style：" + next.getStyle();
                if (2 == next.getStyle()) {
                    g0VarA.b("topon_inter_ad_4_key", true);
                    break;
                }
            }
        }
        String str2 = "topon是否需要初始化插屏全屏：\n" + g0VarA.a("topon_inter_ad_4_key", false) + " 和激励视频：" + g0VarA.a("topon_reward_ad_5_key", false);
        this.mSplashContainer.post(new Runnable() { // from class: com.amgcyo.cuttadon.sdk.topon.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f4252s.r();
            }
        });
    }

    public void jumpToMainActivity() {
        boolean z2 = this.f4254n0;
        if (!this.f4254n0) {
            finish();
            return;
        }
        if (!this.B0) {
            this.B0 = true;
            return;
        }
        if (this.A0) {
            return;
        }
        this.A0 = true;
        if (com.amgcyo.cuttadon.h.i.h.a.a != null && this.mSplashContainer != null) {
            try {
                e.a(getApplicationContext()).a(this.mSplashContainer.getChildAt(0), getWindow().getDecorView());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            startActivity(new Intent(this, (Class<?>) MkMainActivity.class));
            overridePendingTransition(0, 0);
        }
        finish();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdClick(ATAdInfo aTAdInfo) {
        String str = "onAdClick:\n" + aTAdInfo.toString();
        com.amgcyo.cuttadon.h.j.a.c(aTAdInfo);
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
        String str = "onAdDismiss type:" + aTSplashAdExtraInfo.getDismissType();
        com.amgcyo.cuttadon.h.i.h.a.a = aTSplashAdExtraInfo.getAtSplashEyeAd();
        jumpToMainActivity();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdLoadTimeout() {
        o.g("加载开屏广告超时！");
        s();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdLoaded(boolean z2) {
        FrameLayout frameLayout;
        String str = "onAdLoaded---------isTimeout:" + z2;
        if (!this.C0) {
            this.D0 = true;
            return;
        }
        ATSplashAd aTSplashAd = this.f4250y0;
        if (aTSplashAd == null || !aTSplashAd.isAdReady() || (frameLayout = this.mSplashContainer) == null) {
            jumpToMainActivity();
        } else {
            this.f4250y0.show(this, frameLayout);
        }
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onAdShow(ATAdInfo aTAdInfo) {
        String str = "onAdShow:\n" + aTAdInfo.toString();
        com.amgcyo.cuttadon.h.j.a.d(aTAdInfo);
        com.amgcyo.cuttadon.h.j.a.a(SNEvent.AdType.SPLASH, aTAdInfo);
        o.g("广告显示成功！");
        if (this.mSplashContainer == null || TextUtils.isEmpty(this.f4255o0)) {
            return;
        }
        c.a().a(this, this.f4255o0);
    }

    @Override // com.anythink.splashad.api.ATSplashExListener
    public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z2) {
        String str = "onDeeplinkCallback:" + aTAdInfo.toString() + "--status:" + z2;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ATSplashAd aTSplashAd = this.f4250y0;
        if (aTSplashAd != null) {
            aTSplashAd.setAdListener(null);
            this.f4250y0.setAdDownloadListener(null);
            this.f4250y0.setAdSourceStatusListener(null);
        }
    }

    @Override // com.anythink.splashad.api.ATSplashExListener
    public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        String str = "onDeeplinkCallback:" + aTAdInfo.toString();
    }

    @Override // com.anythink.splashad.api.ATSplashAdListener
    public void onNoAdError(AdError adError) {
        String str = "onNoAdError---------:" + adError.getFullErrorInfo();
        o.g("没有广告返回：" + adError.getFullErrorInfo());
        s();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.C0 = false;
        this.B0 = false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        FrameLayout frameLayout;
        super.onResume();
        this.C0 = true;
        if (this.B0) {
            jumpToMainActivity();
        }
        this.B0 = true;
        if (this.D0) {
            this.D0 = false;
            ATSplashAd aTSplashAd = this.f4250y0;
            if (aTSplashAd == null || !aTSplashAd.isAdReady() || (frameLayout = this.mSplashContainer) == null) {
                return;
            }
            this.f4250y0.show(this, frameLayout);
        }
    }

    public /* synthetic */ void q() {
        this.f4250y0.show(this, this.mSplashContainer);
    }
}
