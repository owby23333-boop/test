package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements com.bumptech.glide.load.c {
    private final com.bumptech.glide.load.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13513c;

    c(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.b = cVar;
        this.f13513c = cVar2;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b.equals(cVar.b) && this.f13513c.equals(cVar.f13513c);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.f13513c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.f13513c + '}';
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
        this.f13513c.updateDiskCacheKey(messageDigest);
    }
}
