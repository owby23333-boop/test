package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface b {
    void onViewAttachedToWindow(View view);

    void onViewDetachedFromWindow(View view);
}
