package io.rx_cache2.internal.migration;

import io.reactivex.Observable;
import io.rx_cache2.MigrationCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
final class GetPendingMigrations {
    private int cacheVersion;
    private List<MigrationCache> migrations;

    @Inject
    GetPendingMigrations() {
    }

    public Observable<List<MigrationCache>> react() {
        List<MigrationCache> list = this.migrations;
        if (list == null || list.isEmpty()) {
            return Observable.just(new ArrayList());
        }
        Collections.sort(this.migrations, new Comparator<MigrationCache>() { // from class: io.rx_cache2.internal.migration.GetPendingMigrations.1
            @Override // java.util.Comparator
            public int compare(MigrationCache migrationCache, MigrationCache migrationCache2) {
                return migrationCache.version() - migrationCache2.version();
            }
        });
        ArrayList arrayList = new ArrayList();
        for (MigrationCache migrationCache : this.migrations) {
            if (this.cacheVersion < migrationCache.version()) {
                arrayList.add(migrationCache);
            }
        }
        return Observable.just(arrayList);
    }

    GetPendingMigrations with(int i2, List<MigrationCache> list) {
        this.cacheVersion = i2;
        this.migrations = list;
        return this;
    }
}
