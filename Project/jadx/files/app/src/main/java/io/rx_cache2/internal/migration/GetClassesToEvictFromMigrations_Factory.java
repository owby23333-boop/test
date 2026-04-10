package io.rx_cache2.internal.migration;

import dagger.internal.b;

/* JADX INFO: loaded from: classes3.dex */
public final class GetClassesToEvictFromMigrations_Factory implements b<GetClassesToEvictFromMigrations> {
    private static final GetClassesToEvictFromMigrations_Factory INSTANCE = new GetClassesToEvictFromMigrations_Factory();

    public static GetClassesToEvictFromMigrations_Factory create() {
        return INSTANCE;
    }

    public static GetClassesToEvictFromMigrations newGetClassesToEvictFromMigrations() {
        return new GetClassesToEvictFromMigrations();
    }

    @Override // javax.inject.a, dagger.a
    public GetClassesToEvictFromMigrations get() {
        return new GetClassesToEvictFromMigrations();
    }
}
