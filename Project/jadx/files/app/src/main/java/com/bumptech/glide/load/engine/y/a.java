package com.bumptech.glide.load.engine.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: DiskCache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.y.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskCache.java */
    public interface InterfaceC0261a {
        @Nullable
        a build();
    }

    /* JADX INFO: compiled from: DiskCache.java */
    public interface b {
        boolean a(@NonNull File file);
    }

    @Nullable
    File a(com.bumptech.glide.load.c cVar);

    void a(com.bumptech.glide.load.c cVar, b bVar);

    void clear();

    void delete(com.bumptech.glide.load.c cVar);
}
