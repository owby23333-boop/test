package io.rx_cache2.internal;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface Persistence {
    List<String> allKeys();

    void evict(String str);

    void evictAll();

    <T> T retrieve(String str, Class<T> cls, boolean z2, String str2);

    <T> Record<T> retrieveRecord(String str, boolean z2, String str2);

    void save(String str, Object obj, boolean z2, String str2);

    void saveRecord(String str, Record record, boolean z2, String str2);

    int storedMB();
}
