package com.anythink.core.common.k;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final String a = "anythink_bidding";

    public static void a(String str, com.anythink.core.common.e.e eVar, String str2, ai aiVar, int i2, int i3) {
        a(str, eVar, str2, aiVar, i2, i3, null);
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        a(str, str2, str3, str4, str5, false);
    }

    public static void a(String str, com.anythink.core.common.e.e eVar, String str2, ai aiVar, int i2, int i3, List<String> list) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reason", str2);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str);
                jSONObject.put("adtype", eVar.Z());
                jSONObject.put("adsourceId", aiVar.t());
                jSONObject.put("networkFirmId", aiVar.c());
                jSONObject.put("content", eVar.G());
                jSONObject.put("hourly_frequency", i2);
                jSONObject.put("hourly_limit", aiVar.f());
                jSONObject.put("daily_frequency", i3);
                jSONObject.put("daily_limit", aiVar.e());
                jSONObject.put("pacing_limit", aiVar.s());
                jSONObject.put("request_fail_interval", aiVar.H());
                jSONObject.put("filter_source_ids", list != null ? list : "");
                a("anythink_network", jSONObject.toString(), true);
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(String str, String str2) {
        a(str, str2, false);
    }

    public static void a(String str, String str2, String str3, ai aiVar) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.f8246p, g.i.f6876v);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put("adsourceId", aiVar.t());
                jSONObject.put("networkFirmId", aiVar.c());
                jSONObject.put("content", aiVar.g());
                jSONObject.put("msg", aiVar.z());
                a(a, jSONObject.toString(), TextUtils.equals(g.i.f6861g, str));
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.f8246p, g.i.f6877w);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put(RewardItem.KEY_ERROR_MSG, str4);
                a("anythink_network", jSONObject.toString(), TextUtils.equals(g.i.f6861g, str));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) {
        if (ATSDK.isNetworkLogDebug()) {
            a("anythink_".concat(String.valueOf(str)), str2, false);
        }
    }

    public static void a(String str, String str2, boolean z2) {
        String property = System.getProperty("line.separator");
        try {
            if (str2.startsWith("{")) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        String str3 = "╔═══════════════════════════════════════════════════════════════════════════════════════";
        for (String str4 : str2.split(property)) {
            str3 = (str3 + "\n") + "║ " + str4;
        }
        String str5 = str3 + "\n╚═══════════════════════════════════════════════════════════════════════════════════════";
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(com.anythink.core.common.b.n.a().v() ? "(DebuggerMode)" : "");
            sb.toString();
            " \n".concat(String.valueOf(str5));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(com.anythink.core.common.b.n.a().v() ? "(DebuggerMode)" : "");
        sb2.toString();
        " \n".concat(String.valueOf(str5));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (ATSDK.isNetworkLogDebug()) {
            byte b = -1;
            switch (str2.hashCode()) {
                case 48:
                    if (str2.equals("0")) {
                        b = 0;
                    }
                    break;
                case 49:
                    if (str2.equals("1")) {
                        b = 1;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        b = 2;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        b = 3;
                    }
                    break;
                case 52:
                    if (str2.equals("4")) {
                        b = 4;
                    }
                    break;
            }
            if (b == 0) {
                str6 = g.i.f6866l;
            } else if (b == 1) {
                str6 = g.i.f6865k;
            } else if (b == 2) {
                str6 = g.i.f6863i;
            } else if (b != 3) {
                str6 = b != 4 ? "" : g.i.f6867m;
            } else {
                str6 = g.i.f6864j;
            }
            a(str, str6, str3, str4, str5, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            boolean r0 = com.anythink.core.api.ATSDK.isNetworkLogDebug()
            if (r0 == 0) goto Lb7
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb7
            r0.<init>()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = "placementId"
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = "adtype"
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = "api"
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = "result"
            r0.put(r3, r5)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = "reason"
            r0.put(r3, r6)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = ""
            if (r7 == 0) goto L9b
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lb7
            if (r4 != 0) goto L95
            com.anythink.core.common.v r4 = com.anythink.core.common.v.a()     // Catch: java.lang.Throwable -> Lb7
            java.util.Map r2 = r4.c(r2)     // Catch: java.lang.Throwable -> Lb7
            int r4 = r2.size()     // Catch: java.lang.Throwable -> Lb7
            if (r4 <= 0) goto L95
            java.util.Set r2 = r2.entrySet()     // Catch: java.lang.Throwable -> Lb7
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lb7
            r4 = r3
        L45:
            boolean r5 = r2.hasNext()     // Catch: java.lang.Throwable -> Lb7
            if (r5 == 0) goto L81
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> Lb7
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> Lb7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            r6.<init>()     // Catch: java.lang.Throwable -> Lb7
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = "key="
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r4 = r5.getKey()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lb7
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = ",value="
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r4 = r5.getValue()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb7
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = ";"
            r6.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> Lb7
            goto L45
        L81:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r5 = "["
            r2.<init>(r5)     // Catch: java.lang.Throwable -> Lb7
            r2.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = "]"
            r2.append(r4)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb7
            goto L96
        L95:
            r2 = r3
        L96:
            java.lang.String r4 = "extra"
            r0.put(r4, r2)     // Catch: java.lang.Throwable -> Lb7
        L9b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r4 = "anythink_network"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lb7
            com.anythink.core.common.b.n r4 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> Lb7
            boolean r4 = r4.v()     // Catch: java.lang.Throwable -> Lb7
            if (r4 == 0) goto Lae
            java.lang.String r3 = "(DebuggerMode)"
        Lae:
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb7
            r2.toString()     // Catch: java.lang.Throwable -> Lb7
            r0.toString()     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.n.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }
}
