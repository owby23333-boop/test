package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.duokan.reader.ui.DkViewFlipper;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class DkStackView extends DkViewFlipper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animation f5385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Animation f5386b;
    public final Animation c;
    public final Animation d;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f5387a;

        public a(Animation.AnimationListener animationListener) {
            this.f5387a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5387a.onAnimationEnd(animation);
            DkStackView.this.f5385a.setAnimationListener(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f5387a.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f5387a.onAnimationStart(animation);
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f5389a;

        public b(Animation.AnimationListener animationListener) {
            this.f5389a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5389a.onAnimationEnd(animation);
            DkStackView.this.c.setAnimationListener(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f5389a.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f5389a.onAnimationStart(animation);
        }
    }

    public DkStackView(Context context) {
        this(context, null);
    }

    public View c() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return null;
        }
        View childAt = getChildAt(childCount - 1);
        removeView(childAt);
        return childAt;
    }

    public void d(View view, boolean z) {
        e(view, z, null);
    }

    public void e(View view, boolean z, Animation.AnimationListener animationListener) {
        if (z && animationListener != null) {
            this.f5385a.setAnimationListener(new a(animationListener));
        }
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (z) {
            showNext();
            return;
        }
        f();
        if (animationListener != null) {
            animationListener.onAnimationEnd(null);
        }
    }

    public void f() {
        setInAnimation(null);
        setOutAnimation(null);
        super.showNext();
    }

    public void g(boolean z, Animation.AnimationListener animationListener) {
        if (!z) {
            h();
        } else {
            this.c.setAnimationListener(new b(animationListener));
            showPrevious();
        }
    }

    public void h() {
        setInAnimation(null);
        setOutAnimation(null);
        super.showPrevious();
    }

    @Override // android.widget.ViewAnimator
    public void showNext() {
        setInAnimation(this.f5385a);
        setOutAnimation(this.f5386b);
        super.showNext();
    }

    @Override // android.widget.ViewAnimator
    public void showPrevious() {
        setInAnimation(this.c);
        setOutAnimation(this.d);
        super.showPrevious();
    }

    public DkStackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5385a = AnimationUtils.loadAnimation(context, st2.a.n1);
        this.f5386b = AnimationUtils.loadAnimation(context, st2.a.o1);
        this.c = AnimationUtils.loadAnimation(context, st2.a.p1);
        this.d = AnimationUtils.loadAnimation(context, st2.a.q1);
    }
}
