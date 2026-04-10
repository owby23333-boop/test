package me.jessyan.art.http.imageloader.glide.transform;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.x.e;
import com.bumptech.glide.load.resource.bitmap.f;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class BlurTransformation extends f {
    public static final int DEFAULT_RADIUS = 15;
    private static final String ID = "me.jessyan.art.http.imageloader.glide.transform.BlurTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(c.a);
    private int mRadius;

    public BlurTransformation(@IntRange(from = 0) int i2) {
        this.mRadius = i2;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof BlurTransformation;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return ID.hashCode();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap transform(@NonNull e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return FastBlur.doBlur(bitmap, this.mRadius, true);
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
