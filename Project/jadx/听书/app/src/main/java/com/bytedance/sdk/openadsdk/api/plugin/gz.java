package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.comm.pi.ACTD;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class gz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f899a = m.g();
    private String dl;
    private String g;
    private final Context z;

    gz(Context context) {
        this.z = context;
    }

    public void z() {
        if (com.bytedance.sdk.openadsdk.api.plugin.dl.gc.z(this.z)) {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        gc.z("plugin_download", "start run");
        String strZ = com.bytedance.sdk.openadsdk.api.plugin.g.dl.z().z(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.bytedance.sdk.openadsdk.api.plugin.dl.g.z(g()).toString().getBytes());
        if (strZ == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strZ);
            if (jSONObject.optInt("cypher") == 3) {
                String strG = com.bytedance.sdk.openadsdk.api.plugin.dl.g.g(jSONObject.optString("message"));
                if (TextUtils.isEmpty(strG)) {
                    return;
                }
                dl.z(this.z).z(z(new JSONObject(strG).optJSONArray("plugins")));
            }
        } catch (JSONException e) {
            gc.z("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.bytedance.sdk.openadsdk.api.plugin.dl.gc.g(this.z));
            jSONObject.put(an.x, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.1.0.5");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put("app_version", a());
            jSONObject.put(an.o, this.dl);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.f899a.get(ACTD.APPID_KEY);
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.api.plugin.dl.a.z(str != null ? str.concat(String.valueOf(jCurrentTimeMillis)).concat("7.1.0.5") : ""));
            jSONObject.put("channel", "main");
            jSONObject.put("imei", this.f899a.get("imei"));
            jSONObject.put("source", 0);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", dl());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject dl() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PluginConstants.KEY_APP_ID, this.f899a.get(ACTD.APPID_KEY));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
        jSONObject2.put("sdk_version", "7.1.0.5");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    private String a() {
        Context context;
        if (TextUtils.isEmpty(this.g) && (context = this.z) != null) {
            try {
                this.dl = context.getPackageName();
                this.g = this.z.getPackageManager().getPackageInfo(this.dl, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.g;
    }

    private List<z> z(JSONArray jSONArray) {
        gc.z("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                z zVar = new z();
                zVar.z = jSONObjectOptJSONObject.optString(an.o);
                zVar.g = jSONObjectOptJSONObject.optInt("version_code");
                zVar.dl = jSONObjectOptJSONObject.optString("download_url");
                zVar.f900a = jSONObjectOptJSONObject.optString("sign");
                zVar.m = z(jSONObjectOptJSONObject.optString("min_version"));
                zVar.e = z(jSONObjectOptJSONObject.optString("max_version"));
                zVar.gz = jSONObjectOptJSONObject.optInt("plugin_update_network");
                arrayList.add(zVar);
                gc.z("plugin_download", "parse " + i + " : " + zVar);
            }
        }
        return arrayList;
    }

    private int z(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(FileUtils.FILE_EXTENSION_SEPARATOR, ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }

    static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f900a;
        public String dl;
        public int e;
        public String fo;
        public int g;
        public String gc;
        public int gz;
        public int m;
        public boolean uy;
        public String z;

        z() {
        }

        public String toString() {
            try {
                return new JSONObject().put(an.o, this.z).put("version_code", this.g).put("sign", this.f900a).put("max_version", this.e).put("min_version", this.m).put("is_revert", this.uy).put(TKDownloadReason.KSAD_TK_MD5, this.gc).put("plugin_file", this.fo).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }
}
