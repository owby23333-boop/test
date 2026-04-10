package com.amgcyo.cuttadon.view.comic.zoomablerecyclerview;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import com.amgcyo.cuttadon.view.comic.m.d;

/* JADX INFO: compiled from: ScaleDragDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ScaleGestureDetector.OnScaleGestureListener {
    private final ScaleGestureDetector a;
    private final float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f4591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4592d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4593e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private VelocityTracker f4594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f4598j;

    public c(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4591c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b = viewConfiguration.getScaledTouchSlop();
        this.f4598j = dVar;
        this.a = new ScaleGestureDetector(context, this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setQuickScaleEnabled(false);
        }
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f4593e);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f4593e);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f4592d = motionEvent.getPointerId(0);
            this.f4594f = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f4594f;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f4596h = b(motionEvent);
            this.f4597i = c(motionEvent);
            this.f4595g = false;
        } else if (action == 1) {
            this.f4592d = -1;
            if (this.f4595g && this.f4594f != null) {
                this.f4596h = b(motionEvent);
                this.f4597i = c(motionEvent);
                this.f4594f.addMovement(motionEvent);
                this.f4594f.computeCurrentVelocity(1000);
                float xVelocity = this.f4594f.getXVelocity();
                float yVelocity = this.f4594f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f4591c) {
                    this.f4598j.a(this.f4596h, this.f4597i, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f4594f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f4594f = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f2 = fB - this.f4596h;
            float f3 = fC - this.f4597i;
            if (!this.f4595g) {
                this.f4595g = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.b);
            }
            if (this.f4595g) {
                this.f4598j.a(f2, f3);
                this.f4596h = fB;
                this.f4597i = fC;
                VelocityTracker velocityTracker3 = this.f4594f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f4592d = -1;
            VelocityTracker velocityTracker4 = this.f4594f;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f4594f = null;
            }
        } else if (action == 6) {
            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (motionEvent.getPointerId(action2) == this.f4592d) {
                int i2 = action2 == 0 ? 1 : 0;
                this.f4592d = motionEvent.getPointerId(i2);
                this.f4596h = motionEvent.getX(i2);
                this.f4597i = motionEvent.getY(i2);
            }
        }
        int i3 = this.f4592d;
        if (i3 == -1) {
            i3 = 0;
        }
        this.f4593e = motionEvent.findPointerIndex(i3);
        return true;
    }

    public boolean a() {
        return this.a.isInProgress();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.f4598j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f4598j.a();
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            this.a.onTouchEvent(motionEvent);
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
