package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class wp extends RecyclerView.wp {
    private final RecyclerView.v dl = new RecyclerView.v() { // from class: com.bytedance.sdk.component.widget.recycler.wp.1
        boolean z = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
        public void z(RecyclerView recyclerView, int i) {
            super.z(recyclerView, i);
            if (i == 0 && this.z) {
                this.z = false;
                wp.this.z();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
        public void z(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.z = true;
        }
    };
    private Scroller g;
    RecyclerView z;

    public abstract int z(RecyclerView.fo foVar, int i, int i2);

    public abstract View z(RecyclerView.fo foVar);

    public abstract int[] z(RecyclerView.fo foVar, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.wp
    public boolean z(int i, int i2) {
        RecyclerView.fo layoutManager = this.z.getLayoutManager();
        if (layoutManager == null || this.z.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.z.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && g(layoutManager, i, i2);
    }

    public void z(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.z;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                dl();
            }
            this.z = recyclerView;
            if (recyclerView != null) {
                g();
                this.g = new Scroller(this.z.getContext(), new DecelerateInterpolator());
                z();
            }
        }
    }

    private void g() throws IllegalStateException {
        if (this.z.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.z.z(this.dl);
        this.z.setOnFlingListener(this);
    }

    private void dl() {
        this.z.g(this.dl);
        this.z.setOnFlingListener(null);
    }

    private boolean g(RecyclerView.fo foVar, int i, int i2) {
        RecyclerView.js jsVarDl;
        int iZ;
        if (!(foVar instanceof RecyclerView.js.g) || (jsVarDl = dl(foVar)) == null || (iZ = z(foVar, i, i2)) == -1) {
            return false;
        }
        jsVarDl.dl(iZ);
        foVar.z(jsVarDl);
        return true;
    }

    void z() {
        RecyclerView.fo layoutManager;
        View viewZ;
        RecyclerView recyclerView = this.z;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewZ = z(layoutManager)) == null) {
            return;
        }
        int[] iArrZ = z(layoutManager, viewZ);
        int i = iArrZ[0];
        if (i == 0 && iArrZ[1] == 0) {
            return;
        }
        this.z.z(i, iArrZ[1]);
    }

    protected RecyclerView.js dl(RecyclerView.fo foVar) {
        return g(foVar);
    }

    @Deprecated
    protected m g(RecyclerView.fo foVar) {
        if (foVar instanceof RecyclerView.js.g) {
            return new m(this.z.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.wp.2
                @Override // com.bytedance.sdk.component.widget.recycler.m, com.bytedance.sdk.component.widget.recycler.RecyclerView.js
                protected void z(View view, RecyclerView.tb tbVar, RecyclerView.js.z zVar) {
                    if (wp.this.z != null) {
                        wp wpVar = wp.this;
                        int[] iArrZ = wpVar.z(wpVar.z.getLayoutManager(), view);
                        int i = iArrZ[0];
                        int i2 = iArrZ[1];
                        int iZ = z(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iZ > 0) {
                            zVar.update(i, i2, iZ, this.g);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.m
                protected float z(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
