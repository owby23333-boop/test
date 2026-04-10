package com.amgcyo.cuttadon.view.otherview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.amgcyo.cuttadon.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConsecutiveScrollerLayout extends ViewGroup implements NestedScrollingParent {
    static final Interpolator M = new a();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    protected b H;
    private int I;
    private NestedScrollingParentHelper J;
    private View K;
    private int L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private OverScroller f4946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private VelocityTracker f4947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private VelocityTracker f4948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4951z;

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public interface b {
        void a(View view, int i2, int i3);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getRawX()
            int r0 = (int) r0
            float r1 = r8.getRawY()
            int r1 = (int) r1
            java.util.List r0 = com.amgcyo.cuttadon.view.otherview.l.a(r7, r0, r1)
            java.util.List r1 = com.amgcyo.cuttadon.view.otherview.l.a(r0)
            boolean r2 = super.dispatchTouchEvent(r8)
            int r3 = r8.getActionMasked()
            r4 = 1
            if (r3 == 0) goto L87
            r5 = 0
            if (r3 == r4) goto L57
            r6 = 2
            if (r3 == r6) goto L2d
            r0 = 3
            if (r3 == r0) goto L57
            r0 = 5
            if (r3 == r0) goto L87
            r0 = 6
            if (r3 == r0) goto L87
            goto L91
        L2d:
            boolean r3 = r7.F
            if (r3 == 0) goto L4e
            int r3 = r7.C
            int r3 = java.lang.Math.abs(r3)
            int r4 = r7.f4951z
            if (r3 < r4) goto L4e
            java.util.List r0 = com.amgcyo.cuttadon.view.otherview.l.a(r0)
            boolean r0 = com.amgcyo.cuttadon.view.otherview.l.a(r1, r0)
            if (r0 == 0) goto L4c
            int r0 = r7.C
            int r0 = -r0
            r7.scrollBy(r5, r0)
            goto L4e
        L4c:
            r7.F = r5
        L4e:
            r7.g()
            android.view.VelocityTracker r0 = r7.f4948w
            r0.addMovement(r8)
            goto L91
        L57:
            r7.D = r5
            android.view.VelocityTracker r0 = r7.f4948w
            if (r0 == 0) goto L84
            r0.addMovement(r8)
            boolean r8 = r7.F
            if (r8 == 0) goto L84
            android.widget.OverScroller r8 = r7.f4946u
            boolean r8 = r8.isFinished()
            if (r8 == 0) goto L84
            android.view.VelocityTracker r8 = r7.f4948w
            r0 = 1000(0x3e8, float:1.401E-42)
            int r1 = r7.f4949x
            float r1 = (float) r1
            r8.computeCurrentVelocity(r0, r1)
            android.view.VelocityTracker r8 = r7.f4948w
            float r8 = r8.getYVelocity()
            int r8 = (int) r8
            r7.k()
            int r8 = -r8
            r7.b(r8)
        L84:
            r7.F = r4
            goto L91
        L87:
            r7.h()
            android.view.VelocityTracker r0 = r7.f4948w
            r0.addMovement(r8)
            r7.F = r4
        L91:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.otherview.ConsecutiveScrollerLayout.a(android.view.MotionEvent):boolean");
    }

    private void b(int i2) {
        if (Math.abs(i2) > this.f4950y) {
            this.f4946u.fling(0, this.f4944s, 1, i2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            invalidate();
        }
    }

    private void c(int i2) {
        View viewC;
        int i3 = this.f4944s;
        do {
            int scrollY = 0;
            if (!e() && (viewC = c()) != null) {
                awakenScrollBars();
                int iF = l.f(viewC);
                if (iF < 0) {
                    int iC = l.c(viewC);
                    scrollY = Math.max(i2, iF);
                    a(viewC, scrollY);
                    int iC2 = l.c(viewC);
                    if (!l.h(viewC)) {
                        scrollY = iC2 - iC;
                    }
                } else {
                    int scrollY2 = getScrollY();
                    int scrollY3 = getScrollY();
                    d(scrollY2 + Math.max(i2, ((viewC.getTop() + getPaddingBottom()) - scrollY2) - getHeight()));
                    scrollY = getScrollY() - scrollY3;
                }
                this.f4944s += scrollY;
                i2 -= scrollY;
            }
            if (scrollY >= 0) {
                break;
            }
        } while (i2 < 0);
        int i4 = this.f4944s;
        if (i3 != i4) {
            b(i4, i3);
            o();
        }
    }

    private void d(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = this.f4945t;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        super.scrollTo(0, i2);
    }

    private void e(int i2) {
        View viewB;
        int i3 = this.f4944s;
        do {
            int scrollY = 0;
            if (!d() && (viewB = b()) != null) {
                awakenScrollBars();
                int iE = l.e(viewB);
                if (iE > 0) {
                    int iC = l.c(viewB);
                    scrollY = Math.min(i2, iE);
                    a(viewB, scrollY);
                    int iC2 = l.c(viewB);
                    if (!l.h(viewB)) {
                        scrollY = iC2 - iC;
                    }
                } else {
                    int scrollY2 = getScrollY();
                    d(getScrollY() + Math.min(i2, (viewB.getBottom() - getPaddingTop()) - getScrollY()));
                    scrollY = getScrollY() - scrollY2;
                }
                this.f4944s += scrollY;
                i2 -= scrollY;
            }
            if (scrollY <= 0) {
                break;
            }
        } while (i2 > 0);
        int i4 = this.f4944s;
        if (i3 != i4) {
            b(i4, i3);
            o();
        }
    }

    private void f() {
        int scrollY = getScrollY();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = nonGoneChildren.get(i2);
            if (l.g(view)) {
                scrollY += l.c(view);
            }
        }
        this.f4944s = scrollY;
    }

    private void g() {
        if (this.f4948w == null) {
            this.f4948w = VelocityTracker.obtain();
        }
    }

    private List<View> getEffectiveChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private List<View> getNonGoneChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private List<View> getStickyChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && a(childAt)) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private void h() {
        VelocityTracker velocityTracker = this.f4948w;
        if (velocityTracker == null) {
            this.f4948w = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void i() {
        VelocityTracker velocityTracker = this.f4947v;
        if (velocityTracker == null) {
            this.f4947v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void j() {
        if (this.f4947v == null) {
            this.f4947v = VelocityTracker.obtain();
        }
    }

    private void k() {
        VelocityTracker velocityTracker = this.f4948w;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4948w = null;
        }
    }

    private void l() {
        VelocityTracker velocityTracker = this.f4947v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4947v = null;
        }
    }

    @SuppressLint({"NewApi"})
    private void m() {
        for (View view : getNonGoneChildren()) {
            view.setTranslationY(0.0f);
            view.setTranslationZ(0.0f);
        }
    }

    private void n() {
        this.K = b();
        if (this.K != null) {
            this.L = getScrollY() - this.K.getTop();
        }
    }

    private void o() {
        View view;
        View view2;
        if (Build.VERSION.SDK_INT >= 21) {
            List<View> stickyChildren = getStickyChildren();
            if (stickyChildren.isEmpty()) {
                return;
            }
            int size = stickyChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = stickyChildren.get(i2);
                view3.setTranslationY(0.0f);
                view3.setTranslationZ(0.0f);
            }
            int i3 = size - 1;
            int i4 = i3;
            while (true) {
                view = null;
                if (i4 < 0) {
                    view2 = null;
                    break;
                }
                view2 = stickyChildren.get(i4);
                if (view2.getTop() > getScrollY()) {
                    i4--;
                } else if (i4 != i3) {
                    view = stickyChildren.get(i4 + 1);
                }
            }
            if (view2 != null) {
                b(view2, view != null ? Math.max(0, view2.getHeight() - (view.getTop() - getScrollY())) : 0);
            }
        }
    }

    private void p() {
        this.f4946u.abortAnimation();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipToPadding(false);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f4946u.computeScrollOffset()) {
            a(this.f4946u.getCurrY());
            invalidate();
        }
        if (this.f4946u.isFinished()) {
            a(false);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.f4944s;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int height = 0;
        for (int i2 = 0; i2 < size; i2++) {
            View view = nonGoneChildren.get(i2);
            height += !l.g(view) ? view.getHeight() : Math.max(l.d(view) + view.getPaddingTop() + view.getPaddingBottom(), view.getHeight());
        }
        return height;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionIndex()
            int r1 = r6.getActionMasked()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L6c
            if (r1 == r2) goto L63
            r4 = 2
            if (r1 == r4) goto L36
            r4 = 3
            if (r1 == r4) goto L63
            r4 = 5
            if (r1 == r4) goto L74
            r4 = 6
            if (r1 == r4) goto L1c
            goto L96
        L1c:
            int r1 = r5.I
            int r4 = r6.getPointerId(r0)
            if (r1 != r4) goto L96
            if (r0 != 0) goto L27
            goto L28
        L27:
            r2 = 0
        L28:
            int r0 = r6.getPointerId(r2)
            r5.I = r0
            float r0 = r6.getY(r2)
            int r0 = (int) r0
            r5.B = r0
            goto L96
        L36:
            int r0 = r5.I
            int r0 = r6.findPointerIndex(r0)
            float r1 = r6.getY(r0)
            int r1 = (int) r1
            int r3 = r5.B
            int r1 = r1 - r3
            boolean r3 = r5.b(r6)
            if (r3 == 0) goto L59
            int r3 = java.lang.Math.abs(r1)
            int r4 = r5.f4951z
            if (r3 < r4) goto L54
            r5.E = r2
        L54:
            boolean r3 = r5.E
            if (r3 != 0) goto L59
            return r2
        L59:
            r5.C = r1
            float r0 = r6.getY(r0)
            int r0 = (int) r0
            r5.B = r0
            goto L96
        L63:
            r5.C = r3
            r5.E = r3
            r5.B = r3
            r5.G = r3
            goto L96
        L6c:
            r5.p()
            r5.a(r3)
            r5.G = r2
        L74:
            int r1 = r6.getPointerId(r0)
            r5.I = r1
            float r1 = r6.getY(r0)
            int r1 = (int) r1
            r5.B = r1
            r5.requestDisallowInterceptTouchEvent(r3)
            int r1 = com.amgcyo.cuttadon.view.otherview.l.a(r5, r6, r0)
            int r0 = com.amgcyo.cuttadon.view.otherview.l.b(r5, r6, r0)
            android.view.View r0 = r5.a(r1, r0)
            boolean r0 = com.amgcyo.cuttadon.view.otherview.l.g(r0)
            r5.D = r0
        L96:
            boolean r0 = r5.D
            if (r0 == 0) goto L9f
            boolean r6 = r5.a(r6)
            goto La3
        L9f:
            boolean r6 = super.dispatchTouchEvent(r6)
        La3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.otherview.ConsecutiveScrollerLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public int getOwnScrollY() {
        return this.f4944s;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 2 && b(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        this.f4945t = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        while (i6 < size) {
            View view = nonGoneChildren.get(i6);
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, measuredHeight);
            this.f4945t += view.getHeight();
            i6++;
            paddingTop = measuredHeight;
        }
        this.f4945t -= (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        n();
        super.onMeasure(i2, i3);
        measureChildren(i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z2) {
        if (f3 > 0.0f) {
            if (d()) {
                return false;
            }
            if (!view.canScrollVertically(1)) {
                b((int) f3);
                return true;
            }
        } else {
            if (e()) {
                return false;
            }
            if (!view.canScrollVertically(-1)) {
                b((int) f3);
                return true;
            }
        }
        return super.onNestedFling(view, f2, f3, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return super.onNestedPreFling(view, f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        scrollBy(0, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.J.onNestedScrollAccepted(view, view2, i2);
        a(false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).b : false) && (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.J.onStopNestedScroll(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.I
            int r0 = r6.findPointerIndex(r0)
            int r1 = r6.getActionMasked()
            r2 = 1
            if (r1 == 0) goto L6e
            r3 = 0
            if (r1 == r2) goto L41
            r4 = 2
            if (r1 == r4) goto L1d
            r4 = 3
            if (r1 == r4) goto L41
            r3 = 5
            if (r1 == r3) goto L6e
            r3 = 6
            if (r1 == r3) goto L6e
            goto L7d
        L1d:
            int r1 = r5.A
            if (r1 != 0) goto L29
            float r6 = r6.getY(r0)
            int r6 = (int) r6
            r5.A = r6
            return r2
        L29:
            float r0 = r6.getY(r0)
            int r0 = (int) r0
            int r1 = r5.A
            int r1 = r0 - r1
            r5.A = r0
            int r0 = -r1
            r5.scrollBy(r3, r0)
            r5.j()
            android.view.VelocityTracker r0 = r5.f4947v
            r0.addMovement(r6)
            goto L7d
        L41:
            r5.A = r3
            android.view.VelocityTracker r0 = r5.f4947v
            if (r0 == 0) goto L7d
            r0.addMovement(r6)
            android.view.VelocityTracker r6 = r5.f4947v
            r0 = 1000(0x3e8, float:1.401E-42)
            int r1 = r5.f4949x
            float r1 = (float) r1
            r6.computeCurrentVelocity(r0, r1)
            android.view.VelocityTracker r6 = r5.f4947v
            float r6 = r6.getYVelocity()
            int r6 = (int) r6
            int r0 = r5.f4949x
            int r1 = -r0
            int r6 = java.lang.Math.min(r6, r0)
            int r6 = java.lang.Math.max(r1, r6)
            r5.l()
            int r6 = -r6
            r5.b(r6)
            goto L7d
        L6e:
            float r0 = r6.getY(r0)
            int r0 = (int) r0
            r5.A = r0
            r5.i()
            android.view.VelocityTracker r0 = r5.f4947v
            r0.addMovement(r6)
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.otherview.ConsecutiveScrollerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        scrollTo(0, this.f4944s + i3);
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        a(i3);
    }

    @Override // android.view.View
    @Deprecated
    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
    }

    public void setOnVerticalScrollChangeListener(b bVar) {
        this.H = bVar;
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C = 0;
        this.D = false;
        this.F = true;
        this.G = false;
        this.f4946u = new OverScroller(getContext(), M);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4949x = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4950y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4951z = ViewConfiguration.getTouchSlop();
        setWillNotDraw(false);
        setVerticalScrollBarEnabled(true);
        this.J = new NestedScrollingParentHelper(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public boolean d() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (effectiveChildren.size() > 0) {
            return getScrollY() >= this.f4945t && !effectiveChildren.get(effectiveChildren.size() - 1).canScrollVertically(1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void b(int i2, int i3) {
        b bVar = this.H;
        if (bVar != null) {
            bVar.a(this, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private void b(View view) {
        int iC;
        do {
            iC = 0;
            int iE = l.e(view);
            if (iE > 0) {
                int iC2 = l.c(view);
                a(view, iE);
                iC = iC2 - l.c(view);
            }
        } while (iC != 0);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4952c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = true;
            this.b = true;
            this.f4952c = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConsecutiveScrollerLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getBoolean(0, true);
            this.f4952c = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.b = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = true;
            this.b = true;
            this.f4952c = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = true;
            this.b = true;
            this.f4952c = false;
        }
    }

    @SuppressLint({"NewApi"})
    private void b(View view, int i2) {
        view.setY(getScrollY() - i2);
        view.setTranslationZ(1.0f);
        view.setClickable(true);
    }

    public View b() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = effectiveChildren.get(i2);
            if (view.getTop() <= scrollY && view.getBottom() > scrollY) {
                return view;
            }
        }
        return null;
    }

    private boolean b(MotionEvent motionEvent) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.I);
        View viewA = a(l.a(this, motionEvent, iFindPointerIndex), l.b(this, motionEvent, iFindPointerIndex));
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if ((!(layoutParams instanceof LayoutParams) || ((LayoutParams) layoutParams).a) && l.a(viewA)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (effectiveChildren.size() > 0) {
            return getScrollY() <= 0 && !effectiveChildren.get(0).canScrollVertically(-1);
        }
        return true;
    }

    private void c(View view) {
        int iC;
        do {
            iC = 0;
            int iF = l.f(view);
            if (iF > 0) {
                int iC2 = l.c(view);
                a(view, iF);
                iC = iC2 - l.c(view);
            }
        } while (iC != 0);
    }

    private void a(int i2) {
        int i3 = this.f4944s;
        int i4 = i2 - i3;
        if (i3 < i2) {
            e(i4);
        } else if (i3 > i2) {
            c(i4);
        }
    }

    public View c() {
        int height = (getHeight() - getPaddingBottom()) + getScrollY();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = effectiveChildren.get(i2);
            if (view.getTop() < height && view.getBottom() >= height) {
                return view;
            }
        }
        return null;
    }

    private void a(View view, int i2) {
        if (view instanceof AbsListView) {
            ((AbsListView) view).scrollListBy(i2);
        } else {
            view.scrollBy(0, i2);
        }
    }

    public void a() {
        View view = this.K;
        if (view != null) {
            if (indexOfChild(view) != -1) {
                d(this.K.getTop() + this.L);
            }
        } else {
            d(getScrollY());
        }
        this.K = null;
        this.L = 0;
        a(true);
        if (Build.VERSION.SDK_INT >= 21) {
            m();
            o();
        }
    }

    private void a(boolean z2) {
        int i2;
        if (this.G || !this.f4946u.isFinished()) {
            return;
        }
        int i3 = this.f4944s;
        View viewB = b();
        if (viewB == null) {
            return;
        }
        int iIndexOfChild = indexOfChild(viewB);
        if (z2) {
            int iE = l.e(viewB);
            int top = viewB.getTop() - getScrollY();
            if (iE > 0 && top < 0) {
                int iMin = Math.min(iE, -top);
                d(getScrollY() - iMin);
                a(viewB, iMin);
            }
        }
        for (int i4 = 0; i4 < iIndexOfChild; i4++) {
            View childAt = getChildAt(i4);
            if (l.g(childAt)) {
                b(childAt);
            }
        }
        while (true) {
            iIndexOfChild++;
            if (iIndexOfChild >= getChildCount()) {
                break;
            }
            View childAt2 = getChildAt(iIndexOfChild);
            if (l.g(childAt2)) {
                c(childAt2);
            }
        }
        f();
        if (z2 && i3 != (i2 = this.f4944s)) {
            b(i2, i3);
        }
        o();
    }

    private boolean a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).f4952c;
        }
        return false;
    }

    private View a(int i2, int i3) {
        for (View view : getNonGoneChildren()) {
            if (l.b(view, i2, i3)) {
                return view;
            }
        }
        return null;
    }
}
