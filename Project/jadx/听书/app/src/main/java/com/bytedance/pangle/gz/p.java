package com.bytedance.pangle.gz;

/* JADX INFO: loaded from: classes2.dex */
public class p extends Exception {
    public final int z;

    public p(int i, String str) {
        super(str);
        this.z = i;
    }

    public p(int i, String str, Throwable th) {
        super(str, th);
        this.z = i;
    }
}
