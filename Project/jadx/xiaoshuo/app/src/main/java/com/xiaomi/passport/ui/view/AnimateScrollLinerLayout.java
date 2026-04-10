package com.xiaomi.passport.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public class AnimateScrollLinerLayout extends LinearLayout {
    private Scroller mScroller;

    public AnimateScrollLinerLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public void smoothScrollBy(int i, int i2) {
        Scroller scroller = this.mScroller;
        scroller.startScroll(scroller.getFinalX(), this.mScroller.getFinalY(), i, i2);
        invalidate();
    }

    public void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - this.mScroller.getFinalX(), i2 - this.mScroller.getFinalY());
    }

    public AnimateScrollLinerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AnimateScrollLinerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
