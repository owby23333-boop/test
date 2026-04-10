package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.c.h;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.util.KeyboardUtils;
import com.lxj.xpopup.widget.SmartDragLayout;

/* JADX INFO: loaded from: classes3.dex */
public class BottomPopupView extends BasePopupView {
    protected SmartDragLayout N;

    class a implements SmartDragLayout.OnCloseListener {
        a() {
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onClose() {
            h hVar;
            BottomPopupView.this.d();
            BottomPopupView bottomPopupView = BottomPopupView.this;
            com.lxj.xpopup.core.b bVar = bottomPopupView.f17361s;
            if (bVar != null && (hVar = bVar.f17423r) != null) {
                hVar.f(bottomPopupView);
            }
            BottomPopupView.this.i();
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onDrag(int i2, float f2, boolean z2) {
            BottomPopupView bottomPopupView = BottomPopupView.this;
            com.lxj.xpopup.core.b bVar = bottomPopupView.f17361s;
            if (bVar == null) {
                return;
            }
            h hVar = bVar.f17423r;
            if (hVar != null) {
                hVar.a(bottomPopupView, i2, f2, z2);
            }
            if (!BottomPopupView.this.f17361s.f17410e.booleanValue() || BottomPopupView.this.f17361s.f17411f.booleanValue()) {
                return;
            }
            BottomPopupView bottomPopupView2 = BottomPopupView.this;
            bottomPopupView2.setBackgroundColor(bottomPopupView2.f17363u.b(f2));
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
        public void onOpen() {
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomPopupView.this.g();
        }
    }

    public BottomPopupView(@NonNull Context context) {
        super(context);
        this.N = (SmartDragLayout) findViewById(R$id.bottomPopupContainer);
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
        this.N.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_bottom_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f17361s.f17417l;
        return i2 == 0 ? com.lxj.xpopup.util.b.c(getContext()) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected c getPopupAnimator() {
        return null;
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
        com.lxj.xpopup.b.a aVar;
        if (this.f17361s.f17411f.booleanValue() && (aVar = this.f17364v) != null) {
            aVar.a();
        }
        this.N.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        com.lxj.xpopup.b.a aVar;
        if (this.f17361s.f17411f.booleanValue() && (aVar = this.f17364v) != null) {
            aVar.b();
        }
        this.N.open();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        if (this.N.getChildCount() == 0) {
            w();
        }
        this.N.setDuration(getAnimationDuration());
        this.N.enableDrag(this.f17361s.B.booleanValue());
        this.N.dismissOnTouchOutside(this.f17361s.f17408c.booleanValue());
        this.N.isThreeDrag(this.f17361s.I);
        getPopupImplView().setTranslationX(this.f17361s.f17431z);
        getPopupImplView().setTranslationY(this.f17361s.A);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
        this.N.setOnCloseListener(new a());
        this.N.setOnClickListener(new b());
    }

    protected void w() {
        this.N.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.N, false));
    }
}
