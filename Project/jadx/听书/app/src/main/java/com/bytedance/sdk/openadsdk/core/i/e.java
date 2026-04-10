package com.bytedance.sdk.openadsdk.core.i;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eo;
import com.bytedance.sdk.openadsdk.core.i.gz;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile e z;

    public static e z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e();
                }
            }
        }
        return z;
    }

    private e() {
    }

    public void z(final na naVar, final String str, final boolean z2) {
        if (naVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new gz().z(new gz.z() { // from class: com.bytedance.sdk.openadsdk.core.i.e.1
            private boolean m = false;

            @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
            public void z() {
                z(false, "resume");
                if (!z2) {
                    g(str);
                }
                com.bytedance.sdk.openadsdk.core.g.z().put("dpl_reject_by_dialog", true);
                a.z(naVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
            }

            @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
            public void z(String str2) {
                z(false, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
            public void z(boolean z3) {
                this.m = z3;
                z(z3, "stop");
                if (!this.m && !z2) {
                    g(str);
                }
                com.bytedance.sdk.openadsdk.core.g.z().put("dpl_reject_by_dialog", false);
            }

            private void g(String str2) {
                na naVar2 = naVar;
                if (naVar2 == null || this.m) {
                    return;
                }
                boolean zIb = naVar2.ib();
                ls lsVarVy = naVar.vy();
                if (lsVarVy == null || lsVarVy.z()) {
                    return;
                }
                int iDl = lsVarVy.dl();
                if (zIb) {
                    return;
                }
                if (iDl == 1 || iDl == 2) {
                    eo.z(naVar, str2);
                }
            }

            private void z(final boolean z3, final String str2) {
                com.bytedance.sdk.component.uy.e.z(new com.bytedance.sdk.component.uy.fo("EventData") { // from class: com.bytedance.sdk.openadsdk.core.i.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z2) {
                            a.dl(naVar, str, z3 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z3 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean z4 = uy.ls().z();
                        map.put("has_focus", Boolean.valueOf(uy.ls().z(true)));
                        map.put("is_background", Boolean.valueOf(z4));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        a.gz(naVar, str, str3, map);
                        if (naVar != null) {
                            e.g(naVar, str);
                        }
                    }
                }, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(na naVar, String str) {
        if (naVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        dlVarZ.put("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObjectKv = naVar.kv();
        if (jSONObjectKv == null) {
            return;
        }
        dlVarZ.put("save_dpl_success_materialmeta", jSONObjectKv.toString());
        dlVarZ.put("save_jump_success_ad_tag", str);
    }
}
