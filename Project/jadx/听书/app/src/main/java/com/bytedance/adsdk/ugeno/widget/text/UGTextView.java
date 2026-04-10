package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.adsdk.ugeno.dl.gc;
import com.bytedance.adsdk.ugeno.z.e;
import com.bytedance.adsdk.ugeno.z.gz;

/* JADX INFO: loaded from: classes2.dex */
public class UGTextView extends TextView implements gc, e {
    private gz dl;
    private float g;
    private dl z;

    public UGTextView(Context context) {
        super(context);
        this.dl = new gz(this);
    }

    public void z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.z;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.gc, com.bytedance.adsdk.ugeno.z.e
    public float getRipple() {
        return this.g;
    }

    public void setShine(float f) {
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.dl(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getShine() {
        return this.dl.getShine();
    }

    public void setStretch(float f) {
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.a(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getStretch() {
        return this.dl.getStretch();
    }

    public void setRubIn(float f) {
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.gc(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRubIn() {
        return this.dl.getRubIn();
    }

    public void setRipple(float f) {
        this.g = f;
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.g(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(canvas, this);
            this.z.z(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }

    public void setBorderRadius(float f) {
        gz gzVar = this.dl;
        if (gzVar != null) {
            gzVar.z(f);
        }
    }

    public float getBorderRadius() {
        return this.dl.z();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.dl.z(i);
    }
}
