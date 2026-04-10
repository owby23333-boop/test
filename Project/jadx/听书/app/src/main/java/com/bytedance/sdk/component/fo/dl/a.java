package com.bytedance.sdk.component.fo.dl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f705a = new Object();
    private boolean dl;
    private dl g = new dl();
    private int gc;
    private Context z;

    public a(Context context, boolean z, int i) {
        this.z = context;
        this.dl = z;
        this.gc = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(org.json.JSONObject r10) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.fo.dl.a.z(org.json.JSONObject):void");
    }

    public void z() {
        if (this.dl) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.z, e.z().z(this.gc).z(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                dl dlVarG = g(new JSONObject(string));
                if (dlVarG != null) {
                    this.g = dlVarG;
                }
                com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfig: " + (dlVarG == null ? "null" : dlVarG.toString()));
            } catch (Throwable th) {
                wp.z(th);
                com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void g() {
        try {
            String strZ = com.bytedance.sdk.component.fo.a.a.z(this.z, 1, this.gc);
            if (TextUtils.isEmpty(strZ)) {
                com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            dl dlVarG = g(new JSONObject(strZ));
            com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfigForOtherProcess, config: " + (dlVarG == null ? "null" : dlVarG.toString()));
            if (dlVarG != null) {
                this.g = dlVarG;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.fo.a.dl.g("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public dl dl() {
        return this.g;
    }

    private dl g(JSONObject jSONObject) {
        try {
            dl dlVar = new dl();
            if (jSONObject.has("local_enable")) {
                dlVar.z = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dlVar.g = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                dlVar.dl = map;
            } else {
                dlVar.dl = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                dlVar.f706a = map2;
            } else {
                dlVar.f706a = null;
            }
            dlVar.gc = jSONObject.optInt("req_to_cnt", dlVar.gc);
            dlVar.m = jSONObject.optInt("req_to_api_cnt", dlVar.m);
            dlVar.e = jSONObject.optInt("req_to_ip_cnt", dlVar.e);
            dlVar.gz = jSONObject.optInt("req_err_cnt", dlVar.gz);
            dlVar.fo = jSONObject.optInt("req_err_api_cnt", dlVar.fo);
            dlVar.uy = jSONObject.optInt("req_err_ip_cnt", dlVar.uy);
            dlVar.kb = jSONObject.optInt("update_interval", dlVar.kb);
            dlVar.wp = jSONObject.optInt("update_random_range", dlVar.wp);
            dlVar.i = jSONObject.optString("http_code_black", dlVar.i);
            return dlVar;
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }
}
