package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideEncryptKeyFactory implements b<String> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideEncryptKeyFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideEncryptKeyFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideEncryptKeyFactory(rxCacheModule);
    }

    public static String proxyProvideEncryptKey(RxCacheModule rxCacheModule) {
        String strProvideEncryptKey = rxCacheModule.provideEncryptKey();
        d.a(strProvideEncryptKey, "Cannot return null from a non-@Nullable @Provides method");
        return strProvideEncryptKey;
    }

    @Override // javax.inject.a, dagger.a
    public String get() {
        String strProvideEncryptKey = this.module.provideEncryptKey();
        d.a(strProvideEncryptKey, "Cannot return null from a non-@Nullable @Provides method");
        return strProvideEncryptKey;
    }
}
