package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: BitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public final class d implements com.bumptech.glide.load.g<ImageDecoder.Source, Bitmap> {
    private final com.bumptech.glide.load.engine.x.e a = new com.bumptech.glide.load.engine.x.f();

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull ImageDecoder.Source source, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new com.bumptech.glide.load.k.a(i2, i3, fVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            String str = "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]";
        }
        return new e(bitmapDecodeBitmap, this.a);
    }
}
