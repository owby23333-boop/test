package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import com.umeng.umcrash.UMCrash;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PathCenter.java */
/* JADX INFO: loaded from: classes4.dex */
public class z {
    public static final String A = "rtd";
    public static final String B = "lepd";
    private static Map<String, String> C = null;
    private static String D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2258a = "env";
    public static final String b = "exp";
    public static final String c = "imp";
    public static final String d = "ua";
    public static final String e = "zc";
    public static final String f = "id";
    public static final String g = "zf";
    public static final String h = "exid";
    public static final String i = "ucc";
    public static final String j = "ugc";
    public static final String k = "usi";
    public static final String l = "uso";
    public static final String m = "user";
    public static final String n = "uspi";
    public static final String o = "dtfn";
    public static final String p = "pr";
    public static final String q = "upg";
    public static final String r = "pri";
    public static final String s = "probe";
    public static final String t = "bl";
    public static final String u = "wl";
    public static final String v = "subp";
    public static final String w = "subua";
    public static final String x = "sta";
    public static final String y = "emi";
    public static final String z = "sli";

    static {
        HashMap map = new HashMap();
        C = map;
        D = "";
        map.put(f2258a, "envelope");
        C.put(b, ".umeng");
        C.put(c, ".imprint");
        C.put(d, "ua.db");
        C.put(e, "umeng_zero_cache.db");
        C.put("id", "umeng_it.cache");
        C.put(g, "umeng_zcfg_flag");
        C.put(h, "exid.dat");
        C.put(i, "umeng_common_config");
        C.put(j, "umeng_general_config");
        C.put(k, UMCrash.KEY_CALLBACK_SESSION_ID);
        C.put(l, "umeng_sp_oaid");
        C.put(m, "mobclick_agent_user_");
        C.put(n, "umeng_subprocess_info");
        C.put(o, "delayed_transmission_flag_new");
        C.put("pr", "umeng_policy_result_flag");
        C.put(q, "um_policy_grant");
        C.put(r, "um_pri");
        C.put(s, "UM_PROBE_DATA");
        C.put("bl", "ekv_bl");
        C.put(u, "ekv_wl");
        C.put(v, e.f2217a);
        C.put(w, "ua_");
        C.put(x, "stateless");
        C.put(y, ".emitter");
        C.put(z, "um_slmode_sp");
        C.put(A, "um_rtd_conf");
        C.put(B, "");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(D)) {
            if (str.length() > 3) {
                D = str.substring(0, 3) + "_";
            } else {
                D = str + "_";
            }
        }
    }

    public void a() {
        D = "";
    }

    public String b(String str) {
        if (!C.containsKey(str)) {
            return "";
        }
        String str2 = C.get(str);
        if (b.equalsIgnoreCase(str) || c.equalsIgnoreCase(str) || y.equalsIgnoreCase(str)) {
            return FileUtils.FILE_EXTENSION_SEPARATOR + D + str2.substring(1);
        }
        return D + str2;
    }

    private z() {
    }

    /* JADX INFO: compiled from: PathCenter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final z f2259a = new z();

        private a() {
        }
    }

    public static z b() {
        return a.f2259a;
    }
}
