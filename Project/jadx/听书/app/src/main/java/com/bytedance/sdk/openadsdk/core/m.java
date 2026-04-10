package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.bytedance.embedapplog.gc;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private AtomicBoolean dl;
    private String g;
    private volatile String z;

    private static final class z {
        static final m z = new m();
    }

    public String e() {
        return "unionser_slardar_applog";
    }

    public String m() {
        return "164362";
    }

    private m() {
        this.z = null;
        this.g = null;
        this.dl = new AtomicBoolean(false);
        z(zw.getContext());
    }

    private void z(Context context) {
        final com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        com.bytedance.embedapplog.gz gzVar = new com.bytedance.embedapplog.gz("164362", "unionser_slardar_applog");
        if (aVarP != null) {
            boolean zDl = aVarP.dl();
            gzVar.a(zDl);
            if (!zDl) {
                gzVar.g(aVarP.uy());
            }
            gzVar.dl(aVarP.a());
            if (gk.dl >= 4600) {
                gzVar.gc(aVarP.m());
                if (gk.e() && gk.dl >= 4900) {
                    gzVar.z(aVarP.v());
                }
            }
        }
        gzVar.m(!com.bytedance.sdk.openadsdk.core.a.z.dl());
        gzVar.z(new com.bytedance.embedapplog.e() { // from class: com.bytedance.sdk.openadsdk.core.m.1
            @Override // com.bytedance.embedapplog.e
            public String z() {
                com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = aVarP;
                if (aVar == null || aVar.a()) {
                    return com.bytedance.sdk.openadsdk.pf.g.z();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.e
            public String z(Context context2) {
                return com.bytedance.sdk.component.utils.p.g(context2);
            }

            @Override // com.bytedance.embedapplog.e
            public String g() {
                return com.bytedance.sdk.openadsdk.core.un.uy.g();
            }

            @Override // com.bytedance.embedapplog.e
            public boolean dl() {
                return zw.g().mc();
            }

            @Override // com.bytedance.embedapplog.e
            public boolean a() {
                return com.bytedance.sdk.openadsdk.core.un.ls.z();
            }

            @Override // com.bytedance.embedapplog.e
            public Looper gc() {
                return com.bytedance.sdk.component.utils.gz.z().getLooper();
            }

            @Override // com.bytedance.embedapplog.e
            public Looper m() {
                return com.bytedance.sdk.component.utils.gz.z().getLooper();
            }

            @Override // com.bytedance.embedapplog.e
            public String z(String str) {
                return com.bytedance.sdk.openadsdk.core.un.sy.g(str);
            }

            @Override // com.bytedance.embedapplog.e
            public JSONObject z(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray jSONArrayGz = com.bytedance.sdk.openadsdk.core.un.kb.gz();
                    try {
                        if (jSONArrayGz.length() != 0) {
                            jSONObject.put("ipv6_list", jSONArrayGz);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }

            @Override // com.bytedance.embedapplog.e
            public void z(String[] strArr, int[] iArr, boolean z2) {
                com.bytedance.sdk.openadsdk.core.eo.z.z().z(iArr);
            }
        });
        gzVar.g(zw.g().zw());
        gzVar.z(true);
        gzVar.g(0);
        gz();
        com.bytedance.embedapplog.z.z(context, gzVar);
        HashMap map = new HashMap();
        String strQ = uy.ls().q();
        map.put("host_appid", TextUtils.isEmpty(strQ) ? "164362" : strQ);
        map.put("is_plugin", Boolean.valueOf(gk.z()));
        map.put("sdk_version", "7.1.0.5");
        map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
        map.put("sdk_api_version", gk.f1105a);
        map.put("channel", gk.gc());
        if (zw.g().p()) {
            map.put("use_apm_sdk", "1");
        }
        com.bytedance.embedapplog.z.z((HashMap<String, Object>) map);
    }

    private void gz() {
        final boolean zGz = uy.ls().gz();
        boolean zFo = uy.ls().fo();
        com.bytedance.embedapplog.z.z(zGz && !zFo);
        final boolean zKb = uy.ls().kb();
        com.bytedance.embedapplog.z.z(new com.bytedance.embedapplog.gc() { // from class: com.bytedance.sdk.openadsdk.core.m.2
            @Override // com.bytedance.embedapplog.gc
            public void z(gc.z zVar) {
                if (zVar != null) {
                    com.bytedance.sdk.openadsdk.core.un.zw.z(zVar.z);
                }
                if (zKb || !zGz || m.this.dl.get()) {
                    return;
                }
                m.this.z(new com.bytedance.sdk.openadsdk.pf.a(zVar));
            }
        });
        if (zFo) {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.this.z(new com.bytedance.sdk.openadsdk.pf.a(com.bytedance.sdk.openadsdk.core.un.zw.dl(com.bytedance.sdk.openadsdk.core.un.uy.dl(false))));
                }
            });
        } else {
            if (zKb || !zGz) {
                return;
            }
            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.4
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.dl.get()) {
                        return;
                    }
                    m.this.z(new com.bytedance.sdk.openadsdk.pf.a("timeout"));
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.pf.a aVar) {
        this.dl.set(true);
        com.bytedance.sdk.openadsdk.core.un.zw.z(aVar);
    }

    public static m z() {
        return z.z;
    }

    public void g() {
        com.bytedance.embedapplog.z.z(uy.ls().gz());
        com.bytedance.embedapplog.z.z();
    }

    public String dl() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = com.bytedance.embedapplog.z.fo();
            com.bytedance.sdk.openadsdk.tools.g.dl(16, this.z);
            com.bytedance.sdk.openadsdk.core.dl.a.z().wp(this.z == null ? "" : this.z);
        }
        return this.z;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String a() {
        if (TextUtils.isEmpty(this.g)) {
            this.g = com.bytedance.embedapplog.z.kb();
        }
        return this.g;
    }

    public String gc() {
        return (String) com.bytedance.embedapplog.z.z("sdk_version_name", "");
    }

    public void z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.z.g(str, jSONObject);
    }

    public static void g(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.z.z(str, jSONObject);
    }
}
