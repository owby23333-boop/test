package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class aa {
    private static final Map<String, String> W = new HashMap();
    private static aa aq = null;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public String H;
    public boolean J;
    public final SharedPreferences O;
    public final SharedPreferences P;
    private final Context X;
    private String Y;
    private String Z;
    private String aa;
    private String aj;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18473e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18479k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f18483o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18484p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f18485q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f18486r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f18487s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<String> f18490v;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18474f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18475g = "com.tencent.bugly";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18476h = "4.1.9";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18477i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public final String f18478j = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18480l = "unknown";
    private String ab = "unknown";
    private String ac = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f18481m = 0;
    private String ad = null;
    private long ae = -1;
    private long af = -1;
    private long ag = -1;
    private String ah = null;
    private String ai = null;
    private Map<String, PlugInBean> ak = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18482n = false;
    private String al = null;
    private Boolean am = null;
    private String an = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f18488t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18489u = null;
    private Map<String, PlugInBean> ao = null;
    private Map<String, PlugInBean> ap = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f18491w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f18492x = -1;
    private final Map<String, String> ar = new HashMap();
    private final Map<String, String> as = new HashMap();
    private final Map<String, String> at = new HashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f18493y = "unknown";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f18494z = 0;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public boolean I = false;
    public HashMap<String, String> K = new HashMap<>();
    public List<String> L = new ArrayList();
    public boolean M = false;
    public q N = null;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    private final Object au = new Object();
    public final Object T = new Object();
    private final Object av = new Object();
    private final Object aw = new Object();
    public final Object U = new Object();
    public final Object V = new Object();
    private final Object ax = new Object();
    private final List<Integer> ay = new ArrayList();
    public final long a = System.currentTimeMillis();
    public final byte b = 1;

    private aa(Context context) {
        this.aj = null;
        this.f18483o = null;
        this.f18485q = null;
        this.f18486r = null;
        this.f18487s = null;
        this.f18490v = null;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.J = false;
        this.X = ap.a(context);
        PackageInfo packageInfoB = z.b(context);
        if (packageInfoB != null) {
            try {
                this.f18483o = packageInfoB.versionName;
                this.E = this.f18483o;
                this.F = Integer.toString(packageInfoB.versionCode);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f18471c = z.a(context);
        this.f18472d = z.a(Process.myPid());
        this.f18485q = z.c(context);
        this.f18479k = "Android " + ab.b() + ",level " + ab.c();
        Map<String, String> mapD = z.d(context);
        if (mapD != null) {
            try {
                this.f18490v = z.a(mapD);
                String str = mapD.get("BUGLY_APPID");
                if (str != null) {
                    this.f18486r = str;
                    b("APP_ID", this.f18486r);
                }
                String str2 = mapD.get("BUGLY_APP_VERSION");
                if (str2 != null) {
                    this.f18483o = str2;
                }
                String str3 = mapD.get("BUGLY_APP_CHANNEL");
                if (str3 != null) {
                    this.f18487s = str3;
                }
                String str4 = mapD.get("BUGLY_ENABLE_DEBUG");
                if (str4 != null) {
                    this.D = str4.equalsIgnoreCase(ITagManager.STATUS_TRUE);
                }
                String str5 = mapD.get("com.tencent.rdm.uuid");
                if (str5 != null) {
                    this.G = str5;
                }
                String str6 = mapD.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str6)) {
                    this.f18484p = Integer.parseInt(str6);
                }
                String str7 = mapD.get("BUGLY_AREA");
                if (str7 != null) {
                    this.H = str7;
                }
            } catch (Throwable th2) {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.J = true;
                al.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (p.f18774c) {
                th3.printStackTrace();
            }
        }
        this.O = ap.a("BUGLY_COMMON_VALUES", context);
        this.P = ap.a("BUGLY_RESERVED_VALUES", context);
        this.aj = ab.a(context);
        E();
        al.c("com info create end", new Object[0]);
    }

    public static int B() {
        return ab.c();
    }

    @Deprecated
    public static boolean C() {
        al.a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean D() {
        al.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void E() {
        try {
            for (Map.Entry<String, ?> entry : this.P.getAll().entrySet()) {
                al.c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : W.entrySet()) {
                al.c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                a(entry2.getKey(), entry2.getValue(), true);
            }
            W.clear();
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private String F() {
        if (TextUtils.isEmpty(this.ad)) {
            this.ad = ap.d("androidid", null);
        }
        return this.ad;
    }

    private static String G() {
        String string = UUID.randomUUID().toString();
        return !ap.a(string) ? string.replaceAll("-", "") : string;
    }

    public static synchronized aa b() {
        return aq;
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public final synchronized Map<String, PlugInBean> A() {
        Map<String, PlugInBean> map;
        map = this.ao;
        if (this.ap != null) {
            map.putAll(this.ap);
        }
        return map;
    }

    public final boolean a() {
        boolean z2 = this.ay.size() > 0;
        al.c("isAppForeground:%s", Boolean.valueOf(z2));
        return z2;
    }

    public final void c() {
        synchronized (this.au) {
            this.Y = UUID.randomUUID().toString();
        }
    }

    public final String d() {
        String str;
        synchronized (this.au) {
            if (this.Y == null) {
                c();
            }
            str = this.Y;
        }
        return str;
    }

    public final String e() {
        return !ap.a(this.f18473e) ? this.f18473e : this.f18486r;
    }

    public final String f() {
        String str;
        synchronized (this.V) {
            str = this.f18480l;
        }
        return str;
    }

    public final String g() {
        String str = this.aa;
        if (str != null) {
            return str;
        }
        this.aa = ap.d("deviceId", null);
        String str2 = this.aa;
        if (str2 != null) {
            return str2;
        }
        this.aa = F();
        if (TextUtils.isEmpty(this.aa)) {
            this.aa = G();
        }
        String str3 = this.aa;
        if (str3 == null) {
            return "";
        }
        ap.c("deviceId", str3);
        return this.aa;
    }

    public final synchronized String h() {
        if (this.Z != null) {
            return this.Z;
        }
        this.Z = ap.d("deviceModel", null);
        if (this.Z != null) {
            al.c("collect device model from sp:%s", this.Z);
            return this.Z;
        }
        if (!this.f18482n) {
            al.c("not allow collect device model", new Object[0]);
            return "fail";
        }
        this.Z = ab.a();
        al.c("collect device model:%s", this.Z);
        ap.c("deviceModel", this.Z);
        return this.Z;
    }

    public final synchronized String i() {
        return this.ac;
    }

    public final long j() {
        if (this.ae <= 0) {
            this.ae = ab.e();
        }
        return this.ae;
    }

    public final long k() {
        if (this.af <= 0) {
            this.af = ab.i();
        }
        return this.af;
    }

    public final long l() {
        if (this.ag <= 0) {
            this.ag = ab.k();
        }
        return this.ag;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.ai)) {
            al.c("get cpu type from so:%s", this.ai);
            return this.ai;
        }
        if (TextUtils.isEmpty(this.aj)) {
            return "unknown";
        }
        al.c("get cpu type from lib dir:%s", this.aj);
        return this.aj;
    }

    public final String o() {
        try {
            Map<String, ?> all = this.X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.T) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.K.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            al.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            al.a(th2);
        }
        if (this.K.isEmpty()) {
            al.c("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.K.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        al.c("SDK_INFO = %s", sb.toString());
        b("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public final synchronized Map<String, PlugInBean> p() {
        if (this.ak != null && this.ak.size() > 0) {
            HashMap map = new HashMap(this.ak.size());
            map.putAll(this.ak);
            return map;
        }
        return null;
    }

    public final String q() {
        if (this.al == null) {
            this.al = ab.m();
        }
        return this.al;
    }

    public final Boolean r() {
        if (this.am == null) {
            this.am = Boolean.valueOf(ab.n());
        }
        return this.am;
    }

    public final String s() {
        if (this.an == null) {
            this.an = ab.d(this.X);
            al.a("ROM ID: %s", this.an);
        }
        return this.an;
    }

    public final Map<String, String> t() {
        synchronized (this.av) {
            if (this.ar.size() <= 0) {
                return null;
            }
            return new HashMap(this.ar);
        }
    }

    public final void u() {
        synchronized (this.av) {
            this.ar.clear();
        }
    }

    public final int v() {
        int size;
        synchronized (this.av) {
            size = this.ar.size();
        }
        return size;
    }

    public final Set<String> w() {
        Set<String> setKeySet;
        synchronized (this.av) {
            setKeySet = this.ar.keySet();
        }
        return setKeySet;
    }

    public final Map<String, String> x() {
        synchronized (this.ax) {
            if (this.as.size() <= 0) {
                return null;
            }
            return new HashMap(this.as);
        }
    }

    public final Map<String, String> y() {
        synchronized (this.aw) {
            if (this.at.size() <= 0) {
                return null;
            }
            return new HashMap(this.at);
        }
    }

    public final int z() {
        int i2;
        synchronized (this.U) {
            i2 = this.f18491w;
        }
        return i2;
    }

    public final void b(String str) {
        al.a("change deviceModel，old:%s new:%s", this.Z, str);
        this.Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ap.c("deviceModel", str);
    }

    public final void a(int i2, boolean z2) {
        al.c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i2), Boolean.valueOf(z2));
        if (z2) {
            this.ay.add(Integer.valueOf(i2));
        } else {
            this.ay.remove(Integer.valueOf(i2));
            this.ay.remove((Object) 0);
        }
        q qVar = this.N;
        if (qVar != null) {
            qVar.setNativeIsAppForeground(this.ay.size() > 0);
        }
    }

    public final synchronized void c(String str) {
        this.ab = String.valueOf(str);
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ai = str.trim();
    }

    public final String f(String str) {
        String strRemove;
        if (ap.a(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            strRemove = this.ar.remove(str);
        }
        return strRemove;
    }

    public final void b(String str, String str2) {
        if (ap.a(str) || ap.a(str2)) {
            al.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aw) {
            this.at.put(str, str2);
        }
    }

    public final synchronized void d(String str) {
        this.ac = String.valueOf(str);
    }

    public static synchronized aa a(Context context) {
        if (aq == null) {
            aq = new aa(context);
        }
        return aq;
    }

    public final String g(String str) {
        String str2;
        if (ap.a(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            str2 = this.ar.get(str);
        }
        return str2;
    }

    public final void a(String str) {
        this.aa = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c("deviceId", str);
        }
        synchronized (this.ax) {
            this.as.put("E8", str);
        }
    }

    public final void a(String str, String str2) {
        if (ap.a(str) || ap.a(str2)) {
            al.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.av) {
            this.ar.put(str, str2);
        }
    }

    private void a(String str, String str2, boolean z2) {
        if (ap.a(str)) {
            al.d("key should not be empty %s", str);
            return;
        }
        al.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z2));
        synchronized (this.ax) {
            if (TextUtils.isEmpty(str2)) {
                this.as.remove(str);
                this.P.edit().remove(str).apply();
            } else {
                this.as.put(str, str2);
                if (z2) {
                    this.P.edit().putString(str, str2).apply();
                }
            }
        }
    }
}
