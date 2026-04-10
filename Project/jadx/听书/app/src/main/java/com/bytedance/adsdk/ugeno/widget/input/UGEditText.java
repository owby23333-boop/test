package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EditText;
import com.bytedance.adsdk.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public class UGEditText extends EditText {
    private dl z;

    public UGEditText(Context context) {
        super(context);
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
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }
}
