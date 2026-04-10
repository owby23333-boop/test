package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class PositionPopupView extends BasePopupView {
    FrameLayout N;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PositionPopupView positionPopupView = PositionPopupView.this;
            b bVar = positionPopupView.f17361s;
            if (bVar == null) {
                return;
            }
            if (bVar.C) {
                PositionPopupView.this.N.setTranslationX((!com.lxj.xpopup.util.b.d(positionPopupView.getContext()) ? com.lxj.xpopup.util.b.c(PositionPopupView.this.getContext()) - PositionPopupView.this.N.getMeasuredWidth() : -(com.lxj.xpopup.util.b.c(PositionPopupView.this.getContext()) - PositionPopupView.this.N.getMeasuredWidth())) / 2.0f);
            } else {
                positionPopupView.N.setTranslationX(bVar.f17431z);
            }
            PositionPopupView.this.N.setTranslationY(r0.f17361s.A);
            PositionPopupView.this.w();
        }
    }

    public PositionPopupView(@NonNull Context context) {
        super(context);
        this.N = (FrameLayout) findViewById(R$id.positionPopupContainer);
        this.N.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.N, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_position_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected c getPopupAnimator() {
        return new d(getPopupContentView(), getAnimationDuration(), PopupAnimation.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    protected void w() {
        p();
        l();
        j();
    }
}
