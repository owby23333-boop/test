package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected PointF f614a;
    protected PointF dl;
    protected PointF g;
    protected PointF gc;
    protected PointF z;

    public z(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.dl = new PointF();
        this.f614a = new PointF();
        this.gc = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.z = pointF;
        this.g = pointF2;
    }

    public z(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return z(g(f));
    }

    protected float z(float f) {
        this.gc.y = this.z.y * 3.0f;
        this.f614a.y = ((this.g.y - this.z.y) * 3.0f) - this.gc.y;
        this.dl.y = (1.0f - this.gc.y) - this.f614a.y;
        return f * (this.gc.y + ((this.f614a.y + (this.dl.y * f)) * f));
    }

    protected float g(float f) {
        float fDl = f;
        for (int i = 1; i < 14; i++) {
            float fA = a(fDl) - f;
            if (Math.abs(fA) < 0.001d) {
                break;
            }
            fDl -= fA / dl(fDl);
        }
        return fDl;
    }

    private float dl(float f) {
        return this.gc.x + (f * ((this.f614a.x * 2.0f) + (this.dl.x * 3.0f * f)));
    }

    private float a(float f) {
        this.gc.x = this.z.x * 3.0f;
        this.f614a.x = ((this.g.x - this.z.x) * 3.0f) - this.gc.x;
        this.dl.x = (1.0f - this.gc.x) - this.f614a.x;
        return f * (this.gc.x + ((this.f614a.x + (this.dl.x * f)) * f));
    }
}
