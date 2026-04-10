package com.ss.android.socialbase.downloader.zk;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class v<K, T> extends LinkedHashMap<K, T> {
    private int e;

    public v() {
        this(4, 4);
    }

    public void e(int i) {
        this.e = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.e;
    }

    public v(int i, int i2) {
        this(i, i2, true);
    }

    public v(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        e(i2);
    }
}
