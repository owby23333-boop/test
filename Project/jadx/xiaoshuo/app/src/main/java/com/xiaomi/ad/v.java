package com.xiaomi.ad;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class v {
    public static final String A = "1";
    public static final String B = "2";
    public static final String C = "adTimeout";
    public static final String D = "timeout";
    public static final int E = 0;
    public static final int F = 304;
    public static final long G = 0;
    public static final long H = 30000;
    public static final String e = "MediationConfig";
    public static final String f = "code";
    public static final String g = "comd5";
    public static final String h = "data";
    public static final String i = "ct";
    public static final String j = "app";
    public static final String k = "poslist";
    public static final String l = "dcid";
    public static final int m = 1;
    public static final String n = "dspParallelism";
    public static final String o = "isClosed";
    public static final String p = "tagid";
    public static final String q = "isBid";
    public static final String r = "extraParameters";
    public static final String s = "info";
    public static final String t = "name";
    public static final String u = "parameter";
    public static final String v = "weight";
    public static final String w = "blacklist";
    public static final String x = "dsp";
    public static final String y = "value";
    public static final String z = "isExpress";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7299b = -1;
    public List<b> c = new ArrayList();
    public List<String> d = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7301b;
        public String c;
        public String d;
        public int e;
        public long f;
        public boolean g;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7303b;
        public long c;
        public int d;
        public boolean e;
        public boolean f;
        public String g;
        public String h;
        public HashMap<String, a> i;

        public a a(String str) {
            HashMap<String, a> map = this.i;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }

        public List<a> a() {
            return new ArrayList(this.i.values());
        }

        public boolean a(Map<String, a> map) {
            HashMap<String, a> map2;
            if (map == null || map.isEmpty() || (map2 = this.i) == null || map2.isEmpty()) {
                return true;
            }
            if (this.i.size() != map.size()) {
                return false;
            }
            for (String str : this.i.keySet()) {
                if (!map.containsKey(str) || this.i.get(str) == null || map.get(str) == null || this.i.get(str).e != map.get(str).e) {
                    return false;
                }
            }
            return true;
        }
    }

    public static v d(String str) {
        JSONException e2;
        v vVar;
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            vVar = new v();
        } catch (JSONException e3) {
            e2 = e3;
            vVar = null;
        }
        try {
            vVar.f7298a = jSONObject.optString("comd5");
            vVar.f7299b = jSONObject.optInt("code");
            vVar.b(jSONObject.optJSONArray(k));
            vVar.a(jSONObject.optJSONArray(w));
        } catch (JSONException e4) {
            e2 = e4;
            MLog.e(e, "Failed to convert from cached file", e2);
        }
        return vVar;
    }

    public static v e(String str) {
        JSONException e2;
        v vVar;
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            vVar = new v();
        } catch (JSONException e3) {
            e2 = e3;
            vVar = null;
        }
        try {
            int iOptInt = jSONObject.optInt("code");
            vVar.f7299b = iOptInt;
            if (iOptInt == 0) {
                vVar.f7298a = jSONObject.optString("comd5");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    MLog.e(e, "response data array is null or empty");
                    return null;
                }
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    vVar.a(jSONArrayOptJSONArray.optJSONObject(i2));
                }
            }
        } catch (JSONException e4) {
            e2 = e4;
            MLog.e(e, "Failed to convert from response", e2);
        }
        return vVar;
    }

    public int a(String str) {
        b bVarB = b(str);
        if (bVarB != null) {
            return bVarB.d;
        }
        return 1;
    }

    public int b(String str, String str2) {
        a aVarA;
        b bVarB = b(str);
        if (bVarB == null || (aVarA = bVarB.a(str2)) == null) {
            return -1;
        }
        return aVarA.e;
    }

    public long c(String str) {
        return 30000L;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    private JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        if (!this.c.isEmpty()) {
            for (b bVar : this.c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(l, bVar.f7302a);
                    jSONObject.put(C, bVar.f7303b);
                    jSONObject.put("timeout", bVar.c);
                    jSONObject.put(o, bVar.e);
                    jSONObject.put(n, bVar.d);
                    jSONObject.put(p, bVar.g);
                    jSONObject.put(r, bVar.h);
                    jSONObject.put(q, bVar.f);
                    jSONObject.put("info", a(bVar.i));
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    MLog.e(e, "Failed to convert position info list to json", e2);
                }
            }
        }
        return jSONArray;
    }

    public int a(String str, String str2) {
        a aVarA;
        b bVarB = b(str);
        if (bVarB == null || (aVarA = bVarB.a(str2)) == null) {
            return 0;
        }
        return aVarA.f7300a;
    }

    public b b(String str) {
        if (this.c.isEmpty()) {
            return null;
        }
        for (b bVar : this.c) {
            if (TextUtils.equals(bVar.g, str)) {
                return bVar;
            }
        }
        return null;
    }

    private JSONArray a(Map<String, a> map) {
        JSONArray jSONArray = new JSONArray();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                a aVar = map.get(it.next());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", aVar.c);
                    jSONObject.put(u, aVar.d);
                    jSONObject.put(v, aVar.e);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    MLog.e(e, "Failed to convert dsp info list to json", e2);
                }
            }
        }
        return jSONArray;
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("comd5", this.f7298a);
            jSONObject.put("code", this.f7299b);
            jSONObject.put(k, d());
            jSONObject.put(w, c());
        } catch (JSONException e2) {
            MLog.e(e, "Failed to convert to cached file", e2);
        }
        return jSONObject.toString();
    }

    private void a(b bVar, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        bVar.i = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            a aVar = new a();
            aVar.c = jSONObjectOptJSONObject.optString("name");
            aVar.d = jSONObjectOptJSONObject.optString(u);
            aVar.e = jSONObjectOptJSONObject.optInt(v);
            aVar.f = bVar.f7303b;
            aVar.f7300a = i2;
            aVar.f7301b = aVar.c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aVar.d;
            aVar.g = jSONObjectOptJSONObject.optBoolean(z, false);
            if (StringUtils.isNotEmpty(aVar.f7301b)) {
                bVar.i.put(aVar.f7301b, aVar);
            }
        }
    }

    private void b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                b bVar = new b();
                bVar.f7302a = jSONObjectOptJSONObject.optString(l);
                bVar.f7303b = jSONObjectOptJSONObject.optLong(C, 0L) * 1000;
                bVar.c = jSONObjectOptJSONObject.optLong("timeout", 30000L);
                bVar.d = jSONObjectOptJSONObject.optInt(n, 1);
                bVar.e = jSONObjectOptJSONObject.optBoolean(o, false);
                bVar.f = jSONObjectOptJSONObject.optBoolean(q, false);
                bVar.g = jSONObjectOptJSONObject.optString(p);
                String strOptString = jSONObjectOptJSONObject.optString(r);
                if (!TextUtils.isEmpty(strOptString)) {
                    bVar.h = strOptString;
                }
                a(bVar, jSONObjectOptJSONObject.optJSONArray("info"));
                this.c.add(bVar);
            }
        }
    }

    private void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.d = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String strOptString = jSONArray.optString(i2);
            if (strOptString != null) {
                this.d.add(strOptString);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (strOptString = jSONObject.optString(i)) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(j)) == null) {
            return;
        }
        if (strOptString.equals("2")) {
            a(jSONObjectOptJSONObject.optJSONArray(w));
        } else if (strOptString.equals("1")) {
            b(jSONObjectOptJSONObject.optJSONArray(k));
        }
    }

    public boolean a() {
        return this.f7299b == 0;
    }

    public boolean a(b bVar, b bVar2) {
        if (bVar == null && bVar2 == null) {
            return true;
        }
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.a(bVar2.i);
    }
}
