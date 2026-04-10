package com.bytedance.sdk.component.adexpress.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Drawable z(Context context, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        if (context == null || eVar == null) {
            return null;
        }
        return z(context, (int) gz.z(context, eVar.p()), eVar.ls(), eVar.l());
    }

    public static Drawable z(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
