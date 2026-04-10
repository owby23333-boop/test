package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* JADX INFO: loaded from: classes2.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View e(int i) {
        return (ViewGroup) this.z.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.a
    public void gz(int i) {
        super.gz(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.a
    public void fo(int i) {
        super.fo(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View z(int i, int i2) {
        if (this.z.isEmpty()) {
            return new View(getContext());
        }
        View viewE = e(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewE instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewE.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewE.getParent()).removeView(viewE);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(viewE, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }
}
