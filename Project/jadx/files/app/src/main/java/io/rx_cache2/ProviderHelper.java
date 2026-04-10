package io.rx_cache2;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes3.dex */
public class ProviderHelper {
    public static <T> Observable<T> withoutLoader() {
        return Observable.error(new RuntimeException());
    }
}
