package com.duokan.kernel;

import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes11.dex */
public class DkBox {
    public float mX0;
    public float mX1;
    public float mY0;
    public float mY1;

    public DkBox(float f, float f2, float f3, float f4) {
        this.mX0 = f;
        this.mY0 = f2;
        this.mX1 = f3;
        this.mY1 = f4;
    }

    public boolean equals(Object obj) {
        DkBox dkBox = (DkBox) obj;
        return Double.compare((double) this.mX0, (double) dkBox.mX0) == 0 && Double.compare((double) this.mY0, (double) dkBox.mY0) == 0 && Double.compare((double) this.mX1, (double) dkBox.mX1) == 0 && Double.compare((double) this.mY1, (double) dkBox.mY1) == 0;
    }

    public Rect toRect() {
        return new Rect(Math.round(this.mX0), Math.round(this.mY0), Math.round(this.mX1), Math.round(this.mY1));
    }

    public RectF toRectF() {
        return new RectF(this.mX0, this.mY0, this.mX1, this.mY1);
    }

    public DkBox() {
        this.mX0 = 0.0f;
        this.mY0 = 0.0f;
        this.mX1 = 0.0f;
        this.mY1 = 0.0f;
    }
}
