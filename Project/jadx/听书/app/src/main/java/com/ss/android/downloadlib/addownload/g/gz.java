package com.ss.android.downloadlib.addownload.g;

import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gz {
    private static volatile gz z;

    private gz() {
    }

    public static gz z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new gz();
                }
            }
        }
        return z;
    }

    public void z(int i, int i2, com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(gVar.js());
        if (zVarZ.z("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= zVarZ.z("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().g("api_hijack", jSONObject, gVar);
    }
}
