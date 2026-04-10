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
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path FR;
    private Paint FS;
    private float FT;
    private float FU;
    private float FV;
    private float FW;
    private int FX;
    private a FY;
    private GestureDetector nX;

    public interface a {
        void a(float f2, float f3, float f4, float f5);

        void lA();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.FX = Color.parseColor("#66ffffff");
        init();
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FX = Color.parseColor("#66ffffff");
        init();
    }

    private void b(MotionEvent motionEvent) {
        if (this.nX.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.FR.reset();
            this.FT = motionEvent.getX();
            this.FU = motionEvent.getY();
            float f2 = this.FT;
            this.FV = f2;
            float f3 = this.FU;
            this.FW = f3;
            this.FR.moveTo(f2, f3);
            invalidate();
            if (this.FY != null) {
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            c(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.FR.reset();
        invalidate();
        a aVar = this.FY;
        if (aVar != null) {
            aVar.a(this.FT, this.FU, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void c(float f2, float f3) {
        float fAbs = Math.abs(f2 - this.FV);
        float fAbs2 = Math.abs(f3 - this.FW);
        if (fAbs >= 3.0f || fAbs2 >= 3.0f) {
            Path path = this.FR;
            float f4 = this.FV;
            float f5 = this.FW;
            path.quadTo(f4, f5, (f2 + f4) / 2.0f, (f3 + f5) / 2.0f);
            this.FV = f2;
            this.FW = f3;
        }
    }

    private void init() {
        this.FR = new Path();
        this.FS = new Paint();
        this.FS.setStrokeCap(Paint.Cap.ROUND);
        this.FS.setStrokeWidth(com.kwad.sdk.b.kwai.a.a(getContext(), 15.0f));
        this.FS.setStyle(Paint.Style.STROKE);
        this.FS.setColor(this.FX);
        this.FS.setDither(true);
        this.nX = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.FY == null) {
                    return false;
                }
                KsSplashSlidePathView.this.FY.lA();
                return true;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.FR, this.FS);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.FY = aVar;
    }
}
