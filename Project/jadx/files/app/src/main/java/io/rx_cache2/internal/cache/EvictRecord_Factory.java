package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class EvictRecord_Factory implements b<EvictRecord> {
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public EvictRecord_Factory(a<Memory> aVar, a<Persistence> aVar2) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
    }

    public static EvictRecord_Factory create(a<Memory> aVar, a<Persistence> aVar2) {
        return new EvictRecord_Factory(aVar, aVar2);
    }

    @Override // javax.inject.a, dagger.a
    public EvictRecord get() {
        return new EvictRecord(this.memoryProvider.get(), this.persistenceProvider.get());
    }
}
