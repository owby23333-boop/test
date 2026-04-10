package com.bytedance.sdk.openadsdk.core.iq;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lq {
    private static final Set<String> e;
    private static final Set<String> fo;
    private static final Set<String> gc;
    private static final Set<String> gz;
    private static final Map<String, String> kb;
    private static final Set<String> m;
    private static boolean uy;
    private static volatile boolean wp;
    public static final Set<String> z;
    private int g;
    private static final Set<String> dl = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f1177a = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        gc = copyOnWriteArraySet;
        m = new CopyOnWriteArraySet();
        e = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        gz = copyOnWriteArraySet2;
        fo = new CopyOnWriteArraySet();
        uy = false;
        kb = new HashMap();
        z = new CopyOnWriteArraySet();
        wp = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public lq(JSONObject jSONObject) {
        this.g = jSONObject.optInt("block_auto_open");
    }

    public void z(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.g);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    public static void g(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                f1177a.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        f1177a.add(strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                gc.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        gc.add(strOptString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                m.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        m.add(strOptString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("url_report_rule_list");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    e.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            e.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    gz.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            gz.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    fo.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            fo.add(strOptString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        uy = true;
    }

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        dlVar.put("turn_up_white_list", f1177a);
        dlVar.put("turn_up_black_list_1", gc);
        dlVar.put("turn_up_black_list_2", m);
        dlVar.put("url_report_rule_list", e);
        dlVar.put("net_url_block_list", gz);
        dlVar.put("_turn_up_is_get_list", uy);
        dlVar.put("dialog_black_list", fo);
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        Set<String> set = f1177a;
        set.addAll(dlVar.get("turn_up_white_list", set));
        Set<String> set2 = gc;
        set2.addAll(dlVar.get("turn_up_black_list_1", set2));
        Set<String> set3 = m;
        set3.addAll(dlVar.get("turn_up_black_list_2", set3));
        Set<String> set4 = e;
        set4.addAll(dlVar.get("url_report_rule_list", set4));
        Set<String> set5 = gz;
        set5.addAll(dlVar.get("net_url_block_list", set5));
        uy = dlVar.get("_turn_up_is_get_list", false);
        Set<String> set6 = fo;
        set6.addAll(dlVar.get("dialog_black_list", set6));
    }

    public static int z(na naVar) {
        lq lqVarMq;
        if (naVar == null || (lqVarMq = naVar.mq()) == null) {
            return 0;
        }
        return lqVarMq.g;
    }

    public static boolean z(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.mc mcVar, String str, boolean z2, boolean z3) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.bytedance.sdk.openadsdk.core.un.eo.z(str, atomicInteger) && z(webView, atomicInteger, str, true)) {
                return true;
            }
            if (mcVar == null || !TextUtils.isEmpty(g(str, dl)) || !TextUtils.isEmpty(g(str, f1177a))) {
                return false;
            }
            String strG = g(str, e);
            if (!TextUtils.isEmpty(strG)) {
                g(mcVar.gz(), str, strG);
            }
            String strZ = z(str, mcVar.gc(z3), z2, z3);
            if (!TextUtils.isEmpty(strZ) && uy) {
                z(mcVar.gz(), str, strZ);
            }
            if (!TextUtils.isEmpty(strZ)) {
                return true;
            }
        }
        return false;
    }

    private static boolean z(WebView webView, AtomicInteger atomicInteger, String str, boolean z2) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = kb;
            if (map.containsKey(path)) {
                return z(atomicInteger, map.get(path), str, webView, z2);
            }
            if (!wp) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.un.x.z("cloud_path_check_res").get("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        kb.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = kb;
                if (map2.containsKey(path)) {
                    return z(atomicInteger, map2.get(path), str, webView, z2);
                }
            }
            com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
            gcVarG.z(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.tb.dl()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", "App").toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put("extra", "");
            gcVarG.z(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.1
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    try {
                        strArr[0] = new JSONObject(gVar.a()).optJSONObject("data").optString("label");
                        if (TextUtils.isEmpty(strArr[0])) {
                            return;
                        }
                        if (lq.kb.size() > 1000) {
                            Iterator it = lq.kb.entrySet().iterator();
                            for (int i = 0; i < 200; i++) {
                                it.next();
                                it.remove();
                            }
                        }
                        lq.kb.put(path, strArr[0]);
                        if (!lq.wp) {
                            boolean unused = lq.wp = true;
                            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.un.x.z("cloud_path_check_res");
                                    dlVarZ.clear();
                                    HashSet hashSet = new HashSet();
                                    for (Map.Entry entry : lq.kb.entrySet()) {
                                        hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                    }
                                    dlVarZ.put("cloud_path_check_res", hashSet);
                                    boolean unused2 = lq.wp = false;
                                }
                            }, 1800000L);
                        }
                    } catch (Throwable unused2) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return z(atomicInteger, strArr[0], str, webView, z2);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean z(java.util.concurrent.atomic.AtomicInteger r1, java.lang.String r2, java.lang.String r3, android.webkit.WebView r4, boolean r5) {
        /*
            r3 = 0
            if (r4 != 0) goto L4
            return r3
        L4:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto Lb
            return r3
        Lb:
            if (r1 != 0) goto Le
            return r3
        Le:
            int r5 = r1.get()
            r0 = 1
            if (r5 != r0) goto L16
            return r0
        L16:
            int r5 = r2.hashCode()
            switch(r5) {
                case -284840886: goto L3c;
                case 3181155: goto L32;
                case 93818879: goto L28;
                case 113101865: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L46
        L1e:
            java.lang.String r5 = "white"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L46
            r2 = 3
            goto L47
        L28:
            java.lang.String r5 = "black"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L46
            r2 = r3
            goto L47
        L32:
            java.lang.String r5 = "gray"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L46
            r2 = 2
            goto L47
        L3c:
            java.lang.String r5 = "unknown"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L46
            r2 = r0
            goto L47
        L46:
            r2 = -1
        L47:
            if (r2 == 0) goto L4a
            return r3
        L4a:
            r1.set(r0)
            android.content.Context r1 = r4.getContext()
            r2 = 0
            com.bytedance.sdk.openadsdk.core.un.m.z(r1, r2, r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.iq.lq.z(java.util.concurrent.atomic.AtomicInteger, java.lang.String, java.lang.String, android.webkit.WebView, boolean):boolean");
    }

    public static boolean z(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.mc mcVar, WebResourceRequest webResourceRequest, boolean z2, boolean z3) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return z(webView, atomicInteger, mcVar, url.toString(), z2, z3);
    }

    public static boolean z(final com.bytedance.sdk.openadsdk.core.mc mcVar, final int i, final String str) {
        final String strG = g(str, fo);
        boolean z2 = (uy && TextUtils.isEmpty(strG)) ? false : true;
        final boolean z3 = z2;
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z3));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(lq.uy));
                    jSONObject.putOpt("pattern", strG);
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.un.eo.kb(mcVar.gz()));
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_dialog_report_rule").gz(mcVar.gz().vk()).g(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g();
                }
            }
        }, "stats_dialog_report_rule");
        return z2;
    }

    private static String z(String str, int i, boolean z2, boolean z3) {
        boolean z4 = (!z3 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i == 1) {
            if (uy) {
                return g(str, m);
            }
            return null;
        }
        if (i == 2) {
            if (!uy) {
                if (z2) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z4) {
                return "local://short-internal";
            }
            String strG = g(str, gc);
            if (!TextUtils.isEmpty(strG)) {
                return strG;
            }
            String strG2 = g(str, m);
            if (TextUtils.isEmpty(strG2)) {
                return null;
            }
            return strG2;
        }
        if (i != 3) {
            return null;
        }
        if (z2 || !uy) {
            return "local://preload-setting:" + uy;
        }
        if (z4) {
            return "local://short-internal";
        }
        String strG3 = g(str, gc);
        if (!TextUtils.isEmpty(strG3)) {
            return strG3;
        }
        String strG4 = g(str, m);
        if (TextUtils.isEmpty(strG4)) {
            return null;
        }
        return strG4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("JumpModel", e2.getMessage());
            return null;
        }
    }

    public static void z(final na naVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", naVar.mk());
                jSONObject2.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mj());
                jSONObject2.put("req_id", naVar.aq());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.un.eo.kb(naVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_block_report").gz(naVar.vk()).g(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static void g(final na naVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.4
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", naVar.mk());
                jSONObject2.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mj());
                jSONObject2.put("req_id", naVar.aq());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.un.eo.kb(naVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_url_report_rule").gz(naVar.vk()).g(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static Set<String> z() {
        return gz;
    }

    public static com.bytedance.sdk.component.g.z.fo g() {
        return new com.bytedance.sdk.component.g.z.fo() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.5
            @Override // com.bytedance.sdk.component.g.z.fo
            public com.bytedance.sdk.component.g.z.ls z(fo.z zVar) throws IOException {
                String str;
                com.bytedance.sdk.component.g.z.ls lsVarZ = zVar.z(zVar.z());
                String str2 = "";
                final String strZ = lsVarZ.z("csj-location-record", "");
                final String strZ2 = lsVarZ.z("csj-source-from", "");
                final String strZ3 = lsVarZ.z("csj-extra-info", "");
                if (lsVarZ.dl() == 8848) {
                    final String strGc = lsVarZ.gc();
                    com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.5.1
                        @Override // com.bytedance.sdk.openadsdk.kb.z.z
                        public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", strGc);
                            jSONObject.putOpt("sourceFrom", strZ2);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strZ3);
                            return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_net_block_url").g(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i = 0;
                try {
                    String[] strArrZ = lq.z(strZ);
                    if (strArrZ == null || strArrZ.length <= 1) {
                        str = "";
                    } else {
                        String str3 = strArrZ[0];
                        try {
                            str = strArrZ[strArrZ.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i = Integer.parseInt(strZ2);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (TextUtils.isEmpty(strZ) || i == 0 || !TextUtils.isEmpty(lq.g(str4, lq.f1177a))) {
                    return lsVarZ;
                }
                com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.lq.5.2
                    @Override // com.bytedance.sdk.openadsdk.kb.z.z
                    public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("url", strZ);
                        jSONObject.putOpt("sourceFrom", strZ2);
                        jSONObject.putOpt("sourceUrl", str4);
                        jSONObject.putOpt("destUrl", str5);
                        jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strZ3);
                        return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_net_locations_url").g(jSONObject.toString());
                    }
                }, "stats_net_locations_url");
                return lsVarZ;
            }
        };
    }

    public static String[] z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
