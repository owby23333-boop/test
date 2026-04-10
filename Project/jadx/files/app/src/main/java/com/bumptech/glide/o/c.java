package com.bumptech.glide.o;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: EmptySignature.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bumptech.glide.load.c {
    private static final c b = new c();

    private c() {
    }

    @NonNull
    public static c a() {
        return b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
