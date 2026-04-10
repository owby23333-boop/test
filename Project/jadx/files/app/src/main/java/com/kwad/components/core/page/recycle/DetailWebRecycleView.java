package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.r.p;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public class DetailWebRecycleView extends b {
    private boolean MA;
    private boolean MB;
    private int MC;
    private int MD;
    private boolean ME;
    a MF;
    private Runnable MG;
    private p MH;
    private int Mz;
    private int my;

    public interface a {
        boolean pb();
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Mz = 1000;
        this.MA = false;
        this.MB = false;
        this.MG = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object objD = r.d(DetailWebRecycleView.this, "mGapWorker");
                    if (objD != null) {
                        r.a(objD, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Mz));
                    }
                } catch (RuntimeException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
        };
        this.MH = new p(this.MG);
        this.my = context instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) context) : com.kwad.sdk.b.kwai.a.getScreenHeight(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.MH, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.MH);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.MF;
        if (aVar != null && aVar.pb()) {
            return true;
        }
        this.MD = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.MC - this.MD) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        this.MD = computeVerticalScrollOffset();
        if (this.MD >= this.MC) {
            return false;
        }
        fling((int) f2, (int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        this.MD = computeVerticalScrollOffset();
        if ((i3 > 0 && this.MD < this.MC) && !this.ME && this.MD < this.my) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
        if (i3 < 0 && this.MD > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        super.onScrollStateChanged(i2);
        if (i2 == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.ME = true;
                    return;
                }
            }
            this.ME = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 2) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.MB) {
            this.MB = false;
        } else {
            if (this.MA) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z2) {
        this.MA = z2;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z2) {
        this.MB = z2;
    }

    public void setInterceptTouchListener(a aVar) {
        this.MF = aVar;
    }

    public void setTopViewHeight(int i2) {
        this.MC = i2;
    }
}
