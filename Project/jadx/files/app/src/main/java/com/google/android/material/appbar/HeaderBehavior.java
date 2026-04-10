package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Runnable f14957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f14958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private VelocityTracker f14963j;

    private class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final CoordinatorLayout f14964s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final V f14965t;

        a(CoordinatorLayout coordinatorLayout, V v2) {
            this.f14964s = coordinatorLayout;
            this.f14965t = v2;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f14965t == null || (overScroller = HeaderBehavior.this.f14958e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.a(this.f14964s, this.f14965t);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.b(this.f14964s, this.f14965t, headerBehavior.f14958e.getCurrY());
            ViewCompat.postOnAnimation(this.f14965t, this);
        }
    }

    public HeaderBehavior() {
        this.f14960g = -1;
        this.f14962i = -1;
    }

    final int a(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        return b(coordinatorLayout, v2, b() - i2, i3, i4);
    }

    void a(CoordinatorLayout coordinatorLayout, V v2) {
    }

    boolean a(V v2) {
        return false;
    }

    int b(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        return b(coordinatorLayout, v2, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int c(@NonNull V v2) {
        return v2.getHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f14962i < 0) {
            this.f14962i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f14959f) {
            int i2 = this.f14960g;
            if (i2 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y2 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y2 - this.f14961h) > this.f14962i) {
                this.f14961h = y2;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f14960g = -1;
            int x2 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            this.f14959f = a(v2) && coordinatorLayout.isPointInChildBounds(v2, x2, y3);
            if (this.f14959f) {
                this.f14961h = y3;
                this.f14960g = motionEvent.getPointerId(0);
                c();
                OverScroller overScroller = this.f14958e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f14958e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f14963j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f14960g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f14961h = r12
            goto L4c
        L2d:
            int r0 = r11.f14960g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f14961h
            int r7 = r1 - r0
            r11.f14961h = r0
            int r8 = r11.b(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.a(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f14963j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f14963j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f14963j
            int r4 = r11.f14960g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f14959f = r3
            r11.f14960g = r1
            android.view.VelocityTracker r13 = r11.f14963j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f14963j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f14963j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f14959f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    private void c() {
        if (this.f14963j == null) {
            this.f14963j = VelocityTracker.obtain();
        }
    }

    int b(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4) {
        int iClamp;
        int iA = a();
        if (i3 == 0 || iA < i3 || iA > i4 || iA == (iClamp = MathUtils.clamp(i2, i3, i4))) {
            return 0;
        }
        a(iClamp);
        return iA - iClamp;
    }

    final boolean a(CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2, int i3, float f2) {
        Runnable runnable = this.f14957d;
        if (runnable != null) {
            v2.removeCallbacks(runnable);
            this.f14957d = null;
        }
        if (this.f14958e == null) {
            this.f14958e = new OverScroller(v2.getContext());
        }
        this.f14958e.fling(0, a(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f14958e.computeScrollOffset()) {
            this.f14957d = new a(coordinatorLayout, v2);
            ViewCompat.postOnAnimation(v2, this.f14957d);
            return true;
        }
        a(coordinatorLayout, v2);
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14960g = -1;
        this.f14962i = -1;
    }

    int b() {
        return a();
    }

    int b(@NonNull V v2) {
        return -v2.getHeight();
    }
}
