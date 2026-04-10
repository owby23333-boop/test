package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes15.dex */
public class o02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u12 f15174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15175b;
    public boolean c = false;

    public o02(u12 u12Var) {
        this.f15174a = u12Var;
    }

    public static String c(u12 u12Var) {
        return od0.f(u12Var.h() + "_" + u12Var.m(), "md5").toLowerCase();
    }

    public void a() {
        b();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f15175b)) {
            this.f15175b = c(this.f15174a);
        }
        return this.f15175b;
    }

    public long d() {
        return this.f15174a.c();
    }

    public u12 e() {
        return this.f15174a;
    }

    public String f() {
        return nn.f14895a + b();
    }

    public long g() {
        return this.f15174a.g();
    }

    public String h() {
        return this.f15174a.h();
    }

    public String i() {
        return this.f15174a.m();
    }

    public long j() {
        return this.f15174a.n();
    }

    public boolean k() {
        return this.c;
    }

    public void l(boolean z) {
        this.c = z;
    }

    public String toString() {
        return "MiCloudBookItemInfo{mFileInfo=" + h() + ", mBookIdAtCloud='" + this.f15175b + "', mPrepareForDownload=" + this.c + '}';
    }
}
