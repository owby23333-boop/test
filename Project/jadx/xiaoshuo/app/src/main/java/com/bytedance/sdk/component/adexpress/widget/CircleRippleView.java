package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CircleRippleView extends View {
    private int bf;
    private float bh;
    private float d;
    private int e;
    private float ga;
    private Paint m;
    private boolean p;
    private int t;
    private int tg;
    private List<Integer> v;
    private int vn;
    private Paint wu;
    private float xu;
    private List<Integer> zk;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    private void d() {
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStrokeWidth(this.t);
        this.v.add(255);
        this.zk.add(0);
        Paint paint2 = new Paint();
        this.wu = paint2;
        paint2.setAntiAlias(true);
        this.wu.setColor(Color.parseColor("#0FFFFFFF"));
        this.wu.setStyle(Paint.Style.FILL);
    }

    public void bf() {
        this.p = false;
        this.zk.clear();
        this.v.clear();
        this.v.add(255);
        this.zk.add(0);
        invalidate();
    }

    public void e() {
        this.p = true;
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.m.setShader(new LinearGradient(this.xu, 0.0f, this.bh, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.v.size()) {
                break;
            }
            Integer num = this.v.get(i);
            this.m.setAlpha(num.intValue());
            Integer num2 = this.zk.get(i);
            if (this.d + num2.intValue() < this.ga) {
                canvas.drawCircle(this.xu, this.bh, this.d + num2.intValue(), this.m);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ga) {
                this.v.set(i, Integer.valueOf(num.intValue() - this.vn > 0 ? num.intValue() - (this.vn * 3) : 1));
                this.zk.set(i, Integer.valueOf(num2.intValue() + this.vn));
            }
            i++;
        }
        List<Integer> list = this.zk;
        if (list.get(list.size() - 1).intValue() >= this.ga / this.tg) {
            this.v.add(255);
            this.zk.add(0);
        }
        if (this.zk.size() >= 3) {
            this.zk.remove(0);
            this.v.remove(0);
        }
        this.m.setAlpha(255);
        this.m.setColor(this.bf);
        canvas.drawCircle(this.xu, this.bh, this.d, this.wu);
        if (this.p) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.xu = f;
        this.bh = i2 / 2.0f;
        float f2 = f - (this.t / 2.0f);
        this.ga = f2;
        this.d = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void setColor(int i) {
        this.e = i;
    }

    public void setCoreColor(int i) {
        this.bf = i;
    }

    public void setCoreRadius(int i) {
        this.d = i;
    }

    public void setDiffuseSpeed(int i) {
        this.vn = i;
    }

    public void setDiffuseWidth(int i) {
        this.tg = i;
    }

    public void setMaxWidth(int i) {
        this.ga = i;
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.bf = -65536;
        this.d = 18.0f;
        this.tg = 3;
        this.ga = 50.0f;
        this.vn = 2;
        this.p = false;
        this.v = new ArrayList();
        this.zk = new ArrayList();
        this.t = 24;
        d();
    }
}
