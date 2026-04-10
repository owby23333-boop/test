package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvidePersistenceFactory implements b<Persistence> {
    private final a<Disk> diskProvider;
    private final RxCacheModule module;

    public RxCacheModule_ProvidePersistenceFactory(RxCacheModule rxCacheModule, a<Disk> aVar) {
        this.module = rxCacheModule;
        this.diskProvider = aVar;
    }

    public static RxCacheModule_ProvidePersistenceFactory create(RxCacheModule rxCacheModule, a<Disk> aVar) {
        return new RxCacheModule_ProvidePersistenceFactory(rxCacheModule, aVar);
    }

    public static Persistence proxyProvidePersistence(RxCacheModule rxCacheModule, Disk disk) {
        Persistence persistenceProvidePersistence = rxCacheModule.providePersistence(disk);
        d.a(persistenceProvidePersistence, "Cannot return null from a non-@Nullable @Provides method");
        return persistenceProvidePersistence;
    }

    @Override // javax.inject.a, dagger.a
    public Persistence get() {
        Persistence persistenceProvidePersistence = this.module.providePersistence(this.diskProvider.get());
        d.a(persistenceProvidePersistence, "Cannot return null from a non-@Nullable @Provides method");
        return persistenceProvidePersistence;
    }
}
