package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends wp {
    private gz dl;
    private gz g;

    @Override // com.bytedance.sdk.component.widget.recycler.wp
    public int[] z(RecyclerView.fo foVar, View view) {
        int[] iArr = new int[2];
        if (foVar.dl()) {
            iArr[0] = z(foVar, view, gc(foVar));
        } else {
            iArr[0] = 0;
        }
        if (foVar.a()) {
            iArr[1] = z(foVar, view, a(foVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.wp
    public View z(RecyclerView.fo foVar) {
        if (foVar.a()) {
            return z(foVar, a(foVar));
        }
        if (foVar.dl()) {
            return z(foVar, gc(foVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.wp
    public int z(RecyclerView.fo foVar, int i, int i2) {
        View viewG;
        int iA;
        PointF pointFDl;
        int iH = foVar.h();
        if (iH == 0) {
            return -1;
        }
        if (foVar.a()) {
            viewG = g(foVar, a(foVar));
        } else {
            viewG = foVar.dl() ? g(foVar, gc(foVar)) : null;
        }
        if (viewG == null || (iA = foVar.a(viewG)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !foVar.dl() ? i2 <= 0 : i <= 0;
        if ((foVar instanceof RecyclerView.js.g) && (pointFDl = ((RecyclerView.js.g) foVar).dl(iH - 1)) != null && (pointFDl.x < 0.0f || pointFDl.y < 0.0f)) {
            z = true;
        }
        return z ? z2 ? iA - 1 : iA : z2 ? iA + 1 : iA;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.wp
    protected m g(RecyclerView.fo foVar) {
        if (foVar instanceof RecyclerView.js.g) {
            return new m(this.z.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.fo.1
                @Override // com.bytedance.sdk.component.widget.recycler.m, com.bytedance.sdk.component.widget.recycler.RecyclerView.js
                protected void z(View view, RecyclerView.tb tbVar, RecyclerView.js.z zVar) {
                    fo foVar2 = fo.this;
                    int[] iArrZ = foVar2.z(foVar2.z.getLayoutManager(), view);
                    int i = iArrZ[0];
                    int i2 = iArrZ[1];
                    int iZ = z(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iZ > 0) {
                        zVar.update(i, i2, iZ, this.g);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected float z(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected int g(int i) {
                    return Math.min(100, super.g(i));
                }
            };
        }
        return null;
    }

    private int z(RecyclerView.fo foVar, View view, gz gzVar) {
        int iGc;
        int iZ = gzVar.z(view) + (gzVar.gc(view) / 2);
        if (foVar.pf()) {
            iGc = gzVar.dl() + (gzVar.m() / 2);
        } else {
            iGc = gzVar.gc() / 2;
        }
        return iZ - iGc;
    }

    private View z(RecyclerView.fo foVar, gz gzVar) {
        int iGc;
        int iJs = foVar.js();
        View view = null;
        if (iJs == 0) {
            return null;
        }
        if (foVar.pf()) {
            iGc = gzVar.dl() + (gzVar.m() / 2);
        } else {
            iGc = gzVar.gc() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iJs; i2++) {
            View viewGz = foVar.gz(i2);
            int iAbs = Math.abs((gzVar.z(viewGz) + (gzVar.gc(viewGz) / 2)) - iGc);
            if (iAbs < i) {
                view = viewGz;
                i = iAbs;
            }
        }
        return view;
    }

    private View g(RecyclerView.fo foVar, gz gzVar) {
        int iJs = foVar.js();
        View view = null;
        if (iJs == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iJs; i2++) {
            View viewGz = foVar.gz(i2);
            int iZ = gzVar.z(viewGz);
            if (iZ < i) {
                view = viewGz;
                i = iZ;
            }
        }
        return view;
    }

    private gz a(RecyclerView.fo foVar) {
        gz gzVar = this.g;
        if (gzVar == null || gzVar.z != foVar) {
            this.g = gz.g(foVar);
        }
        return this.g;
    }

    private gz gc(RecyclerView.fo foVar) {
        gz gzVar = this.dl;
        if (gzVar == null || gzVar.z != foVar) {
            this.dl = gz.z(foVar);
        }
        return this.dl;
    }
}
