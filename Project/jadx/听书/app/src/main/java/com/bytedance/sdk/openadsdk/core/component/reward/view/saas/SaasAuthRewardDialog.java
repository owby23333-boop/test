package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.openadsdk.core.gz.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import com.bytedance.sdk.openadsdk.core.live.g;
import com.bytedance.sdk.openadsdk.core.mc;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    private static boolean uy;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RotateAnimation f977a;
    private ImageView dl;
    private na e;
    private int fo;
    private BaseSaasEnvelope g;
    private ScaleAnimation gc;
    private String gz;
    private boolean m;
    private SaasAuthEnvelope z;

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.m = false;
        z(context);
    }

    public void z(na naVar, String str, int i) {
        if (naVar == null || g.z().dl() != 2) {
            setVisibility(8);
            return;
        }
        oq oqVarMg = naVar.mg();
        if (oqVarMg == null || ((oqVarMg.kb() == null && oqVarMg.uy() == null) || !oqVarMg.fo())) {
            setVisibility(8);
            return;
        }
        this.e = naVar;
        this.gz = str;
        this.fo = i;
        setBackgroundColor(Color.parseColor("#aa000000"));
        gz.g().postDelayed(this, 5000L);
        z(getContext());
        dl();
    }

    private void z(Context context) {
        this.dl = new ImageView(context);
        try {
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_light_shine.webp")).to(this.dl);
            this.dl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int iA = com.bytedance.sdk.openadsdk.core.un.oq.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(13);
        addView(this.dl, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.z = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.z, layoutParams2);
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.g();
                gz.g().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.z.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.z();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.gc = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.gc.setFillAfter(true);
            this.gc.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.f977a = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.f977a.setDuration(5000L);
                    SaasAuthRewardDialog.this.f977a.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.f977a.setFillAfter(true);
                    SaasAuthRewardDialog.this.f977a.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.dl.startAnimation(SaasAuthRewardDialog.this.f977a);
                }
            });
            this.dl.startAnimation(this.gc);
            mc.g(true);
            setVisibility(0);
            this.z.z();
            gz.g().postDelayed(this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return;
        }
        if (!this.m) {
            gz.g().postDelayed(this, 5000L);
            g();
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.m = true;
        oq oqVarMg = this.e.mg();
        if (oqVarMg.uy() != null) {
            this.g = new SaasAuthCouponEnvelope(getContext(), oqVarMg.uy());
        } else if (oqVarMg.kb() != null) {
            this.g = new SaasAuthProductEnvelope(getContext(), oqVarMg.kb());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.g;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.g.z();
            com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(getContext(), this.e, this.gz, this.fo);
            setTag(67108864, 2917);
            com.bytedance.sdk.component.kb.gc.z.z().z(this.e.hashCode() + this.e.aq()).put("live_saas_interaction_type", 101);
            setOnClickListener(zVar);
            this.g.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.z();
                }
            });
            this.g.setOnButtonClickListener(zVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.z;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.g();
        }
        removeView(this.z);
    }

    public void z() {
        SaasAuthEnvelope saasAuthEnvelope = this.z;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.g();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.g;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.g();
        }
        RotateAnimation rotateAnimation = this.f977a;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.f977a = null;
        }
        ScaleAnimation scaleAnimation = this.gc;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.gc = null;
        }
        gz.g().removeCallbacks(this);
        setVisibility(8);
        mc.g(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mc.g(false);
    }

    private void dl() {
        try {
            if (uy) {
                return;
            }
            z zVar = new z();
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_light_shine.webp")).to(zVar);
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_red_envelope.webp")).to(zVar);
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_reward_goods_bg.webp")).to(zVar);
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_reward_coupon_bg.webp")).to(zVar);
            com.bytedance.sdk.openadsdk.gz.g.z(dl.z("saas_reward_title.webp")).to(zVar);
            uy = true;
        } catch (Throwable unused) {
        }
    }

    private static class z implements io {
        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(ls lsVar) {
        }

        private z() {
        }
    }
}
