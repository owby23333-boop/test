package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: DataRewinder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e<T> {

    /* JADX INFO: compiled from: DataRewinder.java */
    public interface a<T> {
        @NonNull
        e<T> a(@NonNull T t2);

        @NonNull
        Class<T> a();
    }

    @NonNull
    T a() throws IOException;

    void b();
}
