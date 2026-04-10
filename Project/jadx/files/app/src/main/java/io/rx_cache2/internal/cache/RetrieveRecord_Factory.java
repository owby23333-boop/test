package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class RetrieveRecord_Factory implements b<RetrieveRecord> {
    private final a<String> encryptKeyProvider;
    private final a<EvictRecord> evictRecordProvider;
    private final a<HasRecordExpired> hasRecordExpiredProvider;
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public RetrieveRecord_Factory(a<Memory> aVar, a<Persistence> aVar2, a<EvictRecord> aVar3, a<HasRecordExpired> aVar4, a<String> aVar5) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
        this.evictRecordProvider = aVar3;
        this.hasRecordExpiredProvider = aVar4;
        this.encryptKeyProvider = aVar5;
    }

    public static RetrieveRecord_Factory create(a<Memory> aVar, a<Persistence> aVar2, a<EvictRecord> aVar3, a<HasRecordExpired> aVar4, a<String> aVar5) {
        return new RetrieveRecord_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    @Override // javax.inject.a, dagger.a
    public RetrieveRecord get() {
        return new RetrieveRecord(this.memoryProvider.get(), this.persistenceProvider.get(), this.evictRecordProvider.get(), this.hasRecordExpiredProvider.get(), this.encryptKeyProvider.get());
    }
}
