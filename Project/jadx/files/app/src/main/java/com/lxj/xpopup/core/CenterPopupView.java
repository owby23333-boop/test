package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class CenterPopupView extends BasePopupView {
    protected FrameLayout N;
    protected int O;
    protected int P;
    protected View Q;

    public CenterPopupView(@NonNull Context context) {
        super(context);
        this.N = (FrameLayout) findViewById(R$id.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        this.N.setBackground(com.lxj.xpopup.util.b.a(getResources().getColor(R$color._xpopup_dark_color), this.f17361s.f17421p));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        this.N.setBackground(com.lxj.xpopup.util.b.a(getResources().getColor(R$color._xpopup_light_color), this.f17361s.f17421p));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_center_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f17361s.f17417l;
        return i2 == 0 ? (int) (com.lxj.xpopup.util.b.c(getContext()) * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected c getPopupAnimator() {
        return new d(getPopupContentView(), getAnimationDuration(), PopupAnimation.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        if (this.N.getChildCount() == 0) {
            w();
        }
        getPopupContentView().setTranslationX(this.f17361s.f17431z);
        getPopupContentView().setTranslationY(this.f17361s.A);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
    }

    protected void w() {
        this.Q = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.N, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams.gravity = 17;
        this.N.addView(this.Q, layoutParams);
    }

    protected void x() {
        if (this.O == 0) {
            if (this.f17361s.G) {
                b();
            } else {
                c();
            }
        }
    }
}
