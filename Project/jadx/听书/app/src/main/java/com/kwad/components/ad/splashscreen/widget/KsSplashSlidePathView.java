package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path Li;
    private Paint Lj;
    private float Lk;
    private float Ll;
    private float Lm;
    private float Ln;
    private int Lo;
    private a Lp;
    private GestureDetector Lq;

    public interface a {
        void a(float f, float f2, float f3, float f4);

        void c(MotionEvent motionEvent);
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.Lo = Color.parseColor("#66ffffff");
        init();
    }

    public KsSplashSlidePathView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lo = Color.parseColor("#66ffffff");
        init();
    }

    private void init() {
        this.Li = new Path();
        Paint paint = new Paint();
        this.Lj = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.Lj.setStrokeWidth(com.kwad.sdk.c.a.a.a(getContext(), 15.0f));
        this.Lj.setStyle(Paint.Style.STROKE);
        this.Lj.setColor(this.Lo);
        this.Lj.setDither(true);
        this.Lq = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.Lp == null) {
                    return false;
                }
                KsSplashSlidePathView.this.Lp.c(motionEvent);
                return true;
            }
        });
    }

    public void setOnSlideTouchListener(a aVar) {
        this.Lp = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d(motionEvent);
        return true;
    }

    private void d(MotionEvent motionEvent) {
        if (this.Lq.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Li.reset();
            this.Lk = motionEvent.getX();
            float y = motionEvent.getY();
            this.Ll = y;
            float f = this.Lk;
            this.Lm = f;
            this.Ln = y;
            this.Li.moveTo(f, y);
            invalidate();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            b(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.Li.reset();
        invalidate();
        a aVar = this.Lp;
        if (aVar != null) {
            aVar.a(this.Lk, this.Ll, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void b(float f, float f2) {
        float fAbs = Math.abs(f - this.Lm);
        float fAbs2 = Math.abs(f2 - this.Ln);
        if (fAbs >= 3.0f || fAbs2 >= 3.0f) {
            Path path = this.Li;
            float f3 = this.Lm;
            float f4 = this.Ln;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.Lm = f;
            this.Ln = f2;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.Li, this.Lj);
    }
}
