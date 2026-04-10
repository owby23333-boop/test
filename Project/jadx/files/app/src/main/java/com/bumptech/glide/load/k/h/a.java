package com.bumptech.glide.load.k.h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat a;
    private final int b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.k.h.e
    @Nullable
    public s<byte[]> a(@NonNull s<Bitmap> sVar, @NonNull com.bumptech.glide.load.f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.get().compress(this.a, this.b, byteArrayOutputStream);
        sVar.recycle();
        return new com.bumptech.glide.load.k.d.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.b = i2;
    }
}
