package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class CycleSkipView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f1343a;
    protected int dl;
    protected boolean e;
    protected float fo;
    private ValueAnimator fv;
    protected int g;
    protected float gc;
    protected float gz;
    private Paint i;
    private float iq;
    private ValueAnimator js;
    protected boolean kb;
    private AnimatorSet ls;
    protected int m;
    private ValueAnimator p;
    private float pf;
    private final RectF q;
    private boolean tb;
    protected int uy;
    private Paint v;
    private Paint wp;
    protected int z;

    public CycleSkipView(Context context) {
        super(context);
        this.z = Color.parseColor("#f9e8b9");
        this.g = Color.parseColor("#ffffff");
        this.dl = Color.parseColor("#7b7b7b");
        this.m = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.e = false;
        this.gz = 5.0f;
        this.fo = 0.0f;
        this.uy = 0;
        this.kb = true;
        this.pf = 0.0f;
        this.tb = false;
        this.q = new RectF();
        this.iq = 1.0f;
        this.f1343a = z(2.0f);
        this.gc = z(10.0f);
        this.m %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        g();
        setBackgroundColor(-16711681);
    }

    private void g() {
        Paint paint = new Paint(1);
        this.wp = paint;
        paint.setColor(this.z);
        this.wp.setStrokeWidth(this.f1343a);
        this.wp.setAntiAlias(true);
        this.wp.setStrokeCap(Paint.Cap.ROUND);
        this.wp.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setColor(this.g);
        this.i.setAntiAlias(true);
        this.i.setStrokeWidth(this.f1343a);
        this.i.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.v = paint3;
        paint3.setColor(this.dl);
        this.v.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = dl();
        }
        if (mode2 != 1073741824) {
            size2 = dl();
        }
        g(size, size2);
        setMeasuredDimension(size, size2);
        this.q.left = -this.gc;
        this.q.right = this.gc;
        this.q.top = -this.gc;
        this.q.bottom = this.gc;
        this.v.setTextSize(getMinLine() / 3.0f);
    }

    private int dl() {
        return (int) ((((this.f1343a / 2.0f) + this.gc) * 2.0f) + z(4.0f));
    }

    private void g(int i, int i2) {
        this.gc = (Math.min(i, i2) / 2.0f) - this.f1343a;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        g(canvas);
        z(canvas);
    }

    private void z(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.v.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.v);
        canvas.restore();
    }

    private void g(Canvas canvas) {
        float f;
        float fMax;
        float f2;
        canvas.save();
        float f3 = this.pf * 360.0f;
        if (this.e) {
            if (this.kb) {
                f = this.m;
                f3 = -f3;
            } else {
                f = this.m - f3;
            }
        } else {
            if (this.kb) {
                float f4 = this.m + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                fMax = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
                canvas.drawCircle(0.0f, 0.0f, this.gc, this.i);
                canvas.drawArc(this.q, f2, fMax, false, this.wp);
                canvas.restore();
            }
            f = this.m;
        }
        fMax = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.gc, this.i);
        canvas.drawArc(this.q, f2, fMax, false, this.wp);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.fv;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.fv = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.pf, this.iq);
        this.fv = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.fv.setDuration(1000L);
        this.fv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.pf = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.fv;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.ls;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.ls = null;
            }
            ValueAnimator valueAnimator = this.js;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.js = null;
            }
            ValueAnimator valueAnimator2 = this.p;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.p = null;
            }
            ValueAnimator valueAnimator3 = this.fv;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.fv = null;
            }
            this.pf = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float z(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void z() {
        AnimatorSet animatorSet = this.ls;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.ls.cancel();
            this.ls = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.ls = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.ls.setInterpolator(new LinearInterpolator());
        this.ls.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.tb = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.tb) {
                    CycleSkipView.this.tb = false;
                }
            }
        });
        this.ls.start();
    }

    public void z(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.gz = f;
        float f2 = i2;
        this.fo = f2;
        this.uy = i - i2;
        this.iq = f2 / f;
        z();
    }
}
