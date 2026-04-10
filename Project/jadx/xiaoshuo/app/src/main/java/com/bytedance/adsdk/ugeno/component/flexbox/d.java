package com.bytedance.adsdk.ugeno.component.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    int bh;
    boolean f;
    int ga;
    boolean l;
    float m;
    int p;
    int s;
    int v;
    int vn;
    int w;
    float wu;
    int xu;
    int zk;
    int e = Integer.MAX_VALUE;
    int bf = Integer.MAX_VALUE;
    int d = Integer.MIN_VALUE;
    int tg = Integer.MIN_VALUE;
    List<Integer> t = new ArrayList();

    public int bf() {
        return this.v - this.zk;
    }

    public int e() {
        return this.p;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        bf bfVar = (bf) view.getLayoutParams();
        this.e = Math.min(this.e, (view.getLeft() - bfVar.bh()) - i);
        this.bf = Math.min(this.bf, (view.getTop() - bfVar.t()) - i2);
        this.d = Math.max(this.d, view.getRight() + bfVar.s() + i3);
        this.tg = Math.max(this.tg, view.getBottom() + bfVar.w() + i4);
    }
}
