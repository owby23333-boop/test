package com.anythink.expressad.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static void a(View view, String str, String str2) {
        if (view != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(str2));
            gradientDrawable.setCornerRadius(t.b(view.getContext(), 12.0f));
            gradientDrawable.setStroke(t.b(view.getContext(), 1.0f), Color.parseColor(str));
            view.setBackgroundDrawable(gradientDrawable);
        }
    }

    public static void a(View view, float f2, float f3, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view != null) {
            int[] iArr = new int[2];
            for (int i2 = 0; i2 < 2; i2++) {
                iArr[i2] = Color.parseColor(strArr[i2]);
            }
            GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
            gradientDrawable.setCornerRadius(t.b(view.getContext(), f3));
            gradientDrawable.setStroke(t.b(view.getContext(), f2), Color.parseColor(str));
            view.setBackgroundDrawable(gradientDrawable);
        }
    }
}
