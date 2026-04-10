package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public final class s implements com.bumptech.glide.load.g<InputStream, Bitmap> {
    private final d a = new d();

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.a.a(ImageDecoder.createSource(com.bumptech.glide.util.a.a(inputStream)), i2, i3, fVar);
    }
}
