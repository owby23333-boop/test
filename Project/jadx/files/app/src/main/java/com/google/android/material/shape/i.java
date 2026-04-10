package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: OffsetEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends f {
    private final f a;
    private final float b;

    public i(@NonNull f fVar, float f2) {
        this.a = fVar;
        this.b = f2;
    }

    @Override // com.google.android.material.shape.f
    public void a(float f2, float f3, float f4, @NonNull n nVar) {
        this.a.a(f2, f3 - this.b, f4, nVar);
    }

    @Override // com.google.android.material.shape.f
    boolean a() {
        return this.a.a();
    }
}
