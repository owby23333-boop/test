package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f724h = {"channel", Constants.KEY_PACKAGE, "app_version"};
    private boolean a;
    private final Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j2 f725c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedPreferences f728f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<e2> f727e = new ArrayList<>(32);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f729g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f726d = new JSONObject();

    public k2(Context context, j2 j2Var) {
        this.b = context;
        this.f725c = j2Var;
        this.f728f = j2Var.w();
        s0.a(j2Var.r());
        s0.a(j2Var.s());
        s0.a(this.b);
    }

    private String a(Set<String> set) {
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

    static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private boolean a(e2 e2Var) {
        boolean z2 = !this.f725c.J() && e2Var.f675d;
        if (l0.a) {
            l0.a("needSyncFromSub " + e2Var + " " + z2, null);
        }
        return z2;
    }

    static boolean a(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private void b(JSONObject jSONObject) {
        synchronized (this) {
            if (jSONObject == null) {
                l0.b("null abconfig", null);
            } else {
                String strOptString = n().optString("ab_version");
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
                                } catch (JSONException e2) {
                                    l0.a(e2);
                                }
                            }
                        }
                    }
                    hashSet.retainAll(hashSet2);
                    b("ab_version", a(hashSet));
                }
            }
        }
    }

    public static boolean b(String str) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z2 = true;
                break;
            }
            if (str.charAt(i2) != '0') {
                break;
            }
            i2++;
        }
        return !z2;
    }

    private boolean b(String str, Object obj) {
        boolean z2;
        Object objOpt = n().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z2 = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f726d;
                    JSONObject jSONObject2 = new JSONObject();
                    m0.b(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f726d = jSONObject2;
                } catch (JSONException e2) {
                    l0.a(e2);
                }
            }
            z2 = true;
        }
        l0.a("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z2;
    }

    private JSONObject n() {
        return this.f726d;
    }

    public <T> T a(String str, T t2) {
        T t3;
        JSONObject jSONObjectN = n();
        if (jSONObjectN == null || (t3 = (T) jSONObjectN.opt(str)) == null) {
            t3 = null;
        }
        return t3 == null ? t2 : t3;
    }

    public JSONObject a() {
        if (this.a) {
            return n();
        }
        return null;
    }

    public void a(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = n().optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e2) {
                l0.a(e2);
            }
        }
        if (b("custom", jSONObjectOptJSONObject)) {
            this.f725c.b(jSONObjectOptJSONObject);
        }
    }

    public void a(JSONObject jSONObject) {
        this.f725c.c(jSONObject);
        b(jSONObject);
    }

    public boolean a(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z2;
        boolean zB;
        SharedPreferences.Editor editorEdit;
        String strOptString;
        boolean z3;
        String strOptString2;
        String strOptString3;
        boolean z4;
        if (l0.a) {
            l0.a("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zB2 = b(str);
        boolean zB3 = b(str2);
        try {
            zB = b(str3);
            int i2 = this.f728f.getInt("version_code", 0);
            int iOptInt = n().optInt("version_code", 0);
            editorEdit = this.f728f.edit();
            if (i2 != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zB2) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                b("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zB2) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                a.a("tt_fetch_did_error", jSONObject2);
            }
            strOptString = n().optString("device_id", "");
            if (zB2 && b("device_id", str)) {
                editorEdit.putString("device_id", str);
                z3 = true;
            } else {
                z3 = false;
            }
            strOptString2 = n().optString("install_id", "");
            if (zB3 && b("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z3 = true;
            }
            strOptString3 = n().optString("ssid", "");
        } catch (JSONException e2) {
            e = e2;
            z2 = false;
        }
        if (zB) {
            z2 = false;
            try {
                if (b("ssid", str3)) {
                    editorEdit.putString("ssid", str3);
                    z4 = true;
                }
                a.f().a(z4, strOptString, str, strOptString2, str2, strOptString3, str3);
                editorEdit.apply();
            } catch (JSONException e3) {
                e = e3;
                l0.a(e);
            }
            if (!zB2 && zB3) {
                return true;
            }
        }
        z2 = false;
        z4 = z3;
        a.f().a(z4, strOptString, str, strOptString2, str2, strOptString3, str3);
        editorEdit.apply();
        return !zB2 ? z2 : z2;
    }

    public JSONObject b() {
        JSONObject jSONObjectA = a();
        if (jSONObjectA == null) {
            return jSONObjectA;
        }
        try {
            String strA = s0.a(jSONObjectA.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strA)) {
                return jSONObjectA;
            }
            JSONObject jSONObject = new JSONObject();
            m0.b(jSONObject, jSONObjectA);
            jSONObject.put("oaid", strA);
            return jSONObject;
        } catch (Exception e2) {
            l0.a(e2);
            return jSONObjectA;
        }
    }

    public int c() {
        l0.a("D.getVC", null);
        int iOptInt = this.a ? n().optInt("version_code", -1) : -1;
        for (int i2 = 0; i2 < 3 && iOptInt == -1; i2++) {
            e();
            iOptInt = this.a ? n().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String d() {
        l0.a("D.getVN", null);
        String strOptString = this.a ? n().optString("app_version", null) : null;
        for (int i2 = 0; i2 < 3 && strOptString == null; i2++) {
            e();
            strOptString = this.a ? n().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public boolean e() {
        l0.a("D.load", null);
        synchronized (this.f727e) {
            if (this.f727e.size() == 0) {
                this.f727e.add(new f2(this.b, this.f725c));
                this.f727e.add(new h2(this.b));
                this.f727e.add(new i2(this.b, this.f725c));
                this.f727e.add(new l2(this.b));
                this.f727e.add(new m2(this.b));
                this.f727e.add(new n2(this.b, this.f725c));
                this.f727e.add(new j(this.b));
                this.f727e.add(new l(this.b));
                this.f727e.add(new m(this.b, this.f725c));
                this.f727e.add(new n());
                this.f727e.add(new o(this.f725c));
                this.f727e.add(new p(this.b));
                this.f727e.add(new q(this.b));
                this.f727e.add(new r(this.b, this.f725c));
                this.f727e.add(new c2(this.b, this.f725c));
                this.f727e.add(new k(this.b, this.f725c));
                this.f727e.add(new g2(this.b, this.f725c));
            }
        }
        JSONObject jSONObjectN = n();
        JSONObject jSONObject = new JSONObject();
        m0.b(jSONObject, jSONObjectN);
        boolean z2 = true;
        int i2 = 0;
        int i3 = 0;
        for (e2 e2Var : this.f727e) {
            if (!e2Var.a || e2Var.f674c || a(e2Var)) {
                try {
                    e2Var.a = e2Var.a(jSONObject);
                } catch (SecurityException e2) {
                    if (!e2Var.b) {
                        i3++;
                        l0.b("loadHeader, " + this.f729g, e2);
                        if (!e2Var.a && this.f729g > 10) {
                            e2Var.a = true;
                        }
                    }
                } catch (JSONException e3) {
                    l0.a(e3);
                }
                if (!e2Var.a && !e2Var.b) {
                    i2++;
                }
            }
            z2 &= e2Var.a || e2Var.b;
        }
        if (z2) {
            int length = f724h.length;
            for (int i4 = 0; i4 < length; i4++) {
                z2 &= !TextUtils.isEmpty(jSONObject.optString(r1[i4]));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f726d = jSONObject;
        this.a = z2;
        if (l0.a) {
            l0.a("loadHeader, " + this.a + ", " + this.f729g + ", " + this.f726d.toString(), null);
        } else {
            l0.d("loadHeader, " + this.a + ", " + this.f729g, null);
        }
        if (i3 > 0 && i3 == i2) {
            this.f729g++;
            if (k() != 0) {
                this.f729g += 10;
            }
        }
        if (this.a) {
            a.f().a(g(), h(), i());
        }
        return this.a;
    }

    public String f() {
        return n().optString("user_unique_id", "");
    }

    public String g() {
        return n().optString("device_id", "");
    }

    public String h() {
        return n().optString("install_id", "");
    }

    public String i() {
        return n().optString("ssid", "");
    }

    public String j() {
        return n().optString("user_unique_id", "");
    }

    public int k() {
        String strOptString = n().optString("device_id", "");
        n().optString("install_id", "");
        if (b(strOptString)) {
            return this.f728f.getInt("version_code", 0) == n().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long l() {
        return n().optLong("register_time", 0L);
    }

    public String m() {
        return n().optString("ab_sdk_version", "");
    }
}
