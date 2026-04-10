package com.kwad.components.ad.interstitial.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends com.kwad.components.ad.interstitial.c.b {
    private static int ls = 4;
    private c jq;
    private a lq = new a();
    private b lr = new b();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    static class a {
        private ImageView lt;
        private TextView lu;
        private TextView lv;
        private KsPriceView lw;

        a() {
        }
    }

    static class b {
        private String appIconUrl;
        private String lA;
        private String lx;
        private CharSequence ly;
        private String lz;
        private String price;

        b() {
        }

        public final void A(String str) {
            this.price = str;
        }

        public final void B(String str) {
            this.lA = str;
        }

        public final void a(CharSequence charSequence) {
            this.ly = charSequence;
        }

        public final String ej() {
            return this.lx;
        }

        public final CharSequence ek() {
            return this.ly;
        }

        public final String el() {
            return this.lz;
        }

        public final String em() {
            return this.lA;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void x(String str) {
            this.appIconUrl = str;
        }

        public final void y(String str) {
            this.lx = str;
        }

        public final void z(String str) {
            this.lz = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.lt;
        if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.a.a.cg(adInfo)) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, ls);
            }
        }
        aVar.lu.setText(bVar.ej());
        if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            aVar.lw.d(bVar.getPrice(), bVar.el(), true);
            aVar.lw.setVisibility(0);
            aVar.lv.setVisibility(8);
            ei();
        } else {
            aVar.lv.setText(bVar.ek());
        }
        this.jq.jr.h(bVar.em(), 0);
    }

    private void e(AdInfo adInfo) {
        b bVar;
        String string;
        b bVar2;
        String string2;
        if (com.kwad.sdk.core.response.a.a.cg(adInfo)) {
            this.lr.x(com.kwad.sdk.core.response.a.a.cl(adInfo));
            this.lr.y(com.kwad.sdk.core.response.a.a.bK(adInfo));
            CharSequence charSequenceE = com.kwad.sdk.core.response.a.a.e(adInfo, com.kwad.components.core.widget.e.WP);
            if (TextUtils.isEmpty(charSequenceE)) {
                charSequenceE = com.kwad.sdk.core.response.a.a.ck(adInfo);
            }
            this.lr.a(charSequenceE);
            if (com.kwad.sdk.core.response.a.a.ch(adInfo)) {
                this.lr.B(com.kwad.components.ad.c.b.ah());
                return;
            } else {
                this.lr.B(com.kwad.components.ad.c.b.ak());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfo);
            this.lr.x(adProductInfoCr.icon);
            this.lr.y(adProductInfoCr.name);
            this.lr.z(adProductInfoCr.originPrice);
            this.lr.A(adProductInfoCr.price);
            this.lr.B(com.kwad.components.ad.c.b.ai());
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            this.lr.x(com.kwad.sdk.core.response.a.a.bL(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ap(adInfo))) {
                bVar2 = this.lr;
                string2 = com.kwad.sdk.core.response.a.a.ap(adInfo);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                bVar2 = this.lr;
                string2 = getContext().getString(R.string.ksad_ad_default_username_normal);
            } else {
                bVar2 = this.lr;
                string2 = adInfo.advertiserInfo.adAuthorText;
            }
            bVar2.y(string2);
            this.lr.a(com.kwad.sdk.core.response.a.a.ao(adInfo));
            this.lr.B(com.kwad.sdk.core.response.a.a.ax(adInfo));
            return;
        }
        this.lr.x(com.kwad.sdk.core.response.a.a.bL(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aq(adInfo))) {
            bVar = this.lr;
            string = com.kwad.sdk.core.response.a.a.aq(adInfo);
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            bVar = this.lr;
            string = getContext().getString(R.string.ksad_ad_default_username_normal);
        } else {
            bVar = this.lr;
            string = adInfo.advertiserInfo.adAuthorText;
        }
        bVar.y(string);
        this.lr.a(com.kwad.sdk.core.response.a.a.ao(adInfo));
        this.lr.B(com.kwad.sdk.core.response.a.a.ax(adInfo));
    }

    private void ei() {
        View viewFindViewById = this.jq.jr.findViewById(R.id.ksad_ad_desc_layout);
        View viewFindViewById2 = this.jq.jr.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        AdTemplate adTemplate = this.jq.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.lq.lt = (ImageView) this.jq.jr.findViewById(R.id.ksad_app_icon);
        this.lq.lu = (TextView) this.jq.jr.findViewById(R.id.ksad_app_title);
        this.lq.lv = (TextView) this.jq.jr.findViewById(R.id.ksad_app_desc);
        this.lq.lw = (KsPriceView) this.jq.jr.findViewById(R.id.ksad_product_price);
        e(this.mAdInfo);
        a(this.lq, this.lr, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
