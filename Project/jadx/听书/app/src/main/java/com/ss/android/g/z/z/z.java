package com.ss.android.g.z.z;

import com.ss.android.z.z.g.gz;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z implements com.ss.android.z.z.dl.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f2027a;
    protected boolean dl;
    protected JSONObject e;
    protected boolean fo;
    protected int g;
    protected boolean gc;
    protected Object ls;
    protected int m;
    protected Object pf;
    protected int z;
    protected boolean gz = true;
    protected boolean uy = true;
    protected boolean kb = true;
    protected boolean wp = true;
    protected boolean i = true;
    protected gz v = null;

    @Override // com.ss.android.z.z.dl.z
    public boolean gc() {
        return false;
    }

    @Override // com.ss.android.z.z.dl.z
    public int m() {
        return 1;
    }

    @Override // com.ss.android.z.z.dl.z
    public int z() {
        return this.z;
    }

    @Override // com.ss.android.z.z.dl.z
    public int g() {
        return this.g;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean dl() {
        return this.dl;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean a() {
        return this.f2027a;
    }

    @Override // com.ss.android.z.z.dl.z
    public Object e() {
        return this.pf;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean gz() {
        return this.gc;
    }

    @Override // com.ss.android.z.z.dl.z
    public int fo() {
        return this.m;
    }

    @Override // com.ss.android.z.z.dl.z
    public JSONObject uy() {
        return this.e;
    }

    @Override // com.ss.android.z.z.dl.z
    public Object kb() {
        return this.ls;
    }

    @Override // com.ss.android.z.z.dl.z
    public void z(int i) {
        this.g = i;
    }

    @Override // com.ss.android.z.z.dl.z
    public void g(int i) {
        this.z = i;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean wp() {
        return this.gz;
    }

    @Override // com.ss.android.z.z.dl.z
    public void z(boolean z) {
        this.gz = z;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean i() {
        return this.fo;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean v() {
        return this.uy;
    }

    public void dl(boolean z) {
        this.fo = z;
    }

    @Override // com.ss.android.z.z.dl.z
    public void g(boolean z) {
        this.uy = z;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean pf() {
        return this.kb;
    }

    @Override // com.ss.android.z.z.dl.z
    public boolean ls() {
        return this.wp;
    }

    public void z(Object obj) {
        this.ls = obj;
    }

    public void z(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public boolean p() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public gz fv() {
        return this.v;
    }

    public void z(gz gzVar) {
        this.v = gzVar;
    }

    /* JADX INFO: renamed from: com.ss.android.g.z.z.z$z, reason: collision with other inner class name */
    public static final class C0450z {
        z z = new z();

        @Deprecated
        public C0450z dl(boolean z) {
            return this;
        }

        public C0450z z(int i) {
            this.z.z = i;
            return this;
        }

        public C0450z g(int i) {
            this.z.g = i;
            return this;
        }

        public C0450z z(boolean z) {
            this.z.dl = z;
            return this;
        }

        public C0450z g(boolean z) {
            this.z.f2027a = z;
            return this;
        }

        public C0450z a(boolean z) {
            this.z.gc = z;
            return this;
        }

        public C0450z dl(int i) {
            this.z.m = i;
            return this;
        }

        public C0450z z(JSONObject jSONObject) {
            this.z.e = jSONObject;
            return this;
        }

        public C0450z z(Object obj) {
            this.z.ls = obj;
            return this;
        }

        public C0450z gc(boolean z) {
            this.z.gz = z;
            return this;
        }

        public C0450z m(boolean z) {
            this.z.fo = z;
            return this;
        }

        public C0450z e(boolean z) {
            this.z.uy = z;
            return this;
        }

        public C0450z gz(boolean z) {
            this.z.kb = z;
            return this;
        }

        public C0450z fo(boolean z) {
            this.z.wp = z;
            return this;
        }

        public C0450z uy(boolean z) {
            this.z.i = z;
            return this;
        }

        public z z() {
            return this.z;
        }
    }
}
