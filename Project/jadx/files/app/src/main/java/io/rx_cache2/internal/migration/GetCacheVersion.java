package io.rx_cache2.internal.migration;

import io.reactivex.Observable;
import io.rx_cache2.internal.Persistence;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
final class GetCacheVersion extends CacheVersion {
    @Inject
    public GetCacheVersion(Persistence persistence) {
        super(persistence);
    }

    Observable<Integer> react() {
        Integer num = (Integer) this.persistence.retrieve("key_cache_version", Integer.class, false, null);
        return Observable.just(Integer.valueOf(num != null ? num.intValue() : 0));
    }
}
