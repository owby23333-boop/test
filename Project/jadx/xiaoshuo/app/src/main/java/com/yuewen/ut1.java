package com.yuewen;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ut1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18716b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public ut1() {
        this.f18715a = "";
        this.f18716b = "";
        this.c = "";
        this.d = "";
    }

    public static void c(ut1 ut1Var, ut1 ut1Var2) {
        ut1Var2.f18715a = ut1Var.f18715a;
        ut1Var2.f18716b = ut1Var.f18716b;
        ut1Var2.c = ut1Var.c;
        ut1Var2.d = ut1Var.d;
        ut1Var2.e = ut1Var.e;
        ut1Var2.f = ut1Var.f;
        ut1Var2.g = ut1Var.g;
        ut1Var2.h = ut1Var.h;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", this.f18715a);
        bundle.putString("appId", this.f18716b);
        bundle.putString("versionCode", this.c);
        bundle.putString("channel", this.d);
        bundle.putString("earlyAccessId", this.e);
        bundle.putString("imeiMd5", this.f);
        bundle.putString("oaid", this.g);
        bundle.putString("deviceIdSet", this.h);
        return bundle;
    }

    public void b(ut1 ut1Var) {
        this.f18715a = ut1Var.f18715a;
        this.f18716b = ut1Var.f18716b;
        this.c = ut1Var.c;
        this.d = ut1Var.d;
        this.e = ut1Var.e;
        this.f = ut1Var.f;
        this.g = ut1Var.g;
        this.h = ut1Var.h;
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f18715a);
    }

    public ut1(Bundle bundle) {
        this.f18715a = "";
        this.f18716b = "";
        this.c = "";
        this.d = "";
        this.f18715a = bundle.getString("deviceId");
        this.f18716b = bundle.getString("appId");
        this.c = bundle.getString("versionCode");
        this.d = bundle.getString("channel");
        this.e = bundle.getString("earlyAccessId");
        this.f = bundle.getString("imeiMd5");
        this.g = bundle.getString("oaid");
        this.h = bundle.getString("deviceIdSet");
    }

    public ut1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f18715a = str;
        this.f18716b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
    }
}
