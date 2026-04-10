package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class t {
    private String bf;
    private int d;
    private int e;
    private String ga;
    private double p;
    private double tg;
    private double vn;

    public String bf() {
        return this.bf;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String ga() {
        return this.ga;
    }

    public double p() {
        return this.p;
    }

    public double tg() {
        return this.tg;
    }

    public boolean v() {
        return !TextUtils.isEmpty(this.ga);
    }

    public double vn() {
        return this.vn;
    }

    public void bf(double d) {
        this.vn = d;
    }

    public void d(double d) {
        this.p = d;
    }

    public void e(double d) {
        this.tg = d;
    }

    public void bf(int i) {
        this.d = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public void bf(String str) {
        this.ga = str;
    }

    public void e(String str) {
        this.bf = str;
    }
}
