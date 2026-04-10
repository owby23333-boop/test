package com.bumptech.glide.load.engine.x;

/* JADX INFO: compiled from: ArrayPool.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    <T> T a(int i2, Class<T> cls);

    void a();

    <T> T b(int i2, Class<T> cls);

    <T> void put(T t2);

    void trimMemory(int i2);
}
