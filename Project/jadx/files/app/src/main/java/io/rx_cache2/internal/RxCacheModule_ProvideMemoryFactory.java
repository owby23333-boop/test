package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideMemoryFactory implements b<Memory> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideMemoryFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideMemoryFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideMemoryFactory(rxCacheModule);
    }

    public static Memory proxyProvideMemory(RxCacheModule rxCacheModule) {
        Memory memoryProvideMemory = rxCacheModule.provideMemory();
        d.a(memoryProvideMemory, "Cannot return null from a non-@Nullable @Provides method");
        return memoryProvideMemory;
    }

    @Override // javax.inject.a, dagger.a
    public Memory get() {
        Memory memoryProvideMemory = this.module.provideMemory();
        d.a(memoryProvideMemory, "Cannot return null from a non-@Nullable @Provides method");
        return memoryProvideMemory;
    }
}
