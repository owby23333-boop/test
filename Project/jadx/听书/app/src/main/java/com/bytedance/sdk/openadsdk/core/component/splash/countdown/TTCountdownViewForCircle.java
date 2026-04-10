package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class TTCountdownViewForCircle extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f996a;
    private int dl;
    private float e;
    private boolean fo;
    private Paint fv;
    private int g;
    private float gc;
    private int gz;
    private AtomicBoolean h;
    private ValueAnimator hh;
    private String i;
    private AnimatorSet io;
    private RectF iq;
    private Paint js;
    private float kb;
    private boolean l;
    private Paint ls;
    private float m;
    private Paint p;
    private boolean pf;
    private float q;
    private ValueAnimator sy;
    private float tb;
    private ValueAnimator uf;
    private float uy;
    private boolean v;
    private float wp;
    private int z;
    private z zw;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public View getView() {
        return this;
    }

    public float z(float f, float f2) {
        return f * f2;
    }

    public float z(float f, int i) {
        return i * f;
    }

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = Color.parseColor("#fce8b6");
        this.g = Color.parseColor("#f0f0f0");
        this.dl = Color.parseColor("#ffffff");
        this.f996a = Color.parseColor("#7c7c7c");
        this.gc = 2.0f;
        this.m = 12.0f;
        this.e = 18.0f;
        this.gz = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.fo = false;
        this.uy = 5.0f;
        this.kb = 5.0f;
        this.wp = 0.8f;
        this.i = "跳过";
        this.v = false;
        this.pf = false;
        this.tb = 1.0f;
        this.q = 1.0f;
        this.l = false;
        this.h = new AtomicBoolean(true);
        this.gc = z(2.0f);
        this.e = z(18.0f);
        this.m = g(12.0f);
        this.gz %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        a();
        gc();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.ls = paint;
        paint.setColor(this.z);
        this.ls.setStrokeWidth(this.gc);
        this.ls.setAntiAlias(true);
        this.ls.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.p = paint2;
        paint2.setColor(this.dl);
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth(this.gc);
        this.p.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.fv = paint3;
        paint3.setColor(this.g);
        this.fv.setAntiAlias(true);
        this.fv.setStrokeWidth(this.gc / 2.0f);
        this.fv.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.js = paint4;
        paint4.setColor(this.f996a);
        this.fv.setAntiAlias(true);
        this.js.setTextSize(this.m);
        this.js.setTextAlign(Paint.Align.CENTER);
    }

    private void gc() {
        float f = this.e;
        this.iq = new RectF(-f, -f, f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = m();
        }
        if (mode2 != 1073741824) {
            size2 = m();
        }
        setMeasuredDimension(size, size2);
    }

    private int m() {
        return (int) ((((this.gc / 2.0f) + this.e) * 2.0f) + z(4.0f));
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
        Paint.FontMetrics fontMetrics = this.js.getFontMetrics();
        String strU = zw.g().u();
        this.i = strU;
        if (TextUtils.isEmpty(strU)) {
            this.i = "跳过";
        }
        canvas.drawText(this.i, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.js);
        canvas.restore();
    }

    private void g(Canvas canvas) {
        float f;
        canvas.save();
        float fZ = z(this.tb, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        if (this.fo) {
            f = this.gz - fZ;
        } else {
            f = this.gz;
        }
        canvas.drawCircle(0.0f, 0.0f, this.e, this.p);
        canvas.drawCircle(0.0f, 0.0f, this.e, this.fv);
        canvas.drawArc(this.iq, f, fZ, false, this.ls);
        canvas.restore();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void z() {
        if (this.pf) {
            return;
        }
        AnimatorSet animatorSet = this.io;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.io.cancel();
            this.io = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.io = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.io.setInterpolator(new LinearInterpolator());
        this.io.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.l = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.l) {
                    TTCountdownViewForCircle.this.l = false;
                } else if (TTCountdownViewForCircle.this.zw != null) {
                    TTCountdownViewForCircle.this.zw.z();
                }
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.io.start();
        if (this.h.get()) {
            return;
        }
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void z(boolean z) {
        this.pf = z;
        if (z) {
            e();
        }
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.uf;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.uf = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.q, 0.0f);
        this.uf = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.uf.setDuration((long) (z(this.q, this.kb) * 1000.0f));
        this.uf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.q = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.uf;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.sy;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.sy = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.tb, 0.0f);
        this.sy = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.sy.setDuration((long) (z(this.tb, this.uy) * 1000.0f));
        this.sy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.tb = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.sy;
    }

    private void e() {
        try {
            AnimatorSet animatorSet = this.io;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.io = null;
            }
            ValueAnimator valueAnimator = this.hh;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.hh = null;
            }
            ValueAnimator valueAnimator2 = this.uf;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.uf = null;
            }
            ValueAnimator valueAnimator3 = this.sy;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.sy = null;
            }
            this.tb = 1.0f;
            this.q = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void setCountDownTime(int i) {
        float f = i;
        this.kb = f;
        this.uy = f;
        e();
    }

    private float z(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float g(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public z getCountdownListener() {
        return this.zw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.a
    public void setCountdownListener(z zVar) {
        this.zw = zVar;
        this.h.get();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.h.set(z);
        if (this.pf) {
            return;
        }
        if (!this.h.get()) {
            g();
        } else {
            dl();
        }
    }

    public void g() {
        try {
            if (this.io != null) {
                this.io.pause();
            }
        } catch (Throwable unused) {
        }
    }

    public void dl() {
        try {
            if (this.pf || this.io == null) {
                return;
            }
            this.io.resume();
        } catch (Throwable unused) {
        }
    }
}
