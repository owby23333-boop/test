package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
class q implements r {
    private final ViewOverlay a;

    q(@NonNull View view) {
        this.a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.r
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // com.google.android.material.internal.r
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }
}
