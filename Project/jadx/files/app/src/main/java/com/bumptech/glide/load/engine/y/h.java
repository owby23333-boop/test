package com.bumptech.glide.load.engine.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: compiled from: MemoryCache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {

    /* JADX INFO: compiled from: MemoryCache.java */
    public interface a {
        void a(@NonNull s<?> sVar);
    }

    @Nullable
    s<?> a(@NonNull com.bumptech.glide.load.c cVar);

    @Nullable
    s<?> a(@NonNull com.bumptech.glide.load.c cVar, @Nullable s<?> sVar);

    void a();

    void a(@NonNull a aVar);

    void trimMemory(int i2);
}
