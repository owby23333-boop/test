package com.google.android.material.theme.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R$attr;

/* JADX INFO: compiled from: MaterialThemeOverlay.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final int[] a = {R.attr.theme, R$attr.theme};
    private static final int[] b = {R$attr.materialThemeOverlay};

    @StyleRes
    private static int a(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @NonNull
    public static Context b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        int iA = a(context, attributeSet, i2, i3);
        boolean z2 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == iA;
        if (iA == 0 || z2) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, iA);
        int iA2 = a(context, attributeSet);
        if (iA2 != 0) {
            contextThemeWrapper.getTheme().applyStyle(iA2, true);
        }
        return contextThemeWrapper;
    }

    @StyleRes
    private static int a(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
