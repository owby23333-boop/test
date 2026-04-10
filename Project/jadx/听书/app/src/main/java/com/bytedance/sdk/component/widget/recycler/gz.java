package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz {
    private int dl;
    final Rect g;
    protected final RecyclerView.fo z;

    public abstract int a();

    public abstract int a(View view);

    public abstract int dl();

    public abstract int dl(View view);

    public abstract int e();

    public abstract int g(View view);

    public abstract int gc();

    public abstract int gc(View view);

    public abstract int gz();

    public abstract int m();

    public abstract int m(View view);

    public abstract int z(View view);

    public abstract void z(int i);

    private gz(RecyclerView.fo foVar) {
        this.dl = Integer.MIN_VALUE;
        this.g = new Rect();
        this.z = foVar;
    }

    public void z() {
        this.dl = m();
    }

    public int g() {
        if (Integer.MIN_VALUE == this.dl) {
            return 0;
        }
        return m() - this.dl;
    }

    public static gz z(RecyclerView.fo foVar, int i) {
        if (i == 0) {
            return z(foVar);
        }
        if (i == 1) {
            return g(foVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static gz z(RecyclerView.fo foVar) {
        return new gz(foVar) { // from class: com.bytedance.sdk.component.widget.recycler.gz.1
            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int a() {
                return this.z.iq() - this.z.sy();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gc() {
                return this.z.iq();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public void z(int i) {
                this.z.fo(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int dl() {
                return this.z.io();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gc(View view) {
                RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
                return this.z.gc(view) + uyVar.leftMargin + uyVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int m(View view) {
                RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
                return this.z.m(view) + uyVar.topMargin + uyVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int g(View view) {
                return this.z.fo(view) + ((RecyclerView.uy) view.getLayoutParams()).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int z(View view) {
                return this.z.e(view) - ((RecyclerView.uy) view.getLayoutParams()).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int dl(View view) {
                this.z.z(view, true, this.g);
                return this.g.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int a(View view) {
                this.z.z(view, true, this.g);
                return this.g.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int m() {
                return (this.z.iq() - this.z.io()) - this.z.sy();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int e() {
                return this.z.sy();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gz() {
                return this.z.tb();
            }
        };
    }

    public static gz g(RecyclerView.fo foVar) {
        return new gz(foVar) { // from class: com.bytedance.sdk.component.widget.recycler.gz.2
            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int a() {
                return this.z.zw() - this.z.hh();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gc() {
                return this.z.zw();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public void z(int i) {
                this.z.uy(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int dl() {
                return this.z.uf();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gc(View view) {
                RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
                return this.z.m(view) + uyVar.topMargin + uyVar.bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int m(View view) {
                RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
                return this.z.gc(view) + uyVar.leftMargin + uyVar.rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int g(View view) {
                return this.z.uy(view) + ((RecyclerView.uy) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int z(View view) {
                return this.z.gz(view) - ((RecyclerView.uy) view.getLayoutParams()).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int dl(View view) {
                this.z.z(view, true, this.g);
                return this.g.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int a(View view) {
                this.z.z(view, true, this.g);
                return this.g.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int m() {
                return (this.z.zw() - this.z.uf()) - this.z.hh();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int e() {
                return this.z.hh();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.gz
            public int gz() {
                return this.z.q();
            }
        };
    }
}
