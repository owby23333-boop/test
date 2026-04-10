package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.e;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static final HashMap<String, e.z> z = new HashMap<>();

    public static boolean z(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && z(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return g(jSONObject) && z(jSONObject.optJSONArray("device_requirements")) && dl(jSONObject);
    }

    public static boolean g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                if (i >= i3 && i <= i4) {
                    return true;
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return false;
    }

    public static boolean dl(JSONObject jSONObject) {
        return jSONObject == null || m.z() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean z(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strUy : strOptString.split(",")) {
                    if ("market".equals(strUy)) {
                        strUy = gc.uy();
                    }
                    e.z zVarG = g(strUy);
                    if (zVarG != null && !(z2 = z(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, zVarG))) {
                        return false;
                    }
                }
            }
        }
        return z2;
    }

    private static boolean z(JSONArray jSONArray, JSONArray jSONArray2, String str, e.z zVar) {
        String strE = zVar.e();
        int iM = zVar.m();
        String str2 = iM + "_" + strE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iM >= i2 && iM <= i3) {
                        return true;
                    }
                }
            } catch (Exception e) {
                wp.z(e);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (g(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !g(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean g(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static e.z g(String str) {
        HashMap<String, e.z> map = z;
        if (map.containsKey(str)) {
            e.z zVar = map.get(str);
            if (zVar != null) {
                return zVar;
            }
            return null;
        }
        e.z zVarG = e.g(str);
        map.put(str, zVarG);
        if (zVarG != null) {
            return zVarG;
        }
        return null;
    }

    public static e.z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                e.z zVarG = g(str);
                if (zVarG != null) {
                    return zVarG;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean z(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strZ = dl.z(jSONObject.optString("az"), strOptString);
                String strZ2 = dl.z(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strZ);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strZ2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
