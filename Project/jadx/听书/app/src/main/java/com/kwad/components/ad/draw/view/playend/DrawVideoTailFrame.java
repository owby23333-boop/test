package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener dW;
    private KsDrawAd.AdInteractionListener dh;
    private TextView ee;
    private DrawDownloadProgressBar gA;
    private ViewGroup gB;
    private TextView gC;
    private TextView gD;
    private AdBaseFrameLayout gt;
    private ImageView gu;
    private ViewGroup gv;
    private ImageView gw;
    private AppScoreView gx;
    private TextView gy;
    private TextView gz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(Context context) {
        super(context);
        B(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.gu = (ImageView) findViewById(R.id.ksad_video_cover);
        this.gv = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_name);
        this.gx = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gy = (TextView) findViewById(R.id.ksad_app_download_count);
        this.gz = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.gA = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.gB = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.gC = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    public final void j(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = a.aV(adInfoEl);
        String str = materialFeatureAV.coverUrl;
        this.mLogoView.aP(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = materialFeatureAV.width;
            int i2 = materialFeatureAV.height;
            if (i > 0 && i > i2) {
                int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i3 = (int) (screenWidth * (i2 / i));
                ViewGroup.LayoutParams layoutParams = this.gu.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i3;
            }
            KSImageLoader.loadImage(this.gu, str, this.mAdTemplate);
        }
        if (a.aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.gw, a.co(this.mAdInfo), this.mAdTemplate, 11);
            this.ee.setText(a.av(this.mAdInfo));
            float fAA = a.aA(this.mAdInfo);
            if (fAA >= 3.0f) {
                this.gx.setScore(fAA);
                this.gx.setVisibility(0);
            }
            this.gy.setText(a.az(this.mAdInfo));
            this.gz.setText(a.au(this.mAdInfo));
            this.gv.setVisibility(0);
            this.gB.setVisibility(8);
        } else {
            this.gC.setText(a.au(this.mAdInfo));
            this.gD.setText(a.aE(this.mAdInfo));
            this.gv.setVisibility(8);
            this.gB.setVisibility(0);
        }
        this.gA.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.gt = adBaseFrameLayout;
    }

    public final void bW() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.dW;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.dW = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.dW) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.gA.e(a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawVideoTailFrame.this.gA.e(i + "%", i);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.gA.e(a.IQ(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.gA.e(a.cl(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.gA.e(a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.gA.e(a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }
        };
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dh = adInteractionListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(view == this.gA ? 1 : 2).aq(view == this.gA).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.dh != null) {
                    DrawVideoTailFrame.this.dh.onAdClicked();
                }
                com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.gt.getTouchCoords());
            }
        }));
    }
}
