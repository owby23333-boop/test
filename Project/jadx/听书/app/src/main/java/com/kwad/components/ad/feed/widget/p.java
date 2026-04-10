package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private TextView hA;
    private ImageView hC;
    private DownloadProgressView hH;
    private RoundAngleImageView iq;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public p(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bw() {
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.iq = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.hH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    private void cn() {
        this.mLogoView.aP(this.mAdTemplate);
        this.hH.at(this.mAdTemplate);
        this.hH.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.hH.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.hH.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            ck();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        List<String> listBa = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        if (listBa.size() > 0) {
            this.ht = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.iq, listBa.get(0), this.mAdTemplate, this.hy);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        cn();
        com.kwad.sdk.c.a.a.a(this, this.hA, this.iq, this.hH, this.hC);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.iq, this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cq() {
        super.cq();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.hH.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        DownloadProgressView downloadProgressView;
        super.aa();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.hH) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.hA) {
            i = 25;
        } else if (view == this.iq) {
            i = 100;
        } else {
            i = view == this.hH ? 1 : 35;
        }
        d(view, i);
    }

    private void d(View view, final int i) {
        if (view == this.hC) {
            vW();
        } else {
            com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.mAdTemplate).az(5).aA(i).b(this.mApkDownloadHelper).aB(view == this.hH ? 1 : 2).aq(view == this.hH).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.p.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    p.this.ba(i);
                }
            }));
        }
    }
}
