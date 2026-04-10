package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class CycleCountDownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f1329a;
    protected int dl;
    protected boolean e;
    private String eo;
    protected float fo;
    private ValueAnimator fv;
    protected int g;
    protected float gc;
    private final Rect gk;
    protected float gz;
    private final Rect h;
    private boolean hh;
    private Paint i;
    private Bitmap io;
    private boolean iq;
    private ValueAnimator js;
    private boolean kb;
    private final RectF l;
    private final Rect lq;
    private float ls;
    protected int m;
    private final Rect mc;
    private String oq;
    private AnimatorSet p;
    private Paint pf;
    private boolean q;
    private boolean sy;
    private ValueAnimator tb;
    private String ti;
    private Bitmap uf;
    private float un;
    protected int uy;
    private Paint v;
    private String wj;
    private Paint wp;
    private final Rect x;
    protected int z;
    private Bitmap zw;

    public CycleCountDownView(Context context) {
        super(context);
        this.z = Color.parseColor("#FFDA7B");
        this.g = Color.parseColor("#4D000000");
        this.dl = Color.parseColor("#ffffff");
        this.m = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.e = false;
        this.gz = 5.0f;
        this.fo = 0.0f;
        this.uy = 0;
        this.kb = false;
        this.ls = 0.0f;
        this.q = false;
        this.iq = false;
        this.sy = false;
        this.hh = false;
        this.l = new RectF();
        this.h = new Rect();
        this.gk = new Rect();
        this.x = new Rect();
        this.lq = new Rect();
        this.mc = new Rect();
        this.un = 1.0f;
        this.f1329a = z(4.0f);
        this.gc = z(34.0f);
        this.m %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        g();
        dl();
        setBackgroundColor(-16711681);
    }

    private void g() {
        Paint paint = new Paint(1);
        this.wp = paint;
        paint.setColor(this.z);
        this.wp.setStrokeWidth(this.f1329a);
        this.wp.setAntiAlias(true);
        this.wp.setStrokeCap(Paint.Cap.ROUND);
        this.wp.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setColor(this.g);
        this.i.setAntiAlias(true);
        this.i.setStrokeWidth(this.f1329a);
        this.i.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.v = paint3;
        paint3.setColor(this.dl);
        this.v.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.pf = paint4;
        paint4.setFilterBitmap(true);
        this.pf.setDither(true);
    }

    private void dl() {
        this.zw = tb.a(getContext(), "tt_reward_chest_gift2");
        this.io = tb.a(getContext(), "tt_reward_chest_gift_open2");
        this.uf = z(getContext(), "tt_reward_chest_btn_bg");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = a();
        }
        if (mode2 != 1073741824) {
            size2 = a();
        }
        z(size, size2);
        setMeasuredDimension(size, size2);
        this.l.left = -this.gc;
        this.l.right = this.gc;
        this.l.top = -this.gc;
        this.l.bottom = this.gc;
        this.h.left = 0;
        this.h.top = 0;
        Rect rect = this.h;
        Bitmap bitmap = this.zw;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap2 = this.zw;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        this.gk.left = 0;
        this.gk.top = 0;
        Rect rect3 = this.gk;
        Bitmap bitmap3 = this.io;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.gk;
        Bitmap bitmap4 = this.io;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        int i3 = -minLine;
        int i4 = i3 / 2;
        this.x.left = i4;
        this.x.top = i4;
        int i5 = minLine / 2;
        this.x.right = i5;
        this.x.bottom = i5;
        this.lq.left = 0;
        this.lq.top = 0;
        this.lq.right = this.uf.getWidth();
        this.lq.bottom = this.uf.getHeight();
        this.mc.left = i3 / 3;
        this.mc.top = minLine / 8;
        int i6 = minLine / 3;
        this.mc.right = i6;
        this.mc.bottom = i6;
        this.v.setTextSize(((this.mc.bottom - this.mc.top) / 2) - g(2.0f));
    }

    private int a() {
        return (int) ((((this.f1329a / 2.0f) + this.gc) * 2.0f) + z(4.0f));
    }

    private void z(int i, int i2) {
        this.gc = (Math.min(i, i2) / 2.0f) - this.f1329a;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        z(canvas);
        dl(canvas);
        g(canvas);
    }

    private void z(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.uy <= 0 && (bitmap = this.io) != null) {
            boolean z2 = this.sy;
            if (!(z2 && this.hh) && (z2 || this.hh)) {
                bitmap = this.zw;
            } else {
                z = true;
            }
        } else {
            bitmap = this.zw;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.gk : this.h, this.x, this.pf);
        }
        canvas.restore();
    }

    private void g(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.uf, this.lq, this.mc, this.pf);
        Paint.FontMetrics fontMetrics = this.v.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        String str = (!TextUtils.isEmpty(this.wj) && this.uy <= 0) ? this.wj : this.ti + this.uy + this.eo;
        if (this.kb) {
            str = str + "｜" + this.oq;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.v);
        canvas.restore();
    }

    private void dl(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.ls * 360.0f;
        if (this.e) {
            f = this.m - f2;
        } else {
            f = this.m;
        }
        canvas.drawCircle(0.0f, 0.0f, this.gc, this.i);
        canvas.drawArc(this.l, f, f2, false, this.wp);
        canvas.restore();
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.js;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.js = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.ls, this.un);
        this.js = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.js.setDuration(1000L);
        this.js.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.ls = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.js;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.p;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.p = null;
            }
            ValueAnimator valueAnimator = this.tb;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.tb = null;
            }
            ValueAnimator valueAnimator2 = this.fv;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.fv = null;
            }
            ValueAnimator valueAnimator3 = this.js;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.js = null;
            }
            this.ls = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    private float z(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private float g(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void z() {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.p.cancel();
            this.p = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.p = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.p.setInterpolator(new LinearInterpolator());
        this.p.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.q = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.q) {
                    CycleCountDownView.this.q = false;
                } else {
                    CycleCountDownView.this.iq = true;
                }
            }
        });
        this.p.start();
    }

    public void z(int i, int i2, int i3) {
        float f = i;
        this.gz = f;
        float f2 = i2;
        this.fo = f2;
        this.uy = i3;
        this.un = f2 / f;
        z();
    }

    private Bitmap z(Context context, String str) {
        Drawable drawableDl = tb.dl(context, str);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableDl.getIntrinsicWidth(), drawableDl.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableDl.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableDl.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCanSkip(boolean z) {
        this.kb = z;
    }

    public void z(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.ti = str;
        this.eo = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.oq = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.wj = str4;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.zw = bitmap;
        this.sy = true;
        this.h.left = 0;
        this.h.top = 0;
        Rect rect = this.h;
        Bitmap bitmap2 = this.zw;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap3 = this.zw;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.io = bitmap;
        this.hh = true;
        this.gk.left = 0;
        this.gk.top = 0;
        Rect rect = this.gk;
        Bitmap bitmap2 = this.io;
        rect.right = bitmap2 != null ? bitmap2.getWidth() : 0;
        Rect rect2 = this.gk;
        Bitmap bitmap3 = this.io;
        rect2.bottom = bitmap3 != null ? bitmap3.getHeight() : 0;
    }
}
