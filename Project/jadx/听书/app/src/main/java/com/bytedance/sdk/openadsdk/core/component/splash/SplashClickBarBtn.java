package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.b;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBarBtn extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f990a;
    private TextView dl;
    private RelativeLayout e;
    private SplashClickBarArrow fo;
    private final ValueAnimator fv;
    private b g;
    private LottieAnimationView gc;
    private int gk;
    private LinearLayout gz;
    private JSONObject h;
    private JSONObject hh;
    private Path i;
    private float io;
    private iq iq;
    private LinearGradient js;
    private RockView kb;
    private JSONObject l;
    private na lq;
    private final AnimatorSet ls;
    private RelativeLayout m;
    private final ValueAnimator p;
    private Paint pf;
    private boolean q;
    private float sy;
    private int[] tb;
    private float uf;
    private SlideUpView uy;
    private Rect v;
    private AnimatorSet wp;
    private int x;
    private GradientDrawable z;
    private com.bytedance.sdk.openadsdk.core.g.z zw;

    public SplashClickBarBtn(Context context, na naVar) {
        super(context);
        this.g = new b();
        this.ls = new AnimatorSet();
        this.p = new ValueAnimator();
        this.fv = new ValueAnimator();
        this.tb = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.q = false;
        this.io = 13.0f;
        this.sy = 50.0f;
        this.lq = naVar;
        gc();
    }

    private View z(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.m = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.m.setId(2114387576);
        this.m.setClipChildren(false);
        layoutParams2.addRule(13);
        this.m.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.m);
        this.kb = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.kb.setId(2114387575);
        layoutParams3.addRule(14);
        this.kb.setLayoutParams(layoutParams3);
        oq.z((View) this.kb, 8);
        this.m.addView(this.kb);
        this.e = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.e.setId(2114387574);
        this.e.setClipChildren(false);
        layoutParams4.addRule(13);
        this.e.setGravity(17);
        this.e.setLayoutParams(layoutParams4);
        this.m.addView(this.e);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.e.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.gc = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.gc.setAnimation("lottie_json/twist_multi_angle.json");
        this.gc.setImageAssetsFolder("images/");
        this.gc.z(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = oq.dl(context, 4.0f);
        layoutParams6.gravity = 17;
        this.gc.setLayoutParams(layoutParams6);
        linearLayout.addView(this.gc);
        oq.z((View) this.gc, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.uy = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = oq.dl(context, -140.0f);
        this.uy.setLayoutParams(layoutParams7);
        linearLayout.addView(this.uy);
        oq.z((View) this.uy, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.gz = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.gz.setGravity(17);
        this.gz.setOrientation(1);
        this.gz.setLayoutParams(layoutParams8);
        this.e.addView(this.gz);
        TextView textView = new TextView(context);
        this.f990a = textView;
        textView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.f990a.setSingleLine();
        this.f990a.setText(tb.z(context, "tt_splash_click_bar_text"));
        this.f990a.setTextColor(-1);
        this.f990a.setTextSize(20.0f);
        this.f990a.setTypeface(Typeface.defaultFromStyle(1));
        this.f990a.setLayoutParams(layoutParams9);
        this.gz.addView(this.f990a);
        oq.z((View) this.f990a, 8);
        TextView textView2 = new TextView(context);
        this.dl = textView2;
        textView2.setId(2114387567);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.dl.setShadowLayer(2.0f, 0.0f, 0.5f, tb.uy(context, "tt_splash_click_bar_text_shadow"));
        this.dl.setSingleLine();
        this.dl.setText(tb.z(context, "tt_splash_click_bar_text"));
        this.dl.setTextColor(-1);
        this.dl.setTextSize(15.0f);
        this.dl.setTypeface(Typeface.defaultFromStyle(1));
        this.dl.setLayoutParams(layoutParams10);
        this.gz.addView(this.dl);
        oq.z((View) this.dl, 8);
        return relativeLayout;
    }

    private void gc() {
        View viewZ = z(getContext());
        if (viewZ == null) {
            return;
        }
        addView(viewZ);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.fo = splashClickBarArrow;
        this.m.addView(splashClickBarArrow);
        this.fo.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fo.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.e.getId());
        this.z = z(Color.parseColor("#57000000"));
        this.i = new Path();
        Paint paint = new Paint();
        this.pf = paint;
        paint.isAntiAlias();
    }

    private GradientDrawable z(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(oq.dl(zw.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void z(b bVar) {
        if (bVar == null) {
            return;
        }
        this.g = bVar;
        if (bVar.fo() == 4) {
            this.kb.z(this.g);
            return;
        }
        TextView textView = this.dl;
        if (textView != null) {
            textView.setVisibility(0);
            this.dl.setText(TextUtils.isEmpty(this.g.g()) ? "点击跳转至详情页或第三方应用" : this.g.g());
            if (this.g.wp() != null) {
                this.dl.setTextSize(2, this.g.wp().g());
            }
        }
        if (this.f990a != null && this.g.i() != null) {
            this.f990a.setTextSize(2, this.g.i().g());
        }
        this.z.setColor(Color.parseColor("#57000000"));
        this.fo.z(this.g.fo());
        int iFo = this.g.fo();
        if (iFo == 1 || iFo == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.wp = animatorSet;
            animatorSet.playTogether(getAnimator(), this.fo.getAnimator());
        } else if (iFo == 3) {
            TextView textView2 = this.f990a;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.f990a.setText(this.g.kb());
            }
            TextView textView3 = this.dl;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.z = z(Color.parseColor(this.g.uy()));
        } else {
            if (iFo == 4) {
                return;
            }
            if (iFo == 5) {
                SlideUpView slideUpView = this.uy;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.gz;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.gz.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.f990a;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.f990a.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.g.kb())) {
                        this.f990a.setText("向上滑动");
                    } else {
                        this.f990a.setText(this.g.kb());
                    }
                }
                TextView textView5 = this.dl;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.g.g()) ? "滑动查看详情" : this.g.g());
                    this.dl.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (iFo == 7) {
                TextView textView6 = this.f990a;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.f990a.setText(this.g.kb());
                    this.f990a.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.dl;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.dl.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.gc;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
            this.z.setStroke(0, -16777216);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.wp = animatorSet2;
            animatorSet2.playTogether(getAnimator(), this.fo.getAnimator());
            try {
                setBackgroundColor(Color.parseColor(this.g.uy()));
            } catch (Throwable unused) {
                setBackgroundColor(Color.parseColor("#008DEA"));
            }
        }
        setBackgroundDrawable(this.z);
    }

    private void m() {
        if (this.q) {
            return;
        }
        this.q = true;
        int iFo = this.g.fo();
        if (iFo == 1 || iFo == 2) {
            gz();
            e();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.z.setColor(i);
        setBackgroundDrawable(this.z);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m();
        super.onDraw(canvas);
        if (this.p.isRunning()) {
            this.pf.setShader(this.js);
            canvas.drawRoundRect(new RectF(this.v), oq.dl(getContext(), 50.0f), oq.dl(getContext(), 50.0f), this.pf);
        }
    }

    private void e() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.g.uy());
        this.z.setColor(color);
        this.fv.setIntValues(color, color2);
        this.fv.setEvaluator(new ArgbEvaluator());
        this.fv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.z.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.z);
            }
        });
        this.fv.setDuration(300L);
        this.fv.setStartDelay(800L);
        this.fv.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.ls.playTogether(this.fv);
    }

    private void gz() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.i.moveTo(point.x, point.y);
        this.i.lineTo(point2.x, point2.y);
        this.i.lineTo(point3.x, point3.y);
        this.i.lineTo(point4.x, point4.y);
        this.i.close();
        this.v = getBackground().getBounds();
        final int iDl = oq.dl(getContext(), 36.0f);
        final int iDl2 = oq.dl(getContext(), 45.0f);
        this.p.setIntValues(point.x - iDl, point2.x + iDl);
        this.p.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.p.setDuration(1600L);
        this.p.setStartDelay(1300L);
        this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.js = new LinearGradient(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0.0f, r11 + iDl, iDl2, SplashClickBarBtn.this.tb, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.ls.playTogether(this.p);
    }

    public Animator getAnimator() {
        return this.ls;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        iq iqVar = this.iq;
        if (iqVar != null) {
            if (z) {
                na naVar = this.lq;
                iqVar.z(naVar != null ? naVar.gc() : 0);
            } else {
                na naVar2 = this.lq;
                iqVar.g(naVar2 != null ? naVar2.gc() : 0);
            }
        }
    }

    public iq getShakeUtils() {
        return this.iq;
    }

    public void setShakeValue(float f) {
        this.io = f;
    }

    public void setDeepShakeValue(float f) {
        this.uf = f;
    }

    public void setWriggleValue(float f) {
        this.sy = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.hh = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.gk = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.x = i;
    }

    private void fo() {
        if (this.g != null && isShown()) {
            if (this.g.fo() == 4 || this.g.fo() == 7) {
                if (this.iq == null) {
                    if (this.g.fo() == 4) {
                        this.iq = new iq(zw.getContext(), 1, uy.ls().gc());
                    } else if (this.g.fo() == 7) {
                        this.iq = new iq(zw.getContext(), 2, uy.ls().gc());
                    }
                }
                this.iq.z(this.io);
                this.iq.dl(this.uf);
                this.iq.g(this.sy);
                this.iq.z(this.hh);
                this.iq.dl(this.l);
                this.iq.g(this.h);
                this.iq.gc(this.gk);
                this.iq.m(this.x);
                this.iq.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.iq.z
                    public void z(int i) {
                        if (SplashClickBarBtn.this.zw == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.iq.z() && SplashClickBarBtn.this.lq != null) {
                            com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.f1219a = true;
                        }
                        if (i != 1) {
                            if (i == 2 && SplashClickBarBtn.this.g.fo() == 7) {
                                ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) SplashClickBarBtn.this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).g();
                                SplashClickBarBtn.this.zw.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (SplashClickBarBtn.this.g.fo() == 4) {
                            ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) SplashClickBarBtn.this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z();
                            SplashClickBarBtn.this.zw.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                iq iqVar = this.iq;
                na naVar = this.lq;
                iqVar.z(naVar != null ? naVar.gc() : 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fo();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.z();
            }
        });
    }

    public void z() {
        AnimatorSet animatorSet = this.wp;
        if (animatorSet != null) {
            animatorSet.start();
        }
        g();
        dl();
        a();
        uy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iq iqVar = this.iq;
        if (iqVar != null) {
            na naVar = this.lq;
            iqVar.g(naVar != null ? naVar.gc() : 0);
        }
        AnimatorSet animatorSet = this.wp;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.ls;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.uy;
        if (slideUpView != null) {
            slideUpView.g();
        }
        LottieAnimationView lottieAnimationView = this.gc;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
        }
    }

    public void g() {
        if (this.g.fo() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void dl() {
        RockView rockView;
        if (this.g.fo() == 4 && (rockView = this.kb) != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.kb != null) {
                        SplashClickBarBtn.this.kb.z();
                    }
                }
            }, 500L);
        }
    }

    public void a() {
        if (this.g.fo() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.gc != null) {
                        SplashClickBarBtn.this.gc.z();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    private void uy() {
        b bVar = this.g;
        if (bVar == null || bVar.fo() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.uy == null) {
                    return;
                }
                SplashClickBarBtn.this.uy.z();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.uy.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
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
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }
                });
            }
        }, 500L);
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.zw = zVar;
        if (this.g.fo() == 4 || this.g.fo() == 7 || this.g.fo() == 5 || zVar == null) {
            return;
        }
        zVar.z(this);
        setOnClickListener(zVar);
        setOnTouchListener(zVar);
        setId(2114387633);
    }
}
