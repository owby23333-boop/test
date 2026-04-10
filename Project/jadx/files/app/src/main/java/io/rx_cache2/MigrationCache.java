package io.rx_cache2;

/* JADX INFO: loaded from: classes3.dex */
public final class MigrationCache {
    private final Class[] evictClasses;
    private final int version;

    public MigrationCache(int i2, Class[] clsArr) {
        this.version = i2;
        this.evictClasses = clsArr;
    }

    public Class[] evictClasses() {
        return this.evictClasses;
    }

    public int version() {
        return this.version;
    }
}
