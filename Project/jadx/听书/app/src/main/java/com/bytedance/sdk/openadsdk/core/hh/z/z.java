package com.bytedance.sdk.openadsdk.core.hh.z;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.fo.g.gc;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends fo {
    private z() {
        super("PluginSettingsFetchTask");
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.hh.z.z$z, reason: collision with other inner class name */
    private static class C0175z {
        private static final z z = new z();
    }

    public static z z() {
        return C0175z.z;
    }

    public void g() {
        if (v.z(zw.getContext())) {
            e.g(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
        gcVarG.z(eo.gz("/api/ad/union/sdk/settings/plugins"));
        gcVarG.g("User-Agent", uy.i());
        gcVarG.z(com.bytedance.sdk.component.utils.z.z(dl()));
        gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.z.z.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar == null || !gVar.gz() || TextUtils.isEmpty(gVar.a())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(gVar.a());
                    if (jSONObject.optInt("cypher") == 3) {
                        String strDl = com.bytedance.sdk.component.utils.z.dl(jSONObject.optString("message"));
                        if (TextUtils.isEmpty(strDl)) {
                            return;
                        }
                        g.z().z(new JSONObject(strDl).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, IOException iOException) {
                try {
                    Iterator<String> itKeys = com.bytedance.sdk.openadsdk.core.uy.ls().lq().keys();
                    while (itKeys.hasNext()) {
                        g.z().z(itKeys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", uy.dl(false));
            jSONObject.put("conn_type", v.g(zw.getContext()));
            jSONObject.put(an.x, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put(an.o, eo.fo());
            jSONObject.put("app_version", eo.kb());
            jSONObject.put("app_code", eo.uy());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String strQ = com.bytedance.sdk.openadsdk.core.uy.ls().q();
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, strQ);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.gc.g(strQ != null ? strQ.concat(String.valueOf(jCurrentTimeMillis)).concat(gk.f1105a) : ""));
            jSONObject.put("channel", gk.e);
            jSONObject.put("applog_did", uy.p());
            jSONObject.put("imei", uy.gz());
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", a());
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.uy.ls().na() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectLq = com.bytedance.sdk.openadsdk.core.uy.ls().lq();
        boolean zVt = zw.g().vt();
        if (jSONObjectLq != null) {
            Iterator<String> itKeys = jSONObjectLq.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectLq.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.uy.ls().uf().z(next));
                    }
                    if (zVt && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(g.g(), jSONObjectOptJSONObject);
                    } else {
                        jSONObject.putOpt(next, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }
}
