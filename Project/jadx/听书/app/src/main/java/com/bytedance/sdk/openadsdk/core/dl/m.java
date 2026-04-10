package com.bytedance.sdk.openadsdk.core.dl;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.i;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.zw;
import com.google.common.net.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static volatile m z;

    public static m z() {
        if (z == null) {
            synchronized (m.class) {
                if (z == null) {
                    z = new m();
                }
            }
        }
        return z;
    }

    public com.bytedance.sdk.openadsdk.core.h.g z(String str) {
        Object obj;
        com.bytedance.sdk.openadsdk.core.h.g gVar = new com.bytedance.sdk.openadsdk.core.h.g();
        HashMap map = new HashMap();
        try {
            gVar.z(str.length());
            Pair<Integer, ?> pairDl = z().dl(str);
            int iIntValue = 3;
            if (pairDl != null) {
                obj = pairDl.second;
                if (pairDl.first != null) {
                    iIntValue = ((Integer) pairDl.first).intValue();
                }
            } else {
                obj = null;
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", gk.f1105a);
                map.put("x-plugin-version", "7.1.0.5");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
                gVar.z((byte[]) obj);
                gVar.z(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", gk.f1105a);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
                gVar.g(jSONObject);
                gVar.z(map);
            }
        } catch (Throwable unused) {
        }
        return gVar;
    }

    public com.bytedance.sdk.openadsdk.core.h.g g(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.h.g gVar = new com.bytedance.sdk.openadsdk.core.h.g();
        HashMap map = new HashMap();
        try {
            gVar.z(str.length());
            Pair<Integer, JSONObject> pairZ = z().z(str, false);
            if (pairZ != null) {
                JSONObject jSONObject2 = (JSONObject) pairZ.second;
                try {
                    iIntValue = pairZ.first != null ? ((Integer) pairZ.first).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                iIntValue = 3;
            }
            jSONObject.put("ad_sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", gk.f1105a);
                map.put("x-plugin-version", "7.1.0.5");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable unused2) {
        }
        gVar.z(map);
        gVar.g(jSONObject);
        return gVar;
    }

    public Pair<Integer, JSONObject> z(String str, boolean z2) {
        try {
            if (zw.g().yw()) {
                return g(str, z2);
            }
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
        return a(str);
    }

    public Pair<Integer, ?> dl(String str) {
        try {
            if (!TextUtils.isEmpty(str) && zw.g().yw()) {
                return z(str, "get_ad");
            }
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
        return a(str);
    }

    private Pair<Integer, JSONObject> m(String str) {
        return a(str);
    }

    public Pair<Integer, JSONObject> a(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.z.z(str));
    }

    private Pair<Integer, JSONObject> g(String str, boolean z2) {
        com.bytedance.sdk.component.a.z zVarG = io.g();
        JSONObject jSONObjectGc = (TextUtils.isEmpty(str) || zVarG == null || !zVarG.getArmorLoadStatus()) ? null : gc(str);
        if (jSONObjectGc == null || TextUtils.isEmpty(jSONObjectGc.optString("message"))) {
            if (zVarG != null && zVarG.getArmorLoadStatus() && z2) {
                v.z().z(3, -1L, (String) null);
            }
            return m(str);
        }
        return new Pair<>(4, jSONObjectGc);
    }

    public JSONObject gc(String str) {
        com.bytedance.sdk.component.a.z zVarG = io.g();
        if (TextUtils.isEmpty(str) || zVarG == null || !zVarG.getArmorLoadStatus()) {
            return null;
        }
        try {
            byte[] bArrEncrypt = zVarG.encrypt(str.getBytes(StandardCharsets.UTF_8));
            if (bArrEncrypt == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrEncrypt, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Pair<Integer, ?> z(String str, String str2) {
        com.bytedance.sdk.component.a.z zVarG = io.g();
        if (TextUtils.isEmpty(str)) {
            return m(str);
        }
        byte[] bArrEncrypt = (zVarG == null || !zVarG.getArmorLoadStatus()) ? null : zVarG.encrypt(i.z(str.getBytes(StandardCharsets.UTF_8)));
        if (bArrEncrypt == null || bArrEncrypt.length == 0) {
            if (zVarG != null && zVarG.getArmorLoadStatus()) {
                v.z().z(3, -1L, str2);
            }
            return m(str);
        }
        return new Pair<>(4, bArrEncrypt);
    }

    public static Pair<Boolean, JSONObject> z(com.bytedance.sdk.component.fo.g gVar, String str, boolean z2) {
        if (com.bytedance.sdk.component.fo.a.z.z(gVar.dl())) {
            return new Pair<>(Boolean.FALSE, z(gVar.uy(), str));
        }
        String strA = gVar.a();
        if (strA != null && !strA.startsWith("{") && !strA.endsWith("}") && !strA.contains("message") && !strA.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, z(gVar.uy(), str));
        }
        JSONObject jSONObject = null;
        if (strA != null) {
            try {
                jSONObject = new JSONObject(strA);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return new Pair<>(Boolean.TRUE, z(jSONObject, true, z2));
    }

    public static JSONObject z(JSONObject jSONObject, boolean z2, boolean z3) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strZ = z(jSONObject, z2);
            String strOptString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(strZ)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strZ);
            if (z3) {
                try {
                    jSONObject2.put("auction_price", strOptString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String z(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            com.bytedance.sdk.component.a.z zVarG = io.g();
            if (iOptInt == 3) {
                return com.bytedance.sdk.component.utils.z.dl(strOptString);
            }
            if (iOptInt != 4 || zVarG == null) {
                return strOptString;
            }
            String strDecryptWithCBC = zVarG.decryptWithCBC(strOptString);
            if (!TextUtils.isEmpty(strDecryptWithCBC) || !z2) {
                return strDecryptWithCBC;
            }
            v.z().z(1, -1L, (String) null);
            return strDecryptWithCBC;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject z(byte[] bArr, String str) {
        try {
            String strG = g(bArr, str);
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            return new JSONObject(strG);
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    private static String g(byte[] bArr, String str) {
        com.bytedance.sdk.component.a.z zVarG;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (zVarG = io.g()) == null) {
                    return null;
                }
                byte[] bArrDecrypt = zVarG.decrypt(bArr);
                String strG = i.g(bArrDecrypt);
                if (!TextUtils.isEmpty(strG)) {
                    return strG;
                }
                v.z().z((bArrDecrypt == null || bArrDecrypt.length == 0) ? 1 : 2, -1L, str);
                return null;
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return null;
    }
}
