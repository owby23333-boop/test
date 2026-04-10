package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private ImageView eB;
    private DownloadProgressView eG;
    private TextView ez;
    private RoundAngleImageView ft;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public k(@NonNull Context context) {
        super(context);
    }

    private void bm() {
        this.mLogoView.U(this.mAdTemplate);
        this.eG.E(this.mAdTemplate);
        com.kwad.sdk.b.kwai.a.a(this, this.ez, this.ft, this.eG);
        new com.kwad.sdk.widget.f(getContext(), this.ez, this);
        new com.kwad.sdk.widget.f(getContext(), this.ft, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eG.getAppDownloadListener());
            this.mApkDownloadHelper.d(this.eG.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bj();
        }
    }

    private void c(View view, final int i2) {
        if (view == this.eB) {
            rL();
        } else {
            com.kwad.components.core.d.b.a.a(new a.C0395a(com.kwad.sdk.b.kwai.a.C(this)).an(5).ao(i2).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.eG ? 1 : 2).al(view == this.eG).a(new a.b() { // from class: com.kwad.components.ad.feed.a.k.1
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    k.this.aH(i2);
                }
            }));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            c(view, TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.ez.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        List<String> listAU = com.kwad.sdk.core.response.a.a.aU(this.mAdInfo);
        if (listAU.size() > 0) {
            this.ew = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.ft, listAU.get(0), this.mAdTemplate, this.ex);
        } else {
            com.kwad.sdk.core.d.b.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        bm();
        this.eB.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.ez = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        this.ft = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.ft.setRadius(com.kwad.sdk.b.kwai.a.a(getContext(), 3.0f));
        this.eB = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eG = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eG.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c(view, view == this.ez ? 25 : view == this.ft ? 100 : view == this.eG ? 1 : 35);
    }
}
