package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: MarkerEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends f {
    private final float a;

    public g(float f2) {
        this.a = f2 - 0.001f;
    }

    @Override // com.google.android.material.shape.f
    public void a(float f2, float f3, float f4, @NonNull n nVar) {
        double d2 = this.a;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        float f5 = (float) ((d2 * dSqrt) / 2.0d);
        float fSqrt = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(f5, 2.0d));
        double d3 = this.a;
        double dSqrt2 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = d3 * dSqrt2;
        double d5 = this.a;
        Double.isNaN(d5);
        nVar.b(f3 - f5, ((float) (-(d4 - d5))) + fSqrt);
        double d6 = this.a;
        double dSqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d6);
        double d7 = d6 * dSqrt3;
        double d8 = this.a;
        Double.isNaN(d8);
        nVar.a(f3, (float) (-(d7 - d8)));
        double d9 = this.a;
        double dSqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d9);
        double d10 = d9 * dSqrt4;
        double d11 = this.a;
        Double.isNaN(d11);
        nVar.a(f3 + f5, ((float) (-(d10 - d11))) + fSqrt);
    }

    @Override // com.google.android.material.shape.f
    boolean a() {
        return true;
    }
}
