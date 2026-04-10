package com.duokan.core.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Interpolator;
import com.duokan.core.ui.n;

/* JADX INFO: loaded from: classes12.dex */
public interface Scrollable {

    public enum OverScrollMode {
        STRETCH,
        ALWAYS,
        AUTO,
        NEVER
    }

    public enum ScrollState {
        IDLE,
        SEEK,
        DRAG,
        FLING,
        SMOOTH
    }

    public interface a {
        void a(Scrollable scrollable, Rect rect, Rect rect2);
    }

    public interface b {
        void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2);

        void b(Scrollable scrollable, boolean z);
    }

    public interface c extends b {
    }

    boolean A0(int i);

    Rect A1(Rect rect);

    boolean B0();

    void C0(boolean z);

    boolean D();

    Rect D0();

    void E0(boolean z);

    void G0(int i, int i2, int i3, int i4);

    void H0(int i, int i2, int i3, int i4);

    void I1();

    void J0(int i, int i2, int i3, Runnable runnable, Runnable runnable2);

    Point K0(Point point);

    Rect M1(Rect rect);

    void R0(boolean z);

    boolean R1();

    void S(int i, int i2, int i3, Runnable runnable, Runnable runnable2);

    Point Z0(Point point);

    void a1(View view, boolean z);

    boolean b1();

    boolean e1();

    int getContentHeight();

    int getContentWidth();

    OverScrollMode getHorizontalOverScrollMode();

    Drawable getHorizontalSeekDrawable();

    Drawable getHorizontalThumbDrawable();

    int getHorizontalThumbMarginBottom();

    int getHorizontalThumbMarginLeft();

    int getHorizontalThumbMarginRight();

    int getHorizontalThumbMarginTop();

    int getIdleTime();

    int getMaxOverScrollHeight();

    int getMaxOverScrollWidth();

    m getScrollDetector();

    int getScrollFinalX();

    int getScrollFinalY();

    ScrollState getScrollState();

    int getScrollTime();

    boolean getSeekEnabled();

    boolean getThumbEnabled();

    OverScrollMode getVerticalOverScrollMode();

    Drawable getVerticalSeekDrawable();

    Drawable getVerticalThumbDrawable();

    int getVerticalThumbMarginBottom();

    int getVerticalThumbMarginLeft();

    int getVerticalThumbMarginRight();

    int getVerticalThumbMarginTop();

    Rect getViewportBounds();

    void h1();

    boolean l0();

    void o0(int i, int i2);

    void o1(Rect rect, Rect rect2, int i, Runnable runnable, Runnable runnable2);

    boolean p0();

    void p1(int i, int i2, int i3, Runnable runnable, Runnable runnable2);

    boolean q1();

    void scrollBy(int i, int i2);

    void scrollTo(int i, int i2);

    default void setDragUnaccomplishedListener(n.InterfaceC0209n interfaceC0209n) {
    }

    void setHorizontalOverScrollMode(OverScrollMode overScrollMode);

    void setHorizontalSeekDrawable(Drawable drawable2);

    void setHorizontalThumbDrawable(Drawable drawable2);

    void setMaxOverScrollHeight(int i);

    void setMaxOverScrollWidth(int i);

    void setOnContentBoundsChangedListener(a aVar);

    void setOnScrollListener(b bVar);

    void setScrollInterpolator(Interpolator interpolator);

    void setSeekEnabled(boolean z);

    void setThumbEnabled(boolean z);

    void setVerticalOverScrollMode(OverScrollMode overScrollMode);

    void setVerticalSeekDrawable(Drawable drawable2);

    void setVerticalThumbDrawable(Drawable drawable2);

    void t0();

    void v0(Rect rect, Rect rect2);

    void w0(float f, float f2, Runnable runnable, Runnable runnable2);

    boolean w1();

    boolean y0();

    boolean z0();
}
