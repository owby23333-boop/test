package com.tramini.plugin.a.i;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str) {
        return a(f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject.optString("agu"), jSONObject, cVar.f19339e);
    }

    private static Method[] c(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.getGenericReturnType().toString().contains(str)) {
                    arrayList.add(method);
                }
            }
            return (Method[]) arrayList.toArray(new Method[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static com.tramini.plugin.a.g.a a(Object obj, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONArray jSONArray) {
        com.tramini.plugin.a.g.a aVarA;
        int i2;
        Method[] methodArr;
        Object objInvoke;
        Method[] methodArr2;
        int i3;
        String strOptString;
        Object obj2 = obj;
        if (obj2 == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        String str5 = str + obj.getClass().getName() + ",";
        try {
            ArrayList arrayList = new ArrayList();
            f.a(obj.getClass(), arrayList);
            Field[] fieldArr = new Field[arrayList.size()];
            arrayList.toArray(fieldArr);
            if (fieldArr.length == 0) {
                return null;
            }
            int length = fieldArr.length;
            int i4 = 0;
            int i5 = 0;
            while (i5 < length) {
                Field field = fieldArr[i5];
                boolean z2 = true;
                field.setAccessible(true);
                Object obj3 = field.get(obj2);
                Method[] methodArrC = c(obj3, str3);
                if (obj3 != null && methodArrC != null) {
                    int length2 = methodArrC.length;
                    int i6 = 0;
                    while (i6 < length2) {
                        Method method = methodArrC[i6];
                        method.setAccessible(z2);
                        try {
                            objInvoke = method.invoke(obj3, new Object[i4]);
                        } catch (Throwable unused) {
                        }
                        if (objInvoke instanceof JSONObject) {
                            try {
                                if (((JSONObject) objInvoke).has(str4)) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    int i7 = 0;
                                    while (i7 < jSONArray.length()) {
                                        try {
                                            strOptString = jSONArray.optString(i7);
                                            methodArr2 = methodArrC;
                                        } catch (Throwable unused2) {
                                            methodArr2 = methodArrC;
                                        }
                                        try {
                                            String strOptString2 = jSONObject.optString(strOptString);
                                            i3 = length2;
                                            try {
                                                if (TextUtils.equals(strOptString2, "all")) {
                                                    jSONObject2.put(strOptString, objInvoke.toString());
                                                } else {
                                                    String strA = a(strOptString2, (JSONObject) objInvoke);
                                                    if (!TextUtils.isEmpty(strA)) {
                                                        jSONObject2.put(strOptString, strA);
                                                    }
                                                }
                                            } catch (Throwable unused3) {
                                            }
                                        } catch (Throwable unused4) {
                                            i3 = length2;
                                        }
                                        i7++;
                                        methodArrC = methodArr2;
                                        length2 = i3;
                                    }
                                    methodArr = methodArrC;
                                    i2 = length2;
                                    try {
                                        com.tramini.plugin.a.g.a aVar = new com.tramini.plugin.a.g.a();
                                        aVar.a = jSONObject2;
                                        return aVar;
                                    } catch (Throwable unused5) {
                                        continue;
                                    }
                                }
                            } catch (Throwable unused6) {
                            }
                        }
                        methodArr = methodArrC;
                        i2 = length2;
                        i6++;
                        z2 = true;
                        i4 = 0;
                        methodArrC = methodArr;
                        length2 = i2;
                    }
                } else if (obj3 != null && !str5.contains(obj3.getClass().getName()) && (aVarA = a(obj3, str5, str2, str3, str4, jSONObject, jSONArray)) != null) {
                    return aVarA;
                }
                i5++;
                i4 = 0;
                obj2 = obj;
            }
            return null;
        } catch (Throwable unused7) {
            return null;
        }
    }

    private static String a(String str, JSONObject jSONObject) throws JSONException {
        String[] strArrSplit;
        JSONObject jSONObject2;
        int i2;
        try {
            strArrSplit = str.split(":");
            jSONObject2 = jSONObject;
            i2 = 0;
        } catch (Throwable unused) {
            return "";
        }
        while (i2 < strArrSplit.length) {
            int i3 = i2 + 1;
            if (i3 == strArrSplit.length) {
                return jSONObject2.optString(strArrSplit[i2]);
            }
            try {
                jSONObject2 = new JSONObject(jSONObject2.optString(strArrSplit[i2]));
            } catch (JSONException unused2) {
                jSONObject2 = new JSONArray(jSONObject2.optString(strArrSplit[i2])).getJSONObject(0);
            }
            i2 = i3;
            return "";
        }
        return "";
    }
}
