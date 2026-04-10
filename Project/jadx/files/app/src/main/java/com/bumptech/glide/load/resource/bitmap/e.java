package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bumptech.glide.load.engine.s<Bitmap>, com.bumptech.glide.load.engine.o {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Bitmap f13771s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.e f13772t;

    public e(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.x.e eVar) {
        com.bumptech.glide.util.k.a(bitmap, "Bitmap must not be null");
        this.f13771s = bitmap;
        com.bumptech.glide.util.k.a(eVar, "BitmapPool must not be null");
        this.f13772t = eVar;
    }

    @Nullable
    public static e a(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.x.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.o
    public void b() {
        this.f13771s.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return com.bumptech.glide.util.l.a(this.f13771s);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
        this.f13772t.a(this.f13771s);
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Bitmap get() {
        return this.f13771s;
    }
}
