package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import io.rx_cache2.internal.encrypt.Encryptor;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideEncryptorFactory implements b<Encryptor> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideEncryptorFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideEncryptorFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideEncryptorFactory(rxCacheModule);
    }

    public static Encryptor proxyProvideEncryptor(RxCacheModule rxCacheModule) {
        Encryptor encryptorProvideEncryptor = rxCacheModule.provideEncryptor();
        d.a(encryptorProvideEncryptor, "Cannot return null from a non-@Nullable @Provides method");
        return encryptorProvideEncryptor;
    }

    @Override // javax.inject.a, dagger.a
    public Encryptor get() {
        Encryptor encryptorProvideEncryptor = this.module.provideEncryptor();
        d.a(encryptorProvideEncryptor, "Cannot return null from a non-@Nullable @Provides method");
        return encryptorProvideEncryptor;
    }
}
