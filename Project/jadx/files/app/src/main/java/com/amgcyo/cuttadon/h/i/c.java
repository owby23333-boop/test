package com.amgcyo.cuttadon.h.i;

import android.app.Activity;
import android.view.ViewGroup;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.china.api.ATAppDownloadListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.sntech.ads.api.event.SNEvent;
import java.util.HashMap;

/* JADX INFO: compiled from: ToponBannerManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.amgcyo.cuttadon.h.d.a {
    private Activity b;

    /* JADX INFO: compiled from: ToponBannerManager.java */
    class a implements ATBannerListener {
        final /* synthetic */ NormalAdParams a;
        final /* synthetic */ AdFrameLayout b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ATBannerView f3988c;

        a(NormalAdParams normalAdParams, AdFrameLayout adFrameLayout, ATBannerView aTBannerView) {
            this.a = normalAdParams;
            this.b = adFrameLayout;
            this.f3988c = aTBannerView;
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshFail(AdError adError) {
            String str = "onBannerAutoRefreshFail:" + adError.getFullErrorInfo();
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClicked(ATAdInfo aTAdInfo) {
            String str = "native ad onAdClicked:\n" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.c(aTAdInfo);
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClose(ATAdInfo aTAdInfo) {
            String str = "native ad onAdImpressed:\n" + aTAdInfo.toString();
            if (this.f3988c.getParent() != null) {
                ((ViewGroup) this.f3988c.getParent()).removeView(this.f3988c);
            }
            ((com.amgcyo.cuttadon.h.d.a) c.this).a = this.a.getStochasticKey();
            com.amgcyo.cuttadon.h.a.c.a(((com.amgcyo.cuttadon.h.d.a) c.this).a, 0L);
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerFailed(AdError adError) {
            String str = "onBannerFailed:" + adError.getFullErrorInfo();
            this.b.a(adError.getFullErrorInfo(), 0);
            o.g("banner广告加载失败：" + adError.getFullErrorInfo());
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerLoaded() {
            ((com.amgcyo.cuttadon.h.d.a) c.this).a = this.a.getStochasticKey();
            com.amgcyo.cuttadon.h.a.c.c(((com.amgcyo.cuttadon.h.d.a) c.this).a);
            o.g("banner广告加载成功");
            this.b.removeAllViews();
            this.b.addView(this.f3988c);
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerShow(ATAdInfo aTAdInfo) {
            String str = "native ad onAdImpressed:\n" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.d(aTAdInfo);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.AdType.EXPRESS_BANNER, aTAdInfo);
            com.amgcyo.cuttadon.h.i.g.a.a().a(c.this.b, this.a);
        }
    }

    /* JADX INFO: compiled from: ToponBannerManager.java */
    class b implements ATAppDownloadListener {
        b(c cVar) {
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onDownloadFail(ATAdInfo aTAdInfo, long j2, long j3, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonDownloadFail: totalBytes: " + j2 + "\ncurrBytes:" + j3 + "\nfileName:" + str + "\nappName:" + str2;
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onDownloadFinish(ATAdInfo aTAdInfo, long j2, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonDownloadFinish: totalBytes: " + j2 + "\nfileName:" + str + "\nappName:" + str2;
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onDownloadPause(ATAdInfo aTAdInfo, long j2, long j3, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonDownloadPause: totalBytes: " + j2 + "\ncurrBytes:" + j3 + "\nfileName:" + str + "\nappName:" + str2;
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onDownloadStart(ATAdInfo aTAdInfo, long j2, long j3, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonDownloadStart: totalBytes: " + j2 + "\ncurrBytes:" + j3 + "\nfileName:" + str + "\nappName:" + str2;
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onDownloadUpdate(ATAdInfo aTAdInfo, long j2, long j3, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonDownloadUpdate: totalBytes: " + j2 + "\ncurrBytes:" + j3 + "\nfileName:" + str + "\nappName:" + str2;
        }

        @Override // com.anythink.china.api.ATAppDownloadListener
        public void onInstalled(ATAdInfo aTAdInfo, String str, String str2) {
            String str3 = "ATAdInfo:" + aTAdInfo.toString() + "\nonInstalled:\nfileName:" + str + "\nappName:" + str2;
        }
    }

    c(Activity activity) {
        this.b = activity;
    }

    void a(NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        int adHeight = normalAdParams.getAdHeight();
        String str = "adWidth: " + adWidth + " adHeightPx: " + adHeight;
        ATBannerView aTBannerView = new ATBannerView(adFrameLayout.getContext());
        aTBannerView.setPlacementId(adUnitId);
        aTBannerView.setBannerAdListener(new a(normalAdParams, adFrameLayout, aTBannerView));
        aTBannerView.setAdDownloadListener(new b(this));
        aTBannerView.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("横幅banner", "ToponBannerManager"));
        HashMap map = new HashMap();
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(adWidth));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(adHeight));
        aTBannerView.setLocalExtra(map);
        if (adFrameLayout.getVisibility() == 8) {
            adFrameLayout.setVisibility(0);
        }
        aTBannerView.loadAd();
    }
}
