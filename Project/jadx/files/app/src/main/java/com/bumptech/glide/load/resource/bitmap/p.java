package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: FitCenter.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends f {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(com.bumptech.glide.load.c.a);

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof p;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap transform(@NonNull com.bumptech.glide.load.engine.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return y.d(eVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
