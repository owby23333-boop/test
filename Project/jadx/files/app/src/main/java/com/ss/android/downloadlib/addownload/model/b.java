package com.ss.android.downloadlib.addownload.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static int b = 2;
    public static int mb = 0;
    public static int ox = 1;
    private int hj = mb;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18006h = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private JSONObject f18007u = null;
    private int ko = 0;
    private String ww = "";
    private String lz = "";

    public boolean mb() {
        return this.hj == ox;
    }

    public int ox() {
        return this.ko;
    }

    public b mb(int i2) {
        this.hj = i2;
        return this;
    }

    public b ox(int i2) {
        this.ko = i2;
        return this;
    }
}
