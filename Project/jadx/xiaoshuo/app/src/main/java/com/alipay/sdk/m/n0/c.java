package com.alipay.sdk.m.n0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f1880b;

    public void a(boolean z) {
        this.f1880b = Boolean.valueOf(z);
    }

    public void b(String str) {
        this.f1879a = str;
    }

    public boolean a() {
        return this.f1880b != null;
    }

    public boolean b() {
        Boolean bool = this.f1880b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f1879a, str);
    }
}
