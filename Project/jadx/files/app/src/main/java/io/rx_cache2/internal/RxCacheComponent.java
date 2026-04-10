package io.rx_cache2.internal;

import dagger.Component;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
@Component(modules = {RxCacheModule.class})
@Singleton
public interface RxCacheComponent {
    ProcessorProviders providers();
}
