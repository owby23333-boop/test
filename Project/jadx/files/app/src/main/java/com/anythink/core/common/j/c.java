package com.anythink.core.common.j;

import android.os.PowerManager;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.an;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.g;
import com.anythink.core.common.e.h;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.z;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7606c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7607d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7608e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7609f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7610g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7611h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7612i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7613j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7614k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7615l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7616m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7617n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7618o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7619p = 0;

    public static void b(String str, String str2, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004666";
        hVar.f7264m = str;
        hVar.f7265n = str2;
        hVar.f7266o = str3;
        a(hVar);
    }

    public static void a(e eVar, AdError adError) {
        try {
            h hVar = new h(eVar.Y(), null);
            hVar.a = "1004630";
            hVar.b = eVar.X();
            hVar.f7255d = eVar.W();
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7262k = String.valueOf(eVar.F());
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
            hVar.f7261j = dVarA != null ? dVarA.U() : "";
            if (adError != null) {
                hVar.f7264m = adError.printStackTrace();
                hVar.f7265n = adError.getCode();
            }
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(h hVar, String str) {
        String str2 = hVar.B;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.equals(str2, jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static /* synthetic */ boolean b(h hVar, com.anythink.core.c.a aVar) {
        Map<String, String> mapE;
        if (TextUtils.isEmpty(hVar.a) || TextUtils.isEmpty(hVar.B) || TextUtils.isEmpty(hVar.A) || (mapE = aVar.e(hVar.a)) == null) {
            return false;
        }
        if (mapE.containsKey("0")) {
            String str = mapE.get("0");
            if (TextUtils.isEmpty(str) || !str.contains(hVar.A)) {
                return false;
            }
        } else {
            if (!mapE.containsKey(hVar.B)) {
                return false;
            }
            String str2 = mapE.get(hVar.B);
            if (TextUtils.isEmpty(str2) || !str2.contains(hVar.A)) {
                return false;
            }
        }
        return true;
    }

    private static void a(String str, String str2, int i2, int i3, int i4, String str3, String str4, int i5, int i6, AdError adError, int i7, double d2, long j2, int i8, int i9, int i10, String str5, String str6) {
        h hVar = new h(str4, String.valueOf(i4));
        hVar.a = "1004631";
        hVar.b = str;
        hVar.f7255d = str2;
        hVar.f7258g = String.valueOf(i2);
        hVar.f7262k = String.valueOf(i3);
        hVar.f7263l = String.valueOf(i8);
        hVar.f7264m = String.valueOf(i4);
        hVar.f7265n = str3;
        hVar.f7266o = String.valueOf(i5);
        hVar.f7267p = String.valueOf(i6);
        hVar.f7268q = adError != null ? adError.getPlatformCode() : "";
        hVar.f7269r = adError != null ? adError.getPlatformMSG() : "";
        hVar.f7270s = String.valueOf(i7);
        hVar.f7271t = String.valueOf(d2);
        if (i6 == 0) {
            hVar.f7272u = String.valueOf(j2);
        }
        hVar.f7273v = String.valueOf(i9);
        hVar.f7274w = String.valueOf(i10);
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(str2);
        hVar.f7261j = dVarA != null ? dVarA.U() : "";
        hVar.C = str5;
        hVar.D = str6;
        a(hVar);
    }

    public static void a(e eVar, int i2, AdError adError) {
        try {
            a(eVar.X(), eVar.W(), eVar.I(), eVar.F(), eVar.H(), eVar.x(), eVar.Y(), -1, i2, adError, eVar.v(), eVar.w(), 0L, eVar.U(), eVar.L(), eVar.f7243q, eVar.P(), eVar.Q());
        } catch (Throwable unused) {
        }
    }

    public static void a(e eVar, int i2, AdError adError, long j2) {
        try {
            a(eVar.X(), eVar.W(), eVar.I(), eVar.F(), eVar.H(), eVar.x(), eVar.Y(), eVar.z(), i2, adError, eVar.v(), eVar.w(), j2, eVar.U(), eVar.L(), eVar.f7243q, eVar.P(), eVar.Q());
        } catch (Throwable unused) {
        }
    }

    public static void a(e eVar, int i2, String str, String str2) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004633";
            hVar.b = eVar.X();
            hVar.f7255d = eVar.W();
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7262k = String.valueOf(eVar.F());
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7264m = String.valueOf(i2);
            hVar.f7265n = str;
            hVar.f7268q = str2;
            if (TextUtils.equals(str2, eVar.X())) {
                hVar.f7269r = "0";
            } else {
                hVar.f7269r = "1";
            }
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
            hVar.f7261j = dVarA != null ? dVarA.U() : "";
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(e eVar, boolean z2) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004634";
        hVar.b = eVar.X();
        hVar.f7255d = eVar.W();
        hVar.f7258g = String.valueOf(eVar.I());
        hVar.f7262k = String.valueOf(eVar.F());
        hVar.f7263l = String.valueOf(eVar.U());
        hVar.f7264m = String.valueOf(eVar.H());
        hVar.f7265n = eVar.x();
        hVar.f7266o = String.valueOf(eVar.A());
        hVar.f7267p = z2 ? "1" : "0";
        hVar.f7268q = String.valueOf(eVar.f7252z);
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
        hVar.f7261j = dVarA != null ? dVarA.U() : "";
        hVar.A = eVar.Y();
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(final e eVar, final boolean z2, final int i2, final int i3, final String str, final int i4, final String str2, final String str3, final String str4, final boolean z3, final String str5) {
        try {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
                    hVar.a = "1004632";
                    hVar.b = eVar.X();
                    hVar.f7255d = eVar.W();
                    hVar.f7258g = String.valueOf(eVar.I());
                    hVar.f7262k = String.valueOf(eVar.F());
                    hVar.f7263l = String.valueOf(eVar.U());
                    hVar.f7264m = z2 ? "1" : "0";
                    hVar.f7265n = String.valueOf(i2);
                    hVar.f7266o = String.valueOf(i3);
                    hVar.f7267p = str;
                    hVar.f7268q = String.valueOf(i4);
                    hVar.f7269r = str2;
                    hVar.f7270s = str3;
                    String str6 = str4;
                    hVar.f7271t = str6;
                    if (TextUtils.equals(str6, eVar.X())) {
                        hVar.f7272u = "0";
                    } else {
                        hVar.f7272u = "1";
                    }
                    if (z3) {
                        hVar.f7273v = "1";
                    } else {
                        hVar.f7273v = "0";
                    }
                    hVar.f7274w = str5;
                    com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
                    hVar.f7261j = dVarA != null ? dVarA.U() : "";
                    hVar.A = eVar.Y();
                    hVar.C = eVar.P();
                    hVar.D = eVar.Q();
                    c.a(hVar);
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void a(e eVar, AdError adError, Map<String, Object> map) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004636";
        hVar.b = eVar.X();
        hVar.f7255d = eVar.W();
        hVar.f7258g = String.valueOf(eVar.I());
        hVar.f7262k = String.valueOf(eVar.F());
        hVar.f7263l = String.valueOf(eVar.U());
        hVar.f7264m = String.valueOf(eVar.H());
        hVar.f7265n = eVar.x();
        hVar.f7266o = String.valueOf(eVar.A());
        hVar.f7267p = adError.getCode();
        hVar.f7268q = adError.getPlatformCode();
        hVar.f7269r = adError.getPlatformMSG();
        com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
        hVar.f7261j = dVarA != null ? dVarA.U() : "";
        hVar.A = eVar.Y();
        if (map != null) {
            try {
                if (map.containsKey("offer_id")) {
                    hVar.f7270s = map.get("offer_id").toString();
                }
            } catch (Throwable unused) {
            }
        }
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        h hVar = new h(null, null);
        hVar.a = "1004616";
        hVar.f7255d = str5;
        hVar.f7264m = str;
        hVar.f7265n = str2;
        hVar.f7266o = str3;
        hVar.f7267p = str4;
        hVar.f7268q = str6;
        hVar.f7269r = str7;
        a(hVar);
    }

    public static void a(String str, String str2, long j2, long j3, long j4) {
        h hVar = new h(null, null);
        hVar.a = "1004635";
        if (!TextUtils.isEmpty(str2)) {
            hVar.f7255d = str2;
        }
        hVar.f7264m = str;
        hVar.f7265n = String.valueOf(j2);
        hVar.f7266o = String.valueOf(j3);
        hVar.f7267p = String.valueOf(j4);
        a(hVar);
    }

    public static void a(String str, String str2, String str3, String str4) {
        h hVar = new h(null, null);
        hVar.a = "1004637";
        hVar.f7255d = str;
        hVar.f7264m = str2;
        hVar.f7265n = str3;
        hVar.f7266o = str4;
        a(hVar);
    }

    public static void a(String str, String str2, String str3, String str4, long j2, String str5, long j3, long j4, int i2, long j5) {
        h hVar = new h(null, null);
        hVar.a = "1004638";
        hVar.f7255d = str;
        hVar.f7264m = str2;
        hVar.f7265n = str3;
        hVar.f7266o = str4;
        hVar.f7267p = String.valueOf(j2);
        hVar.f7268q = str5;
        hVar.f7269r = String.valueOf(j3);
        hVar.f7270s = String.valueOf(j4);
        hVar.f7271t = "1".equals(str4) ? String.valueOf(j5) : null;
        hVar.f7272u = String.valueOf(i2);
        a(hVar);
    }

    public static void a(e eVar) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004640";
            hVar.b = eVar.X();
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7255d = eVar.W();
            hVar.f7264m = String.valueOf(eVar.H());
            hVar.f7265n = eVar.x();
            hVar.f7266o = String.valueOf(eVar.z());
            hVar.f7267p = String.valueOf(eVar.J());
            hVar.f7268q = String.valueOf(eVar.K());
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            hVar.A = eVar.Y();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(e eVar, String str) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004639";
            hVar.b = eVar.X();
            hVar.f7255d = eVar.W();
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7264m = String.valueOf(eVar.H());
            hVar.f7265n = eVar.x();
            hVar.f7266o = String.valueOf(eVar.z());
            hVar.f7267p = str;
            hVar.A = eVar.Y();
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(int i2, int i3, int i4, int i5) {
        h hVar = new h(null, String.valueOf(i5));
        hVar.a = "1004641";
        hVar.f7264m = String.valueOf(i2);
        hVar.f7265n = String.valueOf(i3);
        hVar.f7266o = String.valueOf(i4);
        hVar.f7267p = String.valueOf(i5);
        a(hVar);
    }

    public static void a(String str, String str2, String str3, int i2, String str4, long j2, long j3) {
        h hVar = new h(null, null);
        hVar.a = "1004642";
        hVar.b = str;
        hVar.f7264m = str2;
        hVar.f7265n = str3;
        hVar.f7266o = String.valueOf(i2);
        if (i2 == 3 || i2 == 10) {
            hVar.f7267p = str4;
        } else if (i2 == 2) {
            hVar.f7268q = String.valueOf(j2);
            hVar.f7269r = String.valueOf(j3 / 1024.0f);
        }
        a(hVar);
    }

    public static void a(int i2, long j2, long j3, String str) {
        h hVar = new h(null, null);
        hVar.a = "1004644";
        hVar.f7256e = str;
        hVar.f7264m = String.valueOf(i2);
        hVar.f7265n = String.valueOf(j2);
        hVar.f7266o = String.valueOf(j3);
        hVar.f7267p = String.valueOf(j3 - j2);
        a(hVar);
    }

    private static void a(int i2, long j2, long j3, String str, String str2) {
        h hVar = new h(null, null);
        hVar.a = "1004651";
        hVar.f7256e = str;
        hVar.f7264m = String.valueOf(i2);
        hVar.f7265n = String.valueOf(j3 - j2);
        hVar.f7266o = str2;
        a(hVar);
    }

    public static void a(e eVar, boolean z2, long j2, long j3, long j4) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004643";
            hVar.b = eVar.X();
            hVar.f7255d = eVar.W();
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7262k = String.valueOf(eVar.F());
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7264m = eVar.Y();
            hVar.f7265n = String.valueOf(j2);
            hVar.f7266o = String.valueOf(j3);
            hVar.f7267p = String.valueOf(j4);
            hVar.f7268q = String.valueOf(eVar.H());
            hVar.f7269r = eVar.x();
            hVar.f7270s = String.valueOf(eVar.A());
            hVar.f7271t = String.valueOf(eVar.f7252z);
            hVar.f7272u = z2 ? "1" : "0";
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(eVar.W());
            hVar.f7261j = dVarA != null ? dVarA.U() : "";
            hVar.A = eVar.Y();
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(e eVar, com.anythink.core.c.d dVar, String str, String str2) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004658";
            hVar.b = eVar.X();
            hVar.f7255d = eVar.W();
            hVar.f7258g = String.valueOf(eVar.I());
            hVar.f7262k = String.valueOf(eVar.F());
            hVar.f7263l = String.valueOf(eVar.U());
            hVar.f7261j = dVar != null ? dVar.U() : "";
            hVar.f7264m = String.valueOf(eVar.H());
            hVar.f7265n = eVar.x();
            hVar.f7266o = eVar.l();
            hVar.f7267p = eVar.e();
            hVar.f7268q = eVar.C;
            hVar.f7269r = str;
            hVar.f7270s = str2;
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(j jVar, i iVar, int i2) {
        try {
            h hVar = new h(String.valueOf(jVar.f7309j), String.valueOf(jVar.f7305f));
            hVar.a = "1004679";
            hVar.b = jVar.f7303d;
            hVar.f7255d = jVar.b;
            if (iVar instanceof g) {
                hVar.f7264m = ((g) iVar).T();
            }
            hVar.f7265n = jVar.f7302c;
            hVar.f7266o = iVar.p();
            hVar.f7267p = String.valueOf(iVar.d());
            hVar.f7268q = iVar.e();
            hVar.f7269r = iVar.f();
            hVar.f7270s = String.valueOf(i2);
            a(hVar);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, com.anythink.core.c.d dVar, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004646";
        hVar.b = str;
        hVar.f7255d = str2;
        hVar.f7258g = String.valueOf(dVar.ae());
        hVar.f7263l = String.valueOf(dVar.O());
        hVar.f7261j = dVar.U();
        hVar.f7271t = String.valueOf(str3);
        a(hVar);
    }

    public static void a(String str, String str2, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004647";
        hVar.f7256e = str3;
        hVar.f7264m = str2;
        hVar.f7265n = str;
        a(hVar);
    }

    public static void a(j jVar, i iVar, String str, String str2, String str3, String str4) {
        if (jVar == null || iVar == null) {
            return;
        }
        h hVar = new h(null, null);
        hVar.a = "1004648";
        hVar.f7255d = jVar.b;
        hVar.f7264m = iVar.p();
        hVar.f7265n = String.valueOf(iVar.d());
        hVar.f7266o = str;
        hVar.f7267p = str2;
        hVar.f7268q = str3;
        hVar.f7269r = str4;
        hVar.b = jVar.f7303d;
        a(hVar);
    }

    public static void a(j jVar, i iVar, String str, String str2, int i2) {
        if (jVar == null || iVar == null) {
            return;
        }
        h hVar = new h(String.valueOf(jVar.f7309j), String.valueOf(jVar.f7305f));
        hVar.a = "1004650";
        hVar.f7255d = jVar.b;
        hVar.f7264m = iVar.p();
        hVar.f7265n = String.valueOf(iVar.d());
        hVar.f7266o = str;
        hVar.f7267p = str2;
        hVar.f7268q = String.valueOf(i2);
        hVar.b = jVar.f7303d;
        hVar.f7271t = String.valueOf(jVar.f7309j);
        a(hVar);
    }

    public static void a(i iVar, j jVar, String str, String str2) {
        if (iVar == null || jVar == null) {
            return;
        }
        h hVar = new h(String.valueOf(jVar.f7309j), String.valueOf(jVar.f7305f));
        hVar.a = "1004652";
        hVar.f7255d = jVar.b;
        hVar.f7264m = String.valueOf(jVar.f7305f);
        hVar.f7265n = jVar.f7302c;
        hVar.b = jVar.f7303d;
        if (iVar instanceof s) {
            hVar.f7266o = "1";
        } else if (iVar instanceof g) {
            hVar.f7266o = "2";
        } else if (iVar instanceof z) {
            hVar.f7266o = "3";
        }
        hVar.f7267p = str;
        if (TextUtils.equals("0", str)) {
            hVar.f7268q = str2;
        }
        hVar.f7269r = iVar.p();
        hVar.f7270s = iVar.q();
        hVar.f7271t = iVar.B();
        hVar.f7272u = iVar.r();
        hVar.f7273v = iVar.s();
        hVar.f7274w = iVar.t();
        hVar.f7275x = iVar.u();
        hVar.f7276y = iVar.x();
        try {
            if (iVar instanceof aa) {
                StringBuilder sb = new StringBuilder();
                String strZ = ((aa) iVar).Z();
                if (!TextUtils.isEmpty(strZ)) {
                    JSONArray jSONArray = new JSONArray(strZ);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(jSONArray.optString(i2));
                        sb.append(",");
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    hVar.f7277z = sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        a(hVar);
    }

    public static void a() {
        h hVar = new h(null, null);
        hVar.a = "1004657";
        a(hVar);
    }

    public static void a(e eVar, ai aiVar, double d2, String str) {
        h hVar = new h(String.valueOf(eVar.Y()), String.valueOf(aiVar.c()));
        hVar.a = "1004659";
        hVar.b = eVar.X();
        hVar.f7255d = eVar.W();
        hVar.f7258g = String.valueOf(eVar.I());
        hVar.f7263l = String.valueOf(eVar.U());
        hVar.f7261j = eVar.V();
        hVar.f7264m = String.valueOf(aiVar.c());
        hVar.f7265n = aiVar.t();
        hVar.f7266o = String.valueOf(d2);
        hVar.f7267p = str;
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(ai aiVar, com.anythink.core.common.e.a aVar, long j2, boolean z2, boolean z3) {
        h hVar = new h(String.valueOf(aVar.f7082e), String.valueOf(aiVar.c()));
        hVar.a = "1004660";
        com.anythink.core.c.d dVar = aVar.f7091n;
        hVar.b = aVar.f7080c;
        hVar.f7255d = aVar.f7081d;
        String strC = "";
        hVar.f7258g = String.valueOf(dVar != null ? Integer.valueOf(dVar.ae()) : "");
        hVar.f7263l = String.valueOf(dVar != null ? Integer.valueOf(dVar.O()) : "");
        hVar.f7261j = dVar != null ? dVar.U() : "";
        hVar.f7264m = String.valueOf(aiVar.c());
        hVar.f7265n = aiVar.t();
        hVar.f7266o = z2 ? "1" : "2";
        hVar.f7267p = String.valueOf(j2);
        hVar.f7268q = z3 ? "1" : "2";
        if (dVar != null) {
            try {
                strC = dVar.c();
            } catch (Throwable unused) {
            }
        }
        hVar.C = strC;
        try {
            Object obj = aVar.b.f7586g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                hVar.D = obj.toString();
            }
        } catch (Throwable unused2) {
        }
        a(hVar);
    }

    public static void a(String str, ai aiVar, boolean z2, long j2, com.anythink.core.common.e.a aVar) {
        com.anythink.core.c.d dVar = aVar != null ? aVar.f7091n : null;
        h hVar = new h(String.valueOf(aVar.f7082e), String.valueOf(aiVar.c()));
        hVar.a = "1004665";
        hVar.f7255d = str;
        String strC = "";
        hVar.f7261j = dVar != null ? dVar.U() : "";
        hVar.f7264m = String.valueOf(aiVar.c());
        hVar.f7265n = aiVar.t();
        hVar.f7266o = String.valueOf(z2 ? 1 : 2);
        hVar.f7267p = String.valueOf(j2);
        if (dVar != null) {
            try {
                strC = dVar.c();
            } catch (Throwable unused) {
            }
        }
        hVar.C = strC;
        try {
            Object obj = aVar.b.f7586g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                hVar.D = obj.toString();
            }
        } catch (Throwable unused2) {
        }
        a(hVar);
    }

    public static void a(an anVar) {
        if (anVar == null) {
            return;
        }
        h hVar = new h(null, String.valueOf(anVar.a()));
        hVar.a = "1004667";
        hVar.f7264m = String.valueOf(anVar.a());
        hVar.f7265n = anVar.b();
        hVar.f7266o = anVar.c();
        hVar.f7267p = anVar.d();
        hVar.f7268q = anVar.f();
        hVar.f7269r = anVar.g();
        hVar.f7270s = String.valueOf(anVar.h());
        hVar.f7271t = anVar.i();
        hVar.b = anVar.e();
        hVar.f7258g = anVar.j();
        hVar.f7263l = anVar.k();
        hVar.f7255d = anVar.l();
        String strL = anVar.l();
        if (!TextUtils.isEmpty(strL)) {
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(strL);
            hVar.f7261j = dVarA != null ? dVarA.U() : "";
        }
        a(hVar);
    }

    public static void a(e eVar, int i2, String str, double d2, String str2, String str3) {
        h hVar = new h(eVar.Y(), String.valueOf(i2));
        hVar.a = "1004668";
        hVar.f7255d = eVar.W();
        hVar.f7264m = String.valueOf(i2);
        hVar.f7265n = str;
        hVar.f7266o = String.valueOf(d2);
        hVar.f7267p = str2;
        hVar.f7268q = str3;
        hVar.f7261j = eVar.V();
        hVar.f7258g = String.valueOf(eVar.I());
        hVar.f7263l = String.valueOf(eVar.U());
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(e eVar, String str, String str2) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004669";
        hVar.b = eVar.X();
        hVar.f7255d = eVar.W();
        hVar.f7264m = String.valueOf(eVar.H());
        hVar.f7265n = str;
        hVar.f7266o = str2;
        hVar.f7261j = eVar.V();
        hVar.f7258g = String.valueOf(eVar.I());
        hVar.f7263l = String.valueOf(eVar.U());
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(String str, String str2, int i2, String str3, JSONArray jSONArray, int i3, int i4, int i5, String str4, int i6) {
        h hVar = new h(null, null);
        hVar.a = "1004675";
        hVar.b = str2;
        hVar.f7255d = str;
        hVar.f7264m = str3;
        hVar.f7265n = String.valueOf(i2);
        hVar.f7266o = jSONArray != null ? jSONArray.toString() : "";
        hVar.f7267p = String.valueOf(i3);
        hVar.f7268q = String.valueOf(i4);
        hVar.f7269r = String.valueOf(i5);
        hVar.f7270s = str4;
        hVar.f7271t = String.valueOf(i6);
        a(hVar);
    }

    private static void a(final String str, final String str2, final String str3, final String str4, final String str5, final int i2, final boolean z2, final String str6, final String str7) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.2
            @Override // java.lang.Runnable
            public final void run() {
                h hVar = new h(str4, str5);
                hVar.a = "1004680";
                hVar.b = str;
                hVar.f7255d = str2;
                hVar.f7264m = str3;
                hVar.f7265n = String.valueOf(i2);
                hVar.f7266o = z2 ? "1" : "0";
                boolean zIsScreenOn = true;
                try {
                    zIsScreenOn = ((PowerManager) n.a().g().getSystemService("power")).isScreenOn();
                } catch (Throwable unused) {
                }
                hVar.f7267p = zIsScreenOn ? "1" : "0";
                hVar.f7268q = com.anythink.core.common.k.h.a(n.a().g()) ? "1" : "0";
                hVar.f7269r = str7;
                hVar.f7270s = str6;
                c.a(hVar);
            }
        });
    }

    protected static void a(final h hVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.3
            /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0115  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 364
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.c.AnonymousClass3.run():void");
            }
        });
    }

    private static boolean a(h hVar, com.anythink.core.c.a aVar) {
        Map<String, String> mapE;
        if (TextUtils.isEmpty(hVar.a) || TextUtils.isEmpty(hVar.B) || TextUtils.isEmpty(hVar.A) || (mapE = aVar.e(hVar.a)) == null) {
            return false;
        }
        if (mapE.containsKey("0")) {
            String str = mapE.get("0");
            if (TextUtils.isEmpty(str) || !str.contains(hVar.A)) {
                return false;
            }
        } else {
            if (!mapE.containsKey(hVar.B)) {
                return false;
            }
            String str2 = mapE.get(hVar.B);
            if (TextUtils.isEmpty(str2) || !str2.contains(hVar.A)) {
                return false;
            }
        }
        return true;
    }

    public static void a(final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                h hVarA = h.a(str);
                if (TextUtils.isEmpty(hVarA.a)) {
                    return;
                }
                c.a(hVarA);
            }
        });
    }
}
