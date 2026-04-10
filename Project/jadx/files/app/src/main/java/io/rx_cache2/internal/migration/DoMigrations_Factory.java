package io.rx_cache2.internal.migration;

import dagger.internal.b;
import io.rx_cache2.MigrationCache;
import io.rx_cache2.internal.Persistence;
import java.util.List;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DoMigrations_Factory implements b<DoMigrations> {
    private final a<String> encryptKeyProvider;
    private final a<List<MigrationCache>> migrationsProvider;
    private final a<Persistence> persistenceProvider;

    public DoMigrations_Factory(a<Persistence> aVar, a<List<MigrationCache>> aVar2, a<String> aVar3) {
        this.persistenceProvider = aVar;
        this.migrationsProvider = aVar2;
        this.encryptKeyProvider = aVar3;
    }

    public static DoMigrations_Factory create(a<Persistence> aVar, a<List<MigrationCache>> aVar2, a<String> aVar3) {
        return new DoMigrations_Factory(aVar, aVar2, aVar3);
    }

    @Override // javax.inject.a, dagger.a
    public DoMigrations get() {
        return new DoMigrations(this.persistenceProvider.get(), this.migrationsProvider.get(), this.encryptKeyProvider.get());
    }
}
