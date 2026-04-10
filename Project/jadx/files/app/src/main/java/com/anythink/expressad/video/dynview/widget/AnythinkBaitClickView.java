package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBaitClickView extends RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;
    private static final String a = "MBridgeAnimationClickView";
    private AnyThinkImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnyThinkImageView f11773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f11774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animation f11780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Animation f11781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animation f11782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Animation f11783m;

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$3, reason: invalid class name */
    final class AnonymousClass3 implements Animation.AnimationListener {
        AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            if (AnythinkBaitClickView.this.f11773c != null) {
                AnythinkBaitClickView.this.f11773c.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (AnythinkBaitClickView.this.f11773c != null) {
                AnythinkBaitClickView.this.f11773c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$4, reason: invalid class name */
    final class AnonymousClass4 implements Animation.AnimationListener {
        final /* synthetic */ AnimationSet a;

        AnonymousClass4(AnimationSet animationSet) {
            this.a = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.4.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.b != null) {
                        AnythinkBaitClickView.this.b.startAnimation(AnythinkBaitClickView.this.f11780j);
                    }
                }
            }, 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.f11773c != null) {
                        AnythinkBaitClickView.this.f11773c.startAnimation(AnonymousClass4.this.a);
                    }
                }
            }, 550L);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$5, reason: invalid class name */
    final class AnonymousClass5 implements Animation.AnimationListener {
        AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            AnythinkBaitClickView.this.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.5.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnythinkBaitClickView.this.b != null) {
                        AnythinkBaitClickView.this.b.startAnimation(AnythinkBaitClickView.this.f11780j);
                    }
                }
            }, 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    public AnythinkBaitClickView(@NonNull Context context) {
        super(context);
        this.f11775e = "";
        this.f11776f = "";
        this.f11777g = "Click now for details";
        this.f11778h = 1;
        this.f11779i = 1342177280;
    }

    private void d() {
        AnyThinkImageView anyThinkImageView = this.f11773c;
        if (anyThinkImageView != null) {
            anyThinkImageView.setVisibility(4);
        }
        this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f11780j.setDuration(500L);
        this.f11780j.setRepeatCount(1);
        this.f11780j.setRepeatMode(2);
        this.f11781k = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.f11781k.setDuration(1000L);
        this.f11781k.setRepeatCount(0);
        this.f11782l = new AlphaAnimation(1.0f, 0.0f);
        this.f11782l.setDuration(1000L);
        this.f11782l.setRepeatCount(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f11781k);
        animationSet.addAnimation(this.f11782l);
        this.f11781k.setAnimationListener(new AnonymousClass3());
        this.f11780j.setAnimationListener(new AnonymousClass4(animationSet));
        AnyThinkImageView anyThinkImageView2 = this.b;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(this.f11780j);
        }
    }

    private void e() {
        this.f11780j = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f11780j.setDuration(200L);
        this.f11780j.setRepeatCount(1);
        this.f11780j.setAnimationListener(new AnonymousClass5());
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.f11780j);
        }
    }

    private void f() {
        this.f11783m = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.f11783m.setDuration(300L);
        this.f11783m.setRepeatMode(2);
        this.f11783m.setRepeatCount(-1);
        this.f11781k = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f11781k.setDuration(600L);
        this.f11781k.setRepeatCount(-1);
        this.f11782l = new AlphaAnimation(1.0f, 0.0f);
        this.f11782l.setDuration(600L);
        this.f11782l.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f11781k);
        animationSet.addAnimation(this.f11782l);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.f11783m);
        }
        AnyThinkImageView anyThinkImageView2 = this.f11773c;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(animationSet);
        }
    }

    public void init(int i2) {
        this.f11778h = i2;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        Animation animation = this.f11780j;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f11781k;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f11782l;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f11783m;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i2 = this.f11778h;
        if (i2 == 2) {
            this.f11773c.setVisibility(4);
            this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f11780j.setDuration(500L);
            this.f11780j.setRepeatCount(-1);
            this.f11780j.setRepeatMode(2);
            AnyThinkImageView anyThinkImageView = this.b;
            if (anyThinkImageView != null) {
                anyThinkImageView.startAnimation(this.f11780j);
                return;
            }
            return;
        }
        if (i2 == 3) {
            AnyThinkImageView anyThinkImageView2 = this.f11773c;
            if (anyThinkImageView2 != null) {
                anyThinkImageView2.setVisibility(4);
            }
            this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f11780j.setDuration(500L);
            this.f11780j.setRepeatCount(1);
            this.f11780j.setRepeatMode(2);
            this.f11781k = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.f11781k.setDuration(1000L);
            this.f11781k.setRepeatCount(0);
            this.f11782l = new AlphaAnimation(1.0f, 0.0f);
            this.f11782l.setDuration(1000L);
            this.f11782l.setRepeatCount(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(this.f11781k);
            animationSet.addAnimation(this.f11782l);
            this.f11781k.setAnimationListener(new AnonymousClass3());
            this.f11780j.setAnimationListener(new AnonymousClass4(animationSet));
            AnyThinkImageView anyThinkImageView3 = this.b;
            if (anyThinkImageView3 != null) {
                anyThinkImageView3.startAnimation(this.f11780j);
                return;
            }
            return;
        }
        if (i2 == 4) {
            this.f11773c.setVisibility(4);
            this.f11780j = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.f11780j.setDuration(200L);
            this.f11780j.setRepeatCount(1);
            this.f11780j.setAnimationListener(new AnonymousClass5());
            AnyThinkImageView anyThinkImageView4 = this.b;
            if (anyThinkImageView4 != null) {
                anyThinkImageView4.startAnimation(this.f11780j);
                return;
            }
            return;
        }
        if (i2 != 5) {
            this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.f11780j.setDuration(200L);
            this.f11780j.setRepeatCount(-1);
            this.f11780j.setRepeatMode(2);
            AnyThinkImageView anyThinkImageView5 = this.b;
            if (anyThinkImageView5 != null) {
                anyThinkImageView5.startAnimation(this.f11780j);
            }
            this.f11781k = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.f11781k.setDuration(400L);
            this.f11781k.setRepeatCount(-1);
            this.f11782l = new AlphaAnimation(1.0f, 0.3f);
            this.f11782l.setDuration(400L);
            this.f11782l.setRepeatCount(-1);
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(this.f11781k);
            animationSet2.addAnimation(this.f11782l);
            AnyThinkImageView anyThinkImageView6 = this.f11773c;
            if (anyThinkImageView6 != null) {
                anyThinkImageView6.startAnimation(animationSet2);
                return;
            }
            return;
        }
        this.f11783m = new RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.f11783m.setDuration(300L);
        this.f11783m.setRepeatMode(2);
        this.f11783m.setRepeatCount(-1);
        this.f11781k = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f11781k.setDuration(600L);
        this.f11781k.setRepeatCount(-1);
        this.f11782l = new AlphaAnimation(1.0f, 0.0f);
        this.f11782l.setDuration(600L);
        this.f11782l.setRepeatCount(-1);
        AnimationSet animationSet3 = new AnimationSet(true);
        animationSet3.addAnimation(this.f11781k);
        animationSet3.addAnimation(this.f11782l);
        AnyThinkImageView anyThinkImageView7 = this.b;
        if (anyThinkImageView7 != null) {
            anyThinkImageView7.startAnimation(this.f11783m);
        }
        AnyThinkImageView anyThinkImageView8 = this.f11773c;
        if (anyThinkImageView8 != null) {
            anyThinkImageView8.startAnimation(animationSet3);
        }
    }

    private void a() {
        try {
            this.f11777g = getContext().getResources().getConfiguration().locale.getLanguage().contains(com.anythink.expressad.video.dynview.a.a.V) ? "点击查看详情" : "Click now for details";
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    private void b() {
        this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f11780j.setDuration(200L);
        this.f11780j.setRepeatCount(-1);
        this.f11780j.setRepeatMode(2);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.f11780j);
        }
        this.f11781k = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.f11781k.setDuration(400L);
        this.f11781k.setRepeatCount(-1);
        this.f11782l = new AlphaAnimation(1.0f, 0.3f);
        this.f11782l.setDuration(400L);
        this.f11782l.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(this.f11781k);
        animationSet.addAnimation(this.f11782l);
        AnyThinkImageView anyThinkImageView2 = this.f11773c;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.startAnimation(animationSet);
        }
    }

    private void c() {
        this.f11780j = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.f11780j.setDuration(500L);
        this.f11780j.setRepeatCount(-1);
        this.f11780j.setRepeatMode(2);
        AnyThinkImageView anyThinkImageView = this.b;
        if (anyThinkImageView != null) {
            anyThinkImageView.startAnimation(this.f11780j);
        }
    }

    public void init(int i2, int i3) {
        this.f11779i = i2;
        this.f11778h = i3;
        init();
    }

    public void init(int i2, int i3, String str, String str2, String str3) {
        this.f11779i = i2;
        this.f11778h = i3;
        this.f11775e = str;
        this.f11776f = str2;
        this.f11777g = str3;
        init();
    }

    public AnythinkBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11775e = "";
        this.f11776f = "";
        this.f11777g = "Click now for details";
        this.f11778h = 1;
        this.f11779i = 1342177280;
    }

    public void init() {
        try {
            setBackgroundColor(this.f11779i);
            try {
                this.f11777g = getContext().getResources().getConfiguration().locale.getLanguage().contains(com.anythink.expressad.video.dynview.a.a.V) ? "点击查看详情" : "Click now for details";
            } catch (Throwable th) {
                o.d(a, th.getMessage());
            }
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int iB = t.b(getContext(), 55.0f);
            int iB2 = t.b(getContext(), 33.0f);
            this.f11773c = new AnyThinkImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB);
            layoutParams.setMargins(iB2, iB2, 0, 0);
            this.f11773c.setLayoutParams(layoutParams);
            final int iA = i.a(getContext(), "anythink_icon_click_circle", i.f10645c);
            if (TextUtils.isEmpty(this.f11776f)) {
                this.f11773c.setImageResource(iA);
            } else {
                b.a(n.a().g()).a(this.f11775e, new c() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.1
                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        AnythinkBaitClickView.this.f11773c.setImageBitmap(bitmap);
                    }

                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(String str, String str2) {
                        AnythinkBaitClickView.this.f11773c.setImageResource(iA);
                    }
                });
            }
            int iB3 = t.b(getContext(), 108.0f);
            int iB4 = t.b(getContext(), 35.0f);
            int iB5 = t.b(getContext(), 43.0f);
            this.b = new AnyThinkImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iB3, iB3);
            layoutParams2.setMargins(iB4, iB5, 0, 0);
            this.b.setLayoutParams(layoutParams2);
            final int iA2 = i.a(getContext(), "anythink_icon_click_hand", i.f10645c);
            if (TextUtils.isEmpty(this.f11775e)) {
                this.b.setImageResource(iA2);
            } else {
                b.a(n.a().g()).a(this.f11775e, new c() { // from class: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.2
                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(Bitmap bitmap, String str) {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        AnythinkBaitClickView.this.b.setImageBitmap(bitmap);
                    }

                    @Override // com.anythink.expressad.foundation.g.d.c
                    public final void a(String str, String str2) {
                        AnythinkBaitClickView.this.b.setImageResource(iA2);
                    }
                });
            }
            relativeLayout.addView(this.f11773c);
            relativeLayout.addView(this.b);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.f11774d = new TextView(getContext());
            this.f11774d.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f11774d.setText(this.f11777g);
            this.f11774d.setTextColor(-1);
            this.f11774d.setGravity(14);
            linearLayout.addView(this.f11774d);
            addView(linearLayout);
        } catch (Throwable th2) {
            o.d(a, th2.getMessage());
        }
    }

    public AnythinkBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11775e = "";
        this.f11776f = "";
        this.f11777g = "Click now for details";
        this.f11778h = 1;
        this.f11779i = 1342177280;
    }

    @RequiresApi(api = 21)
    public AnythinkBaitClickView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f11775e = "";
        this.f11776f = "";
        this.f11777g = "Click now for details";
        this.f11778h = 1;
        this.f11779i = 1342177280;
    }
}
