package com.yuewen;

import com.duokan.reader.common.ui.SystemUiMode;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes5.dex */
public class do3 extends w60 implements jw3 {
    public final xw2 u;

    public do3(xv1 xv1Var) {
        super(xv1Var);
        this.u = (xw2) getContext().queryFeature(xw2.class);
    }

    @Override // com.yuewen.w60
    public void Nd(boolean z) {
        this.u.N(this);
        this.u.p1(true);
    }

    public void S8(rd2<SystemUiMode> rd2Var) {
    }

    @Override // com.yuewen.jw3
    public void Y2(rd2<Integer> rd2Var) {
        rd2Var.setValue(Integer.valueOf(ud().getColor(rt2.f.Ei)));
    }

    @Override // com.yuewen.w60
    public void me() {
        this.u.f0(this);
    }

    @Override // com.yuewen.w60
    public void ne() {
        this.u.f0(this);
    }

    @Override // com.yuewen.jw3
    public void ub(rd2<Boolean> rd2Var) {
        if (Gd()) {
            rd2Var.setValue(Boolean.valueOf(!e84.w0(getContext())));
        }
    }
}
