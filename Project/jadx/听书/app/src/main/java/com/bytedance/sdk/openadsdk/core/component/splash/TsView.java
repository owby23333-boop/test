package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.rv;
import com.bytedance.sdk.openadsdk.core.iq.zx;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class TsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f992a;
    private ImageView dl;
    private NativeExpressView e;
    private TextView fo;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.a g;
    private TextView gc;
    private String gz;
    private z i;
    private na kb;
    private SplashClickBar m;
    private FrameLayout pf;
    private FrameLayout uy;
    private boolean v;
    private boolean wp;
    private final Context z;

    public interface z {
        void fo();

        void gz();

        void z(boolean z);
    }

    public TsView(Context context, String str, na naVar) {
        super(context);
        this.wp = false;
        this.v = false;
        this.z = context;
        this.gz = str;
        this.kb = naVar;
        dl();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        z zVar = this.i;
        if (zVar != null) {
            zVar.z(z2);
        }
    }

    private View z(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.f992a = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f992a.setId(2114387581);
        this.f992a.setLayoutParams(layoutParams);
        frameLayout.addView(this.f992a);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.pf = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.dl = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = oq.dl(this.z, 16.0f);
        layoutParams2.leftMargin = oq.dl(this.z, 16.0f);
        this.dl.setId(2114387580);
        this.dl.setLayoutParams(layoutParams2);
        tb.z(this.z, "tt_splash_mute", this.dl);
        oq.z((View) this.dl, 8);
        frameLayout.addView(this.dl);
        this.g = z(frameLayout, context);
        this.gc = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.gc.setId(2114387578);
        this.gc.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = oq.dl(this.z, 40.0f);
        layoutParams3.leftMargin = oq.dl(this.z, 20.0f);
        tb.z(this.z, "tt_ad_logo_new", this.gc);
        this.gc.setLayoutParams(layoutParams3);
        frameLayout.addView(this.gc);
        return frameLayout;
    }

    private void dl() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View viewZ = z(this.z);
            if (viewZ == null) {
                return;
            }
            addView(viewZ);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.kb);
            this.m = splashClickBar;
            addView(splashClickBar);
            FrameLayout frameLayoutG = g(this.kb);
            this.uy = frameLayoutG;
            if (frameLayoutG != null) {
                addView(frameLayoutG);
            }
        } catch (Throwable unused) {
        }
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.e = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        this.f992a.addView(this.e);
        setExpressViewVisibility(0);
    }

    public void setCountDownTime(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a aVar = this.g;
        if (aVar != null) {
            aVar.setCountDownTime(i);
        }
    }

    public void setSkipIconVisibility(int i) {
        oq.z(getCountDownLayout(), i);
    }

    public void setVideoViewVisibility(int i) {
        oq.z((View) this.dl, i);
    }

    void setVideoVoiceVisibility(int i) {
        oq.z((View) this.dl, i);
    }

    public void setAdlogoViewVisibility(int i) {
        oq.z((View) this.gc, i);
    }

    void setExpressViewVisibility(int i) {
        oq.z((View) this.f992a, i);
    }

    public void setAttachedToWindowListener(z zVar) {
        this.i = zVar;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.a getCountDownView() {
        return this.g;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!gc() && !this.v) {
            oq.z(this, getCountDownLayout());
            oq.z(this, this.dl);
        }
        z zVar = this.i;
        if (zVar != null) {
            zVar.gz();
        }
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        return aVar.getView();
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            oq.z((View) this.m, i);
        }
        oq.z((View) this.uy, i);
    }

    public void z(na naVar) {
        SplashClickBar splashClickBar = this.m;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.z(naVar);
            oq.z(this.gc, naVar);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        ls.z("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        ls.z("不允许在Splash广告中注册OnTouchListener");
    }

    final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a aVar = this.g;
        if (aVar == null || aVar.getView() == null) {
            return;
        }
        this.g.getView().setOnClickListener(onClickListener);
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.dl;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.dl;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (this.wp) {
            return;
        }
        SplashClickBar splashClickBar = this.m;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!a());
        }
        setComplianceBarLayout(this.kb);
        this.wp = true;
    }

    public void z(int i, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        SplashClickBar splashClickBar = this.m;
        if (splashClickBar != null) {
            splashClickBar.z(zVar);
        }
        if (i == 1) {
            zVar.z(this);
            setOnClickListenerInternal(zVar);
            setOnTouchListenerInternal(zVar);
        }
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setCountDownViewPosition(na naVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a aVar = this.g;
        if (aVar == null || aVar.getView() == null || naVar == null) {
            return;
        }
        View view = this.g.getView();
        rv rvVarNm = naVar.nm();
        if (rvVarNm == null) {
            return;
        }
        int iZ = rvVarNm.z();
        int iDl = oq.dl(this.z, rvVarNm.g());
        int iDl2 = oq.dl(this.z, rvVarNm.dl());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iZ == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = iDl;
            layoutParams.topMargin = iDl2;
        } else if (iZ == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = iDl;
            layoutParams.bottomMargin = iDl2;
        } else if (iZ == 4) {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = iDl;
            layoutParams.bottomMargin = iDl2;
        } else {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = iDl;
            layoutParams.topMargin = iDl2;
        }
        view.setLayoutParams(layoutParams);
    }

    public FrameLayout g(final na naVar) {
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw;
        zx zxVarHl;
        if (naVar == null || naVar.lt() != 4 || (mVarBw = naVar.bw()) == null || (zxVarHl = naVar.hl()) == null || zxVarHl.z() == 0) {
            return null;
        }
        String strV = mVarBw.v();
        if (TextUtils.isEmpty(strV)) {
            strV = "暂无";
        }
        String strGc = mVarBw.gc();
        if (TextUtils.isEmpty(strGc)) {
            strGc = "补充中，可于应用官网查看";
        }
        String strE = mVarBw.e();
        String str = TextUtils.isEmpty(strE) ? "补充中，可于应用官网查看" : strE;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("应用名：").append(strV).append("；版本号：").append(strGc).append("；开发者：").append(str);
        String strKb = mVarBw.kb();
        if (TextUtils.isEmpty(strKb)) {
            sbAppend.append("；功能 | 权限 | 隐私  ");
        } else {
            sbAppend.append("；功能 | 权限 | 隐私 | 备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i2 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i3 = iIndexOf3 + 2;
        if (!TextUtils.isEmpty(strKb)) {
            int iIndexOf4 = sb.indexOf("备案");
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    TsView tsView = TsView.this;
                    tsView.z(naVar, tsView.z, TsView.this.gz);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(-1);
                    }
                }
            }, iIndexOf4, iIndexOf4 + 2, 34);
        }
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.g(naVar, tsView.z, TsView.this.gz);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf, i, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.a(naVar, tsView.z, TsView.this.gz);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf2, i2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.dl(naVar, tsView.z, TsView.this.gz);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf3, i3, 34);
        this.fo = new TextView(this.z);
        this.uy = new FrameLayout(this.z);
        this.fo.setMovementMethod(LinkMovementMethod.getInstance());
        this.fo.setTextColor(-1);
        this.fo.setTextSize(11.0f);
        this.fo.setText(spannableString);
        this.uy.addView(this.fo);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(oq.dl(this.z, 6.0f));
        this.uy.setBackground(gradientDrawable);
        return this.uy;
    }

    private boolean dl(na naVar) {
        zx zxVarHl;
        return (naVar == null || naVar.lt() != 4 || naVar.bw() == null || (zxVarHl = naVar.hl()) == null || zxVarHl.z() == 0) ? false : true;
    }

    private void setComplianceBarLayout(na naVar) {
        zx zxVarHl;
        if (this.fo == null || !dl(naVar) || (zxVarHl = naVar.hl()) == null) {
            return;
        }
        int iZ = zxVarHl.z();
        int iG = zxVarHl.g();
        int iDl = zxVarHl.dl();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = oq.dl(zw.getContext(), 25.0f);
        layoutParams.rightMargin = oq.dl(zw.getContext(), 25.0f);
        this.fo.setPadding(20, 20, 20, 20);
        this.fo.setHighlightColor(0);
        if (iZ == 2) {
            layoutParams.gravity = 80;
            if (a()) {
                layoutParams.bottomMargin = oq.dl(zw.getContext(), iDl);
            } else {
                layoutParams.bottomMargin = oq.dl(zw.getContext(), iG);
            }
        } else {
            layoutParams.gravity = 48;
            if (a()) {
                layoutParams.topMargin = oq.dl(zw.getContext(), iDl);
            } else {
                layoutParams.topMargin = oq.dl(zw.getContext(), iG);
            }
        }
        this.uy.setLayoutParams(layoutParams);
    }

    public void z(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(naVar, context, str);
    }

    public void g(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(context, naVar, str);
    }

    public void dl(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.dl(naVar, context, str);
    }

    public void a(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.g(naVar, context, str);
    }

    private boolean a() {
        return getHeight() < oq.g(zw.getContext())[1];
    }

    private boolean gc() {
        na naVar = this.kb;
        return naVar != null && naVar.zr() == 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z zVar = this.i;
        if (zVar != null) {
            zVar.fo();
        }
    }

    public void setIsShowSuccess(boolean z2) {
        this.v = z2;
    }

    public void z() {
        TextView textView = this.gc;
        if (textView != null) {
            tb.z(this.z, "tt_ad_logo_backup", textView);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.a z(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        na naVar = this.kb;
        rv rvVarNm = naVar == null ? null : naVar.nm();
        if ((rvVarNm == null ? 1 : rvVarNm.a()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = oq.dl(this.z, 16.0f);
            layoutParams.rightMargin = oq.dl(this.z, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.pf;
    }

    public void g() {
        TextView textView = this.gc;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a aVar = this.g;
        if (aVar == null || aVar.getView() == null) {
            return;
        }
        this.g.z(true);
        this.g.getView().setVisibility(8);
    }
}
