package com.amgcyo.cuttadon.h.a;

import com.amgcyo.cuttadon.api.entity.config.Intervalminarr;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import java.util.List;

/* JADX INFO: compiled from: TencentUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(int i2, long j2, boolean z2) {
        a(i2, z2, j2);
    }

    public static int b(int i2) {
        Intervalminarr interval_min_arr;
        List<Integer> exemptAd;
        String str;
        int iW = 3 == i2 ? com.amgcyo.cuttadon.utils.otherutils.h.w() : com.amgcyo.cuttadon.utils.otherutils.h.Y();
        g0 g0VarA = g0.a();
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null || (interval_min_arr = mkAppConfigE.getInterval_min_arr()) == null) {
            return iW;
        }
        if (3 == i2) {
            exemptAd = interval_min_arr.getComicsExemptAd();
            str = strB + "conflicts";
        } else {
            exemptAd = interval_min_arr.getExemptAd();
            str = strB + "academic";
        }
        if (exemptAd != null && exemptAd.size() != 0) {
            int iA = g0VarA.a(str, 0);
            for (int i3 = 0; i3 < exemptAd.size(); i3++) {
                if (i3 == iA) {
                    return exemptAd.get(i3).intValue();
                }
            }
            String str2 = "minutes=" + iW + "   ad_list_time=" + exemptAd.get(0) + " " + exemptAd.get(1);
        }
        return iW;
    }

    public static int c(int i2) {
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        String str = strB + "specialized";
        if (3 == i2) {
            str = strB + "awesome";
        }
        return g0.a().a(str, 0);
    }

    public static void d(int i2) {
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        g0 g0VarA = g0.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB = b(i2);
        if (3 == i2) {
            String str = strB + "conflicts";
            g0VarA.b(strB + "prognosticate", ((long) (iB * 60 * 1000)) + jCurrentTimeMillis);
            g0VarA.b(strB + "plenipotentiary", jCurrentTimeMillis);
            int iA = g0VarA.a(str, 0);
            String str2 = "  count:" + iA;
            if (iA < com.amgcyo.cuttadon.utils.otherutils.h.v()) {
                g0VarA.b(str, iA + 1);
                g0VarA.b("value_last_time_comics", iB);
            }
            com.amgcyo.cuttadon.app.o.c.a(true);
            return;
        }
        String str3 = strB + "academic";
        g0VarA.b(strB + "extraordinary", ((long) (iB * 60 * 1000)) + jCurrentTimeMillis);
        g0VarA.b(strB + "soc_remotely", jCurrentTimeMillis);
        int iA2 = g0VarA.a(str3, 0);
        String str4 = "  count:" + iA2;
        if (iA2 < com.amgcyo.cuttadon.utils.otherutils.h.X()) {
            g0VarA.b(str3, iA2 + 1);
            g0VarA.b("value_last_time_novel", iB);
        }
        com.amgcyo.cuttadon.app.o.c.b(true);
    }

    public static void a(int i2, boolean z2) {
        long jA = a(i2);
        if (3 == i2) {
            com.amgcyo.cuttadon.utils.otherutils.g.g(false);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g.j(false);
        }
        String str = "本次时长：" + jA;
        if (com.amgcyo.cuttadon.utils.otherutils.h.q(i2) && jA > 1) {
            jA--;
            String str2 = "因为是预加载，所以本次时长需要减1分钟：" + jA;
        }
        String str3 = "最终时长：" + jA;
        a(i2, z2, jA);
    }

    private static void a(int i2, boolean z2, long j2) {
        int iO = com.amgcyo.cuttadon.utils.otherutils.h.o(i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = " time: " + t0.d(jCurrentTimeMillis);
        boolean z3 = j2 > 0;
        long j3 = (60 * j2 * 1000) + jCurrentTimeMillis;
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        g0 g0VarA = g0.a();
        if (1 == i2) {
            String str2 = "pass:" + t0.d(j3) + " times:" + j3;
            g0VarA.b("extraor_okfyudinary", j3);
            long jA = g0VarA.a("extraor_okfyudinary", 0L);
            String str3 = "更新后的时间:" + t0.d(jA) + " long_time:" + jA;
            g0VarA.b("acco_woks_mplish", z3);
            g0VarA.b("cmkvl_remooptely", jCurrentTimeMillis);
            if (z2) {
                g0VarA.b(strB + "specialized", iO + 1);
                return;
            }
            String str4 = strB + "androidsdkapi18";
            g0VarA.b(str4, g0VarA.a(str4, 1) + 1);
            return;
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.h.k(i2)) && j2 > 0) {
            g0VarA.b("wer_raor_tion_dinary", j3);
            g0VarA.b("poelk_cwompkish", z3);
            g0VarA.b("dklsq_renomtely", jCurrentTimeMillis);
            if (z2) {
                g0VarA.b(strB + "awesome", iO + 1);
                return;
            }
            String str5 = strB + "androidsdkapi18";
            g0VarA.b(str5, g0VarA.a(str5, 1) + 1);
            return;
        }
        g0VarA.b("extraor_okfyudinary", j3);
        g0VarA.b("acco_woks_mplish", z3);
        g0VarA.b("cmkvl_remooptely", jCurrentTimeMillis);
        if (z2) {
            g0VarA.b(strB + "specialized", iO + 1);
            return;
        }
        String str6 = strB + "androidsdkapi18";
        g0VarA.b(str6, g0VarA.a(str6, 1) + 1);
    }

    public static int a(int i2) {
        Intervalminarr interval_min_arr;
        List<Integer> comicsChapterRead;
        int iM = com.amgcyo.cuttadon.utils.otherutils.h.m(i2);
        MkAppConfig mkAppConfigE = com.amgcyo.cuttadon.utils.otherutils.h.e();
        if (mkAppConfigE == null || (interval_min_arr = mkAppConfigE.getInterval_min_arr()) == null) {
            return iM;
        }
        if (i2 == 1) {
            comicsChapterRead = interval_min_arr.getChapterRead();
        } else {
            comicsChapterRead = interval_min_arr.getComicsChapterRead();
        }
        if (comicsChapterRead == null || comicsChapterRead.size() == 0) {
            return iM;
        }
        int iC = c(i2);
        for (int i3 = 0; i3 < comicsChapterRead.size(); i3++) {
            if (i3 == iC) {
                return comicsChapterRead.get(i3).intValue();
            }
        }
        return com.amgcyo.cuttadon.utils.otherutils.h.m(i2);
    }

    public static void a() {
        String str = com.amgcyo.cuttadon.utils.otherutils.g.B() + "count_novel_listener";
        g0.a().b(str, g0.a().a(str, 0) + 1);
    }
}
