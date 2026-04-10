package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.t.p;
import com.kwad.sdk.utils.z;

/* JADX INFO: loaded from: classes4.dex */
public class DetailWebRecycleView extends b {
    private int UF;
    private boolean UG;
    private boolean UH;
    private int UI;
    private int UJ;
    private boolean UK;
    a UL;
    private Runnable UM;
    private p UN;
    private int oC;

    public interface a {
        boolean rE();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UF = 1000;
        this.UG = false;
        this.UH = false;
        this.UM = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = z.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        z.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.UF));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        };
        this.UN = new p(this.UM);
        if (context instanceof Activity) {
            this.oC = com.kwad.sdk.c.a.a.g((Activity) context);
        } else {
            this.oC = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }

    public void setTopViewHeight(int i) {
        this.UI = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.UN, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.UN);
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.UG = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.UH = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.UH) {
            this.UH = false;
        } else {
            if (this.UG) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.UL;
        if (aVar != null && aVar.rE()) {
            return true;
        }
        this.UJ = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.UI - this.UJ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.UJ = iComputeVerticalScrollOffset;
        if ((i2 > 0 && iComputeVerticalScrollOffset < this.UI) && !this.UK && iComputeVerticalScrollOffset < this.oC) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.UJ > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.UJ = iComputeVerticalScrollOffset;
        if (iComputeVerticalScrollOffset >= this.UI) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.UK = true;
                    return;
                }
            }
            this.UK = false;
        }
    }

    public void setInterceptTouchListener(a aVar) {
        this.UL = aVar;
    }
}
