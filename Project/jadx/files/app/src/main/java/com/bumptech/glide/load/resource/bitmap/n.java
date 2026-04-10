package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements com.bumptech.glide.load.i<Drawable> {
    private final com.bumptech.glide.load.i<Bitmap> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13784c;

    public n(com.bumptech.glide.load.i<Bitmap> iVar, boolean z2) {
        this.b = iVar;
        this.f13784c = z2;
    }

    private com.bumptech.glide.load.engine.s<Drawable> a(Context context, com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        return t.a(context.getResources(), sVar);
    }

    public com.bumptech.glide.load.i<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.b.equals(((n) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public com.bumptech.glide.load.engine.s<Drawable> transform(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.s<Drawable> sVar, int i2, int i3) {
        com.bumptech.glide.load.engine.x.e eVarD = com.bumptech.glide.c.a(context).d();
        Drawable drawable = sVar.get();
        com.bumptech.glide.load.engine.s<Bitmap> sVarA = m.a(eVarD, drawable, i2, i3);
        if (sVarA != null) {
            com.bumptech.glide.load.engine.s<Bitmap> sVarTransform = this.b.transform(context, sVarA, i2, i3);
            if (!sVarTransform.equals(sVarA)) {
                return a(context, sVarTransform);
            }
            sVarTransform.recycle();
            return sVar;
        }
        if (!this.f13784c) {
            return sVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
