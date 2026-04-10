package com.bytedance.sdk.openadsdk.core.gk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.na;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends com.bytedance.sdk.component.uy.fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gz f1110a;
    private static final AtomicLong dl = new AtomicLong(0);
    private static boolean gc = true;
    private static volatile boolean m = false;
    private volatile Runnable e;
    private final Context g;
    private final gc z;

    public static gz z(gc gcVar) {
        if (f1110a == null) {
            synchronized (gz.class) {
                if (f1110a == null) {
                    f1110a = new gz(gcVar);
                }
            }
        }
        return f1110a;
    }

    public static void z() {
        try {
            x.z("tt_sdk_settings_other").clear();
            x.z("tt_sdk_settings_other_bst").clear();
            x.z("tt_sdk_settings_slot").clear();
            x.z("tt_sdk_settings_slot_bst").clear();
            x.z("tt_sdk_settings_slot_splash").clear();
            x.z("tt_sdk_settings_slot_splash_bst").clear();
        } catch (Throwable unused) {
        }
    }

    private gz(gc gcVar) {
        super("SdkSettingsHelper");
        this.z = gcVar == null ? zw.g() : gcVar;
        Context context = zw.getContext();
        this.g = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            try {
                context.registerReceiver(new z(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), eo.sy(), com.bytedance.sdk.component.utils.gz.z());
            } catch (Throwable unused) {
            }
        }
    }

    private class z extends BroadcastReceiver {
        private z() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            wp.z("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    gz.dl.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (gz.this.z != null) {
                        gz.this.z.z();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void g() {
        if (zw.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eo.fo());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                zw.getContext().sendBroadcast(intent, eo.fo() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public static void z(long j) {
        if (j > 0 && zw.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eo.fo());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                zw.getContext().sendBroadcast(intent, eo.sy());
            } catch (Throwable unused) {
            }
        }
    }

    public void dl() {
        z(false);
    }

    public void z(boolean z2) {
        try {
            if (gz()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z2) {
                if (jCurrentTimeMillis - dl.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                    return;
                }
                g(jCurrentTimeMillis);
            } else {
                if (this.e != null) {
                    wp.g("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j = (dl.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.e = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gk.gz.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gz.this.e = null;
                            gz.this.g(System.currentTimeMillis());
                        }
                    };
                    com.bytedance.sdk.component.utils.gz.z().postDelayed(this.e, j);
                } else {
                    this.e = null;
                    g(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        dl.set(j);
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            z(j);
        }
        com.bytedance.sdk.component.uy.e.z(this, 10);
    }

    private boolean gz() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.uy.ls().q());
    }

    public static boolean a() {
        return m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!v.z(this.g)) {
            try {
                this.z.z();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (gz()) {
            return;
        }
        if (!fo.z() || q.z) {
            JSONObject jSONObjectGc = gc();
            na naVar = new na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
            naVar.z(com.bytedance.sdk.openadsdk.e.dl.z(naVar, eo.gz("/api/ad/union/sdk/settings/")));
            naVar.g("User-Agent", com.bytedance.sdk.openadsdk.core.un.uy.i());
            naVar.g(jSONObjectGc, "settings");
            com.bytedance.sdk.openadsdk.e.dl.z(jSONObjectGc, 1);
            naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.gk.gz.2
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar == null || !gVar.gz()) {
                        try {
                            gz.this.z.z();
                            zw.g().fv();
                        } catch (Throwable unused2) {
                        }
                        q.g();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.bytedance.sdk.openadsdk.core.dl.m.z(gVar, "settings", false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!gz.this.z(jSONObject)) {
                                    wp.g("SdkSettingsHelper", "can not update settings");
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            if (gk.m) {
                                gz.this.z.z(jSONObject);
                            }
                            new com.bytedance.sdk.openadsdk.core.a.g("check_and_update_pl").z(5).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gk.gz.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray jSONArrayOptJSONArray;
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        com.bytedance.sdk.openadsdk.core.hh.z.g.z().z(jSONArrayOptJSONArray2);
                                    }
                                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.core.hh.z.g.z().z(jSONArrayOptJSONArray);
                                }
                            });
                            try {
                                gz.this.z.g(jSONObject);
                                q.z();
                                if (!gz.m) {
                                    boolean unused4 = gz.m = true;
                                }
                                com.bytedance.sdk.openadsdk.core.uy.ls().uf().gc();
                                com.bytedance.sdk.openadsdk.core.x.z.g();
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.core.q.v.z().z("setting_saveData_failed", gz.this.z(th), th);
                            }
                            com.bytedance.sdk.openadsdk.core.q.v.z().g();
                            if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
                                gz.g();
                            }
                            com.bytedance.sdk.openadsdk.e.dl.g(jSONObject, 1);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.core.q.v.z().z("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        com.bytedance.sdk.openadsdk.core.q.v.z().z("setting_parse", th3);
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    try {
                        Iterator<String> itKeys = com.bytedance.sdk.openadsdk.core.uy.ls().lq().keys();
                        while (itKeys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.hh.z.g.z().z(itKeys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        gz.this.z.z();
                        zw.g().fv();
                    } catch (Throwable unused3) {
                    }
                    q.g();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                fo.z(iOptInt);
                wp.z("SdkSettingsHelper", "sdk status: ".concat(String.valueOf(iOptInt)));
                return iOptInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public JSONObject gc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.un.uy.v());
            jSONObject.put("ipv6", com.bytedance.sdk.openadsdk.core.un.uy.pf());
            jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.un.uy.dl(false));
            jSONObject.put("oaid_source", com.bytedance.sdk.openadsdk.core.un.zw.z());
            jSONObject.put("model", com.bytedance.sdk.openadsdk.core.un.uy.g());
            jSONObject.put("conn_type", v.g(this.g));
            jSONObject.put(an.x, 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.y, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put("is_plugin", gk.z());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.a.z.a());
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.kb.fo.a());
            jSONObject.put(an.o, eo.fo());
            jSONObject.put("position", eo.a() ? 1 : 2);
            jSONObject.put("app_version", eo.kb());
            jSONObject.put("app_code", eo.uy());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.uy.ls().q());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.gc.g(com.bytedance.sdk.openadsdk.core.uy.ls().q() != null ? com.bytedance.sdk.openadsdk.core.uy.ls().q().concat(String.valueOf(jCurrentTimeMillis)).concat(gk.f1105a) : ""));
            wp.z("isApplicationForeground", "app_version:" + eo.kb() + "，vendor:" + Build.MANUFACTURER);
            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.un.uy.dl());
            jSONObject.put("channel", gk.e);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.un.uy.p());
            jSONObject.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.uy.ls().m());
            com.bytedance.sdk.openadsdk.pf.g.z(this.g, jSONObject);
            com.bytedance.sdk.openadsdk.pf.g.g(this.g, jSONObject);
            jSONObject.put("system_app", gk.dl());
            if (gk.z()) {
                jSONObject.put("plugins", fo());
            }
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.un.uy.gz());
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            String strSv = com.bytedance.sdk.openadsdk.core.uy.ls().sv();
            if (!TextUtils.isEmpty(strSv)) {
                jSONObject.put("rit_list", strSv);
            }
            long jNa = zw.g().na();
            if (jNa > 0) {
                jSONObject.put("data_time", jNa);
            }
            JSONObject jSONObjectWj = zw.g().wj();
            if (jSONObjectWj != null) {
                jSONObject.put("digest", jSONObjectWj);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.sy.z.z().z("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.uy.ls().na() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    private static JSONObject fo() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectLq = com.bytedance.sdk.openadsdk.core.uy.ls().lq();
        if (jSONObjectLq == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectLq.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectLq.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.uy.ls().uf().z(next));
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
        return jSONObjectLq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject z(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            i++;
            if (stackTraceElement != null) {
                try {
                    jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
