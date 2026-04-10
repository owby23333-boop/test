package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import io.victoralbertos.jolyglot.JolyglotGenerics;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideJolyglotFactory implements b<JolyglotGenerics> {
    private final RxCacheModule module;

    public RxCacheModule_ProvideJolyglotFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_ProvideJolyglotFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_ProvideJolyglotFactory(rxCacheModule);
    }

    public static JolyglotGenerics proxyProvideJolyglot(RxCacheModule rxCacheModule) {
        JolyglotGenerics jolyglotGenericsProvideJolyglot = rxCacheModule.provideJolyglot();
        d.a(jolyglotGenericsProvideJolyglot, "Cannot return null from a non-@Nullable @Provides method");
        return jolyglotGenericsProvideJolyglot;
    }

    @Override // javax.inject.a, dagger.a
    public JolyglotGenerics get() {
        JolyglotGenerics jolyglotGenericsProvideJolyglot = this.module.provideJolyglot();
        d.a(jolyglotGenericsProvideJolyglot, "Cannot return null from a non-@Nullable @Provides method");
        return jolyglotGenericsProvideJolyglot;
    }
}
