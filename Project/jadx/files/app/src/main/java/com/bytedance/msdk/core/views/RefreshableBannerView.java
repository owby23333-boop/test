package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.bytedance.msdk.adapter.util.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshableBannerView extends FrameLayout {
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f14442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f14443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f14444f;

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
            refreshableBannerView.b = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.f14442d);
            RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
            refreshableBannerView2.a(refreshableBannerView2.b);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (RefreshableBannerView.this.getChildCount() > 1) {
                RefreshableBannerView.this.removeViewAt(0);
                Logger.d("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
            }
        }
    }

    public interface c {
        void a(boolean z2);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.a = true;
        this.b = true;
        this.f14441c = true;
        this.f14442d = new Rect();
        this.f14443e = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        boolean z3 = this.a && this.b;
        if (z2) {
            if (!z3 || this.f14441c) {
                return;
            }
            this.f14441c = true;
            c cVar = this.f14444f;
            if (cVar != null) {
                cVar.a(true);
                return;
            }
            return;
        }
        if (z3 || !this.f14441c) {
            return;
        }
        this.f14441c = false;
        c cVar2 = this.f14444f;
        if (cVar2 != null) {
            cVar2.a(false);
        }
    }

    @UiThread
    public void a(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new b());
            duration.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f14443e);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.f14443e);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.a = i2 == 0;
        a(this.a);
    }

    public void setVisibilityChangeListener(c cVar) {
        this.f14444f = cVar;
    }
}
