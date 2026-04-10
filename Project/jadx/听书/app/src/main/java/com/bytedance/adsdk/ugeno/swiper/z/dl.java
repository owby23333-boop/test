package com.bytedance.adsdk.ugeno.swiper.z;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements ViewPager.gc {
    private String z;

    public void z(String str) {
        this.z = str;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.gc
    public void z(View view, float f) {
        if (f >= -1.0f && f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(view.getHeight() * f);
        } else {
            view.setAlpha(0.0f);
        }
        if (TextUtils.equals(this.z, "cube")) {
            float height = f < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f * (-90.0f));
        }
    }
}
