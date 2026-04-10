package io.rx_cache2.internal.cache;

import dagger.internal.b;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class TwoLayersCache_Factory implements b<TwoLayersCache> {
    private final a<EvictRecord> evictRecordProvider;
    private final a<RetrieveRecord> retrieveRecordProvider;
    private final a<SaveRecord> saveRecordProvider;

    public TwoLayersCache_Factory(a<EvictRecord> aVar, a<RetrieveRecord> aVar2, a<SaveRecord> aVar3) {
        this.evictRecordProvider = aVar;
        this.retrieveRecordProvider = aVar2;
        this.saveRecordProvider = aVar3;
    }

    public static TwoLayersCache_Factory create(a<EvictRecord> aVar, a<RetrieveRecord> aVar2, a<SaveRecord> aVar3) {
        return new TwoLayersCache_Factory(aVar, aVar2, aVar3);
    }

    @Override // javax.inject.a, dagger.a
    public TwoLayersCache get() {
        return new TwoLayersCache(this.evictRecordProvider.get(), this.retrieveRecordProvider.get(), this.saveRecordProvider.get());
    }
}
