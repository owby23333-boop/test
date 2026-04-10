package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.js;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class v implements js {
    @Override // com.ss.android.socialbase.downloader.downloader.js
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, int i, int i2) {
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("pause_reserve_wifi", jSONObject, gVarZ);
    }
}
