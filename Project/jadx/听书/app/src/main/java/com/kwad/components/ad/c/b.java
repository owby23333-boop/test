package com.kwad.components.ad.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public FrameLayout bH;
    public a bI;
    public KsAdVideoPlayConfig bJ;
    public List<AdTemplate> bK;
    private KsBannerAd.BannerAdInteractionListener bL;
    private d bM;
    public StyleTemplate bN;
    public boolean bO = false;
    public AdResultData mAdResultData;
    public SceneImpl mAdScene;
    public Context mContext;

    public interface a {
        void Z();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public static boolean a(AdTemplate adTemplate) {
        AdMatrixInfo.AdBannerTKInfo adBannerTKInfoDy;
        return com.kwad.sdk.core.config.e.Fq() && (adBannerTKInfoDy = com.kwad.sdk.core.response.b.b.dy(adTemplate)) != null && !TextUtils.isEmpty(adBannerTKInfoDy.templateId) && adBannerTKInfoDy.renderType == 1;
    }

    public final void a(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bL = bannerAdInteractionListener;
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.bM = dVar;
    }

    public final void a(a aVar) {
        this.bI = aVar;
    }

    public final void W() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShow();
        }
    }

    public final void X() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClicked();
        }
    }

    public final void Y() {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClose();
        }
    }

    public final void c(int i, String str) {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShowError(0, str);
        }
    }

    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.bM.b(this.mAdTemplate);
    }
}
