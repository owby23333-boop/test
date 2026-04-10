package com.bytedance.sdk.component.v;

import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    final String bf;
    final Map<String, String> d;
    final int e;
    final long ga;
    final String tg;
    private final boolean v;
    final long vn;
    private File p = null;
    private byte[] zk = null;

    public bf(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.v = z;
        this.e = i;
        this.bf = str;
        this.d = map;
        this.tg = str2;
        this.ga = j;
        this.vn = j2;
    }

    public String bf() {
        return this.bf;
    }

    public Map<String, String> d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public long ga() {
        return this.ga;
    }

    public File p() {
        return this.p;
    }

    public String tg() {
        return this.tg;
    }

    public boolean v() {
        return this.v;
    }

    public long vn() {
        return this.vn;
    }

    public long zk() {
        return this.ga - this.vn;
    }

    public void e(File file) {
        this.p = file;
    }
}
