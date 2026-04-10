package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class f extends ViewPager {
    private int bdE;
    private boolean bdF;

    public f(Context context) {
        super(context);
        this.bdF = false;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdF = false;
    }

    public void setScrollable(boolean z) {
        this.bdF = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.bdF && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bdF && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.bdF) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.bdF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i = x - this.bdE;
            if (getCurrentItem() == 0 && i > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.bdE = x;
        return super.dispatchTouchEvent(motionEvent);
    }
}
