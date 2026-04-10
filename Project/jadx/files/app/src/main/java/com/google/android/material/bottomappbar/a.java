package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.shape.f;
import com.google.android.material.shape.n;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends f implements Cloneable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f15043s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f15044t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f15045u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f15046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f15047w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f15048x = -1.0f;

    public a(float f2, float f3, float f4) {
        this.f15044t = f2;
        this.f15043s = f3;
        a(f4);
        this.f15047w = 0.0f;
    }

    @Override // com.google.android.material.shape.f
    public void a(float f2, float f3, float f4, @NonNull n nVar) {
        float f5;
        float f6;
        float f7 = this.f15045u;
        if (f7 == 0.0f) {
            nVar.a(f2, 0.0f);
            return;
        }
        float f8 = ((this.f15044t * 2.0f) + f7) / 2.0f;
        float f9 = f4 * this.f15043s;
        float f10 = f3 + this.f15047w;
        float f11 = (this.f15046v * f4) + ((1.0f - f4) * f8);
        if (f11 / f8 >= 1.0f) {
            nVar.a(f2, 0.0f);
            return;
        }
        float f12 = this.f15048x;
        float f13 = f12 * f4;
        boolean z2 = f12 == -1.0f || Math.abs((f12 * 2.0f) - f7) < 0.1f;
        if (z2) {
            f5 = f11;
            f6 = 0.0f;
        } else {
            f6 = 1.75f;
            f5 = 0.0f;
        }
        float f14 = f8 + f9;
        float f15 = f5 + f9;
        float fSqrt = (float) Math.sqrt((f14 * f14) - (f15 * f15));
        float f16 = f10 - fSqrt;
        float f17 = f10 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f15));
        float f18 = (90.0f - degrees) + f6;
        nVar.a(f16, 0.0f);
        float f19 = f9 * 2.0f;
        nVar.a(f16 - f9, 0.0f, f16 + f9, f19, 270.0f, degrees);
        if (z2) {
            nVar.a(f10 - f8, (-f8) - f5, f10 + f8, f8 - f5, 180.0f - f18, (f18 * 2.0f) - 180.0f);
        } else {
            float f20 = this.f15044t;
            float f21 = f13 * 2.0f;
            float f22 = f10 - f8;
            nVar.a(f22, -(f13 + f20), f22 + f20 + f21, f20 + f13, 180.0f - f18, ((f18 * 2.0f) - 180.0f) / 2.0f);
            float f23 = f10 + f8;
            float f24 = this.f15044t;
            nVar.a(f23 - ((f24 / 2.0f) + f13), f24 + f13);
            float f25 = this.f15044t;
            nVar.a(f23 - (f21 + f25), -(f13 + f25), f23, f25 + f13, 90.0f, f18 - 90.0f);
        }
        nVar.a(f17 - f9, 0.0f, f17 + f9, f19, 270.0f - degrees, degrees);
        nVar.a(f2, 0.0f);
    }

    float b() {
        return this.f15046v;
    }

    void c(float f2) {
        this.f15044t = f2;
    }

    float d() {
        return this.f15044t;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(float f2) {
        this.f15045u = f2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float f() {
        return this.f15045u;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float g() {
        return this.f15047w;
    }

    public void b(float f2) {
        this.f15048x = f2;
    }

    public float c() {
        return this.f15048x;
    }

    void d(float f2) {
        this.f15043s = f2;
    }

    float e() {
        return this.f15043s;
    }

    void f(float f2) {
        this.f15047w = f2;
    }

    void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE) float f2) {
        if (f2 >= 0.0f) {
            this.f15046v = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }
}
