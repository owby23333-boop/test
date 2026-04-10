package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class e {
    public static void z(String str, long j) {
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        if (gcVarGc.io()) {
            return;
        }
        gcVarGc.dl.z(str);
        com.ss.android.downloadlib.a.z.z().g("lp_app_dialog_click", gcVarGc);
    }

    public static void g(String str, long j) {
        z(str, null, j);
    }

    public static void z(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.a.z.z().g(str, jSONObject, com.ss.android.downloadlib.addownload.g.m.z().gc(j));
    }

    public static void z(String str, com.ss.android.downloadlib.addownload.g.gc gcVar) {
        com.ss.android.downloadlib.a.z.z().g(str, gcVar);
    }

    public static void z(int i, com.ss.android.downloadlib.addownload.g.gc gcVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().g("lp_compliance_error", jSONObject, gcVar);
    }

    public static void z(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().g("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.g.m.z().gc(j));
    }
}
