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
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends LinearLayout {
    protected AppScoreView Bc;
    protected TextProgressBar Bs;
    protected View Gl;
    protected TextView Hv;
    protected TextView dL;
    protected ValueAnimator iT;
    protected ImageView lt;
    protected TextView lu;
    protected View xZ;
    protected Button ya;
    protected Button yb;
    protected KsAppTagsView yg;
    protected com.kwad.components.ad.g.a yj;
    private Runnable yk;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView();
    }

    private void initView() {
        this.Gl = com.kwad.sdk.i.a.inflate(getContext(), getLayoutId(), this);
        this.lt = (ImageView) findViewById(R.id.ksad_app_icon);
        this.lu = (TextView) findViewById(R.id.ksad_app_name);
        this.Bc = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dL = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Hv = (TextView) findViewById(R.id.ksad_app_introduce);
        this.Bs = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.Bs.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
        this.Bs.setTextColor(-1);
        this.yg = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.ya = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yb = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xZ = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.yj = new com.kwad.components.ad.g.a(this.Gl);
    }

    private void mn() {
        ValueAnimator valueAnimator = this.iT;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.iT = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.iT.setDuration(1200L);
            this.iT.setRepeatCount(-1);
            this.iT.setRepeatMode(1);
            this.iT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.Bs.setScaleY(fFloatValue);
                    a.this.Bs.setScaleX(fFloatValue);
                }
            });
            this.iT.start();
        }
    }

    public void bindView(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String strBL;
        AdInfo adInfoCb = d.cb(adTemplate);
        if (d.q(adTemplate)) {
            imageView = this.lt;
            strBL = com.kwad.sdk.core.response.a.a.cl(adInfoCb);
        } else {
            imageView = this.lt;
            strBL = com.kwad.sdk.core.response.a.a.bL(adInfoCb);
        }
        KSImageLoader.loadAppIcon(imageView, strBL, adTemplate, 12);
        this.lu.setText(com.kwad.sdk.core.response.a.a.bJ(adInfoCb));
        if (!d.q(adTemplate)) {
            float fAt = com.kwad.sdk.core.response.a.a.at(adInfoCb);
            if (fAt >= 3.0f) {
                this.Bc.setScore(fAt);
                this.Bc.setVisibility(0);
            } else {
                this.Bc.setVisibility(8);
            }
            String strAs = com.kwad.sdk.core.response.a.a.as(adInfoCb);
            if (TextUtils.isEmpty(strAs)) {
                this.dL.setVisibility(8);
            } else {
                this.dL.setText(strAs);
                this.dL.setVisibility(0);
            }
        }
        this.Hv.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        if (d.q(adTemplate)) {
            this.Bs.setVisibility(8);
            this.xZ.setVisibility(0);
            this.yb.setText("查看详情");
            Button button = this.ya;
            StringBuilder sb = new StringBuilder();
            sb.append(com.kwad.sdk.core.config.d.uM());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.yk == null) {
                    this.yk = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.yj.lW();
                        }
                    };
                }
                this.xZ.postDelayed(this.yk, 1600L);
            }
        } else {
            this.Bs.setVisibility(0);
            this.xZ.setVisibility(8);
            Runnable runnable = this.yk;
            if (runnable != null) {
                this.xZ.removeCallbacks(runnable);
                this.yk = null;
            }
            x(d.cb(adTemplate));
        }
        if (d.q(adTemplate)) {
            List<String> listBS = c.bS(adTemplate);
            if (listBS.size() > 0) {
                this.yg.setVisibility(0);
            } else {
                this.yg.setVisibility(8);
            }
            this.yg.setAppTags(listBS);
        }
    }

    public View getBtnInstallContainer() {
        return this.xZ;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.Bs;
    }

    public final void kA() {
        ValueAnimator valueAnimator = this.iT;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.iT.cancel();
            this.iT.end();
        }
        Runnable runnable = this.yk;
        if (runnable != null) {
            this.xZ.removeCallbacks(runnable);
            this.yk = null;
        }
        this.yj.lX();
    }

    public final void x(@NonNull AdInfo adInfo) {
        int i2 = adInfo.status;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            kA();
        } else {
            mn();
        }
    }
}
