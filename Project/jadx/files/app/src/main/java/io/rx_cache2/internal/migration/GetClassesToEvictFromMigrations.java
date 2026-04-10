package io.rx_cache2.internal.migration;

import io.reactivex.Observable;
import io.rx_cache2.MigrationCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
final class GetClassesToEvictFromMigrations {
    private List<MigrationCache> migrations;

    @Inject
    public GetClassesToEvictFromMigrations() {
    }

    private boolean isAlreadyAdded(List<Class> list, Class cls) {
        Iterator<Class> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    Observable<List<Class>> react() {
        ArrayList arrayList = new ArrayList();
        Iterator<MigrationCache> it = this.migrations.iterator();
        while (it.hasNext()) {
            for (Class cls : it.next().evictClasses()) {
                if (!isAlreadyAdded(arrayList, cls)) {
                    arrayList.add(cls);
                }
            }
        }
        return Observable.just(arrayList);
    }

    GetClassesToEvictFromMigrations with(List<MigrationCache> list) {
        this.migrations = list;
        return this;
    }
}
