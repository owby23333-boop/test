package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    private float iD;
    private int iE;
    private Map<Integer, com.kwad.components.ad.interstitial.e.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.iE = 0;
    }

    private void a(View view, View view2, float f2) {
        if (this.iE == 0 && f2 != 0.0f) {
            float f3 = this.iD;
            if (f3 != 0.0f) {
                if (f2 > f3) {
                    this.iE = 1;
                } else {
                    this.iE = 2;
                }
            }
        }
        if (this.iE == 1 && view2 != null) {
            if (f2 > 0.5d || f2 <= 0.0f) {
                view2.setTranslationX((1.0f - f2) * 240.0f);
            } else {
                view2.setTranslationX(240.0f * f2);
            }
        }
        if (this.iE == 2 && view != null) {
            if (f2 > 0.5d || f2 < 0.0f) {
                view.setTranslationX((1.0f - f2) * (-240.0f));
            } else {
                view.setTranslationX((-240.0f) * f2);
            }
        }
        this.iD = f2;
        if (f2 == 0.0f) {
            this.iE = 0;
        }
    }

    public final com.kwad.components.ad.interstitial.e.c B(int i2) {
        return this.map.get(Integer.valueOf(i2));
    }

    public final void a(int i2, com.kwad.components.ad.interstitial.e.c cVar) {
        this.map.put(Integer.valueOf(i2), cVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected void onPageScrolled(int i2, float f2, int i3) {
        a(B(i2), B(i2 + 1), f2);
        super.onPageScrolled(i2, f2, i3);
    }
}
