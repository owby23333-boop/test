package com.ss.android.socialbase.downloader.p;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.zk.v;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static JSONObject d;
    private static Boolean ga;
    private static e p;
    private static JSONObject tg;
    private static boolean vn;
    private final Boolean m;
    private final JSONObject v;
    private int wu;
    private final JSONObject zk;
    private static final v<Integer, e> e = new v<>(16, 16);
    private static final e bf = new e(null);

    static {
        e();
    }

    private e(JSONObject jSONObject) {
        Boolean bool;
        this.v = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || vn("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !vn("default")) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.zk = jSONObject2;
        this.m = bool;
    }

    @NonNull
    public static JSONObject bf() {
        return d.hb();
    }

    @NonNull
    public static e d() {
        return bf;
    }

    public static void e() {
        Boolean boolValueOf;
        JSONObject jSONObjectHb = d.hb();
        vn = jSONObjectHb.optInt("disable_task_setting", 0) == 1;
        d = jSONObjectHb.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectHb.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("default")) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        tg = jSONObjectOptJSONObject;
        ga = boolValueOf;
    }

    public static boolean vn(String str) {
        JSONObject jSONObject = d;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONArray ga(String str) {
        JSONObject jSONObject = this.v;
        return (jSONObject == null || !jSONObject.has(str) || vn(str)) ? bf().optJSONArray(str) : this.v.optJSONArray(str);
    }

    public JSONObject tg(String str) {
        JSONObject jSONObject = this.v;
        return (jSONObject == null || !jSONObject.has(str) || vn(str)) ? bf().optJSONObject(str) : this.v.optJSONObject(str);
    }

    public boolean bf(String str, boolean z) {
        if (this.zk != null && !vn(str)) {
            if (this.zk.has(str)) {
                return this.zk.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.m;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = tg;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return tg.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = ga;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String d(String str) {
        return e(str, "");
    }

    private static e d(int i) {
        DownloadInfo downloadInfo;
        if (vn) {
            return bf;
        }
        Context contextI = d.i();
        if (contextI != null && (downloadInfo = Downloader.getInstance(contextI).getDownloadInfo(i)) != null) {
            return bf(downloadInfo);
        }
        return bf;
    }

    public static void e(String str, boolean z) {
        try {
            if (tg == null) {
                tg = new JSONObject();
            }
            tg.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static e e(int i) {
        return e(i, (DownloadInfo) null);
    }

    public int bf(String str) {
        return e(str, 0);
    }

    public static void bf(int i) {
        e eVar = p;
        if (eVar != null && eVar.wu == i) {
            p = null;
        }
        v<Integer, e> vVar = e;
        synchronized (vVar) {
            vVar.remove(Integer.valueOf(i));
        }
    }

    @NonNull
    public static e e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return bf;
        }
        return e(downloadInfo.getId(), downloadInfo);
    }

    private static e e(int i, DownloadInfo downloadInfo) {
        e eVarD;
        e eVar = p;
        if (eVar != null && eVar.wu == i) {
            return eVar;
        }
        v<Integer, e> vVar = e;
        synchronized (vVar) {
            eVarD = vVar.get(Integer.valueOf(i));
        }
        if (eVarD == null) {
            eVarD = downloadInfo == null ? d(i) : bf(downloadInfo);
            synchronized (vVar) {
                vVar.put(Integer.valueOf(i), eVarD);
            }
        }
        eVarD.wu = i;
        p = eVarD;
        return eVarD;
    }

    private static e bf(DownloadInfo downloadInfo) {
        if (vn) {
            return bf;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new e(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bf;
    }

    public boolean e(String str) {
        return bf(str, false);
    }

    public int e(String str, int i) {
        JSONObject jSONObject = this.v;
        if (jSONObject != null && jSONObject.has(str) && !vn(str)) {
            return this.v.optInt(str, i);
        }
        return bf().optInt(str, i);
    }

    public long e(String str, long j) {
        JSONObject jSONObject = this.v;
        if (jSONObject != null && jSONObject.has(str) && !vn(str)) {
            return this.v.optLong(str, j);
        }
        return bf().optLong(str, j);
    }

    public double e(String str, double d2) {
        JSONObject jSONObject = this.v;
        if (jSONObject != null && jSONObject.has(str) && !vn(str)) {
            return this.v.optDouble(str, d2);
        }
        return bf().optDouble(str, d2);
    }

    public String e(String str, String str2) {
        JSONObject jSONObject = this.v;
        if (jSONObject != null && jSONObject.has(str) && !vn(str)) {
            return this.v.optString(str, str2);
        }
        return bf().optString(str, str2);
    }

    @NonNull
    public static e e(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != bf() && !vn) {
            e eVar = p;
            if (eVar != null && eVar.v == jSONObject) {
                return eVar;
            }
            v<Integer, e> vVar = e;
            synchronized (vVar) {
                for (e eVar2 : vVar.values()) {
                    if (eVar2.v == jSONObject) {
                        p = eVar2;
                        return eVar2;
                    }
                }
                e eVar3 = new e(jSONObject);
                p = eVar3;
                return eVar3;
            }
        }
        return bf;
    }

    public static void e(int i, JSONObject jSONObject) {
        e next;
        if (jSONObject == null || jSONObject == bf() || vn) {
            return;
        }
        v<Integer, e> vVar = e;
        synchronized (vVar) {
            e eVar = p;
            if (eVar != null && eVar.v == jSONObject) {
                eVar.wu = i;
            } else {
                Iterator<e> it = vVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.v == jSONObject) {
                        next.wu = i;
                        break;
                    }
                }
                if (next == null) {
                    eVar = new e(jSONObject);
                    eVar.wu = i;
                } else {
                    eVar = next;
                }
                p = eVar;
            }
            e.put(Integer.valueOf(i), eVar);
        }
    }
}
