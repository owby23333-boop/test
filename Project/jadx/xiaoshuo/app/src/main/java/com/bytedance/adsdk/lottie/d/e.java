package com.bytedance.adsdk.lottie.d;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e {
    private final PointF bf;
    private final PointF d;
    private final PointF e;

    public e() {
        this.e = new PointF();
        this.bf = new PointF();
        this.d = new PointF();
    }

    public void bf(float f, float f2) {
        this.bf.set(f, f2);
    }

    public void d(float f, float f2) {
        this.d.set(f, f2);
    }

    public void e(float f, float f2) {
        this.e.set(f, f2);
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.d.x), Float.valueOf(this.d.y), Float.valueOf(this.e.x), Float.valueOf(this.e.y), Float.valueOf(this.bf.x), Float.valueOf(this.bf.y));
    }

    public PointF bf() {
        return this.bf;
    }

    public PointF d() {
        return this.d;
    }

    public PointF e() {
        return this.e;
    }

    public e(PointF pointF, PointF pointF2, PointF pointF3) {
        this.e = pointF;
        this.bf = pointF2;
        this.d = pointF3;
    }
}
