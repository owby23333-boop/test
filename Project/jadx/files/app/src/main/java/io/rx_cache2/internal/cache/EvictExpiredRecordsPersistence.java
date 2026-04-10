package io.rx_cache2.internal.cache;

import io.reactivex.Observable;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import io.rx_cache2.internal.Record;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
@Singleton
public final class EvictExpiredRecordsPersistence extends Action {
    private final String encryptKey;
    private final HasRecordExpired hasRecordExpired;

    @Inject
    public EvictExpiredRecordsPersistence(Memory memory, Persistence persistence, HasRecordExpired hasRecordExpired, String str) {
        super(memory, persistence);
        this.hasRecordExpired = hasRecordExpired;
        this.encryptKey = str;
    }

    public Observable<Integer> startEvictingExpiredRecords() {
        String str;
        for (String str2 : this.persistence.allKeys()) {
            Record recordRetrieveRecord = this.persistence.retrieveRecord(str2, false, this.encryptKey);
            if (recordRetrieveRecord == null && (str = this.encryptKey) != null && !str.isEmpty()) {
                recordRetrieveRecord = this.persistence.retrieveRecord(str2, true, this.encryptKey);
            }
            if (recordRetrieveRecord != null && this.hasRecordExpired.hasRecordExpired(recordRetrieveRecord)) {
                this.persistence.evict(str2);
            }
        }
        return Observable.just(1);
    }
}
