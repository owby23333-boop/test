package io.rx_cache2.internal.migration;

import dagger.internal.b;

/* JADX INFO: loaded from: classes3.dex */
public final class GetPendingMigrations_Factory implements b<GetPendingMigrations> {
    private static final GetPendingMigrations_Factory INSTANCE = new GetPendingMigrations_Factory();

    public static GetPendingMigrations_Factory create() {
        return INSTANCE;
    }

    public static GetPendingMigrations newGetPendingMigrations() {
        return new GetPendingMigrations();
    }

    @Override // javax.inject.a, dagger.a
    public GetPendingMigrations get() {
        return new GetPendingMigrations();
    }
}
