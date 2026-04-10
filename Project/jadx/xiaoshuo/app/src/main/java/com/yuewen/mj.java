package com.yuewen;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.reader.BaseEnv;

/* JADX INFO: loaded from: classes3.dex */
public abstract class mj {
    public static final String d = "/phone/";
    public static final String e = "index.html";
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final String i = "server_config_key";
    public static final String j = "server_config_url";
    public static final String k = "server_test_url";
    public static final String l = "http://";
    public static final String m = "https://";
    public static final String n = "https://distribute.dangdang.com";
    public static kv3<mj> o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseEnv f14388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g72 f14389b;
    public String c = null;

    public mj(BaseEnv baseEnv, g72 g72Var) {
        this.f14388a = baseEnv;
        this.f14389b = g72Var;
    }

    public static String C() {
        return "https://www.duokan.com/c/permit";
    }

    public static boolean N(Context context) {
        String strS = s(context);
        return TextUtils.isEmpty(strS) || strS.startsWith("OFREE");
    }

    public static void P(kv3<mj> kv3Var) {
        o = kv3Var;
    }

    public static mj a() {
        kv3<mj> kv3Var = o;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static String s(Context context) {
        return (String) n50.h(context, "DK_DIST_CHANNEL");
    }

    public static String w() {
        return ko0.U().F() + "/app/privacy/privacyPolicyV1.html?version=2";
    }

    public final String A() {
        return F() + "/app/search/result";
    }

    public abstract int B();

    public abstract String D();

    public abstract String E();

    public abstract String F();

    public abstract String G();

    public String H() {
        return "https://privacy.mi.com/duokan-kids/zh_CN/";
    }

    public String I() {
        return L() ? "https://" : "http://";
    }

    public void J() {
    }

    public abstract boolean K();

    public abstract boolean L();

    public abstract boolean M();

    public boolean O() {
        return !L();
    }

    public String Q() {
        if (!L()) {
            BaseEnv baseEnv = this.f14388a;
            BaseEnv.PrivatePref privatePref = BaseEnv.PrivatePref.STORE;
            if (!TextUtils.isEmpty(baseEnv.e1(privatePref, j, ""))) {
                String strE1 = this.f14388a.e1(privatePref, j, "");
                return strE1.startsWith("http://") ? strE1.substring(7) : strE1.startsWith("https://") ? strE1.substring(8) : strE1;
            }
        }
        return "";
    }

    public String R() {
        String strQ = Q();
        return !TextUtils.isEmpty(strQ) ? strQ : this.c;
    }

    public String S() {
        return I() + R();
    }

    public String T(String str) {
        return m94.a(m94.r(S() + d), "path=" + str).toString();
    }

    public abstract String b();

    public String d() {
        return F() + "/dk_id/api/install/signature";
    }

    public v52<String> g(String[] strArr) {
        return null;
    }

    public abstract String i();

    public String n(String str) {
        return F() + "/hs/feed/" + str;
    }

    public String o() {
        return "https://www.duokan.com";
    }

    public abstract String t(String str);

    public String u() {
        return m94.r(S() + "/free/fe/personal").toString();
    }

    public abstract String x();

    public final String y() {
        return F() + "/app/search";
    }
}
