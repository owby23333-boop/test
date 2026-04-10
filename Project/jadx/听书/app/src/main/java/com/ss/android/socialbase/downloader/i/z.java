package com.ss.android.socialbase.downloader.i;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.downloader.dl;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.pf.gz;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f2088a;
    private static JSONObject dl;
    private static z e;
    private static Boolean gc;
    private static boolean m;
    private final JSONObject fo;
    private final JSONObject gz;
    private int kb;
    private final Boolean uy;
    private static final gz<Integer, z> z = new gz<>(16, 16);
    private static final z g = new z(null);

    static {
        z();
    }

    public static void z() {
        Boolean boolValueOf;
        JSONObject jSONObjectX = dl.x();
        m = jSONObjectX.optInt("disable_task_setting", 0) == 1;
        dl = jSONObjectX.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectX.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("default")) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        f2088a = jSONObjectOptJSONObject;
        gc = boolValueOf;
    }

    private z(JSONObject jSONObject) {
        Boolean bool;
        this.gz = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || m("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !m("default")) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.fo = jSONObject2;
        this.uy = bool;
    }

    public static JSONObject g() {
        return dl.x();
    }

    public static void z(String str, boolean z2) {
        try {
            if (f2088a == null) {
                f2088a = new JSONObject();
            }
            f2088a.put(str, z2 ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static z dl() {
        return g;
    }

    public static z z(int i) {
        return z(i, (com.ss.android.socialbase.downloader.e.dl) null);
    }

    public static z z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return g;
        }
        return z(dlVar.e(), dlVar);
    }

    private static z z(int i, com.ss.android.socialbase.downloader.e.dl dlVar) {
        z zVarDl;
        z zVar = e;
        if (zVar != null && zVar.kb == i) {
            return zVar;
        }
        gz<Integer, z> gzVar = z;
        synchronized (gzVar) {
            zVarDl = gzVar.get(Integer.valueOf(i));
        }
        if (zVarDl == null) {
            zVarDl = dlVar == null ? dl(i) : g(dlVar);
            synchronized (gzVar) {
                gzVar.put(Integer.valueOf(i), zVarDl);
            }
        }
        zVarDl.kb = i;
        e = zVarDl;
        return zVarDl;
    }

    public boolean z(String str) {
        return g(str, false);
    }

    public boolean g(String str, boolean z2) {
        if (this.fo != null && !m(str)) {
            if (this.fo.has(str)) {
                return this.fo.optInt(str, z2 ? 1 : 0) == 1;
            }
            Boolean bool = this.uy;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f2088a;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f2088a.optInt(str, z2 ? 1 : 0) == 1;
            }
            Boolean bool2 = gc;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z2;
    }

    public int g(String str) {
        return z(str, 0);
    }

    public int z(String str, int i) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optInt(str, i);
        }
        return g().optInt(str, i);
    }

    public long z(String str, long j) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optLong(str, j);
        }
        return g().optLong(str, j);
    }

    public double z(String str, double d) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optDouble(str, d);
        }
        return g().optDouble(str, d);
    }

    public String dl(String str) {
        return z(str, "");
    }

    public String z(String str, String str2) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optString(str, str2);
        }
        return g().optString(str, str2);
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optJSONObject(str);
        }
        return g().optJSONObject(str);
    }

    public JSONArray gc(String str) {
        JSONObject jSONObject = this.gz;
        if (jSONObject != null && jSONObject.has(str) && !m(str)) {
            return this.gz.optJSONArray(str);
        }
        return g().optJSONArray(str);
    }

    public static boolean m(String str) {
        JSONObject jSONObject = dl;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static z z(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == g() || m) {
            return g;
        }
        z zVar = e;
        if (zVar != null && zVar.gz == jSONObject) {
            return zVar;
        }
        gz<Integer, z> gzVar = z;
        synchronized (gzVar) {
            for (z zVar2 : gzVar.values()) {
                if (zVar2.gz == jSONObject) {
                    e = zVar2;
                    return zVar2;
                }
            }
            z zVar3 = new z(jSONObject);
            e = zVar3;
            return zVar3;
        }
    }

    public static void z(int i, JSONObject jSONObject) {
        z next;
        if (jSONObject == null || jSONObject == g() || m) {
            return;
        }
        gz<Integer, z> gzVar = z;
        synchronized (gzVar) {
            z zVar = e;
            if (zVar != null && zVar.gz == jSONObject) {
                zVar.kb = i;
            } else {
                Iterator<z> it = gzVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.gz == jSONObject) {
                        next.kb = i;
                        break;
                    }
                }
                if (next == null) {
                    zVar = new z(jSONObject);
                    zVar.kb = i;
                } else {
                    zVar = next;
                }
                e = zVar;
            }
            z.put(Integer.valueOf(i), zVar);
        }
    }

    public static void g(int i) {
        z zVar = e;
        if (zVar != null && zVar.kb == i) {
            e = null;
        }
        gz<Integer, z> gzVar = z;
        synchronized (gzVar) {
            gzVar.remove(Integer.valueOf(i));
        }
    }

    private static z dl(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        if (m) {
            return g;
        }
        Context contextXl = dl.xl();
        if (contextXl != null && (dlVarGz = e.g(contextXl).gz(i)) != null) {
            return g(dlVarGz);
        }
        return g;
    }

    private static z g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (m) {
            return g;
        }
        try {
            String strY = dlVar.y();
            if (!TextUtils.isEmpty(strY)) {
                return new z(new JSONObject(strY));
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return g;
    }
}
