package com.bytedance.adsdk.ugeno.component.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.bf;

/* JADX INFO: loaded from: classes.dex */
public class UGProgressBar extends FrameLayout {
    private View bf;
    private View d;
    private bf e;
    private int ga;
    private TextView tg;

    public UGProgressBar(Context context) {
        super(context);
        e(context);
    }

    private void e(Context context) {
        this.bf = new View(context);
        this.d = new View(context);
        addView(this.bf);
        addView(this.d);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bf.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.bf.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = this.ga;
        layoutParams2.gravity = 5;
        this.d.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.tg = textView;
        textView.setTextColor(-1);
        this.tg.setTextSize(16.0f);
        this.tg.setGravity(17);
        addView(this.tg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.tg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.ga();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(i, i2);
        }
        super.onMeasure(i, i2);
        this.ga = e(0, i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ga = i;
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bf.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.bf.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.d.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.tg.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setProgressBgColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public void setProgressColor(int i) {
        this.bf.setBackgroundColor(i);
    }

    public void setText(String str) {
        this.tg.setText(str);
    }

    public void setTextColor(int i) {
        this.tg.setTextColor(i);
    }

    private int e(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void e(bf bfVar) {
        this.e = bfVar;
    }
}
