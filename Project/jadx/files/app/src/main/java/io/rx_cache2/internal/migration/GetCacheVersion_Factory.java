package io.rx_cache2.internal.migration;

import dagger.internal.b;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class GetCacheVersion_Factory implements b<GetCacheVersion> {
    private final a<Persistence> persistenceProvider;

    public GetCacheVersion_Factory(a<Persistence> aVar) {
        this.persistenceProvider = aVar;
    }

    public static GetCacheVersion_Factory create(a<Persistence> aVar) {
        return new GetCacheVersion_Factory(aVar);
    }

    public static GetCacheVersion newGetCacheVersion(Persistence persistence) {
        return new GetCacheVersion(persistence);
    }

    @Override // javax.inject.a, dagger.a
    public GetCacheVersion get() {
        return new GetCacheVersion(this.persistenceProvider.get());
    }
}
