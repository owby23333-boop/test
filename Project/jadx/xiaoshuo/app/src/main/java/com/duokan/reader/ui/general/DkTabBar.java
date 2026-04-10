package com.duokan.reader.ui.general;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class DkTabBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f5392b;
    public int c;
    public int d;
    public b e;
    public Map<Integer, Boolean> f;
    public final Handler g;
    public final Runnable h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DkTabBar.this.e.a((DkTabBar.this.c < 0 || DkTabBar.this.c >= DkTabBar.this.f5392b.getChildCount()) ? null : DkTabBar.this.f5392b.getChildAt(DkTabBar.this.c), DkTabBar.this.c);
        }
    }

    public interface b {
        void a(View view, int i);
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5394a;

        public c(int i) {
            this.f5394a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DkTabBar.this.i(view, this.f5394a);
        }
    }

    public DkTabBar(Context context) {
        super(context);
        this.g = new Handler(Looper.getMainLooper());
        this.h = new a();
        g();
    }

    public void e(View view, int i, boolean z) {
        this.c = 0;
        this.f5392b.addView(view, i, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f.put(Integer.valueOf(i), Boolean.valueOf(z));
        view.setOnClickListener(new c(i));
    }

    public final void f(View view, float f, float f2, float f3, float f4, long j, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public final void g() {
        this.f = new HashMap();
        this.f5391a = new LinearLayout(getContext());
        this.f5392b = new LinearLayout(getContext());
        this.f5391a.setClickable(false);
        addView(this.f5391a, new FrameLayout.LayoutParams(-2, -1));
        addView(this.f5392b, new FrameLayout.LayoutParams(-1, -1));
        bringChildToFront(this.f5391a);
    }

    public boolean h(int i) {
        if (i < 0 || i >= this.f.size()) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).booleanValue();
    }

    public final void i(View view, int i) {
        View childAt;
        if (this.c == i || !this.f.get(Integer.valueOf(i)).booleanValue()) {
            this.e.a(view, i);
            return;
        }
        int i2 = this.c;
        int i3 = 0;
        if (i2 < 0 || i2 >= this.f5392b.getChildCount()) {
            childAt = null;
        } else {
            childAt = this.f5392b.getChildAt(this.c);
            childAt.setSelected(false);
        }
        int left = childAt != null ? childAt.getLeft() : this.d * this.c;
        int left2 = view.getLeft();
        if (this.f5391a.getVisibility() != 0) {
            this.f5391a.setVisibility(0);
            left = left2;
        } else {
            i3 = 100;
        }
        view.setSelected(true);
        this.c = i;
        this.e.a(view, i);
        f(this.f5391a, left, left2, 0.0f, 0.0f, i3, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.d = Math.round(((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / this.f5392b.getChildCount());
        this.f5391a.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.d, ((getPaddingTop() + getMeasuredHeight()) - getPaddingBottom()) - getPaddingTop());
    }

    public void setOnChildViewClickListener(b bVar) {
        this.e = bVar;
    }

    public void setSelectViewIndex(int i) {
        this.c = i;
        if (i < 0) {
            this.f5391a.setVisibility(8);
            this.f5391a.clearAnimation();
            for (int i2 = 0; i2 < this.f5392b.getChildCount(); i2++) {
                this.f5392b.getChildAt(i2).setSelected(false);
            }
        }
    }

    public void setSliderViewResource(int i) {
        this.f5391a.setBackgroundResource(i);
    }

    public DkTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Handler(Looper.getMainLooper());
        this.h = new a();
        g();
    }
}
