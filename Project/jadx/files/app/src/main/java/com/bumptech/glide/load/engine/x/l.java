package com.bumptech.glide.load.engine.x;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: LruPoolStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
interface l {
    @Nullable
    Bitmap a(int i2, int i3, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i2, int i3, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
