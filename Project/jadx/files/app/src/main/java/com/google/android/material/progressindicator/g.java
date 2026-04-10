package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: DrawingDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class g<S extends b> {
    S a;
    protected f b;

    public g(S s2) {
        this.a = s2;
    }

    abstract int a();

    abstract void a(@NonNull Canvas canvas, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2);

    abstract void a(@NonNull Canvas canvas, @NonNull Paint paint);

    abstract void a(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f3, @ColorInt int i2);

    protected void a(@NonNull f fVar) {
        this.b = fVar;
    }

    abstract int b();

    void b(@NonNull Canvas canvas, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.a.c();
        a(canvas, f2);
    }
}
