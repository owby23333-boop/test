package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.splash.gz;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.qd;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class a extends dl implements View.OnClickListener {
    private ImageView e;
    private FrameLayout fo;
    private TextView fv;
    protected com.bytedance.sdk.openadsdk.ls.dl.g.e gc;
    private View gz;
    private TextView i;
    private iq iq;
    private TextView js;
    private ImageView kb;
    private View ls;
    private RelativeLayout m;
    private RelativeLayout p;
    private TextView pf;
    private TextView q;
    private RelativeLayout tb;
    private RelativeLayout uy;
    private TextView v;
    private TextView wp;
    private View.OnClickListener zw;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public String z() {
        return "splash_card_show";
    }

    a() {
    }

    private View z(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.m = relativeLayout2;
        relativeLayout2.setId(2114387562);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), -2);
        layoutParams2.addRule(13);
        this.m.setClipChildren(false);
        this.m.setVisibility(4);
        this.m.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.m);
        ImageView imageView = new ImageView(context);
        this.gz = imageView;
        imageView.setId(2114387561);
        this.gz.setLayoutParams(new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 280.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 370.0f, resources.getDisplayMetrics())));
        this.m.addView(this.gz);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(2114387560);
        relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 130.0f, resources.getDisplayMetrics())));
        this.m.addView(relativeLayout3);
        TextView textView = new TextView(context);
        this.v = textView;
        textView.setId(2114387559);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(10);
        layoutParams3.addRule(21);
        layoutParams3.topMargin = oq.dl(context, 8.0f);
        layoutParams3.bottomMargin = oq.dl(context, 10.0f);
        layoutParams3.rightMargin = oq.dl(context, 4.0f);
        this.v.setLayoutParams(layoutParams3);
        tb.z(this.z, "tt_splash_card_feedback_bg", this.v);
        this.v.setGravity(17);
        this.v.setText(tb.z(this.z, "tt_feedback"));
        this.v.setTextColor(Color.parseColor("#99FFFFFF"));
        this.v.setTextSize(2, 12.0f);
        relativeLayout3.addView(this.v);
        RelativeLayout relativeLayout4 = new RelativeLayout(context);
        this.uy = relativeLayout4;
        relativeLayout4.setId(2114387558);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 240.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(3, 2114387560);
        this.uy.setLayoutParams(layoutParams4);
        this.uy.setBackgroundColor(Color.parseColor("#D9FFFFFF"));
        this.m.addView(this.uy);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fo = frameLayout;
        frameLayout.setId(2114387557);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 84.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        layoutParams5.topMargin = oq.dl(context, -42.0f);
        this.fo.setElevation(oq.dl(context, 3.0f));
        this.fo.setLayoutParams(layoutParams5);
        this.uy.addView(this.fo);
        ImageView imageView2 = new ImageView(context);
        this.kb = imageView2;
        imageView2.setId(2114387556);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(oq.dl(context, 2.0f), oq.dl(context, 2.0f), oq.dl(context, 2.0f), oq.dl(context, 2.0f));
        this.kb.setLayoutParams(layoutParams6);
        this.fo.addView(this.kb);
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int iDl = oq.dl(context, 6.0f);
        gradientDrawable.setCornerRadius(iDl);
        gradientDrawable.setStroke(iDl / 3, -1);
        view.setBackground(gradientDrawable);
        this.fo.addView(view);
        TextView textView2 = new TextView(context);
        this.wp = textView2;
        textView2.setId(2114387555);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(3, 2114387557);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = oq.dl(context, 16.0f);
        this.wp.setLayoutParams(layoutParams7);
        this.wp.setEllipsize(TextUtils.TruncateAt.END);
        this.wp.setMaxLines(1);
        this.wp.setTextColor(Color.parseColor("#161823"));
        this.wp.setTextSize(2, 20.0f);
        this.uy.addView(this.wp);
        TextView textView3 = new TextView(context);
        this.i = textView3;
        textView3.setId(2114387554);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(3, 2114387555);
        layoutParams8.addRule(14);
        layoutParams8.setMarginStart(oq.dl(context, 42.0f));
        layoutParams8.setMarginEnd(oq.dl(context, 42.0f));
        layoutParams8.topMargin = oq.dl(context, 8.0f);
        this.i.setLayoutParams(layoutParams8);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setGravity(1);
        this.i.setMaxLines(2);
        this.i.setTextColor(Color.parseColor("#90161823"));
        this.i.setTextSize(2, 14.0f);
        this.uy.addView(this.i);
        RelativeLayout relativeLayout5 = new RelativeLayout(context);
        this.p = relativeLayout5;
        relativeLayout5.setId(2114387553);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams9.addRule(3, 2114387554);
        layoutParams9.addRule(14);
        layoutParams9.topMargin = oq.dl(context, 36.0f);
        this.p.setLayoutParams(layoutParams9);
        tb.z(this.z, "tt_splash_card_btn_bg", this.p);
        this.p.setGravity(17);
        this.uy.addView(this.p);
        TextView textView4 = new TextView(context);
        this.fv = textView4;
        textView4.setId(2114387552);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(14);
        this.fv.setLayoutParams(layoutParams10);
        this.fv.setEllipsize(TextUtils.TruncateAt.END);
        this.fv.setMaxLines(1);
        this.fv.setTextColor(Color.parseColor("#FFFFFF"));
        this.fv.setTextSize(2, 14.0f);
        this.fv.setTypeface(Typeface.defaultFromStyle(1));
        this.p.addView(this.fv);
        TextView textView5 = new TextView(context);
        this.js = textView5;
        textView5.setId(2114387551);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(3, 2114387552);
        layoutParams11.addRule(14);
        this.js.setLayoutParams(layoutParams11);
        this.js.setEllipsize(TextUtils.TruncateAt.END);
        this.js.setMaxLines(1);
        this.js.setTextColor(Color.parseColor("#AAFFFFFF"));
        this.js.setTextSize(2, 11.0f);
        this.p.addView(this.js);
        RelativeLayout relativeLayout6 = new RelativeLayout(context);
        this.tb = relativeLayout6;
        relativeLayout6.setId(2114387550);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 192.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
        layoutParams12.addRule(3, 2114387554);
        layoutParams12.addRule(14);
        layoutParams12.topMargin = oq.dl(context, 36.0f);
        this.tb.setLayoutParams(layoutParams12);
        tb.z(this.z, "tt_splash_card_btn_bg", this.tb);
        this.tb.setVisibility(8);
        this.uy.addView(this.tb);
        RelativeLayout relativeLayout7 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(13);
        relativeLayout7.setLayoutParams(layoutParams13);
        this.tb.addView(relativeLayout7);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(2114387549);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 23.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics()));
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        imageView3.setLayoutParams(layoutParams14);
        tb.z(this.z, "tt_splash_card_shake", (View) imageView3);
        relativeLayout7.addView(imageView3);
        TextView textView6 = new TextView(context);
        this.q = textView6;
        textView6.setId(2114387548);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.leftMargin = oq.dl(context, 8.0f);
        layoutParams15.addRule(1, 2114387549);
        layoutParams15.addRule(15);
        this.q.setLayoutParams(layoutParams15);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTypeface(Typeface.defaultFromStyle(1));
        this.q.setMaxLines(1);
        this.q.setTextColor(Color.parseColor("#FFFFFF"));
        this.q.setTextSize(2, 13.0f);
        relativeLayout7.addView(this.q);
        TextView textView7 = new TextView(context);
        this.pf = textView7;
        textView7.setId(2114387546);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.addRule(20);
        layoutParams16.addRule(12);
        layoutParams16.setMarginStart(oq.dl(context, 8.0f));
        layoutParams16.bottomMargin = oq.dl(context, 8.0f);
        this.pf.setLayoutParams(layoutParams16);
        tb.z(this.z, "tt_ad_logo_new", this.pf);
        this.uy.addView(this.pf);
        ImageView imageView4 = new ImageView(context);
        this.ls = imageView4;
        imageView4.setId(2114387547);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        layoutParams17.addRule(3, 2114387562);
        layoutParams17.addRule(14);
        layoutParams17.topMargin = oq.dl(context, 48.0f);
        this.ls.setLayoutParams(layoutParams17);
        tb.z(this.z, "tt_splash_card_close", this.ls);
        relativeLayout.addView(this.ls);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        this.e = tTRoundRectImageView;
        tTRoundRectImageView.setId(2114387545);
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(this.e);
        return relativeLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public void z(Context context, ViewGroup viewGroup, na naVar) {
        super.z(context, viewGroup, naVar);
        View viewZ = z(this.z);
        if (viewZ == null) {
            return;
        }
        this.g.addView(viewZ);
        this.m.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), oq.dl(zw.getContext(), 18.0f));
            }
        });
        this.m.setClipToOutline(true);
        this.e.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), oq.dl(zw.getContext(), 28.0f));
            }
        });
        this.e.setClipToOutline(true);
        oq.z(this.pf, this.dl);
        List<gk> listJz = this.dl.jz();
        if (listJz != null && listJz.size() > 0) {
            com.bytedance.sdk.openadsdk.gz.g.z(listJz.get(0)).type(2).config(Bitmap.Config.ARGB_8888).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.3
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap result = lsVar.getResult();
                    if (result == null) {
                        return;
                    }
                    try {
                        if (result.getConfig() == Bitmap.Config.RGB_565) {
                            result = result.copy(Bitmap.Config.ARGB_8888, true);
                        }
                    } catch (Throwable unused) {
                    }
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(a.this.z, result, 10);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(a.this.z.getResources(), bitmapZ);
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.gz != null) {
                                a.this.gz.setBackground(bitmapDrawable);
                            }
                            if (a.this.e != null) {
                                a.this.e.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
        com.bytedance.sdk.openadsdk.gz.g.z(this.dl.kp()).to(this.kb);
        this.wp.setText(dl());
        this.i.setText(a());
        this.v.setVisibility(this.dl.sz() ? 0 : 8);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gc();
            }
        });
        this.fv.setText(qd.a(this.dl));
        this.js.setText(qd.dl(this.dl));
        z(this.dl);
    }

    private void z(na naVar) {
        if (naVar == null || this.m == null || qd.gc(naVar) != 1) {
            return;
        }
        oq.z((View) this.tb, 0);
        oq.z((View) this.p, 8);
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(qd.a(naVar));
        }
        if (this.iq == null) {
            this.iq = new iq(zw.getContext(), 1, uy.ls().gc());
        }
        this.iq.g(this.dl.hs());
        this.iq.z(this.dl.kk());
        this.iq.g(this.dl.jb());
        this.iq.m(this.dl.s());
        this.iq.z(naVar.fn());
        this.iq.dl(naVar.eb());
        this.iq.gc(naVar.yw());
        this.iq.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.5
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i) {
                if (a.this.zw == null || !a.this.m.isShown() || i != 1 || a.this.zw == null) {
                    return;
                }
                if (a.this.zw instanceof com.bytedance.sdk.openadsdk.core.g.z) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) ((com.bytedance.sdk.openadsdk.core.g.z) a.this.zw).z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z();
                }
                a.this.zw.onClick(a.this.m);
            }
        });
        this.iq.z(this.dl != null ? this.dl.gc() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public void z(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        if (zVar == null) {
            return;
        }
        this.zw = zVar;
        if (qd.e(this.dl)) {
            this.m.setOnClickListener(this);
            this.gz.setOnClickListener(this);
            this.kb.setOnClickListener(this);
            this.wp.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.uy.setOnClickListener(this);
        }
        this.p.setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public void z(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, gz.z zVar) {
        super.z(aVar, zVar);
        this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.m.isAttachedToWindow()) {
                    a.this.g.postDelayed(a.this.m(), 20L);
                } else {
                    a.this.m().run();
                }
            }
        });
        if (this.f998a != null) {
            this.ls.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash_card_close_type", 1);
                        com.bytedance.sdk.openadsdk.core.i.a.g(a.this.dl, "splash_ad", "splash_card_close", jSONObject);
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                    a.this.f998a.g();
                }
            });
        }
        qd.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable m() {
        return new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e.getWidth() == 0 || a.this.e.getHeight() == 0) {
                    return;
                }
                a.this.e.animate().scaleX(a.this.m.getWidth() / a.this.e.getWidth()).scaleY(a.this.m.getHeight() / a.this.e.getHeight()).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(500L).setListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.8.1
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
                        a.this.e.setVisibility(8);
                        a.this.m.setVisibility(0);
                        a.this.fo.setScaleX(0.0f);
                        a.this.fo.setScaleY(0.0f);
                        a.this.fo.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        a.this.wp.setScaleX(0.0f);
                        a.this.wp.setScaleY(0.0f);
                        a.this.wp.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        a.this.i.setScaleX(0.0f);
                        a.this.i.setScaleY(0.0f);
                        a.this.i.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        a.this.p.setScaleX(0.0f);
                        a.this.p.setScaleY(0.0f);
                        a.this.p.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).start();
                        if (a.this.f998a != null) {
                            a.this.f998a.z(qd.m(a.this.dl));
                        }
                    }
                });
            }
        };
    }

    protected String dl() {
        if (this.dl == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.dl.hy())) {
            return (this.dl.c() == null || TextUtils.isEmpty(this.dl.c().dl())) ? "" : this.dl.c().dl();
        }
        return this.dl.hy();
    }

    protected String a() {
        return (this.dl == null || TextUtils.isEmpty(this.dl.li())) ? "" : this.dl.li();
    }

    public void gc() {
        if (this.f998a == null) {
            return;
        }
        if (this.gc == null) {
            this.gc = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.f998a.getActivity(), this.dl.ct(), "splash_ad", true);
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.f998a.getActivity(), this.dl, (com.bytedance.sdk.openadsdk.core.dislike.ui.z) this.gc);
        }
        this.gc.z("splash_card");
        this.gc.z();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view.getId() == 2114387553) {
            i = 0;
        } else if (view.getId() == 2114387561) {
            i = 1;
        } else if (view.getId() == 2114387556) {
            i = 2;
        } else if (view.getId() == 2114387555) {
            i = 3;
        } else {
            i = view.getId() == 2114387554 ? 4 : 5;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_card_click_type", i);
            com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, "splash_ad", "splash_card_click", jSONObject);
        } catch (JSONException e) {
            wp.z(e);
        }
        View.OnClickListener onClickListener = this.zw;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public void g() {
        if (qd.gz(this.dl)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 2);
                com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, "splash_ad", "splash_card_close", jSONObject);
                if (this.f998a != null) {
                    this.f998a.g();
                }
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl
    public void z(boolean z) {
        super.z(z);
        if (this.f998a == null) {
            return;
        }
        if (z) {
            this.f998a.z(-1L);
        } else {
            this.f998a.z();
        }
        iq iqVar = this.iq;
        if (iqVar != null) {
            if (z) {
                iqVar.z(this.dl != null ? this.dl.gc() : 0);
            } else {
                iqVar.g(this.dl != null ? this.dl.gc() : 0);
            }
        }
    }
}
