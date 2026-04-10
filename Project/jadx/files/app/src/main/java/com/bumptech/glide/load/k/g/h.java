package com.bumptech.glide.load.k.g;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements com.bumptech.glide.load.g<GifDecoder, Bitmap> {
    private final com.bumptech.glide.load.engine.x.e a;

    public h(com.bumptech.glide.load.engine.x.e eVar) {
        this.a = eVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull GifDecoder gifDecoder, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public s<Bitmap> a(@NonNull GifDecoder gifDecoder, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return com.bumptech.glide.load.resource.bitmap.e.a(gifDecoder.a(), this.a);
    }
}
