package com.bytedance.sdk.openadsdk.core.dl;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.un.hh;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1037a = null;
    private static AtomicBoolean dl = new AtomicBoolean(false);
    private static boolean g = false;
    private static long z = -1;

    public static void z() {
        if (z > -1) {
            return;
        }
        z = SystemClock.elapsedRealtime();
    }

    public static boolean g() {
        if (g) {
            return true;
        }
        if (z == -1) {
            return false;
        }
        boolean z2 = SystemClock.elapsedRealtime() - z > 60000;
        g = z2;
        return z2;
    }

    public static JSONObject z(Context context, int i) {
        return g(context, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0347 A[Catch: all -> 0x0396, TryCatch #0 {all -> 0x0396, blocks: (B:3:0x0009, B:7:0x0019, B:10:0x0025, B:12:0x002f, B:15:0x0036, B:22:0x004b, B:24:0x0055, B:27:0x005c, B:32:0x006d, B:35:0x007a, B:37:0x0084, B:40:0x008b, B:45:0x009c, B:48:0x00a8, B:52:0x00bb, B:54:0x00c5, B:57:0x00cc, B:62:0x00dd, B:65:0x017c, B:67:0x0186, B:70:0x018d, B:75:0x019e, B:79:0x01f0, B:81:0x0260, B:84:0x026d, B:86:0x0277, B:89:0x027e, B:97:0x0294, B:99:0x029e, B:102:0x02a5, B:110:0x02bb, B:112:0x02c5, B:115:0x02cc, B:123:0x02e2, B:125:0x02ec, B:129:0x02f4, B:137:0x030a, B:139:0x0314, B:144:0x0325, B:147:0x0335, B:149:0x0343, B:151:0x034e, B:153:0x0361, B:154:0x0366, B:156:0x0375, B:157:0x037a, B:161:0x0392, B:160:0x038f, B:150:0x0347, B:140:0x0318, B:143:0x0322, B:130:0x02f8, B:134:0x0303, B:116:0x02d0, B:120:0x02db, B:103:0x02a9, B:107:0x02b4, B:90:0x0282, B:94:0x028d, B:71:0x0191, B:74:0x019b, B:58:0x00d0, B:61:0x00da, B:49:0x00b0, B:41:0x008f, B:44:0x0099, B:28:0x0060, B:31:0x006a, B:16:0x003a, B:19:0x0044), top: B:166:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject g(android.content.Context r16, int r17) {
        /*
            Method dump skipped, instruction units count: 923
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dl.z.g(android.content.Context, int):org.json.JSONObject");
    }

    public static void z(JSONObject jSONObject, int i) throws JSONException {
        if (!dl.z().z(i)) {
            g(jSONObject);
            return;
        }
        JSONArray jSONArrayP = a.z().p();
        if (jSONArrayP != null) {
            if (jSONArrayP.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayP);
            }
            if (dl.get()) {
                return;
            }
            dl.set(true);
            e.g(new fo("tt-scheme") { // from class: com.bytedance.sdk.openadsdk.core.dl.z.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        z.g(null);
                    } catch (Exception unused) {
                    }
                    z.dl.set(false);
                }
            });
            return;
        }
        g(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(JSONObject jSONObject) throws JSONException {
        Set<String> setLt = zw.g().lt();
        if (setLt == null || setLt.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapZ = hh.z(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapZ.entrySet()) {
            String key = entry.getKey();
            if (setLt.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            a.z().z(jSONArray);
        } else {
            e.g(new fo("tt-scheme-save") { // from class: com.bytedance.sdk.openadsdk.core.dl.z.2
                @Override // java.lang.Runnable
                public void run() {
                    a.z().z(jSONArray);
                }
            });
        }
    }

    public static String[] z(int i) {
        try {
            return uy.g(!g());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String z(String str, int i) {
        return kb.z(str);
    }

    public static String dl() {
        if (!TextUtils.isEmpty(f1037a)) {
            return f1037a;
        }
        String strDl = a.z().dl((String) null);
        f1037a = strDl;
        return strDl;
    }
}
