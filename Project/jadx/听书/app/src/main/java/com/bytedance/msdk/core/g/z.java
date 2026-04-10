package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final l z = l.z("tt_user_live_day_time", com.bytedance.msdk.core.g.getContext());
    private static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd");
    private static final Calendar dl = Calendar.getInstance();

    public static void z() {
        com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.bytedance.msdk.core.g.g().eo());
        if (com.bytedance.msdk.core.g.g().eo()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strE = e();
            com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(strE)));
            l lVar = z;
            if (lVar.gc(strE)) {
                com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "key=" + strE + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(lVar.g("start_index"))) {
                lVar.z("start_index", strE);
                com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(strE)));
            }
            lVar.z(strE, true);
            lVar.z("user_live_times", lVar.g("user_live_times", 0) + 1);
            String strG = lVar.g("start_index");
            if (!TextUtils.equals(strG, strE)) {
                try {
                    SimpleDateFormat simpleDateFormat = g;
                    Date date = simpleDateFormat.parse(strG);
                    Date date2 = simpleDateFormat.parse(strE);
                    if (date2 == null) {
                        date2 = new Date();
                    }
                    if (date != null) {
                        int iZ = z(date.getTime(), date2.getTime());
                        int iBv = com.bytedance.msdk.core.g.g().bv();
                        if (iBv - iZ < 0) {
                            int i = iZ - iBv;
                            String strZ = z(date, i);
                            if (!TextUtils.isEmpty(strZ)) {
                                lVar.z("start_index", strZ);
                                z(strG, date, i);
                            }
                            com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "old-startIndex:" + strG + ",diff=" + i + ",new-startIndex:" + strZ);
                        }
                    }
                } catch (ParseException e) {
                    com.bytedance.msdk.z.gc.dl.a("AdLoadDynamicParamHandler", "计算生成日期出错：" + e.getMessage());
                }
            } else {
                com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "startDay:" + strG + ",key=" + strE + "，同一天，不处理");
            }
            com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
    }

    private static void z(String str, Date date, int i) {
        if (i == 1) {
            l lVar = z;
            if (lVar.gc(str)) {
                lVar.z("user_live_times", Math.max(lVar.dl("user_live_times") - 1, 0));
            }
            lVar.m(str);
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String strZ = z(date, i2);
            l lVar2 = z;
            if (lVar2.gc(strZ)) {
                lVar2.z("user_live_times", Math.max(lVar2.dl("user_live_times") - 1, 0));
            }
            lVar2.m(strZ);
        }
    }

    public static int g() {
        if (com.bytedance.msdk.core.g.g().eo()) {
            return z.g("user_live_times", 0);
        }
        return -1;
    }

    public static void z(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return;
        }
        z(str, "_dislike_count_");
    }

    public static int g(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return -1;
        }
        return fo(z.g(g(str, "_dislike_count_")));
    }

    public static void dl(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return;
        }
        z(str, "_show_count_");
    }

    public static int a(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return -1;
        }
        return fo(z.g(g(str, "_show_count_")));
    }

    public static void gc(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return;
        }
        z(str, "_click_count_");
    }

    public static int m(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return -1;
        }
        return fo(z.g(g(str, "_click_count_")));
    }

    public static void dl() {
        com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.bytedance.msdk.core.g.g().eo());
        if (com.bytedance.msdk.core.g.g().eo()) {
            z((String) null, "tt_sdk_start_count_");
        }
    }

    public static int a() {
        if (com.bytedance.msdk.core.g.g().eo()) {
            return fo(z.g("tt_sdk_start_count_"));
        }
        return -1;
    }

    public static void e(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return;
        }
        String strG = g(str, "_show_current_time_");
        String strG2 = g(str, "_show_last_time_");
        l lVar = z;
        String strG3 = lVar.g("_show_gap_time_day");
        String strE = e();
        com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + strG + ",lastKey :" + strG2 + ",today:" + strE + ",recordDate:" + strG3);
        if (!TextUtils.equals(strG3, strE)) {
            lVar.z(strG2, 0L);
            lVar.z(strG, System.currentTimeMillis());
            lVar.z("_show_gap_time_day", strE);
        } else {
            lVar.z(strG2, lVar.a(strG));
            lVar.z(strG, System.currentTimeMillis());
        }
    }

    public static long gz(String str) {
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return -1L;
        }
        String strG = g(str, "_show_current_time_");
        String strG2 = g(str, "_show_last_time_");
        l lVar = z;
        if (!TextUtils.equals(lVar.g("_show_gap_time_day"), e())) {
            return 0L;
        }
        if (lVar.a(strG2) == 0) {
            return 0L;
        }
        return Math.round((lVar.a(strG) - r5) / 1000);
    }

    public static int gc() {
        if (com.bytedance.msdk.core.g.g().eo()) {
            return z(com.bytedance.msdk.core.z.kb().dl(), System.currentTimeMillis());
        }
        return -1;
    }

    public static long m() {
        if (!com.bytedance.msdk.core.g.g().eo()) {
            return -1L;
        }
        float fGc = com.bytedance.msdk.core.z.kb().gc() / 60000.0f;
        if (fGc <= 0.0f || fGc >= 1.0f) {
            return Math.round(fGc);
        }
        return 1L;
    }

    private static void z(String str, String str2) {
        String strG = g(str, str2);
        String strE = e();
        l lVar = z;
        String strG2 = lVar.g(strG);
        com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "saveToSpByAction key:" + strG + ",old value:" + strG2);
        int i = 1;
        if (!TextUtils.isEmpty(strG2)) {
            String[] strArrSplit = strG2.split("_");
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(strE, str3)) {
                    i = 1 + Integer.parseInt(strArrSplit[1]);
                    strE = str3;
                }
                strG2 = z(strE, i);
            }
            com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "saveToSpByAction key:" + strG + "，new value：" + strG2);
            lVar.z(strG, strG2);
            return;
        }
        lVar.z(strG, z(strE, 1));
        com.bytedance.msdk.z.gc.dl.g("AdLoadDynamicParamHandler", "saveToSpByAction 首次记录 key:" + strG + "，new value：" + z(strE, 1));
    }

    private static String z(String str, int i) {
        return str + "_" + i;
    }

    private static int fo(String str) {
        String str2;
        if (str == null) {
            return 0;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 2 || (str2 = strArrSplit[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    private static int z(long j, long j2) {
        return Period.between(Instant.ofEpochMilli(j).atZone(ZoneOffset.systemDefault()).toLocalDate(), Instant.ofEpochMilli(j2).atZone(ZoneOffset.systemDefault()).toLocalDate()).getDays();
    }

    private static String g(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str + str2;
    }

    private static String e() {
        return g.format(new Date());
    }

    private static String z(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar calendar = dl;
        calendar.setTime(date);
        calendar.add(5, i);
        return g.format(calendar.getTime());
    }

    public static void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.core.uy.g gVar) {
        if (!com.bytedance.msdk.core.g.g().eo() || list == null || gVar == null) {
            return;
        }
        for (com.bytedance.msdk.g.dl dlVar : list) {
            if (dlVar != null) {
                dlVar.h().put(MediationConstant.KEY_GM_PRIME_RIT, gVar.un());
            }
        }
    }
}
