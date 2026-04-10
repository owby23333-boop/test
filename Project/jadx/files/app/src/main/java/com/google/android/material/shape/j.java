package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements c {
    private final float a;

    public j(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.a = f2;
    }

    @Override // com.google.android.material.shape.c
    public float a(@NonNull RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.a == ((j) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
