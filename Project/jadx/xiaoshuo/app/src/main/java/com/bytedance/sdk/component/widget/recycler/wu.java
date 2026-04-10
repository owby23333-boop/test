package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class wu extends RecyclerView.vn {
    boolean v = true;

    public abstract boolean bf(RecyclerView.cv cvVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn
    public boolean bf(RecyclerView.cv cvVar, RecyclerView.vn.d dVar, RecyclerView.vn.d dVar2) {
        int i;
        int i2;
        return (dVar == null || ((i = dVar.e) == (i2 = dVar2.e) && dVar.bf == dVar2.bf)) ? bf(cvVar) : e(cvVar, i, dVar.bf, i2, dVar2.bf);
    }

    public final void bh(RecyclerView.cv cvVar) {
        k(cvVar);
    }

    public void d(RecyclerView.cv cvVar, boolean z) {
    }

    public void dt(RecyclerView.cv cvVar) {
    }

    public abstract boolean e(RecyclerView.cv cvVar);

    public abstract boolean e(RecyclerView.cv cvVar, int i, int i2, int i3, int i4);

    public abstract boolean e(RecyclerView.cv cvVar, RecyclerView.cv cvVar2, int i, int i2, int i3, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn
    public boolean e(RecyclerView.cv cvVar, RecyclerView.vn.d dVar, RecyclerView.vn.d dVar2) {
        int i = dVar.e;
        int i2 = dVar.bf;
        View view = cvVar.tg;
        int left = dVar2 == null ? view.getLeft() : dVar2.e;
        int top = dVar2 == null ? view.getTop() : dVar2.bf;
        if (cvVar.pe() || (i == left && i2 == top)) {
            return e(cvVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return e(cvVar, i, i2, left, top);
    }

    public void f(RecyclerView.cv cvVar) {
    }

    public void k(RecyclerView.cv cvVar) {
    }

    public void l(RecyclerView.cv cvVar) {
    }

    public final void m(RecyclerView.cv cvVar) {
        dt(cvVar);
        vn(cvVar);
    }

    public void s(RecyclerView.cv cvVar) {
    }

    public final void t(RecyclerView.cv cvVar) {
        l(cvVar);
    }

    public void tg(RecyclerView.cv cvVar, boolean z) {
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn
    public boolean v(RecyclerView.cv cvVar) {
        return !this.v || cvVar.f();
    }

    public void w(RecyclerView.cv cvVar) {
    }

    public final void wu(RecyclerView.cv cvVar) {
        f(cvVar);
        vn(cvVar);
    }

    public final void xu(RecyclerView.cv cvVar) {
        s(cvVar);
    }

    public final void zk(RecyclerView.cv cvVar) {
        w(cvVar);
        vn(cvVar);
    }

    public final void bf(RecyclerView.cv cvVar, boolean z) {
        d(cvVar, z);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn
    public boolean d(RecyclerView.cv cvVar, RecyclerView.vn.d dVar, RecyclerView.vn.d dVar2) {
        int i = dVar.e;
        int i2 = dVar2.e;
        if (i != i2 || dVar.bf != dVar2.bf) {
            return e(cvVar, i, dVar.bf, i2, dVar2.bf);
        }
        m(cvVar);
        return false;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.vn
    public boolean e(RecyclerView.cv cvVar, RecyclerView.cv cvVar2, RecyclerView.vn.d dVar, RecyclerView.vn.d dVar2) {
        int i;
        int i2;
        int i3 = dVar.e;
        int i4 = dVar.bf;
        if (cvVar2.p()) {
            int i5 = dVar.e;
            i2 = dVar.bf;
            i = i5;
        } else {
            i = dVar2.e;
            i2 = dVar2.bf;
        }
        return e(cvVar, cvVar2, i3, i4, i, i2);
    }

    public final void e(RecyclerView.cv cvVar, boolean z) {
        tg(cvVar, z);
        vn(cvVar);
    }
}
