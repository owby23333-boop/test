package com.bumptech.glide.load.k.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.util.k;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    private final Resources a;

    public b(@NonNull Resources resources) {
        k.a(resources);
        this.a = resources;
    }

    @Override // com.bumptech.glide.load.k.h.e
    @Nullable
    public s<BitmapDrawable> a(@NonNull s<Bitmap> sVar, @NonNull com.bumptech.glide.load.f fVar) {
        return t.a(this.a, sVar);
    }
}
