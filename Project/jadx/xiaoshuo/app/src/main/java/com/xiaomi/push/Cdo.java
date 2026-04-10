package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.yuewen.eq2;
import com.yuewen.h8;
import com.yuewen.openapi.track.TrackConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.xiaomi.push.do, reason: invalid class name */
/* JADX INFO: loaded from: classes8.dex */
public class Cdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7888a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        SharedPreferences sharedPreferencesM305a = m305a(context);
        long j3 = sharedPreferencesM305a.getLong("start_time_for_day", 0L);
        if (j3 == 0) {
            dl.a("recordDisconnection not initialized");
            return;
        }
        if (j - sharedPreferencesM305a.getLong("last_discnt_time", 0L) < 60000) {
            dl.a("recordDisconnection anti-shake");
            return;
        }
        if (j - j3 < 86400000) {
            int i4 = sharedPreferencesM305a.getInt("discnt_count_in_day", 0);
            if (i4 > 100) {
                dl.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                return;
            } else {
                sharedPreferencesM305a.edit().putInt("discnt_count_in_day", i4 + 1).apply();
            }
        } else {
            dl.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
        }
        int i5 = sharedPreferencesM305a.getInt("discnt_count", 0);
        if (i5 == sharedPreferencesM305a.getInt("cnt_count", 0)) {
            a(context, str, a(z), j, i, j2, i2, str2, i3);
            sharedPreferencesM305a.edit().putLong("last_discnt_time", j).putInt("discnt_count", i5 + 1).apply();
        }
        dl.a("recordDisconnection complete");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m305a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    public static void a(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        ag.a(context).a(new dp(context, str, z, j, i, j2, i2, str2, i3));
    }

    private static void b(Context context) {
        dl.a("resetAfterUpload");
        m305a(context).edit().putString("host", null).putString("network_state", null).putString(h8.d, null).putString("ping_interval", null).putString(TrackConstants.NETWORK_TYPE, null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    public static void a(Context context, long j) {
        ag.a(context).a(new dq(context, j));
    }

    private static void a(Context context, String str, int i, long j, int i2, long j2, int i3, String str2, int i4) {
        dl.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str2, Integer.valueOf(i4)));
        SharedPreferences sharedPreferencesM305a = m305a(context);
        String string = sharedPreferencesM305a.getString("host", null);
        String string2 = sharedPreferencesM305a.getString("network_state", null);
        String string3 = sharedPreferencesM305a.getString(h8.d, null);
        String string4 = sharedPreferencesM305a.getString("ping_interval", null);
        String string5 = sharedPreferencesM305a.getString(TrackConstants.NETWORK_TYPE, null);
        String string6 = sharedPreferencesM305a.getString("wifi_digest", null);
        String string7 = sharedPreferencesM305a.getString("connected_network_type", null);
        String string8 = sharedPreferencesM305a.getString("disconnect_time", null);
        String string9 = sharedPreferencesM305a.getString("xmsf_vc", null);
        String string10 = sharedPreferencesM305a.getString("android_vc", null);
        String strA = a(string, str);
        String strA2 = a(string2, i);
        String strA3 = a(string3, i2);
        String strA4 = a(string4, j2);
        String strA5 = a(string5, i3);
        String strA6 = a(string6, str2);
        String strA7 = a(string7, i4);
        String strA8 = a(string8, j);
        sharedPreferencesM305a.edit().putString("host", strA).putString("network_state", strA2).putString(h8.d, strA3).putString("ping_interval", strA4).putString(TrackConstants.NETWORK_TYPE, strA5).putString("wifi_digest", strA6).putString("connected_network_type", strA7).putString("disconnect_time", strA8).putString("xmsf_vc", a(string9, a(context))).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, long j) {
        SharedPreferences sharedPreferencesM305a = m305a(context);
        long j2 = sharedPreferencesM305a.getLong("start_time_for_day", 0L);
        if (j2 == 0) {
            sharedPreferencesM305a.edit().putLong("start_time_for_day", j).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
            return;
        }
        int i = sharedPreferencesM305a.getInt("discnt_count", 0);
        int i2 = sharedPreferencesM305a.getInt("cnt_count", 0);
        if (i > i2) {
            sharedPreferencesM305a.edit().putInt("cnt_count", i2 + 1).putString("connected_time", a(sharedPreferencesM305a.getString("connected_time", null), j)).apply();
        }
        if (j - j2 >= 86400000) {
            sharedPreferencesM305a.edit().putLong("start_time_for_day", j).putInt("discnt_count_in_day", 0).apply();
            m307a(context);
        } else if (i >= 10) {
            m307a(context);
        }
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = eq2.g;
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    private static String a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    private static String a(String str, long j) {
        return a(str, String.valueOf(j));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m307a(Context context) {
        dl.a("upload");
        new dn().a(context, m306a(context));
        b(context);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static List<dm> m306a(Context context) {
        SharedPreferences sharedPreferencesM305a = m305a(context);
        String[] strArrA = a(sharedPreferencesM305a.getString("host", null));
        if (strArrA != null && strArrA.length > 0) {
            String[] strArrA2 = a(sharedPreferencesM305a.getString("network_state", null));
            String[] strArrA3 = a(sharedPreferencesM305a.getString(h8.d, null));
            String[] strArrA4 = a(sharedPreferencesM305a.getString("ping_interval", null));
            String[] strArrA5 = a(sharedPreferencesM305a.getString(TrackConstants.NETWORK_TYPE, null));
            String[] strArrA6 = a(sharedPreferencesM305a.getString("wifi_digest", null));
            String[] strArrA7 = a(sharedPreferencesM305a.getString("connected_network_type", null));
            String[] strArrA8 = a(sharedPreferencesM305a.getString("disconnect_time", null));
            String[] strArrA9 = a(sharedPreferencesM305a.getString("connected_time", null));
            String[] strArrA10 = a(sharedPreferencesM305a.getString("xmsf_vc", null));
            String[] strArrA11 = a(sharedPreferencesM305a.getString("android_vc", null));
            if (strArrA2 != null && strArrA3 != null && strArrA4 != null && strArrA5 != null && strArrA6 != null && strArrA7 != null && strArrA8 != null && strArrA9 != null && strArrA10 != null && strArrA11 != null && strArrA.length == strArrA2.length && strArrA.length == strArrA3.length && strArrA.length == strArrA4.length && strArrA.length == strArrA5.length && strArrA.length == strArrA6.length && strArrA.length == strArrA7.length && strArrA.length == strArrA8.length && strArrA.length == strArrA9.length && strArrA.length == strArrA10.length && strArrA.length == strArrA11.length) {
                ArrayList arrayList = new ArrayList(strArrA.length);
                int i = 0;
                while (i < strArrA.length) {
                    dm dmVar = new dm();
                    dmVar.a(1);
                    dmVar.a(strArrA[i]);
                    dmVar.b(s.a(strArrA2[i], -1));
                    dmVar.c(s.a(strArrA3[i], -1));
                    String[] strArr = strArrA2;
                    String[] strArr2 = strArrA;
                    ArrayList arrayList2 = arrayList;
                    dmVar.a(s.a(strArrA4[i], -1L));
                    dmVar.d(s.a(strArrA5[i], -1));
                    dmVar.b(strArrA6[i]);
                    dmVar.e(s.a(strArrA7[i], -1));
                    long jA = s.a(strArrA8[i], -1L);
                    long jA2 = s.a(strArrA9[i], -1L);
                    dmVar.b(jA2 - jA);
                    dmVar.c(jA);
                    dmVar.d(jA2);
                    dmVar.f(s.a(strArrA10[i], -1));
                    dmVar.g(s.a(strArrA11[i], -1));
                    arrayList2.add(dmVar);
                    i++;
                    strArrA2 = strArr;
                    arrayList = arrayList2;
                    strArrA4 = strArrA4;
                    strArrA3 = strArrA3;
                    strArrA = strArr2;
                    strArrA5 = strArrA5;
                }
                return arrayList;
            }
            com.xiaomi.channel.commonutils.logger.b.m106a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m106a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    private static int a(Context context) {
        if (f7888a <= 0) {
            f7888a = j.b(context);
        }
        return f7888a;
    }
}
