package com.mardous.discreteseekbar.a.c;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: compiled from: SeekBarCompat.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static Drawable a(ColorStateList colorStateList) {
        return Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(colorStateList, null, null) : new com.mardous.discreteseekbar.a.d.a(colorStateList);
    }

    public static void a(@NonNull Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((RippleDrawable) drawable).setColor(colorStateList);
        } else {
            ((com.mardous.discreteseekbar.a.d.a) drawable).b(colorStateList);
        }
    }

    public static void a(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i6 = (i4 - i2) / 8;
            DrawableCompat.setHotspotBounds(drawable, i2 + i6, i3 + i6, i4 - i6, i5 - i6);
        } else {
            drawable.setBounds(i2, i3, i4, i5);
        }
    }
}
