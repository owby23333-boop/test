package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class b extends g {
    private Rect Mr;
    private int Ms;
    private int Mt;
    private boolean Mu;
    private int Mv;
    private a Mw;
    private boolean Mx;
    private boolean My;

    public interface a {
        boolean pa();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Mv = Integer.MIN_VALUE;
        this.My = false;
    }

    private void a(int i2, int i3, int i4) {
        while (true) {
            if (this.Mv == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Mv = iArr[1];
            }
            int iFindFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1 || iFindLastVisibleItemPosition == -1) {
                return;
            }
            if (i2 >= iFindFirstVisibleItemPosition && i2 <= iFindLastVisibleItemPosition) {
                int i5 = i2 - iFindFirstVisibleItemPosition;
                if (getChildCount() > i5) {
                    int[] iArr2 = new int[2];
                    getChildAt(i5).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Mv) - i4);
                    return;
                }
                return;
            }
            if (i2 > iFindLastVisibleItemPosition) {
                scrollBy(0, i3);
                a(i2, i3, i4);
                return;
            }
            scrollBy(0, -i3);
        }
    }

    private void oY() {
        Rect rect = this.Mr;
        if (rect == null) {
            this.Mr = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                this.Mr.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void oZ() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).pd();
        }
    }

    private void scrollToPositionWithOffset(int i2, int i3) {
        a(i2, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oZ();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Ms != 0) {
            oY();
            Rect rect = this.Mr;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Mr);
                canvas.drawColor(this.Ms);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Mx) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.My) {
            stopScroll();
        }
        a aVar = this.Mw;
        if (aVar == null || !aVar.pa()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.Mt;
        if (i4 > 0 && i4 < size) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.Mt, View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Mx) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        if (this.Mu) {
            scrollToPositionWithOffset(i2, 0);
        } else {
            super.scrollToPosition(i2);
        }
    }

    public void setDisableScroll(boolean z2) {
        this.Mx = z2;
    }

    public void setDownStop(boolean z2) {
        this.My = z2;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Mw = aVar;
    }

    public void setUnderneathColor(int i2) {
        this.Ms = i2;
        oY();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z2) {
        this.Mu = z2;
    }
}
