package io.rx_cache2.internal.migration;

import dagger.internal.b;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class UpgradeCacheVersion_Factory implements b<UpgradeCacheVersion> {
    private final a<Persistence> persistenceProvider;

    public UpgradeCacheVersion_Factory(a<Persistence> aVar) {
        this.persistenceProvider = aVar;
    }

    public static UpgradeCacheVersion_Factory create(a<Persistence> aVar) {
        return new UpgradeCacheVersion_Factory(aVar);
    }

    public static UpgradeCacheVersion newUpgradeCacheVersion(Persistence persistence) {
        return new UpgradeCacheVersion(persistence);
    }

    @Override // javax.inject.a, dagger.a
    public UpgradeCacheVersion get() {
        return new UpgradeCacheVersion(this.persistenceProvider.get());
    }
}
