package com.amgcyo.cuttadon.sdk.utils;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean;
import com.amgcyo.cuttadon.api.entity.config.BookTCBAdBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import java.util.List;

/* JADX INFO: compiled from: JsonBooAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static BookTCBAdBean a(String str) {
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null || TextUtils.isEmpty(str)) {
            return null;
        }
        switch (str) {
            case "bookself":
                return mkAppConfigE.getBookself();
            case "book":
                return mkAppConfigE.getBook();
            case "book_city":
                return mkAppConfigE.getBook_city();
            case "book_city_male":
                return mkAppConfigE.getBook_city_male();
            case "book_city_female":
                return mkAppConfigE.getBook_city_female();
            case "book_city_end":
                return mkAppConfigE.getBook_city_end();
            case "book_city_classification":
                return mkAppConfigE.getBook_city_classification();
            default:
                return null;
        }
    }

    public static List<BaseAd> b(String str, String str2, String str3) {
        BaseStochasticBean table_plaque;
        BookTCBAdBean bookTCBAdBeanA = a(str2);
        if (bookTCBAdBeanA == null || (table_plaque = bookTCBAdBeanA.getTable_plaque()) == null) {
            return null;
        }
        String str4 = str2 + "_suffix";
        g0 g0VarA = g0.a();
        int iA = g0VarA.a(str4, 3);
        String str5 = "shelfChapingAdCount:" + iA;
        int iA2 = a(str, str2, str3);
        String str6 = "interval_count:" + iA2;
        g0VarA.b(str4, iA + 1);
        String str7 = "插屏集合：" + com.amgcyo.cuttadon.utils.otherutils.g.b(table_plaque.getStochastic());
        if (iA2 == 0 || iA % iA2 != 0) {
            return null;
        }
        return table_plaque.getStochastic();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static List<BaseAd> a(String str, String str2) {
        BaseStochasticBean index;
        BookTCBAdBean bookTCBAdBeanA = a(str);
        if (bookTCBAdBeanA == null) {
            return null;
        }
        byte b = -1;
        switch (str2.hashCode()) {
            case -1383228885:
                if (str2.equals("bottom")) {
                    b = 2;
                }
                break;
            case -1364013995:
                if (str2.equals("center")) {
                    b = 1;
                }
                break;
            case -896505829:
                if (str2.equals("source")) {
                    b = 3;
                }
                break;
            case 115029:
                if (str2.equals("top")) {
                    b = 0;
                }
                break;
            case 100346066:
                if (str2.equals("index")) {
                    b = 4;
                }
                break;
        }
        if (b == 0) {
            BaseStochasticBean top = bookTCBAdBeanA.getTop();
            if (top != null) {
                return top.getStochastic();
            }
            return null;
        }
        if (b == 1) {
            BaseStochasticBean center = bookTCBAdBeanA.getCenter();
            if (center != null) {
                return center.getStochastic();
            }
            return null;
        }
        if (b == 2) {
            BaseStochasticBean bottom = bookTCBAdBeanA.getBottom();
            if (bottom != null) {
                return bottom.getStochastic();
            }
            return null;
        }
        if (b != 3) {
            if (b == 4 && (index = bookTCBAdBeanA.getIndex()) != null) {
                return index.getStochastic();
            }
            return null;
        }
        BaseStochasticBean source = bookTCBAdBeanA.getSource();
        if (source != null) {
            return source.getStochastic();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.utils.i.a(java.lang.String, java.lang.String, java.lang.String):int");
    }
}
