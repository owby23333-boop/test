package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes3.dex */
public class d extends ViewPager {
    private int aCe;
    private boolean aCf;

    public d(@NonNull Context context) {
        super(context);
        this.aCf = false;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCf = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.aCf) {
            return super.canScrollHorizontally(i2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z2;
        if (!this.aCf) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x2 = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                int i2 = x2 - this.aCe;
                if (getCurrentItem() == 0 && i2 > 0) {
                    parent = getParent();
                    z2 = false;
                }
            }
            this.aCe = x2;
            return super.dispatchTouchEvent(motionEvent);
        }
        parent = getParent();
        z2 = true;
        parent.requestDisallowInterceptTouchEvent(z2);
        this.aCe = x2;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aCf && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aCf && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z2) {
        this.aCf = z2;
    }
}
