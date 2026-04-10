package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import androidx.core.view.ViewCompat;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes12.dex */
public final class t01 implements nd4 {
    public static final long h = 500;
    public static final long i = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17816b;
    public final Rect c;
    public final Drawable d;
    public final u01 e;
    public final a f;
    public boolean g;

    public static class a implements Runnable {
        public static final int h = 0;
        public static final int i = 1;
        public static final int j = 2;
        public static final float[] k = {255.0f};
        public static final float[] l = {0.0f};
        public float[] c;
        public View d;
        public long f;
        public final Interpolator e = new Interpolator(1, 2);
        public int g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17817a = ViewConfiguration.getScrollDefaultDelay();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17818b = ViewConfiguration.getScrollBarFadeDuration();

        public a(View view) {
            this.d = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis >= this.f) {
                int i2 = (int) jCurrentAnimationTimeMillis;
                Interpolator interpolator = this.e;
                interpolator.setKeyFrame(0, i2, k);
                interpolator.setKeyFrame(1, i2 + this.f17818b, l);
                this.g = 2;
                this.d.invalidate();
            }
        }
    }

    public t01(u01 u01Var) {
        View fastScrollableView = u01Var.getFastScrollableView();
        this.f17815a = fastScrollableView;
        fastScrollableView.setVerticalScrollBarEnabled(false);
        Drawable drawable2 = fastScrollableView.getResources().getDrawable(rt2.h.S3);
        this.d = drawable2;
        this.c = new Rect(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.e = u01Var;
        this.f = new a(fastScrollableView);
    }

    @Override // com.yuewen.nd4
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return h(motionEvent);
        }
        return false;
    }

    @Override // com.yuewen.nd4
    public void b(int i2) {
        if (i2 == 0 && ViewCompat.isAttachedToWindow(this.f17815a)) {
            f();
        }
    }

    @Override // com.yuewen.nd4
    public void c(Canvas canvas) {
        g(canvas);
    }

    @Override // com.yuewen.nd4
    public boolean d() {
        return e(500L);
    }

    public final boolean e(long j) {
        ViewCompat.postInvalidateOnAnimation(this.f17815a);
        if (this.g) {
            return false;
        }
        if (this.f.g == 0) {
            j = Math.max(500L, j);
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + j;
        this.f.f = jCurrentAnimationTimeMillis;
        this.f.g = 1;
        this.f17815a.removeCallbacks(this.f);
        this.f17815a.postDelayed(this.f, jCurrentAnimationTimeMillis - AnimationUtils.currentAnimationTimeMillis());
        return false;
    }

    public final boolean f() {
        return e(this.f.f17817a * 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.g
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r0 == 0) goto Ld
            android.graphics.drawable.Drawable r0 = r8.d
            r0.setAlpha(r1)
            goto L4a
        Ld:
            com.yuewen.t01$a r0 = r8.f
            int r3 = com.yuewen.t01.a.d(r0)
            if (r3 != 0) goto L16
            return
        L16:
            r4 = 2
            if (r3 != r4) goto L45
            float[] r1 = com.yuewen.t01.a.a(r0)
            r3 = 1
            if (r1 != 0) goto L25
            float[] r1 = new float[r3]
            com.yuewen.t01.a.f(r0, r1)
        L25:
            float[] r1 = com.yuewen.t01.a.a(r0)
            android.graphics.Interpolator r4 = com.yuewen.t01.a.c(r0)
            android.graphics.Interpolator$Result r4 = r4.timeToValues(r1)
            android.graphics.Interpolator$Result r5 = android.graphics.Interpolator.Result.FREEZE_END
            if (r4 != r5) goto L39
            com.yuewen.t01.a.g(r0, r2)
            goto L4b
        L39:
            android.graphics.drawable.Drawable r0 = r8.d
            r1 = r1[r2]
            int r1 = java.lang.Math.round(r1)
            r0.setAlpha(r1)
            goto L4b
        L45:
            android.graphics.drawable.Drawable r0 = r8.d
            r0.setAlpha(r1)
        L4a:
            r3 = r2
        L4b:
            boolean r0 = r8.i(r2)
            if (r0 == 0) goto L75
            android.view.View r0 = r8.f17815a
            int r0 = r0.getScrollY()
            android.view.View r1 = r8.f17815a
            int r1 = r1.getScrollX()
            android.graphics.drawable.Drawable r2 = r8.d
            android.graphics.Rect r4 = r8.c
            int r5 = r4.left
            int r5 = r5 + r1
            int r6 = r4.top
            int r6 = r6 + r0
            int r7 = r4.right
            int r7 = r7 + r1
            int r1 = r4.bottom
            int r1 = r1 + r0
            r2.setBounds(r5, r6, r7, r1)
            android.graphics.drawable.Drawable r0 = r8.d
            r0.draw(r9)
        L75:
            if (r3 == 0) goto L7c
            android.view.View r9 = r8.f17815a
            r9.invalidate()
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.t01.g(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            float r1 = r8.getY()
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L34
            if (r0 == r3) goto L2a
            r8 = 2
            if (r0 == r8) goto L16
            if (r0 == r2) goto L2a
            goto L8a
        L16:
            boolean r8 = r7.g
            if (r8 == 0) goto L8a
            float r8 = r7.f17816b
            float r8 = r1 - r8
            int r8 = java.lang.Math.round(r8)
            if (r8 == 0) goto L8a
            r7.i(r8)
            r7.f17816b = r1
            goto L8a
        L2a:
            boolean r8 = r7.g
            if (r8 == 0) goto L8a
            r7.g = r4
            r7.d()
            goto L8a
        L34:
            com.yuewen.t01$a r0 = r7.f
            int r0 = com.yuewen.t01.a.d(r0)
            if (r0 != 0) goto L3f
            r7.g = r4
            return r4
        L3f:
            boolean r0 = r7.g
            if (r0 != 0) goto L8a
            r7.i(r4)
            float r0 = r8.getX()
            android.graphics.Rect r5 = r7.c
            int r6 = r5.top
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 < 0) goto L8a
            int r6 = r5.bottom
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 > 0) goto L8a
            int r6 = r5.left
            float r6 = (float) r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L8a
            int r5 = r5.right
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L8a
            r7.g = r3
            r7.f17816b = r1
            com.yuewen.u01 r0 = r7.e
            r0.b(r8)
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r8)
            r8.setAction(r2)
            com.yuewen.u01 r0 = r7.e
            r0.b(r8)
            r8.recycle()
            r7.i(r4)
            android.view.View r8 = r7.f17815a
            com.yuewen.t01$a r0 = r7.f
            r8.removeCallbacks(r0)
        L8a:
            boolean r8 = r7.g
            if (r8 == 0) goto L9d
            android.view.View r8 = r7.f17815a
            r8.invalidate()
            android.view.View r8 = r7.f17815a
            android.view.ViewParent r8 = r8.getParent()
            r8.requestDisallowInterceptTouchEvent(r3)
            return r3
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.t01.h(android.view.MotionEvent):boolean");
    }

    public final boolean i(int i2) {
        int iWidth = this.c.width();
        this.c.right = this.f17815a.getWidth();
        Rect rect = this.c;
        rect.left = rect.right - iWidth;
        int iA = this.e.a();
        if (iA <= 0) {
            return false;
        }
        int iC = this.e.c();
        int iD = iA - this.e.d();
        if (iD <= 0) {
            return false;
        }
        float f = iD;
        int height = this.f17815a.getHeight();
        int iHeight = this.c.height();
        Rect rect2 = this.c;
        rect2.bottom = rect2.top + iHeight;
        int i3 = height - iHeight;
        float f2 = i3;
        int iRound = Math.round(((iC * 1.0f) / f) * f2);
        Rect rect3 = this.c;
        rect3.offsetTo(rect3.left, iRound);
        if (i2 == 0) {
            return true;
        }
        int i4 = iRound + i2;
        if (i4 <= i3) {
            i3 = i4 < 0 ? 0 : i4;
        }
        int iRound2 = Math.round(f * ((i3 * 1.0f) / f2)) - iC;
        View view = this.f17815a;
        if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(iRound2, 0);
            return true;
        }
        view.scrollBy(0, iRound2);
        return true;
    }

    @Override // com.yuewen.nd4
    public void onAttachedToWindow() {
        f();
    }

    @Override // com.yuewen.nd4
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return h(motionEvent);
    }

    @Override // com.yuewen.nd4
    public void onWindowVisibilityChanged(int i2) {
        if (i2 == 0) {
            f();
        }
    }
}
