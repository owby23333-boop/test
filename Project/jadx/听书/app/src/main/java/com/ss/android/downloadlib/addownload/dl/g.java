package com.ss.android.downloadlib.addownload.dl;

import com.ss.android.downloadlib.addownload.g.fo;
import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.downloader.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g implements Runnable {
    private com.ss.android.socialbase.downloader.e.dl z;

    public g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        this.z = dlVar;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.g.z.g.g gVarZ;
        if (this.z == null || (gVarZ = m.z().z(this.z)) == null) {
            return;
        }
        com.ss.android.downloadlib.a.z.z().z("cleanspace_task", gVarZ);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.e.gc.z(this.z.e()) + 1.0d) * this.z.s()).longValue() - this.z.sf();
        long jG = i.g(0L);
        if (wp.i() != null) {
            wp.i();
        }
        dl.z();
        dl.g();
        if (com.ss.android.downloadlib.e.gc.e(gVarZ.js())) {
            dl.z(wp.getContext());
        }
        long jG2 = i.g(0L);
        if (jG2 >= jLongValue) {
            gVarZ.wp("1");
            fo.z().z(gVarZ);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jG2 - jG));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            com.ss.android.downloadlib.a.z.z().z("cleanspace_download_after_quite_clean", jSONObject, gVarZ);
            e.g(wp.getContext()).gc(this.z.e());
            return;
        }
        if (wp.i() != null) {
            gVarZ.a(false);
            a.z().z(gVarZ.z(), new gc() { // from class: com.ss.android.downloadlib.addownload.dl.g.1
            });
            if (wp.i().z(this.z.e(), this.z.uy(), true, jLongValue)) {
                gVarZ.gc(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        com.ss.android.downloadlib.a.z.z().z("cleanspace_window_show", jSONObject2, gVarZ);
    }
}
