package com.amgcyo.cuttadon.sdk.utils;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.umeng.analytics.pro.cb;
import java.util.List;

/* JADX INFO: compiled from: ArtStochasticUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static BaseStochasticBean a(String str) {
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "beanType:" + str;
        byte b = -1;
        switch (str.hashCode()) {
            case -2077523332:
                if (str.equals("comics_exempt_ad")) {
                    b = 2;
                }
                break;
            case -1943924888:
                if (str.equals("welfare_center")) {
                    b = 3;
                }
                break;
            case -1497070673:
                if (str.equals("awaken_err")) {
                    b = cb.f19602k;
                }
                break;
            case -1405044855:
                if (str.equals("awaken")) {
                    b = 12;
                }
                break;
            case -1294651075:
                if (str.equals("err_ad")) {
                    b = 4;
                }
                break;
            case -1112854091:
                if (str.equals("comment_lists")) {
                    b = 17;
                }
                break;
            case -906336856:
                if (str.equals("search")) {
                    b = cb.f19605n;
                }
                break;
            case -809311101:
                if (str.equals("exempt_ad")) {
                    b = 1;
                }
                break;
            case -691808278:
                if (str.equals("splash_screen_err")) {
                    b = 11;
                }
                break;
            case -129775084:
                if (str.equals("err_phone")) {
                    b = 5;
                }
                break;
            case 3492908:
                if (str.equals("rank")) {
                    b = cb.f19604m;
                }
                break;
            case 102982549:
                if (str.equals("lists")) {
                    b = cb.f19603l;
                }
                break;
            case 477192516:
                if (str.equals("splash_screen")) {
                    b = 10;
                }
                break;
            case 731074541:
                if (str.equals("listening_book")) {
                    b = 7;
                }
                break;
            case 733276831:
                if (str.equals("asking_book")) {
                    b = 8;
                }
                break;
            case 1461956363:
                if (str.equals("video_add_book")) {
                    b = 9;
                }
                break;
            case 1655879077:
                if (str.equals("down_cache")) {
                    b = 6;
                }
                break;
        }
        switch (b) {
            case 1:
                return mkAppConfigE.getExempt_ad();
            case 2:
                return mkAppConfigE.getComics_exempt_ad();
            case 3:
                return mkAppConfigE.getWelfare_center();
            case 4:
                return mkAppConfigE.getErr_ad();
            case 5:
                return mkAppConfigE.getErr_phone();
            case 6:
                Boolean.valueOf(mkAppConfigE.getDown_cache() == null);
                return mkAppConfigE.getDown_cache();
            case 7:
                return mkAppConfigE.getListening_book();
            case 8:
                return mkAppConfigE.getAsking_book();
            case 9:
                return mkAppConfigE.getVideo_add_book();
            case 10:
                return mkAppConfigE.getSplash_screen();
            case 11:
                return mkAppConfigE.getSplash_screen_err();
            case 12:
                return mkAppConfigE.getAwaken();
            case 13:
                return mkAppConfigE.getAwaken_err();
            case 14:
                return mkAppConfigE.getLists();
            case 15:
                return mkAppConfigE.getRank();
            case 16:
                return mkAppConfigE.getSearch();
            case 17:
                return mkAppConfigE.getComment_lists();
            default:
                return null;
        }
    }

    public static List<BaseAd> b(String str) {
        BaseStochasticBean baseStochasticBeanA = a(str);
        if (baseStochasticBeanA == null) {
            return null;
        }
        return baseStochasticBeanA.getStochastic();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r3, java.lang.String r4) {
        /*
            com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean r3 = a(r3)
            r0 = 0
            if (r3 != 0) goto L8
            return r0
        L8:
            r1 = -1
            int r2 = r4.hashCode()
            switch(r2) {
                case -1569533992: goto L5a;
                case -907987547: goto L50;
                case -906279820: goto L46;
                case -797691627: goto L3c;
                case -407761836: goto L31;
                case 328626161: goto L27;
                case 1370701899: goto L1c;
                case 1394351761: goto L11;
                default: goto L10;
            }
        L10:
            goto L64
        L11:
            java.lang.String r2 = "today_count"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 3
            goto L65
        L1c:
            java.lang.String r2 = "video_count"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 6
            goto L65
        L27:
            java.lang.String r2 = "add_count"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 4
            goto L65
        L31:
            java.lang.String r2 = "total_count"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 2
            goto L65
        L3c:
            java.lang.String r2 = "interval_count"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 1
            goto L65
        L46:
            java.lang.String r2 = "second"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 5
            goto L65
        L50:
            java.lang.String r2 = "scheme"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 7
            goto L65
        L5a:
            java.lang.String r2 = "interval_min"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L64
            r4 = 0
            goto L65
        L64:
            r4 = -1
        L65:
            switch(r4) {
                case 0: goto L8c;
                case 1: goto L87;
                case 2: goto L82;
                case 3: goto L7d;
                case 4: goto L78;
                case 5: goto L73;
                case 6: goto L6e;
                case 7: goto L69;
                default: goto L68;
            }
        L68:
            goto L90
        L69:
            int r0 = r3.getScheme()
            goto L90
        L6e:
            int r0 = r3.getVideo_count()
            goto L90
        L73:
            int r0 = r3.getSecond()
            goto L90
        L78:
            int r0 = r3.getAdd_count()
            goto L90
        L7d:
            int r0 = r3.getToday_count()
            goto L90
        L82:
            int r0 = r3.getTotal_count()
            goto L90
        L87:
            int r0 = r3.getInterval_count()
            goto L90
        L8c:
            int r0 = r3.getInterval_min()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.sdk.utils.h.a(java.lang.String, java.lang.String):int");
    }
}
