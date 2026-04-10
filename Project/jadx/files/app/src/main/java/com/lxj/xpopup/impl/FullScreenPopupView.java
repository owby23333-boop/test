package com.lxj.xpopup.impl;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.b.h;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.b;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class FullScreenPopupView extends BasePopupView {
    public ArgbEvaluator N;
    protected View O;
    protected FrameLayout P;
    Paint Q;
    Rect R;
    int S;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FullScreenPopupView.this.S = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            FullScreenPopupView.this.postInvalidate();
        }
    }

    public void a(boolean z2) {
        b bVar = this.f17361s;
        if (bVar == null || !bVar.f17426u.booleanValue()) {
            return;
        }
        ArgbEvaluator argbEvaluator = this.N;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(z2 ? 0 : getStatusBarBgColor());
        objArr[1] = Integer.valueOf(z2 ? getStatusBarBgColor() : 0);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, objArr);
        valueAnimatorOfObject.addUpdateListener(new a());
        valueAnimatorOfObject.setDuration(getAnimationDuration()).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b bVar = this.f17361s;
        if (bVar == null || !bVar.f17426u.booleanValue()) {
            return;
        }
        this.Q.setColor(this.S);
        this.R = new Rect(0, 0, getMeasuredWidth(), com.lxj.xpopup.util.b.c());
        canvas.drawRect(this.R, this.Q);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_fullscreen_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected c getPopupAnimator() {
        return new h(getPopupContentView(), getAnimationDuration(), PopupAnimation.TranslateFromBottom);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        a(false);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void l() {
        super.l();
        a(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f17361s != null) {
            getPopupContentView().setTranslationX(this.f17361s.f17431z);
        }
        if (this.f17361s != null) {
            getPopupContentView().setTranslationY(this.f17361s.A);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        if (this.P.getChildCount() == 0) {
            w();
        }
        getPopupContentView().setTranslationX(this.f17361s.f17431z);
        getPopupContentView().setTranslationY(this.f17361s.A);
    }

    protected void w() {
        this.O = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.P, false);
        this.P.addView(this.O);
    }
}
