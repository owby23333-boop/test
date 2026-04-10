package com.yuewen;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class gh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11567b;
    public long c;
    public String d;
    public long e;

    public gh0(long j, long j2, long j3, String str, long j4) {
        this.f11566a = j;
        this.f11567b = j2;
        this.c = j3;
        this.d = str;
        this.e = j4;
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.e;
    }

    public String c() {
        return this.d;
    }

    public long d() {
        return this.f11566a;
    }

    public long e() {
        return this.f11567b;
    }

    public boolean f(gh0 gh0Var) {
        if (gh0Var == null) {
            return false;
        }
        if (this.f11566a > gh0Var.d()) {
            return true;
        }
        if (this.f11566a < gh0Var.d()) {
            return false;
        }
        if (this.e > gh0Var.b()) {
            return true;
        }
        gh0Var.b();
        return false;
    }

    public boolean g(gh0 gh0Var) {
        if (gh0Var == null) {
            return false;
        }
        if (this.f11566a < gh0Var.d()) {
            return true;
        }
        if (this.f11566a > gh0Var.d()) {
            return false;
        }
        if (this.e < gh0Var.b()) {
            return true;
        }
        gh0Var.b();
        return false;
    }

    public void h(long j) {
        this.c = j;
    }

    public void i(long j) {
        this.e = j;
    }

    public void j(String str) {
        this.d = str;
    }

    public void k(long j) {
        this.f11566a = j;
    }

    public void l(long j) {
        this.f11567b = j;
    }

    public JSONArray m() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.d);
        jSONArray.put(this.e);
        jSONArray.put(this.f11566a);
        jSONArray.put(this.f11567b);
        jSONArray.put(this.c);
        return jSONArray;
    }

    public gh0(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 4) {
            return;
        }
        this.d = jSONArray.optString(0);
        this.e = jSONArray.optLong(1);
        this.f11566a = jSONArray.optLong(2);
        this.f11567b = jSONArray.optLong(3);
        this.c = jSONArray.optLong(4);
    }
}
