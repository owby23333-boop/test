package com.bytedance.msdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f365a;
    private String dl;
    private String g;
    private int gc;
    private String m;
    private String z;

    public String z() {
        return this.f365a;
    }

    public g z(String str) {
        this.f365a = str;
        return this;
    }

    public String g() {
        return this.z;
    }

    public g g(String str) {
        this.z = str;
        return this;
    }

    public String dl() {
        return this.g;
    }

    public g dl(String str) {
        this.g = str;
        return this;
    }

    public String a() {
        return this.dl;
    }

    public g a(String str) {
        this.dl = str;
        return this;
    }

    public int gc() {
        return this.gc;
    }

    public g z(int i) {
        this.gc = i;
        return this;
    }

    public String m() {
        return this.m;
    }

    public g gc(String str) {
        this.m = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.z + "', adnName='" + this.g + "', customAdnName='" + this.dl + "', adType='" + this.f365a + "', errCode=" + this.gc + ", errMsg=" + this.m + '}';
    }
}
