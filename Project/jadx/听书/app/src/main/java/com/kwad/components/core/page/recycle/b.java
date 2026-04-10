package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class b extends g {
    private boolean UA;
    private int UB;
    private a UC;
    private boolean UD;
    private boolean UE;
    private Rect Ux;
    private int Uy;
    private int Uz;

    public interface a {
        boolean rD();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UB = Integer.MIN_VALUE;
        this.UE = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Uy != 0) {
            rB();
            Rect rect = this.Ux;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Ux);
                canvas.drawColor(this.Uy);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.UC = aVar;
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.UA = z;
    }

    public void setDisableScroll(boolean z) {
        this.UD = z;
    }

    public void setUnderneathColor(int i) {
        this.Uy = i;
        rB();
        invalidate();
    }

    private void rB() {
        Rect rect = this.Ux;
        if (rect == null) {
            this.Ux = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.Ux.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.UA) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.UB == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.UB = iArr[1];
            }
            int iFindFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1 || iFindLastVisibleItemPosition == -1) {
                return;
            }
            if (i >= iFindFirstVisibleItemPosition && i <= iFindLastVisibleItemPosition) {
                int i4 = i - iFindFirstVisibleItemPosition;
                if (getChildCount() > i4) {
                    int[] iArr2 = new int[2];
                    getChildAt(i4).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.UB) - i3);
                    return;
                }
                return;
            }
            if (i > iFindLastVisibleItemPosition) {
                scrollBy(0, i2);
                a(i, i2, i3);
                return;
            }
            scrollBy(0, -i2);
        }
    }

    public void setDownStop(boolean z) {
        this.UE = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.UD) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.UE) {
            stopScroll();
        }
        a aVar = this.UC;
        if (aVar == null || !aVar.rD()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.UD) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.Uz;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.Uz, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rC();
    }

    private void rC() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).rG();
        }
    }
}
