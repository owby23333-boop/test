package com.amgcyo.cuttadon.h.i;

import android.app.Activity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.bytedance.msdk.api.UIUtils;

/* JADX INFO: compiled from: ToponAdTools.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends f {
    public static void a(Activity activity, BaseAd baseAd, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        int style = baseAd.getStyle();
        int adWidth = normalAdParams.getAdWidth();
        String str = "adWidth:" + adWidth + " screenHeightPx: " + n.a(activity);
        if (adWidth <= 0) {
            adWidth = (int) UIUtils.getScreenWidthDp(activity);
            String str2 = "没有设置过宽度，重新设置一下，adWidth:" + adWidth;
        }
        int iA = n.a(adWidth);
        String str3 = " screenWidthPx: " + iA;
        normalAdParams.setAdWidth(iA);
        if (style == 2) {
            normalAdParams.setAdHeight((int) (iA / 3.0f));
            b(activity, normalAdParams, adFrameLayout, "b");
            return;
        }
        if (style == 3) {
            normalAdParams.setAdHeight((int) (iA / 5.0f));
            b(activity, normalAdParams, adFrameLayout, "c");
            return;
        }
        if (style == 6) {
            normalAdParams.setAdHeight((int) (iA / 6.7f));
            a(activity, normalAdParams, adFrameLayout, "g");
        } else if (style == 7) {
            normalAdParams.setAdHeight((int) (iA / 2.0f));
            a(activity, normalAdParams, adFrameLayout, "f");
        } else {
            String str4 = "暂不支持的广告style: " + style;
        }
    }

    private static void b(Activity activity, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout, String str) {
        String strP = com.amgcyo.cuttadon.sdk.utils.d.p(str);
        String str2 = "xinxiliu unitId:" + strP;
        if (g.p(strP)) {
            normalAdParams.setAdUnitId(strP);
            new d(activity).a(normalAdParams, adFrameLayout);
        }
    }

    private static void a(Activity activity, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout, String str) {
        String strP = com.amgcyo.cuttadon.sdk.utils.d.p(str);
        String str2 = "banner unitId:" + strP;
        if (g.p(strP)) {
            normalAdParams.setAdUnitId(strP);
            new c(activity).a(normalAdParams, adFrameLayout);
        }
    }
}
