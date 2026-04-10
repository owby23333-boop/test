package com.bytedance.msdk.gc;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f466a;
    public String dl;
    public String e;
    public long fo;
    public long fv;
    public String g;
    public String gc;
    public String gz;
    public String i;
    public String kb;
    public String ls;
    public String m;
    public int p;
    public String pf;
    public String q;
    public String uy;
    public int v;
    public String wp;
    public String z;
    public int js = -1;
    public int tb = -1;
    public Map<String, Object> iq = new ConcurrentHashMap();
    private long zw = -1;

    protected a() {
    }

    public a z(int i) {
        this.i = String.valueOf(i);
        return this;
    }

    public a z(long j) {
        this.fv = j;
        return this;
    }

    public a z(String str) {
        this.z = str;
        return this;
    }

    public a g(String str) {
        this.gz = str;
        return this;
    }

    public a g(long j) {
        this.fo = j;
        return this;
    }

    public a dl(String str) {
        this.uy = str;
        return this;
    }

    public a a(String str) {
        this.g = str;
        return this;
    }

    public a gc(String str) {
        this.dl = str;
        return this;
    }

    public a m(String str) {
        this.f466a = str;
        return this;
    }

    public a e(String str) {
        this.gc = str;
        return this;
    }

    public a gz(String str) {
        this.m = str;
        return this;
    }

    public a fo(String str) {
        this.e = str;
        return this;
    }

    public a uy(String str) {
        this.kb = str;
        return this;
    }

    public a g(int i) {
        this.v = i;
        return this;
    }

    public a dl(int i) {
        this.pf = String.valueOf(i);
        return this;
    }

    public a a(int i) {
        this.ls = String.valueOf(i);
        return this;
    }

    public a gc(int i) {
        this.p = i;
        return this;
    }

    public a setResult(int i) {
        this.js = i;
        return this;
    }

    public a m(int i) {
        this.tb = i;
        return this;
    }

    public a kb(String str) {
        this.q = str;
        return this;
    }

    public a z(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.iq.put(str, obj);
        }
        return this;
    }

    public a z(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.iq.putAll(map);
        }
        return this;
    }

    public a dl(long j) {
        this.zw = j;
        return this;
    }

    public long z() {
        return this.zw;
    }

    public static a g() {
        return new a();
    }

    public static a dl() {
        a aVar = new a();
        aVar.dl(System.currentTimeMillis());
        return aVar;
    }
}
