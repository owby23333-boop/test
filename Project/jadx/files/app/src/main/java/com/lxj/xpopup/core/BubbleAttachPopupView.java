package com.lxj.xpopup.core;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.widget.BubbleLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BubbleAttachPopupView extends BasePopupView {
    protected int N;
    protected int O;
    protected BubbleLayout P;
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
            BubbleAttachPopupView.this.x();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17378s;

        b(boolean z2) {
            this.f17378s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fC;
            if (this.f17378s) {
                BubbleAttachPopupView bubbleAttachPopupView = BubbleAttachPopupView.this;
                if (bubbleAttachPopupView.R) {
                    fC = ((com.lxj.xpopup.util.b.c(bubbleAttachPopupView.getContext()) - BubbleAttachPopupView.this.f17361s.f17416k.x) - r2.getPopupContentView().getMeasuredWidth()) - BubbleAttachPopupView.this.O;
                } else {
                    fC = (com.lxj.xpopup.util.b.c(bubbleAttachPopupView.getContext()) - BubbleAttachPopupView.this.f17361s.f17416k.x) + r2.O;
                }
                bubbleAttachPopupView.S = -fC;
            } else {
                BubbleAttachPopupView bubbleAttachPopupView2 = BubbleAttachPopupView.this;
                bubbleAttachPopupView2.S = bubbleAttachPopupView2.R ? bubbleAttachPopupView2.f17361s.f17416k.x + bubbleAttachPopupView2.O : (bubbleAttachPopupView2.f17361s.f17416k.x - bubbleAttachPopupView2.getPopupContentView().getMeasuredWidth()) - BubbleAttachPopupView.this.O;
            }
            BubbleAttachPopupView bubbleAttachPopupView3 = BubbleAttachPopupView.this;
            if (bubbleAttachPopupView3.f17361s.C) {
                if (bubbleAttachPopupView3.R) {
                    if (this.f17378s) {
                        bubbleAttachPopupView3.S += bubbleAttachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    } else {
                        bubbleAttachPopupView3.S -= bubbleAttachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                    }
                } else if (this.f17378s) {
                    bubbleAttachPopupView3.S -= bubbleAttachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                } else {
                    bubbleAttachPopupView3.S += bubbleAttachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                }
            }
            if (BubbleAttachPopupView.this.z()) {
                BubbleAttachPopupView bubbleAttachPopupView4 = BubbleAttachPopupView.this;
                bubbleAttachPopupView4.T = (bubbleAttachPopupView4.f17361s.f17416k.y - bubbleAttachPopupView4.getPopupContentView().getMeasuredHeight()) - BubbleAttachPopupView.this.N;
            } else {
                BubbleAttachPopupView bubbleAttachPopupView5 = BubbleAttachPopupView.this;
                bubbleAttachPopupView5.T = bubbleAttachPopupView5.f17361s.f17416k.y + bubbleAttachPopupView5.N;
            }
            if (BubbleAttachPopupView.this.z()) {
                BubbleAttachPopupView.this.P.setLook(BubbleLayout.Look.BOTTOM);
            } else {
                BubbleAttachPopupView.this.P.setLook(BubbleLayout.Look.TOP);
            }
            BubbleAttachPopupView bubbleAttachPopupView6 = BubbleAttachPopupView.this;
            if (bubbleAttachPopupView6.f17361s.C) {
                bubbleAttachPopupView6.P.setLookPositionCenter(true);
            } else if (bubbleAttachPopupView6.R) {
                bubbleAttachPopupView6.P.setLookPosition(com.lxj.xpopup.util.b.a(bubbleAttachPopupView6.getContext(), 1.0f));
            } else {
                BubbleLayout bubbleLayout = bubbleAttachPopupView6.P;
                bubbleLayout.setLookPosition(bubbleLayout.getMeasuredWidth() - com.lxj.xpopup.util.b.a(BubbleAttachPopupView.this.getContext(), 1.0f));
            }
            BubbleAttachPopupView.this.P.invalidate();
            BubbleAttachPopupView.this.getPopupContentView().setTranslationX(BubbleAttachPopupView.this.S);
            BubbleAttachPopupView.this.getPopupContentView().setTranslationY(BubbleAttachPopupView.this.T);
            BubbleAttachPopupView.this.y();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17380s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ Rect f17381t;

        c(boolean z2, Rect rect) {
            this.f17380s = z2;
            this.f17381t = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17380s) {
                BubbleAttachPopupView bubbleAttachPopupView = BubbleAttachPopupView.this;
                bubbleAttachPopupView.S = -(bubbleAttachPopupView.R ? ((com.lxj.xpopup.util.b.c(bubbleAttachPopupView.getContext()) - this.f17381t.left) - BubbleAttachPopupView.this.getPopupContentView().getMeasuredWidth()) - BubbleAttachPopupView.this.O : (com.lxj.xpopup.util.b.c(bubbleAttachPopupView.getContext()) - this.f17381t.right) + BubbleAttachPopupView.this.O);
            } else {
                BubbleAttachPopupView bubbleAttachPopupView2 = BubbleAttachPopupView.this;
                bubbleAttachPopupView2.S = bubbleAttachPopupView2.R ? this.f17381t.left + bubbleAttachPopupView2.O : (this.f17381t.right - bubbleAttachPopupView2.getPopupContentView().getMeasuredWidth()) - BubbleAttachPopupView.this.O;
            }
            BubbleAttachPopupView bubbleAttachPopupView3 = BubbleAttachPopupView.this;
            if (bubbleAttachPopupView3.f17361s.C) {
                if (bubbleAttachPopupView3.R) {
                    if (this.f17380s) {
                        bubbleAttachPopupView3.S -= (this.f17381t.width() - BubbleAttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    } else {
                        bubbleAttachPopupView3.S += (this.f17381t.width() - BubbleAttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                    }
                } else if (this.f17380s) {
                    bubbleAttachPopupView3.S += (this.f17381t.width() - BubbleAttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                } else {
                    bubbleAttachPopupView3.S -= (this.f17381t.width() - BubbleAttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                }
            }
            if (BubbleAttachPopupView.this.z()) {
                BubbleAttachPopupView.this.T = (this.f17381t.top - r0.getPopupContentView().getMeasuredHeight()) - BubbleAttachPopupView.this.N;
            } else {
                BubbleAttachPopupView.this.T = this.f17381t.bottom + r0.N;
            }
            if (BubbleAttachPopupView.this.z()) {
                BubbleAttachPopupView.this.P.setLook(BubbleLayout.Look.BOTTOM);
            } else {
                BubbleAttachPopupView.this.P.setLook(BubbleLayout.Look.TOP);
            }
            BubbleAttachPopupView bubbleAttachPopupView4 = BubbleAttachPopupView.this;
            if (bubbleAttachPopupView4.f17361s.C) {
                bubbleAttachPopupView4.P.setLookPositionCenter(true);
            } else {
                BubbleLayout bubbleLayout = bubbleAttachPopupView4.P;
                Rect rect = this.f17381t;
                bubbleLayout.setLookPosition((rect.left + (rect.width() / 2)) - ((int) BubbleAttachPopupView.this.S));
            }
            BubbleAttachPopupView.this.P.invalidate();
            BubbleAttachPopupView.this.getPopupContentView().setTranslationX(BubbleAttachPopupView.this.S);
            BubbleAttachPopupView.this.getPopupContentView().setTranslationY(BubbleAttachPopupView.this.T);
            BubbleAttachPopupView.this.y();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_bubble_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.b.c getPopupAnimator() {
        return new d(getPopupContentView(), getAnimationDuration(), PopupAnimation.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        if (this.P.getChildCount() == 0) {
            w();
        }
        if (this.f17361s.a() == null && this.f17361s.f17416k == null) {
            throw new IllegalArgumentException("atView() or watchView() must be called for BubbleAttachPopupView before show()！");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.P.setElevation(com.lxj.xpopup.util.b.a(getContext(), 10.0f));
        }
        this.P.setShadowRadius(com.lxj.xpopup.util.b.a(getContext(), 2.0f));
        com.lxj.xpopup.core.b bVar = this.f17361s;
        this.N = bVar.A;
        int i2 = bVar.f17431z;
        this.O = i2;
        this.P.setTranslationX(i2);
        this.P.setTranslationY(this.f17361s.A);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a());
    }

    protected void w() {
        this.P.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.P, false));
    }

    public void x() {
        int iB;
        int i2;
        float fB;
        int i3;
        this.U = com.lxj.xpopup.util.b.a(getContext()) - this.V;
        boolean zD = com.lxj.xpopup.util.b.d(getContext());
        com.lxj.xpopup.core.b bVar = this.f17361s;
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
            if (z()) {
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
                layoutParams.width = iC;
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
        this.W = (rect.top + rect.bottom) / 2;
        if (z2) {
            this.Q = true;
        } else {
            this.Q = false;
        }
        this.R = i5 < com.lxj.xpopup.util.b.c(getContext()) / 2;
        ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
        if (z()) {
            iB = rect.top - com.lxj.xpopup.util.b.c();
            i2 = this.V;
        } else {
            iB = com.lxj.xpopup.util.b.b(getContext()) - rect.bottom;
            i2 = this.V;
        }
        int i6 = iB - i2;
        int iC2 = (this.R ? com.lxj.xpopup.util.b.c(getContext()) - rect.left : rect.right) - this.V;
        if (getPopupContentView().getMeasuredHeight() > i6) {
            layoutParams2.height = i6;
        }
        if (getPopupContentView().getMeasuredWidth() > iC2) {
            layoutParams2.width = iC2;
        }
        getPopupContentView().setLayoutParams(layoutParams2);
        getPopupContentView().post(new c(zD, rect));
    }

    protected void y() {
        p();
        l();
        j();
    }

    protected boolean z() {
        com.lxj.xpopup.core.b bVar = this.f17361s;
        return bVar.K ? this.W > ((float) (com.lxj.xpopup.util.b.a(getContext()) / 2)) : (this.Q || bVar.f17425t == PopupPosition.Top) && this.f17361s.f17425t != PopupPosition.Bottom;
    }
}
