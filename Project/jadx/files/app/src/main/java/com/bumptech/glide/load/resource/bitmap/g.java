package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bumptech.glide.load.g<ByteBuffer, Bitmap> {
    private final l a;

    public g(l lVar) {
        this.a = lVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) {
        return this.a.a(byteBuffer);
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.a.a(byteBuffer, i2, i3, fVar);
    }
}
