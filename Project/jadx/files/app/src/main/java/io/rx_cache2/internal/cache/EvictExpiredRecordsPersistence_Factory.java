package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class EvictExpiredRecordsPersistence_Factory implements b<EvictExpiredRecordsPersistence> {
    private final a<String> encryptKeyProvider;
    private final a<HasRecordExpired> hasRecordExpiredProvider;
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public EvictExpiredRecordsPersistence_Factory(a<Memory> aVar, a<Persistence> aVar2, a<HasRecordExpired> aVar3, a<String> aVar4) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
        this.hasRecordExpiredProvider = aVar3;
        this.encryptKeyProvider = aVar4;
    }

    public static EvictExpiredRecordsPersistence_Factory create(a<Memory> aVar, a<Persistence> aVar2, a<HasRecordExpired> aVar3, a<String> aVar4) {
        return new EvictExpiredRecordsPersistence_Factory(aVar, aVar2, aVar3, aVar4);
    }

    @Override // javax.inject.a, dagger.a
    public EvictExpiredRecordsPersistence get() {
        return new EvictExpiredRecordsPersistence(this.memoryProvider.get(), this.persistenceProvider.get(), this.hasRecordExpiredProvider.get(), this.encryptKeyProvider.get());
    }
}
