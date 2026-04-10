package io.rx_cache2.internal.cache;

import io.rx_cache2.internal.Record;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public final class HasRecordExpired {
    @Inject
    public HasRecordExpired() {
    }

    public boolean hasRecordExpired(Record record) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lifeTime = record.getLifeTime();
        return lifeTime != null && jCurrentTimeMillis > record.getTimeAtWhichWasPersisted() + lifeTime.longValue();
    }
}
