package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: compiled from: DataFetcherGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
interface e {

    /* JADX INFO: compiled from: DataFetcherGenerator.java */
    public interface a {
        void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void a(com.bumptech.glide.load.c cVar, @Nullable Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2);

        void c();
    }

    boolean a();

    void cancel();
}
