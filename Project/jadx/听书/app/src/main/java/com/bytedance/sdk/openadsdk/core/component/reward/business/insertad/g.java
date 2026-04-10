package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.x;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    private dl dl;
    private int e;
    private int fo;
    private LinearLayout fv;
    private final z.InterfaceC0154z g;
    private TextView gc;
    private int gz;
    private TextView i;
    private LinearLayout js;
    private int kb;
    private boolean ls;
    private int m;
    private SmallSlideView p;
    private LinearLayout pf;
    private TranslateAnimation tb;
    private int uy;
    private int v;
    private TextView wp;
    protected final AtomicBoolean z = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f937a = true;
    private boolean q = false;
    private boolean iq = false;
    private boolean zw = false;

    public g(z.InterfaceC0154z interfaceC0154z) {
        this.g = interfaceC0154z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        r2.remove(r0);
        r3.eo(r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        r1 = r3;
     */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl r6, int r7, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a r8) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r0 = r5.g
            com.bytedance.sdk.openadsdk.core.iq.na r0 = r0.dl()
            r1 = 0
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L37
            java.lang.String r0 = r0.lo()     // Catch: org.json.JSONException -> L37
            r2.<init>(r0)     // Catch: org.json.JSONException -> L37
            r0 = 0
        L11:
            int r3 = r2.length()     // Catch: org.json.JSONException -> L37
            if (r0 >= r3) goto L3b
            org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch: org.json.JSONException -> L37
            com.bytedance.sdk.openadsdk.core.iq.na r3 = com.bytedance.sdk.openadsdk.core.z.z(r3)     // Catch: org.json.JSONException -> L37
            boolean r4 = r5.z(r3, r7)     // Catch: org.json.JSONException -> L37
            if (r4 == 0) goto L34
            r2.remove(r0)     // Catch: org.json.JSONException -> L31
            java.lang.String r0 = r2.toString()     // Catch: org.json.JSONException -> L31
            r3.eo(r0)     // Catch: org.json.JSONException -> L31
            r1 = r3
            goto L3b
        L31:
            r0 = move-exception
            r1 = r3
            goto L38
        L34:
            int r0 = r0 + 1
            goto L11
        L37:
            r0 = move-exception
        L38:
            com.bytedance.sdk.component.utils.wp.z(r0)
        L3b:
            if (r1 == 0) goto Lc2
            r0 = 1
            if (r7 != r0) goto L52
            if (r8 == 0) goto L52
            boolean r2 = r8.z
            if (r2 == 0) goto L52
            boolean r6 = r5.iq
            if (r6 != 0) goto L51
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r6 = r5.g
            int r8 = r8.g
            r6.z(r7, r8)
        L51:
            return
        L52:
            r2 = 2
            if (r7 != r2) goto L67
            if (r8 == 0) goto L67
            boolean r2 = r8.z
            if (r2 == 0) goto L67
            boolean r6 = r5.zw
            if (r6 != 0) goto L66
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r6 = r5.g
            int r8 = r8.g
            r6.z(r7, r8)
        L66:
            return
        L67:
            r2 = 3
            if (r7 != r2) goto L7c
            if (r8 == 0) goto L7c
            boolean r2 = r8.z
            if (r2 == 0) goto L7c
            boolean r6 = r5.q
            if (r6 != 0) goto L7b
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r6 = r5.g
            int r8 = r8.g
            r6.z(r7, r8)
        L7b:
            return
        L7c:
            com.bytedance.sdk.openadsdk.core.component.reward.z.z.z r7 = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z()
            java.lang.String r8 = ""
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.un.eo.z(r1, r8)
            com.bytedance.sdk.openadsdk.ls.dl.dl.g r7 = r7.z(r8)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r8 = r5.g
            boolean r8 = r8.g()
            if (r8 == 0) goto La8
            com.bytedance.sdk.openadsdk.core.component.reward.dl r8 = new com.bytedance.sdk.openadsdk.core.component.reward.dl
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            r8.<init>(r2, r1, r7)
            r8.z(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r6 = r5.g
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.z(r6)
            goto Lbd
        La8:
            com.bytedance.sdk.openadsdk.core.component.reward.g r8 = new com.bytedance.sdk.openadsdk.core.component.reward.g
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            r8.<init>(r2, r1, r7)
            r8.z(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z$z r6 = r5.g
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.z(r6)
        Lbd:
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.z
            r6.set(r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.z(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl, int, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.a):void");
    }

    private boolean z(na naVar, int i) {
        if (i != 1) {
            return i != 2 ? i == 3 && x.g(naVar, true) : x.z(naVar, true);
        }
        return x.z(this.g.g(), naVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void z(dl dlVar) {
        this.dl = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public int z() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return Math.max(0, dlVar.g() - this.dl.dl());
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void z(boolean z) {
        this.f937a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public int g() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public int z(int i, boolean z) {
        if (!this.f937a || z(i)) {
            return 0;
        }
        if (i == 1) {
            if (x.z(this.g.dl()) != 1) {
                return 0;
            }
            if (!z) {
                if (!x.z(this.g.g(), a() ? this.g.a() : na.g(this.g.dl()), this.g.gc())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (x.g(this.g.dl()) != 1) {
                return 0;
            }
            if (!z && this.g.e() && x.i() == 0) {
                return 0;
            }
            if (x.i() == 1) {
                if (this.ls) {
                    return 0;
                }
                if (this.g.fo()) {
                    if (this.g.gz()) {
                        return i;
                    }
                    return 0;
                }
            }
            if (z || x.z(this.g.gc(), this.g.dl(), this.g.g())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || x.dl(this.g.dl()) != 1 || this.g.gz()) {
            return 0;
        }
        if (z || x.z(this.g.gc(), this.g.dl())) {
            return i;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public boolean z(int i) {
        if (this.g.fo()) {
            return gb.hh(this.g.dl()) == com.bytedance.sdk.openadsdk.core.gz.a.e || (gb.hh(this.g.dl()) == com.bytedance.sdk.openadsdk.core.gz.a.gz && !this.g.gz());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void z(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.gc == null) {
            this.gc = oq.p(this.g.getActivity());
        }
        if (this.gc.getParent() != null) {
            ((ViewGroup) this.gc.getParent()).removeView(this.gc);
        }
        this.m = x.gz() * 2;
        frameLayout.addView(this.gc);
        gz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void z(int i, int i2, int i3) {
        if (i == -1 || i == 1 || i == 2) {
            g(i, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            uy();
        }
    }

    private void uy() {
        this.e = this.g.gc() + (x.fo() / 1000);
        this.fv = new LinearLayout(this.g.getActivity());
        int iDl = oq.dl(this.g.getActivity(), 10.0f);
        this.fv.setPadding(iDl, iDl, iDl, iDl);
        this.fv.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(this.g.getActivity(), 12.0f));
        this.fv.setBackground(gradientDrawable);
        this.p = new SmallSlideView(this.g.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oq.dl(this.g.getActivity(), 80.0f), oq.dl(this.g.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.fv.addView(this.p, layoutParams);
        TextView textView = new TextView(this.g.getActivity());
        textView.setText(x.uy() > 0 ? "上滑继续观看\n提前" + x.uy() + "秒领奖" : "上滑继续观看\n才能领奖哦");
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.fv.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(oq.dl(this.g.getActivity(), 160.0f), oq.dl(this.g.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.g.z().addView(this.fv, layoutParams2);
        this.js = new LinearLayout(this.g.getActivity());
        ImageView imageView = new ImageView(this.g.getActivity());
        tb.z((Context) this.g.getActivity(), "tt_ic_back_light", imageView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = oq.dl(this.g.getActivity(), 10.0f);
        layoutParams3.bottomMargin = oq.dl(this.g.getActivity(), 10.0f);
        this.js.addView(imageView, layoutParams3);
        this.g.z().getSceneFrameContainer().setClipChildren(false);
        this.js.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.g.z().getSceneFrameContainer().addView(this.js, layoutParams4);
        this.q = true;
        this.js.post(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.g.z().z(new RewardFullBaseLayout.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.1.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout.z
                public void z() {
                    a aVar = new a();
                    aVar.z = false;
                    aVar.dl = true;
                    aVar.f934a = true;
                    g.this.g.z().z();
                    g.this.g.getActivity().z(3, aVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) g.this.js.getLayoutParams();
            layoutParams.bottomMargin = -g.this.js.getMeasuredHeight();
            g.this.js.setLayoutParams(layoutParams);
            g.this.js.setVisibility(0);
            g.this.tb = new TranslateAnimation(0.0f, 0.0f, 0.0f, -g.this.js.getMeasuredHeight());
            g.this.tb.setDuration(300L);
            g.this.tb.setRepeatCount(3);
            g.this.tb.setRepeatMode(2);
            g.this.tb.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    g.this.p.z();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (g.this.q) {
                        g.this.js.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (g.this.q && g.this.tb != null) {
                                    g.this.g.z().getSceneFrameContainer().startAnimation(g.this.tb);
                                }
                            }
                        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    }
                }
            });
            if (g.this.tb != null) {
                g.this.g.z().getSceneFrameContainer().startAnimation(g.this.tb);
            }
        }
    }

    private void g(final int i, int i2, int i3) {
        if (i == 1) {
            this.gz = i2;
        } else if (i == 2) {
            i2++;
            this.fo = i2;
        } else if (i == -1) {
            this.uy = i2;
            if (i3 > 0) {
                this.kb = i3;
                return;
            }
            this.kb = 0;
        } else {
            i2 = 0;
        }
        LinearLayout linearLayout = this.pf;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.g.getActivity());
            this.pf = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.pf.setOrientation(0);
            this.pf.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.g.getActivity().getWindow().getDecorView()).addView(this.pf, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.g.getActivity());
        this.wp = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.wp.setText(String.valueOf(i2));
        this.wp.setTypeface(Typeface.DEFAULT_BOLD);
        this.wp.setTextSize(2, 14.0f);
        this.pf.addView(this.wp);
        TextView textView2 = new TextView(this.g.getActivity());
        this.i = textView2;
        textView2.setTextColor(-1);
        this.i.setTypeface(Typeface.DEFAULT_BOLD);
        this.i.setSingleLine();
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setText(x.m(this.g.dl()));
        this.i.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(oq.dl(this.g.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.pf.addView(this.i, layoutParams2);
        TextView textView3 = new TextView(this.g.getActivity());
        textView3.setText("取消");
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                g.this.ls = true;
                int i5 = i;
                if (i5 == 1) {
                    g.this.gz = 0;
                } else if (i5 == 2) {
                    g.this.fo = 0;
                    g.this.v = 0;
                } else if (i5 == -1) {
                    g.this.uy = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                } catch (JSONException unused) {
                }
                v.z().z(g.this.g.dl(), "stats_switch_tip_cancel", jSONObject);
                g.this.m();
                g.this.g.uy();
            }
        });
        this.pf.addView(textView3);
        this.pf.setPadding(oq.dl(this.g.getActivity(), 20.0f), oq.dl(this.g.getActivity(), 16.0f), oq.dl(this.g.getActivity(), 20.0f), oq.fv(this.g.getActivity()));
        this.pf.setClickable(false);
        if (i == 1) {
            this.iq = true;
        } else if (i == 2) {
            this.zw = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, oq.dl(this.g.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.pf.startAnimation(translateAnimation);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void dl() {
        if (x.i() == 1 && this.zw && this.wp != null && this.i != null && !TextUtils.isEmpty(x.kb())) {
            this.wp.setText("");
            this.i.setText(x.kb());
            int iWp = x.wp();
            this.v = iWp;
            if (iWp == 0) {
                this.fo = 0;
                m();
            }
        }
        if (this.q && z(3)) {
            SmallSlideView smallSlideView = this.p;
            if (smallSlideView != null) {
                smallSlideView.g();
            }
            TranslateAnimation translateAnimation = this.tb;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.fv;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.g.z().removeView(this.fv);
            }
            LinearLayout linearLayout2 = this.js;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.g.z().getSceneFrameContainer().removeView(this.js);
            }
            this.g.z().z();
            this.g.z(3);
            this.q = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public boolean a() {
        return this.dl != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public boolean gc() {
        return this.z.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void e() {
        int i;
        int i2;
        if (z(3)) {
            return;
        }
        if (this.e > 0 && this.g.gc() >= this.e) {
            this.e = 0;
            a aVar = new a();
            aVar.z = false;
            aVar.dl = false;
            aVar.f934a = true;
            this.g.getActivity().z(3, aVar);
        }
        if (this.wp != null && (i2 = this.gz) > 0) {
            this.gz = Math.max(0, i2 - 1);
            this.wp.setText(new StringBuilder().append(this.gz).toString());
            if (this.gz == 0) {
                a aVar2 = new a();
                aVar2.z = false;
                aVar2.dl = false;
                aVar2.f934a = true;
                this.g.getActivity().z(1, aVar2);
                m();
            }
        }
        if (this.wp != null) {
            if (x.i() == 1 && x.z(this.g.dl()) != 1 && !this.ls && this.g.fo() && this.g.gz()) {
                a aVar3 = new a();
                aVar3.z = false;
                aVar3.dl = false;
                aVar3.f934a = true;
                this.g.getActivity().z(2, aVar3);
            }
            if (this.fo > 0 || this.v > 0) {
                if (x.i() == 1) {
                    if (this.g.fo()) {
                        int iMax = Math.max(0, this.v - 1);
                        this.v = iMax;
                        if (iMax == 0) {
                            m();
                        }
                    } else {
                        this.fo = Math.max(0, this.fo - 1);
                        this.wp.setText(new StringBuilder().append(this.fo).toString());
                        if (this.fo == 0) {
                            a aVar4 = new a();
                            aVar4.z = false;
                            aVar4.dl = false;
                            aVar4.f934a = true;
                            this.g.getActivity().z(2, aVar4);
                            m();
                        }
                    }
                } else {
                    this.fo = Math.max(0, this.fo - 1);
                    this.wp.setText(new StringBuilder().append(this.fo).toString());
                    if (this.fo == 0) {
                        a aVar5 = new a();
                        aVar5.z = false;
                        aVar5.dl = false;
                        aVar5.f934a = true;
                        this.g.getActivity().z(2, aVar5);
                        m();
                    }
                }
            }
        }
        int i3 = this.kb;
        if (i3 > 0) {
            int iMax2 = Math.max(0, i3 - 1);
            this.kb = iMax2;
            if (iMax2 == 0) {
                this.g.z(-1, this.uy);
                return;
            }
            return;
        }
        if (this.wp == null || (i = this.uy) <= 0) {
            return;
        }
        this.uy = Math.max(0, i - 1);
        this.wp.setText(new StringBuilder().append(this.uy).toString());
        if (this.uy == 0) {
            m();
            this.wp = null;
            this.g.kb();
        }
    }

    public void gz() {
        int iM = this.g.m();
        String strConcat = "继续看" + iM + "秒可领取奖励";
        dl dlVar = this.dl;
        if (dlVar != null) {
            if (dlVar.dl() > 0) {
                strConcat = iM <= 0 ? "成功加速" + this.dl.dl() + "秒，奖励已下发" : "加速成功！".concat(String.valueOf(strConcat));
            } else if (iM <= 0) {
                fo();
                return;
            }
        }
        TextView textView = this.gc;
        if (textView != null) {
            textView.setText(strConcat);
        }
        int i = this.m;
        if (i <= 0) {
            fo();
            return;
        }
        this.m = i - 1;
        TextView textView2 = this.gc;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.gz();
                }
            }, 500L);
        }
    }

    public void fo() {
        TextView textView = this.gc;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.gc.getParent()).removeView(this.gc);
        this.gc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void m() {
        if (this.pf != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.g.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    g.this.pf.removeAllViews();
                }
            });
            this.pf.startAnimation(alphaAnimation);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.z
    public void g(boolean z) {
        this.kb = 0;
        if (z) {
            this.uy = 0;
        }
    }
}
