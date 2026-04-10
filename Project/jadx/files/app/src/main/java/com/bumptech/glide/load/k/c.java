package com.bumptech.glide.load.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

/* JADX INFO: compiled from: UnitTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements i<T> {
    private static final i<?> b = new c();

    private c() {
    }

    @NonNull
    public static <T> c<T> a() {
        return (c) b;
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public s<T> transform(@NonNull Context context, @NonNull s<T> sVar, int i2, int i3) {
        return sVar;
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
