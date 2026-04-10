package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends d {
    public KSFrameLayout zX;

    protected void a(FrameLayout frameLayout) {
    }

    protected abstract int iX();

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        KSFrameLayout kSFrameLayout = this.zX;
        if (kSFrameLayout != null) {
            return kSFrameLayout;
        }
        KSFrameLayout kSFrameLayout2 = (KSFrameLayout) findViewById(iX());
        this.zX = kSFrameLayout2;
        if (kSFrameLayout2 == null) {
            KSFrameLayout kSFrameLayout3 = new KSFrameLayout(getContext());
            this.zX = kSFrameLayout3;
            kSFrameLayout3.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            a(this.zX);
            ((FrameLayout) getRootView()).addView(this.zX, layoutParams);
        }
        return this.zX;
    }
}
