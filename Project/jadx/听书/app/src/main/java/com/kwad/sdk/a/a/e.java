package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements View.OnClickListener {
    private final boolean ato;
    private final boolean atp;
    private View atq;
    private ImageView atr;
    private TextView ats;
    private Button att;
    private int atu;
    private int atv;
    private boolean atw;
    private final AdInfo mAdInfo;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private View mRootView = Dc();

    public e(Context context, AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.ato = z;
        this.atp = z2;
        this.atw = z3;
        nu();
    }

    private View Dc() {
        if (this.ato && this.atp) {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.atq = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.atr = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.ats = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.att = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private void nu() {
        this.att.setText(this.ato ? "安装" : "打开");
        this.atq.setOnClickListener(this);
        this.att.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.atr, com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)), this.mAdTemplate, 8);
        String strAv = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
        if (strAv.length() >= 8) {
            strAv = strAv.substring(0, 7) + "...";
        }
        this.ats.setText(this.mContext.getString(this.ato ? R.string.ksad_install_tips : R.string.ksad_launch_tips, strAv));
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.ato && this.atp) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new bg() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                e.this.dismiss();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private void c(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.atu = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.atu);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void d(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = br.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.atv = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.atv);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator animatorF = F(this.mRootView);
        animatorF.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        animatorF.start();
        c.CU().CZ();
    }

    private Animator F(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        if (this.ato && this.atp) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.atv);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.atu);
        }
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        objectAnimatorOfFloat.setDuration(260L);
        return objectAnimatorOfFloat;
    }

    private void show() {
        ObjectAnimator objectAnimatorOfFloat;
        if (this.ato && this.atp) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.atv, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.atu, 0.0f);
        }
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (this.ato) {
                if (this.atw) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.df(29);
                    bVar.dm(23);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar);
                } else {
                    com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 45);
                }
                as.a(com.kwad.sdk.core.response.b.a.H(this.mAdInfo), new as.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.as.a
                    public final void pR() {
                        com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bk(e.this.mAdTemplate);
                    }

                    @Override // com.kwad.sdk.utils.as.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }
                });
                return;
            }
            if (as.as(this.mContext, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
                com.kwad.sdk.core.adlog.c.bU(this.mAdTemplate);
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 47);
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (this.ato) {
                if (this.atw) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    bVar2.df(69);
                    bVar2.dm(23);
                    bVar2.dq(1);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, null, bVar2);
                    return;
                }
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 48);
        }
    }
}
