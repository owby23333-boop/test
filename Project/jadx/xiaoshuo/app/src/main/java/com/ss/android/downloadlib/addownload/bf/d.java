package com.ss.android.downloadlib.addownload.bf;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static int bf = 1;
    public static int d = 2;
    public static int e;
    private int tg = e;
    private long ga = 0;
    private JSONObject vn = null;
    private int p = 0;
    private String v = "";
    private String zk = "";

    public int bf() {
        return this.p;
    }

    public boolean e() {
        return this.tg == bf;
    }

    public d bf(int i) {
        this.p = i;
        return this;
    }

    public d e(int i) {
        this.tg = i;
        return this;
    }
}
