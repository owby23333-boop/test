package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class xd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19864a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v52<String> f19865b = null;
    public oe2 c;
    public ne2 d;

    public xd2 a(int i) {
        this.f19864a = i;
        return this;
    }

    public xd2 b(String str, String str2) {
        this.f19865b = new v52<>(str, str2);
        return this;
    }

    public boolean c() {
        ne2 ne2Var = this.d;
        return ne2Var != null && ne2Var.a();
    }

    public xd2 d(ne2 ne2Var) {
        this.d = ne2Var;
        return this;
    }

    public xd2 e(String str) {
        return b("md5", str);
    }

    public xd2 f(oe2 oe2Var) {
        this.c = oe2Var;
        return this;
    }
}
