package com.ss.android.downloadlib.dl;

import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements com.ss.android.socialbase.downloader.gz.dl {
    @Override // com.ss.android.socialbase.downloader.gz.dl
    public void z(int i, String str, JSONObject jSONObject) {
        com.ss.android.g.z.g.g gVarZ;
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(i);
        if (dlVarGz == null || (gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVarGz)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = i.z(jSONObject);
            com.ss.android.downloadlib.z.z(jSONObject, dlVarGz);
            i.z(jSONObject, "model_id", Long.valueOf(gVarZ.g()));
        }
        com.ss.android.downloadlib.a.z.z().g(str, jSONObject, gVarZ);
    }

    @Override // com.ss.android.socialbase.downloader.gz.dl
    public void g(int i, String str, JSONObject jSONObject) {
        com.ss.android.g.z.g.g gVarZ;
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(i);
        if (dlVarGz == null || (gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVarGz)) == null) {
            return;
        }
        com.ss.android.downloadlib.a.z.z().z(str, jSONObject, gVarZ);
    }
}
