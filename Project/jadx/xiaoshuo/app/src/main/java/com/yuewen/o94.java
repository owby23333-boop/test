package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class o94 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15234a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15235b = "";
    public String c = "";

    public static void b(o94 o94Var, o94 o94Var2) {
        o94Var2.f15234a = o94Var.f15234a;
        o94Var2.f15235b = o94Var.f15235b;
        o94Var2.c = o94Var.c;
    }

    public void a(o94 o94Var) {
        this.f15234a = o94Var.f15234a;
        this.f15235b = o94Var.f15235b;
        this.c = o94Var.c;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f15235b) ? this.f15235b : this.f15234a;
    }
}
