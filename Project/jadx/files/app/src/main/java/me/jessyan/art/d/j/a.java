package me.jessyan.art.d.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public interface a<K, V> {

    /* JADX INFO: renamed from: me.jessyan.art.d.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.java */
    /* JADX INFO: loaded from: classes3.dex */
    public interface InterfaceC0579a {
        @NonNull
        a a(b bVar);
    }

    void clear();

    boolean containsKey(K k2);

    @Nullable
    V get(K k2);

    @Nullable
    V put(K k2, V v2);

    @Nullable
    V remove(K k2);
}
