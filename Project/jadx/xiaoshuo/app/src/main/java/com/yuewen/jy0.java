package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class jy0 extends zr0 {
    public String r;
    public boolean s;

    public jy0() {
        this.r = null;
        this.s = false;
    }

    @Override // com.yuewen.zr0
    public zr0 a() {
        return new jy0(this);
    }

    public jy0(jy0 jy0Var) {
        super(jy0Var);
        this.r = null;
        this.s = false;
        this.r = jy0Var.r;
        this.s = jy0Var.s;
    }
}
