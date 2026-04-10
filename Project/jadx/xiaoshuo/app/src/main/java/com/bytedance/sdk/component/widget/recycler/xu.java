package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class xu extends RecyclerView.xu {
    private Scroller bf;
    private final RecyclerView.t d = new RecyclerView.t() { // from class: com.bytedance.sdk.component.widget.recycler.xu.1
        boolean e = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
        public void e(RecyclerView recyclerView, int i) {
            super.e(recyclerView, i);
            if (i == 0 && this.e) {
                this.e = false;
                xu.this.e();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
        public void e(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.e = true;
        }
    };
    RecyclerView e;

    private void bf() throws IllegalStateException {
        if (this.e.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.e.e(this.d);
        this.e.setOnFlingListener(this);
    }

    private void d() {
        this.e.bf(this.d);
        this.e.setOnFlingListener(null);
    }

    public abstract int e(RecyclerView.zk zkVar, int i, int i2);

    public abstract View e(RecyclerView.zk zkVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xu
    public boolean e(int i, int i2) {
        RecyclerView.zk layoutManager = this.e.getLayoutManager();
        if (layoutManager == null || this.e.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.e.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && bf(layoutManager, i, i2);
    }

    public abstract int[] e(RecyclerView.zk zkVar, View view);

    public RecyclerView.k d(RecyclerView.zk zkVar) {
        return bf(zkVar);
    }

    public int[] bf(int i, int i2) {
        this.bf.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.bf.getFinalX(), this.bf.getFinalY()};
    }

    public void e(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                d();
            }
            this.e = recyclerView;
            if (recyclerView != null) {
                bf();
                this.bf = new Scroller(this.e.getContext(), new DecelerateInterpolator());
                e();
            }
        }
    }

    private boolean bf(RecyclerView.zk zkVar, int i, int i2) {
        RecyclerView.k kVarD;
        int iE;
        if (!(zkVar instanceof RecyclerView.k.bf) || (kVarD = d(zkVar)) == null || (iE = e(zkVar, i, i2)) == -1) {
            return false;
        }
        kVarD.d(iE);
        zkVar.e(kVarD);
        return true;
    }

    public void e() {
        RecyclerView.zk layoutManager;
        View viewE;
        RecyclerView recyclerView = this.e;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewE = e(layoutManager)) == null) {
            return;
        }
        int[] iArrE = e(layoutManager, viewE);
        int i = iArrE[0];
        if (i == 0 && iArrE[1] == 0) {
            return;
        }
        this.e.e(i, iArrE[1]);
    }

    @Deprecated
    public vn bf(RecyclerView.zk zkVar) {
        if (zkVar instanceof RecyclerView.k.bf) {
            return new vn(this.e.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.xu.2
                @Override // com.bytedance.sdk.component.widget.recycler.vn, com.bytedance.sdk.component.widget.recycler.RecyclerView.k
                public void e(View view, RecyclerView.dt dtVar, RecyclerView.k.e eVar) {
                    xu xuVar = xu.this;
                    RecyclerView recyclerView = xuVar.e;
                    if (recyclerView != null) {
                        int[] iArrE = xuVar.e(recyclerView.getLayoutManager(), view);
                        int i = iArrE[0];
                        int i2 = iArrE[1];
                        int iE = e(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iE > 0) {
                            eVar.update(i, i2, iE, ((vn) this).bf);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.vn
                public float e(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
