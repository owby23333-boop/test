package com.google.android.material.i;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: MaterialAttributes.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    @Nullable
    public static TypedValue a(@NonNull Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int a(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        TypedValue typedValueA = a(context, i2);
        if (typedValueA != null) {
            return typedValueA.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static int a(@NonNull View view, @AttrRes int i2) {
        return a(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static boolean a(@NonNull Context context, @AttrRes int i2, boolean z2) {
        TypedValue typedValueA = a(context, i2);
        return (typedValueA == null || typedValueA.type != 18) ? z2 : typedValueA.data != 0;
    }
}
