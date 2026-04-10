package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: compiled from: DataFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d<T> {

    /* JADX INFO: compiled from: DataFetcher.java */
    public interface a<T> {
        void a(@NonNull Exception exc);

        void a(@Nullable T t2);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull Priority priority, @NonNull a<? super T> aVar);

    void b();

    void cancel();

    @NonNull
    DataSource getDataSource();
}
