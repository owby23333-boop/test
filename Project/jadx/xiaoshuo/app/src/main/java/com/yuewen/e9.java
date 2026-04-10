package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed2 f10545a;

    public e9(ed2 ed2Var) {
        this.f10545a = ed2Var;
    }

    public String a() {
        ed2 ed2Var = this.f10545a;
        if (ed2Var == null || TextUtils.isEmpty(ed2Var.f10569a)) {
            return null;
        }
        ed2 ed2Var2 = this.f10545a;
        if (ed2Var2.f10570b == 5) {
            return ed2Var2.f10569a;
        }
        return null;
    }

    public String b() {
        ed2 ed2Var = this.f10545a;
        if (ed2Var == null || TextUtils.isEmpty(ed2Var.d)) {
            return null;
        }
        ed2 ed2Var2 = this.f10545a;
        if (ed2Var2.f10570b == 5) {
            return ed2Var2.d;
        }
        return null;
    }

    public boolean c() {
        return !TextUtils.isEmpty(a());
    }
}
