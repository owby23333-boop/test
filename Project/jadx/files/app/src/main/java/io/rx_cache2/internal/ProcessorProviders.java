package io.rx_cache2.internal;

import io.reactivex.Observable;
import io.rx_cache2.ConfigProvider;

/* JADX INFO: loaded from: classes3.dex */
public interface ProcessorProviders {
    Observable<Void> evictAll();

    <T> Observable<T> process(ConfigProvider configProvider);
}
