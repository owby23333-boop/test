package com.mibi.sdk.common;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.utils.MibiLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class BundleUtils {
    private static final String TAG = "BundleUtils";

    public static String appendBundle2Url(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uriBuild = Uri.parse(str);
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if ((obj instanceof Integer) || (obj instanceof Boolean) || (obj instanceof String)) {
                uriBuild = uriBuild.buildUpon().appendQueryParameter(str2, obj.toString()).build();
            }
        }
        return uriBuild.toString();
    }

    public static JSONObject convertBundle2Json(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            try {
                if (obj instanceof String) {
                    try {
                        jSONObject.put(str, new JSONObject(obj.toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jSONObject.put(str, obj);
                    }
                }
                jSONObject.put(str, obj.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
                MibiLog.e(TAG, "can not convert types except for int string and string key:" + str);
            }
        }
        return jSONObject;
    }

    public static Bundle convertJson2Bundle(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, obj.toString());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                MibiLog.e(TAG, "can not put value into bundle string and string key:" + next);
            }
        }
        return bundle;
    }

    public static Map<String, Object> convertJson2Map(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if ((obj instanceof Integer) || (obj instanceof Boolean) || (obj instanceof String)) {
                    map.put(next, obj);
                } else {
                    MibiLog.e(TAG, "can not convert types except for int string and string key:" + next);
                }
            }
            return map;
        } catch (JSONException e) {
            MibiLog.e(TAG, "BundleUtils convertJson2Map JSONException: ", e);
            return null;
        }
    }

    public static Bundle convertMap2Bundle(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else {
                MibiLog.e(TAG, "can not convert types except for int string and string key:" + str);
            }
        }
        return bundle;
    }
}
