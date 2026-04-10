package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String a = "none";
    public static final String b = "text";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12782c = "static_image";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12783d = "gif";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12784e = "rich_media";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12785f = "html";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12786g = "hybrid";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12787h = "video";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f12788i = 1750000;
    private String A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String K;
    private List<String> M;
    private JSONObject N;
    private long O;
    private long P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private JSONObject X;
    private int Y;
    private int Z;
    private int aa;
    private List<String> ab;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f12790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f12791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f12792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f12793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f12794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f12795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f12796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f12797r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f12799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f12800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f12801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f12802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f12803x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f12804y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f12805z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f12798s = 1;
    private String L = "none";
    private int ac = 0;

    /* JADX WARN: Removed duplicated region for block: B:41:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148 A[Catch: all -> 0x0177, JSONException -> 0x017c, TryCatch #3 {JSONException -> 0x017c, all -> 0x0177, blocks: (B:5:0x007c, B:8:0x008c, B:10:0x009d, B:11:0x00b6, B:13:0x00c2, B:15:0x00cd, B:17:0x00d3, B:18:0x00d5, B:20:0x00db, B:22:0x00e1, B:24:0x00e9, B:28:0x00f2, B:30:0x00fc, B:31:0x011b, B:33:0x0121, B:34:0x0127, B:36:0x012f, B:38:0x0135, B:40:0x013f, B:43:0x0148, B:45:0x0156, B:47:0x015d, B:48:0x0165, B:50:0x016b), top: B:101:0x007c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instruction units count: 793
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String A() {
        return this.f12805z;
    }

    public String B() {
        return this.f12804y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public long E() {
        return this.P;
    }

    public List<String> F() {
        return this.M;
    }

    public String G() {
        return this.Q;
    }

    public JSONObject H() {
        return this.N;
    }

    public String I() {
        return this.T;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        String str = this.W;
        return (str == null || str.length() <= 4) ? this.W : "";
    }

    public int M() {
        return this.aa;
    }

    public List<String> N() {
        return this.ab;
    }

    public JSONObject O() {
        return this.X;
    }

    public int P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.ac;
    }

    public JSONObject S() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.Q);
            jSONObject.put("tit", this.f12789j);
            jSONObject.put("desc", this.f12790k);
            jSONObject.put("pk", this.f12801v);
            jSONObject.put("appname", this.f12795p);
            jSONObject.put("act", this.C);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return this.f12790k;
    }

    public String c() {
        return this.f12791l;
    }

    public String d() {
        return this.f12792m;
    }

    public int e() {
        return this.f12793n;
    }

    public int f() {
        return this.f12794o;
    }

    public String g() {
        return this.f12795p;
    }

    public String h() {
        return this.R;
    }

    public String i() {
        return this.S;
    }

    public long j() {
        return this.f12796q;
    }

    public int k() {
        return this.f12797r;
    }

    public int l() {
        return this.f12798s;
    }

    public String m() {
        return this.f12801v;
    }

    public String n() {
        return this.f12802w;
    }

    public String o() {
        return this.f12803x;
    }

    public int p() {
        return this.C;
    }

    public String q() {
        return this.D;
    }

    public int r() {
        return this.E;
    }

    public int s() {
        return this.F;
    }

    public int t() {
        return this.G;
    }

    public int u() {
        return this.H;
    }

    public int v() {
        return this.I;
    }

    public int w() {
        return this.J;
    }

    public String x() {
        return this.L;
    }

    public long y() {
        return this.O;
    }

    public String z() {
        return !TextUtils.isEmpty(this.f12800u) ? this.f12800u : this.f12799t;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] strArrSplit;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_op");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("opt_style_") && (strArrSplit = strOptString.substring(10).split("_")) != null && strArrSplit.length > 0) {
                        i4 = Integer.parseInt(strArrSplit[0]);
                    }
                }
            } catch (Throwable th) {
                bq.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String a() {
        return this.f12789j;
    }
}
