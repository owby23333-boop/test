package com.amgcyo.cuttadon.sdk.gm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.h.d.e.k;
import com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import me.jessyan.art.d.d;
import me.jessyan.art.d.f;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class GmWakeupActivity extends MyBaseAdActivity {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private k f4166y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private GMSplashAdListener f4167z0;

    class a implements GMSplashAdListener {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdClicked() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdDismiss() {
            GmWakeupActivity.this.q();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShow() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShowFail(@NotNull AdError adError) {
            GmWakeupActivity.this.r();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdSkip() {
            GmWakeupActivity.this.q();
        }
    }

    class b implements GMSplashAdLoadCallback {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onAdLoadTimeout() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadFail(@NotNull AdError adError) {
            String str = adError.message;
            String str2 = "load splash ad error : " + adError.code + ", " + adError.message;
            if (GmWakeupActivity.this.f4166y0.b() != null) {
                String str3 = "ad load infos: " + GmWakeupActivity.this.f4166y0.b().getAdLoadInfoList();
            }
            GmWakeupActivity.this.r();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadSuccess() {
            GmWakeupActivity.this.f4166y0.c();
            GmWakeupActivity.this.f4166y0.b().showAd(((MyBaseAdActivity) GmWakeupActivity.this).mSplashContainer);
        }
    }

    public static void launch(Context context, String str, String str2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) GmWakeupActivity.class);
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
        FrameLayout frameLayout = this.mSplashContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        d.e().a(SdkSplashActivity.class);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (g.a(this.f4259s0)) {
            q();
            return;
        }
        f.a().a("gm", "tag_gromore_fail");
        finish();
        overridePendingTransition(0, 0);
    }

    public void initAdLoader() {
        this.f4166y0 = new k(this, false, new b(), this.f4167z0);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (TextUtils.isEmpty(this.f4256p0) || this.mSplashContainer == null || TextUtils.isEmpty(this.f4255o0)) {
            q();
            return;
        }
        String str = this.f4260t0 + " " + this.f4261u0 + " " + this.f4264x0 + " " + this.f4263w0;
        initListener();
        initAdLoader();
        k kVar = this.f4166y0;
        if (kVar != null) {
            kVar.a(this.f4255o0, this.f4260t0, this.f4261u0 - this.f4262v0);
        }
    }

    public void initListener() {
        this.f4167z0 = new a();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k kVar = this.f4166y0;
        if (kVar != null) {
            kVar.a();
        }
    }
}
