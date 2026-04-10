package com.anythink.network.mobrain;

import com.anythink.core.api.ATAdConst;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAd;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAd;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAd;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATConst {
    public static final int NETWORK_FIRM_ID = 46;

    static Map<String, Object> a(Object obj) {
        GMAdEcpmInfo showEcpm = obj instanceof GMRewardAd ? ((GMRewardAd) obj).getShowEcpm() : obj instanceof GMFullVideoAd ? ((GMFullVideoAd) obj).getShowEcpm() : obj instanceof GMInterstitialAd ? ((GMInterstitialAd) obj).getShowEcpm() : obj instanceof GMBannerAd ? ((GMBannerAd) obj).getShowEcpm() : obj instanceof GMSplashAd ? ((GMSplashAd) obj).getShowEcpm() : obj instanceof GMNativeAd ? ((GMNativeAd) obj).getShowEcpm() : obj instanceof GMInterstitialFullAd ? ((GMInterstitialFullAd) obj).getShowEcpm() : null;
        try {
            HashMap map = new HashMap(8);
            if (showEcpm != null) {
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_ID, Integer.valueOf(showEcpm.getAdNetworkPlatformId()));
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_NAME, showEcpm.getAdNetworkPlatformName());
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_UNIT_ID, showEcpm.getAdNetworkRitId());
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_ECPM, showEcpm.getPreEcpm());
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, showEcpm.getRequestId());
                map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_BIDDING_TYPE, Integer.valueOf(showEcpm.getReqBiddingType()));
            }
            return map;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getNetworkVersion() {
        return GMMediationAdSdk.getSdkVersion();
    }
}
