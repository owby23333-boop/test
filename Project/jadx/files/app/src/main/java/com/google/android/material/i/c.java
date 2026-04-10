package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c {
    @Nullable
    public static ColorStateList a(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int color;
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i2, -1)) == -1) ? typedArray.getColorStateList(i2) : ColorStateList.valueOf(color) : colorStateList;
    }

    @Nullable
    public static Drawable b(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawable;
    }

    @Nullable
    public static d c(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean b(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    @Nullable
    public static ColorStateList a(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i2) {
        int color;
        int resourceId;
        ColorStateList colorStateList;
        if (tintTypedArray.hasValue(i2) && (resourceId = tintTypedArray.getResourceId(i2, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) != null) {
            return colorStateList;
        }
        if (Build.VERSION.SDK_INT <= 15 && (color = tintTypedArray.getColor(i2, -1)) != -1) {
            return ColorStateList.valueOf(color);
        }
        return tintTypedArray.getColorStateList(i2);
    }

    public static int a(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i2, typedValue) && typedValue.type == 2) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i3);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i2, i3);
    }

    public static boolean a(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    @StyleableRes
    static int a(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }
}
