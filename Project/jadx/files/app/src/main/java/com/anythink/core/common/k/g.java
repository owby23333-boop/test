package com.anythink.core.common.k;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    public static class a {
        public static final String a = "com.android.vending";
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            String str2 = "Invalid Channel(" + str + "):Channel'length over 128";
            return false;
        }
        if (Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        }
        String str3 = "Invalid Channel(" + str + "): contains some characters that are not in the ^([.A-Za-z0-9_-]){1,128}$";
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            String str2 = "Invalid SubChannel(" + str + "):SubChannel'length over 128";
            return false;
        }
        if (Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        }
        String str3 = "Invalid SubChannel(" + str + "):SubChannel contains some characters that are not in the ^([.A-Za-z0-9_-]){1,128}$";
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 14) {
            String str2 = "Invalid Scenario(" + str + "):Scenario'length isn't 14";
            return false;
        }
        if (Pattern.matches("^[A-Za-z0-9]+$", str)) {
            return true;
        }
        String str3 = "Invalid Scenario(" + str + "):Scenario contains some characters that are not in the [A-Za-z0-9]";
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 48: goto L34;
                case 49: goto L2a;
                case 50: goto L20;
                case 51: goto L16;
                case 52: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L3e
        Lc:
            java.lang.String r0 = "4"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 4
            goto L3f
        L16:
            java.lang.String r0 = "3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 3
            goto L3f
        L20:
            java.lang.String r0 = "2"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 2
            goto L3f
        L2a:
            java.lang.String r0 = "1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 1
            goto L3f
        L34:
            java.lang.String r0 = "0"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3e
            r5 = 0
            goto L3f
        L3e:
            r5 = -1
        L3f:
            if (r5 == 0) goto L58
            if (r5 == r4) goto L55
            if (r5 == r3) goto L52
            if (r5 == r2) goto L4f
            if (r5 == r1) goto L4c
            java.lang.String r5 = ""
            return r5
        L4c:
            java.lang.String r5 = "Splash"
            return r5
        L4f:
            java.lang.String r5 = "Interstitial"
            return r5
        L52:
            java.lang.String r5 = "Banner"
            return r5
        L55:
            java.lang.String r5 = "RewardedVideo"
            return r5
        L58:
            java.lang.String r5 = "Native"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.g.d(java.lang.String):java.lang.String");
    }

    private static boolean d(Context context) {
        return q.a().b(context);
    }

    public static String a(String str, String str2, long j2) {
        return str + "_" + str2 + "_" + j2;
    }

    public static String b(String str, String str2, long j2) {
        return a(str, str2, j2) + "_refresh";
    }

    private static boolean c(Context context) {
        return q.a().a(context);
    }

    public static JSONObject a(Context context, String str, String str2, int i2, int i3) {
        ae aeVar;
        int i4;
        int i5;
        Map<String, ae> mapA = com.anythink.core.a.a.a(context).a(i2);
        if (mapA != null) {
            i4 = 0;
            i5 = 0;
            for (ae aeVar2 : mapA.values()) {
                i4 += aeVar2.f7139c;
                i5 += aeVar2.f7140d;
            }
            aeVar = mapA.get(str2);
        } else {
            aeVar = null;
            i4 = 0;
            i5 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sr", "tp");
            jSONObject.put("rid", str);
            jSONObject.put(com.anythink.expressad.foundation.d.d.f10218h, i4);
            jSONObject.put("ahs", i5);
            jSONObject.put("pds", aeVar != null ? aeVar.f7139c : 0);
            jSONObject.put("phs", aeVar != null ? aeVar.f7140d : 0);
            jSONObject.put(IAdInterListener.AdReqParam.AP, i3);
            jSONObject.put("tpl", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String b(Context context) {
        String strX = com.anythink.core.common.b.n.a().x();
        if (TextUtils.isEmpty(strX)) {
            strX = d.d(context) + d.f();
        }
        return f.a(strX + UUID.randomUUID().toString());
    }

    private static boolean c() {
        return q.a().b();
    }

    public static boolean b() {
        try {
            Map<String, Object> mapM = com.anythink.core.common.b.n.a().m();
            if (mapM == null || !mapM.containsKey(ATCustomRuleKeys.AGE)) {
                return false;
            }
            return Integer.parseInt(mapM.get(ATCustomRuleKeys.AGE).toString()) <= 13;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(Context context) {
        String strX = com.anythink.core.common.b.n.a().x();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d.d(context));
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append(d.f());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append(strX);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append(new Random().nextInt(10000));
        return f.a(stringBuffer.toString());
    }

    public static void a(List<ai> list, ai aiVar, boolean z2) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (z2) {
            if (aiVar.a() == -1 || size == 0) {
                list.add(aiVar);
                return;
            }
        } else if (size == 0) {
            list.add(aiVar);
            return;
        }
        int i2 = size - 1;
        int i3 = 0;
        while (i3 < size) {
            ai aiVar2 = list.get(i3);
            boolean z3 = true;
            if ((z2 && aiVar2.a() == -1) || a(aiVar) >= a(aiVar2)) {
                list.add(i3, aiVar);
            } else if (i3 == i2) {
                list.add(aiVar);
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            } else {
                i3++;
            }
        }
    }

    private static boolean a(List<ai> list, ai aiVar, ai aiVar2, int i2, int i3, boolean z2) {
        if (z2 && aiVar.a() == -1) {
            list.add(i2, aiVar2);
            return true;
        }
        if (a(aiVar2) >= a(aiVar)) {
            list.add(i2, aiVar2);
            return true;
        }
        if (i2 != i3) {
            return false;
        }
        list.add(aiVar2);
        return true;
    }

    public static void a(com.anythink.core.common.e.e eVar, String str, String str2, String str3) {
        if (!ATSDK.isNetworkLogDebug() || eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (eVar.y() != 0) {
                jSONObject.put("defaultAdSourceType", eVar.y());
            }
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, eVar.W());
            jSONObject.put("adType", eVar.Z());
            jSONObject.put("mixedFormatAdType", eVar.L());
            jSONObject.put(NativeAdvancedJsUtils.f8246p, str);
            jSONObject.put("refresh", eVar.F());
            jSONObject.put("result", str2);
            jSONObject.put("segmentId", eVar.I());
            jSONObject.put("adSourceId", eVar.x());
            jSONObject.put("position", eVar.z());
            jSONObject.put("networkType", eVar.H());
            jSONObject.put("networkName", eVar.T());
            jSONObject.put("networkVersion", eVar.f7247u);
            jSONObject.put("networkUnit", eVar.G());
            jSONObject.put("isHB", eVar.v());
            jSONObject.put("msg", str3);
            jSONObject.put("hourly_frequency", eVar.B());
            jSONObject.put("daily_frequency", eVar.C());
            jSONObject.put("network_list", eVar.D());
            jSONObject.put("request_network_num", eVar.E());
            jSONObject.put("handle_class", eVar.i());
        } catch (Throwable unused) {
        }
        n.a("network", jSONObject.toString());
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        webView.getSettings().setSavePassword(false);
    }

    public static double a(ai aiVar) {
        if (aiVar == null) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        if (aiVar.aa()) {
            return com.anythink.core.b.f.a().b(aiVar);
        }
        return aiVar.ag();
    }

    private static void a(String str, List<ai> list) {
        if (list != null) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ai aiVar = list.get(i2);
                    sb.append("\n");
                    sb.append(i2);
                    sb.append(" --> adSourceId: ");
                    sb.append(aiVar.t());
                    sb.append(", ");
                    sb.append(aiVar.d());
                    sb.append(", real: ");
                    sb.append(aiVar.x());
                    sb.append(", sort: ");
                    sb.append(a(aiVar));
                    String strZ = aiVar.z();
                    if (!TextUtils.isEmpty(strZ)) {
                        sb.append(", errorMsg: ");
                        sb.append(strZ);
                    }
                }
                sb.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String a() {
        return TextUtils.isEmpty(com.anythink.core.common.b.g.a) ? "UA_0.0.0" : com.anythink.core.common.b.g.a;
    }

    public static String a(com.anythink.core.common.e.i iVar) {
        return f.a(iVar.p() + iVar.A());
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.e.e eVar) {
        if (eVar == null || eVar.H() >= 100000) {
            return;
        }
        map.put(g.k.f6898h, eVar);
    }

    private static int a(int i2, int[] iArr, int i3) {
        if (iArr == null) {
            return i3;
        }
        for (int i4 : iArr) {
            if (i2 == i4) {
                return i2;
            }
        }
        return i3;
    }
}
