package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
