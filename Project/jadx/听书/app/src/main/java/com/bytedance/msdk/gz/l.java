package com.bytedance.msdk.gz;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.e.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static final Map<String, l> z = new HashMap();
    private com.bytedance.sdk.component.a.g.dl g;

    public static l z(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        Map<String, l> map = z;
        l lVar = map.get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(str, context);
        map.put(str, lVar2);
        return lVar2;
    }

    private l(String str, Context context) {
        context = context == null ? com.bytedance.msdk.core.g.getContext() : context;
        if (context != null) {
            this.g = new a.z().z(str).z(context).z(1).z(com.bytedance.msdk.core.z.kb().i()).z();
        }
    }

    public void z(String str) {
        z("any_door_id", str);
    }

    public String z() {
        return g("any_door_id", "");
    }

    public void z(String str, String str2) {
        try {
            this.g.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public String g(String str) {
        try {
            return g(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String g(String str, String str2) {
        try {
            return this.g.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void z(String str, int i) {
        try {
            this.g.put(str, i);
        } catch (Throwable unused) {
        }
    }

    public int dl(String str) {
        return g(str, -1);
    }

    public int g(String str, int i) {
        try {
            return this.g.get(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void z(String str, long j) {
        try {
            this.g.put(str, j);
        } catch (Throwable unused) {
        }
    }

    public long a(String str) {
        return g(str, -1L);
    }

    public long g(String str, long j) {
        try {
            return this.g.get(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void z(String str, float f) {
        try {
            this.g.put(str, f);
        } catch (Throwable unused) {
        }
    }

    public float g(String str, float f) {
        try {
            return this.g.get(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public void z(String str, boolean z2) {
        try {
            this.g.put(str, z2);
        } catch (Throwable unused) {
        }
    }

    public boolean gc(String str) {
        return g(str, false);
    }

    public boolean g(String str, boolean z2) {
        try {
            return this.g.get(str, z2);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public Map<String, ?> g() {
        try {
            return this.g.getAll();
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public void m(String str) {
        try {
            this.g.remove(str);
        } catch (Throwable unused) {
        }
    }

    public void dl() {
        try {
            this.g.clear();
        } catch (Throwable unused) {
        }
    }

    public static void z(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String strG = z("gm_v3_temp", com.bytedance.msdk.core.g.getContext()).g("gm_key_v3_bug");
            if (!TextUtils.isEmpty(strG)) {
                jSONArray = new JSONArray(strG);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            z("gm_v3_temp", com.bytedance.msdk.core.g.getContext()).z("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONArray a() {
        try {
            String strG = z("gm_v3_temp", com.bytedance.msdk.core.g.getContext()).g("gm_key_v3_bug");
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strG);
            z("gm_v3_temp", com.bytedance.msdk.core.g.getContext()).m("gm_key_v3_bug");
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void z(boolean z2, int i, String str, long j, String str2) {
        JSONObject jSONObject;
        try {
            String strG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("v3");
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            int i2 = 1;
            if (z2) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                int i3 = iOptInt == -1 ? 1 : iOptInt + 1;
                jSONObjectOptJSONObject.put("times", i3);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload_size", -1);
                jSONObjectOptJSONObject.put("upload_size", iOptInt2 == -1 ? i : iOptInt2 + i);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(MediationConstant.KEY_REASON);
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObjectOptJSONObject.put(MediationConstant.KEY_REASON, jSONObjectOptJSONObject2);
                }
                int iOptInt3 = jSONObjectOptJSONObject2.optInt(str, -1);
                if (iOptInt3 != -1) {
                    i2 = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject2.put(str, i2);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    jSONObjectOptJSONObject.put("avg_req_duration", jOptInt == -1 ? j : ((jOptInt * ((long) (i3 - 1))) + j) / ((long) i3));
                }
            } else {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject3);
                }
                int iOptInt4 = jSONObjectOptJSONObject3.optInt("times", -1);
                jSONObjectOptJSONObject3.put("times", iOptInt4 == -1 ? 1 : iOptInt4 + 1);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("error_code");
                if (jSONObjectOptJSONObject4 == null) {
                    jSONObjectOptJSONObject4 = new JSONObject();
                    jSONObjectOptJSONObject3.put("error_code", jSONObjectOptJSONObject4);
                }
                int iOptInt5 = jSONObjectOptJSONObject4.optInt(str2, -1);
                if (iOptInt5 != -1) {
                    i2 = 1 + iOptInt5;
                }
                jSONObjectOptJSONObject4.put(str2, i2);
            }
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("v3", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void z(String str, boolean z2, long j, String str2) {
        JSONObject jSONObject;
        try {
            String strG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g(str);
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            int i = 1;
            if (z2) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                if (iOptInt != -1) {
                    i = 1 + iOptInt;
                }
                jSONObjectOptJSONObject.put("times", i);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    if (jOptInt != -1) {
                        j = ((jOptInt * ((long) (i - 1))) + j) / ((long) i);
                    }
                    jSONObjectOptJSONObject.put("avg_req_duration", j);
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject2);
                }
                int iOptInt2 = jSONObjectOptJSONObject2.optInt("times", -1);
                jSONObjectOptJSONObject2.put("times", iOptInt2 == -1 ? 1 : iOptInt2 + 1);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("error_code");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObjectOptJSONObject2.put("error_code", jSONObjectOptJSONObject3);
                }
                int iOptInt3 = jSONObjectOptJSONObject3.optInt(str2, -1);
                if (iOptInt3 != -1) {
                    i = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject3.put(str2, i);
            }
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject e(String str) {
        try {
            String strG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g(str);
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).m(str);
            return new JSONObject(strG);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void dl(String str, long j) {
        JSONObject jSONObject;
        try {
            String strG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("init_time");
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            jSONObject.put(str, j);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("init_time", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject gc() {
        try {
            String strG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("init_time");
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).m("init_time");
            return new JSONObject(strG);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void z(int i, int i2) {
        try {
            int iG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("low_m_cnt", 0);
            int iG2 = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("clean_invalid_cnt", 0) + i;
            int iG3 = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("force_clean_cnt", 0) + i2;
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("low_m_cnt", iG + 1);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("clean_invalid_cnt", iG2);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("force_clean_cnt", iG3);
        } catch (Throwable unused) {
        }
    }

    public static void z(Map<String, Object> map) {
        try {
            int iG = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("low_m_cnt", 0);
            int iG2 = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("clean_invalid_cnt", 0);
            int iG3 = z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).g("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", iG);
            jSONObject.put("invalid_cnt", iG2);
            jSONObject.put("force_cnt", iG3);
            map.put("low_m_clean", jSONObject);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("low_m_cnt", 0);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("clean_invalid_cnt", 0);
            z("evt_upload_info", com.bytedance.msdk.core.g.getContext()).z("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }

    public static void g(Map<String, Object> map) {
        try {
            Context context = com.bytedance.msdk.core.g.getContext();
            SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g((Context) com.bytedance.msdk.z.gc.z.z(context), "cb_test", 0);
            String string = sharedPreferencesG.getString(MediationConstant.ADN_KS, "");
            String string2 = sharedPreferencesG.getString(MediationConstant.ADN_GDT, "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "cb_test", 0);
                string = sharedPreferencesG.getString(MediationConstant.ADN_KS, "");
                string2 = sharedPreferencesG.getString(MediationConstant.ADN_GDT, "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(MediationConstant.ADN_KS, string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put(MediationConstant.ADN_GDT, string2);
            }
            map.put("cb_stacktrace", jSONObject);
            sharedPreferencesG.edit().clear().apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
