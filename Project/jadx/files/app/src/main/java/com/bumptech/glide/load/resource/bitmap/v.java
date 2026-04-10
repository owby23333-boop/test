package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements com.bumptech.glide.load.g<Uri, Bitmap> {
    private final com.bumptech.glide.load.k.e.f a;
    private final com.bumptech.glide.load.engine.x.e b;

    public v(com.bumptech.glide.load.k.e.f fVar, com.bumptech.glide.load.engine.x.e eVar) {
        this.a = fVar;
        this.b = eVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.load.engine.s<Drawable> sVarA = this.a.a(uri, i2, i3, fVar);
        if (sVarA == null) {
            return null;
        }
        return m.a(this.b, sVarA.get(), i2, i3);
    }
}
