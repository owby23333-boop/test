package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_UseExpiredDataIfLoaderNotAvailableFactory implements b<Boolean> {
    private final RxCacheModule module;

    public RxCacheModule_UseExpiredDataIfLoaderNotAvailableFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_UseExpiredDataIfLoaderNotAvailableFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_UseExpiredDataIfLoaderNotAvailableFactory(rxCacheModule);
    }

    public static Boolean proxyUseExpiredDataIfLoaderNotAvailable(RxCacheModule rxCacheModule) {
        Boolean boolUseExpiredDataIfLoaderNotAvailable = rxCacheModule.useExpiredDataIfLoaderNotAvailable();
        d.a(boolUseExpiredDataIfLoaderNotAvailable, "Cannot return null from a non-@Nullable @Provides method");
        return boolUseExpiredDataIfLoaderNotAvailable;
    }

    @Override // javax.inject.a, dagger.a
    public Boolean get() {
        Boolean boolUseExpiredDataIfLoaderNotAvailable = this.module.useExpiredDataIfLoaderNotAvailable();
        d.a(boolUseExpiredDataIfLoaderNotAvailable, "Cannot return null from a non-@Nullable @Provides method");
        return boolUseExpiredDataIfLoaderNotAvailable;
    }
}
