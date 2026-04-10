package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: CustomGestureDetector.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    private int a = -1;
    private int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f14854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f14855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f14858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f14859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f14860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f14861j;

    /* JADX INFO: compiled from: CustomGestureDetector.java */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.f14861j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f14860i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f14859h = viewConfiguration.getScaledTouchSlop();
        this.f14861j = cVar;
        this.f14854c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            this.f14855d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f14855d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f14857f = b(motionEvent);
            this.f14858g = c(motionEvent);
            this.f14856e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.f14856e && this.f14855d != null) {
                this.f14857f = b(motionEvent);
                this.f14858g = c(motionEvent);
                this.f14855d.addMovement(motionEvent);
                this.f14855d.computeCurrentVelocity(1000);
                float xVelocity = this.f14855d.getXVelocity();
                float yVelocity = this.f14855d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f14860i) {
                    this.f14861j.a(this.f14857f, this.f14858g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f14855d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f14855d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f2 = fB - this.f14857f;
            float f3 = fC - this.f14858g;
            if (!this.f14856e) {
                this.f14856e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f14859h);
            }
            if (this.f14856e) {
                this.f14861j.a(f2, f3);
                this.f14857f = fB;
                this.f14858g = fC;
                VelocityTracker velocityTracker3 = this.f14855d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker4 = this.f14855d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f14855d = null;
            }
        } else if (action == 6) {
            int iA = m.a(motionEvent.getAction());
            if (motionEvent.getPointerId(iA) == this.a) {
                int i2 = iA == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i2);
                this.f14857f = motionEvent.getX(i2);
                this.f14858g = motionEvent.getY(i2);
            }
        }
        int i3 = this.a;
        if (i3 == -1) {
            i3 = 0;
        }
        this.b = motionEvent.findPointerIndex(i3);
        return true;
    }

    public boolean a() {
        return this.f14856e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            this.f14854c.onTouchEvent(motionEvent);
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.f14854c.isInProgress();
    }
}
