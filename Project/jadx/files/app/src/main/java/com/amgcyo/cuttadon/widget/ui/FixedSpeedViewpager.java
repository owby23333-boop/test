package com.amgcyo.cuttadon.widget.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class FixedSpeedViewpager extends ViewPager {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f5674s;

    public FixedSpeedViewpager(@NonNull Context context) {
        super(context);
        this.f5674s = false;
        a();
    }

    private void a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            a aVar = new a(getContext(), new LinearOutSlowInInterpolator());
            declaredField.set(this, aVar);
            aVar.a(200);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5674s) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5674s) {
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
        this.f5674s = z2;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2);
    }

    public FixedSpeedViewpager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5674s = false;
        a();
    }
}
