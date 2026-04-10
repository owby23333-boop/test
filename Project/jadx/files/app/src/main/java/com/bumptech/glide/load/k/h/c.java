package com.bumptech.glide.load.k.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements e<Drawable, byte[]> {
    private final com.bumptech.glide.load.engine.x.e a;
    private final e<Bitmap, byte[]> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<com.bumptech.glide.load.k.g.c, byte[]> f13749c;

    public c(@NonNull com.bumptech.glide.load.engine.x.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.bumptech.glide.load.k.g.c, byte[]> eVar3) {
        this.a = eVar;
        this.b = eVar2;
        this.f13749c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static s<com.bumptech.glide.load.k.g.c> a(@NonNull s<Drawable> sVar) {
        return sVar;
    }

    @Override // com.bumptech.glide.load.k.h.e
    @Nullable
    public s<byte[]> a(@NonNull s<Drawable> sVar, @NonNull com.bumptech.glide.load.f fVar) {
        Drawable drawable = sVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(com.bumptech.glide.load.resource.bitmap.e.a(((BitmapDrawable) drawable).getBitmap(), this.a), fVar);
        }
        if (!(drawable instanceof com.bumptech.glide.load.k.g.c)) {
            return null;
        }
        e<com.bumptech.glide.load.k.g.c, byte[]> eVar = this.f13749c;
        a(sVar);
        return eVar.a(sVar, fVar);
    }
}
