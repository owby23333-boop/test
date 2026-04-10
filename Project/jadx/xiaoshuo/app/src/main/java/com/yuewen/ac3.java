package com.yuewen;

import com.yuewen.bc3;
import com.yuewen.bc3.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ac3<HEADER extends bc3.b> extends w60 {
    public final bc3 u;
    public final gc3 v;

    public ac3(xv1 xv1Var, bc3 bc3Var, int i) {
        super(xv1Var, i);
        this.u = bc3Var;
        this.v = bc3Var.Qe();
    }

    @Override // com.yuewen.w60
    public void Nd(boolean z) {
        super.Nd(z);
        Se(this.u.Ne());
    }

    public void Ne() {
        this.v.a();
    }

    public bc3 Oe() {
        return this.u;
    }

    public void Pe() {
        Qe(false);
    }

    public void Qe(boolean z) {
        this.v.c(this, z);
    }

    public void Re(ac3 ac3Var) {
        this.v.b(ac3Var);
    }

    public abstract void Se(HEADER header);

    @Override // com.yuewen.w60
    public boolean ke() {
        if (!this.v.d(this)) {
            return super.ke();
        }
        Pe();
        return true;
    }

    @Override // com.yuewen.w60
    public void me() {
        super.me();
    }

    public ac3(xv1 xv1Var, bc3 bc3Var) {
        super(xv1Var);
        this.u = bc3Var;
        this.v = bc3Var.Qe();
    }
}
