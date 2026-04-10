package io.rx_cache2.internal.cache;

import dagger.internal.b;

/* JADX INFO: loaded from: classes3.dex */
public final class HasRecordExpired_Factory implements b<HasRecordExpired> {
    private static final HasRecordExpired_Factory INSTANCE = new HasRecordExpired_Factory();

    public static HasRecordExpired_Factory create() {
        return INSTANCE;
    }

    @Override // javax.inject.a, dagger.a
    public HasRecordExpired get() {
        return new HasRecordExpired();
    }
}
