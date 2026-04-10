package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    int e;
    int fo;
    boolean fv;
    int gc;
    int gz;
    int i;
    float kb;
    int ls;
    int m;
    boolean p;
    int pf;
    float uy;
    int wp;
    int z = Integer.MAX_VALUE;
    int g = Integer.MAX_VALUE;
    int dl = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f238a = Integer.MIN_VALUE;
    List<Integer> v = new ArrayList();

    dl() {
    }

    public int z() {
        return this.e;
    }

    public int g() {
        return this.gz - this.fo;
    }

    void z(View view, int i, int i2, int i3, int i4) {
        g gVar = (g) view.getLayoutParams();
        this.z = Math.min(this.z, (view.getLeft() - gVar.i()) - i);
        this.g = Math.min(this.g, (view.getTop() - gVar.v()) - i2);
        this.dl = Math.max(this.dl, view.getRight() + gVar.pf() + i3);
        this.f238a = Math.max(this.f238a, view.getBottom() + gVar.ls() + i4);
    }
}
