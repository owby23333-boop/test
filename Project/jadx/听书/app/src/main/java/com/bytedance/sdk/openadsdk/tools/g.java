package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1473a = 0;
    private static Map<Integer, String> dl = null;
    private static boolean g = false;
    private static String z = "SettingRitRepertoryImpl";

    public static String dl() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static boolean z() {
        return g;
    }

    public static void g() {
        g = true;
    }

    public static String z(int i, String str) {
        if (dl == null || System.currentTimeMillis() - f1473a > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            f1473a = System.currentTimeMillis();
            dl = a();
        }
        Map<Integer, String> map = dl;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strDl = com.bytedance.sdk.component.utils.z.dl(map.get(Integer.valueOf(i)));
            return "null".equals(strDl) ? "" : strDl;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[PHI: r3
  0x0058: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:21:0x0056, B:15:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.Integer, java.lang.String> a() {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "_id"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            java.lang.String r5 = "setting_global_info"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            r7 = 0
            r6[r7] = r1     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            r7 = 1
            r6[r7] = r0     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r3 = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            if (r3 != 0) goto L2a
            if (r3 == 0) goto L29
            r3.close()
        L29:
            return r2
        L2a:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            if (r4 == 0) goto L4c
            int r4 = r3.getColumnIndex(r1)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            int r4 = r3.getInt(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            int r5 = r3.getColumnIndex(r0)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            if (r5 != 0) goto L48
            java.lang.String r5 = ""
        L48:
            r2.put(r4, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L4f
            goto L2a
        L4c:
            if (r3 == 0) goto L5b
            goto L58
        L4f:
            r0 = move-exception
            if (r3 == 0) goto L55
            r3.close()
        L55:
            throw r0
        L56:
            if (r3 == 0) goto L5b
        L58:
            r3.close()
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.g.a():java.util.Map");
    }

    public static Map<String, String> z(String str) throws JSONException {
        HashMap map;
        JSONObject jSONObjectG = g(str);
        HashMap map2 = null;
        if (jSONObjectG == null) {
            return null;
        }
        String strOptString = jSONObjectG.optString("ext");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            map = new HashMap();
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("headers");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject.optString(next));
            }
            return map;
        } catch (Exception unused2) {
            map2 = map;
            return map2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject g(java.lang.String r10) throws org.json.JSONException {
        /*
            boolean r0 = z()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            java.lang.String r3 = "setting_rit"
            r4 = 0
            java.lang.String r5 = "rit=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]
            r0 = 0
            r6[r0] = r10
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r10 == 0) goto L6c
            int r0 = r10.getCount()
            if (r0 > 0) goto L27
            goto L6c
        L27:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L3a
            java.lang.String r0 = "config"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L57
            if (r0 < 0) goto L3a
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L57
            goto L3c
        L3a:
            java.lang.String r0 = ""
        L3c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L57
            if (r2 != 0) goto L51
            java.lang.String r0 = com.bytedance.sdk.component.utils.z.dl(r0)     // Catch: java.lang.Throwable -> L57
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L57
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto L50
            r10.close()     // Catch: java.lang.Throwable -> L50
        L50:
            return r2
        L51:
            if (r10 == 0) goto L64
        L53:
            r10.close()     // Catch: java.lang.Throwable -> L64
            goto L64
        L57:
            r0 = move-exception
            java.lang.String r2 = com.bytedance.sdk.openadsdk.tools.g.z     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L65
            com.bytedance.sdk.component.utils.wp.g(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r10 == 0) goto L64
            goto L53
        L64:
            return r1
        L65:
            r0 = move-exception
            if (r10 == 0) goto L6b
            r10.close()     // Catch: java.lang.Throwable -> L6b
        L6b:
            throw r0
        L6c:
            if (r10 == 0) goto L71
            r10.close()
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.g.g(java.lang.String):org.json.JSONObject");
    }

    public static void z(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectG = g(str);
        if (jSONObjectG == null) {
            return;
        }
        String strOptString = jSONObjectG.optString("aid");
        String strOptString2 = jSONObjectG.optString(CmcdConfiguration.KEY_CONTENT_ID);
        String strOptString3 = jSONObjectG.optString("ext");
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (TextUtils.isEmpty(strOptString3)) {
            return;
        }
        jSONObject.put("ext", strOptString3);
    }

    public static void g(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectDl;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (jSONObjectDl = dl(str)) == null) {
            return;
        }
        if (jSONObjectDl.has("image_mode")) {
            jSONObject.put("image_mode", jSONObjectDl.optString("image_mode"));
        }
        if (jSONObjectDl.has("preview_extra")) {
            jSONObject.put("preview_extra", jSONObjectDl.optString("preview_extra"));
        }
        if (jSONObjectDl.has("preview_ads")) {
            jSONObject.put("preview_ads", jSONObjectDl.optJSONObject("preview_ads"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject dl(java.lang.String r10) throws org.json.JSONException {
        /*
            boolean r0 = z()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            java.lang.String r3 = "setting_rit"
            r4 = 0
            java.lang.String r5 = "rit=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]
            r0 = 0
            r6[r0] = r10
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r10 == 0) goto L6c
            int r0 = r10.getCount()
            if (r0 > 0) goto L27
            goto L6c
        L27:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L3a
            java.lang.String r0 = "preview_ads"
            int r0 = r10.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L57
            if (r0 < 0) goto L3a
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L57
            goto L3c
        L3a:
            java.lang.String r0 = ""
        L3c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L57
            if (r2 != 0) goto L51
            java.lang.String r0 = com.bytedance.sdk.component.utils.z.dl(r0)     // Catch: java.lang.Throwable -> L57
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L57
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L57
            if (r10 == 0) goto L50
            r10.close()     // Catch: java.lang.Throwable -> L50
        L50:
            return r2
        L51:
            if (r10 == 0) goto L64
        L53:
            r10.close()     // Catch: java.lang.Throwable -> L64
            goto L64
        L57:
            r0 = move-exception
            java.lang.String r2 = com.bytedance.sdk.openadsdk.tools.g.z     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L65
            com.bytedance.sdk.component.utils.wp.g(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r10 == 0) goto L64
            goto L53
        L64:
            return r1
        L65:
            r0 = move-exception
            if (r10 == 0) goto L6b
            r10.close()     // Catch: java.lang.Throwable -> L6b
        L6b:
            throw r0
        L6c:
            if (r10 == 0) goto L71
            r10.close()
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.g.dl(java.lang.String):org.json.JSONObject");
    }

    public static void z(String str, JSONObject jSONObject) {
        if (!z() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectZ = com.bytedance.sdk.component.utils.z.z(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("value", jSONObjectZ.toString());
        if (z2) {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), "setting_rit", contentValues);
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (z()) {
            String strA = gVar.a();
            if (a(strA)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", gVar.m());
                    jSONObject.put("img_height", gVar.e());
                    jSONObject.put("express_width", gVar.gz());
                    jSONObject.put("express_height", gVar.fo());
                    jSONObject.put("ad_count", gVar.wp());
                } catch (JSONException e) {
                    wp.z(e);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strA);
                contentValues.put("slot", com.bytedance.sdk.component.utils.z.g(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strA});
            }
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r10) {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            java.lang.String r1 = "setting_rit"
            r2 = 0
            java.lang.String r3 = "rit=?"
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]
            r9 = 0
            r4[r9] = r10
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r10 == 0) goto L26
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L1f
            if (r0 <= 0) goto L26
            goto L27
        L1f:
            r0 = move-exception
            if (r10 == 0) goto L25
            r10.close()
        L25:
            throw r0
        L26:
            r8 = r9
        L27:
            if (r10 == 0) goto L2c
            r10.close()
        L2c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tools.g.a(java.lang.String):boolean");
    }

    public static void g(int i, String str) {
        if (z()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            try {
                com.bytedance.sdk.openadsdk.core.multipro.z.z.z(zw.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + com.bytedance.sdk.component.utils.z.g(str) + "')");
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    public static void dl(int i, String str) {
        if (z()) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            String strG = com.bytedance.sdk.component.utils.z.g(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ar.d, Integer.valueOf(i));
            contentValues.put("value", strG);
            if (z2) {
                com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), "setting_global_info", contentValues);
            }
        }
    }
}
