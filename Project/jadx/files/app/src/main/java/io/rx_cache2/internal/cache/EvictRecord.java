package io.rx_cache2.internal.cache;

import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public final class EvictRecord extends Action {
    @Inject
    public EvictRecord(Memory memory, Persistence persistence) {
        super(memory, persistence);
    }

    void evictAll() {
        this.memory.evictAll();
        this.persistence.evictAll();
    }

    void evictRecordMatchingDynamicKeyGroup(String str, String str2, String str3) {
        String keyOnMemoryMatchingDynamicKeyGroup = getKeyOnMemoryMatchingDynamicKeyGroup(str, str2, str3);
        this.memory.evict(keyOnMemoryMatchingDynamicKeyGroup);
        this.persistence.evict(keyOnMemoryMatchingDynamicKeyGroup);
    }

    void evictRecordsMatchingDynamicKey(String str, String str2) {
        for (String str3 : getKeysOnMemoryMatchingDynamicKey(str, str2)) {
            this.memory.evict(str3);
            this.persistence.evict(str3);
        }
    }

    void evictRecordsMatchingProviderKey(String str) {
        for (String str2 : getKeysOnMemoryMatchingProviderKey(str)) {
            this.memory.evict(str2);
            this.persistence.evict(str2);
        }
    }

    void mockMemoryDestroyed() {
        this.memory.evictAll();
    }
}
