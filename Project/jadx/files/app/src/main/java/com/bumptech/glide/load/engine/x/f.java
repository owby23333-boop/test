package com.bumptech.glide.load.engine.x;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapPoolAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.x.e
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.x.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.x.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return a(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.x.e
    public void trimMemory(int i2) {
    }

    @Override // com.bumptech.glide.load.engine.x.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
