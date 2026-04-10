package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_ProvideProcessorProvidersFactory implements b<ProcessorProviders> {
    private final RxCacheModule module;
    private final a<ProcessorProvidersBehaviour> processorProvidersBehaviourProvider;

    public RxCacheModule_ProvideProcessorProvidersFactory(RxCacheModule rxCacheModule, a<ProcessorProvidersBehaviour> aVar) {
        this.module = rxCacheModule;
        this.processorProvidersBehaviourProvider = aVar;
    }

    public static RxCacheModule_ProvideProcessorProvidersFactory create(RxCacheModule rxCacheModule, a<ProcessorProvidersBehaviour> aVar) {
        return new RxCacheModule_ProvideProcessorProvidersFactory(rxCacheModule, aVar);
    }

    public static ProcessorProviders proxyProvideProcessorProviders(RxCacheModule rxCacheModule, ProcessorProvidersBehaviour processorProvidersBehaviour) {
        ProcessorProviders processorProvidersProvideProcessorProviders = rxCacheModule.provideProcessorProviders(processorProvidersBehaviour);
        d.a(processorProvidersProvideProcessorProviders, "Cannot return null from a non-@Nullable @Provides method");
        return processorProvidersProvideProcessorProviders;
    }

    @Override // javax.inject.a, dagger.a
    public ProcessorProviders get() {
        ProcessorProviders processorProvidersProvideProcessorProviders = this.module.provideProcessorProviders(this.processorProvidersBehaviourProvider.get());
        d.a(processorProvidersProvideProcessorProviders, "Cannot return null from a non-@Nullable @Provides method");
        return processorProvidersProvideProcessorProviders;
    }
}
