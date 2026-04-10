package com.bytedance.sdk.openadsdk.core.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1237a;
    private final float dl;
    private int e;
    private Paint fo;
    private float fv;
    private final float g;
    private final float gc;
    private int gz;
    private boolean i;
    private float js;
    private float kb;
    private long ls;
    private final long m;
    private int p;
    private boolean pf;
    private float q;
    private float tb;
    private final PorterDuffXfermode uy;
    private int v;
    private boolean wp;
    private final float z;

    private float z(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = 0.25f;
        this.g = 0.375f;
        this.dl = 0.16f;
        this.f1237a = 0.32f;
        this.gc = 400.0f;
        this.m = 17L;
        this.e = -119723;
        this.gz = -14289682;
        this.uy = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.wp = false;
        this.i = false;
        this.v = 0;
        this.pf = false;
        this.ls = -1L;
        this.p = -1;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            g();
        } else {
            dl();
        }
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.p = i;
            this.fv = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.js = f;
            float f2 = (i * 0.16f) + f;
            this.tb = f2;
            this.q = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl();
    }

    public boolean z() {
        return this.pf;
    }

    public void g() {
        gc();
        this.pf = true;
        this.wp = true;
        postInvalidate();
    }

    public void dl() {
        this.pf = false;
        this.i = false;
        this.kb = 0.0f;
    }

    public void setProgress(float f) {
        if (!this.i) {
            gc();
        }
        this.kb = f;
        this.pf = false;
        this.wp = false;
        postInvalidate();
    }

    private Paint a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.p <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    private void gc() {
        this.ls = -1L;
        if (this.p <= 0) {
            setProgressBarInfo(oq.dl(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.p > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.fo == null) {
            this.fo = a();
        }
        this.i = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((z() || !this.wp) && this.i) {
            if (this.wp) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (this.ls < 0) {
                    this.ls = jNanoTime;
                }
                float f = (jNanoTime - this.ls) / 400.0f;
                this.kb = f;
                int i = (int) f;
                z = ((this.v + i) & 1) == 1;
                this.kb = f - i;
            }
            try {
                float fZ = z(this.kb);
                int i2 = this.p;
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.fo, 31);
                float f2 = (this.q * fZ) + this.tb;
                float f3 = ((double) fZ) < 0.5d ? fZ * 2.0f : 2.0f - (fZ * 2.0f);
                float f4 = this.js;
                float f5 = (0.25f * f3 * f4) + f4;
                this.fo.setColor(z ? this.gz : this.e);
                canvas.drawCircle(f2, this.fv, f5, this.fo);
                float f6 = this.p - f2;
                float f7 = this.js;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.fo.setColor(z ? this.e : this.gz);
                this.fo.setXfermode(this.uy);
                canvas.drawCircle(f6, this.fv, f8, this.fo);
                this.fo.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    public void setCycleBias(int i) {
        this.v = i;
    }
}
