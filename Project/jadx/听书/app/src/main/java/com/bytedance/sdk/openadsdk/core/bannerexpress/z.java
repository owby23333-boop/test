package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
class z extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected na f926a;
    protected NativeExpressView dl;
    protected com.bytedance.sdk.openadsdk.uf.z.g.z.dl e;
    protected boolean fo;
    protected NativeExpressView g;
    protected com.bytedance.sdk.openadsdk.ls.dl.dl.g gc;
    protected int gz;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.z m;
    protected String uy;
    protected final Context z;

    public z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(context);
        this.uy = "banner_ad";
        this.z = context;
        this.f926a = naVar;
        this.gc = gVar;
        z();
    }

    protected void z() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.z, this.f926a, this.gc, this.uy);
        this.g = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void z(na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.z, naVar, gVar, this.uy);
        this.dl = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.z.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, int i) {
                if (z.this.m != null) {
                    z.this.m.z(z.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, float f, float f2) {
                z.this.z(f, f2);
                z.this.m();
            }
        });
        oq.z((View) this.dl, 8);
        addView(this.dl, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        this.e = dlVar;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.z zVar) {
        this.m = zVar;
        NativeExpressView nativeExpressView = this.g;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.z.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, int i) {
                    if (z.this.m != null) {
                        z.this.m.z(z.this, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, String str, int i) {
                    if (z.this.m != null) {
                        z.this.m.z(z.this, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).q()) {
                        z.this.z(f, f2);
                    }
                    if (z.this.m != null) {
                        z.this.m.z(z.this, f, f2);
                    }
                }
            });
        }
    }

    protected void z(float f, float f2) {
        int iDl = oq.dl(this.z, f);
        int iDl2 = oq.dl(this.z, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iDl, iDl2);
        }
        layoutParams.width = iDl;
        layoutParams.height = iDl2;
        setLayoutParams(layoutParams);
    }

    public void gc() {
        NativeExpressView nativeExpressView = this.g;
        if (nativeExpressView != null) {
            nativeExpressView.p();
        }
    }

    public void a() {
        NativeExpressView nativeExpressView = this.g;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.g.i();
            this.g = null;
        }
        NativeExpressView nativeExpressView2 = this.dl;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.dl.i();
            this.dl = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.g;
    }

    public NativeExpressView getNextView() {
        return this.dl;
    }

    public void setDuration(int i) {
        this.gz = i;
    }

    private ObjectAnimator z(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator g(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.z.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                z.this.fo = false;
            }
        });
        return objectAnimatorOfFloat;
    }

    public void dl() {
        NativeExpressView nativeExpressView = this.dl;
        if (nativeExpressView != null) {
            nativeExpressView.p();
        }
    }

    protected void m() {
        if (this.fo || this.dl == null || this.g == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(z(this.g)).with(g(this.dl));
        animatorSet.setDuration(this.gz).start();
        oq.z((View) this.dl, 0);
        this.fo = true;
        NativeExpressView nativeExpressView = this.g;
        this.g = this.dl;
        this.dl = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.dl.i();
            this.dl = null;
        }
    }

    public boolean g() {
        return this.dl != null;
    }
}
