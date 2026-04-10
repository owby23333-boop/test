package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gb {
    private static final String[] m = {"channel", "package", "app_version"};
    private final bv dl;
    private final SharedPreferences e;
    private final Context g;
    private boolean z;
    private final ArrayList<gp> gc = new ArrayList<>(32);
    private int gz = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f287a = new JSONObject();

    public gb(Context context, bv bvVar) {
        this.g = context;
        this.dl = bvVar;
        this.e = bvVar.gc();
        if (z.g) {
            dh.z(context);
        }
    }

    public JSONObject z() {
        if (this.z) {
            return pf();
        }
        return null;
    }

    public <T> T z(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectPf = pf();
        if (jSONObjectPf == null || (objOpt = jSONObjectPf.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private JSONObject pf() {
        return this.f287a;
    }

    public int g() {
        int iOptInt = this.z ? pf().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            m();
            iOptInt = this.z ? pf().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String dl() {
        String strOptString = this.z ? pf().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            m();
            strOptString = this.z ? pf().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public void a() {
        ti.m().fo();
    }

    public void gc() {
        try {
            new qd(this.g, this.dl).z(this.f287a);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl("od", "e:" + e.getMessage(), e);
        }
    }

    public boolean m() {
        synchronized (this.gc) {
            if (this.gc.size() == 0) {
                this.gc.add(new t(this.g, this.dl));
                this.gc.add(new y(this.g));
                this.gc.add(new ec(this.g, this.dl));
                this.gc.add(new jq(this.g));
                this.gc.add(new sv(this.g));
                this.gc.add(new f(this.g, this.dl));
                this.gc.add(new yx(this.g));
                this.gc.add(new zx(this.g, this.dl));
                this.gc.add(new b(this.g, this.dl));
                this.gc.add(new lw());
                this.gc.add(new rv(this.dl));
                this.gc.add(new tc(this.g));
                this.gc.add(new me(this.g));
                this.gc.add(new nh(this.g, this.dl));
                this.gc.add(new xl(this.g, this.dl));
                this.gc.add(new qd(this.g, this.dl));
                this.gc.add(new vm(this.g, this.dl));
            }
        }
        JSONObject jSONObjectPf = pf();
        JSONObject jSONObject = new JSONObject();
        o.g(jSONObject, jSONObjectPf);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (gp gpVar : this.gc) {
            if (!gpVar.z || gpVar.dl || z(gpVar)) {
                try {
                    gpVar.z = gpVar.z(jSONObject);
                } catch (SecurityException e) {
                    if (!gpVar.g) {
                        i++;
                        cb.g("loadHeader, " + this.gz, e);
                        if (!gpVar.z && this.gz > 10) {
                            gpVar.z = true;
                        }
                    }
                } catch (JSONException e2) {
                    cb.g(e2);
                }
                if (!gpVar.z && !gpVar.g) {
                    i2++;
                }
            }
            z &= gpVar.z || gpVar.g;
        }
        if (z) {
            int length = m.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(r7[i3]));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f287a = jSONObject;
        this.z = z;
        if (cb.g) {
            cb.z("loadHeader, " + this.z + ", " + this.gz + ", " + this.f287a.toString(), null);
        } else {
            cb.a("loadHeader, " + this.z + ", " + this.gz, null);
        }
        if (i > 0 && i == i2) {
            this.gz++;
            if (wp() != 0) {
                this.gz += 10;
            }
        }
        if (this.z) {
            z.wp().z(e(), fo(), uy());
        }
        return this.z;
    }

    private boolean z(gp gpVar) {
        boolean z = !this.dl.fv() && gpVar.f288a;
        if (cb.g) {
            cb.z("needSyncFromSub " + gpVar + " " + z, null);
        }
        return z;
    }

    public void z(JSONObject jSONObject) {
        this.dl.dl(jSONObject);
        g(jSONObject);
    }

    private synchronized void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            cb.g("null abconfig", null);
            return;
        }
        String strOptString = pf().optString("ab_version");
        if (!TextUtils.isEmpty(strOptString)) {
            String[] strArrSplit = strOptString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> itKeys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e) {
                            cb.g(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            g("ab_version", z(hashSet));
        }
    }

    private String z(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void z(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = pf().optJSONObject(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                cb.g(e);
            }
        }
        if (g(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObjectOptJSONObject)) {
            this.dl.g(jSONObjectOptJSONObject);
        }
    }

    public String e() {
        return pf().optString("device_id", "");
    }

    public String gz() {
        return pf().optString("aid", "");
    }

    public String fo() {
        return pf().optString("install_id", "");
    }

    public String uy() {
        return pf().optString("ssid", "");
    }

    public String kb() {
        return pf().optString("user_unique_id", "");
    }

    private boolean g(String str, Object obj) {
        boolean z;
        Object objOpt = pf().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f287a;
                    JSONObject jSONObject2 = new JSONObject();
                    o.g(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f287a = jSONObject2;
                } catch (JSONException e) {
                    cb.g(e);
                }
            }
            z = true;
        }
        cb.z("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    static void z(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    static boolean z(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (str.charAt(i) != '0') {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public int wp() {
        String strOptString = pf().optString("device_id", "");
        pf().optString("install_id", "");
        if (g(strOptString)) {
            return this.e.getInt("version_code", 0) == pf().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long i() {
        return pf().optLong("register_time", 0L);
    }

    public boolean z(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (cb.g) {
            cb.z("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zG = g(str);
        boolean zG2 = g(str2);
        try {
            boolean zG3 = g(str3);
            int i = this.e.getInt("version_code", 0);
            int iOptInt = pf().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.e.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zG) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                g("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zG) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                z.z("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = pf().optString("device_id", "");
            if (zG && g("device_id", str)) {
                editorEdit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = pf().optString("install_id", "");
            if (zG2 && g("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = pf().optString("ssid", "");
            if (zG3 && g("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            z.wp().z(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            cb.g(e);
        }
        return zG && zG2;
    }

    public String v() {
        return pf().optString("ab_sdk_version", "");
    }
}
