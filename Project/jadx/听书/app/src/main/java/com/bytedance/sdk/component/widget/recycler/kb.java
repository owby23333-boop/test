package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class kb extends RecyclerView.m {
    boolean gz = true;

    public abstract boolean g(RecyclerView.zw zwVar);

    public abstract boolean z(RecyclerView.zw zwVar);

    public abstract boolean z(RecyclerView.zw zwVar, int i, int i2, int i3, int i4);

    public abstract boolean z(RecyclerView.zw zwVar, RecyclerView.zw zwVar2, int i, int i2, int i3, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean e(RecyclerView.zw zwVar) {
        return !this.gz || zwVar.v();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean z(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2) {
        int i = gVar.z;
        int i2 = gVar.g;
        View view = zwVar.z;
        int left = gVar2 == null ? view.getLeft() : gVar2.z;
        int top2 = gVar2 == null ? view.getTop() : gVar2.g;
        if (zwVar.p() || (i == left && i2 == top2)) {
            return z(zwVar);
        }
        view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
        return z(zwVar, i, i2, left, top2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean g(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2) {
        return (gVar == null || (gVar.z == gVar2.z && gVar.g == gVar2.g)) ? g(zwVar) : z(zwVar, gVar.z, gVar.g, gVar2.z, gVar2.g);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean dl(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2) {
        if (gVar.z == gVar2.z && gVar.g == gVar2.g) {
            fo(zwVar);
            return false;
        }
        return z(zwVar, gVar.z, gVar.g, gVar2.z, gVar2.g);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean z(RecyclerView.zw zwVar, RecyclerView.zw zwVar2, RecyclerView.m.g gVar, RecyclerView.m.g gVar2) {
        int i;
        int i2;
        int i3 = gVar.z;
        int i4 = gVar.g;
        if (zwVar2.L_()) {
            int i5 = gVar.z;
            i2 = gVar.g;
            i = i5;
        } else {
            i = gVar2.z;
            i2 = gVar2.g;
        }
        return z(zwVar, zwVar2, i3, i4, i, i2);
    }

    public final void gz(RecyclerView.zw zwVar) {
        m(zwVar);
    }

    public final void fo(RecyclerView.zw zwVar) {
        m(zwVar);
    }

    public final void uy(RecyclerView.zw zwVar) {
        m(zwVar);
    }

    public final void z(RecyclerView.zw zwVar, boolean z) {
        m(zwVar);
    }
}
