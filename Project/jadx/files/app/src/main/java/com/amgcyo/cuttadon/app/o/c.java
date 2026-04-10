package com.amgcyo.cuttadon.app.o;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.Intervalminarr;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.h.a.i;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import me.jessyan.art.base.QDTCProtect;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QDTCUtils.java */
/* JADX INFO: loaded from: classes.dex */
@QDTCProtect
public class c {
    public static void a(int i2) {
        com.amgcyo.cuttadon.utils.comic.d.a("extraordinary", Integer.valueOf(i2));
    }

    private static void a(Exception exc) {
    }

    public static void b(int i2) {
        com.amgcyo.cuttadon.utils.comic.d.a("insignificant", Integer.valueOf(i2));
    }

    public static String c() {
        String strF = g.f(MkApplication.getAppContext());
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        try {
            return g.D(h.t());
        } catch (NoSuchAlgorithmException unused) {
            return NoSuchAlgorithmException.class.getName();
        }
    }

    public static int d() {
        Intervalminarr interval_min_arr;
        List<Integer> listeningBook;
        int iT = h.T();
        g0 g0VarA = g0.a();
        String strB = g.B();
        MkAppConfig mkAppConfigE = h.e();
        if (mkAppConfigE == null || (interval_min_arr = mkAppConfigE.getInterval_min_arr()) == null || (listeningBook = interval_min_arr.getListeningBook()) == null || listeningBook.size() == 0) {
            return iT;
        }
        int iA = g0VarA.a(strB + "count_novel_listener", 0);
        for (int i2 = 0; i2 < listeningBook.size(); i2++) {
            if (i2 == iA) {
                return listeningBook.get(i2).intValue();
            }
        }
        return h.T();
    }

    public static boolean e() {
        return g0.a().a(g.B() + "exaggeration", false);
    }

    public static boolean f() {
        return g0.a().a(g.B() + "accomplish", false);
    }

    public static int g() {
        return com.amgcyo.cuttadon.utils.comic.d.a("insignificant", 0).intValue();
    }

    public static boolean h() {
        if (!h.K0()) {
            return false;
        }
        int iA0 = h.a0();
        int iB0 = h.b0();
        int iG = g();
        long jA = g.A();
        String str = "noviceCount：" + iA0 + " noviceRead " + iB0 + " sp_startCount " + iG + " sp_readingTime " + jA;
        return (iA0 <= 0 || iB0 != 0) ? (iB0 <= 0 || iA0 != 0) ? iA0 > 0 && iB0 > 0 && iG >= iA0 && jA >= ((long) iB0) : jA >= ((long) iB0) : iG >= iA0;
    }

    public static boolean i() {
        String strB = g.B();
        g0 g0VarA = g0.a();
        try {
            long jA = g0VarA.a(strB + "prognosticate", 0L);
            long jA2 = g0VarA.a(strB + "plenipotentiary", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = "漫画免广告模块 当前时间：" + t0.d(jCurrentTimeMillis) + " 》》》" + jCurrentTimeMillis + "\n过期时间：" + t0.d(jA) + " 》》》" + jA + "\n兑换的时间：" + t0.d(jA2) + " 》》》" + jA2;
            if (jA2 <= 0 || jCurrentTimeMillis <= jA2 || jA <= 0) {
                return false;
            }
            long j2 = jA - jCurrentTimeMillis;
            String str2 = "免除广告：long_time: " + jA + " result_time: " + j2;
            if (j2 > 1) {
                return e();
            }
            return false;
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    public static boolean j() {
        String strB = g.B();
        try {
            long jA = g0.a().a(strB + "extraordinary", 0L);
            long jA2 = g0.a().a(strB + "soc_remotely", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = "小说免广告模块 当前时间：" + t0.d(jCurrentTimeMillis) + "\n过期时间：" + t0.d(jA) + "\n兑换的时间：" + t0.d(jA2);
            if (jCurrentTimeMillis <= jA2 || jA - jCurrentTimeMillis <= 1) {
                return false;
            }
            return f();
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    private static boolean k() {
        if (h()) {
            return g.c();
        }
        return true;
    }

    public static boolean l() {
        try {
            long jA = g0.a().a("therapeutic", 0L);
            long jA2 = g0.a().a("thera_focus_peutic", 0L);
            boolean zA = g0.a().a("contractive", false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = "当前时间：" + t0.d(jCurrentTimeMillis) + " 过期时间：" + t0.d(jA) + " 用户听书的那个时间：" + t0.d(jA2);
            if (jCurrentTimeMillis <= jA2) {
                return false;
            }
            long j2 = jA - jCurrentTimeMillis;
            StringBuilder sb = new StringBuilder();
            sb.append("免除广告：long_time: ");
            sb.append(jA);
            sb.append(" reward: ");
            sb.append(zA);
            sb.append(" result_time: ");
            sb.append(j2);
            sb.append(" result: ");
            sb.append(j2 > 1 && zA);
            sb.toString();
            return j2 > 1 && zA;
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    public static int a() {
        return com.amgcyo.cuttadon.utils.comic.d.a("extraordinary").intValue();
    }

    public static long b() {
        return com.amgcyo.cuttadon.utils.comic.d.b("stimulate").longValue();
    }

    public static void a(long j2) {
        com.amgcyo.cuttadon.utils.comic.d.a("stimulate", Long.valueOf(j2));
    }

    @Nullable
    private static BaseAd b(String str, List<BaseAd> list) {
        BaseAd baseAd;
        if (g.a(list)) {
            String str2 = str + " 没有集合";
            return null;
        }
        int size = list.size();
        if (size == 1) {
            String str3 = str + " 只有一个";
            return list.get(0);
        }
        int iIntValue = com.amgcyo.cuttadon.utils.comic.d.a(str, 0).intValue();
        String str4 = str + " size：" + size + " platformCount " + iIntValue;
        try {
            baseAd = list.get(iIntValue);
            if (baseAd != null) {
                com.amgcyo.cuttadon.utils.comic.d.a(str, Integer.valueOf(iIntValue + 1));
            }
        } catch (Exception unused) {
            baseAd = list.get(0);
            if (baseAd != null) {
                com.amgcyo.cuttadon.utils.comic.d.a(str, (Object) 1);
            }
        }
        if (baseAd != null) {
            baseAd.setStochasticKey(str);
            baseAd.toString();
        }
        return baseAd;
    }

    public static NewApiAd a(String[] strArr, int i2, boolean... zArr) {
        NewApiAdList newApiAdListB;
        List<NewApiAd> type_1;
        String str;
        NewApiAd newApiAd;
        boolean z2 = (zArr == null || zArr.length <= 0) ? false : zArr[0];
        Boolean.valueOf(z2);
        if ((!z2 && k()) || (newApiAdListB = h.b()) == null) {
            return null;
        }
        String str2 = "位置：" + strArr[1] + " 广告类型：" + i2;
        switch (i2) {
            case 1:
                type_1 = newApiAdListB.getType_1();
                str = "闪屏";
                break;
            case 2:
                type_1 = newApiAdListB.getType_2();
                str = "banner";
                break;
            case 3:
                type_1 = newApiAdListB.getType_3();
                str = "插屏";
                break;
            case 4:
                type_1 = newApiAdListB.getType_4();
                str = "左图右文大";
                break;
            case 5:
                type_1 = newApiAdListB.getType_5();
                str = "上文下图";
                break;
            case 6:
                type_1 = newApiAdListB.getType_6();
                str = "玩一玩";
                break;
            case 7:
                type_1 = newApiAdListB.getType_7();
                str = "左图右文小";
                break;
            case 8:
                type_1 = newApiAdListB.getType_8();
                str = "激励视频";
                break;
            case 9:
                type_1 = newApiAdListB.getType_9();
                str = "全屏视频";
                break;
            default:
                str = "";
                type_1 = null;
                break;
        }
        if (g.a(type_1)) {
            String str3 = strArr[0] + " 没有一个ad集合";
            return null;
        }
        int size = type_1.size();
        if (size == 1) {
            String str4 = strArr[0] + " 只有一个";
            return type_1.get(0);
        }
        g0 g0VarA = g0.a();
        int iA = g0VarA.a(strArr[0], 0);
        String str5 = strArr[0] + " size：" + size + " platformCount " + iA;
        try {
            newApiAd = type_1.get(iA);
            if (newApiAd != null) {
                g0VarA.b(strArr[0], iA + 1);
            }
        } catch (Exception unused) {
            newApiAd = type_1.get(0);
            if (newApiAd != null) {
                g0VarA.b(strArr[0], 1);
            }
        }
        if (newApiAd != null) {
            newApiAd.setOwnerType(str);
            newApiAd.setLocation(strArr[1]);
            newApiAd.toString();
        }
        return newApiAd;
    }

    public static boolean c(int i2) {
        long jA;
        long jA2;
        boolean zA;
        if (!h() || g.c()) {
            return true;
        }
        try {
            if (1 == i2) {
                jA = g0.a().a("extraor_okfyudinary", 0L);
                jA2 = g0.a().a("cmkvl_remooptely", 0L);
                zA = g0.a().a("acco_woks_mplish", false);
            } else {
                List<BaseAd> listK = h.k(i2);
                int iA = i.a(i2);
                if (!g.a(listK) && iA > 0) {
                    jA = g0.a().a("wer_raor_tion_dinary", 0L);
                    jA2 = g0.a().a("dklsq_renomtely", 0L);
                    zA = g0.a().a("poelk_cwompkish", false);
                } else {
                    jA = g0.a().a("extraor_okfyudinary", 0L);
                    jA2 = g0.a().a("cmkvl_remooptely", 0L);
                    zA = g0.a().a("acco_woks_mplish", false);
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = "当前时间：" + t0.d(jCurrentTimeMillis) + " 过期时间：" + t0.d(jA) + " 用户解锁的那个时间：" + t0.d(jA2);
            return jCurrentTimeMillis > jA2 && jA - jCurrentTimeMillis > 1 && zA;
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    public static void b(boolean z2) {
        g0.a().b(g.B() + "accomplish", z2);
    }

    public static BaseAd c(String str, List<BaseAd> list) {
        if (g.a(list)) {
            return null;
        }
        return b(str, list);
    }

    public static NewApiAd a(String[] strArr) {
        NewApiAd newApiAd = null;
        if (k()) {
            return null;
        }
        NewApiAdList newApiAdListB = h.b();
        if (newApiAdListB != null && strArr != null) {
            List<NewApiAd> type_6 = newApiAdListB.getType_6();
            if (g.a(type_6)) {
                return null;
            }
            int size = type_6.size();
            if (size == 1) {
                String str = strArr[0] + " 只有一个 ";
                return type_6.get(0);
            }
            g0 g0VarA = g0.a();
            int iA = g0VarA.a(strArr[0], 0);
            String str2 = strArr[0] + " size：" + size + " platformCount " + iA;
            try {
                newApiAd = type_6.get(iA);
                if (newApiAd != null) {
                    g0VarA.b(strArr[0], iA + 1);
                }
            } catch (Exception unused) {
                newApiAd = type_6.get(0);
                if (newApiAd != null) {
                    g0VarA.b(strArr[0], 1);
                }
            }
            if (newApiAd != null) {
                newApiAd.setOwnerType("玩一玩");
                newApiAd.setLocation(strArr[1]);
                newApiAd.toString();
            }
        }
        return newApiAd;
    }

    public static BaseAd a(String str, List<BaseAd> list) {
        if (a(list)) {
            return null;
        }
        return b(str, list);
    }

    public static BaseAd a(String str, List<BaseAd> list, int i2, boolean z2) {
        if (a(list)) {
            return null;
        }
        if (z2) {
            if (1 == i2) {
                if (j()) {
                    return null;
                }
            } else if (3 == i2 && i()) {
                return null;
            }
        }
        return b(str, list);
    }

    private static boolean a(List<BaseAd> list) {
        if (!h() || g.a(list)) {
            return true;
        }
        return g.c();
    }

    public static void a(boolean z2) {
        g0.a().b(g.B() + "exaggeration", z2);
    }
}
