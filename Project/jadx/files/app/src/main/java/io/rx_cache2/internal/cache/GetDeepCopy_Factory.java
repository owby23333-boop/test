package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class GetDeepCopy_Factory implements b<GetDeepCopy> {
    private final a<JolyglotGenerics> jolyglotProvider;
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public GetDeepCopy_Factory(a<Memory> aVar, a<Persistence> aVar2, a<JolyglotGenerics> aVar3) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
        this.jolyglotProvider = aVar3;
    }

    public static GetDeepCopy_Factory create(a<Memory> aVar, a<Persistence> aVar2, a<JolyglotGenerics> aVar3) {
        return new GetDeepCopy_Factory(aVar, aVar2, aVar3);
    }

    @Override // javax.inject.a, dagger.a
    public GetDeepCopy get() {
        return new GetDeepCopy(this.memoryProvider.get(), this.persistenceProvider.get(), this.jolyglotProvider.get());
    }
}
