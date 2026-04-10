package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements c {
    private final ArrayMap<e<?>, Object> b = new com.bumptech.glide.util.b();

    public void a(@NonNull f fVar) {
        this.b.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.b);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.b.equals(((f) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            a(this.b.keyAt(i2), this.b.valueAt(i2), messageDigest);
        }
    }

    @NonNull
    public <T> f a(@NonNull e<T> eVar, @NonNull T t2) {
        this.b.put(eVar, t2);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull e<T> eVar) {
        return this.b.containsKey(eVar) ? (T) this.b.get(eVar) : eVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NonNull e<T> eVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        eVar.update(obj, messageDigest);
    }
}
