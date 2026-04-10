package com.amgcyo.cuttadon.view.comment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class NoScrollViewPager extends ViewPager {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f4622s;

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4622s = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f4622s) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4622s) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2, boolean z2) {
        super.setCurrentItem(i2, z2);
    }

    public void setNoScroll(boolean z2) {
        this.f4622s = z2;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2);
    }

    public NoScrollViewPager(Context context) {
        super(context);
        this.f4622s = false;
    }
}
