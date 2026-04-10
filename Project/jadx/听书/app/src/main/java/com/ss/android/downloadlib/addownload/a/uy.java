package com.ss.android.downloadlib.addownload.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class uy implements fo {
    @Override // com.ss.android.downloadlib.addownload.a.fo
    public boolean z(com.ss.android.g.z.g.g gVar, int i, gz gzVar) {
        if (gVar == null || !g(gVar.js())) {
            return false;
        }
        if (System.currentTimeMillis() - gVar.ec() > z(gVar.js())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("pause_optimise", jSONObject, gVar);
        return true;
    }

    private long z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_mistake_click_interval", 300);
    }

    private boolean g(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
