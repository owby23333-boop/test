package me.jessyan.lifecyclemodel.cache;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface Cache<K, V> {
    void clear();

    boolean containsKey(K k2);

    @Nullable
    V get(K k2);

    int getMaxSize();

    Set<K> keySet();

    @Nullable
    V put(K k2, V v2);

    @Nullable
    V remove(K k2);

    int size();
}
