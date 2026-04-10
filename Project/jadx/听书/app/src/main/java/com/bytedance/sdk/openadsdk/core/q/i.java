package com.bytedance.sdk.openadsdk.core.q;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class i implements com.bytedance.sdk.openadsdk.core.q.dl.z {
    public static final i z = new i();

    private i() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.q.dl.z
    public void z(final com.bytedance.sdk.openadsdk.kb.z.z zVar, final String str, final boolean z2) {
        com.bytedance.sdk.openadsdk.hh.e.g(new com.bytedance.sdk.component.uy.fo("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.q.i.1
            @Override // java.lang.Runnable
            public void run() {
                if (gc.z(str, 1.0d) || !z2) {
                    i.this.z(zVar, z2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.kb.z.z zVar, boolean z2) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObjectZ = zVar.z().z();
            if (jSONObjectZ != null) {
                String strOptString = jSONObjectZ.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(strOptString);
                }
                int iIncrementAndGet = g.g.incrementAndGet();
                jSONObject.put("stats_index", iIncrementAndGet);
                jSONObject.put("sdk_session_id", g.z);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.uy.ls().na() ? 1 : 0);
                if (!TextUtils.isEmpty(eo.fo)) {
                    jSONObject.put("wrong_stats_url", eo.fo);
                }
                if (!TextUtils.isEmpty(eo.uy)) {
                    jSONObject.put("wrong_applog_url", eo.uy);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.sy.z.z().z("DeviceRate", "bytebench_value")));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.bytedance.sdk.openadsdk.core.uy.ls().qd());
                } catch (Exception unused2) {
                }
                if (com.bytedance.sdk.openadsdk.core.uy.ls().e()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                jSONObjectZ.put("event_extra", jSONObject.toString());
                com.bytedance.sdk.component.gz.g.a.z.z zVar2 = new com.bytedance.sdk.component.gz.g.a.z.z(UUID.randomUUID().toString(), jSONObjectZ);
                zVar2.dl((byte) 0);
                zVar2.g((byte) 3);
                zVar2.z((byte) 1);
                g.z(zVar2, jSONObjectZ.optString("type"), iIncrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
