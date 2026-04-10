package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bh;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends w implements View.OnClickListener {
    private ImageView fo;
    private TextView lN;
    private com.kwad.components.ad.reward.j qS;
    private ImageView za;
    private TextView zb;
    private TextView zc;
    private TextView zd;
    private View ze;
    private Set<ImageView> zf = new HashSet();
    private TextView zg;
    private Animator zh;

    public k(com.kwad.components.ad.reward.j jVar) {
        this.qS = jVar;
    }

    private static Animator a(View view, long j2, float f2) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f2).setDuration(j2);
        float f3 = -f2;
        long j3 = j2 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration2.setInterpolator(interpolatorCreate);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f3, f2).setDuration(j3);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration4.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(objectAnimatorOfFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f3, 0.0f).setDuration(j2));
        return animatorSet;
    }

    static /* synthetic */ Animator a(k kVar, View view) {
        return q(view);
    }

    static /* synthetic */ Animator a(k kVar, View view, long j2, float f2) {
        return a(view, 100L, 8.0f);
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.zb.setText(aVar.getTitle());
        this.lN.setText(aVar.hA());
        this.zc.setText(aVar.hx());
        String strFo = aVar.fo();
        Drawable drawable = this.fo.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.fo, strFo, drawable);
        String strAj = com.kwad.components.ad.c.b.aj();
        if (!ba.isNullString(strAj)) {
            KSImageLoader.loadImage(this.za, strAj, aVar.hs());
        }
        if (!aVar.hy()) {
            this.ze.setVisibility(8);
            return;
        }
        this.ze.setVisibility(0);
        String strHw = aVar.hw();
        if (!TextUtils.isEmpty(strHw)) {
            this.zg.setText(String.format("%s已预约直播", strHw));
        }
        if (aVar.hz() != null) {
            List<String> listHz = aVar.hz();
            int i2 = 0;
            for (ImageView imageView : this.zf) {
                if (i2 < listHz.size()) {
                    imageView.setVisibility(0);
                    KSImageLoader.loadCircleIcon(imageView, listHz.get(i2), drawable);
                }
                i2++;
            }
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        this.zd = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.za = (ImageView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.fo = (ImageView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.zb = (TextView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.lN = (TextView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.zc = (TextView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.ze = this.sN.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.zf.add(imageView);
        this.zf.add(imageView2);
        this.zf.add(imageView3);
        this.zg = (TextView) this.sN.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.sN.setOnClickListener(this);
        this.zc.setOnClickListener(this);
    }

    private void kk() {
        this.zd.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                kVar.zh = k.a(kVar, kVar.zd, 100L, 8.0f);
                k.this.zh.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.k.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (k.this.zh != null) {
                            k.this.zh.start();
                        }
                    }
                });
                k.this.zh.start();
            }
        }, 500L);
    }

    private void kl() {
        bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                k.a(kVar, kVar.ze).start();
            }
        }, com.anythink.expressad.exoplayer.i.a.f9492f);
    }

    private static Animator q(View view) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(interpolatorCreate);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.w(adTemplate));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void ad(boolean z2) {
        super.ad(z2);
        Context context = this.sN.getContext();
        if (ah.cu(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sN.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.sN.setLayoutParams(layoutParams);
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void kj() {
        kk();
        kl();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zc)) {
            this.qS.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.sN)) {
            this.qS.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.zh;
        if (animator != null) {
            animator.cancel();
            this.zh = null;
        }
    }
}
