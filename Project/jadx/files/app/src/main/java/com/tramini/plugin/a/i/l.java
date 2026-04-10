package com.tramini.plugin.a.i;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends f {
    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str) {
        int i2;
        int i3;
        String[] strArr;
        String strOptString = jSONObject.optString("pre1");
        String strOptString2 = jSONObject.optString("pre2");
        String strOptString3 = jSONObject.optString("clna");
        String strOptString4 = jSONObject.optString("mena");
        String strOptString5 = jSONObject.optString("adaptna");
        String strOptString6 = jSONObject.optString("ctrlna");
        String strOptString7 = jSONObject.optString("in_na");
        String strOptString8 = jSONObject.optString("objna_arr");
        String strOptString9 = jSONObject.optString("obj2na");
        String strOptString10 = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f12785f);
        Object objD = d(strOptString7, str);
        String str2 = objD instanceof String ? (String) objD : null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] strArrSplit = strOptString3.split(",");
        int length = strArrSplit.length;
        int i4 = 0;
        while (i4 < length) {
            Object objB = f.b(strArrSplit[i4], strOptString4);
            if (objB != null) {
                i2 = i4;
                i3 = length;
                strArr = strArrSplit;
                com.tramini.plugin.a.g.a aVarA = a(objB, strOptString, strOptString6, strOptString5, strOptString2, str2, strOptString8, strOptString9, strOptString10, jSONObject, cVar.f19339e);
                if (aVarA != null) {
                    return aVarA;
                }
            } else {
                i2 = i4;
                i3 = length;
                strArr = strArrSplit;
            }
            i4 = i2 + 1;
            length = i3;
            strArrSplit = strArr;
        }
        return null;
    }

    private static Object d(String str, String str2) {
        Map map;
        try {
            Object objInvoke = Class.forName(str).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field[] declaredFields = objInvoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if ((field.get(objInvoke) instanceof Map) && (map = (Map) field.get(objInvoke)) != null && map.containsKey(str2)) {
                        return map.get(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static com.tramini.plugin.a.g.a a(Object obj, String str, String str2, JSONObject jSONObject, JSONArray jSONArray) {
        Object obj2;
        Object obj3;
        String str3;
        try {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length != 2) {
                return null;
            }
            try {
                List list = (List) f.b(obj, str);
                obj2 = null;
                for (int i2 = 0; i2 < list.size() && (obj2 = list.get(i2)) == null; i2++) {
                    try {
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                obj2 = null;
            }
            Object objA = f.a(f.b(obj2, strArrSplit[0]), strArrSplit[1]);
            JSONObject jSONObject2 = new JSONObject();
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                String strOptString = jSONArray.optString(i3);
                String strOptString2 = jSONObject.optString(strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    try {
                        str3 = (String) f.b(obj, strOptString2);
                    } catch (Throwable unused3) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put(strOptString, str3);
                    } else {
                        String str4 = (String) f.b(obj2, strOptString2);
                        if (!TextUtils.isEmpty(str4)) {
                            jSONObject2.put(strOptString, str4);
                        } else {
                            if (objA instanceof String) {
                                String string = objA.toString();
                                JSONArray jSONArray2 = new JSONArray(strOptString2);
                                int i4 = 0;
                                boolean z2 = false;
                                while (i4 < jSONArray2.length()) {
                                    Matcher matcher = Pattern.compile(jSONArray2.optString(i4)).matcher(string);
                                    while (true) {
                                        if (!matcher.find()) {
                                            obj3 = objA;
                                            break;
                                        }
                                        String strGroup = matcher.group();
                                        int iIndexOf = strGroup.indexOf(">");
                                        int iIndexOf2 = strGroup.indexOf("<");
                                        obj3 = objA;
                                        if (iIndexOf != -1 && iIndexOf2 != -1) {
                                            try {
                                                String strSubstring = strGroup.substring(iIndexOf + 1, iIndexOf2);
                                                if (!TextUtils.isEmpty(strSubstring)) {
                                                    jSONObject2.put(strOptString, strSubstring);
                                                    z2 = true;
                                                    break;
                                                }
                                            } catch (Throwable unused4) {
                                            }
                                        }
                                        objA = obj3;
                                    }
                                    if (!z2) {
                                        i4++;
                                        objA = obj3;
                                    }
                                }
                            }
                            i3++;
                            objA = obj3;
                        }
                    }
                }
                obj3 = objA;
                i3++;
                objA = obj3;
            }
            if (jSONObject2.length() <= 0) {
                return null;
            }
            com.tramini.plugin.a.g.a aVar = new com.tramini.plugin.a.g.a();
            aVar.a = jSONObject2;
            return aVar;
        } catch (Throwable unused5) {
            return null;
        }
    }

    private static com.tramini.plugin.a.g.a a(Object obj, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            Object objA = f.a(obj, str, new StringBuffer(), new h(str5, str2));
            Object objA2 = objA == null ? null : f.a(objA, str, new StringBuffer(), new i(str3));
            if (objA2 == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Object objA3 = f.a(objA2, str4, stringBuffer, new j(str4, str6));
            if (objA3 == null) {
                objA3 = f.a(objA2, str4, new StringBuffer(), new k(str5, str4, stringBuffer, str6));
            }
            if (objA3 == null) {
                return null;
            }
            return a(objA3, str7, str8, jSONObject, jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
