package io.rx_cache2.internal.cache;

import io.rx_cache2.Source;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import io.rx_cache2.internal.Record;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public final class RetrieveRecord extends Action {
    private final String encryptKey;
    private final EvictRecord evictRecord;
    private final HasRecordExpired hasRecordExpired;

    @Inject
    public RetrieveRecord(Memory memory, Persistence persistence, EvictRecord evictRecord, HasRecordExpired hasRecordExpired, String str) {
        super(memory, persistence);
        this.evictRecord = evictRecord;
        this.hasRecordExpired = hasRecordExpired;
        this.encryptKey = str;
    }

    <T> Record<T> retrieveRecord(String str, String str2, String str3, boolean z2, Long l2, boolean z3) {
        String strComposeKey = composeKey(str, str2, str3);
        Record<T> ifPresent = this.memory.getIfPresent(strComposeKey);
        if (ifPresent != null) {
            ifPresent.setSource(Source.MEMORY);
        } else {
            try {
                ifPresent = this.persistence.retrieveRecord(strComposeKey, z3, this.encryptKey);
                ifPresent.setSource(Source.PERSISTENCE);
                this.memory.put(strComposeKey, ifPresent);
            } catch (Exception unused) {
                return null;
            }
        }
        ifPresent.setLifeTime(l2);
        if (!this.hasRecordExpired.hasRecordExpired(ifPresent)) {
            return ifPresent;
        }
        if (!str3.isEmpty()) {
            this.evictRecord.evictRecordMatchingDynamicKeyGroup(str, str2, str3);
        } else if (str2.isEmpty()) {
            this.evictRecord.evictRecordsMatchingProviderKey(str);
        } else {
            this.evictRecord.evictRecordsMatchingDynamicKey(str, str2);
        }
        if (z2) {
            return ifPresent;
        }
        return null;
    }
}
