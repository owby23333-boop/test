package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b implements c {
    private final c a;
    private final float b;

    public b(float f2, @NonNull c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f2 += ((b) cVar).b;
        }
        this.a = cVar;
        this.b = f2;
    }

    @Override // com.google.android.material.shape.c
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b == bVar.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
