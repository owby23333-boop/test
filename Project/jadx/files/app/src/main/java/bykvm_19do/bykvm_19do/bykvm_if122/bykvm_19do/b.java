package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final b I = new b();
    private boolean A;
    private JSONObject B;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private String G;
    private int[] H;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f1318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1320e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f1327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f1328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f1329n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    private UserInfoForSegment f1334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private GMConfigUserInfoForSegment f1335t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Map<String, Object> f1339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<String> f1340y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1341z;
    private int a = 0;
    private boolean b = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1321f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1322g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1323h = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Set<String> f1330o = new HashSet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, Map<String, String>> f1331p = new HashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, Map<String, String>> f1332q = new HashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, Object> f1333r = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1336u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f1337v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private GMPrivacyConfig f1338w = new GMPrivacyConfig();

    private b() {
    }

    public static b J() {
        return I;
    }

    private static void h(String str) {
        b0.a(str, "appid不能为空");
    }

    private static void i(String str) {
        b0.a(str, "name不能为空");
    }

    public boolean A() {
        return this.A;
    }

    public boolean B() {
        return this.f1321f;
    }

    public boolean C() {
        return this.f1322g;
    }

    public boolean D() {
        return this.f1323h;
    }

    public boolean E() {
        return this.b;
    }

    public boolean F() {
        return this.E;
    }

    public boolean G() {
        return this.F;
    }

    public boolean H() {
        return ("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d));
    }

    public boolean I() {
        return this.C;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f1329n)) {
            this.f1329n = e0.a((String) null, a.d()).b();
            if (TextUtils.isEmpty(this.f1329n)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                e0.a((String) null, a.d()).e(strValueOf);
                this.f1329n = strValueOf;
            }
        }
        return this.f1329n;
    }

    public void a(int i2) {
        this.f1336u = i2;
    }

    public void a(long j2) {
        try {
            e0 e0VarS = d.S();
            if (e0VarS.a("first_install_time", -1L) == -1) {
                this.f1337v = j2;
                e0VarS.b("first_install_time", j2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void a(UserInfoForSegment userInfoForSegment, boolean z2) {
        boolean zEquals;
        if (z2) {
            this.f1334s = userInfoForSegment;
            return;
        }
        if (this.f1334s == null && userInfoForSegment == null) {
            zEquals = true;
        } else {
            UserInfoForSegment userInfoForSegment2 = this.f1334s;
            zEquals = (userInfoForSegment2 == null || userInfoForSegment == null) ? false : userInfoForSegment2.equals(userInfoForSegment);
        }
        this.f1334s = userInfoForSegment;
        if (zEquals) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a().a(1);
    }

    public void a(GMConfigUserInfoForSegment gMConfigUserInfoForSegment, boolean z2) {
        boolean zEquals;
        if (z2) {
            this.f1335t = gMConfigUserInfoForSegment;
            return;
        }
        if (this.f1335t == null && gMConfigUserInfoForSegment == null) {
            zEquals = true;
        } else {
            GMConfigUserInfoForSegment gMConfigUserInfoForSegment2 = this.f1335t;
            zEquals = (gMConfigUserInfoForSegment2 == null || gMConfigUserInfoForSegment == null) ? false : gMConfigUserInfoForSegment2.equals(gMConfigUserInfoForSegment);
        }
        this.f1335t = gMConfigUserInfoForSegment;
        if (zEquals) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a().a(1);
    }

    public void a(GMPrivacyConfig gMPrivacyConfig) {
        if (gMPrivacyConfig != null) {
            this.f1338w = gMPrivacyConfig;
        }
    }

    public void a(Object obj, Object obj2) {
        if ((obj instanceof List) && (obj2 instanceof GMConfigCallback)) {
            try {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(a.f()).a((List<String>) obj, (GMConfigCallback) obj2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(String str) {
        h(str);
        this.f1319d = str;
    }

    public void a(List<String> list) {
        this.f1340y = list;
    }

    public void a(Map<String, String> map) {
        this.f1327l = map;
    }

    public void a(Set<String> set) {
        if (set != null) {
            this.f1330o.addAll(set);
        }
    }

    public void a(JSONObject jSONObject) {
        this.B = jSONObject;
    }

    public void a(boolean z2) {
        this.f1341z = z2;
    }

    public void a(int... iArr) {
        this.H = iArr;
    }

    public void a(String[] strArr) {
        this.f1318c = strArr;
    }

    public String b() {
        return this.f1319d;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void b(String str) {
        i(str);
        this.f1320e = str;
    }

    public void b(Map<String, Object> map) {
        this.f1339x = map;
    }

    public void b(boolean z2) {
        this.A = z2;
        if (this.A) {
            try {
                Class.forName("com.bykv.vk.openvk.TTVfSdk");
            } catch (ClassNotFoundException e2) {
                this.A = false;
                e2.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        return this.B;
    }

    public void c(String str) {
        this.D = str;
    }

    public void c(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f1331p.putAll(map);
        }
    }

    public void c(boolean z2) {
        this.f1325j = z2;
    }

    public Map<String, String> d() {
        return this.f1327l;
    }

    public void d(String str) {
        this.f1326k = str;
    }

    public void d(Map<String, Map<String, String>> map) {
        if (map != null) {
            this.f1332q.putAll(map);
        }
    }

    public void d(boolean z2) {
        this.f1321f = z2;
    }

    public long e() {
        long j2;
        long j3 = this.f1337v;
        if (j3 != -1) {
            return j3;
        }
        try {
            e0 e0VarS = d.S();
            long jA = e0VarS.a("first_install_time", -1L);
            if (jA == -1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                e0VarS.b("first_install_time", jCurrentTimeMillis);
                this.f1337v = jCurrentTimeMillis;
                j2 = jCurrentTimeMillis;
            } else {
                this.f1337v = jA;
                j2 = jA;
            }
            return j2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void e(String str) {
        this.f1328m = str;
    }

    public void e(Map<String, String> map) {
        if (this.f1327l == null) {
            this.f1327l = new HashMap();
        }
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f1327l.putAll(map);
    }

    public void e(boolean z2) {
        this.f1322g = z2;
    }

    public GMConfigUserInfoForSegment f() {
        return this.f1335t;
    }

    public void f(String str) {
        this.f1324i = str;
    }

    public void f(boolean z2) {
        this.f1323h = z2;
    }

    public Map<String, Object> g() {
        this.f1333r.put("gm_usb", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.a());
        return this.f1333r;
    }

    public void g(String str) {
        this.G = str;
    }

    public void g(boolean z2) {
        this.b = z2;
    }

    public Map<String, Object> h() {
        return this.f1339x;
    }

    public void h(boolean z2) {
        this.E = z2;
    }

    public String i() {
        return this.f1320e;
    }

    public void i(boolean z2) {
        this.F = z2;
    }

    public String j() {
        return this.D;
    }

    public void j(boolean z2) {
        this.C = z2;
    }

    public String k() {
        return this.f1326k;
    }

    public String l() {
        return this.f1328m;
    }

    public String[] m() {
        return this.f1318c;
    }

    public int n() {
        return this.f1336u;
    }

    public int o() {
        return this.a;
    }

    public int[] p() {
        return this.H;
    }

    public String q() {
        if (("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d))) {
            try {
                return e0.a("tt_mediation_ppe_info", a.d()).d("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public List<String> r() {
        return this.f1340y;
    }

    public GMPrivacyConfig s() {
        return this.f1338w;
    }

    public String t() {
        return this.f1324i;
    }

    @Deprecated
    public UserInfoForSegment u() {
        return this.f1334s;
    }

    public String v() {
        return this.G;
    }

    public boolean w() {
        return ("com.header.app.untext".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d)) || ("com.bytedance.mediation_demo".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d)) || ("com.msdk.qa.monkey".equals(a.d().getPackageName()) && "5001121".equals(this.f1319d));
    }

    public boolean x() {
        String strA = m0.a();
        return "com.header.app.untext".equals(strA) || "com.bytedance.mediation_demo".equals(strA) || "com.msdk.qa.monkey".equals(strA);
    }

    public boolean y() {
        return this.f1341z;
    }

    public boolean z() {
        return this.f1325j;
    }
}
