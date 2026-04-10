package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a {
    private JSONObject A;
    private int C;
    private String D;
    private String a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f1594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1595k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f1599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f1600p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1608x;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f1596l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1597m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f1598n = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1601q = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<GMSettingConfigCallback> f1602r = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<String, Boolean> f1603s = new HashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicBoolean f1604t = new AtomicBoolean(false);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1605u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Map<String, String> f1606v = new ConcurrentHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map<String, List<String>> f1607w = new ConcurrentHashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Map<String, e> f1609y = new ConcurrentHashMap();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1610z = 0;
    private final List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d> B = new CopyOnWriteArrayList();

    class a implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d$a$a, reason: collision with other inner class name */
        class C0048a implements GMConfigCallback {
            C0048a(a aVar) {
            }

            @Override // com.bytedance.msdk.api.v2.GMConfigCallback
            public void onConfigLoadFail(AdError adError) {
            }

            @Override // com.bytedance.msdk.api.v2.GMConfigCallback
            public void onConfigLoaded(List<String> list) {
                Logger.d("TMe", "初始化更新pangle配置成功");
            }
        }

        a(boolean z2, boolean z3) {
            this.a = z2;
            this.b = z3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b
        public void a() {
            Logger.e("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + this.a);
            if (this.a) {
                if (!d.this.f1604t.get()) {
                    d.this.f1604t.set(true);
                    int iC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.c();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.h();
                    if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.d()) {
                        Logger.d("TMe", "-----==---- 正常上报sdk_init_end");
                        h.a(jElapsedRealtime, iC, this.b ? 1 : 0, -1L);
                    } else {
                        Logger.d("TMe", "-----==---- 延时上报sdk_init_end");
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(jElapsedRealtime, iC, this.b ? 1 : 0);
                    }
                    d.this.W();
                    Logger.d("TTMediationSDK", "sdk init end, duration: " + jElapsedRealtime + ", initAdnCount: " + iC + ", isFromLocalConfig: " + this.b);
                }
                c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a(new C0048a(this));
                d.this.X();
                if (this.b) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.c();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.i();
            }
        }
    }

    public static String L() {
        return "tt_sdk_adn_init_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
    }

    public static String M() {
        return "tt_sdk_app_common_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
    }

    public static String N() {
        return "tt_sdk_rit_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
    }

    public static e0 O() {
        return e0.a(L(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static e0 P() {
        return e0.a(M(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static String Q() {
        return "tt_sdk_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
    }

    public static e0 R() {
        return e0.a(N(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static e0 S() {
        return e0.a(Q(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static e0 T() {
        return e0.a(U(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static String U() {
        return "tt_sdk_splash_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
    }

    private boolean V() {
        Boolean bool = this.f1603s.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.B.size() > 0) {
            synchronized (this.B) {
                Iterator<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d> it = this.B.iterator();
                while (it.hasNext()) {
                    it.next().callback();
                }
                this.B.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (y()) {
            synchronized (this.f1602r) {
                Iterator<GMSettingConfigCallback> it = this.f1602r.iterator();
                while (it.hasNext()) {
                    it.next().configLoad();
                }
                this.f1602r.clear();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c.a().a(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONArray r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L5d
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1 = 0
            r2 = 0
        La:
            int r3 = r9.length()
            if (r2 >= r3) goto L51
            org.json.JSONObject r3 = r9.optJSONObject(r2)
            if (r3 == 0) goto L4e
            java.lang.String r4 = "break_request_error_code"
            org.json.JSONArray r4 = r3.optJSONArray(r4)
            if (r4 == 0) goto L4e
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
        L24:
            int r7 = r4.length()
            if (r6 >= r7) goto L34
            java.lang.String r7 = r4.optString(r6)
            r5.add(r7)
            int r6 = r6 + 1
            goto L24
        L34:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b r4 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b
            r4.<init>()
            java.lang.String r6 = "break_request_duration"
            long r6 = r3.optLong(r6)
            r4.a(r6)
            r4.a(r5)
            java.lang.String r5 = "adn_name"
            java.lang.String r3 = r3.optString(r5)
            r0.put(r3, r4)
        L4e:
            int r2 = r2 + 1
            goto La
        L51:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c.a()
            r1.a(r0)
            java.lang.String r0 = r9.toString()
            goto L74
        L5d:
            r9 = 31
            switch(r9) {
                case 29: goto L6d;
                case 30: goto L74;
                case 31: goto L63;
                default: goto L62;
            }
        L62:
            goto L5d
        L63:
            r1 = 39
            switch(r1) {
                case 37: goto L74;
                case 38: goto L69;
                case 39: goto L6d;
                default: goto L68;
            }
        L68:
            goto L74
        L69:
            switch(r9) {
                case 64: goto L74;
                case 65: goto L6d;
                case 66: goto L5d;
                default: goto L6c;
            }
        L6c:
            goto L74
        L6d:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c r9 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c.a()
            r9.a(r0)
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.a(org.json.JSONArray):java.lang.String");
    }

    private void b(JSONObject jSONObject) {
        this.f1606v.clear();
        this.f1605u = 0;
        if (jSONObject == null) {
            return;
        }
        this.f1605u = jSONObject.optInt("if_sample", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (jSONObjectOptJSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                            this.f1606v.put(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(JSONObject jSONObject) {
        this.f1607w.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                if (jSONArrayOptJSONArray.get(i2) != null) {
                                    arrayList.add(jSONArrayOptJSONArray.get(i2).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.f1607w.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f1609y.put(next, e.a(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    private String e(JSONObject jSONObject) {
        this.f1603s.clear();
        if (jSONObject != null) {
            try {
                if (jSONObject.optBoolean("ad_event_control")) {
                    this.f1603s.put("ad_event_control", true);
                }
                if (jSONObject.optBoolean("type_banner_control")) {
                    this.f1603s.put("type_banner_control", true);
                }
                if (jSONObject.optBoolean("type_interaction_control")) {
                    this.f1603s.put("type_interaction_control", true);
                }
                if (jSONObject.optBoolean("type_interactionfull_control")) {
                    this.f1603s.put("type_interactionfull_control", true);
                }
                if (jSONObject.optBoolean("type_splash_control")) {
                    this.f1603s.put("type_splash_control", true);
                }
                if (jSONObject.optBoolean("type_feed_control")) {
                    this.f1603s.put("type_feed_control", true);
                }
                if (jSONObject.optBoolean("type_reward_control")) {
                    this.f1603s.put("type_reward_control", true);
                }
                if (jSONObject.optBoolean("type_full_control")) {
                    this.f1603s.put("type_full_control", true);
                }
                if (jSONObject.optBoolean("type_native_control")) {
                    this.f1603s.put("type_native_control", true);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.f1595k = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    public boolean A() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean B() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean C() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean D() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean E() {
        return this.f1597m == 1;
    }

    public boolean F() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean G() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean H() {
        if (this.f1601q == Integer.MAX_VALUE) {
            this.f1601q = 1;
        }
        return this.f1601q == 1;
    }

    public boolean I() {
        return this.f1608x == 1;
    }

    public boolean J() {
        return this.f1595k == 1;
    }

    public boolean K() {
        return this.C == 1;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(str);
    }

    public List<String> a(List<String> list) {
        if (list != null && list.size() > 0) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void a() {
        S().a();
        this.a = null;
    }

    public void a(int i2) {
        this.f1608x = i2;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d dVar) {
        if (dVar == null || !u()) {
            this.B.add(dVar);
        } else {
            dVar.callback();
        }
    }

    public void a(GMSettingConfigCallback gMSettingConfigCallback) {
        if (gMSettingConfigCallback == null) {
            return;
        }
        if (y()) {
            gMSettingConfigCallback.configLoad();
            return;
        }
        synchronized (this.f1602r) {
            if (!this.f1602r.contains(gMSettingConfigCallback)) {
                this.f1602r.add(gMSettingConfigCallback);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        e0 e0VarS = S();
        this.b = jSONObject.optLong("max_age");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.b;
        this.f1587c = jCurrentTimeMillis + j2;
        e0VarS.b("max_age", j2);
        e0VarS.b("max_expire_time", this.f1587c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        if (r0 <= 68) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        switch(r0) {
            case 10: goto L85;
            case 11: goto L86;
            case 12: goto L88;
            default: goto L84;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r0 >= 3) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        r2 = 'X';
        r0 = -16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        switch(r2) {
            case 87: goto L12;
            case 88: goto L82;
            case 89: goto L81;
            default: goto L83;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
    
        return;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003b -> B:7:0x0029). Please report as a decompilation issue!!! */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONObject r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.a(org.json.JSONObject, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b7 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e9 A[Catch: all -> 0x02c6, TRY_ENTER, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0211 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0221 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0238 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024c A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0260 A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x026c A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027b A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ad A[Catch: all -> 0x02c6, TryCatch #1 {all -> 0x02c6, blocks: (B:10:0x000f, B:12:0x001d, B:14:0x0027, B:17:0x0035, B:33:0x00aa, B:37:0x00be, B:40:0x00ca, B:42:0x00e3, B:46:0x00f4, B:47:0x00f8, B:22:0x004a, B:24:0x0065, B:29:0x0096, B:31:0x009e, B:48:0x0113, B:50:0x01b7, B:51:0x01bd, B:53:0x01c9, B:54:0x01d1, B:57:0x01e9, B:59:0x01ef, B:61:0x01f5, B:62:0x01fd, B:63:0x0205, B:65:0x0211, B:66:0x0219, B:68:0x0221, B:69:0x022c, B:71:0x0238, B:72:0x0240, B:74:0x024c, B:75:0x0254, B:77:0x0260, B:79:0x026f, B:81:0x027b, B:83:0x0281, B:85:0x0287, B:86:0x028f, B:88:0x0295, B:89:0x02a1, B:91:0x02ad, B:93:0x02b3, B:95:0x02b9, B:78:0x026c, B:26:0x0077, B:19:0x0043), top: B:104:0x000f, inners: #0, #2 }] */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r13) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.a(boolean):void");
    }

    public boolean a(String str, int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarB;
        return !TextUtils.isEmpty(str) && (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || (cVarB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str)) == null || cVarB.s() == i2);
    }

    public boolean a(String str, String str2) {
        List<j> listB;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str);
        if (cVarB != null && (listB = cVarB.B()) != null) {
            for (j jVar : listB) {
                if (jVar != null && TextUtils.equals(jVar.d(), str2)) {
                    return jVar.C();
                }
            }
        }
        return false;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a b(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(str);
    }

    public void b(int i2) {
        this.f1601q = i2;
    }

    public void b(GMSettingConfigCallback gMSettingConfigCallback) {
        if (gMSettingConfigCallback == null) {
            return;
        }
        synchronized (this.f1602r) {
            if (this.f1602r.contains(gMSettingConfigCallback)) {
                this.f1602r.remove(gMSettingConfigCallback);
            }
        }
    }

    public void b(boolean z2) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a().a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), new a(x(), z2));
    }

    public boolean b() {
        return this.f1610z == 1;
    }

    public boolean b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(it.next()) == null) {
                return false;
            }
        }
        return true;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str);
    }

    public String c() {
        return this.f1596l;
    }

    public long d(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarC = c(str);
        return cVarC != null ? cVarC.d() : m.ag;
    }

    public String d() {
        return this.f1598n;
    }

    public Map<String, String> e() {
        return this.f1606v;
    }

    public boolean e(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarB;
        Map<Integer, List<j>> mapA;
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || !(TextUtils.isEmpty(str) || (cVarB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str)) == null || (mapA = cVarB.A()) == null || mapA.size() == 0);
    }

    public String f() {
        return this.f1590f;
    }

    public boolean f(String str) {
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().e() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str) == null) ? false : true;
    }

    public Map<String, List<String>> g() {
        return this.f1607w;
    }

    public boolean g(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().d(str);
    }

    public String h() {
        if (this.a == null) {
            this.a = S().d("etag");
        }
        return this.a;
    }

    public void h(String str) {
        boolean z2;
        try {
            e0 e0VarS = S();
            if ("2".equals(str)) {
                z2 = true;
                this.f1603s.put("active_control", true);
            } else {
                z2 = false;
                this.f1603s.put("active_control", false);
            }
            e0VarS.b("all_active_control", z2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int i() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b();
    }

    public int j() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().f();
    }

    public String k() {
        return this.D;
    }

    public int l() {
        return this.f1608x;
    }

    public Map<String, e> m() {
        return this.f1609y;
    }

    public long n() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().c();
    }

    public String o() {
        return this.f1591g;
    }

    public boolean p() {
        return Integer.valueOf(this.f1593i).intValue() > 0;
    }

    public boolean q() {
        return "1".equals(this.f1594j);
    }

    public boolean r() {
        return this.f1592h >= 1;
    }

    public boolean s() {
        try {
            return Integer.valueOf(this.f1593i).intValue() > 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean t() {
        return this.f1605u == 1;
    }

    public boolean u() {
        return this.f1604t.get();
    }

    public boolean v() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean w() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean x() {
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().e()) ? false : true;
    }

    public boolean y() {
        return (TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b()) || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || !u()) ? false : true;
    }

    public boolean z() {
        if (!V()) {
            return false;
        }
        Boolean bool = this.f1603s.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }
}
