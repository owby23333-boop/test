package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideCacheDirectoryFactory implements b<File> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideCacheDirectoryFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideCacheDirectoryFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideCacheDirectoryFactory(rxCacheModule);
    }

    public static File proxyProvideCacheDirectory(RxCacheModule rxCacheModule) {
        File fileProvideCacheDirectory = rxCacheModule.provideCacheDirectory();
        d.a(fileProvideCacheDirectory, "Cannot return null from a non-@Nullable @Provides method");
        return fileProvideCacheDirectory;
    }

    @Override // javax.inject.a, dagger.a
    public File get() {
        File fileProvideCacheDirectory = this.module.provideCacheDirectory();
        d.a(fileProvideCacheDirectory, "Cannot return null from a non-@Nullable @Provides method");
        return fileProvideCacheDirectory;
    }
}
