package com.kwad.components.ad.reward.kwai;

import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static TemplateConfig gN() {
        SdkConfigData sdkConfigDataUG = d.uG();
        if (sdkConfigDataUG == null) {
            return null;
        }
        return sdkConfigDataUG.templateConfigMap.rewardReflowConfig;
    }

    public static int gO() {
        return a.qY.getValue().intValue();
    }

    public static String gP() {
        return a.rc.getValue();
    }

    public static int gQ() {
        return a.qZ.getValue().intValue();
    }

    public static boolean gR() {
        return a.rb.getValue().booleanValue();
    }

    public static int gS() {
        return a.ra.getValue().intValue();
    }

    private static boolean gT() {
        return a.re.getValue().intValue() == 1;
    }

    public static float gU() {
        return a.rj.getValue().floatValue();
    }

    public static boolean gV() {
        return a.rj.getValue().floatValue() > 0.0f && a.rj.getValue().floatValue() < 1.0f;
    }

    public static boolean gW() {
        return a.rk.getValue().booleanValue();
    }

    public static long gX() {
        return a.rh.getValue().intValue();
    }

    public static int gY() {
        return a.ri.getValue().intValue();
    }

    public static int gZ() {
        return a.rl.getValue().intValue();
    }

    public static boolean ha() {
        return a.rm.getValue().booleanValue();
    }

    public static boolean hb() {
        return a.rn.getValue().intValue() == 1 || a.rn.getValue().intValue() == 3;
    }

    public static boolean j(AdInfo adInfo) {
        return !k(adInfo) && com.kwad.sdk.core.response.a.a.cm(adInfo) && gT();
    }

    public static boolean k(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.cm(adInfo) && a.rg.getValue().intValue() == 1;
    }

    public static boolean l(AdInfo adInfo) {
        return j(adInfo);
    }
}
