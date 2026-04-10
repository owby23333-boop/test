package com.google.android.material.b;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CanvasCompat.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static int a(@NonNull Canvas canvas, float f2, float f3, float f4, float f5, int i2) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i2) : canvas.saveLayerAlpha(f2, f3, f4, f5, i2, 31);
    }
}
