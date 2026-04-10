package com.ss.android.downloadlib.addownload.g;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    public static int dl = 2;
    public static int g = 1;
    public static int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1985a = z;
    private long gc = 0;
    private JSONObject m = null;
    private int e = 0;
    private String gz = "";
    private String fo = "";

    public boolean z() {
        return this.f1985a == g;
    }

    public int g() {
        return this.e;
    }

    public dl z(int i) {
        this.f1985a = i;
        return this;
    }

    public dl g(int i) {
        this.e = i;
        return this;
    }
}
