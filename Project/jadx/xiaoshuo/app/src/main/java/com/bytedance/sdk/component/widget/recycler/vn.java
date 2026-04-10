package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class vn extends RecyclerView.k {
    protected PointF d;
    private final float vn;
    protected final LinearInterpolator e = new LinearInterpolator();
    protected final DecelerateInterpolator bf = new DecelerateInterpolator();
    protected int tg = 0;
    protected int ga = 0;

    public vn(Context context) {
        this.vn = e(context.getResources().getDisplayMetrics());
    }

    private int bf(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int d() {
        PointF pointF = this.d;
        if (pointF != null) {
            float f = pointF.x;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
    public void e() {
    }

    public int tg() {
        PointF pointF = this.d;
        if (pointF != null) {
            float f = pointF.y;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
    public void bf() {
        this.ga = 0;
        this.tg = 0;
        this.d = null;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
    public void e(View view, RecyclerView.dt dtVar, RecyclerView.k.e eVar) {
        int iBf = bf(view, d());
        int iE = e(view, tg());
        int iE2 = e((int) Math.sqrt((iBf * iBf) + (iE * iE)));
        if (iE2 > 0) {
            eVar.update(-iBf, -iE, iE2, this.bf);
        }
    }

    public int bf(int i) {
        return (int) Math.ceil(Math.abs(i) * this.vn);
    }

    public int bf(View view, int i) {
        RecyclerView.zk zkVarGa = ga();
        if (zkVarGa == null || !zkVarGa.d()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e(zkVarGa.p(view) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, zkVarGa.zk(view) + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, zkVarGa.lc(), zkVarGa.wl() - zkVarGa.uk(), i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
    public void e(int i, int i2, RecyclerView.dt dtVar, RecyclerView.k.e eVar) {
        if (m() == 0) {
            vn();
            return;
        }
        this.tg = bf(this.tg, i);
        int iBf = bf(this.ga, i2);
        this.ga = iBf;
        if (this.tg == 0 && iBf == 0) {
            e(eVar);
        }
    }

    public float e(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i) {
        return (int) Math.ceil(((double) bf(i)) / 0.3356d);
    }

    public void e(RecyclerView.k.e eVar) {
        PointF pointFTg = tg(zk());
        if (pointFTg != null && (pointFTg.x != 0.0f || pointFTg.y != 0.0f)) {
            e(pointFTg);
            this.d = pointFTg;
            this.tg = (int) (pointFTg.x * 10000.0f);
            this.ga = (int) (pointFTg.y * 10000.0f);
            eVar.update((int) (this.tg * 1.2f), (int) (this.ga * 1.2f), (int) (bf(10000) * 1.2f), this.e);
            return;
        }
        eVar.e(zk());
        vn();
    }

    public int e(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int e(View view, int i) {
        RecyclerView.zk zkVarGa = ga();
        if (zkVarGa == null || !zkVarGa.tg()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e(zkVarGa.v(view) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, zkVarGa.m(view) + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin, zkVarGa.a(), zkVarGa.za() - zkVarGa.fy(), i);
    }
}
