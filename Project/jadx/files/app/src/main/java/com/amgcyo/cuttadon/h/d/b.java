package com.amgcyo.cuttadon.h.d;

import android.app.Activity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.h.a.f;
import com.amgcyo.cuttadon.h.d.e.e;
import com.amgcyo.cuttadon.h.d.e.i;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.sdk.utils.d;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.bytedance.msdk.api.UIUtils;

/* JADX INFO: compiled from: GmUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Activity activity, String str, com.amgcyo.cuttadon.h.f.b bVar) {
        new i().a(activity, str, bVar);
    }

    private static void b(Activity activity, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout, String str) {
        String strJ = d.j(str);
        if (g.p(strJ)) {
            normalAdParams.setAdUnitId(strJ);
            new com.amgcyo.cuttadon.h.d.e.g(activity).a(normalAdParams, (c) null, adFrameLayout);
        }
    }

    public static void a(Activity activity, BaseAd baseAd, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        int style = baseAd.getStyle();
        int adWidth = normalAdParams.getAdWidth();
        int screenWidthDp = (int) UIUtils.getScreenWidthDp(activity);
        if (adWidth <= 0) {
            normalAdParams.setAdWidth(screenWidthDp);
        }
        if (style == 2) {
            b(activity, normalAdParams, adFrameLayout, "b");
            return;
        }
        if (style == 3) {
            b(activity, normalAdParams, adFrameLayout, "c");
            return;
        }
        if (style == 4) {
            b(activity, normalAdParams, adFrameLayout, "d");
            return;
        }
        if (style == 7) {
            normalAdParams.setAdHeight(f.b(screenWidthDp));
            a(activity, normalAdParams, adFrameLayout, "h");
        } else if (style == 8) {
            normalAdParams.setAdHeight((int) (screenWidthDp / 1.2f));
            a(activity, normalAdParams, adFrameLayout, "i");
        } else {
            String str = "暂不支持的广告style: " + style;
        }
    }

    private static void a(Activity activity, NormalAdParams normalAdParams, AdFrameLayout adFrameLayout, String str) {
        String strJ = d.j(str);
        String str2 = "unitId:" + strJ;
        if (g.p(strJ)) {
            normalAdParams.setAdUnitId(strJ);
            new e(activity).a(normalAdParams, (c) null, adFrameLayout);
        }
    }
}
