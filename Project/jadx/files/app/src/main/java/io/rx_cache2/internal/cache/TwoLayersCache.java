package io.rx_cache2.internal.cache;

import io.rx_cache2.internal.Record;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
@Singleton
public final class TwoLayersCache {
    private final EvictRecord evictRecord;
    private final RetrieveRecord retrieveRecord;
    private final SaveRecord saveRecord;

    @Inject
    public TwoLayersCache(EvictRecord evictRecord, RetrieveRecord retrieveRecord, SaveRecord saveRecord) {
        this.evictRecord = evictRecord;
        this.retrieveRecord = retrieveRecord;
        this.saveRecord = saveRecord;
    }

    public void evictAll() {
        this.evictRecord.evictAll();
    }

    public void evictDynamicKey(String str, String str2) {
        this.evictRecord.evictRecordsMatchingDynamicKey(str, str2);
    }

    public void evictDynamicKeyGroup(String str, String str2, String str3) {
        this.evictRecord.evictRecordMatchingDynamicKeyGroup(str, str2, str3);
    }

    public void evictProviderKey(String str) {
        this.evictRecord.evictRecordsMatchingProviderKey(str);
    }

    public void mockMemoryDestroyed() {
        this.evictRecord.mockMemoryDestroyed();
    }

    public <T> Record<T> retrieve(String str, String str2, String str3, boolean z2, Long l2, boolean z3) {
        return this.retrieveRecord.retrieveRecord(str, str2, str3, z2, l2, z3);
    }

    public void save(String str, String str2, String str3, Object obj, Long l2, boolean z2, boolean z3) {
        this.saveRecord.save(str, str2, str3, obj, l2, z2, z3);
    }
}
