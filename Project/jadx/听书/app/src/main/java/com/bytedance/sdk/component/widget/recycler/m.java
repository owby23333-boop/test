package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class m extends RecyclerView.js {
    protected PointF dl;
    private final float m;
    protected final LinearInterpolator z = new LinearInterpolator();
    protected final DecelerateInterpolator g = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f838a = 0;
    protected int gc = 0;

    private int g(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public m(Context context) {
        this.m = z(context.getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.js
    protected void z(View view, RecyclerView.tb tbVar, RecyclerView.js.z zVar) {
        int iG = g(view, g());
        int iZ = z(view, dl());
        int iZ2 = z((int) Math.sqrt((iG * iG) + (iZ * iZ)));
        if (iZ2 > 0) {
            zVar.update(-iG, -iZ, iZ2, this.g);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.js
    protected void z(int i, int i2, RecyclerView.tb tbVar, RecyclerView.js.z zVar) {
        if (fo() == 0) {
            gc();
            return;
        }
        this.f838a = g(this.f838a, i);
        int iG = g(this.gc, i2);
        this.gc = iG;
        if (this.f838a == 0 && iG == 0) {
            z(zVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.js
    protected void z() {
        this.gc = 0;
        this.f838a = 0;
        this.dl = null;
    }

    protected float z(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int z(int i) {
        return (int) Math.ceil(((double) g(i)) / 0.3356d);
    }

    protected int g(int i) {
        return (int) Math.ceil(Math.abs(i) * this.m);
    }

    protected int g() {
        PointF pointF = this.dl;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.dl.x > 0.0f ? 1 : -1;
    }

    protected int dl() {
        PointF pointF = this.dl;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.dl.y > 0.0f ? 1 : -1;
    }

    protected void z(RecyclerView.js.z zVar) {
        PointF pointFA = a(gz());
        if (pointFA != null && (pointFA.x != 0.0f || pointFA.y != 0.0f)) {
            z(pointFA);
            this.dl = pointFA;
            this.f838a = (int) (pointFA.x * 10000.0f);
            this.gc = (int) (pointFA.y * 10000.0f);
            zVar.update((int) (this.f838a * 1.2f), (int) (this.gc * 1.2f), (int) (g(10000) * 1.2f), this.z);
            return;
        }
        zVar.z(gz());
        gc();
    }

    public int z(int i, int i2, int i3, int i4, int i5) {
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

    public int z(View view, int i) {
        RecyclerView.fo foVarA = a();
        if (foVarA == null || !foVarA.a()) {
            return 0;
        }
        RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
        return z(foVarA.gz(view) - uyVar.topMargin, foVarA.uy(view) + uyVar.bottomMargin, foVarA.uf(), foVarA.zw() - foVarA.hh(), i);
    }

    public int g(View view, int i) {
        RecyclerView.fo foVarA = a();
        if (foVarA == null || !foVarA.dl()) {
            return 0;
        }
        RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
        return z(foVarA.e(view) - uyVar.leftMargin, foVarA.fo(view) + uyVar.rightMargin, foVarA.io(), foVarA.iq() - foVarA.sy(), i);
    }
}
