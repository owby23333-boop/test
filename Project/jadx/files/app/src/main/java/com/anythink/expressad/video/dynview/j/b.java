package com.anythink.expressad.video.dynview.j;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.widget.AnyThinkFramLayout;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.video.dynview.widget.AnyThinkRelativeLayout;
import com.anythink.expressad.video.module.AnythinkClickCTAView;
import com.anythink.expressad.video.widget.SoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private String a = "anythink_top_play_bg";
    private String b = "anythink_top_finger_bg";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11666c = "anythink_bottom_play_bg";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11667d = "anythink_bottom_finger_bg";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11668e = "anythink_tv_count";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11669f = "anythink_sound_switch";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11670g = "anythink_top_control";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11671h = "anythink_tv_title";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11672i = "anythink_tv_desc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11673j = "anythink_tv_install";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11674k = "anythink_sv_starlevel";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11675l = "anythink_sv_heat_count_level";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f11676m = "anythink_tv_cta";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f11677n = "anythink_native_ec_controller";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f11678o = "anythink_reward_shape_choice_rl";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f11679p = "#FFFFFF";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f11680q = "#FF000000";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f11681r = "#40000000";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f11682s = "#CAEF79";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f11683t = "#2196F3";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f11684u = "#402196F3";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f11685v = "#8FC31F";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f11686w = "#03A9F4";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f11687x = false;

    private static void a() {
    }

    private void b(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f11670g));
        if (relativeLayout != null) {
            if (com.anythink.expressad.video.dynview.a.b.a == 0 && com.anythink.expressad.video.dynview.a.b.b == 0 && com.anythink.expressad.video.dynview.a.b.f11594c == 0 && com.anythink.expressad.video.dynview.a.b.f11595d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    private void d(View view, com.anythink.expressad.video.dynview.c cVar) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f11677n));
        if (relativeLayout != null) {
            if (cVar.e() == 1) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(layoutParams.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams.topMargin + com.anythink.expressad.video.dynview.a.b.f11594c, layoutParams.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams.bottomMargin + com.anythink.expressad.video.dynview.a.b.f11595d);
                relativeLayout.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.setMargins(layoutParams2.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams2.topMargin + com.anythink.expressad.video.dynview.a.b.f11594c, layoutParams2.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams2.bottomMargin + com.anythink.expressad.video.dynview.a.b.f11595d);
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }

    public final void a(View view) {
        ObjectAnimator objectAnimatorA;
        ObjectAnimator objectAnimatorB;
        ObjectAnimator objectAnimatorA2;
        if (view == null || !(view instanceof AnyThinkFramLayout)) {
            return;
        }
        AnyThinkFramLayout anyThinkFramLayout = (AnyThinkFramLayout) view;
        AnimatorSet animatorSet = new AnimatorSet();
        if (view.getContext() != null) {
            this.f11687x = false;
            ImageView imageView = (ImageView) view.findViewById(a(this.a));
            ImageView imageView2 = (ImageView) view.findViewById(a(this.b));
            ImageView imageView3 = (ImageView) view.findViewById(a(this.f11666c));
            ImageView imageView4 = (ImageView) view.findViewById(a(this.f11667d));
            ObjectAnimator objectAnimatorB2 = null;
            if (imageView != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimatorA = com.anythink.expressad.video.dynview.h.b.a(imageView);
            } else {
                objectAnimatorA = null;
            }
            if (imageView2 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimatorB = com.anythink.expressad.video.dynview.h.b.b(imageView2);
            } else {
                objectAnimatorB = null;
            }
            if (imageView3 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimatorA2 = com.anythink.expressad.video.dynview.h.b.a(imageView3);
            } else {
                objectAnimatorA2 = null;
            }
            if (imageView4 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimatorB2 = com.anythink.expressad.video.dynview.h.b.b(imageView4);
            }
            if (objectAnimatorA == null || objectAnimatorA2 == null || objectAnimatorB == null || objectAnimatorB2 == null) {
                return;
            }
            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2, objectAnimatorB, objectAnimatorB2);
            anyThinkFramLayout.setAnimatorSet(animatorSet);
        }
    }

    public final void c(View view, com.anythink.expressad.video.dynview.c cVar) {
        if (view == null || cVar == null) {
            return;
        }
        if (view.getContext() != null) {
            this.f11687x = false;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(a(this.f11674k));
            View viewFindViewById = view.findViewById(a(this.f11676m));
            if (linearLayout != null && (linearLayout instanceof AnyThinkLevelLayoutView)) {
                if (cVar.e() == 1) {
                    linearLayout.setOrientation(1);
                } else {
                    linearLayout.setOrientation(0);
                }
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f11677n));
            if (relativeLayout != null) {
                if (cVar.e() == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(layoutParams.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams.topMargin + com.anythink.expressad.video.dynview.a.b.f11594c, layoutParams.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams.bottomMargin + com.anythink.expressad.video.dynview.a.b.f11595d);
                    relativeLayout.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(layoutParams2.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams2.topMargin + com.anythink.expressad.video.dynview.a.b.f11594c, layoutParams2.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams2.bottomMargin + com.anythink.expressad.video.dynview.a.b.f11595d);
                    relativeLayout.setLayoutParams(layoutParams2);
                }
            }
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof TextView) {
                    TextView textView = (TextView) viewFindViewById;
                    textView.setTextColor(Color.parseColor(this.f11679p));
                    textView.setTextSize(25.0f);
                    String str = this.f11682s;
                    com.anythink.expressad.video.dynview.i.b.a.a(viewFindViewById, 1.0f, 5.0f, str, new String[]{this.f11685v, str}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
                AnimatorSet animatorSet = new AnimatorSet();
                new com.anythink.expressad.video.dynview.h.b();
                animatorSet.playTogether(com.anythink.expressad.video.dynview.h.b.c(viewFindViewById));
                if (view instanceof AnyThinkFramLayout) {
                    ((AnyThinkFramLayout) view).setAnimatorSet(animatorSet);
                }
                if (view instanceof AnyThinkRelativeLayout) {
                    ((AnyThinkRelativeLayout) view).setAnimatorSet(animatorSet);
                }
            }
        }
        new com.anythink.expressad.video.dynview.h.b();
        com.anythink.expressad.video.dynview.h.b.e(view);
    }

    public final void b(View view, com.anythink.expressad.video.dynview.c cVar) {
        Context context;
        int iB;
        if (view == null || cVar == null || (context = view.getContext()) == null) {
            return;
        }
        if (cVar.e() == 1) {
            view.setBackgroundDrawable(context.getResources().getDrawable(i.a(context, this.f11678o, i.f10645c)));
            TextView textView = (TextView) view.findViewById(a(this.f11671h));
            if (textView != null) {
                textView.setTextColor(Color.parseColor(this.f11680q));
            }
            TextView textView2 = (TextView) view.findViewById(a(this.f11672i));
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(this.f11680q));
            }
            iB = t.b(context, 2.0f);
        } else {
            iB = t.b(context, 10.0f);
            view.getBackground().setAlpha(100);
        }
        int iB2 = t.b(context, 8.0f);
        View viewFindViewById = view.findViewById(a(this.f11673j));
        if (viewFindViewById != null) {
            if (cVar.f() != null && (cVar.f() instanceof AnythinkClickCTAView)) {
                new com.anythink.expressad.video.dynview.h.b();
                ((AnythinkClickCTAView) cVar.f()).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(viewFindViewById));
            }
            if (viewFindViewById instanceof TextView) {
                TextView textView3 = (TextView) viewFindViewById;
                textView3.setTextColor(Color.parseColor(this.f11679p));
                textView3.setTextSize(15.0f);
                String str = this.f11682s;
                com.anythink.expressad.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str, new String[]{this.f11685v, str}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (view.getLayoutParams() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(iB, iB, iB, iB2);
            layoutParams.height = t.b(context, 60.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r11, com.anythink.expressad.video.dynview.c r12) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.dynview.j.b.a(android.view.View, com.anythink.expressad.video.dynview.c):void");
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private void a(Context context, View view, com.anythink.expressad.video.dynview.c cVar) {
        SoundImageView soundImageView = (SoundImageView) view.findViewById(a(this.f11669f));
        int iB = t.b(context, 60.0f);
        int iB2 = t.b(context, 10.0f);
        if (soundImageView != null) {
            cVar.e();
            ((FrameLayout.LayoutParams) soundImageView.getLayoutParams()).setMargins(iB2, 0, 0, iB);
        }
    }

    private static int a(String str) {
        return i.a(n.a().g(), str, "id");
    }
}
