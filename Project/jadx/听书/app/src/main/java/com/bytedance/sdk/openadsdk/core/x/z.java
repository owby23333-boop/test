package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.component.uy.z.g;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static boolean g = false;
    public static volatile boolean z = true;

    public static void z() {
        if (g) {
            return;
        }
        g = true;
        kb kbVar = kb.g;
        kbVar.z(11);
        kbVar.a(gk.z());
        kbVar.dl(true);
        kbVar.z(true);
        kbVar.g(true);
        kbVar.z(new g() { // from class: com.bytedance.sdk.openadsdk.core.x.z.1
            @Override // com.bytedance.sdk.component.uy.z.g
            public String z(String str) {
                return str != null ? str.startsWith("csj") ? str : "csj_".concat(String.valueOf(str)) : "csj_uk";
            }
        });
    }

    public static void g() {
        JSONObject jSONObjectQd = zw.g().qd();
        if (jSONObjectQd == null) {
            return;
        }
        kb kbVar = kb.g;
        int iOptInt = jSONObjectQd.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            kbVar.a(iOptInt);
        }
        int iOptInt2 = jSONObjectQd.optInt("core_count", 0);
        if (iOptInt2 > 0) {
            kbVar.dl(iOptInt2);
        }
        int iOptInt3 = jSONObjectQd.optInt("big_keep_alive", 0);
        if (iOptInt3 > 0) {
            kbVar.z(iOptInt3);
        }
        kbVar.gc(jSONObjectQd.optBoolean("big_priority", false));
        kbVar.dl(jSONObjectQd.optBoolean("catch_oom", true));
        kbVar.g(jSONObjectQd.optBoolean("forbid_autosize_oom", true));
        kbVar.m(jSONObjectQd.optBoolean("enable_proxy", true));
        z = jSONObjectQd.optBoolean("can_set_crash", true);
        e.z(jSONObjectQd.optBoolean("autosize", true));
        kbVar.fo(jSONObjectQd.optBoolean("report_task", false));
        kbVar.g(jSONObjectQd.optInt("wait_in_big", 50));
        kbVar.dl(jSONObjectQd.optInt("wait_in_little", 2000));
        kbVar.a(jSONObjectQd.optInt("run_cost", 6000));
    }
}
