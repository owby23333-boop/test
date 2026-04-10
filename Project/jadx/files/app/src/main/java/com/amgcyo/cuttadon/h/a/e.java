package com.amgcyo.cuttadon.h.a;

import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g0;

/* JADX INFO: compiled from: AllAdClickUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a() {
        int iA = com.amgcyo.cuttadon.sdk.utils.g.a("no_network_type");
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        String str = "continue_type:" + iA + " preName: " + strB;
        if (iA == 2) {
            int iA2 = g0.a().a(strB + "today_all_click_ad_total_count", 0);
            String str2 = "today_all_click_ad_total_count:" + iA2;
            if (iA2 < 2) {
                int iA3 = g0.a().a("click_ad_to_continue", 0);
                if (iA3 <= 1) {
                    iA3 = 3;
                }
                int iA4 = g0.a().a(strB + "today_click_ad_count", 0) + 1;
                g0.a().b(strB + "today_click_ad_count", iA4);
                int iA5 = g0.a().a("continue_read_count", 0);
                String str3 = "today_click_ad_count:" + iA4 + " click_ad_to_continue " + iA3;
                if (iA4 == 0 || iA4 % iA3 != 0) {
                    return;
                }
                g0.a().b(strB + "today_all_click_ad_total_count", iA2 + 1);
                g0.a().b("continue_read_count", iA5 + 1);
                o.f("恭喜通过点击广告获得1次无网情况下继续阅读次数");
            }
        }
    }
}
