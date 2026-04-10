package com.bytedance.sdk.component.adexpress.g;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fo f578a;
    private String dl;
    private String e;
    private int eo;
    private boolean fo;
    private int fv;
    private gc g;
    private int gc;
    private boolean gk;
    private String gz;
    private JSONObject h;
    private JSONObject hh;
    private String i;
    private double io;
    private int iq;
    private int js;
    private long kb;
    private JSONObject l;
    private final boolean lq;
    private boolean ls;
    private String m;
    private boolean mc;
    private String p;
    private int pf;
    private int q;
    private boolean sy;
    private int tb;
    private String ti;
    private int uf;
    private View un;
    private int uy;
    private Map<String, String> v;
    private int wp;
    private String x;
    private JSONObject z;
    private String zw;

    public i(z zVar) {
        this.mc = true;
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f578a = zVar.f579a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.fo = zVar.fo;
        this.uy = zVar.uy;
        this.kb = zVar.kb;
        this.wp = zVar.wp;
        this.i = zVar.i;
        this.v = zVar.v;
        this.pf = zVar.pf;
        this.ls = zVar.ls;
        this.p = zVar.p;
        this.fv = zVar.fv;
        this.js = zVar.js;
        this.tb = zVar.tb;
        this.q = zVar.q;
        this.iq = zVar.iq;
        this.zw = zVar.zw;
        this.io = zVar.io;
        this.uf = zVar.uf;
        this.sy = zVar.sy;
        this.hh = zVar.hh;
        this.l = zVar.l;
        this.h = zVar.h;
        this.gk = zVar.gk;
        this.x = zVar.x;
        this.lq = zVar.lq;
        this.mc = zVar.mc;
        this.eo = zVar.un;
        this.ti = zVar.eo;
        this.un = zVar.ti;
    }

    public String z() {
        return this.ti;
    }

    public View g() {
        return this.un;
    }

    public boolean dl() {
        return this.sy;
    }

    public double a() {
        return this.io;
    }

    public JSONObject gc() {
        gc gcVar;
        if (this.z == null && (gcVar = this.g) != null) {
            this.z = gcVar.z();
        }
        return this.z;
    }

    public String m() {
        return this.dl;
    }

    public fo e() {
        return this.f578a;
    }

    public int gz() {
        return this.gc;
    }

    public boolean fo() {
        return this.mc;
    }

    public int uy() {
        return this.uf;
    }

    public boolean kb() {
        return this.fo;
    }

    public long wp() {
        return this.kb;
    }

    public int i() {
        return this.wp;
    }

    public Map<String, String> v() {
        return this.v;
    }

    public int pf() {
        return this.pf;
    }

    public boolean ls() {
        return this.ls;
    }

    public String p() {
        return this.p;
    }

    public void z(int i) {
        this.gc = i;
    }

    public int fv() {
        return this.fv;
    }

    public int js() {
        return this.js;
    }

    public int tb() {
        return this.tb;
    }

    public JSONObject q() {
        return this.hh;
    }

    public JSONObject iq() {
        return this.l;
    }

    public JSONObject zw() {
        return this.h;
    }

    public int io() {
        return this.q;
    }

    public int uf() {
        return this.iq;
    }

    public boolean sy() {
        return this.gk;
    }

    public String hh() {
        return this.x;
    }

    public boolean l() {
        return this.lq;
    }

    public int h() {
        return this.eo;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fo f579a;
        private String dl;
        private String e;
        private String eo;
        private boolean fo;
        private int fv;
        private gc g;
        private int gc;
        private boolean gk;
        private String gz;
        private JSONObject h;
        private JSONObject hh;
        private String i;
        private double io;
        private int iq;
        private int js;
        private long kb;
        private JSONObject l;
        private boolean ls;
        private String m;
        private String p;
        private int pf;
        private int q;
        private int tb;
        private View ti;
        private int uf;
        private int un;
        private int uy;
        private Map<String, String> v;
        private int wp;
        private String x;
        private JSONObject z;
        private String zw;
        private boolean sy = true;
        private boolean lq = true;
        private boolean mc = true;

        public z z(boolean z) {
            this.mc = z;
            return this;
        }

        public z z(JSONObject jSONObject) {
            this.z = jSONObject;
            return this;
        }

        public z z(String str) {
            this.dl = str;
            return this;
        }

        public z z(fo foVar) {
            this.f579a = foVar;
            return this;
        }

        public z z(int i) {
            this.gc = i;
            return this;
        }

        public z g(String str) {
            this.m = str;
            return this;
        }

        public z dl(String str) {
            this.e = str;
            return this;
        }

        public z a(String str) {
            this.gz = str;
            return this;
        }

        public z g(boolean z) {
            this.fo = z;
            return this;
        }

        public z g(int i) {
            this.uy = i;
            return this;
        }

        public z dl(int i) {
            this.wp = i;
            return this;
        }

        public z gc(String str) {
            this.i = str;
            return this;
        }

        public z z(Map<String, String> map) {
            this.v = map;
            return this;
        }

        public z a(int i) {
            this.pf = i;
            return this;
        }

        public z m(String str) {
            this.p = str;
            return this;
        }

        public z gc(int i) {
            this.fv = i;
            return this;
        }

        public z m(int i) {
            this.js = i;
            return this;
        }

        public z e(int i) {
            this.tb = i;
            return this;
        }

        public z gz(int i) {
            this.q = i;
            return this;
        }

        public z fo(int i) {
            this.iq = i;
            return this;
        }

        public z e(String str) {
            this.zw = str;
            return this;
        }

        public z dl(boolean z) {
            this.gk = z;
            return this;
        }

        public z gz(String str) {
            this.x = str;
            return this;
        }

        public z uy(int i) {
            this.un = i;
            return this;
        }

        public i z() {
            return new i(this);
        }

        public z g(JSONObject jSONObject) {
            this.hh = jSONObject;
            return this;
        }

        public z dl(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public z a(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public z fo(String str) {
            this.eo = str;
            return this;
        }

        public z z(View view) {
            this.ti = view;
            return this;
        }
    }
}
