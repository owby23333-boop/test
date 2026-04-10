package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import io.rx_cache2.MigrationCache;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideMigrationsFactory implements b<List<MigrationCache>> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideMigrationsFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideMigrationsFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideMigrationsFactory(rxCacheModule);
    }

    public static List<MigrationCache> proxyProvideMigrations(RxCacheModule rxCacheModule) {
        List<MigrationCache> listProvideMigrations = rxCacheModule.provideMigrations();
        d.a(listProvideMigrations, "Cannot return null from a non-@Nullable @Provides method");
        return listProvideMigrations;
    }

    @Override // javax.inject.a, dagger.a
    public List<MigrationCache> get() {
        List<MigrationCache> listProvideMigrations = this.module.provideMigrations();
        d.a(listProvideMigrations, "Cannot return null from a non-@Nullable @Provides method");
        return listProvideMigrations;
    }
}
