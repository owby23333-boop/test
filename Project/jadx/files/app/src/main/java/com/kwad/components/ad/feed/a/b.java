package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    protected ImageView dI;
    protected TextView dJ;
    private TextView dQ;
    protected ImageView eA;
    protected ImageView eB;
    protected RatioFrameLayout eC;
    protected TextView eD;
    private TextView eE;
    private View eF;
    protected DownloadProgressView eG;
    protected TextView ez;
    protected com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    public b(@NonNull Context context) {
        super(context);
    }

    private void a(View view, final int i2) {
        if (view == this.eB) {
            rL();
        } else {
            bi();
            com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).J(this.mAdTemplate).an(5).ao(i2).b(this.mApkDownloadHelper).ap(view == this.eG ? 1 : 2).al(view == this.eG).a(new a.b() { // from class: com.kwad.components.ad.feed.a.b.2
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    b.this.aH(i2);
                }
            }));
        }
    }

    private void bl() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eE = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eF = findViewById(R.id.ksad_h5_open_cover);
        this.eE.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.dQ.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
        this.eF.setOnClickListener(this);
        this.eE.setOnClickListener(this);
        this.dQ.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dQ, this);
    }

    private void bm() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dJ = (TextView) findViewById(R.id.ksad_app_title);
        this.eD = (TextView) findViewById(R.id.ksad_app_desc);
        com.kwad.sdk.b.kwai.a.a(this, this.dI, this.dJ, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.dI, this);
        new com.kwad.sdk.widget.f(getContext(), this.dJ, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        this.dJ.setText(com.kwad.sdk.core.response.a.a.ap(this.mAdInfo));
        this.dI.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dI, com.kwad.sdk.core.response.a.a.bL(this.mAdInfo), this.mAdTemplate, 8);
        this.eD.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        bj();
        this.eG.E(this.mAdTemplate);
        this.eG.setOnClickListener(this);
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eG.getAppDownloadListener());
        this.mApkDownloadHelper.d(this.eG.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            a(view, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull final AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.ez.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.mLogoView.U(adTemplate);
        this.eA.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                if (com.kwad.sdk.core.response.a.a.aN(adInfoCb).height > com.kwad.sdk.core.response.a.a.aN(adInfoCb).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.eC.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.eC.setRatio(1.7857142686843872d);
                    b.this.eC.setLayoutParams(layoutParams);
                }
                List<String> listAU = com.kwad.sdk.core.response.a.a.aU(b.this.mAdInfo);
                if (listAU.size() > 0) {
                    KSImageLoader.loadFeeImage(b.this.eA, listAU.get(0), b.this.mAdTemplate, b.this.ex);
                } else {
                    com.kwad.sdk.core.d.b.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            bm();
        } else {
            bl();
        }
        com.kwad.sdk.b.kwai.a.a(this, this.ez, this.eA, this.eB);
        new com.kwad.sdk.widget.f(getContext(), this.ez, this);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.ez = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eC = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.eC.setRatio(0.5600000023841858d);
        this.eA = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eB = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eG = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eG.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, view == this.ez ? 25 : view == this.eA ? 100 : (view == this.eG || view == this.dQ || view == this.eF) ? 1 : view == this.dI ? 13 : view == this.dJ ? 14 : (view == this.eD || view == this.eE) ? 101 : 35);
    }
}
