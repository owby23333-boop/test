package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    final Rect bf;
    private int d;
    protected final RecyclerView.zk e;

    public int bf() {
        if (Integer.MIN_VALUE == this.d) {
            return 0;
        }
        return vn() - this.d;
    }

    public abstract int bf(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e(View view);

    public void e() {
        this.d = vn();
    }

    public abstract void e(int i);

    public abstract int ga();

    public abstract int ga(View view);

    public abstract int p();

    public abstract int tg();

    public abstract int tg(View view);

    public abstract int v();

    public abstract int vn();

    public abstract int vn(View view);

    private v(RecyclerView.zk zkVar) {
        this.d = Integer.MIN_VALUE;
        this.bf = new Rect();
        this.e = zkVar;
    }

    public static v bf(RecyclerView.zk zkVar) {
        return new v(zkVar) { // from class: com.bytedance.sdk.component.widget.recycler.v.2
            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int bf(View view) {
                return this.e.m(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int d() {
                return this.e.a();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public void e(int i) {
                this.e.m(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int ga() {
                return this.e.za();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int p() {
                return this.e.fy();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int tg() {
                return this.e.za() - this.e.fy();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int v() {
                return this.e.cv();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int vn(View view) {
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                return this.e.ga(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int d(View view) {
                this.e.e(view, true, this.bf);
                return this.bf.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int e(View view) {
                return this.e.v(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int ga(View view) {
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                return this.e.vn(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int tg(View view) {
                this.e.e(view, true, this.bf);
                return this.bf.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int vn() {
                return (this.e.za() - this.e.a()) - this.e.fy();
            }
        };
    }

    public static v e(RecyclerView.zk zkVar, int i) {
        if (i == 0) {
            return e(zkVar);
        }
        if (i == 1) {
            return bf(zkVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static v e(RecyclerView.zk zkVar) {
        return new v(zkVar) { // from class: com.bytedance.sdk.component.widget.recycler.v.1
            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int bf(View view) {
                return this.e.zk(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int d() {
                return this.e.lc();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public void e(int i) {
                this.e.zk(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int ga() {
                return this.e.wl();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int p() {
                return this.e.uk();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int tg() {
                return this.e.wl() - this.e.uk();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int v() {
                return this.e.y();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int vn(View view) {
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                return this.e.vn(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int d(View view) {
                this.e.e(view, true, this.bf);
                return this.bf.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int e(View view) {
                return this.e.p(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int ga(View view) {
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                return this.e.ga(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int tg(View view) {
                this.e.e(view, true, this.bf);
                return this.bf.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.v
            public int vn() {
                return (this.e.wl() - this.e.lc()) - this.e.uk();
            }
        };
    }
}
