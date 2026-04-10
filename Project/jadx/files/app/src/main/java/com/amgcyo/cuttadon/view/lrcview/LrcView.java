package com.amgcyo.cuttadon.view.lrcview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.amgcyo.cuttadon.R$styleable;
import com.anythink.expressad.video.module.a.a.m;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"StaticFieldLeak"})
public class LrcView extends View {
    private float A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private float J;
    private c K;
    private ValueAnimator L;
    private GestureDetector M;
    private Scroller N;
    private float O;
    private int P;
    private Object Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private GestureDetector.SimpleOnGestureListener W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Runnable f4874a0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<com.amgcyo.cuttadon.view.lrcview.c> f4875s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextPaint f4876t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextPaint f4877u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint.FontMetrics f4878v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f4879w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4880x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f4881y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4882z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!LrcView.this.a() || LrcView.this.K == null) {
                return super.onDown(motionEvent);
            }
            LrcView.this.N.forceFinished(true);
            LrcView lrcView = LrcView.this;
            lrcView.removeCallbacks(lrcView.f4874a0);
            LrcView.this.S = true;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (!LrcView.this.a()) {
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            LrcView lrcView = LrcView.this;
            LrcView.this.N.fling(0, (int) LrcView.this.O, 0, (int) f3, 0, 0, (int) lrcView.a(lrcView.f4875s.size() - 1), (int) LrcView.this.a(0));
            LrcView.this.T = true;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (!LrcView.this.a()) {
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            LrcView.this.U = true;
            LrcView.b(LrcView.this, -f3);
            LrcView lrcView = LrcView.this;
            lrcView.O = Math.min(lrcView.O, LrcView.this.a(0));
            LrcView lrcView2 = LrcView.this;
            float f4 = lrcView2.O;
            LrcView lrcView3 = LrcView.this;
            lrcView2.O = Math.max(f4, lrcView3.a(lrcView3.f4875s.size() - 1));
            LrcView.this.R = true;
            LrcView.this.invalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect bounds = LrcView.this.f4879w.getBounds();
            int i2 = bounds.right;
            if (LrcView.this.K.c()) {
                bounds.right = LrcView.this.getWidth() - (LrcView.this.H / 2);
            }
            boolean zContains = bounds.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            bounds.right = i2;
            if (LrcView.this.a() && LrcView.this.R && zContains) {
                int centerLine = LrcView.this.getCenterLine();
                long jD = ((com.amgcyo.cuttadon.view.lrcview.c) LrcView.this.f4875s.get(centerLine)).d();
                if (LrcView.this.K != null && LrcView.this.K.b()) {
                    LrcView.this.R = false;
                    LrcView lrcView = LrcView.this;
                    lrcView.removeCallbacks(lrcView.f4874a0);
                    LrcView.this.P = centerLine;
                    LrcView.this.invalidate();
                    LrcView.this.K.a(jD);
                    return true;
                }
            }
            if (LrcView.this.K == null) {
                return super.onSingleTapConfirmed(motionEvent);
            }
            LrcView.this.R = false;
            LrcView.this.invalidate();
            LrcView.this.K.a();
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LrcView.this.a() && LrcView.this.R) {
                LrcView.this.R = false;
                LrcView lrcView = LrcView.this;
                lrcView.b(lrcView.P);
            }
        }
    }

    public interface c {
        void a();

        void a(long j2);

        boolean b();

        boolean c();
    }

    public LrcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCenterLine() {
        int i2 = 0;
        float fAbs = Float.MAX_VALUE;
        for (int i3 = 0; i3 < this.f4875s.size(); i3++) {
            if (Math.abs(this.O - a(i3)) < fAbs) {
                fAbs = Math.abs(this.O - a(i3));
                i2 = i3;
            }
        }
        return i2;
    }

    private Object getFlag() {
        return this.Q;
    }

    private float getLrcWidth() {
        return getWidth() - (this.J * 2.0f);
    }

    private void setFlag(Object obj) {
        this.Q = obj;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.N.computeScrollOffset()) {
            this.O = this.N.getCurrY();
            invalidate();
        }
        if (this.T && this.N.isFinished()) {
            this.T = false;
            if (!a() || this.S) {
                return;
            }
            b();
            postDelayed(this.f4874a0, m.ag);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4874a0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        if (!a()) {
            this.f4876t.setColor(this.B);
            int lrcWidth = (int) getLrcWidth();
            String str = "lrcWidth: " + lrcWidth;
            if (lrcWidth > 0) {
                a(canvas, new StaticLayout(this.I, this.f4876t, lrcWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false), height);
                return;
            }
            return;
        }
        int centerLine = getCenterLine();
        if (this.R) {
            this.f4879w.draw(canvas);
            this.f4877u.setColor(this.E);
            float f2 = height;
            canvas.drawLine(this.H, f2, getWidth() - this.H, f2, this.f4877u);
            this.f4877u.setColor(this.F);
            String str2 = "第" + (this.f4875s.get(centerLine).d() + 1) + "段";
            float width = getWidth() - (this.H / 2);
            Paint.FontMetrics fontMetrics = this.f4878v;
            canvas.drawText(str2, width, f2 - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), this.f4877u);
        }
        float fA = 0.0f;
        canvas.translate(0.0f, this.O);
        for (int i2 = 0; i2 < this.f4875s.size(); i2++) {
            if (i2 > 0) {
                fA += ((this.f4875s.get(i2 - 1).a() + this.f4875s.get(i2).a()) >> 1) + this.f4880x;
            }
            if (i2 == this.P) {
                this.f4876t.setTextSize(this.C);
                this.f4876t.setColor(this.B);
            } else if (this.R && i2 == centerLine) {
                this.f4876t.setColor(this.D);
            } else {
                this.f4876t.setTextSize(this.A);
                this.f4876t.setColor(this.f4882z);
            }
            a(canvas, this.f4875s.get(i2).c(), fA);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            e();
            d();
            if (a()) {
                a(this.P, 0L);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.S = false;
            if (a() && !this.T) {
                b();
                postDelayed(this.f4874a0, m.ag);
            }
        }
        return this.M.onTouchEvent(motionEvent);
    }

    public void setCurrentColor(int i2) {
        this.B = i2;
        postInvalidate();
    }

    public void setCurrentTextSize(float f2) {
        this.C = f2;
    }

    public void setLabel(final String str) {
        a(new Runnable() { // from class: com.amgcyo.cuttadon.view.lrcview.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f4886s.a(str);
            }
        });
    }

    public void setNormalColor(int i2) {
        this.f4882z = i2;
        postInvalidate();
    }

    public void setNormalTextSize(float f2) {
        this.A = f2;
    }

    @Deprecated
    public void setOnPlayClickListener(c cVar) {
        this.K = cVar;
    }

    public void setTimeTextColor(int i2) {
        this.F = i2;
        postInvalidate();
    }

    public void setTimelineColor(int i2) {
        this.E = i2;
        postInvalidate();
    }

    public void setTimelineTextColor(int i2) {
        this.D = i2;
        postInvalidate();
    }

    public LrcView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4875s = new ArrayList();
        this.f4876t = new TextPaint();
        this.f4877u = new TextPaint();
        this.W = new a();
        this.f4874a0 = new b();
        a(attributeSet);
    }

    private void e() {
        int i2 = (this.H - this.G) / 2;
        int height = getHeight() / 2;
        int i3 = this.G;
        int i4 = height - (i3 / 2);
        this.f4879w.setBounds(i2, i4, i2 + i3, i3 + i4);
    }

    private void d() {
        if (!a() || getWidth() == 0) {
            return;
        }
        Iterator<com.amgcyo.cuttadon.view.lrcview.c> it = this.f4875s.iterator();
        while (it.hasNext()) {
            it.next().a(this.f4876t, (int) getLrcWidth(), this.V);
        }
        this.O = getHeight() / 2;
    }

    static /* synthetic */ float b(LrcView lrcView, float f2) {
        float f3 = lrcView.O + f2;
        lrcView.O = f3;
        return f3;
    }

    private void c() {
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.L.end();
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LrcView);
        this.C = typedArrayObtainStyledAttributes.getDimension(9, getResources().getDimension(R.dimen.lrc_text_size));
        this.A = typedArrayObtainStyledAttributes.getDimension(5, getResources().getDimension(R.dimen.lrc_text_size));
        if (this.A == 0.0f) {
            this.A = this.C;
        }
        this.f4880x = typedArrayObtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.lrc_divider_height));
        int integer = getResources().getInteger(R.integer.lrc_animation_duration);
        this.f4881y = typedArrayObtainStyledAttributes.getInt(0, integer);
        long j2 = this.f4881y;
        if (j2 < 0) {
            j2 = integer;
        }
        this.f4881y = j2;
        this.f4882z = typedArrayObtainStyledAttributes.getColor(4, getResources().getColor(R.color.lrc_normal_text_color));
        this.B = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.lrc_current_text_color));
        this.D = typedArrayObtainStyledAttributes.getColor(14, getResources().getColor(R.color.lrc_timeline_text_color));
        this.I = typedArrayObtainStyledAttributes.getString(3);
        this.I = TextUtils.isEmpty(this.I) ? getContext().getString(R.string.lrc_label) : this.I;
        this.J = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.E = typedArrayObtainStyledAttributes.getColor(12, getResources().getColor(R.color.lrc_timeline_color));
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, getResources().getDimension(R.dimen.lrc_timeline_height));
        this.f4879w = typedArrayObtainStyledAttributes.getDrawable(7);
        Drawable drawable = this.f4879w;
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.lrc_play);
        }
        this.f4879w = drawable;
        this.F = typedArrayObtainStyledAttributes.getColor(10, getResources().getColor(R.color.lrc_time_text_color));
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(11, getResources().getDimension(R.dimen.lrc_time_text_size));
        this.V = typedArrayObtainStyledAttributes.getInteger(8, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.G = (int) getResources().getDimension(R.dimen.lrc_drawable_width);
        this.H = (int) getResources().getDimension(R.dimen.lrc_time_width);
        this.f4876t.setAntiAlias(true);
        this.f4876t.setTextSize(this.C);
        this.f4876t.setTextAlign(Paint.Align.LEFT);
        this.f4877u.setAntiAlias(true);
        this.f4877u.setTextSize(dimension2);
        this.f4877u.setTextAlign(Paint.Align.CENTER);
        this.f4877u.setStrokeWidth(dimension);
        this.f4877u.setStrokeCap(Paint.Cap.ROUND);
        this.f4878v = this.f4877u.getFontMetrics();
        this.M = new GestureDetector(getContext(), this.W);
        this.M.setIsLongpressEnabled(false);
        this.N = new Scroller(getContext());
    }

    private void b() {
        a(getCenterLine(), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        a(i2, this.f4881y);
    }

    public /* synthetic */ void a(String str) {
        this.I = str;
        invalidate();
    }

    public boolean a() {
        return !this.f4875s.isEmpty();
    }

    private void a(Canvas canvas, StaticLayout staticLayout, float f2) {
        if (staticLayout != null) {
            canvas.save();
            canvas.translate(this.J, f2 - (staticLayout.getHeight() >> 1));
            staticLayout.draw(canvas);
            canvas.restore();
        }
    }

    private void a(int i2, long j2) {
        float fA = a(i2);
        c();
        this.L = ValueAnimator.ofFloat(this.O, fA);
        this.L.setDuration(j2);
        this.L.setInterpolator(new LinearInterpolator());
        this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amgcyo.cuttadon.view.lrcview.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f4885s.a(valueAnimator);
            }
        });
        d.a();
        this.L.start();
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.O = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(int i2) {
        if (this.f4875s.get(i2).b() == Float.MIN_VALUE) {
            float height = getHeight() / 2;
            for (int i3 = 1; i3 <= i2; i3++) {
                height -= ((this.f4875s.get(i3 - 1).a() + this.f4875s.get(i3).a()) >> 1) + this.f4880x;
            }
            this.f4875s.get(i2).a(height);
        }
        return this.f4875s.get(i2).b();
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
