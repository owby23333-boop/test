package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private ImageView eA;
    private ImageView eB;
    private TextView ez;
    private KsLogoView mLogoView;

    public j(@NonNull Context context) {
        super(context);
    }

    private void c(View view, int i2) {
        if (view == this.eB) {
            rL();
            return;
        }
        if (com.kwad.components.core.d.b.d.b(new a.C0395a(getContext()).J(this.mAdTemplate), 1) == 1) {
            aH(i2);
            return;
        }
        boolean zAy = com.kwad.sdk.core.response.a.a.ay(this.mAdInfo);
        aH(i2);
        if (zAy) {
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.oJ);
        } else {
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
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
        this.mLogoView.U(adTemplate);
        if (listAU.size() > 0) {
            KSImageLoader.loadFeeImage(this.eA, listAU.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.b.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.b.kwai.a.a(this, this.ez, this.eA, this.eB);
        new com.kwad.sdk.widget.f(getContext(), this.ez, this);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            bj();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.ez = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eA = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eB = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c(view, view == this.ez ? 25 : view == this.eA ? 100 : 35);
    }
}
