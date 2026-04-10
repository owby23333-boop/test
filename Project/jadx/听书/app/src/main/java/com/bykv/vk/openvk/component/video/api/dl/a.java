package com.bykv.vk.openvk.component.video.api.dl;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl f96a;
    private int e;
    private boolean fv;
    public int g;
    private dl gc;
    private int i;
    private int js;
    private String kb;
    private long ls;
    private String m;
    private boolean p;
    private String pf;
    private int tb;
    private List<String> v;
    private int wp;
    public String z;
    private int gz = 204800;
    private int fo = 0;
    private int uy = 0;
    public final HashMap<String, Object> dl = new HashMap<>();
    private int q = 10000;
    private int iq = 10000;
    private int zw = 10000;
    private int io = 0;
    private JSONObject uf = new JSONObject();

    public a(String str, dl dlVar, dl dlVar2, int i, int i2) {
        this.js = 0;
        this.tb = 0;
        this.m = str;
        this.f96a = dlVar;
        this.gc = dlVar2;
        this.js = i;
        this.tb = i2;
    }

    public JSONObject z() {
        return this.uf;
    }

    public int g() {
        return this.uf.optInt("pitaya_cache_size", 0);
    }

    public int dl() {
        return this.uf.optInt("pitaya_code", 0);
    }

    public String a() {
        return this.uf.optString("pitaya_msg");
    }

    public String gc() {
        return this.m;
    }

    public void z(String str) {
        this.m = str;
    }

    public void z(int i) {
        this.e = i;
    }

    public int m() {
        if (v()) {
            return this.gc.ls();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.ls();
        }
        return 0;
    }

    public boolean e() {
        return this.fv;
    }

    public void z(boolean z) {
        this.fv = z;
    }

    public void g(String str) {
        this.kb = str;
    }

    public int gz() {
        return this.wp;
    }

    public void g(int i) {
        this.wp = i;
    }

    public int fo() {
        return this.i;
    }

    public void dl(int i) {
        this.i = i;
    }

    public void z(List<String> list) {
        this.v = list;
    }

    public void dl(String str) {
        this.pf = str;
    }

    public long uy() {
        return this.ls;
    }

    public void z(long j) {
        this.ls = j;
    }

    public boolean kb() {
        return this.p;
    }

    public void g(boolean z) {
        this.p = z;
    }

    public long wp() {
        if (v()) {
            return this.gc.gc();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.gc();
        }
        return 0L;
    }

    public boolean i() {
        if (v()) {
            return this.gc.zw();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.zw();
        }
        return true;
    }

    public void a(String str) {
        this.z = str;
    }

    public void a(int i) {
        this.g = i;
    }

    public boolean v() {
        dl dlVar;
        return this.tb == 1 && (dlVar = this.gc) != null && !TextUtils.isEmpty(dlVar.wp()) && (com.bykv.vk.openvk.component.video.api.dl.gc() == 2 || this.js == 1);
    }

    public float pf() {
        if (v()) {
            return this.gc.gz();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.gz();
        }
        return -1.0f;
    }

    public String ls() {
        if (v()) {
            return this.gc.wp();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.wp();
        }
        return null;
    }

    public String p() {
        if (v()) {
            return this.gc.pf();
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar.pf();
        }
        return null;
    }

    public int fv() {
        return this.js;
    }

    public void gc(int i) {
        this.js = i;
    }

    public synchronized void z(String str, Object obj) {
        this.dl.put(str, obj);
    }

    public synchronized Object gc(String str) {
        return this.dl.get(str);
    }

    public int js() {
        return this.q;
    }

    public void m(int i) {
        this.q = i;
    }

    public int tb() {
        return this.iq;
    }

    public void e(int i) {
        this.iq = i;
    }

    public int q() {
        return this.zw;
    }

    public void gz(int i) {
        this.zw = i;
    }

    public int iq() {
        return this.io;
    }

    public void fo(int i) {
        this.io = i;
    }

    public dl zw() {
        return this.f96a;
    }

    public dl io() {
        return this.gc;
    }

    public dl uf() {
        if (v()) {
            return this.gc;
        }
        dl dlVar = this.f96a;
        if (dlVar != null) {
            return dlVar;
        }
        return null;
    }
}
