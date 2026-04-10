package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.dt;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes10.dex */
public class TTRewardChestView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2124b;
    protected int bf;
    private Paint bh;
    private boolean bm;
    private boolean bx;
    private ValueAnimator cv;
    protected int d;
    private AnimatorSet dt;
    protected int e;
    private float f;
    private Bitmap fy;
    protected float ga;
    private Bitmap h;
    private int hb;
    private RectF k;
    private float l;
    private boolean lc;
    protected int m;
    protected int p;
    private ValueAnimator pe;
    private Paint s;
    private Paint t;
    protected float tg;
    private Bitmap uk;
    protected boolean v;
    protected float vn;
    private Paint w;
    private boolean wl;
    protected int wu;
    private int x;
    protected double xu;
    private ValueAnimator y;
    private boolean za;
    protected float zk;

    public TTRewardChestView(Context context) {
        this(context, null);
    }

    private void d(Canvas canvas) {
        canvas.save();
        float f = this.l * 360.0f;
        float f2 = this.v ? this.p - f : this.p;
        if (this.bm) {
            canvas.drawCircle(0.0f, 0.0f, this.vn, this.t);
        }
        if (this.bx) {
            canvas.drawArc(this.k, f2, f, false, this.bh);
        }
        canvas.restore();
    }

    private void ga() {
        Paint paint = new Paint(1);
        this.bh = paint;
        paint.setColor(this.e);
        this.bh.setStrokeWidth(this.tg);
        this.bh.setAntiAlias(true);
        this.bh.setStrokeCap(Paint.Cap.ROUND);
        this.bh.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.t = paint2;
        paint2.setColor(this.bf);
        this.t.setAntiAlias(true);
        this.t.setStrokeWidth(this.tg);
        this.t.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.s = paint3;
        paint3.setColor(this.d);
        this.s.setTextSize(this.ga);
        this.s.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.w = paint4;
        paint4.setFilterBitmap(true);
        this.w.setDither(true);
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        float f = this.l;
        long j = (long) (this.zk * f * 1000.0f);
        if (j < 0) {
            j = 0;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
        this.y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.y.setDuration(j);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.TTRewardChestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTRewardChestView.this.l = 1.0f - ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTRewardChestView.this.postInvalidate();
            }
        });
        return this.y;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.pe;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.pe = null;
        }
        float f = this.f;
        long j = (long) (this.zk * f * 1000.0f);
        if (j < 0) {
            j = 0;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
        this.pe = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.pe.setDuration(j);
        this.pe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.TTRewardChestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTRewardChestView.this.f = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTRewardChestView.this.postInvalidate();
            }
        });
        return this.pe;
    }

    private void m() {
        try {
            AnimatorSet animatorSet = this.dt;
            if (animatorSet != null) {
                animatorSet.resume();
            }
        } catch (Throwable unused) {
        }
    }

    private int p() {
        return (int) ((((this.tg / 2.0f) + this.vn) * 2.0f) + e(4.0f));
    }

    private void v() {
        try {
            AnimatorSet animatorSet = this.dt;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.dt = null;
            }
            ValueAnimator valueAnimator = this.cv;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.cv = null;
            }
            ValueAnimator valueAnimator2 = this.pe;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.pe = null;
            }
            ValueAnimator valueAnimator3 = this.y;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.y = null;
            }
            this.l = 1.0f;
            this.f = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private void vn() {
        this.uk = BitmapFactory.decodeResource(getResources(), dt.tg(getContext(), "tt_reward_chest_box"));
        this.h = BitmapFactory.decodeResource(getResources(), dt.tg(getContext(), "tt_reward_box_time_bg"));
    }

    private void zk() {
        try {
            AnimatorSet animatorSet = this.dt;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        v();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.lc && this.m != -1 && !this.f2123a) {
            if (((int) Math.ceil(this.f * this.zk)) <= this.m) {
                zk();
            } else {
                m();
            }
        }
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        d(canvas);
        e(canvas);
        bf(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = p();
        }
        if (mode2 != 1073741824) {
            size2 = p();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCountDownTime(int i) {
        if (i <= 0) {
            this.za = true;
        }
        this.zk = i;
        this.m = i;
        this.wu = i;
        v();
    }

    public void setRewardDrawType(boolean z) {
        this.lc = z;
        this.xu = 2.2d;
        this.uk = BitmapFactory.decodeResource(getResources(), dt.tg(getContext(), "tt_reward_chest_gift2"));
        this.fy = BitmapFactory.decodeResource(getResources(), dt.tg(getContext(), "tt_reward_chest_gift_open2"));
        this.h = e(dt.tg(getContext(), "tt_reward_chest_btn_bg"));
        this.d = Color.parseColor("#FFE3AA");
        this.vn = e(26.0f);
        this.ga = bf(10.0f);
        int i = (int) (this.vn + 14.0f);
        this.x = i;
        this.hb = i + 6;
        this.tg = e(2.0f);
        float f = this.vn;
        this.k = new RectF(-f, -f, f, f);
        ga();
    }

    public void setRewardLuStyle(boolean z) {
        this.f2124b = z;
        this.bx = false;
        this.x = 22;
        this.hb = 22 + 2;
        this.uk = BitmapFactory.decodeResource(getResources(), dt.tg(getContext(), "tt_shop_page_red_bag"));
        ga();
    }

    public void tg() {
        this.f2123a = false;
        m();
    }

    public TTRewardChestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRewardChestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = Color.parseColor("#FFDA7B");
        this.bf = Color.parseColor("#4D000000");
        this.d = Color.parseColor("#D9255B");
        this.p = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.v = false;
        this.zk = 5.0f;
        this.m = -1;
        this.wu = -1;
        this.xu = 3.5d;
        this.l = 1.0f;
        this.f = 1.0f;
        this.wl = false;
        this.za = false;
        this.x = 12;
        this.hb = 12;
        this.bx = true;
        this.bm = true;
        this.tg = e(4.0f);
        this.vn = e(34.0f);
        this.ga = bf(8.0f);
        this.p %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        float f = this.vn;
        this.k = new RectF(-f, -f, f, f);
        ga();
        vn();
    }

    private void bf(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        float f = fontMetrics.bottom;
        float f2 = fontMetrics.top;
        float f3 = ((f - f2) / 2.0f) + (((f - f2) / 2.0f) - f) + this.hb + 4.0f;
        if (!this.lc && !this.f2124b) {
            if (this.za) {
                str = "已领取";
            } else {
                str = "倒计时" + ((int) Math.ceil(this.f * this.zk)) + "s";
            }
        } else if (this.za) {
            str = "奖励已领取";
        } else {
            str = this.wu + "s后领取";
        }
        canvas.drawText(str, 0.0f, f3, this.s);
        canvas.restore();
    }

    private void e(Canvas canvas) {
        Bitmap bitmap;
        double height;
        canvas.save();
        if (!this.za || (bitmap = this.fy) == null) {
            bitmap = this.uk;
        }
        double width = 1.0d;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            height = ((double) bitmap.getHeight()) / ((double) bitmap.getWidth());
        } else if (bitmap.getHeight() > bitmap.getWidth()) {
            height = 1.0d;
            width = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
        } else {
            height = 1.0d;
        }
        int measuredWidth = (int) ((((double) getMeasuredWidth()) / this.xu) * width);
        int measuredHeight = (int) ((((double) getMeasuredHeight()) / this.xu) * height);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(-measuredWidth, -measuredHeight, measuredWidth, measuredHeight), this.w);
        int width2 = this.h.getWidth();
        int height2 = this.h.getHeight();
        Rect rect = new Rect(0, 0, width2, height2);
        int i = this.x;
        canvas.drawBitmap(this.h, rect, new Rect((-r2) - 6, i, (width2 - (width2 / 2)) + 6, height2 + i), this.w);
        canvas.restore();
    }

    public void d() {
        this.f2123a = true;
        zk();
    }

    private float bf(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void bf() {
        AnimatorSet animatorSet = this.dt;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.dt.cancel();
            this.dt = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.dt = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.dt.setInterpolator(new LinearInterpolator());
        this.dt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.TTRewardChestView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTRewardChestView.this.wl = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTRewardChestView.this.wl) {
                    TTRewardChestView.this.wl = false;
                } else if (!TTRewardChestView.this.f2124b) {
                    TTRewardChestView.this.za = true;
                } else {
                    TTRewardChestView tTRewardChestView = TTRewardChestView.this;
                    tTRewardChestView.za = tTRewardChestView.wu <= 0;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        this.dt.start();
    }

    private Bitmap e(int i) {
        Drawable drawable2 = getResources().getDrawable(i, null);
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable2.draw(canvas);
        return bitmapCreateBitmap;
    }

    private float e(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void e() {
        this.za = true;
        this.l = 1.0f;
        AnimatorSet animatorSet = this.dt;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.dt.cancel();
        this.dt = null;
    }

    public void e(int i, int i2) {
        this.m = (int) Math.ceil(this.zk - i);
        this.wu = i2;
        m();
        AnimatorSet animatorSet = this.dt;
        if (animatorSet != null && !animatorSet.isRunning() && this.wu > 0) {
            this.za = false;
            bf();
        }
        if (!this.f2124b || this.wu > 0) {
            return;
        }
        if (!this.za) {
            invalidate();
        }
        this.za = true;
    }
}
