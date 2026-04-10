package com.bytedance.sdk.openadsdk.core.lc;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    public String e;
    public List<String> k;
    public int bf = 1;
    public int d = 1;
    public int tg = 2;
    public int ga = 1;
    public int vn = 0;
    public int p = 1;
    public int v = 3;
    public int zk = 0;
    public int m = 0;
    public int wu = 2;
    public int xu = 1;
    public int bh = 0;
    public int t = 1500;
    public int s = 0;
    public int w = 2000;
    public int l = 0;
    public boolean f = false;
    public int dt = 2;
    public int pe = 100;
    public int y = 0;
    public int cv = 0;
    public boolean wl = false;
    public boolean za = false;
    public long lc = 0;

    private e() {
    }

    public static e e() {
        return new e();
    }

    public e bf(boolean z) {
        this.za = z;
        return this;
    }

    public e bh(int i) {
        this.ga = i;
        return this;
    }

    public e d(int i) {
        this.bh = i;
        return this;
    }

    public e dt(int i) {
        this.cv = i;
        return this;
    }

    public e f(int i) {
        this.pe = i;
        return this;
    }

    public e ga(int i) {
        this.s = i;
        return this;
    }

    public e k(int i) {
        this.y = i;
        return this;
    }

    public e l(int i) {
        this.dt = i;
        return this;
    }

    public e m(int i) {
        this.bf = i;
        return this;
    }

    public e p(int i) {
        this.zk = i;
        return this;
    }

    public e s(int i) {
        this.p = i;
        return this;
    }

    public e t(int i) {
        this.vn = i;
        return this;
    }

    public e tg(int i) {
        this.t = i;
        return this;
    }

    public e v(int i) {
        this.m = i;
        return this;
    }

    public e vn(int i) {
        this.wu = i;
        return this;
    }

    public e w(int i) {
        this.xu = i;
        return this;
    }

    public e wu(int i) {
        this.d = i;
        return this;
    }

    public e xu(int i) {
        this.tg = i;
        return this;
    }

    public e zk(int i) {
        this.v = i;
        return this;
    }

    public e bf(int i) {
        this.w = i;
        return this;
    }

    public e d(boolean z) {
        this.f = z;
        return this;
    }

    public e e(boolean z) {
        this.wl = z;
        return this;
    }

    public e e(long j) {
        this.lc = j;
        return this;
    }

    public e e(int i) {
        this.l = i;
        return this;
    }

    public e e(String str) {
        this.e = str;
        return this;
    }

    public e e(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.k = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.k.add(jSONArray.get(i).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
