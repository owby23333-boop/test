package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: ToolbarUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class m {
    @Nullable
    public static TextView a(@NonNull Toolbar toolbar) {
        return a(toolbar, toolbar.getSubtitle());
    }

    @Nullable
    public static TextView b(@NonNull Toolbar toolbar) {
        return a(toolbar, toolbar.getTitle());
    }

    @Nullable
    private static TextView a(@NonNull Toolbar toolbar, CharSequence charSequence) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }
}
