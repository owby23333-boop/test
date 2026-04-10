package com.ss.android.downloadlib.addownload.g;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private String dl;
    private int g;
    private int z;

    public e(int i) {
        this(i, 0, null);
    }

    public e(int i, int i2) {
        this(i, i2, null);
    }

    public e(int i, String str) {
        this(i, 0, str);
    }

    public e(int i, int i2, String str) {
        this.z = i;
        this.g = i2;
        this.dl = str;
    }

    public int getType() {
        return this.z;
    }

    public int z() {
        return this.g;
    }

    public String g() {
        return this.dl;
    }
}
