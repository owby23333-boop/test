package com.kwad.components.ad.splashscreen.b;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {
    private KsLogoView mLogoView;

    private void h(ViewGroup viewGroup) {
        if (this.Cx.BR != 0) {
            return;
        }
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        double d2 = displayMetrics.heightPixels;
        double d3 = displayMetrics.widthPixels;
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d2 / d3 > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.ar();
        this.mLogoView = (KsLogoView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_logo_container);
        h(this.mLogoView);
        if (this.Cx.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.Cx.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.mLogoView.setVisibility(8);
        } else {
            this.mLogoView.setVisibility(0);
            this.mLogoView.U(this.Cx.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
