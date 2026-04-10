package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private TextView hA;
    private ImageView hB;
    private ImageView hC;
    private KsLogoView mLogoView;

    public n(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bw() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        this.hB = (ImageView) findViewById(R.id.ksad_ad_image);
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        List<String> listBa = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        this.mLogoView.aP(this.mAdTemplate);
        if (listBa.size() > 0) {
            KSImageLoader.loadFeeImage(this.hB, listBa.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.c.a.a.a(this, this.hA, this.hB, this.hC);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.hB, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            ck();
        }
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
        } else {
            i = view == this.hB ? 100 : 35;
        }
        d(view, i);
    }

    private void d(View view, int i) {
        if (view == this.hC) {
            vW();
            return;
        }
        if (com.kwad.components.core.e.d.d.a(new a.C0333a(getContext()).aB(this.mAdTemplate), 1) == 1) {
            ba(i);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            ba(i);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.aig);
        } else {
            ba(i);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }
}
