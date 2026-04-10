package com.bytedance.sdk.component.adexpress.bf;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class xu {
    private String bf;
    private Map<String, String> bh;
    private double cv;
    private v d;
    private int dt;
    private JSONObject e;
    private int f;
    private String ga;
    private int k;
    private int l;
    private long m;
    private String p;
    private int pe;
    private boolean s;
    private int t;
    private int tg;
    private boolean v;
    private String vn;
    private String w;
    private int wu;
    private String xu;
    private String y;
    private int zk;

    public static class e {
        private String bf;
        private Map<String, String> bh;
        private double cv;
        private v d;
        private int dt;
        private JSONObject e;
        private int f;
        private String ga;
        private int k;
        private int l;
        private long m;
        private String p;
        private int pe;
        private boolean s;
        private int t;
        private int tg;
        private boolean v;
        private String vn;
        private String w;
        private int wu;
        private String xu;
        private String y;
        private int zk;

        public e bf(String str) {
            this.ga = str;
            return this;
        }

        public e d(String str) {
            this.vn = str;
            return this;
        }

        public e e(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public e ga(String str) {
            this.xu = str;
            return this;
        }

        public e p(int i) {
            this.k = i;
            return this;
        }

        public e tg(String str) {
            this.p = str;
            return this;
        }

        public e v(int i) {
            this.dt = i;
            return this;
        }

        public e vn(int i) {
            this.f = i;
            return this;
        }

        public e zk(int i) {
            this.pe = i;
            return this;
        }

        public e bf(int i) {
            this.zk = i;
            return this;
        }

        public e d(int i) {
            this.wu = i;
            return this;
        }

        public e e(String str) {
            this.bf = str;
            return this;
        }

        public e ga(int i) {
            this.l = i;
            return this;
        }

        public e tg(int i) {
            this.t = i;
            return this;
        }

        public e vn(String str) {
            this.y = str;
            return this;
        }

        public e e(v vVar) {
            this.d = vVar;
            return this;
        }

        public e e(int i) {
            this.tg = i;
            return this;
        }

        public e e(boolean z) {
            this.v = z;
            return this;
        }

        public e e(long j) {
            this.m = j;
            return this;
        }

        public e e(Map<String, String> map) {
            this.bh = map;
            return this;
        }

        public xu e() {
            return new xu(this);
        }
    }

    public xu(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d;
        this.tg = eVar.tg;
        this.ga = eVar.ga;
        this.vn = eVar.vn;
        this.p = eVar.p;
        this.v = eVar.v;
        this.zk = eVar.zk;
        this.m = eVar.m;
        this.wu = eVar.wu;
        this.xu = eVar.xu;
        this.bh = eVar.bh;
        this.t = eVar.t;
        this.s = eVar.s;
        this.w = eVar.w;
        this.l = eVar.l;
        this.f = eVar.f;
        this.k = eVar.k;
        this.dt = eVar.dt;
        this.pe = eVar.pe;
        this.y = eVar.y;
        this.cv = eVar.cv;
    }

    public JSONObject bf() {
        return this.e;
    }

    public int bh() {
        return this.l;
    }

    public String d() {
        return this.bf;
    }

    public double e() {
        return this.cv;
    }

    public int ga() {
        return this.tg;
    }

    public int l() {
        return this.pe;
    }

    public int m() {
        return this.t;
    }

    public long p() {
        return this.m;
    }

    public int s() {
        return this.k;
    }

    public int t() {
        return this.f;
    }

    public v tg() {
        return this.d;
    }

    public int v() {
        return this.wu;
    }

    public boolean vn() {
        return this.v;
    }

    public int w() {
        return this.dt;
    }

    public boolean wu() {
        return this.s;
    }

    public String xu() {
        return this.w;
    }

    public Map<String, String> zk() {
        return this.bh;
    }

    public void e(int i) {
        this.tg = i;
    }
}
