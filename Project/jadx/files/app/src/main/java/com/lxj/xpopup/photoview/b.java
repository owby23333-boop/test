package com.lxj.xpopup.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: CustomGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
class b {
    private int a = -1;
    private int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f17496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f17497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f17500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f17501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f17502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f17503j;

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
            b.this.f17503j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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
        this.f17502i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f17501h = viewConfiguration.getScaledTouchSlop();
        this.f17503j = cVar;
        this.f17496c = new ScaleGestureDetector(context, new a());
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
            this.f17497d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f17497d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f17499f = b(motionEvent);
            this.f17500g = c(motionEvent);
            this.f17498e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.f17498e && this.f17497d != null) {
                this.f17499f = b(motionEvent);
                this.f17500g = c(motionEvent);
                this.f17497d.addMovement(motionEvent);
                this.f17497d.computeCurrentVelocity(1000);
                float xVelocity = this.f17497d.getXVelocity();
                float yVelocity = this.f17497d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f17502i) {
                    this.f17503j.a(this.f17499f, this.f17500g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f17497d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f17497d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f2 = fB - this.f17499f;
            float f3 = fC - this.f17500g;
            if (!this.f17498e) {
                this.f17498e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f17501h);
            }
            if (this.f17498e) {
                this.f17503j.a(f2, f3);
                this.f17499f = fB;
                this.f17500g = fC;
                VelocityTracker velocityTracker3 = this.f17497d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker4 = this.f17497d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f17497d = null;
            }
        } else if (action == 6) {
            int iA = l.a(motionEvent.getAction());
            if (motionEvent.getPointerId(iA) == this.a) {
                int i2 = iA == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i2);
                this.f17499f = motionEvent.getX(i2);
                this.f17500g = motionEvent.getY(i2);
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
        return this.f17498e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f17496c.onTouchEvent(motionEvent);
            }
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.f17496c.isInProgress();
    }
}
