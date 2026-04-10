package com.bytedance.msdk.core.gz;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f399a;
    protected String dl;
    protected String g;
    protected int gc;
    private boolean m;
    protected String z;

    public boolean z() {
        return this.m;
    }

    public String g() {
        return this.z;
    }

    public String dl() {
        return this.g;
    }

    public String a() {
        return TextUtils.isEmpty(this.g) ? this.z : this.z + "_" + this.g;
    }

    public String gc() {
        return this.dl;
    }

    public String m() {
        return this.f399a;
    }

    public int e() {
        return this.gc;
    }

    public a(String str, String str2, String str3, String str4, int i) {
        this.z = str;
        this.dl = str3;
        this.gc = i;
        this.g = str2;
        this.m = !TextUtils.isEmpty(str2);
        this.f399a = str4;
    }

    public boolean gz() {
        return this.gc == 1;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.z + "', showRulesVersion='" + this.dl + "', timingMode=" + this.gc + '}';
    }
}
