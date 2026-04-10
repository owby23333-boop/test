package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.e;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AttachPopupView extends BasePopupView {
    protected int N;
    protected int O;
    protected FrameLayout P;
    public boolean Q;
    public boolean R;
    float S;
    float T;
    float U;
    int V;
    float W;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView.this.y();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17356s;

        b(boolean z2) {
            this.f17356s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fC;
            if (this.f17356s) {
                AttachPopupView attachPopupView = AttachPopupView.this;
                if (attachPopupView.R) {
                    fC = ((com.lxj.xpopup.util.b.c(attachPopupView.getContext()) - AttachPopupView.this.f17361s.f17416k.x) - r2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.O;
                } else {
                    fC = (com.lxj.xpopup.util.b.c(attachPopupView.getContext()) - AttachPopupView.this.f17361s.f17416k.x) + r2.O;
                }
                attachPopupView.S = -fC;
            } else {
                AttachPopupView attachPopupView2 = AttachPopupView.this;
                attachPopupView2.S = attachPopupView2.R ? attachPopupView2.f17361s.f17416k.x + attachPopupView2.O : (attachPopupView2.f17361s.f17416k.x - attachPopupView2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.O;
            }
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f17361s.C) {
                if (attachPopupView3.R) {
                    if (this.f17356s) {
                        attachPopupView3.S += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    } else {
                        attachPopupView3.S -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    }
                } else if (this.f17356s) {
                    attachPopupView3.S -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                } else {
                    attachPopupView3.S += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                }
            }
            if (AttachPopupView.this.A()) {
                AttachPopupView attachPopupView4 = AttachPopupView.this;
                attachPopupView4.T = (attachPopupView4.f17361s.f17416k.y - attachPopupView4.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.N;
            } else {
                AttachPopupView attachPopupView5 = AttachPopupView.this;
                attachPopupView5.T = attachPopupView5.f17361s.f17416k.y + attachPopupView5.N;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.S);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.T);
            AttachPopupView.this.z();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17358s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ Rect f17359t;

        c(boolean z2, Rect rect) {
            this.f17358s = z2;
            this.f17359t = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17358s) {
                AttachPopupView attachPopupView = AttachPopupView.this;
                attachPopupView.S = -(attachPopupView.R ? ((com.lxj.xpopup.util.b.c(attachPopupView.getContext()) - this.f17359t.left) - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.O : (com.lxj.xpopup.util.b.c(attachPopupView.getContext()) - this.f17359t.right) + AttachPopupView.this.O);
            } else {
                AttachPopupView attachPopupView2 = AttachPopupView.this;
                attachPopupView2.S = attachPopupView2.R ? this.f17359t.left + attachPopupView2.O : (this.f17359t.right - attachPopupView2.getPopupContentView().getMeasuredWidth()) - AttachPopupView.this.O;
            }
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f17361s.C) {
                if (attachPopupView3.R) {
                    if (this.f17358s) {
                        attachPopupView3.S -= (this.f17359t.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    } else {
                        attachPopupView3.S += (this.f17359t.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    }
                } else if (this.f17358s) {
                    attachPopupView3.S += (this.f17359t.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                } else {
                    attachPopupView3.S -= (this.f17359t.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                }
            }
            if (AttachPopupView.this.A()) {
                AttachPopupView.this.T = (this.f17359t.top - r0.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.N;
            } else {
                AttachPopupView.this.T = this.f17359t.bottom + r0.N;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.S);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.T);
            AttachPopupView.this.z();
        }
    }

    public AttachPopupView(@NonNull Context context) {
        super(context);
        this.N = 0;
        this.O = 0;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = com.lxj.xpopup.util.b.a(getContext());
        this.V = com.lxj.xpopup.util.b.a(getContext(), 10.0f);
        this.W = 0.0f;
        this.P = (FrameLayout) findViewById(R$id.attachPopupContainer);
    }

    protected boolean A() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        return bVar.K ? this.W > ((float) (com.lxj.xpopup.util.b.a(getContext()) / 2)) : (this.Q || bVar.f17425t == PopupPosition.Top) && this.f17361s.f17425t != PopupPosition.Bottom;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.b.c getPopupAnimator() {
        e eVar;
        if (A()) {
            eVar = new e(getPopupContentView(), getAnimationDuration(), this.R ? PopupAnimation.ScrollAlphaFromLeftBottom : PopupAnimation.ScrollAlphaFromRightBottom);
        } else {
            eVar = new e(getPopupContentView(), getAnimationDuration(), this.R ? PopupAnimation.ScrollAlphaFromLeftTop : PopupAnimation.ScrollAlphaFromRightTop);
        }
        return eVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        if (this.P.getChildCount() == 0) {
            w();
        }
        if (this.f17361s.a() == null && this.f17361s.f17416k == null) {
            throw new IllegalArgumentException("atView() or watchView() must be called for AttachPopupView before show()！");
        }
        int iA = this.f17361s.A;
        if (iA == 0) {
            iA = com.lxj.xpopup.util.b.a(getContext(), 2.0f);
        }
        this.N = iA;
        int i2 = this.f17361s.f17431z;
        this.O = i2;
        this.P.setTranslationX(i2);
        this.P.setTranslationY(this.f17361s.A);
        x();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    protected void w() {
        this.P.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.P, false));
    }

    protected void x() {
        Drawable.ConstantState constantState;
        Drawable.ConstantState constantState2;
        if (this.f17367y) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (getPopupImplView().getBackground() != null && (constantState2 = getPopupImplView().getBackground().getConstantState()) != null) {
                this.P.setBackground(constantState2.newDrawable(getResources()));
                getPopupImplView().setBackground(null);
            }
            this.P.setElevation(com.lxj.xpopup.util.b.a(getContext(), 20.0f));
            return;
        }
        if (getPopupImplView().getBackground() == null || (constantState = getPopupImplView().getBackground().getConstantState()) == null) {
            return;
        }
        this.P.setBackground(constantState.newDrawable(getResources()));
        getPopupImplView().setBackground(null);
    }

    public void y() {
        int iB;
        int i2;
        float fB;
        int i3;
        this.U = com.lxj.xpopup.util.b.a(getContext()) - this.V;
        boolean zD = com.lxj.xpopup.util.b.d(getContext());
        com.lxj.xpopup.core.b bVar = this.f17361s;
        if (bVar == null) {
            return;
        }
        if (bVar.f17416k != null) {
            PointF pointF = com.lxj.xpopup.a.f17319f;
            if (pointF != null) {
                bVar.f17416k = pointF;
            }
            float f2 = this.f17361s.f17416k.y;
            this.W = f2;
            if (f2 + ((float) getPopupContentView().getMeasuredHeight()) > this.U) {
                this.Q = this.f17361s.f17416k.y > ((float) (com.lxj.xpopup.util.b.b(getContext()) / 2));
            } else {
                this.Q = false;
            }
            this.R = this.f17361s.f17416k.x < ((float) (com.lxj.xpopup.util.b.c(getContext()) / 2));
            ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
            if (A()) {
                fB = this.f17361s.f17416k.y - com.lxj.xpopup.util.b.c();
                i3 = this.V;
            } else {
                fB = com.lxj.xpopup.util.b.b(getContext()) - this.f17361s.f17416k.y;
                i3 = this.V;
            }
            int i4 = (int) (fB - i3);
            int iC = (int) ((this.R ? com.lxj.xpopup.util.b.c(getContext()) - this.f17361s.f17416k.x : this.f17361s.f17416k.x) - this.V);
            if (getPopupContentView().getMeasuredHeight() > i4) {
                layoutParams.height = i4;
            }
            if (getPopupContentView().getMeasuredWidth() > iC) {
                layoutParams.width = Math.max(iC, getPopupWidth());
            }
            getPopupContentView().setLayoutParams(layoutParams);
            getPopupContentView().post(new b(zD));
            return;
        }
        int[] iArr = new int[2];
        bVar.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f17361s.a().getMeasuredWidth(), iArr[1] + this.f17361s.a().getMeasuredHeight());
        int i5 = (rect.left + rect.right) / 2;
        boolean z2 = ((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.U;
        int i6 = rect.top;
        this.W = (rect.bottom + i6) / 2;
        if (z2) {
            int iC2 = (i6 - com.lxj.xpopup.util.b.c()) - this.V;
            if (getPopupContentView().getMeasuredHeight() > iC2) {
                this.Q = ((float) iC2) > this.U - ((float) rect.bottom);
            } else {
                this.Q = true;
            }
        } else {
            this.Q = false;
        }
        this.R = i5 < com.lxj.xpopup.util.b.c(getContext()) / 2;
        ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
        if (A()) {
            iB = rect.top - com.lxj.xpopup.util.b.c();
            i2 = this.V;
        } else {
            iB = com.lxj.xpopup.util.b.b(getContext()) - rect.bottom;
            i2 = this.V;
        }
        int i7 = iB - i2;
        int iC3 = (this.R ? com.lxj.xpopup.util.b.c(getContext()) - rect.left : rect.right) - this.V;
        if (getPopupContentView().getMeasuredHeight() > i7) {
            layoutParams2.height = i7;
        }
        if (getPopupContentView().getMeasuredWidth() > iC3) {
            layoutParams2.width = Math.max(iC3, getPopupWidth());
        }
        getPopupContentView().setLayoutParams(layoutParams2);
        getPopupContentView().post(new c(zD, rect));
    }

    protected void z() {
        p();
        l();
        j();
    }
}
