package com.amgcyo.cuttadon.sdk.utils;

import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.bytedance.msdk.api.UIUtils;
import java.util.List;

/* JADX INFO: compiled from: AdStatusUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static NormalAdParams a(String str, String str2) {
        List<BaseAd> listA = a(str);
        if (listA == null) {
            return null;
        }
        BaseAd baseAdA = com.amgcyo.cuttadon.app.o.c.a(str, listA);
        if (baseAdA == null) {
            String str3 = str + " 没有配置广告";
        }
        if (baseAdA == null) {
            return null;
        }
        NormalAdParams normalAdParams = new NormalAdParams(str, str2);
        normalAdParams.setBaseAd(baseAdA);
        return normalAdParams;
    }

    public static BaseAd b(String str, String str2) {
        String str3 = str + " beanType： " + str2;
        List<BaseAd> listB = h.b(str2);
        if (listB == null) {
            return null;
        }
        Integer.valueOf(listB.size());
        BaseAd baseAdC = com.amgcyo.cuttadon.app.o.c.c(str, listB);
        if (baseAdC == null) {
            String str4 = str + " 没有配置广告";
        }
        if (baseAdC != null) {
            baseAdC.setStochasticKey(str);
            baseAdC.setNoExempt(true);
        }
        return baseAdC;
    }

    public static NormalAdParams c(String str) {
        return a(str, "csj_new_position_book_city");
    }

    public static NormalAdParams d(String str) {
        return a(str, "position_unlock_comic");
    }

    public static NormalAdParams c() {
        NormalAdParams normalAdParamsA = a("position_page_ad", "csj_new_position_read_page", 1);
        if (normalAdParamsA != null) {
            normalAdParamsA.setAdWidth(((int) UIUtils.getScreenWidthDp(MkApplication.getAppContext())) - 20);
            String str = "宽度：" + normalAdParamsA.getAdWidth();
        }
        return normalAdParamsA;
    }

    public static NormalAdParams a(String str, String str2, int i2) {
        List<BaseAd> listA = a(str);
        if (listA == null) {
            return null;
        }
        BaseAd baseAdA = com.amgcyo.cuttadon.app.o.c.a(str, listA, i2, true);
        if (baseAdA == null) {
            String str3 = str + " 没有配置广告";
        }
        if (baseAdA == null) {
            return null;
        }
        NormalAdParams normalAdParams = new NormalAdParams(str, str2, i2);
        normalAdParams.setBaseAd(baseAdA);
        return normalAdParams;
    }

    public static NormalAdParams b(String str) {
        NormalAdParams normalAdParamsA = a(str, "csj_new_position_book_city");
        if (normalAdParamsA != null) {
            int iA = g0.a().a("key_city_sex_width", 0);
            String str2 = "adWidth:" + iA;
            normalAdParamsA.setAdWidth(iA);
        }
        return normalAdParamsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01aa  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.amgcyo.cuttadon.api.entity.config.BaseAd> a(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.utils.e.a(java.lang.String):java.util.List");
    }

    public static NormalAdParams b() {
        NormalAdParams normalAdParamsA = a("comics_position_page_ad", "csj_new_position_read_page_comics", 3);
        if (normalAdParamsA != null) {
            normalAdParamsA.setAdWidth(((int) UIUtils.getScreenWidthDp(MkApplication.getAppContext())) - 20);
        }
        return normalAdParamsA;
    }

    public static NormalAdParams a() {
        NormalAdParams normalAdParamsA = a("comics_position_end_ad", "csj_new_position_read_end_comics", 3);
        if (normalAdParamsA != null) {
            normalAdParamsA.setAdWidth(((int) UIUtils.getScreenWidthDp(MkApplication.getAppContext())) - 20);
        }
        return normalAdParamsA;
    }
}
