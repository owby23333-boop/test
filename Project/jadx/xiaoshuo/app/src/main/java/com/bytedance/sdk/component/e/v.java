package com.bytedance.sdk.component.e;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class v {
    private xu e;

    private v(xu xuVar) {
        this.e = xuVar;
    }

    public static v e(xu xuVar) {
        return new v(xuVar);
    }

    public <T> T e(String str, Type type) throws JSONException {
        e(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.e.e(str, type);
    }

    public <T> String e(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
            string = this.e.e(t);
        } else {
            string = t.toString();
        }
        e(string);
        return string;
    }

    private static void e(String str) {
        if (str.startsWith("{") && str.endsWith(com.alipay.sdk.m.y.l.d)) {
            return;
        }
        zk.e(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
    }
}
