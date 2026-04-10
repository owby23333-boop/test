package com.xiaomi.phonenum.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.alipay.sdk.m.y.l;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class MapUtil {
    public static String join(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static JSONObject joinToJson(Map<String, List<String>> map) throws JSONException {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            String strJoin = join(entry.getValue(), ";");
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(strJoin)) {
                jSONObject.put(key, strJoin);
            }
        }
        return jSONObject;
    }

    public static String joinToJsonMap(Map<String, List<String>> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean z = true;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            String strJoin = join(entry.getValue(), ";");
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(strJoin)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(key);
                sb.append("\"");
                sb.append(":");
                sb.append("\"");
                sb.append(strJoin);
                sb.append("\"");
            }
        }
        sb.append(l.d);
        return sb.toString();
    }

    public static String joinToQuery(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(a.p);
                }
                sb.append(key);
                sb.append(MscKeys.KEY_VAL_SEP);
                sb.append(value);
            }
        }
        return sb.toString();
    }

    public static Map<String, String> jsonToMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return map;
    }
}
