package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: RoundedCorners.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f13799c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(com.bumptech.glide.load.c.a);
    private final int b;

    public w(int i2) {
        com.bumptech.glide.util.k.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.b = i2;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof w) && this.b == ((w) obj).b;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.l.a("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), com.bumptech.glide.util.l.b(this.b));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap transform(@NonNull com.bumptech.glide.load.engine.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return y.b(eVar, bitmap, this.b);
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f13799c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
}
