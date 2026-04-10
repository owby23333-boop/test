package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ThirdPartySplashAdView extends AsseblemSplashAdView {
    BaseAd P;

    public ThirdPartySplashAdView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final float a(a aVar, int i2) {
        return 1.0f;
    }

    @Override // com.anythink.basead.ui.AsseblemSplashAdView, com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void b() {
        super.b();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_ad_lable_area", "id"));
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.f6129r.add(frameLayout);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        BaseAd baseAd = this.P;
        if (baseAd == null || baseAd.getAdMediaView(new Object[0]) == null) {
            return;
        }
        View adMediaView = this.P.getAdMediaView(new Object[0]);
        if (adMediaView.getParent() != null) {
            ((ViewGroup) adMediaView.getParent()).removeView(adMediaView);
        }
        frameLayout2.addView(adMediaView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.anythink.basead.ui.AsseblemSplashAdView, com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void c() {
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final boolean m() {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void o() {
        super.o();
        GuideToClickView guideToClickView = this.J;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView, com.anythink.basead.ui.BaseSplashAdView
    protected final void p() {
    }

    public void registerNativeClickListener(View view) {
        if (this.P != null) {
            if (this.f6114c.f7312m.x() == 0) {
                this.f6129r.add(this);
                this.P.registerListener(view, this.f6129r, null);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(((AsseblemSplashAdView) this).a);
                this.P.registerListener(view, arrayList, null);
            }
        }
    }

    public ThirdPartySplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar, String str) {
        super(context, jVar, iVar, aVar);
        this.P = com.anythink.basead.d.i.a().a(str);
    }
}
