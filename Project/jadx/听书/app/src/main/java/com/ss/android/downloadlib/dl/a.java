package com.ss.android.downloadlib.dl;

import com.ss.android.downloadlib.addownload.g.fo;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.a.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a implements com.ss.android.socialbase.appdownloader.dl.gz, wp {
    @Override // com.ss.android.socialbase.appdownloader.dl.gz
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z) {
        if (dlVar == null) {
            return;
        }
        z(dlVar, dlVar.zw(), z);
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, int i, boolean z) {
        com.ss.android.downloadlib.addownload.g.m.z().g();
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        if (gVarZ == null) {
            return;
        }
        try {
            if (z) {
                gVarZ.dl(dlVar.to());
            } else if (gVarZ.gk() == -1) {
                return;
            } else {
                gVarZ.dl(-1);
            }
            fo.z().z(gVarZ);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", dlVar.e());
            jSONObject.put("name", dlVar.gz());
            jSONObject.put("url", dlVar.uy());
            jSONObject.put("download_time", dlVar.oz());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", dlVar.sf());
            jSONObject.put("total_bytes", dlVar.s());
            int i2 = 1;
            jSONObject.put("only_wifi", dlVar.io() ? 1 : 0);
            jSONObject.put("chunk_count", dlVar.ux());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", dlVar.to());
            com.ss.android.downloadlib.a.z.z().z("embeded_ad", "download_uncompleted", jSONObject, gVarZ);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.wp
    public void z() {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.dl.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.e.dl dlVarGz;
                int i;
                com.ss.android.downloadlib.addownload.g.m.z().g();
                for (com.ss.android.g.z.g.g gVar : com.ss.android.downloadlib.addownload.g.m.z().dl().values()) {
                    int iJs = gVar.js();
                    if (iJs != 0) {
                        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(iJs);
                        if (zVarZ.g("notification_opt_2") == 1 && (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.downloadlib.addownload.wp.getContext()).gz(iJs)) != null) {
                            if (i.g(gVar) && !i.dl(gVar.gc())) {
                                int i2 = dlVarGz.i("restart_notify_open_app_count");
                                if (i2 < zVarZ.z("noti_open_restart_times", 1)) {
                                    gz.z().gc(gVar);
                                    dlVarGz.z("restart_notify_open_app_count", String.valueOf(i2 + 1));
                                }
                            } else if (dlVarGz.zw() == -2) {
                                int i3 = dlVarGz.i("restart_notify_continue_count");
                                if (i3 < zVarZ.z("noti_continue_restart_times", 1)) {
                                    gz.z().z(gVar);
                                    dlVarGz.z("restart_notify_continue_count", String.valueOf(i3 + 1));
                                }
                            } else if (dlVarGz.zw() == -3 && com.ss.android.socialbase.downloader.pf.m.dl(dlVarGz) && !i.g(gVar) && (i = dlVarGz.i("restart_notify_install_count")) < zVarZ.z("noti_install_restart_times", 1)) {
                                gz.z().dl(gVar);
                                dlVarGz.z("restart_notify_install_count", String.valueOf(i + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
