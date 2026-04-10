package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements com.bumptech.glide.load.g<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.engine.s<Bitmap> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Bitmap f13803s;

        a(@NonNull Bitmap bitmap) {
            this.f13803s = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.s
        @NonNull
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.s
        public int getSize() {
            return com.bumptech.glide.util.l.a(this.f13803s);
        }

        @Override // com.bumptech.glide.load.engine.s
        public void recycle() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.s
        @NonNull
        public Bitmap get() {
            return this.f13803s;
        }
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new a(bitmap);
    }
}
