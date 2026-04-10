package com.bumptech.glide.load.k.g;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* JADX INFO: compiled from: GifBitmapProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements GifDecoder.a {
    private final com.bumptech.glide.load.engine.x.e a;

    @Nullable
    private final com.bumptech.glide.load.engine.x.b b;

    public b(com.bumptech.glide.load.engine.x.e eVar, @Nullable com.bumptech.glide.load.engine.x.b bVar) {
        this.a = eVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public Bitmap a(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.a.b(i2, i3, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public int[] b(int i2) {
        com.bumptech.glide.load.engine.x.b bVar = this.b;
        return bVar == null ? new int[i2] : (int[]) bVar.a(i2, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void a(@NonNull Bitmap bitmap) {
        this.a.a(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public byte[] a(int i2) {
        com.bumptech.glide.load.engine.x.b bVar = this.b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.a(i2, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void a(@NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.x.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void a(@NonNull int[] iArr) {
        com.bumptech.glide.load.engine.x.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
