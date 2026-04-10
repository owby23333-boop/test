package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements com.bumptech.glide.load.engine.s<BitmapDrawable>, com.bumptech.glide.load.engine.o {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Resources f13797s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.s<Bitmap> f13798t;

    private t(@NonNull Resources resources, @NonNull com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        com.bumptech.glide.util.k.a(resources);
        this.f13797s = resources;
        com.bumptech.glide.util.k.a(sVar);
        this.f13798t = sVar;
    }

    @Nullable
    public static com.bumptech.glide.load.engine.s<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new t(resources, sVar);
    }

    @Override // com.bumptech.glide.load.engine.o
    public void b() {
        com.bumptech.glide.load.engine.s<Bitmap> sVar = this.f13798t;
        if (sVar instanceof com.bumptech.glide.load.engine.o) {
            ((com.bumptech.glide.load.engine.o) sVar).b();
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return this.f13798t.getSize();
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
        this.f13798t.recycle();
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f13797s, this.f13798t.get());
    }
}
