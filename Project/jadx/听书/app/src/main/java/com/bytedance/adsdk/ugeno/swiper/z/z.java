package com.bytedance.adsdk.ugeno.swiper.z;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class z implements ViewPager.gc {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.gc
    public void z(View view, float f) {
        view.setPivotX(f < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}
