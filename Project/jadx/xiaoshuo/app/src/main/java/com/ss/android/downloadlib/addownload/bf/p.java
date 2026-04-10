package com.ss.android.downloadlib.addownload.bf;

/* JADX INFO: loaded from: classes4.dex */
public class p {
    private int bf;
    private String d;
    private int e;

    public p(int i) {
        this(i, 0, null);
    }

    public String bf() {
        return this.d;
    }

    public int e() {
        return this.bf;
    }

    public int getType() {
        return this.e;
    }

    public p(int i, int i2) {
        this(i, i2, null);
    }

    public p(int i, String str) {
        this(i, 0, str);
    }

    public p(int i, int i2, String str) {
        this.e = i;
        this.bf = i2;
        this.d = str;
    }
}
