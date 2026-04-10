package com.amgcyo.cuttadon.h.i.g;

import android.content.Context;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.anythink.banner.api.ATBannerExListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import java.util.HashMap;

/* JADX INFO: compiled from: ToponBannerPreloadUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "com.amgcyo.cuttadon.h.i.g.a";

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.i.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ToponBannerPreloadUtil.java */
    class C0104a implements ATBannerExListener {
        final /* synthetic */ NormalAdParams a;

        C0104a(a aVar, NormalAdParams normalAdParams) {
            this.a = normalAdParams;
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshFail(AdError adError) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClicked(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerClose(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerFailed(AdError adError) {
            this.a.setAdWidth(0);
            this.a.setAdHeight(0);
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerLoaded() {
            this.a.setAdWidth(0);
            this.a.setAdHeight(0);
        }

        @Override // com.anythink.banner.api.ATBannerListener
        public void onBannerShow(ATAdInfo aTAdInfo) {
        }

        @Override // com.anythink.banner.api.ATBannerExListener
        public void onDeeplinkCallback(boolean z2, ATAdInfo aTAdInfo, boolean z3) {
        }

        @Override // com.anythink.banner.api.ATBannerExListener
        public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        }
    }

    /* JADX INFO: compiled from: ToponBannerPreloadUtil.java */
    private static class b {
        private static final a a = new a();
    }

    public static a a() {
        return b.a;
    }

    public void a(Context context, NormalAdParams normalAdParams) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        int adHeight = normalAdParams.getAdHeight();
        String str = "pre adWidth: " + adWidth + " adHeightPx: " + adHeight;
        ATBannerView aTBannerView = new ATBannerView(context);
        aTBannerView.setPlacementId(adUnitId);
        aTBannerView.setBannerAdListener(new C0104a(this, normalAdParams));
        aTBannerView.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("横幅banner广告预加载", a));
        HashMap map = new HashMap();
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(adWidth));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(adHeight));
        aTBannerView.setLocalExtra(map);
        aTBannerView.loadAd();
    }
}
