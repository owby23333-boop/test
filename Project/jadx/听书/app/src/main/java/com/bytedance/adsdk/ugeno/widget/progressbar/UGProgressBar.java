package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public class UGProgressBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f255a;
    private View dl;
    private View g;
    private int gc;
    private dl z;

    public UGProgressBar(Context context) {
        super(context);
        z(context);
    }

    private void z(Context context) {
        this.g = new View(context);
        this.dl = new View(context);
        addView(this.g);
        addView(this.dl);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.g.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dl.getLayoutParams();
        layoutParams2.width = this.gc;
        layoutParams2.gravity = 5;
        this.dl.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.f255a = textView;
        textView.setTextColor(-1);
        this.f255a.setTextSize(16.0f);
        this.f255a.setGravity(17);
        addView(this.f255a);
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.g.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dl.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.dl.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f255a.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setText(String str) {
        this.f255a.setText(str);
    }

    public void setTextColor(int i) {
        this.f255a.setTextColor(i);
    }

    public void setProgressColor(int i) {
        this.g.setBackgroundColor(i);
    }

    public void setProgressBgColor(int i) {
        this.dl.setBackgroundColor(i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.gc = i;
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2);
        }
        super.onMeasure(i, i2);
        this.gc = z(0, i);
    }

    private int z(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }
}
