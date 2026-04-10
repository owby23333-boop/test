package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e0 {
    private static Map<String, e0> b = new HashMap();
    private SharedPreferences a;

    private e0(String str, Context context) {
        if (context != null) {
            this.a = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static e0 a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        e0 e0Var = b.get(str);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0(str, context);
        b.put(str, e0Var2);
        return e0Var2;
    }

    public static void a(JSONObject jSONObject) {
        try {
            String strD = a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d("gm_key_v3_bug");
            JSONArray jSONArray = !TextUtils.isEmpty(strD) ? new JSONArray(strD) : new JSONArray();
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z2, boolean z3, int i2, String str, long j2, int i3) {
        String str2 = z2 ? com.anythink.expressad.foundation.g.a.f10413j : "v1";
        try {
            String strD = a("evt_upload_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d(str2);
            JSONObject jSONObject = TextUtils.isEmpty(strD) ? new JSONObject() : new JSONObject(strD);
            int i4 = 1;
            if (z3) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt(Constants.KEY_TIMES, -1);
                int i5 = iOptInt == -1 ? 1 : iOptInt + 1;
                jSONObjectOptJSONObject.put(Constants.KEY_TIMES, i5);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload_size", -1);
                jSONObjectOptJSONObject.put("upload_size", iOptInt2 == -1 ? i2 : iOptInt2 + i2);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reason");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObjectOptJSONObject.put("reason", jSONObjectOptJSONObject2);
                }
                int iOptInt3 = jSONObjectOptJSONObject2.optInt(str, -1);
                if (iOptInt3 != -1) {
                    i4 = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject2.put(str, i4);
                if (j2 <= 10000) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    jSONObjectOptJSONObject.put("avg_req_duration", jOptInt == -1 ? j2 : ((jOptInt * ((long) (i5 - 1))) + j2) / ((long) i5));
                }
            } else {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject3);
                }
                int iOptInt4 = jSONObjectOptJSONObject3.optInt(Constants.KEY_TIMES, -1);
                jSONObjectOptJSONObject3.put(Constants.KEY_TIMES, iOptInt4 == -1 ? 1 : iOptInt4 + 1);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("error_code");
                if (jSONObjectOptJSONObject4 == null) {
                    jSONObjectOptJSONObject4 = new JSONObject();
                    jSONObjectOptJSONObject3.put("error_code", jSONObjectOptJSONObject4);
                }
                String str3 = "" + i3;
                int iOptInt5 = jSONObjectOptJSONObject4.optInt(str3, -1);
                if (iOptInt5 != -1) {
                    i4 = 1 + iOptInt5;
                }
                jSONObjectOptJSONObject4.put(str3, i4);
            }
            a("evt_upload_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b(str2, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONArray c() {
        try {
            String strD = a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d("gm_key_v3_bug");
            if (!TextUtils.isEmpty(strD)) {
                JSONArray jSONArray = new JSONArray(strD);
                a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).f("gm_key_v3_bug");
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static JSONObject g(String str) {
        try {
            String strD = a("evt_upload_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d(str);
            if (!TextUtils.isEmpty(strD)) {
                a("evt_upload_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).f(str);
                return new JSONObject(strD);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public float a(@NonNull String str, float f2) {
        try {
            return this.a.getFloat(str, f2);
        } catch (Throwable unused) {
            return f2;
        }
    }

    public int a(@NonNull String str, int i2) {
        try {
            return this.a.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long a(@NonNull String str, long j2) {
        try {
            return this.a.getLong(str, j2);
        } catch (Throwable unused) {
            return j2;
        }
    }

    public String a(@NonNull String str, @NonNull String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a() {
        try {
            this.a.edit().clear().commit();
        } catch (Throwable unused) {
        }
    }

    public boolean a(@NonNull String str) {
        return a(str, false);
    }

    public boolean a(@NonNull String str, boolean z2) {
        try {
            return this.a.getBoolean(str, z2);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public int b(@NonNull String str) {
        return a(str, -1);
    }

    public String b() {
        return a("any_door_id", (String) null);
    }

    public void b(@NonNull String str, float f2) {
        try {
            this.a.edit().putFloat(str, f2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, int i2) {
        try {
            this.a.edit().putInt(str, i2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, long j2) {
        try {
            this.a.edit().putLong(str, j2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, @NonNull String str2) {
        try {
            this.a.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, boolean z2) {
        try {
            this.a.edit().putBoolean(str, z2).apply();
        } catch (Throwable unused) {
        }
    }

    public long c(@NonNull String str) {
        return a(str, -1L);
    }

    public String d(@NonNull String str) {
        try {
            return a(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void e(String str) {
        b("any_door_id", str);
    }

    public void f(@NonNull String str) {
        try {
            this.a.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
