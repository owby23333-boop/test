package com.bumptech.glide.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.k;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.bumptech.glide.load.c {
    private final Object b;

    public d(@NonNull Object obj) {
        k.a(obj);
        this.b = obj;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.b.equals(((d) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(com.bumptech.glide.load.c.a));
    }
}
