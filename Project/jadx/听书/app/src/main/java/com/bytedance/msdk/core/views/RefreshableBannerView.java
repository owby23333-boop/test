package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.msdk.z.gc.dl;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshableBannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f419a;
    private boolean dl;
    private boolean g;
    private final ViewTreeObserver.OnScrollChangedListener gc;
    private z m;
    private boolean z;

    public interface z {
        void z(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.z = true;
        this.g = true;
        this.dl = true;
        this.f419a = new Rect();
        this.gc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.g = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.f419a);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.z(refreshableBannerView2.g);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.gc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.gc);
    }

    public void z(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        dl.z("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z2 = i == 0;
        this.z = z2;
        z(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z2) {
        boolean z3 = this.z && this.g;
        if (z2) {
            if (!z3 || this.dl) {
                return;
            }
            this.dl = true;
            z zVar = this.m;
            if (zVar != null) {
                zVar.z(true);
                return;
            }
            return;
        }
        if (z3 || !this.dl) {
            return;
        }
        this.dl = false;
        z zVar2 = this.m;
        if (zVar2 != null) {
            zVar2.z(false);
        }
    }

    public void setVisibilityChangeListener(z zVar) {
        this.m = zVar;
    }
}
