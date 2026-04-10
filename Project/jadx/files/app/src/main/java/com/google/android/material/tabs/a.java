package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: ElasticTabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends b {
    a() {
    }

    private static float a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        double d2 = f2;
        Double.isNaN(d2);
        return (float) (1.0d - Math.cos((d2 * 3.141592653589793d) / 2.0d));
    }

    private static float b(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        double d2 = f2;
        Double.isNaN(d2);
        return (float) Math.sin((d2 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.b
    void a(TabLayout tabLayout, View view, View view2, float f2, @NonNull Drawable drawable) {
        float fB;
        float fA;
        RectF rectFA = b.a(tabLayout, view);
        RectF rectFA2 = b.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            fB = a(f2);
            fA = b(f2);
        } else {
            fB = b(f2);
            fA = a(f2);
        }
        drawable.setBounds(com.google.android.material.a.a.a((int) rectFA.left, (int) rectFA2.left, fB), drawable.getBounds().top, com.google.android.material.a.a.a((int) rectFA.right, (int) rectFA2.right, fA), drawable.getBounds().bottom);
    }
}
