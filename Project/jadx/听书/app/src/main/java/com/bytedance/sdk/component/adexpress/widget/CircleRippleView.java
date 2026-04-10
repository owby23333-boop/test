package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CircleRippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f592a;
    private float dl;
    private boolean e;
    private List<Integer> fo;
    private int g;
    private float gc;
    private List<Integer> gz;
    private float i;
    private Paint kb;
    private int m;
    private Paint uy;
    private int v;
    private float wp;
    private int z;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = -1;
        this.g = SupportMenu.CATEGORY_MASK;
        this.dl = 18.0f;
        this.f592a = 3;
        this.gc = 50.0f;
        this.m = 2;
        this.e = false;
        this.gz = new ArrayList();
        this.fo = new ArrayList();
        this.v = 24;
        dl();
    }

    private void dl() {
        Paint paint = new Paint();
        this.uy = paint;
        paint.setAntiAlias(true);
        this.uy.setStrokeWidth(this.v);
        this.gz.add(255);
        this.fo.add(0);
        Paint paint2 = new Paint();
        this.kb = paint2;
        paint2.setAntiAlias(true);
        this.kb.setColor(Color.parseColor("#0FFFFFFF"));
        this.kb.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.wp = f;
        this.i = i2 / 2.0f;
        float f2 = f - (this.v / 2.0f);
        this.gc = f2;
        this.dl = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.uy.setShader(new LinearGradient(this.wp, 0.0f, this.i, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.gz.size()) {
                break;
            }
            Integer num = this.gz.get(i);
            this.uy.setAlpha(num.intValue());
            Integer num2 = this.fo.get(i);
            if (this.dl + num2.intValue() < this.gc) {
                canvas.drawCircle(this.wp, this.i, this.dl + num2.intValue(), this.uy);
            }
            if (num.intValue() > 0 && num2.intValue() < this.gc) {
                this.gz.set(i, Integer.valueOf(num.intValue() - this.m > 0 ? num.intValue() - (this.m * 3) : 1));
                this.fo.set(i, Integer.valueOf(num2.intValue() + this.m));
            }
            i++;
        }
        List<Integer> list = this.fo;
        if (list.get(list.size() - 1).intValue() >= this.gc / this.f592a) {
            this.gz.add(255);
            this.fo.add(0);
        }
        if (this.fo.size() >= 3) {
            this.fo.remove(0);
            this.gz.remove(0);
        }
        this.uy.setAlpha(255);
        this.uy.setColor(this.g);
        canvas.drawCircle(this.wp, this.i, this.dl, this.kb);
        if (this.e) {
            invalidate();
        }
    }

    public void z() {
        this.e = true;
        invalidate();
    }

    public void g() {
        this.e = false;
        this.fo.clear();
        this.gz.clear();
        this.gz.add(255);
        this.fo.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.z = i;
    }

    public void setCoreColor(int i) {
        this.g = i;
    }

    public void setCoreRadius(int i) {
        this.dl = i;
    }

    public void setDiffuseWidth(int i) {
        this.f592a = i;
    }

    public void setMaxWidth(int i) {
        this.gc = i;
    }

    public void setDiffuseSpeed(int i) {
        this.m = i;
    }
}
