package com.ss.android.socialbase.downloader.pf;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class gz<K, T> extends LinkedHashMap<K, T> {
    private int z;

    public gz() {
        this(4, 4);
    }

    public gz(int i, int i2) {
        this(i, i2, true);
    }

    public gz(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        z(i2);
    }

    public void z(int i) {
        this.z = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.z;
    }
}
