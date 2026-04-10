package com.kwad.components.ad.reward.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.bh;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d implements View.OnClickListener {
    private final ViewGroup gu;
    private TextView hb;
    private TextView lN;
    private int[] ro;
    private View rp;
    private ImageView rq;
    private TextView rr;
    private Button rs;

    @Nullable
    private b rt;

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.a.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ v ru;
        final /* synthetic */ long rv;

        AnonymousClass1(v vVar, long j2) {
            this.ru = vVar;
            this.rv = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            final Animator animatorA = a.a(aVar, aVar.rp);
            animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorA.removeListener(this);
                    com.kwad.sdk.core.report.a.b(AnonymousClass1.this.ru.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.rq, AnonymousClass1.this.rv).start();
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.reward.a.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hd();
                        }
                    }, null, AnonymousClass1.this.rv);
                }
            });
            animatorA.start();
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.a.a$a, reason: collision with other inner class name */
    static class C0365a {
        private CharSequence rB;
        private CharSequence rC;
        private CharSequence rD;
        private CharSequence title;

        private C0365a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.rB = couponInfo.displayValue;
            this.rC = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.rD = couponInfo.displayActionWords;
        }

        @Nullable
        private static C0365a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0365a(couponInfo);
        }

        @Nullable
        public static C0365a u(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (adProductInfoCr == null || (list = adProductInfoCr.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(adProductInfoCr.couponList.get(0));
        }

        public final CharSequence P(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.rB));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence he() {
            return this.rC;
        }

        public final CharSequence hf() {
            return this.rD;
        }
    }

    public interface b {
        void hg();

        void hh();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.ro = iArr;
        this.gu = (ViewGroup) com.kwad.sdk.i.a.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        d(this.gu);
    }

    private static Animator a(ImageView imageView, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(j2);
        return objectAnimatorOfFloat;
    }

    static /* synthetic */ Animator a(a aVar, View view) {
        return n(view);
    }

    static /* synthetic */ Animator a(a aVar, ImageView imageView, long j2) {
        return a(imageView, j2);
    }

    private void a(C0365a c0365a) {
        if (c0365a == null) {
            return;
        }
        TextView textView = this.hb;
        if (textView != null) {
            textView.setText(c0365a.getTitle());
        }
        TextView textView2 = this.rr;
        if (textView2 != null) {
            textView2.setText(c0365a.P(this.gu.getContext()));
        }
        TextView textView3 = this.lN;
        if (textView3 != null) {
            textView3.setText(c0365a.he());
        }
        Button button = this.rs;
        if (button != null) {
            button.setText(c0365a.hf());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.rp = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.rq = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.hb = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.rr = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.lN = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        this.rs = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.rs.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        final Animator animatorO = o(this.rp);
        animatorO.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animatorO.removeListener(this);
                if (a.this.rt != null) {
                    a.this.rt.hh();
                }
            }
        });
        animatorO.start();
    }

    private static Animator n(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    private Animator o(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        int[] iArrF;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        int[] iArr = this.ro;
        ObjectAnimator objectAnimatorOfFloat4 = null;
        if (iArr == null || iArr.length < 2 || (iArrF = com.kwad.sdk.b.kwai.a.F(view)) == null) {
            objectAnimatorOfFloat = null;
        } else {
            Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationX", this.ro[0] - iArrF[0]);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", this.ro[1] - iArrF[1]);
            objectAnimatorOfFloat4.setInterpolator(interpolatorCreate2);
            objectAnimatorOfFloat.setInterpolator(interpolatorCreate2);
        }
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat5.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat6.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimatorOfFloat4 != null) {
            animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, animatorSet, objectAnimatorOfFloat4, objectAnimatorOfFloat);
        } else {
            animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, animatorSet);
        }
        return animatorSet2;
    }

    public final void a(@Nullable b bVar) {
        this.rt = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(C0365a.u(vVar.getAdTemplate()));
        this.gu.post(new AnonymousClass1(vVar, com.kwad.components.ad.reward.kwai.b.gX()));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.gu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.rs) || (bVar = this.rt) == null) {
            return;
        }
        bVar.hg();
    }
}
