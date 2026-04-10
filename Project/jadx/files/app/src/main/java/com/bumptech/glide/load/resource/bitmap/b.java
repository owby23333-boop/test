package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements com.bumptech.glide.load.h<BitmapDrawable> {
    private final com.bumptech.glide.load.engine.x.e a;
    private final com.bumptech.glide.load.h<Bitmap> b;

    public b(com.bumptech.glide.load.engine.x.e eVar, com.bumptech.glide.load.h<Bitmap> hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(@NonNull com.bumptech.glide.load.engine.s<BitmapDrawable> sVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        return this.b.a((Bitmap) new e(sVar.get().getBitmap(), this.a), file, fVar);
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy a(@NonNull com.bumptech.glide.load.f fVar) {
        return this.b.a(fVar);
    }
}
