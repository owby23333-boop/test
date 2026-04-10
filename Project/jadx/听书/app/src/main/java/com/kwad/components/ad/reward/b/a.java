package com.kwad.components.ad.reward.b;

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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d implements View.OnClickListener {
    private TextView fv;
    private final ViewGroup jI;
    private TextView ko;
    private int[] tJ;
    private View tK;
    private ImageView tL;
    private TextView tM;
    private Button tN;
    private b tO;

    public interface b {
        void hT();

        void hU();
    }

    static /* synthetic */ Animator a(a aVar, View view) {
        return o(view);
    }

    static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    public a(Context context, ViewGroup viewGroup, int[] iArr) {
        this.tJ = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.jI = viewGroup2;
        d(viewGroup2);
    }

    public final void a(b bVar) {
        this.tO = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.jI;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0298a.Q(rVar.getAdTemplate()));
        this.jI.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.hI()));
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    final class AnonymousClass1 extends bg {
        final /* synthetic */ r tP;
        final /* synthetic */ long tQ;

        AnonymousClass1(r rVar, long j) {
            this.tP = rVar;
            this.tQ = j;
        }

        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            a aVar = a.this;
            final Animator animatorA = a.a(aVar, aVar.tK);
            animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorA.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.tP.getAdTemplate(), 169, (JSONObject) null);
                    a.a(a.this, a.this.tL, AnonymousClass1.this.tQ).start();
                    bw.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hQ();
                        }
                    }, null, AnonymousClass1.this.tQ);
                }
            });
            animatorA.start();
        }
    }

    private void a(C0298a c0298a) {
        if (c0298a == null) {
            return;
        }
        TextView textView = this.ko;
        if (textView != null) {
            textView.setText(c0298a.getTitle());
        }
        TextView textView2 = this.tM;
        if (textView2 != null) {
            textView2.setText(c0298a.Q(this.jI.getContext()));
        }
        TextView textView3 = this.fv;
        if (textView3 != null) {
            textView3.setText(c0298a.hR());
        }
        Button button = this.tN;
        if (button != null) {
            button.setText(c0298a.hS());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.tK = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.tL = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.ko = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.tM = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.fv = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.tN = button;
        button.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.tN) || (bVar = this.tO) == null) {
            return;
        }
        bVar.hT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        final Animator animatorP = p(this.tK);
        animatorP.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animatorP.removeListener(this);
                if (a.this.tO != null) {
                    a.this.tO.hU();
                }
            }
        });
        animatorP.start();
    }

    private static Animator o(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    private static Animator a(ImageView imageView, long j) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    private Animator p(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        int[] iArrI;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat4.setInterpolator(interpolatorCreate);
        int[] iArr = this.tJ;
        if (iArr == null || iArr.length < 2 || (iArrI = com.kwad.sdk.c.a.a.I(view)) == null) {
            objectAnimatorOfFloat = null;
            objectAnimatorOfFloat2 = null;
        } else {
            Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", this.tJ[0] - iArrI[0]);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", this.tJ[1] - iArrI[1]);
            objectAnimatorOfFloat.setInterpolator(interpolatorCreate2);
            objectAnimatorOfFloat2.setInterpolator(interpolatorCreate2);
        }
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat5.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat6.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimatorOfFloat != null) {
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, animatorSet, objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } else {
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, animatorSet);
        }
        return animatorSet2;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    static class C0298a {
        private CharSequence tW;
        private CharSequence tX;
        private CharSequence tY;
        private CharSequence title;

        private C0298a(CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.tW = couponInfo.displayValue;
            if (!TextUtils.isEmpty(couponInfo.displayBase)) {
                this.tX = String.format("满%s可用", couponInfo.displayBase);
            } else {
                this.tX = "";
            }
            this.tY = couponInfo.displayActionWords;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence Q(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.tW));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence hR() {
            return this.tX;
        }

        public final CharSequence hS() {
            return this.tY;
        }

        public static C0298a Q(AdTemplate adTemplate) {
            AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(e.el(adTemplate));
            if (adProductInfoCV == null || adProductInfoCV.couponList == null || adProductInfoCV.couponList.size() <= 0) {
                return null;
            }
            return a(adProductInfoCV.couponList.get(0));
        }

        private static C0298a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0298a(couponInfo);
        }
    }
}
