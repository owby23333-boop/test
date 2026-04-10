package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: BitmapDrawableDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<DataType> implements com.bumptech.glide.load.g<DataType, BitmapDrawable> {
    private final com.bumptech.glide.load.g<DataType, Bitmap> a;
    private final Resources b;

    public a(@NonNull Resources resources, @NonNull com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        com.bumptech.glide.util.k.a(resources);
        this.b = resources;
        com.bumptech.glide.util.k.a(gVar);
        this.a = gVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull DataType datatype, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.a.a(datatype, fVar);
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<BitmapDrawable> a(@NonNull DataType datatype, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return t.a(this.b, this.a.a(datatype, i2, i3, fVar));
    }
}
