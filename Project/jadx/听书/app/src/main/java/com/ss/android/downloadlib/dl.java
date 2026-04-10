package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.e.kb;
import com.ss.android.socialbase.downloader.z.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements com.ss.android.socialbase.appdownloader.dl.fo {
    private static String z = "dl";
    private Handler g = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.dl.fo
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
        com.ss.android.socialbase.downloader.gc.z zVar2;
        final com.ss.android.z.z.dl.dl dlVarZ;
        if (dlVar == null) {
            return;
        }
        if (i == -1 && zVar != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.e.m.dl(dlVar, jSONObject);
            z.z(jSONObject, dlVar);
            kb.z("download_failed", jSONObject.toString());
        }
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        if (gVarZ == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    z.z(dlVar, gVarZ);
                    return;
                }
                if (i == 2001) {
                    z.z().z(dlVar, gVarZ, 2001);
                    return;
                } else {
                    if (i == 11) {
                        z.z().z(dlVar, gVarZ, 2000);
                        if (gVarZ.y()) {
                            return;
                        }
                        z(dlVar, gVarZ);
                        return;
                    }
                    return;
                }
            }
            if (zVar != null) {
                if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("toast_without_network", 0) == 1 && zVar.z() == 1049) {
                    this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.dl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wp.dl().z(5, wp.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.pf.m.gz(zVar)) {
                    if (wp.i() != null) {
                        wp.i();
                    }
                    com.ss.android.downloadlib.a.z.z().z("download_failed_for_space", gVarZ);
                    if (!gVarZ.t()) {
                        com.ss.android.downloadlib.a.z.z().z("download_can_restart", gVarZ);
                        z(dlVar);
                    }
                    if ((wp.i() == null || !wp.i().dl()) && (dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(gVarZ.g())) != null && dlVarZ.kb()) {
                        final com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
                        if (zVarZ.z("show_no_enough_space_toast", 0) == 1) {
                            this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.dl.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    wp.dl().z(2, wp.getContext(), dlVarZ, zVarZ.z("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                zVar2 = new com.ss.android.socialbase.downloader.gc.z(zVar.z(), i.z(zVar.getMessage(), wp.fo().optInt("exception_msg_length", 500)));
            } else {
                zVar2 = null;
            }
            com.ss.android.downloadlib.a.z.z().g(dlVar, zVar2);
            gz.z().z(dlVar, zVar, "");
        } catch (Exception e) {
            wp.tb().z(e, "onAppDownloadMonitorSend");
        }
    }

    private void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.g.z.g.g gVar) {
        final long jZ = i.z(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, i.z(Environment.getDataDirectory()) / 10);
        final long jS = dlVar.s();
        final double d = (jS * 2.5d) + jMin;
        if (jZ > -1 && jS > -1) {
            double d2 = jZ;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.a.g()) {
                com.ss.android.downloadlib.addownload.a.z(dlVar.e());
            }
        }
        com.ss.android.socialbase.downloader.z.z.z().z(new z.InterfaceC0484z() { // from class: com.ss.android.downloadlib.dl.3
            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void dl() {
            }

            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void g() {
                if (!i.g(gVar)) {
                    long j = jZ;
                    if (j <= -1 || jS <= -1 || j >= d) {
                        return;
                    }
                    com.ss.android.downloadlib.a.z.z().z("clean_space_install", com.ss.android.downloadlib.addownload.a.z("install_no_enough_space"), gVar);
                    if (com.ss.android.downloadlib.addownload.a.z(dlVar, ((long) d) - jZ)) {
                        com.ss.android.socialbase.downloader.z.z.z().g(this);
                        gVar.e(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.z.z.z().g(this);
            }
        });
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (com.ss.android.downloadlib.e.gc.m(dlVar.e())) {
            gc.z().g(new com.ss.android.downloadlib.addownload.dl.g(dlVar));
        }
    }
}
