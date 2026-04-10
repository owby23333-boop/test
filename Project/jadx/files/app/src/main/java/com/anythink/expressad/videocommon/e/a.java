package com.anythink.expressad.videocommon.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a = 1000;
    public static final int b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Integer> f12205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, com.anythink.expressad.videocommon.c.c> f12206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f12211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f12212j;

    private long l() {
        return this.f12207e * 1000;
    }

    private long m() {
        return this.f12208f * 1000;
    }

    private long n() {
        return this.f12212j;
    }

    private static a o() {
        a aVar = new a();
        HashMap map = new HashMap(5);
        map.put("1", 1000);
        map.put("9", 1000);
        map.put("8", 1000);
        HashMap map2 = new HashMap(3);
        map2.put("1", new com.anythink.expressad.videocommon.c.c("Virtual Item", 1));
        aVar.f12205c = map;
        aVar.f12206d = map2;
        aVar.f12207e = 43200L;
        aVar.f12208f = 5400L;
        aVar.f12209g = com.anythink.expressad.d.a.b.P;
        aVar.f12210h = com.anythink.expressad.d.a.b.P;
        aVar.f12211i = 5L;
        return aVar;
    }

    public final void a() {
        this.f12207e = 43200L;
    }

    public final void b() {
        this.f12208f = 5400L;
    }

    public final long c() {
        return this.f12209g * 1000;
    }

    public final void d() {
        this.f12209g = com.anythink.expressad.d.a.b.P;
    }

    public final long e() {
        return this.f12210h;
    }

    public final void f() {
        this.f12210h = com.anythink.expressad.d.a.b.P;
    }

    public final long g() {
        return this.f12211i;
    }

    public final void h() {
        this.f12211i = 5L;
    }

    public final Map<String, Integer> i() {
        if (this.f12205c == null) {
            this.f12205c = new HashMap();
            this.f12205c.put("1", 1000);
            this.f12205c.put("9", 1000);
            this.f12205c.put("8", 1000);
        }
        return this.f12205c;
    }

    public final Map<String, com.anythink.expressad.videocommon.c.c> j() {
        return this.f12206d;
    }

    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f12205c != null && this.f12205c.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f12205c.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put(b.a, jSONObject2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f12206d != null && this.f12206d.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.anythink.expressad.videocommon.c.c> entry2 : this.f12206d.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.anythink.expressad.videocommon.c.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.a());
                            jSONObject3.put("amount", value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f12207e);
            jSONObject.put(b.f12234x, this.f12208f);
            jSONObject.put("plct", this.f12209g);
            jSONObject.put("dlct", this.f12210h);
            jSONObject.put(b.A, this.f12211i);
            jSONObject.put("current_time", this.f12212j);
            return jSONObject;
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }

    private void a(long j2) {
        this.f12212j = j2;
    }

    public final void b(Map<String, com.anythink.expressad.videocommon.c.c> map) {
        this.f12206d = map;
    }

    public final void a(Map<String, Integer> map) {
        this.f12205c = map;
    }

    private static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(b.a);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            int iOptInt = jSONObjectOptJSONObject.optInt(next, 1000);
                            if (!TextUtils.isEmpty(next)) {
                                if (!TextUtils.isEmpty(next) && iOptInt == 0) {
                                    map.put(next, 1000);
                                } else {
                                    map.put(next, Integer.valueOf(iOptInt));
                                }
                            }
                        }
                        aVar2.f12205c = map;
                    }
                    aVar2.f12206d = com.anythink.expressad.videocommon.c.c.a(jSONObject.optJSONArray("reward"));
                    aVar2.f12207e = jSONObject.optLong("getpf", 43200L);
                    aVar2.f12208f = jSONObject.optLong(b.f12234x, 5400L);
                    aVar2.f12209g = jSONObject.optLong("plct", com.anythink.expressad.d.a.b.P);
                    aVar2.f12210h = jSONObject.optLong("dlct", com.anythink.expressad.d.a.b.P);
                    aVar2.f12211i = jSONObject.optLong(b.A, 5L);
                    aVar2.f12212j = jSONObject.optLong("current_time");
                    return aVar2;
                } catch (Exception e2) {
                    e = e2;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return aVar;
    }
}
