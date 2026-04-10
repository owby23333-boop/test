package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends LinearLayout {
    protected KsAppTagsView BE;
    protected com.kwad.components.ad.j.a BH;
    private Runnable BI;
    protected View Bw;
    protected Button Bx;
    protected Button By;
    protected TextProgressBar EG;
    protected AppScoreView Ep;
    protected View GD;
    protected TextView MU;
    protected TextView gy;
    protected ValueAnimator lJ;
    protected ImageView nq;
    protected TextView nr;

    public abstract int getLayoutId();

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }

    private void initView() {
        this.GD = m.inflate(getContext(), getLayoutId(), this);
        this.nq = (ImageView) findViewById(R.id.ksad_app_icon);
        this.nr = (TextView) findViewById(R.id.ksad_app_name);
        this.Ep = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gy = (TextView) findViewById(R.id.ksad_app_download_count);
        this.MU = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.EG = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.EG.setTextColor(-1);
        this.BE = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.Bx = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.By = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.Bw = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.BH = new com.kwad.components.ad.j.a(this.GD);
    }

    public void j(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        if (e.O(adTemplate)) {
            KSImageLoader.loadAppIcon(this.nq, com.kwad.sdk.core.response.b.a.cO(adInfoEl), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.nq, com.kwad.sdk.core.response.b.a.co(adInfoEl), adTemplate, 12);
        }
        this.nr.setText(com.kwad.sdk.core.response.b.a.cl(adInfoEl));
        if (!e.O(adTemplate)) {
            float fAA = com.kwad.sdk.core.response.b.a.aA(adInfoEl);
            if (fAA >= 3.0f) {
                this.Ep.setScore(fAA);
                this.Ep.setVisibility(0);
            } else {
                this.Ep.setVisibility(8);
            }
            String strAz = com.kwad.sdk.core.response.b.a.az(adInfoEl);
            if (!TextUtils.isEmpty(strAz)) {
                this.gy.setText(strAz);
                this.gy.setVisibility(0);
            } else {
                this.gy.setVisibility(8);
            }
        }
        this.MU.setText(com.kwad.sdk.core.response.b.a.au(adInfoEl));
        if (e.O(adTemplate)) {
            this.EG.setVisibility(8);
            this.Bw.setVisibility(0);
            this.By.setText("查看详情");
            this.Bx.setText(String.format("浏览详情页%s秒，领取奖励", new StringBuilder().append(com.kwad.sdk.core.config.e.FC()).toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.BI == null) {
                    this.BI = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.BH.je();
                        }
                    };
                }
                this.Bw.postDelayed(this.BI, 1600L);
            }
        } else {
            this.EG.setVisibility(0);
            this.Bw.setVisibility(8);
            Runnable runnable = this.BI;
            if (runnable != null) {
                this.Bw.removeCallbacks(runnable);
                this.BI = null;
            }
            D(e.el(adTemplate));
        }
        if (e.O(adTemplate)) {
            List<String> listEc = d.ec(adTemplate);
            if (listEc.size() > 0) {
                this.BE.setVisibility(0);
            } else {
                this.BE.setVisibility(8);
            }
            this.BE.setAppTags(listEc);
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.EG;
    }

    public View getBtnInstallContainer() {
        return this.Bw;
    }

    public final void D(AdInfo adInfo) {
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            lv();
        } else {
            nW();
        }
    }

    public final void lv() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.lJ.cancel();
            this.lJ.end();
        }
        Runnable runnable = this.BI;
        if (runnable != null) {
            this.Bw.removeCallbacks(runnable);
            this.BI = null;
        }
        this.BH.nE();
    }

    private void nW() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.lJ = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(1200L);
            this.lJ.setRepeatCount(-1);
            this.lJ.setRepeatMode(1);
            this.lJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.EG.setScaleY(fFloatValue);
                    a.this.EG.setScaleX(fFloatValue);
                }
            });
            this.lJ.start();
        }
    }
}
