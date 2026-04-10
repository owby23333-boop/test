package com.bumptech.glide.load.engine.x;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BitmapPool.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {
    @NonNull
    Bitmap a(int i2, int i3, Bitmap.Config config);

    void a();

    void a(Bitmap bitmap);

    @NonNull
    Bitmap b(int i2, int i3, Bitmap.Config config);

    void trimMemory(int i2);
}
