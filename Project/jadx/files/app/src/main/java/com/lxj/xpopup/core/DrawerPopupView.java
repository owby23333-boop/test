package com.lxj.xpopup.core;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.c.h;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.util.KeyboardUtils;
import com.lxj.xpopup.widget.PopupDrawerLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DrawerPopupView extends BasePopupView {
    protected PopupDrawerLayout N;
    protected FrameLayout O;
    float P;
    Paint Q;
    Rect R;
    public ArgbEvaluator S;
    int T;
    int U;

    class a implements PopupDrawerLayout.OnCloseListener {
        a() {
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onClose() {
            h hVar;
            DrawerPopupView.this.d();
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            com.lxj.xpopup.core.b bVar = drawerPopupView.f17361s;
            if (bVar != null && (hVar = bVar.f17423r) != null) {
                hVar.f(drawerPopupView);
            }
            DrawerPopupView.this.i();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onDrag(int i2, float f2, boolean z2) {
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            com.lxj.xpopup.core.b bVar = drawerPopupView.f17361s;
            if (bVar == null) {
                return;
            }
            drawerPopupView.N.isDrawStatusBarShadow = bVar.f17426u.booleanValue();
            DrawerPopupView drawerPopupView2 = DrawerPopupView.this;
            h hVar = drawerPopupView2.f17361s.f17423r;
            if (hVar != null) {
                hVar.a(drawerPopupView2, i2, f2, z2);
            }
            DrawerPopupView drawerPopupView3 = DrawerPopupView.this;
            drawerPopupView3.P = f2;
            drawerPopupView3.f17363u.a(f2);
            DrawerPopupView.this.postInvalidate();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
        public void onOpen() {
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DrawerPopupView.this.T = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            DrawerPopupView.this.postInvalidate();
        }
    }

    public DrawerPopupView(@NonNull Context context) {
        super(context);
        this.P = 0.0f;
        this.Q = new Paint();
        this.S = new ArgbEvaluator();
        this.U = 0;
        this.N = (PopupDrawerLayout) findViewById(R$id.drawerLayout);
        this.O = (FrameLayout) findViewById(R$id.drawerContentContainer);
        this.O.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.O, false));
    }

    public void a(boolean z2) {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || !bVar.f17426u.booleanValue()) {
            return;
        }
        ArgbEvaluator argbEvaluator = this.S;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(z2 ? 0 : getStatusBarBgColor());
        objArr[1] = Integer.valueOf(z2 ? getStatusBarBgColor() : 0);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, objArr);
        valueAnimatorOfObject.addUpdateListener(new b());
        valueAnimatorOfObject.setDuration(getAnimationDuration()).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null || !bVar.f17426u.booleanValue()) {
            return;
        }
        if (this.R == null) {
            this.R = new Rect(0, 0, getMeasuredWidth(), com.lxj.xpopup.util.b.c());
        }
        this.Q.setColor(((Integer) this.S.evaluate(this.P, Integer.valueOf(this.U), Integer.valueOf(getStatusBarBgColor()))).intValue());
        canvas.drawRect(this.R, this.Q);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null) {
            return;
        }
        PopupStatus popupStatus = this.f17366x;
        PopupStatus popupStatus2 = PopupStatus.Dismissing;
        if (popupStatus == popupStatus2) {
            return;
        }
        this.f17366x = popupStatus2;
        if (bVar.f17422q.booleanValue()) {
            KeyboardUtils.a(this);
        }
        clearFocus();
        a(false);
        this.N.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected c getPopupAnimator() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public View getPopupImplView() {
        return this.O.getChildAt(0);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void i() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar != null && bVar.f17422q.booleanValue()) {
            KeyboardUtils.a(this);
        }
        this.C.removeCallbacks(this.J);
        this.C.postDelayed(this.J, 0L);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        this.N.open();
        a(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        this.N.isDismissOnTouchOutside = this.f17361s.f17408c.booleanValue();
        this.N.setOnCloseListener(new a());
        getPopupImplView().setTranslationX(this.f17361s.f17431z);
        getPopupImplView().setTranslationY(this.f17361s.A);
        PopupDrawerLayout popupDrawerLayout = this.N;
        PopupPosition popupPosition = this.f17361s.f17425t;
        if (popupPosition == null) {
            popupPosition = PopupPosition.Left;
        }
        popupDrawerLayout.setDrawerPosition(popupPosition);
        this.N.enableDrag = this.f17361s.B.booleanValue();
    }
}
