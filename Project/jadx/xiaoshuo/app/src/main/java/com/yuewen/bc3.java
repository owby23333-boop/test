package com.yuewen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bc3 extends w60 {
    public final fc3 u;
    public final ViewGroup v;
    public gc3 w;
    public b x;

    public class a extends fc3 {
        public a(xv1 xv1Var) {
            super(xv1Var);
        }

        @Override // com.yuewen.fc3
        public void Sf() {
            bc3.this.Se();
        }
    }

    public interface b {
        View a(LayoutInflater layoutInflater, ViewGroup viewGroup);
    }

    public bc3(xv1 xv1Var) {
        super(xv1Var);
        Ge(rt2.n.x0);
        this.v = (ViewGroup) od(rt2.k.P3);
        ViewGroup viewGroup = (ViewGroup) od(rt2.k.l4);
        a aVar = new a(getContext());
        this.u = aVar;
        Rc(aVar);
        d4(aVar);
        viewGroup.addView(aVar.getContentView());
    }

    @Override // com.yuewen.w60
    public void Nd(boolean z) {
        super.Nd(z);
        if (z) {
            this.w = Re(this.u);
            this.u.Tf(Oe(this));
        }
    }

    public b Ne() {
        return this.x;
    }

    public abstract ac3<? extends b> Oe(bc3 bc3Var);

    public fc3 Pe() {
        return this.u;
    }

    public gc3 Qe() {
        return this.w;
    }

    public abstract gc3 Re(fc3 fc3Var);

    public void Se() {
    }

    public bc3 Te(b bVar) {
        View viewA = bVar.a(LayoutInflater.from(getContext()), this.v);
        this.v.removeAllViews();
        this.v.addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        this.x = bVar;
        return this;
    }
}
