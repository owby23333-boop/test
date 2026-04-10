package com.sntech.event;

import com.anythink.core.api.ATAdInfo;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SNEvent {
    private static Map<Integer, AdPlatform> sIdPlatform;

    public enum AdEvent {
        SHOW("SHOW"),
        CLICK("CLICK"),
        CLICK_CREATIVE("CLICK_CREATIVE"),
        DOWNLOAD("DOWNLOAD"),
        INSTALL("INSTALL"),
        SHOW_COMPLETE("SHOW_COMPLETE"),
        AD_CLOSE("AD_CLOSE"),
        AD_ERROR("AD_ERROR"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdEvent(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public enum AdPlatform {
        FACEBOOK(GlobalSetting.FACEBOOK_SDK_WRAPPER),
        ADMOB(GlobalSetting.ADMOB_SDK_WRAPPER),
        INMOBI("INMOBI"),
        FLURRY("FLURRY"),
        APPLOVIN(GlobalSetting.APPLOVIN_SDK_WRAPPER),
        MOPUB("MOPUB"),
        CHARTBOOST("CHARTBOOST"),
        TAPJOY("TAPJOY"),
        IRONSOURCE("IRONSOURCE"),
        UNITY("UNITY"),
        VUNGLE("VUNGLE"),
        ADCOLONY("ADCOLONY"),
        JOOMOB("JOOMOB"),
        ONEWAY("ONEWAY"),
        JINSHANYUN("JINSHANYUN"),
        APPNEXT("APPNEXT"),
        NEND("NEND"),
        MAIO("MAIO"),
        STARTAPP("STARTAPP"),
        SUPERAWESOME("SUPERAWESOME"),
        MYTARGET("MYTARGET"),
        MYOFFER("MYOFFER"),
        OGURY("OGURY"),
        FYBER("FYBER"),
        HUAWEI("HUAWEI"),
        HELIUM("HELIUM"),
        KIDOZ("KIDOZ"),
        PANGLE("PANGLE"),
        CSJ("CSJ"),
        YLH("YLH"),
        BQT("BQT"),
        KUAISHOU("KUAISHOU"),
        SIGMOB("SIGMOB"),
        MTG("MTG"),
        YKY("YKY"),
        GROMORE("GROMORE"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdPlatform(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public enum AdType {
        FEED("FEED"),
        DRAW_FEED("DRAW_FEED"),
        NATIVE("NATIVE"),
        BANNER("BANNER"),
        INTERSTITIAL("INTERSTITIAL"),
        SPLASH("SPLASH"),
        REWARD_VIDEO("REWARD_VIDEO"),
        FULL_SCREEN_VIDEO("FULL_SCREEN_VIDEO"),
        EXPRESS_SPLASH("EXPRESS_SPLASH"),
        EXPRESS_NATIVE("EXPRESS_NATIVE"),
        EXPRESS_FEED("EXPRESS_FEED"),
        EXPRESS_DRAW_FEED("EXPRESS_DRAW_FEED"),
        EXPRESS_BANNER("EXPRESS_BANNER"),
        EXPRESS_BANNER_FEED("EXPRESS_BANNER_FEED"),
        EXPRESS_REWARD_VIDEO("EXPRESS_REWARD_VIDEO"),
        EXPRESS_FULL_SCREEN_VIDEO("EXPRESS_FULL_SCREEN_VIDEO"),
        EXPRESS_INTERSTITIAL("EXPRESS_INTERSTITIAL"),
        UNKNOWN("UNKNOWN");

        private String name;

        AdType(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public enum EventSource {
        POLLING("polling"),
        OFFICIAL("official");

        private String name;

        EventSource(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public enum UserEvent {
        REGISTER("REGISTER"),
        LOGIN("LOGIN");

        private String name;

        UserEvent(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public enum WithdrawChannel {
        ALIPAY("ALIPAY"),
        WECHAT("WECHAT");

        private String name;

        WithdrawChannel(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    static {
        HashMap map = new HashMap();
        sIdPlatform = map;
        map.put(1, AdPlatform.FACEBOOK);
        sIdPlatform.put(2, AdPlatform.ADMOB);
        sIdPlatform.put(3, AdPlatform.INMOBI);
        sIdPlatform.put(4, AdPlatform.FLURRY);
        sIdPlatform.put(5, AdPlatform.APPLOVIN);
        sIdPlatform.put(6, AdPlatform.MTG);
        sIdPlatform.put(7, AdPlatform.MOPUB);
        sIdPlatform.put(8, AdPlatform.YLH);
        sIdPlatform.put(9, AdPlatform.CHARTBOOST);
        sIdPlatform.put(10, AdPlatform.TAPJOY);
        sIdPlatform.put(11, AdPlatform.IRONSOURCE);
        sIdPlatform.put(12, AdPlatform.UNITY);
        sIdPlatform.put(13, AdPlatform.VUNGLE);
        sIdPlatform.put(14, AdPlatform.ADCOLONY);
        sIdPlatform.put(15, AdPlatform.CSJ);
        sIdPlatform.put(16, AdPlatform.JOOMOB);
        sIdPlatform.put(17, AdPlatform.ONEWAY);
        sIdPlatform.put(19, AdPlatform.JINSHANYUN);
        sIdPlatform.put(21, AdPlatform.APPNEXT);
        sIdPlatform.put(22, AdPlatform.BQT);
        sIdPlatform.put(23, AdPlatform.NEND);
        sIdPlatform.put(24, AdPlatform.MAIO);
        sIdPlatform.put(25, AdPlatform.STARTAPP);
        sIdPlatform.put(26, AdPlatform.SUPERAWESOME);
        sIdPlatform.put(28, AdPlatform.KUAISHOU);
        sIdPlatform.put(29, AdPlatform.SIGMOB);
        sIdPlatform.put(32, AdPlatform.MYTARGET);
        sIdPlatform.put(35, AdPlatform.MYOFFER);
        sIdPlatform.put(36, AdPlatform.OGURY);
        sIdPlatform.put(37, AdPlatform.FYBER);
        sIdPlatform.put(39, AdPlatform.HUAWEI);
        sIdPlatform.put(40, AdPlatform.HELIUM);
        sIdPlatform.put(45, AdPlatform.KIDOZ);
        sIdPlatform.put(46, AdPlatform.GROMORE);
        sIdPlatform.put(50, AdPlatform.PANGLE);
        sIdPlatform.put(51, AdPlatform.YKY);
    }

    public static String getTopOnRealAdId(ATAdInfo aTAdInfo) {
        return aTAdInfo == null ? "" : aTAdInfo.getNetworkPlacementId();
    }

    public static AdPlatform getTopOnRealAdPlatform(ATAdInfo aTAdInfo) {
        return aTAdInfo == null ? AdPlatform.UNKNOWN : getTopOnRealAdPlatform(aTAdInfo.getNetworkFirmId());
    }

    public static AdPlatform getTopOnRealAdPlatform(int i2) {
        AdPlatform adPlatform = sIdPlatform.get(Integer.valueOf(i2));
        return adPlatform == null ? AdPlatform.UNKNOWN : adPlatform;
    }
}
