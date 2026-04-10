package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.i.a;

/* JADX INFO: loaded from: classes2.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsDrawAd.AdInteractionListener bV;

    @Nullable
    private KsAppDownloadListener cE;
    private AdBaseFrameLayout dF;
    private ImageView dG;
    private ViewGroup dH;
    private ImageView dI;
    private TextView dJ;
    private AppScoreView dK;
    private TextView dL;
    private TextView dM;
    private DrawDownloadProgressBar dN;
    private ViewGroup dO;
    private TextView dP;
    private TextView dQ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        D(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        a.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.dG = (ImageView) findViewById(R.id.ksad_video_cover);
        this.dH = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dJ = (TextView) findViewById(R.id.ksad_app_name);
        this.dK = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dL = (TextView) findViewById(R.id.ksad_app_download_count);
        this.dM = (TextView) findViewById(R.id.ksad_app_ad_desc);
        this.dN = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.dN.setTextSize(15);
        this.dO = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.dP = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.dN.f(com.kwad.sdk.core.response.a.a.ax(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dN.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.dN.f(com.kwad.sdk.core.response.a.a.aI(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dN.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.dN.f(com.kwad.sdk.core.response.a.a.ax(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dN.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.dN.f(com.kwad.sdk.core.response.a.a.U(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dN.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                super.onPaused(i2);
                DrawVideoTailFrame.this.dN.f(com.kwad.sdk.core.response.a.a.xI(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DrawVideoTailFrame.this.dN.f(i2 + "%", i2);
            }
        };
    }

    public final void aX() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.cE;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
            } else {
                this.cE = getAppDownloadListener();
                this.mApkDownloadHelper.b(this.cE);
            }
        }
    }

    public final void bindView(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
        String str = materialFeatureAO.coverUrl;
        this.mLogoView.U(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i2 = materialFeatureAO.width;
            int i3 = materialFeatureAO.height;
            if (i2 > 0 && i2 > i3) {
                int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i4 = (int) (screenWidth * (i3 / i2));
                ViewGroup.LayoutParams layoutParams = this.dG.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i4;
            }
            KSImageLoader.loadImage(this.dG, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.dI, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), this.mAdTemplate, 11);
            this.dJ.setText(com.kwad.sdk.core.response.a.a.ap(this.mAdInfo));
            float fAt = com.kwad.sdk.core.response.a.a.at(this.mAdInfo);
            if (fAt >= 3.0f) {
                this.dK.setScore(fAt);
                this.dK.setVisibility(0);
            }
            this.dL.setText(com.kwad.sdk.core.response.a.a.as(this.mAdInfo));
            this.dM.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
            this.dH.setVisibility(0);
            this.dO.setVisibility(8);
        } else {
            this.dP.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
            this.dQ.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
            this.dH.setVisibility(8);
            this.dO.setVisibility(0);
        }
        this.dN.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.dN ? 1 : 2).al(view == this.dN).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.bV != null) {
                    DrawVideoTailFrame.this.bV.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dF.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.cE) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.dF = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
