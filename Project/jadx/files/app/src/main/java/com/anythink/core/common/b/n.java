package com.anythink.core.common.b;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.api.ATInitConfig;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATNetworkConfig;
import com.anythink.core.api.ATPrivacyConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.DeviceInfoCallback;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.s;
import com.anythink.core.common.r;
import com.anythink.core.common.t;
import com.anythink.core.common.u;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import com.anythink.core.common.x;
import com.umeng.message.proguard.ad;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile n f6960j;
    private String F;
    private String G;
    private boolean I;
    private com.anythink.core.common.f.c K;
    private Location L;
    private JSONArray N;
    private List<String> O;
    private String Q;
    private ATDebuggerConfig R;
    private boolean S;
    private ConcurrentHashMap<String, IATAdFilter> W;
    private ATPrivacyConfig Y;
    private ak aa;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Boolean f6961c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    WeakReference<Activity> f6963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6964f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f6968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6969l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f6970m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f6972o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ConcurrentHashMap<String, ATCustomAdapterConfig> f6975r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<String, Boolean> f6976s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f6977t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BroadcastReceiver f6979v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f6980w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f6981x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f6982y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private IExHandler f6983z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f6965g = "SDK.init";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f6966h = "com.anythink.pd.ExHandler";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6967i = false;
    private boolean B = false;
    private boolean C = false;
    private long D = 0;
    private long E = 0;
    private boolean J = false;
    private String M = "";
    private int T = 1;
    private boolean U = false;
    private boolean V = false;
    private String X = "";
    private int Z = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f6962d = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Handler f6971n = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ConcurrentHashMap<String, Map<String, Object>> f6974q = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f6973p = new ConcurrentHashMap<>();
    private final String A = File.separator + "anythink.test";
    private boolean H = true;
    private ConcurrentHashMap<String, List<String>> P = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private JSONObject f6978u = new JSONObject();
    private long ab = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.anythink.core.common.b.n$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.k.d.a(n.this.f6968k);
                com.anythink.core.common.k.d.q(n.this.f6968k);
            } catch (Exception unused) {
            }
            if (n.this.A()) {
                String strD = com.anythink.core.common.k.d.d(n.this.f6968k);
                String str = "********************************** " + com.anythink.core.common.k.g.a() + " *************************************";
                String str2 = "GAID(ADID): " + com.anythink.core.common.k.d.f() + " , AndroidID: " + strD;
                String str3 = "********************************** " + com.anythink.core.common.k.g.a() + " *************************************";
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                String str4 = "You can use \"ATSDK.setDebuggerConfig(context, \"" + strD + "\",new ATDebuggerConfig.Builder(the NetworkFirmId you want to test).build());\" to open the debugger mode.";
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.n$10, reason: invalid class name */
    final class AnonymousClass10 extends BroadcastReceiver {
        AnonymousClass10() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (com.anythink.core.common.k.h.a(context)) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.10.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a().b();
                    }
                });
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.10.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a().b();
                    }
                });
                com.anythink.core.common.j.b.a().b();
                n nVar = n.this;
                nVar.a(context, nVar.p(), n.this.q());
            }
            if (TextUtils.equals(intent.getAction(), g.C)) {
                com.anythink.core.common.j.c.a(intent.getStringExtra(g.D));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.n$11, reason: invalid class name */
    final class AnonymousClass11 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        AnonymousClass11(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.a.getApplicationContext()).b(this.b);
            if (aVarB != null) {
                if (!aVarB.G()) {
                    r.a(n.this.f6968k).a(aVarB);
                }
                if (com.anythink.core.c.b.a(this.a.getApplicationContext()).a(this.b)) {
                    return;
                }
                com.anythink.core.c.b.a(this.a.getApplicationContext());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.n$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ ATInitConfig a;
        final /* synthetic */ Context b;

        AnonymousClass5(ATInitConfig aTInitConfig, Context context) {
            this.a = aTInitConfig;
            this.b = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x009c A[Catch: all -> 0x00d5, TryCatch #1 {all -> 0x00d5, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0020, B:21:0x0057, B:25:0x0074, B:29:0x008b, B:31:0x009c, B:32:0x00ca, B:20:0x0054, B:7:0x0025), top: B:39:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.b.n.AnonymousClass5.run():void");
        }
    }

    private n() {
    }

    static /* synthetic */ void N() {
        try {
            Class<?> cls = Class.forName("com.anythink.network.adx.AdxATInitManager");
            Object objInvoke = null;
            try {
                objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                String str = "Cannot instantiate " + cls.getName() + ", please check if SDK is imported";
            }
            if (objInvoke == null || !(objInvoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) objInvoke).getResourceStatus();
        } catch (Throwable unused2) {
        }
    }

    private void O() {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1());
    }

    private static void P() {
        try {
            Class<?> cls = Class.forName("com.anythink.network.adx.AdxATInitManager");
            Object objInvoke = null;
            try {
                objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                String str = "Cannot instantiate " + cls.getName() + ", please check if SDK is imported";
            }
            if (objInvoke == null || !(objInvoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) objInvoke).getResourceStatus();
        } catch (Throwable unused2) {
        }
    }

    private void Q() {
        try {
            if (this.f6979v != null) {
                this.f6968k.unregisterReceiver(this.f6979v);
                k.a(this.f6968k).a(this.f6979v);
            }
            this.f6979v = null;
        } catch (Throwable unused) {
        }
        try {
            this.f6979v = new AnonymousClass10();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(g.C);
            this.f6968k.registerReceiver(this.f6979v, intentFilter);
            k.a(this.f6968k).a(this.f6979v, intentFilter);
        } catch (Throwable unused2) {
        }
    }

    private static boolean R() {
        return true;
    }

    private void S() {
        Throwable th;
        boolean zExists;
        Context context = this.f6968k;
        boolean z2 = false;
        if (context != null) {
            try {
                zExists = new File(context.getExternalFilesDir(null), this.A).exists();
                if (!zExists) {
                    try {
                        zExists = new File(this.f6968k.getFilesDir(), this.A).exists();
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zExists = false;
            }
            z2 = zExists;
        }
        this.B = z2;
    }

    private boolean T() {
        return this.H;
    }

    private long U() {
        return this.ab;
    }

    private Map<String, Object> q(String str) {
        if (this.f6974q == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f6974q.get(str);
    }

    private void r(String str) {
        this.f6969l = str;
        com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.f6800p, str);
    }

    private void s(String str) {
        this.f6970m = str;
        com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.f6801q, str);
    }

    public final boolean A() {
        return this.B || this.C;
    }

    public final com.anythink.core.common.f.c B() {
        if (this.K == null) {
            this.K = new com.anythink.core.common.h.d();
        }
        return this.K;
    }

    public final boolean C() {
        return this.U;
    }

    public final boolean D() {
        return this.V;
    }

    public final Context E() {
        WeakReference<Activity> weakReference = this.f6963e;
        return (weakReference == null || weakReference.get() == null) ? this.f6968k : this.f6963e.get();
    }

    public final Activity F() {
        WeakReference<Activity> weakReference = this.f6963e;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f6963e.get();
    }

    public final String G() {
        return this.X;
    }

    public final boolean H() {
        Boolean bool = this.f6961c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class.forName("com.reyun.mobdna.MobDNA");
            this.f6961c = Boolean.TRUE;
        } catch (Throwable unused) {
            this.f6961c = Boolean.FALSE;
        }
        return this.f6961c.booleanValue();
    }

    public final boolean I() {
        return this.J;
    }

    public final ATPrivacyConfig J() {
        return this.Y;
    }

    public final int K() {
        return this.Z;
    }

    public final ak L() {
        if (this.aa == null) {
            this.aa = new ak();
        }
        try {
            this.aa.a(com.anythink.core.common.k.d.s(a().f6968k));
            this.aa.b(com.anythink.core.common.k.d.k());
            this.aa.c(com.anythink.core.common.k.d.m());
            this.aa.d(com.anythink.core.common.k.d.b(com.anythink.core.common.k.d.l()));
        } catch (Throwable unused) {
        }
        return this.aa;
    }

    public final void M() {
        this.ab = System.currentTimeMillis();
    }

    public final synchronized IExHandler b() {
        if (this.f6967i) {
            return this.f6983z;
        }
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.pd.ExHandler").asSubclass(IExHandler.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            this.f6983z = (IExHandler) declaredConstructor.newInstance(new Object[0]);
        } catch (Exception unused) {
        }
        this.f6967i = true;
        return this.f6983z;
    }

    public final synchronized String[] f() {
        Set<String> setKeySet;
        int size;
        if (this.f6976s == null || (size = (setKeySet = this.f6976s.keySet()).size()) <= 0) {
            return null;
        }
        String[] strArr = new String[size];
        setKeySet.toArray(strArr);
        return strArr;
    }

    public final Context g() {
        return this.f6968k;
    }

    public final long h() {
        return this.D;
    }

    public final long i() {
        return this.E;
    }

    public final int j() {
        return this.f6964f;
    }

    public final List<String> k() {
        return this.O;
    }

    public final JSONArray l() {
        return this.N;
    }

    public final Map<String, Object> m() {
        return this.f6973p;
    }

    public final String n() {
        Object obj = this.f6973p.get("channel");
        return obj != null ? obj.toString() : "";
    }

    public final String o() {
        Object obj = this.f6973p.get("sub_channel");
        return obj != null ? obj.toString() : "";
    }

    public final String p() {
        if (TextUtils.isEmpty(this.f6969l)) {
            this.f6969l = com.anythink.core.common.k.p.b(this.f6968k, g.f6799o, g.f6800p, "");
        }
        return this.f6969l;
    }

    public final String t() {
        return this.M;
    }

    public final boolean u() {
        return this.S;
    }

    public final boolean v() {
        return this.S && this.R != null;
    }

    public final ATDebuggerConfig w() {
        return this.R;
    }

    public final String x() {
        if (TextUtils.isEmpty(this.f6980w)) {
            this.f6980w = com.anythink.core.common.k.p.b(this.f6968k, g.f6799o, g.o.f6917i, "");
        }
        return this.f6980w;
    }

    public final String y() {
        if (TextUtils.isEmpty(this.f6981x)) {
            this.f6981x = com.anythink.core.common.k.p.b(this.f6968k, g.f6807w, g.o.f6920l, "");
        }
        return this.f6981x;
    }

    public final String z() {
        if (TextUtils.isEmpty(this.f6982y)) {
            this.f6982y = com.anythink.core.common.k.p.b(this.f6968k, g.f6807w, g.o.f6921m, "");
        }
        return this.f6982y;
    }

    public static n a() {
        if (f6960j == null) {
            synchronized (n.class) {
                if (f6960j == null) {
                    f6960j = new n();
                }
            }
        }
        return f6960j;
    }

    static boolean h(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Deprecated
    private void t(String str) {
        this.Q = str;
    }

    private synchronized String u(String str) throws JSONException {
        String strOptString = this.f6978u.optString(str);
        if (!TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": sessionid is empty.");
        String strX = x();
        String string = "";
        if (TextUtils.isEmpty(strX)) {
            strX = com.anythink.core.common.k.d.d(this.f6968k) + com.anythink.core.common.k.d.f();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(new Random().nextInt(10000000));
            string = sb2.toString();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = com.anythink.core.common.k.f.a(strX + str + string + jCurrentTimeMillis);
        try {
            this.f6978u.put(str, strA);
        } catch (Exception unused) {
        }
        com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.o.f6915g, this.f6978u.toString());
        if (!TextUtils.isEmpty(x())) {
            string = null;
        }
        com.anythink.core.common.j.c.a(str, "2", string, String.valueOf(jCurrentTimeMillis));
        return strA;
    }

    public final String c() {
        return b() != null ? g.c.f6827e : g.c.f6828f;
    }

    public final String d() {
        return this.f6972o;
    }

    public final int e() {
        return this.T;
    }

    public final String g(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strOptString = this.f6978u.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            return u(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": sessionid exists.");
        return strOptString;
    }

    public final void i(String str) {
        this.f6981x = str;
        com.anythink.core.common.k.p.a(this.f6968k, g.f6807w, g.o.f6920l, str);
    }

    public final void j(String str) {
        this.f6982y = str;
        com.anythink.core.common.k.p.a(this.f6968k, g.f6807w, g.o.f6921m, str);
    }

    public final void k(String str) {
        com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.o.f6917i, str);
        this.f6980w = str;
    }

    public final List<String> l(String str) {
        return this.P.get(str);
    }

    public final List<String> m(String str) {
        return this.P.get(str + "_network_firm");
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int i2 = (Long.parseLong(str) > 0L ? 1 : (Long.parseLong(str) == 0L ? 0 : -1));
        } catch (Exception unused) {
            String str2 = "AdSourceId '" + str + "' is not compliant";
        }
    }

    public final synchronized boolean c(String str) {
        if (this.f6976s == null) {
            return false;
        }
        return this.f6976s.containsKey(str);
    }

    public final Map<String, Object> d(String str) {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.f6974q.get(str);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.f6973p;
        if (concurrentHashMap != null) {
            map.putAll(concurrentHashMap);
        }
        if (map2 != null) {
            map.putAll(map2);
        }
        map.remove("channel");
        map.remove("sub_channel");
        Object obj = this.f6973p.get("channel");
        Object obj2 = this.f6973p.get("sub_channel");
        if (obj != null) {
            map.put("channel", obj);
        }
        if (obj2 != null) {
            map.put("sub_channel", obj2);
        }
        return map;
    }

    public final void e(String str) {
        this.F = str;
        this.f6973p.put("channel", this.F);
    }

    public final IATAdFilter o(String str) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.W) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final String q() {
        if (TextUtils.isEmpty(this.f6970m)) {
            this.f6970m = com.anythink.core.common.k.p.b(this.f6968k, g.f6799o, g.f6801q, "");
        }
        return this.f6970m;
    }

    public final String r() {
        try {
            if (TextUtils.isEmpty(this.f6977t)) {
                a(this.f6968k, p(), 0);
            }
        } catch (Exception unused) {
        }
        return this.f6977t;
    }

    public final Location s() {
        return this.L;
    }

    public final void p(String str) {
        this.X = str;
    }

    private void e(Context context) {
        long jCurrentTimeMillis = this.f6962d;
        try {
            String strB = com.anythink.core.common.k.p.b(a().f6968k, g.f6799o, a().p() + "playRecord", "");
            if (!TextUtils.isEmpty(strB)) {
                JSONObject jSONObject = new JSONObject(strB);
                long jOptLong = jSONObject.optLong("start_time");
                long jOptLong2 = jSONObject.optLong("end_time");
                String strOptString = jSONObject.optString(e.f6775c);
                int iOptInt = jSONObject.optInt(e.f6776d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.j.c.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                    new StringBuilder("Create new psid, SDKContext.init to send playTime:").append((jOptLong2 - jOptLong) / 1000);
                } else {
                    try {
                        new StringBuilder("Psid is old, use pervioud statime，close before:").append((jOptLong2 - jOptLong) / 1000);
                        jCurrentTimeMillis = jOptLong;
                    } catch (Exception unused) {
                        jCurrentTimeMillis = jOptLong;
                        com.anythink.core.common.k.p.a(a().f6968k, g.f6799o, a().p() + "playRecord", "");
                    }
                }
                com.anythink.core.common.k.p.a(a().f6968k, g.f6799o, a().p() + "playRecord", "");
            }
        } catch (Exception unused2) {
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6916h, (Long) 0L).longValue();
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new e(jCurrentTimeMillis));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r2.importance != 100) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r5.getSystemService(r1)     // Catch: java.lang.Throwable -> L32
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L32
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L32
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L32
        L11:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L31
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L32
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = r2.processName     // Catch: java.lang.Throwable -> L32
            java.lang.String r4 = r5.getPackageName()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L11
            int r5 = r2.importance     // Catch: java.lang.Throwable -> L32
            r1 = 100
            if (r5 != r1) goto L31
            r5 = 1
            return r5
        L31:
            return r0
        L32:
            r5 = move-exception
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.b.n.c(android.content.Context):boolean");
    }

    public final void a(String str) {
        this.f6972o = str;
    }

    public final void f(String str) {
        this.G = str;
        this.f6973p.put("sub_channel", this.G);
    }

    public final synchronized void a(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f6975r == null) {
            this.f6975r = new ConcurrentHashMap<>();
        }
        if (aTCustomAdapterConfig == null) {
            this.f6975r.remove(str);
        } else {
            this.f6975r.put(str, aTCustomAdapterConfig);
        }
    }

    public final ATCustomAdapterConfig b(String str) {
        if (this.f6975r == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f6975r.get(str);
    }

    static boolean c(Context context, List<String> list) {
        boolean z2;
        boolean z3;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            z2 = true;
        } catch (Throwable th) {
            sb.append(", error: ");
            sb.append(th.getMessage());
            z2 = false;
        }
        if (packageInfo == null) {
            return false;
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        for (String str : list) {
            int length = providerInfoArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z3 = false;
                    break;
                }
                if (TextUtils.equals(providerInfoArr[i2].name, str)) {
                    z3 = true;
                    break;
                }
                i2++;
            }
            if (!z3) {
                sb.append(", ");
                sb.append(str);
                z2 = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z2) {
            String str2 = "Providers : Missing " + sb.toString() + " declare in AndroidManifest";
        }
        return z2;
    }

    public final void b(int i2) {
        this.f6964f = i2;
    }

    private void b(Context context, String str, String str2) {
        a(context.getApplicationContext(), str, str2);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass11(context, str));
    }

    private boolean d(Context context) {
        String strD = com.anythink.core.common.k.d.d(context);
        if (!TextUtils.isEmpty(strD) && strD.equals(this.Q)) {
            return true;
        }
        String strF = com.anythink.core.common.k.d.f();
        if (!TextUtils.isEmpty(strF) && strF.equals(this.Q)) {
            return true;
        }
        IExHandler iExHandlerB = a().b();
        return iExHandlerB != null && iExHandlerB.checkDebuggerDevice(context, this.Q);
    }

    public final void b(final Context context) {
        if (A()) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.12
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        Enumeration<String> enumerationEntries = new DexFile(context.getPackageCodePath()).entries();
                        while (enumerationEntries.hasMoreElements()) {
                            String strNextElement = enumerationEntries.nextElement();
                            if (strNextElement.contains("com.anythink.network") && strNextElement.contains("InitManager") && !strNextElement.contains("$")) {
                                arrayList.add(strNextElement);
                            }
                        }
                        arrayList.size();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            try {
                                Class<?> cls = Class.forName((String) it.next());
                                Object objInvoke = null;
                                try {
                                    objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                                } catch (Throwable unused) {
                                    String str = "Cannot instantiate " + cls.getName() + ", please check if a third-party SDK is imported";
                                }
                                if (objInvoke != null && (objInvoke instanceof ATInitMediation)) {
                                    ATInitMediation aTInitMediation = (ATInitMediation) objInvoke;
                                    String networkName = aTInitMediation.getNetworkName();
                                    if (!TextUtils.isEmpty(networkName)) {
                                        String networkVersion = aTInitMediation.getNetworkVersion();
                                        if (TextUtils.isEmpty(networkVersion)) {
                                            "NetworkName: ".concat(String.valueOf(networkName));
                                        } else {
                                            String str2 = "NetworkName: " + networkName + "  (v" + networkVersion + ad.f20406s;
                                        }
                                        boolean zH = n.h(aTInitMediation.getNetworkSDKClass());
                                        boolean zB = n.b(aTInitMediation.getPluginClassStatus());
                                        boolean zA = n.a(context, (List<String>) aTInitMediation.getActivityStatus());
                                        boolean zB2 = n.b(context, (List<String>) aTInitMediation.getServiceStatus());
                                        boolean zC = n.c(context, aTInitMediation.getProviderStatus());
                                        boolean zD = n.d(context, aTInitMediation.getMetaValutStatus());
                                        boolean zE = n.e(context, aTInitMediation.getPermissionStatus());
                                        aTInitMediation.getResourceStatus();
                                        if (zH && zB && zA && zB2 && zC && zD && !zE) {
                                        }
                                    }
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Exception unused3) {
                    }
                }
            });
        }
    }

    static boolean b(Map<String, Boolean> map) {
        boolean z2 = true;
        if (map == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (!map.get(str).booleanValue()) {
                sb.append(", ");
                sb.append(str);
                z2 = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z2) {
            "Dependence Plugin: Missing ".concat(String.valueOf(sb));
        }
        return z2;
    }

    public final void a(int i2) {
        if (i2 == 2) {
            this.T = 2;
        } else {
            this.T = 1;
        }
    }

    public final synchronized void a(String... strArr) {
        if (strArr != null) {
            this.f6976s = new HashMap();
            for (String str : strArr) {
                this.f6976s.put(str, Boolean.TRUE);
            }
            return;
        }
        this.f6976s = null;
    }

    static boolean d(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            int size = list.size();
            boolean z3 = true;
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
                if (TextUtils.isEmpty(applicationInfo.metaData.getString(str))) {
                    sb.append(", \"");
                    sb.append(str);
                    sb.append("\"");
                    z3 = false;
                }
            }
            if (sb.length() > 2) {
                sb.delete(0, 2);
            }
            z2 = z3;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z2) {
            String str2 = "meta-data: Missing " + sb.toString() + " declare in AndroidManifest";
        }
        return z2;
    }

    static boolean b(Context context, List<String> list) {
        boolean z2 = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        PackageManager packageManager = context.getPackageManager();
        for (String str : list) {
            try {
            } catch (Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (packageManager.queryIntentServices(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z2 = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z2) {
            String str2 = "Services : Missing " + sb.toString() + " declare in AndroidManifest";
        }
        return z2;
    }

    public final void c(Runnable runnable) {
        this.f6971n.removeCallbacks(runnable);
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        this.f6968k = context;
    }

    public final void c(boolean z2) {
        this.H = z2;
    }

    public final void a(Map<String, Object> map) {
        if (map != null && map.containsKey("channel")) {
            Object obj = map.get("channel");
            this.F = obj != null ? obj.toString() : "";
            if (!com.anythink.core.common.k.g.a(this.F)) {
                this.F = null;
                map.remove("channel");
            }
        }
        if (map != null && map.containsKey("sub_channel")) {
            Object obj2 = map.get("sub_channel");
            this.G = obj2 != null ? obj2.toString() : "";
            if (!com.anythink.core.common.k.g.b(this.G)) {
                this.G = null;
                map.remove("sub_channel");
            }
        }
        this.f6973p.clear();
        if (map != null) {
            this.f6973p.putAll(map);
        }
        if (!TextUtils.isEmpty(this.F)) {
            this.f6973p.put("channel", this.F);
        }
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        this.f6973p.put("sub_channel", this.G);
    }

    public final void c(int i2) {
        this.Z = i2;
    }

    static boolean e(Context context, List<String> list) {
        int size;
        boolean z2;
        if (list == null || (size = list.size()) == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        boolean z3 = false;
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                boolean z4 = true;
                for (int i2 = 0; i2 < size; i2++) {
                    String str = list.get(i2);
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z2 = false;
                            break;
                        }
                        if (TextUtils.equals(str, strArr[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z2) {
                        if (sb.length() == 0) {
                            sb.append(str);
                        } else {
                            sb.append(", ");
                            sb.append(str);
                        }
                        z4 = false;
                    }
                }
                z3 = z4;
            } else {
                for (int i4 = 0; i4 < size; i4++) {
                    String str2 = list.get(i4);
                    if (i4 == 0) {
                        sb.append(str2);
                    } else {
                        sb.append(", ");
                        sb.append(str2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z3) {
            String str3 = "Permission: Missing " + sb.toString() + " declare in AndroidManifest";
        }
        return z3;
    }

    public static void b(Runnable runnable) {
        com.anythink.core.common.k.b.a.a().a(runnable);
    }

    public final void b(boolean z2) {
        this.C = z2;
    }

    public final void b(String str, List<String> list) {
        this.P.put(str + "_network_firm", list);
    }

    static /* synthetic */ void b(n nVar) {
        Throwable th;
        boolean zExists;
        Context context = nVar.f6968k;
        boolean z2 = false;
        if (context != null) {
            try {
                zExists = new File(context.getExternalFilesDir(null), nVar.A).exists();
                if (!zExists) {
                    try {
                        zExists = new File(nVar.f6968k.getFilesDir(), nVar.A).exists();
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zExists = false;
            }
            z2 = zExists;
        }
        nVar.B = z2;
    }

    public static void d(Runnable runnable) {
        com.anythink.core.common.k.b.a.a().a(runnable, 1000L);
    }

    public final void d(boolean z2) {
        this.V = z2;
    }

    public final long d(int i2) {
        if (i2 != 1 && i2 != 4) {
            return 26214400L;
        }
        com.anythink.core.c.b.a(this.f6968k);
        return com.anythink.core.c.b.a() * 1024;
    }

    private void e(boolean z2) {
        this.U = z2;
    }

    public final void a(String str, Map<String, Object> map) {
        if (map != null) {
            this.f6974q.put(str, map);
        }
    }

    public final void a(List<String> list) {
        try {
            this.O = list;
            if (list != null && !list.isEmpty()) {
                this.N = new JSONArray((Collection) list);
            } else {
                this.N = null;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void a(Location location) {
        this.L = location;
    }

    public final synchronized void a(boolean z2) {
        this.M = z2 ? "1" : "2";
    }

    public final synchronized void a(final Context context, final String str, String str2, final ATNetworkConfig aTNetworkConfig) {
        if (context == null) {
            return;
        }
        this.f6968k = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.I) {
                return;
            }
            this.I = true;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.D = com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6919k, (Long) 0L).longValue();
                if (this.D == 0) {
                    this.D = jCurrentTimeMillis;
                    com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6919k, this.D);
                }
                this.E = ((a(jCurrentTimeMillis) - a(this.D)) / 86400000) + 1;
                this.f6962d = 0L;
                com.anythink.core.a.a.a(context.getApplicationContext()).a();
                this.Z = com.anythink.core.common.k.p.b(context, g.f6799o, "r", 1);
                final Context applicationContext = context.getApplicationContext();
                a(applicationContext);
                this.f6969l = str;
                com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.f6800p, str);
                this.f6970m = str2;
                com.anythink.core.common.k.p.a(this.f6968k, g.f6799o, g.f6801q, str2);
                this.U = com.anythink.core.common.k.h.a();
                try {
                    if (this.f6979v != null) {
                        this.f6968k.unregisterReceiver(this.f6979v);
                        k.a(this.f6968k).a(this.f6979v);
                    }
                    this.f6979v = null;
                } catch (Throwable unused) {
                }
                try {
                    this.f6979v = new AnonymousClass10();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction(g.C);
                    this.f6968k.registerReceiver(this.f6979v, intentFilter);
                    k.a(this.f6968k).a(this.f6979v, intentFilter);
                } catch (Throwable unused2) {
                }
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.anythink.core.common.j.b.a().a(applicationContext);
                            n.this.a(applicationContext, str, 0);
                            n.a(n.this, context);
                            h.a(applicationContext).a();
                            n.b(n.this);
                            n.N();
                            com.anythink.core.common.a.j.a().b();
                            com.anythink.core.common.res.d.a(n.this.g()).b();
                        } catch (Exception unused3) {
                        }
                    }
                });
                ((Application) this.f6968k).registerActivityLifecycleCallbacks(new f(c(this.f6968k)));
                a(new Runnable() { // from class: com.anythink.core.common.b.n.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.core.common.k.d.p(applicationContext);
                    }
                }, 5000L);
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass1());
                com.anythink.core.common.p.a().a(this.f6968k);
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.this.b();
                        if (n.this.f6983z != null) {
                            n.this.f6983z.initDeviceInfo(context);
                        }
                        com.anythink.core.c.e.a(applicationContext).a();
                        com.anythink.core.common.k.d.r(n.this.f6968k);
                        x.a(context);
                    }
                });
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        n nVar = n.this;
                        n.a(nVar, nVar.f6968k, aTNetworkConfig);
                    }
                });
                a(context.getApplicationContext(), str, str2);
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass11(context, str));
            } catch (Exception unused3) {
            }
        }
    }

    public final void a(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        IExHandler iExHandlerB;
        if (context == null) {
            A();
            return;
        }
        if (a().f6968k == null) {
            a().a(context.getApplicationContext());
        }
        this.Q = str;
        this.R = aTDebuggerConfig;
        String strD = com.anythink.core.common.k.d.d(context);
        boolean z2 = true;
        if (TextUtils.isEmpty(strD) || !strD.equals(this.Q)) {
            String strF = com.anythink.core.common.k.d.f();
            if ((TextUtils.isEmpty(strF) || !strF.equals(this.Q)) && ((iExHandlerB = a().b()) == null || !iExHandlerB.checkDebuggerDevice(context, this.Q))) {
                z2 = false;
            }
        }
        this.S = z2;
        if (TextUtils.isEmpty(this.Q)) {
            A();
            this.S = false;
        } else {
            if (this.S) {
                A();
                if (this.R != null) {
                    A();
                    return;
                }
                return;
            }
            A();
        }
    }

    protected final synchronized long a(Context context, String str, int i2) {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(context).b(str);
        String strB = com.anythink.core.common.k.p.b(context, g.f6799o, g.o.f6914f, "");
        String strB2 = com.anythink.core.common.k.p.b(context, g.f6799o, g.o.f6915g, "");
        long jLongValue = com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6916h, (Long) 0L).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jLongValue < 0) {
            jLongValue = 0;
        }
        if (jCurrentTimeMillis - jLongValue <= (i2 == 0 ? aVarB.N() : aVarB.B())) {
            new StringBuilder("psid updataTime<=").append(aVarB.N());
            this.f6977t = strB;
            if (!TextUtils.isEmpty(strB2)) {
                this.f6978u = new JSONObject(strB2);
            }
            new StringBuilder("psid :").append(this.f6977t);
            return 0L;
        }
        new StringBuilder("psid updataTime>").append(aVarB.N());
        String strX = x();
        String strValueOf = "";
        if (TextUtils.isEmpty(strX)) {
            strX = com.anythink.core.common.k.d.d(context) + com.anythink.core.common.k.d.f();
            strValueOf = String.valueOf(new Random().nextInt(10000000));
        }
        this.f6977t = com.anythink.core.common.k.f.a(strX + str + strValueOf + jCurrentTimeMillis);
        this.f6978u = new JSONObject();
        com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6914f, this.f6977t);
        com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6915g, "");
        com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6916h, jCurrentTimeMillis);
        new StringBuilder("psid :").append(this.f6977t);
        com.anythink.core.common.j.c.a((String) null, "1", strValueOf, String.valueOf(jCurrentTimeMillis));
        if (i2 == 0) {
            this.f6962d = jCurrentTimeMillis;
        }
        return jCurrentTimeMillis;
    }

    public final void a(Context context, final String str, Map<String, Object> map) {
        if (A()) {
            String str2 = "Requesting placement(" + str + ") setting Info，please wait a moment.";
            new com.anythink.core.common.g.j(context, a().p(), a().q(), str, "", map, new HashMap(1)).a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.b.n.13
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i2) {
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i2, String str3, AdError adError) {
                    String str4 = "********************************** Get Splash Config Start(" + str + ") *************************************";
                    String str5 = "This placement(" + str + ") request error:" + adError.printStackTrace();
                    String str6 = "********************************** Get Splash Config End(" + str + ") *************************************";
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i2, Object obj) {
                    com.anythink.core.c.d dVarB = com.anythink.core.c.d.b((String) obj);
                    if (!"4".equals(String.valueOf(dVarB.X()))) {
                        String str3 = "********************************** Get Splash Config Start(" + str + ") *************************************";
                        String str4 = "This placement(" + str + ") does not belong to Splash!";
                        String str5 = "********************************** Get Splash Config End(" + str + ") *************************************";
                        return;
                    }
                    String str6 = "********************************** Get Splash Config Start(" + str + ") *************************************";
                    List<ai> listF = dVarB.F();
                    if (listF == null || listF.size() == 0) {
                        ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", "").getDesc();
                    } else {
                        for (ai aiVar : listF) {
                            String str7 = "Network Firm Id:" + aiVar.c();
                            String str8 = "AdSource Id:" + aiVar.t();
                            String str9 = "Network Content:" + aiVar.g();
                        }
                    }
                    String str10 = "********************************** Get Splash Config End(" + str + ") *************************************";
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i2) {
                }
            });
            return;
        }
        String str3 = "********************************** Get Splash Config Start(" + str + ") *************************************";
        String str4 = "********************************** Get Splash Config End(" + str + ") *************************************";
    }

    static boolean a(Context context, List<String> list) {
        boolean z2 = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            try {
            } catch (Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (context.getPackageManager().queryIntentActivities(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z2 = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z2) {
            String str2 = "Activities : Missing " + sb.toString() + " declare in AndroidManifest";
        }
        return z2;
    }

    public final void a(final Context context, final String str, final String str2) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.2
            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.core.c.b.a(context).a(str)) {
                    com.anythink.core.c.b.a(context).a(str, str2);
                }
            }
        });
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f6971n.post(runnable);
        }
    }

    public final void a(Runnable runnable, long j2) {
        if (j2 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f6971n.postDelayed(runnable, j2);
        }
    }

    private static long a(long j2) {
        Date date = new Date(j2);
        return new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
    }

    public final void a(String str, List<String> list) {
        this.P.put(str, list);
    }

    public final void a(final Context context, final DeviceInfoCallback deviceInfoCallback) {
        if (this.I) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(context).b(n.a().p());
                    String strF = aVarB != null ? aVarB.F() : "";
                    boolean z2 = true;
                    if (!TextUtils.isEmpty(strF)) {
                        try {
                            JSONObject jSONObject = new JSONObject(strF);
                            if (!jSONObject.isNull("a")) {
                                if (jSONObject.optInt("a") != 1) {
                                    z2 = false;
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        IExHandler iExHandlerB = n.a().b();
                        if (iExHandlerB != null) {
                            iExHandlerB.fillTestDeviceData(jSONObject2, aVarB);
                        }
                        jSONObject2.put("GAID", com.anythink.core.common.k.d.r(context));
                        jSONObject2.put("AndroidID", z2 ? com.anythink.core.common.k.d.d(context) : "");
                        jSONObject2.put("How to config TestMode", "Please visit the document center and learn more through： Integration(Basic) -> How To Test");
                        com.anythink.core.common.k.n.a("testModeDeviceInfo", jSONObject2.toString());
                        if (deviceInfoCallback != null) {
                            deviceInfoCallback.deviceInfo(jSONObject2.toString());
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else if (deviceInfoCallback != null) {
            deviceInfoCallback.deviceInfo("You should init SDK first.");
        }
    }

    public final void a(final String str, final String str2, final String str3, final Map<String, Object> map) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.4
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.b bVarA;
                boolean z2;
                if (n.this.I) {
                    com.anythink.core.common.f fVarB = v.a().b(str);
                    com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.this.f6968k).a(str);
                    String strB = w.a().b(str);
                    String str4 = (TextUtils.isEmpty(str2) || !com.anythink.core.common.k.g.c(str2)) ? "" : str2;
                    if (fVarB != null) {
                        boolean zE = fVarB.e();
                        bVarA = fVarB.a(n.this.f6968k, false, false, map);
                        z2 = zE;
                    } else {
                        bVarA = null;
                        z2 = false;
                    }
                    if (bVarA != null) {
                        com.anythink.core.common.e.e eVarN = bVarA.h().N();
                        eVarN.d(1);
                        eVarN.C = str4;
                        com.anythink.core.common.j.a.a(n.this.f6968k).a(16, eVarN);
                        return;
                    }
                    com.anythink.core.common.e.e eVarA = s.a(TextUtils.isEmpty(strB) ? "" : strB, str, "", dVarA, "", 0, 0, 0, map);
                    eVarA.d(z2 ? 3 : 2);
                    if (dVarA == null) {
                        eVarA.z(str3);
                    }
                    eVarA.C = str4;
                    com.anythink.core.common.j.a.a(n.this.f6968k).a(16, eVarA);
                }
            }
        });
    }

    public final void a(Activity activity) {
        WeakReference<Activity> weakReference = this.f6963e;
        if (weakReference == null || weakReference.get() == null) {
            this.f6963e = new WeakReference<>(activity);
        }
    }

    private void a(Context context, ATNetworkConfig aTNetworkConfig) {
        ATInitConfig aTInitConfig;
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new ArrayList<>(2);
        }
        if (v()) {
            aTInitConfigList.clear();
        }
        boolean z2 = false;
        this.J = aTInitConfigList.size() > 0;
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            aTInitConfig = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
            try {
                aTInitConfigList.add(0, aTInitConfig);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            aTInitConfig = null;
        }
        for (ATInitConfig aTInitConfig2 : aTInitConfigList) {
            if (aTInitConfig2 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig2.getClass().getSimpleName())) {
                    if (!z2) {
                        z2 = true;
                    }
                }
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(aTInitConfig2, context));
            }
        }
    }

    public final void a(String str, Map<String, Object> map, String... strArr) {
        com.anythink.core.common.e.e eVar;
        if (map == null || map.containsKey(ATInitMediation.KEY_LOCAL)) {
            return;
        }
        try {
            eVar = (com.anythink.core.common.e.e) map.get(g.k.f6898h);
        } catch (Throwable unused) {
            eVar = null;
        }
        map.remove(g.k.f6898h);
        String string = new JSONObject(map).toString();
        String str2 = "Mismatched initialization parameters! server params: [" + str + "], " + string;
        com.anythink.core.common.k.p.a(this.f6968k, g.f6808x, str, string);
        if (eVar == null || strArr == null) {
            return;
        }
        try {
            com.anythink.core.common.j.c.a(eVar, strArr[0], strArr.length > 1 ? strArr[1] : null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String[] strArr, IATAdFilter iATAdFilter) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap = this.W;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (this.W == null) {
            this.W = new ConcurrentHashMap<>();
        }
        for (String str : strArr) {
            this.W.put(str, iATAdFilter);
        }
    }

    public final void a(ATPrivacyConfig aTPrivacyConfig) {
        this.Y = aTPrivacyConfig;
    }

    static /* synthetic */ void a(n nVar, Context context) {
        long jCurrentTimeMillis = nVar.f6962d;
        try {
            String strB = com.anythink.core.common.k.p.b(a().f6968k, g.f6799o, a().p() + "playRecord", "");
            if (!TextUtils.isEmpty(strB)) {
                JSONObject jSONObject = new JSONObject(strB);
                long jOptLong = jSONObject.optLong("start_time");
                long jOptLong2 = jSONObject.optLong("end_time");
                String strOptString = jSONObject.optString(e.f6775c);
                int iOptInt = jSONObject.optInt(e.f6776d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.j.c.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                    new StringBuilder("Create new psid, SDKContext.init to send playTime:").append((jOptLong2 - jOptLong) / 1000);
                } else {
                    try {
                        new StringBuilder("Psid is old, use pervioud statime，close before:").append((jOptLong2 - jOptLong) / 1000);
                        jCurrentTimeMillis = jOptLong;
                    } catch (Exception unused) {
                        jCurrentTimeMillis = jOptLong;
                        com.anythink.core.common.k.p.a(a().f6968k, g.f6799o, a().p() + "playRecord", "");
                    }
                }
                com.anythink.core.common.k.p.a(a().f6968k, g.f6799o, a().p() + "playRecord", "");
            }
        } catch (Exception unused2) {
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = com.anythink.core.common.k.p.a(context, g.f6799o, g.o.f6916h, (Long) 0L).longValue();
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new e(jCurrentTimeMillis));
    }

    static /* synthetic */ void a(n nVar, Context context, ATNetworkConfig aTNetworkConfig) {
        ATInitConfig aTInitConfig;
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new ArrayList<>(2);
        }
        if (nVar.v()) {
            aTInitConfigList.clear();
        }
        boolean z2 = false;
        nVar.J = aTInitConfigList.size() > 0;
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            aTInitConfig = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
            try {
                aTInitConfigList.add(0, aTInitConfig);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            aTInitConfig = null;
        }
        for (ATInitConfig aTInitConfig2 : aTInitConfigList) {
            if (aTInitConfig2 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig2.getClass().getSimpleName())) {
                    if (!z2) {
                        z2 = true;
                    }
                }
                com.anythink.core.common.k.b.a.a().a(nVar.new AnonymousClass5(aTInitConfig2, context));
            }
        }
    }
}
