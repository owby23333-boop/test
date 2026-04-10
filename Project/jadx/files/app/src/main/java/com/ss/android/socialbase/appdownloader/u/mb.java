package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.ko;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    private static final HashMap<String, ko.mb> mb = new HashMap<>();

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || h.mb() || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static boolean mb(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && mb(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int iOptInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i2 >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i3 = 0; i3 < strArrSplit.length; i3 += 2) {
                int i4 = Integer.parseInt(strArrSplit[i3]);
                int i5 = Integer.parseInt(strArrSplit[i3 + 1]);
                if (i2 >= i4 && i2 <= i5) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return ox(jSONObject) && mb(jSONObject.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS)) && b(jSONObject);
    }

    public static boolean mb(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
                String strOptString2 = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                boolean zMb = z2;
                for (String strLz : strOptString.split(",")) {
                    if ("market".equals(strLz)) {
                        strLz = hj.lz();
                    }
                    ko.mb mbVarOx = ox(strLz);
                    if (mbVarOx != null && !(zMb = mb(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, mbVarOx))) {
                        return false;
                    }
                }
                z2 = zMb;
            }
        }
        return z2;
    }

    private static boolean ox(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ko.mb ox(String str) {
        if (mb.containsKey(str)) {
            ko.mb mbVar = mb.get(str);
            if (mbVar != null) {
                return mbVar;
            }
            return null;
        }
        ko.mb mbVarOx = ko.ox(str);
        mb.put(str, mbVarOx);
        if (mbVarOx != null) {
            return mbVarOx;
        }
        return null;
    }

    private static boolean mb(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull ko.mb mbVar) {
        String strKo = mbVar.ko();
        int iU = mbVar.u();
        String str2 = iU + "_" + strKo;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                    int i3 = Integer.parseInt(strArrSplit[i2]);
                    int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                    if (iU >= i3 && iU <= i4) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (ox(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !ox(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static ko.mb mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ko.mb mbVarOx = ox(str);
                if (mbVarOx != null) {
                    return mbVarOx;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean mb(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strMb = b.mb(jSONObject.optString("az"), strOptString);
                String strMb2 = b.mb(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strMb);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strMb2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
