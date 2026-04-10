package com.duokan.core.async.work;

import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class b {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final String m = "work_item_local_id";
    public static final String n = "work_item_type";
    public static final String o = "work_item_max_retry_times";
    public static final String p = "work_item_cloud_id";
    public static final String q = "work_item_type_details";
    public static final String r = "work_item_status";
    public static final String s = "work_item_progress";
    public static final String t = "work_item_progress_numerator";
    public static final String u = "work_item_progress_denominator";
    public static final String v = "work_item_execution_result";
    public static final String w = "work_item_start_time";
    public static final String x = "work_item_end_time";
    public static final String y = "work_item_extension_data";
    public static final int z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f2779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2780b;
    public int c;
    public int d;
    public String e;
    public JSONObject f;
    public int g;
    public Pair<Long, Long> h;
    public a i;
    public long j;
    public long k;
    public JSONObject l;

    public static class a {
        public static final String g = "work_result_ok";
        public static final String h = "work_result_user_canceled";
        public static final String i = "work_result_code";
        public static final String j = "work_result_description";
        public static final String k = "work_result_recoverable";
        public static final String l = "work_result_auto_retriable";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2782b;
        public final int c;
        public final String d;
        public final boolean e;
        public final boolean f;

        public static a a(int i2, String str, boolean z, boolean z2) {
            return new a(false, false, i2, str, z, z2);
        }

        public static a b(int i2, boolean z, boolean z2) {
            return new a(false, false, i2, "", z, z2);
        }

        public static a c(int i2, String str, boolean z, boolean z2) {
            return new a(true, false, i2, str, z, z2);
        }

        public static a d(int i2, boolean z, boolean z2) {
            return new a(true, false, i2, "", z, z2);
        }

        public static a e(int i2, String str, boolean z, boolean z2) {
            return new a(false, true, i2, str, z, z2);
        }

        public static a f(int i2, boolean z, boolean z2) {
            return new a(false, true, i2, "", z, z2);
        }

        public boolean g() {
            return this.f2781a;
        }

        public boolean h() {
            return this.f2782b;
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(g, this.f2781a);
                jSONObject.put(h, this.f2782b);
                jSONObject.put(i, this.c);
                jSONObject.put(j, this.d);
                jSONObject.put(k, this.e);
                jSONObject.put(l, this.f);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public a(boolean z, boolean z2, int i2, String str, boolean z3, boolean z4) {
            this.f2781a = z;
            this.f2782b = z2;
            this.c = i2;
            this.d = str;
            this.e = z3;
            this.f = z4;
        }

        public a(JSONObject jSONObject) {
            this.f2781a = jSONObject.optBoolean(g);
            this.f2782b = jSONObject.optBoolean(h);
            this.c = jSONObject.optInt(i);
            this.d = jSONObject.optString(j);
            this.e = jSONObject.optBoolean(k);
            this.f = jSONObject.optBoolean(l);
        }
    }

    public b(String str, int i, int i2) {
        this.i = null;
        this.f2779a = new JSONObject();
        this.f2780b = str;
        this.c = i;
        this.d = i2;
        this.e = null;
        this.f = new JSONObject();
        this.g = 0;
        this.h = new Pair<>(0L, 0L);
        this.i = null;
        this.j = 0L;
        this.k = 0L;
        this.l = new JSONObject();
    }

    public final synchronized boolean A(boolean z2) {
        int i = this.g;
        if (i == 0 || i == 1 || i == 2) {
            this.g = z2 ? 4 : 3;
            return true;
        }
        if (i == 4) {
            return false;
        }
        if (i != 3) {
            return false;
        }
        if (!z2) {
            return false;
        }
        this.g = 4;
        return true;
    }

    public final synchronized boolean B() {
        a aVar;
        int i = this.g;
        if (i != 1 && i != 2) {
            if (i == 0) {
                this.j = System.currentTimeMillis();
                this.g = 1;
                this.i = null;
                return true;
            }
            if (i == 3 || i == 4) {
                this.g = 1;
                this.i = null;
                return true;
            }
            if (i != 6 || ((aVar = this.i) != null && !aVar.e)) {
                return false;
            }
            this.g = 1;
            this.i = null;
            return true;
        }
        return false;
    }

    public final synchronized boolean C(a aVar) {
        int i = this.g;
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            return false;
        }
        this.g = 5;
        this.i = aVar;
        this.k = System.currentTimeMillis();
        return true;
    }

    public final synchronized void D() {
        try {
            this.f2779a.put(m, this.f2780b);
            this.f2779a.put(n, this.c);
            this.f2779a.put(o, this.d);
            this.f2779a.put(p, this.e);
            E(this.f);
            this.f2779a.put(q, this.f);
            this.f2779a.put(r, this.g);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t, ((Long) this.h.first).longValue());
            jSONObject.put(u, ((Long) this.h.second).longValue());
            this.f2779a.put(s, jSONObject);
            JSONObject jSONObject2 = this.f2779a;
            a aVar = this.i;
            jSONObject2.put(v, aVar == null ? null : aVar.i());
            this.f2779a.put(w, this.j);
            this.f2779a.put(x, this.k);
            this.f2779a.put(y, this.l);
        } catch (JSONException unused) {
        }
    }

    public void E(JSONObject jSONObject) {
    }

    public final void F(String str) {
        this.e = str;
    }

    public void G(String str) {
        this.f2780b = str;
    }

    public final synchronized void H(long j, long j2) {
        this.h = new Pair<>(Long.valueOf(j), Long.valueOf(j2));
    }

    public final synchronized boolean a() {
        if (this.g == 5) {
            return false;
        }
        this.g = 7;
        this.i = null;
        this.k = System.currentTimeMillis();
        return true;
    }

    public final synchronized boolean b() {
        if (this.g != 1) {
            return false;
        }
        this.g = 2;
        return true;
    }

    public final synchronized boolean c(a aVar) {
        int i = this.g;
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            return false;
        }
        this.g = 6;
        this.i = aVar;
        this.k = System.currentTimeMillis();
        return true;
    }

    public final String d() {
        return this.e;
    }

    public final JSONObject e() {
        return this.f2779a;
    }

    public final long f() {
        return this.k;
    }

    public final JSONObject g() {
        return this.l;
    }

    public String h() {
        return this.f2780b;
    }

    public int i() {
        return this.d;
    }

    public final Pair<Long, Long> j() {
        return this.h;
    }

    public final long k() {
        return this.j;
    }

    public final a l() {
        return this.i;
    }

    public final JSONObject m() {
        return this.f;
    }

    public final int n() {
        return this.g;
    }

    public int o() {
        return this.c;
    }

    public final boolean p() {
        return this.g == 7;
    }

    public final boolean q() {
        int i = this.g;
        return i == 1 || i == 2;
    }

    public final boolean r() {
        return this.g == 2;
    }

    public final boolean s() {
        return this.g == 6;
    }

    public final boolean t() {
        int i = this.g;
        return i == 4 || i == 3;
    }

    public final boolean u() {
        return this.g == 3;
    }

    public final boolean v() {
        return this.g == 0;
    }

    public final boolean w() {
        return this.g == 1;
    }

    public final boolean x() {
        return this.g == 5;
    }

    public final boolean y() {
        int i = this.g;
        return (i == 5 || i == 7) ? false : true;
    }

    public void z(JSONObject jSONObject) throws JSONException {
    }

    public b(JSONObject jSONObject) throws JSONException {
        long jOptLong;
        long jOptLong2;
        byte b2 = 0;
        this.i = null;
        this.f2779a = jSONObject;
        this.f2780b = jSONObject.optString(m);
        this.c = jSONObject.optInt(n);
        this.d = jSONObject.optInt(o);
        this.e = jSONObject.optString(p);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(q);
        this.f = jSONObjectOptJSONObject;
        z(jSONObjectOptJSONObject);
        this.g = jSONObject.optInt(r);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(s);
        if (jSONObjectOptJSONObject2 != null) {
            jOptLong = jSONObjectOptJSONObject2.optLong(t);
            jOptLong2 = jSONObjectOptJSONObject2.optLong(u);
        } else {
            jOptLong = 0;
            jOptLong2 = 0;
        }
        this.h = new Pair<>(Long.valueOf(jOptLong), Long.valueOf(jOptLong2));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(v);
        this.i = jSONObjectOptJSONObject3 != null ? new a(jSONObjectOptJSONObject3) : null;
        this.j = jSONObject.optLong(w);
        this.k = jSONObject.optLong(x);
        this.l = jSONObject.optJSONObject(y);
    }
}
