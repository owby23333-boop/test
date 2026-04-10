package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements com.bumptech.glide.load.i<Bitmap> {
    protected abstract Bitmap transform(@NonNull com.bumptech.glide.load.engine.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.i
    @NonNull
    public final com.bumptech.glide.load.engine.s<Bitmap> transform(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.s<Bitmap> sVar, int i2, int i3) {
        if (!com.bumptech.glide.util.l.b(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.engine.x.e eVarD = com.bumptech.glide.c.a(context).d();
        Bitmap bitmap = sVar.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(eVarD, bitmap, i2, i3);
        return bitmap.equals(bitmapTransform) ? sVar : e.a(bitmapTransform, eVarD);
    }
}
