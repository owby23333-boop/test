package me.drakeet.multitype;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: TypePool.java */
/* JADX INFO: loaded from: classes3.dex */
public interface g {
    int a(@NonNull Class<?> cls);

    @NonNull
    b<?, ?> a(int i2);

    <T> void a(@NonNull Class<? extends T> cls, @NonNull b<T, ?> bVar, @NonNull c<T> cVar);

    @NonNull
    c<?> b(int i2);

    boolean b(@NonNull Class<?> cls);
}
