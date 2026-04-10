package com.bytedance.msdk.api;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f364a;
    private String dl;
    private int e;
    private String fo;
    private String g;
    private String gc;
    private String gz;
    private String i;
    private String kb;
    private String ls;
    private String m;
    private final Map<String, String> p = new HashMap();
    private String pf;
    private String uy;
    private String v;
    private String wp;
    private int z;

    public void z(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.p.clear();
        this.p.putAll(map);
    }

    public Map<String, String> z() {
        return this.p;
    }

    public String g() {
        return this.uy;
    }

    public void z(String str) {
        this.uy = str;
    }

    public String dl() {
        return this.kb;
    }

    public void g(String str) {
        this.kb = str;
    }

    public String a() {
        return this.wp;
    }

    public void dl(String str) {
        this.wp = str;
    }

    public String gc() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }

    public String m() {
        return this.v;
    }

    public void gc(String str) {
        this.v = str;
    }

    public String e() {
        return this.pf;
    }

    public void m(String str) {
        this.pf = str;
    }

    public String gz() {
        return this.ls;
    }

    public void e(String str) {
        this.ls = str;
    }

    public String fo() {
        return this.g;
    }

    public void gz(String str) {
        this.g = str;
    }

    public String uy() {
        return this.dl;
    }

    public void fo(String str) {
        this.dl = str;
    }

    public void z(int i) {
        this.z = i;
    }

    public String kb() {
        return this.f364a;
    }

    public void uy(String str) {
        this.f364a = str;
    }

    public String wp() {
        return TextUtils.isEmpty(this.dl) ? this.g : this.dl;
    }

    public String i() {
        return this.m;
    }

    public void kb(String str) {
        this.m = str;
    }

    public String v() {
        return this.gc;
    }

    public void wp(String str) {
        this.gc = str;
    }

    public int pf() {
        return this.e;
    }

    public void g(int i) {
        this.e = i;
    }

    public String ls() {
        return this.gz;
    }

    public void i(String str) {
        this.gz = str;
    }

    public String p() {
        return this.fo;
    }

    public void v(String str) {
        this.fo = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.z + "', mSlotId='" + this.f364a + "', mLevelTag='" + this.gc + "', mEcpm=" + this.m + ", mReqBiddingType=" + this.e + "', mRequestId=" + this.fo + ", mSubRitType=" + this.kb + '}';
    }
}
