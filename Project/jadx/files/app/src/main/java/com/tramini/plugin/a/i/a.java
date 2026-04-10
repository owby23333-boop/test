package com.tramini.plugin.a.i;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    private static final String a = JSONObject.class.getName();

    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str, String str2) {
        return a(f.a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), a(jSONObject.optJSONArray("p_key")), jSONObject, cVar.f19339e, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1852354744: goto L29;
                case -1052935859: goto L1f;
                case -336842123: goto L15;
                case 45377598: goto Lb;
                default: goto La;
            }
        La:
            goto L33
        Lb:
            java.lang.String r0 = "html_doctype_write"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 3
            goto L34
        L15:
            java.lang.String r0 = "html_x3d"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 2
            goto L34
        L1f:
            java.lang.String r0 = "naitve"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 0
            goto L34
        L29:
            java.lang.String r0 = "html_play"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L33
            r5 = 1
            goto L34
        L33:
            r5 = -1
        L34:
            if (r5 == 0) goto L9d
            if (r5 == r3) goto L7e
            if (r5 == r2) goto L7e
            if (r5 == r1) goto L45
            java.lang.String r4 = com.tramini.plugin.a.i.f.c(r4)
            java.lang.String r4 = e(r4)
            return r4
        L45:
            java.lang.String r5 = "x22"
            java.lang.String r0 = "\""
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r5 = "x26"
            java.lang.String r0 = "&"
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r5 = "x27"
            java.lang.String r0 = "'"
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r5 = "x3c"
            java.lang.String r0 = "<"
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r5 = "x3d"
            java.lang.String r0 = "="
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r5 = "x3e"
            java.lang.String r0 = ">"
            java.lang.String r4 = r4.replace(r5, r0)
            java.lang.String r4 = com.tramini.plugin.a.i.f.c(r4)
            java.lang.String r4 = e(r4)
            return r4
        L7e:
            java.lang.String r5 = "%"
            java.lang.String r0 = "\\\\\\\\x"
            java.lang.String r4 = r4.replace(r0, r5)
            java.lang.String r0 = "\\\\x"
            java.lang.String r4 = r4.replaceAll(r0, r5)
            java.lang.String r5 = "\\\\n"
            java.lang.String r0 = ""
            java.lang.String r4 = r4.replaceAll(r5, r0)
            java.lang.String r4 = com.tramini.plugin.a.i.f.c(r4)
            java.lang.String r4 = e(r4)
            return r4
        L9d:
            java.lang.String r5 = "\\/"
            java.lang.String r0 = "/"
            java.lang.String r4 = r4.replace(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.a.d(java.lang.String, java.lang.String):java.lang.String");
    }

    private static String e(String str) {
        return str.replaceAll("&amp;", DispatchConstants.SIGN_SPLIT_SYMBOL).replaceAll("&quot;", "\"");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = ""
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7b
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L7b
            r6 = 0
            r2 = r0
        L9:
            int r3 = r1.length()     // Catch: java.lang.Throwable -> L7b
            if (r6 >= r3) goto L7b
            org.json.JSONObject r3 = r1.optJSONObject(r6)     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L78
            java.lang.String r4 = "action"
            r5 = -1
            int r4 = r3.optInt(r4, r5)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "param"
            java.lang.String r3 = r3.optString(r5, r0)     // Catch: java.lang.Throwable -> L7b
            r5 = 11
            if (r4 == r5) goto L67
            r5 = 13
            if (r4 == r5) goto L5c
            r5 = 101(0x65, float:1.42E-43)
            if (r4 == r5) goto L51
            r5 = 102(0x66, float:1.43E-43)
            if (r4 == r5) goto L33
            goto L71
        L33:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L78
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = "'"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L7b
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "'\\s*:\\s*'(.*?)'"
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = com.tramini.plugin.a.i.f.c(r7, r2)     // Catch: java.lang.Throwable -> L7b
            goto L71
        L51:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L78
            java.lang.String r2 = com.tramini.plugin.a.i.f.c.a(r7, r3)     // Catch: java.lang.Throwable -> L7b
            goto L71
        L5c:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L78
            java.lang.String r2 = com.tramini.plugin.a.i.f.e.b(r7, r3)     // Catch: java.lang.Throwable -> L7b
            goto L71
        L67:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L78
            java.lang.String r2 = com.tramini.plugin.a.i.f.e.a(r7, r3)     // Catch: java.lang.Throwable -> L7b
        L71:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L78
            return r2
        L78:
            int r6 = r6 + 1
            goto L9
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.a.e(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0111 A[PHI: r0
  0x0111: PHI (r0v3 org.json.JSONObject) = (r0v2 org.json.JSONObject), (r0v10 org.json.JSONObject), (r0v10 org.json.JSONObject) binds: [B:72:0x0125, B:13:0x0043, B:15:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tramini.plugin.a.g.a a(java.lang.Object r17, java.lang.String r18, java.lang.String[] r19, org.json.JSONObject r20, org.json.JSONArray r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.a.a(java.lang.Object, java.lang.String, java.lang.String[], org.json.JSONObject, org.json.JSONArray, java.lang.String):com.tramini.plugin.a.g.a");
    }

    private static JSONObject a(Object obj, Set<Object> set, String str, String str2) {
        if (obj != null && !set.contains(obj)) {
            set.add(obj);
            Class<?> superclass = obj.getClass();
            ArrayList<Field> arrayList = new ArrayList();
            do {
                arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
                superclass = superclass.getSuperclass();
            } while (superclass.getName().startsWith(str2));
            for (Field field : arrayList) {
                field.setAccessible(true);
                try {
                    Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        if (!field.getType().getName().equals("interface") && !obj2.getClass().getName().startsWith(str2)) {
                            if (field.getType().getName().equals(a)) {
                                JSONObject jSONObject = (JSONObject) obj2;
                                if (jSONObject.has(str)) {
                                    return jSONObject;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            JSONObject jSONObjectA = a(obj2, set, str, str2);
                            if (jSONObjectA != null) {
                                return jSONObjectA;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private static String[] a(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    strArr[i2] = jSONArray.getString(i2);
                } catch (JSONException unused) {
                    return strArr;
                }
            }
            return strArr;
        } catch (JSONException unused2) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.a.a(java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):java.lang.String");
    }
}
