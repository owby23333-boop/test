package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zh0 implements hj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x50 f20774a = null;

    @Override // com.yuewen.hj1
    public boolean a() {
        x50 x50Var = this.f20774a;
        return (x50Var == null || TextUtils.isEmpty(x50Var.d()) || TextUtils.isEmpty(this.f20774a.c())) ? false : true;
    }

    @Override // com.yuewen.hj1
    public boolean b() {
        x50 x50VarG = xh0.f().g(getKey());
        if (x50VarG != null) {
            boolean zEquals = x50VarG.equals(this.f20774a);
            this.f20774a = x50VarG;
            return zEquals;
        }
        boolean z = this.f20774a == null;
        this.f20774a = null;
        return z;
    }

    @Override // com.yuewen.hj1
    public x50 c() {
        return xh0.f().g(getKey());
    }

    public String d() {
        return this.f20774a.b();
    }

    public String e() {
        return this.f20774a.d();
    }

    public String f() {
        return this.f20774a.c();
    }

    public boolean g() {
        return this.f20774a.f();
    }

    @Override // com.yuewen.hj1
    public String getKey() {
        return y50.M2;
    }
}
