package com.amgcyo.cuttadon.h.i.g;

import android.content.Context;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashAdListener;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.HashMap;

/* JADX INFO: compiled from: ToponSplashPreloadUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private ATSplashAdListener a = new a(this);

    /* JADX INFO: compiled from: ToponSplashPreloadUtil.java */
    class a implements ATSplashAdListener {
        a(c cVar) {
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onAdClick(ATAdInfo aTAdInfo) {
            String str = "开屏广告预加载 onAdClick:\n" + aTAdInfo.toString();
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
            String str = "开屏广告预加载 onAdDismiss type:" + aTSplashAdExtraInfo.getDismissType();
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onAdLoadTimeout() {
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onAdLoaded(boolean z2) {
            String str = "开屏广告预加载 onAdLoaded,isTimeout：" + z2;
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onAdShow(ATAdInfo aTAdInfo) {
            String str = "开屏广告预加载 onAdShow:\n" + aTAdInfo.toString();
        }

        @Override // com.anythink.splashad.api.ATSplashAdListener
        public void onNoAdError(AdError adError) {
            String str = "开屏广告预加载 onNoAdError: " + adError.getFullErrorInfo();
        }
    }

    /* JADX INFO: compiled from: ToponSplashPreloadUtil.java */
    private static class b {
        private static final c a = new c();
    }

    public static c a() {
        return b.a;
    }

    public void a(Context context, String str) {
        ATSplashAd aTSplashAd = new ATSplashAd(context, str, this.a, 10000, "");
        HashMap map = new HashMap();
        g0 g0VarA = g0.a();
        int iA = g0VarA.a("topon_splash_sizekey_width", DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED);
        int iA2 = g0VarA.a("topon_splash_sizekey_height", 1920);
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(iA));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(iA2));
        String str2 = "width: " + iA + " height: " + iA2;
        aTSplashAd.setLocalExtra(map);
        ATSplashAd.entryAdScenario(str, null);
        aTSplashAd.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("开屏广告预加载", "ToponSplashActivity"));
        aTSplashAd.loadAd();
    }
}
