package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {
    public static final Charset a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
