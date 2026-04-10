package com.bumptech.glide.load.k.g;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements com.bumptech.glide.load.i<c> {
    private final com.bumptech.glide.load.i<Bitmap> b;

    public f(com.bumptech.glide.load.i<Bitmap> iVar) {
        k.a(iVar);
        this.b = iVar;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.b.equals(((f) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public s<c> transform(@NonNull Context context, @NonNull s<c> sVar, int i2, int i3) {
        c cVar = sVar.get();
        s<Bitmap> eVar = new com.bumptech.glide.load.resource.bitmap.e(cVar.c(), com.bumptech.glide.c.a(context).d());
        s<Bitmap> sVarTransform = this.b.transform(context, eVar, i2, i3);
        if (!eVar.equals(sVarTransform)) {
            eVar.recycle();
        }
        cVar.a(this.b, sVarTransform.get());
        return sVar;
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
