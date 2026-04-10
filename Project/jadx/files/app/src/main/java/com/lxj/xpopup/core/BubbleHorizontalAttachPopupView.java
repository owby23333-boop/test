package com.lxj.xpopup.core;

import android.graphics.PointF;
import android.graphics.Rect;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.widget.BubbleLayout;

/* JADX INFO: loaded from: classes3.dex */
public class BubbleHorizontalAttachPopupView extends BubbleAttachPopupView {
    private boolean A() {
        return (this.R || this.f17361s.f17425t == PopupPosition.Left) && this.f17361s.f17425t != PopupPosition.Right;
    }

    @Override // com.lxj.xpopup.core.BubbleAttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected void q() {
        this.P.setLook(BubbleLayout.Look.LEFT);
        super.q();
        b bVar = this.f17361s;
        this.N = bVar.A;
        int iA = bVar.f17431z;
        if (iA == 0) {
            iA = com.lxj.xpopup.util.b.a(getContext(), 2.0f);
        }
        this.O = iA;
    }

    @Override // com.lxj.xpopup.core.BubbleAttachPopupView
    public void x() {
        int i2;
        float f2;
        float fHeight;
        int i3;
        boolean zD = com.lxj.xpopup.util.b.d(getContext());
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        b bVar = this.f17361s;
        if (bVar.f17416k != null) {
            PointF pointF = com.lxj.xpopup.a.f17319f;
            if (pointF != null) {
                bVar.f17416k = pointF;
            }
            this.R = this.f17361s.f17416k.x > ((float) (com.lxj.xpopup.util.b.c(getContext()) / 2));
            if (zD) {
                f2 = -(this.R ? (com.lxj.xpopup.util.b.c(getContext()) - this.f17361s.f17416k.x) + this.O : ((com.lxj.xpopup.util.b.c(getContext()) - this.f17361s.f17416k.x) - getPopupContentView().getMeasuredWidth()) - this.O);
            } else {
                f2 = A() ? (this.f17361s.f17416k.x - measuredWidth) - this.O : this.f17361s.f17416k.x + this.O;
            }
            fHeight = this.f17361s.f17416k.y - (measuredHeight * 0.5f);
            i3 = this.N;
        } else {
            int[] iArr = new int[2];
            bVar.a().getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f17361s.a().getMeasuredWidth(), iArr[1] + this.f17361s.a().getMeasuredHeight());
            this.R = (rect.left + rect.right) / 2 > com.lxj.xpopup.util.b.c(getContext()) / 2;
            if (zD) {
                i2 = -(this.R ? (com.lxj.xpopup.util.b.c(getContext()) - rect.left) + this.O : ((com.lxj.xpopup.util.b.c(getContext()) - rect.right) - getPopupContentView().getMeasuredWidth()) - this.O);
            } else {
                i2 = A() ? (rect.left - measuredWidth) - this.O : rect.right + this.O;
            }
            f2 = i2;
            fHeight = rect.top + ((rect.height() - measuredHeight) / 2.0f);
            i3 = this.N;
        }
        float f3 = fHeight + i3;
        if (A()) {
            this.P.setLook(BubbleLayout.Look.RIGHT);
        } else {
            this.P.setLook(BubbleLayout.Look.LEFT);
        }
        this.P.setLookPositionCenter(true);
        this.P.invalidate();
        getPopupContentView().setTranslationX(f2);
        getPopupContentView().setTranslationY(f3);
        y();
    }
}
