package com.baidu.tts.tools;

import java.util.Collection;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class JsonTool {
    public static JSONArray fromSetToJson(Set<String> set) {
        if (set != null) {
            return new JSONArray((Collection) set);
        }
        return null;
    }

    public static String[] getStringarray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArray.optString(i2);
        }
        return strArr;
    }
}
