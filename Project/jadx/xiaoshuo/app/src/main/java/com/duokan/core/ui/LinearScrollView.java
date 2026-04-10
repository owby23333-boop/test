package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.n;
import com.yuewen.e84;

/* JADX INFO: loaded from: classes12.dex */
public class LinearScrollView extends LinearLayout implements Scrollable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2907b;
    public int c;
    public int d;
    public int e;

    public class a extends n {
        public a() {
            super(LinearScrollView.this, LinearScrollView.this);
        }

        @Override // com.duokan.core.ui.n
        public void W1(Canvas canvas) {
            LinearScrollView.super.draw(canvas);
        }

        @Override // com.duokan.core.ui.n
        public void X1(int i, int i2) {
            LinearScrollView.super.scrollTo(i, i2);
        }
    }

    public LinearScrollView(Context context) {
        this(context, null);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean A0(int i) {
        return this.f2906a.A0(i);
    }

    @Override // com.duokan.core.ui.Scrollable
    public Rect A1(Rect rect) {
        return this.f2906a.A1(rect);
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean B0() {
        return this.f2906a.B0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public void C0(boolean z) {
        this.f2906a.C0(z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean D() {
        return this.f2906a.D();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final Rect D0() {
        return this.f2906a.D0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public void E0(boolean z) {
        this.f2906a.E0(z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void G0(int i, int i2, int i3, int i4) {
        this.f2906a.G0(i, i2, i3, i4);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void H0(int i, int i2, int i3, int i4) {
        this.f2906a.H0(i, i2, i3, i4);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void I1() {
        this.f2906a.I1();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void J0(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f2906a.J0(i, i2, i3, runnable, runnable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public Point K0(Point point) {
        return this.f2906a.K0(point);
    }

    @Override // com.duokan.core.ui.Scrollable
    public Rect M1(Rect rect) {
        return this.f2906a.M1(rect);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void R0(boolean z) {
        this.f2906a.R0(z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean R1() {
        return this.f2906a.R1();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void S(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f2906a.S(i, i2, i3, runnable, runnable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public Point Z0(Point point) {
        return this.f2906a.Z0(point);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void a1(View view, boolean z) {
        this.f2906a.a1(view, z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean b1() {
        return this.f2906a.b1();
    }

    public a c() {
        return new a();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return this.f2906a.N();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return this.f2906a.O();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return this.f2906a.P();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return this.f2906a.Q();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.f2906a.R();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return this.f2906a.T();
    }

    public boolean d(View view, boolean z) {
        return this.f2906a.y1(view, z);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f2906a.v1(canvas);
        this.f2906a.G(canvas);
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean e1() {
        return this.f2906a.e1();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getContentHeight() {
        return this.f2906a.getContentHeight();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getContentWidth() {
        return this.f2906a.getContentWidth();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Scrollable.OverScrollMode getHorizontalOverScrollMode() {
        return this.f2906a.getHorizontalOverScrollMode();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Drawable getHorizontalSeekDrawable() {
        return this.f2906a.getHorizontalSeekDrawable();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Drawable getHorizontalThumbDrawable() {
        return this.f2906a.getHorizontalThumbDrawable();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getHorizontalThumbMarginBottom() {
        return this.f2906a.getHorizontalThumbMarginBottom();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getHorizontalThumbMarginLeft() {
        return this.f2906a.getHorizontalThumbMarginLeft();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getHorizontalThumbMarginRight() {
        return this.f2906a.getHorizontalThumbMarginRight();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getHorizontalThumbMarginTop() {
        return this.f2906a.getHorizontalThumbMarginTop();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getIdleTime() {
        return this.f2906a.getIdleTime();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getMaxOverScrollHeight() {
        return this.f2906a.getMaxOverScrollHeight();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getMaxOverScrollWidth() {
        return this.f2906a.getMaxOverScrollWidth();
    }

    @Override // com.duokan.core.ui.Scrollable
    public m getScrollDetector() {
        return this.f2906a.getScrollDetector();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getScrollFinalX() {
        return this.f2906a.getScrollFinalX();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getScrollFinalY() {
        return this.f2906a.getScrollFinalY();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final Scrollable.ScrollState getScrollState() {
        return this.f2906a.getScrollState();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final int getScrollTime() {
        return this.f2906a.getScrollTime();
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean getSeekEnabled() {
        return this.f2906a.getSeekEnabled();
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean getThumbEnabled() {
        return this.f2906a.getThumbEnabled();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Scrollable.OverScrollMode getVerticalOverScrollMode() {
        return this.f2906a.getVerticalOverScrollMode();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Drawable getVerticalSeekDrawable() {
        return this.f2906a.getVerticalSeekDrawable();
    }

    @Override // com.duokan.core.ui.Scrollable
    public Drawable getVerticalThumbDrawable() {
        return this.f2906a.getVerticalThumbDrawable();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getVerticalThumbMarginBottom() {
        return this.f2906a.getVerticalThumbMarginBottom();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getVerticalThumbMarginLeft() {
        return this.f2906a.getVerticalThumbMarginLeft();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getVerticalThumbMarginRight() {
        return this.f2906a.getVerticalThumbMarginRight();
    }

    @Override // com.duokan.core.ui.Scrollable
    public int getVerticalThumbMarginTop() {
        return this.f2906a.getVerticalThumbMarginTop();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final Rect getViewportBounds() {
        return this.f2906a.getViewportBounds();
    }

    @Override // com.duokan.core.ui.Scrollable
    public void h1() {
        this.f2906a.h1();
    }

    @Override // android.view.View
    public boolean isHorizontalFadingEdgeEnabled() {
        return this.f2906a.j0();
    }

    @Override // android.view.View
    public boolean isHorizontalScrollBarEnabled() {
        return this.f2906a.k0();
    }

    @Override // android.view.View
    public boolean isVerticalFadingEdgeEnabled() {
        return this.f2906a.n0();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        return this.f2906a.q0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean l0() {
        return this.f2906a.l0();
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (getOrientation() == 0 && view.getLayoutParams().width == -1) {
            i = this.f2907b;
        }
        int i5 = i;
        if (getOrientation() == 1 && view.getLayoutParams().height == -1) {
            i3 = this.c;
            i4 = 0;
        }
        super.measureChildWithMargins(view, i5, 0, i3, i4);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void o0(int i, int i2) {
        this.f2906a.o0(i, i2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void o1(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2) {
        this.f2906a.o1(rect, rect2, i, runnable, runnable2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2906a.E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2906a.F();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2906a.k1(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getOrientation() == 0) {
            super.onLayout(z, i, i2, i + this.d, i4);
        } else {
            super.onLayout(z, i, i2, i3, i2 + this.e);
        }
        if (z) {
            if (getOrientation() == 0) {
                setMaxOverScrollHeight(0);
                setMaxOverScrollWidth(e84.e0(getContext()));
            } else {
                setMaxOverScrollWidth(0);
                setMaxOverScrollHeight(e84.e0(getContext()));
            }
        }
        this.f2906a.H(z, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.f2907b = i;
        this.c = i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = getOrientation() == 0 ? 0 : mode;
        int i4 = i3 == 0 ? 0 : size;
        int i5 = getOrientation() == 1 ? 0 : mode2;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5 != 0 ? size2 : 0, i5));
        this.d = getMeasuredWidth();
        this.e = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(this.d, size);
        } else if (mode != 1073741824) {
            size = this.d;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.e, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.e;
        }
        if (getOrientation() == 0 && mode != 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.d, 1073741824), i2);
        } else if (getOrientation() == 1 && mode2 != 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
        }
        setMeasuredDimension(size, size2);
        this.f2906a.J1(this.d, this.e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2906a.l1(motionEvent);
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean p0() {
        return this.f2906a.p0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void p1(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f2906a.p1(i, i2, i3, runnable, runnable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean q1() {
        return this.f2906a.q1();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f2906a.z1(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f2906a.I(z);
    }

    @Override // android.view.View, com.duokan.core.ui.Scrollable
    public void scrollBy(int i, int i2) {
        this.f2906a.scrollBy(i, i2);
    }

    @Override // android.view.View, com.duokan.core.ui.Scrollable
    public void scrollTo(int i, int i2) {
        this.f2906a.scrollTo(i, i2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setDragUnaccomplishedListener(n.InterfaceC0209n interfaceC0209n) {
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setHorizontalOverScrollMode(Scrollable.OverScrollMode overScrollMode) {
        this.f2906a.setHorizontalOverScrollMode(overScrollMode);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setHorizontalSeekDrawable(Drawable drawable2) {
        this.f2906a.setHorizontalSeekDrawable(drawable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setHorizontalThumbDrawable(Drawable drawable2) {
        this.f2906a.setHorizontalThumbDrawable(drawable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void setMaxOverScrollHeight(int i) {
        this.f2906a.setMaxOverScrollHeight(i);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void setMaxOverScrollWidth(int i) {
        this.f2906a.setMaxOverScrollWidth(i);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setOnContentBoundsChangedListener(Scrollable.a aVar) {
        this.f2906a.setOnContentBoundsChangedListener(aVar);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setOnScrollListener(Scrollable.b bVar) {
        this.f2906a.setOnScrollListener(bVar);
    }

    @Override // com.duokan.core.ui.Scrollable
    public final void setScrollInterpolator(Interpolator interpolator) {
        this.f2906a.setScrollInterpolator(interpolator);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setSeekEnabled(boolean z) {
        this.f2906a.setSeekEnabled(z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setThumbEnabled(boolean z) {
        this.f2906a.setThumbEnabled(z);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setVerticalOverScrollMode(Scrollable.OverScrollMode overScrollMode) {
        this.f2906a.setVerticalOverScrollMode(overScrollMode);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setVerticalSeekDrawable(Drawable drawable2) {
        this.f2906a.setVerticalSeekDrawable(drawable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void setVerticalThumbDrawable(Drawable drawable2) {
        this.f2906a.setVerticalThumbDrawable(drawable2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return this.f2906a.O1();
    }

    @Override // com.duokan.core.ui.Scrollable
    public void t0() {
        this.f2906a.t0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public void v0(Rect rect, Rect rect2) {
        this.f2906a.v0(rect, rect2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public void w0(float f, float f2, Runnable runnable, Runnable runnable2) {
        this.f2906a.w0(f, f2, runnable, runnable2);
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean w1() {
        return this.f2906a.w1();
    }

    @Override // com.duokan.core.ui.Scrollable
    public final boolean y0() {
        return this.f2906a.y0();
    }

    @Override // com.duokan.core.ui.Scrollable
    public boolean z0() {
        return this.f2906a.z0();
    }

    public LinearScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2907b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        setWillNotDraw(false);
        setClipToPadding(false);
        setScrollContainer(true);
        this.f2906a = c();
        setThumbEnabled(true);
        Scrollable.OverScrollMode overScrollMode = Scrollable.OverScrollMode.AUTO;
        setHorizontalOverScrollMode(overScrollMode);
        setVerticalOverScrollMode(overScrollMode);
    }
}
