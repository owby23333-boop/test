package com.bytedance.sdk.component.z;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class gz {
    private wp z;

    static gz z(wp wpVar) {
        return new gz(wpVar);
    }

    private gz(wp wpVar) {
        this.z = wpVar;
    }

    <T> T z(String str, Type type) throws JSONException {
        z(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.z.z(str, type);
    }

    <T> String z(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.z.z(t);
        }
        z(string);
        return string;
    }

    private static void z(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        fo.z(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
