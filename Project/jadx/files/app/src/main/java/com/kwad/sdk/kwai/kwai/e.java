package com.kwad.sdk.kwai.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bc;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    private final boolean YM;
    private final boolean YN;
    private View YO;
    private ImageView YP;
    private TextView YQ;
    private Button YR;
    private int YS;
    private int YT;
    private boolean YU;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = tu();

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z2, boolean z3, boolean z4) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.YM = z2;
        this.YN = z3;
        this.YU = z4;
        lw();
    }

    private Animator A(View view) {
        ObjectAnimator objectAnimatorOfFloat = (this.YM && this.YN) ? ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.YT) : ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.YS);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        objectAnimatorOfFloat.setDuration(260L);
        return objectAnimatorOfFloat;
    }

    private void b(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.YS = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.YS);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void c(FrameLayout frameLayout) {
        int screenWidth = bc.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.YT = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.YT);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void lw() {
        this.YR.setText(this.YM ? "安装" : "打开");
        this.YO.setOnClickListener(this);
        this.YR.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.YP, com.kwad.sdk.core.response.a.a.bL(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)), this.mAdTemplate, 8);
        String strAp = com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        if (strAp.length() >= 8) {
            strAp = strAp.substring(0, 7) + "...";
        }
        this.YQ.setText(this.mContext.getString(this.YM ? R.string.ksad_install_tips : R.string.ksad_launch_tips, strAp));
    }

    private void show() {
        ObjectAnimator objectAnimatorOfFloat = (this.YM && this.YN) ? ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.YT, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.YS, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    @SuppressLint({"InflateParams"})
    private View tu() {
        Context context;
        int i2;
        if (this.YM && this.YN) {
            context = this.mContext;
            i2 = R.layout.ksad_install_tips_bottom;
        } else {
            context = this.mContext;
            i2 = R.layout.ksad_install_tips;
        }
        this.mRootView = com.kwad.sdk.i.a.inflate(context, i2, null);
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.YO = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.YP = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.YQ = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.YR = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    public final void a(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.YM && this.YN) {
            c(frameLayout);
        } else {
            b(frameLayout);
        }
        this.mRootView.postDelayed(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.dismiss();
            }
        }, 10000L);
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator animatorA = A(this.mRootView);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.kwai.kwai.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        animatorA.start();
        c.tm().tr();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() != R.id.ksad_install_tips_install) {
            if (view.getId() == R.id.ksad_install_tips_close) {
                if (!this.YM) {
                    com.kwad.sdk.core.report.a.n(this.mAdTemplate, 48);
                    return;
                }
                if (!this.YU) {
                    com.kwad.sdk.core.report.a.o(this.mAdTemplate, 46);
                    return;
                }
                i iVar = new i();
                iVar.bh(69);
                iVar.bm(23);
                iVar.bq(1);
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar);
                return;
            }
            return;
        }
        if (!this.YM) {
            if (aj.aj(this.mContext, com.kwad.sdk.core.response.a.a.ar(this.mAdInfo))) {
                com.kwad.sdk.core.report.a.au(this.mAdTemplate);
            }
            com.kwad.sdk.core.report.a.n(this.mAdTemplate, 47);
            return;
        }
        if (this.YU) {
            i iVar2 = new i();
            iVar2.bh(29);
            iVar2.bm(23);
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar2);
        } else {
            com.kwad.sdk.core.report.a.o(this.mAdTemplate, 45);
        }
        if (aj.ak(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), this.mAdInfo.downloadFilePath)) {
            com.kwad.sdk.core.report.a.h(this.mAdTemplate, 1);
        }
    }
}
