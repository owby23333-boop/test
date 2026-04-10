package com.ss.android.g.z.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g implements com.ss.android.z.z.dl.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f2026a;
    protected String dl;
    protected String e;
    protected int fo;
    protected String g;
    protected String gc;
    protected String gz;
    protected transient Object i;
    protected String m;
    protected JSONObject pf;
    protected JSONObject v;
    protected String wp;
    protected String z;
    protected boolean uy = true;
    protected boolean kb = false;

    @Override // com.ss.android.z.z.dl.g
    public String z() {
        return this.wp;
    }

    @Override // com.ss.android.z.z.dl.g
    public String g() {
        return this.z;
    }

    @Override // com.ss.android.z.z.dl.g
    public String dl() {
        return this.g;
    }

    @Override // com.ss.android.z.z.dl.g
    public String a() {
        return this.dl;
    }

    @Override // com.ss.android.z.z.dl.g
    public String gc() {
        return this.f2026a;
    }

    @Override // com.ss.android.z.z.dl.g
    public String m() {
        return this.gc;
    }

    @Override // com.ss.android.z.z.dl.g
    public String e() {
        return this.m;
    }

    @Override // com.ss.android.z.z.dl.g
    public String gz() {
        return this.e;
    }

    @Override // com.ss.android.z.z.dl.g
    public String fo() {
        return this.gz;
    }

    @Override // com.ss.android.z.z.dl.g
    public Object uy() {
        return this.i;
    }

    @Override // com.ss.android.z.z.dl.g
    public int kb() {
        return this.fo;
    }

    @Override // com.ss.android.z.z.dl.g
    public boolean wp() {
        return this.uy;
    }

    @Override // com.ss.android.z.z.dl.g
    public boolean i() {
        return this.kb;
    }

    @Override // com.ss.android.z.z.dl.g
    public JSONObject v() {
        return this.v;
    }

    @Override // com.ss.android.z.z.dl.g
    public JSONObject pf() {
        return this.pf;
    }

    public void z(Object obj) {
        this.i = obj;
    }

    public void g(String str) {
        this.z = str;
    }

    public void z(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public void g(JSONObject jSONObject) {
        this.pf = jSONObject;
    }

    public void dl(String str) {
        this.g = str;
    }

    @Override // com.ss.android.z.z.dl.g
    public void z(int i) {
        this.fo = i;
    }

    @Override // com.ss.android.z.z.dl.g
    public void z(String str) {
        this.wp = str;
    }

    public static final class z {
        g z = new g();

        @Deprecated
        public z g(boolean z) {
            return this;
        }

        @Deprecated
        public z gz(String str) {
            return this;
        }

        public z z(String str) {
            this.z.z = str;
            return this;
        }

        public z g(String str) {
            this.z.g = str;
            return this;
        }

        public z dl(String str) {
            this.z.dl = str;
            return this;
        }

        public z a(String str) {
            this.z.f2026a = str;
            return this;
        }

        public z gc(String str) {
            this.z.gc = str;
            return this;
        }

        public z m(String str) {
            this.z.m = str;
            return this;
        }

        public z e(String str) {
            this.z.e = str;
            return this;
        }

        public z fo(String str) {
            this.z.gz = str;
            return this;
        }

        public z z(Object obj) {
            this.z.i = obj;
            return this;
        }

        public z z(int i) {
            this.z.fo = i;
            return this;
        }

        public z z(boolean z) {
            this.z.uy = z;
            return this;
        }

        public z dl(boolean z) {
            this.z.kb = z;
            return this;
        }

        public z uy(String str) {
            this.z.wp = str;
            return this;
        }

        public z z(JSONObject jSONObject) {
            this.z.v = jSONObject;
            return this;
        }

        public z g(JSONObject jSONObject) {
            this.z.pf = jSONObject;
            return this;
        }

        public g z() {
            return this.z;
        }
    }
}
