package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: RoundedCornerTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends d {
    float a = -1.0f;

    @Override // com.google.android.material.shape.d
    public void a(@NonNull n nVar, float f2, float f3, float f4) {
        nVar.a(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        nVar.a(0.0f, 0.0f, f5, f5, 180.0f, f2);
    }
}
