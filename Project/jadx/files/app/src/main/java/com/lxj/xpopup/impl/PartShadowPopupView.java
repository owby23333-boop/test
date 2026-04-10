package com.lxj.xpopup.impl;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.h;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.widget.PartShadowContainer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PartShadowPopupView extends BasePopupView {
    protected PartShadowContainer N;
    public boolean O;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PartShadowPopupView.this.x();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PartShadowPopupView.this.y();
            PartShadowPopupView.this.getPopupImplView().setVisibility(0);
        }
    }

    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PartShadowPopupView.this.f17361s.f17408c.booleanValue()) {
                return false;
            }
            PartShadowPopupView.this.g();
            return false;
        }
    }

    class d implements com.lxj.xpopup.c.b {
        d() {
        }

        @Override // com.lxj.xpopup.c.b
        public void a() {
            if (PartShadowPopupView.this.f17361s.f17408c.booleanValue()) {
                PartShadowPopupView.this.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        p();
        l();
        j();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_partshadow_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.b.c getPopupAnimator() {
        return new h(getPopupImplView(), getAnimationDuration(), this.O ? PopupAnimation.TranslateFromBottom : PopupAnimation.TranslateFromTop);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        if (this.N.getChildCount() == 0) {
            w();
        }
        if (this.f17361s.f17410e.booleanValue()) {
            this.f17363u.b = getPopupContentView();
        }
        getPopupContentView().setTranslationY(this.f17361s.A);
        getPopupImplView().setTranslationX(this.f17361s.f17431z);
        getPopupImplView().setTranslationY(0.0f);
        getPopupImplView().setVisibility(4);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    protected void w() {
        this.N.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.N, false));
    }

    public void x() {
        if (this.f17361s.a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        marginLayoutParams.width = getMeasuredWidth();
        int[] iArr = new int[2];
        this.f17361s.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f17361s.a().getMeasuredWidth(), iArr[1] + this.f17361s.a().getMeasuredHeight());
        if (!this.f17361s.C || getPopupImplView() == null) {
            int measuredWidth = rect.left + this.f17361s.f17431z;
            if (getPopupImplView().getMeasuredWidth() + measuredWidth > com.lxj.xpopup.util.b.c(getContext())) {
                measuredWidth -= (getPopupImplView().getMeasuredWidth() + measuredWidth) - com.lxj.xpopup.util.b.c(getContext());
            }
            getPopupImplView().setTranslationX(measuredWidth);
        } else {
            getPopupImplView().setTranslationX(((rect.left + rect.right) / 2) - (getPopupImplView().getMeasuredWidth() / 2));
        }
        int iHeight = rect.top + (rect.height() / 2);
        View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if ((iHeight > getMeasuredHeight() / 2 || this.f17361s.f17425t == PopupPosition.Top) && this.f17361s.f17425t != PopupPosition.Bottom) {
            marginLayoutParams.height = rect.top;
            this.O = true;
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
        } else {
            int measuredHeight = getMeasuredHeight();
            int i2 = rect.bottom;
            marginLayoutParams.height = measuredHeight - i2;
            this.O = false;
            marginLayoutParams.topMargin = i2;
            layoutParams.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        childAt.setLayoutParams(layoutParams);
        getPopupContentView().post(new b());
        this.N.setOnLongClickListener(new c());
        this.N.setOnClickOutsideListener(new d());
    }
}
