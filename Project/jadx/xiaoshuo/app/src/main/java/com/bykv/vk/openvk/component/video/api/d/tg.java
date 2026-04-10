package com.bykv.vk.openvk.component.video.api.d;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class tg implements Serializable {
    public int bf;
    private int bh;
    private int dt;
    public String e;
    private boolean f;
    private d ga;
    private int k;
    private boolean l;
    private int p;
    private String s;
    private List<String> t;
    private d tg;
    private String vn;
    private long w;
    private String wu;
    private int xu;
    private int v = 204800;
    private int zk = 0;
    private int m = 0;
    public final HashMap<String, Object> d = new HashMap<>();
    private int pe = 10000;
    private int y = 10000;
    private int cv = 10000;
    private int wl = 0;
    private JSONObject za = new JSONObject();

    public tg(String str, d dVar, d dVar2, int i, int i2) {
        this.k = 0;
        this.dt = 0;
        this.vn = str;
        this.tg = dVar;
        this.ga = dVar2;
        this.k = i;
        this.dt = i2;
    }

    public int bf() {
        return this.za.optInt("pitaya_cache_size", 0);
    }

    public boolean bh() {
        if (t()) {
            return this.ga.cv();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.cv();
        }
        return true;
    }

    public d cv() {
        return this.tg;
    }

    public int d() {
        return this.za.optInt("pitaya_code", 0);
    }

    public int dt() {
        return this.y;
    }

    public JSONObject e() {
        return this.za;
    }

    public int f() {
        return this.k;
    }

    public String ga() {
        return this.vn;
    }

    public int k() {
        return this.pe;
    }

    public String l() {
        if (t()) {
            return this.ga.s();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.s();
        }
        return null;
    }

    public long m() {
        return this.w;
    }

    public boolean p() {
        return this.f;
    }

    public int pe() {
        return this.cv;
    }

    public float s() {
        if (t()) {
            return this.ga.v();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.v();
        }
        return -1.0f;
    }

    public boolean t() {
        return this.k == 1 && this.dt == 1 && this.ga != null;
    }

    public String tg() {
        return this.za.optString("pitaya_msg");
    }

    public int v() {
        return this.xu;
    }

    public int vn() {
        if (t()) {
            return this.ga.w();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.w();
        }
        return 0;
    }

    public String w() {
        if (t()) {
            return this.ga.xu();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.xu();
        }
        return null;
    }

    public d wl() {
        return this.ga;
    }

    public boolean wu() {
        return this.l;
    }

    public long xu() {
        if (t()) {
            return this.ga.ga();
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar.ga();
        }
        return 0L;
    }

    public int y() {
        return this.wl;
    }

    public d za() {
        if (t()) {
            return this.ga;
        }
        d dVar = this.tg;
        if (dVar != null) {
            return dVar;
        }
        return null;
    }

    public int zk() {
        return this.bh;
    }

    public void bf(String str) {
        this.wu = str;
    }

    public void d(int i) {
        this.bh = i;
    }

    public void e(String str) {
        this.vn = str;
    }

    public void ga(int i) {
        this.k = i;
    }

    public void p(int i) {
        this.y = i;
    }

    public void tg(String str) {
        this.e = str;
    }

    public void v(int i) {
        this.cv = i;
    }

    public void zk(int i) {
        this.wl = i;
    }

    public void bf(int i) {
        this.xu = i;
    }

    public void d(String str) {
        this.s = str;
    }

    public void e(int i) {
        this.p = i;
    }

    public synchronized Object ga(String str) {
        return this.d.get(str);
    }

    public void tg(int i) {
        this.bf = i;
    }

    public void bf(boolean z) {
        this.l = z;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public void e(List<String> list) {
        this.t = list;
    }

    public void vn(int i) {
        this.pe = i;
    }

    public void e(long j) {
        this.w = j;
    }

    public synchronized void e(String str, Object obj) {
        this.d.put(str, obj);
    }
}
