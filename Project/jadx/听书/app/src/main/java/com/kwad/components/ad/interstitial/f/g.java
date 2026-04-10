package com.kwad.components.ad.interstitial.f;

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

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.kwad.components.ad.interstitial.f.b {
    private static int np = 4;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mj;
    private a nn = new a();
    private b no = new b();

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mj.mAdTemplate);
        this.nn.nq = (ImageView) this.mj.mk.findViewById(R.id.ksad_app_icon);
        this.nn.nr = (TextView) this.mj.mk.findViewById(R.id.ksad_app_title);
        this.nn.ns = (TextView) this.mj.mk.findViewById(R.id.ksad_app_desc);
        this.nn.nt = (KsPriceView) this.mj.mk.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.nn, this.no, this.mAdInfo, this.mAdTemplate);
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.nq;
        if (!TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.ch(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, np);
            }
        } else {
            imageView.setVisibility(8);
        }
        aVar.nr.setText(bVar.ez());
        if (!com.kwad.components.ad.interstitial.b.b.dN() || com.kwad.sdk.core.response.b.a.ch(adInfo) != 3) {
            aVar.ns.setText(bVar.eA());
        } else {
            aVar.nt.d(bVar.getPrice(), bVar.eB(), true);
            aVar.nt.setVisibility(0);
            aVar.ns.setVisibility(8);
            ey();
        }
        this.mj.mk.f(bVar.eC(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.ch(adInfo) == 2) {
            this.no.w(com.kwad.sdk.core.response.b.a.cO(adInfo));
            this.no.x(com.kwad.sdk.core.response.b.a.cn(adInfo));
            CharSequence charSequenceB = com.kwad.sdk.core.response.b.a.b(adInfo, com.kwad.components.core.widget.e.ajk);
            if (TextUtils.isEmpty(charSequenceB)) {
                charSequenceB = com.kwad.sdk.core.response.b.a.cN(adInfo);
            }
            this.no.a(charSequenceB);
            if (com.kwad.sdk.core.response.b.a.cK(adInfo)) {
                this.no.z(com.kwad.components.ad.e.b.aC());
                return;
            } else {
                this.no.z(com.kwad.components.ad.e.b.aF());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dN() && com.kwad.sdk.core.response.b.a.ch(adInfo) == 3) {
            AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            this.no.w(adProductInfoCV.icon);
            this.no.x(adProductInfoCV.name);
            this.no.y(adProductInfoCV.originPrice);
            this.no.setPrice(adProductInfoCV.price);
            this.no.z(com.kwad.components.ad.e.b.aD());
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.no.w(com.kwad.sdk.core.response.b.a.co(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.av(adInfo))) {
                this.no.x(com.kwad.sdk.core.response.b.a.av(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.no.x(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.no.x(getContext().getString(R.string.ksad_ad_default_username_normal));
            }
            this.no.a(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.no.z(com.kwad.sdk.core.response.b.a.aE(adInfo));
            return;
        }
        this.no.w(com.kwad.sdk.core.response.b.a.co(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.ax(adInfo))) {
            this.no.x(com.kwad.sdk.core.response.b.a.ax(adInfo));
        } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.no.x(adInfo.advertiserInfo.adAuthorText);
        } else {
            this.no.x(getContext().getString(R.string.ksad_ad_default_username_normal));
        }
        this.no.a(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.no.z(com.kwad.sdk.core.response.b.a.aE(adInfo));
    }

    private void ey() {
        View viewFindViewById = this.mj.mk.findViewById(R.id.ksad_ad_desc_layout);
        View viewFindViewById2 = this.mj.mk.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    static class a {
        private ImageView nq;
        private TextView nr;
        private TextView ns;
        private KsPriceView nt;

        a() {
        }
    }

    static class b {
        private String appIconUrl;
        private String nu;
        private CharSequence nv;
        private String nw;
        private String nx;
        private String price;

        b() {
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final void w(String str) {
            this.appIconUrl = str;
        }

        public final String ez() {
            return this.nu;
        }

        public final void x(String str) {
            this.nu = str;
        }

        public final CharSequence eA() {
            return this.nv;
        }

        public final void a(CharSequence charSequence) {
            this.nv = charSequence;
        }

        public final String eB() {
            return this.nw;
        }

        public final void y(String str) {
            this.nw = str;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void setPrice(String str) {
            this.price = str;
        }

        public final String eC() {
            return this.nx;
        }

        public final void z(String str) {
            this.nx = str;
        }
    }
}
