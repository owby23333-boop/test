package com.google.android.material.e;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {
    @Nullable
    public static PorterDuffColorFilter a(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    @TargetApi(21)
    public static void a(@Nullable RippleDrawable rippleDrawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i2);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i2));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e2);
        }
    }
}
