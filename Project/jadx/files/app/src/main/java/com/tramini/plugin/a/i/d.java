package com.tramini.plugin.a.i;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {
    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str) {
        return a(f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject, cVar.f19339e);
    }

    private static Method c(Object obj, String str) {
        try {
            ArrayList<Method> arrayList = new ArrayList();
            f.b(obj.getClass(), arrayList);
            for (Method method : arrayList) {
                if (method.getGenericReturnType().toString().contains(str)) {
                    return method;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String d(Object obj, String str) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            if (jSONObject.has(str)) {
                return jSONObject.optString(str);
            }
            while (itKeys.hasNext()) {
                Object objOpt = jSONObject.opt(itKeys.next());
                if ((objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
                    String strD = d(objOpt, str);
                    if (!TextUtils.isEmpty(strD)) {
                        return strD;
                    }
                }
            }
        }
        if (!(obj instanceof JSONArray)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            JSONArray jSONArray = (JSONArray) obj;
            if (i2 >= jSONArray.length()) {
                return null;
            }
            Object objOpt2 = jSONArray.opt(i2);
            if ((objOpt2 instanceof JSONObject) || (objOpt2 instanceof JSONArray)) {
                String strD2 = d(objOpt2, str);
                if (!TextUtils.isEmpty(strD2)) {
                    return strD2;
                }
            }
            i2++;
        }
    }

    private static com.tramini.plugin.a.g.a a(Object obj, String str, String str2, String str3, JSONObject jSONObject, JSONArray jSONArray) {
        com.tramini.plugin.a.g.a aVarA;
        Object objInvoke;
        if (obj == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        String str4 = str + obj.getClass().getName() + ",";
        try {
            ArrayList arrayList = new ArrayList();
            f.a(obj.getClass(), arrayList);
            Field[] fieldArr = new Field[arrayList.size()];
            arrayList.toArray(fieldArr);
            if (fieldArr.length == 0) {
                return null;
            }
            int length = fieldArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                Field field = fieldArr[i3];
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                Method methodC = c(obj2, str3);
                if (obj2 != null && methodC != null) {
                    methodC.setAccessible(true);
                    try {
                        objInvoke = methodC.invoke(obj2, new Object[i2]);
                    } catch (Throwable unused) {
                    }
                    if (objInvoke instanceof JSONObject) {
                        JSONObject jSONObject2 = new JSONObject();
                        String str5 = "";
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                String strOptString = jSONArray.optString(i4);
                                try {
                                    String strOptString2 = jSONObject.optString(strOptString);
                                    if (TextUtils.equals(strOptString2, "all")) {
                                        str5 = strOptString;
                                    } else {
                                        String strD = d(objInvoke, strOptString2);
                                        if (!TextUtils.isEmpty(strD)) {
                                            jSONObject2.put(strOptString, strD);
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                            }
                        }
                        try {
                            if (jSONObject2.length() > 0) {
                                com.tramini.plugin.a.g.a aVar = new com.tramini.plugin.a.g.a();
                                if (!TextUtils.isEmpty(str5)) {
                                    jSONObject2.put(str5, objInvoke.toString());
                                }
                                aVar.a = jSONObject2;
                                return aVar;
                            }
                            continue;
                        } catch (Throwable unused4) {
                            continue;
                        }
                    }
                } else if (obj2 != null && !str4.contains(obj2.getClass().getName()) && (aVarA = a(obj2, str4, str2, str3, jSONObject, jSONArray)) != null) {
                    return aVarA;
                }
                i3++;
                i2 = 0;
            }
            return null;
        } catch (Throwable unused5) {
            return null;
        }
    }
}
