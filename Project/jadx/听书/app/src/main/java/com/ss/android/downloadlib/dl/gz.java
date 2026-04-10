package com.ss.android.downloadlib.dl;

import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gz {

    private static class z {
        private static gz z = new gz();
    }

    public static gz z() {
        return z.z;
    }

    private gz() {
    }

    public void z(com.ss.android.g.z.g.g gVar) {
        g(gVar, 5L);
    }

    public void g(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return;
        }
        g(gVar, com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("noti_continue_delay_secs", 5));
    }

    private void g(final com.ss.android.g.z.g.g gVar, long j) {
        final int iJs = gVar.js();
        if (com.ss.android.socialbase.downloader.i.z.z(iJs).g("notification_opt_2") != 1) {
            return;
        }
        z(iJs);
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.dl.gz.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iJs);
                JSONObject jSONObject = new JSONObject();
                i.z(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.e.m.dl(dlVarGz, jSONObject);
                if (dlVarGz != null && -2 == dlVarGz.zw() && !dlVarGz.jq()) {
                    gz.this.z(iJs, gVar, jSONObject);
                } else {
                    i.z(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.a.z.z().g("download_notification_try_show", jSONObject, gVar);
            }
        }, j * 1000);
    }

    public void dl(com.ss.android.g.z.g.g gVar) {
        dl(gVar, 5L);
    }

    public void a(com.ss.android.g.z.g.g gVar) {
        dl(gVar, com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("noti_install_delay_secs", 5));
    }

    private void dl(final com.ss.android.g.z.g.g gVar, long j) {
        final int iJs = gVar.js();
        if (com.ss.android.socialbase.downloader.i.z.z(iJs).g("notification_opt_2") != 1) {
            return;
        }
        z(iJs);
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.dl.gz.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iJs);
                JSONObject jSONObject = new JSONObject();
                i.z(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.e.m.dl(dlVarGz, jSONObject);
                if (!i.g(gVar)) {
                    gz.this.z(iJs, gVar, jSONObject);
                } else {
                    i.z(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.a.z.z().g("download_notification_try_show", jSONObject, gVar);
            }
        }, j * 1000);
    }

    public void gc(com.ss.android.g.z.g.g gVar) {
        z(gVar, 5L);
    }

    public void m(com.ss.android.g.z.g.g gVar) {
        z(gVar, com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("noti_open_delay_secs", 5));
    }

    public void z(final com.ss.android.g.z.g.g gVar, long j) {
        final int iJs = gVar.js();
        if (com.ss.android.socialbase.downloader.i.z.z(iJs).g("notification_opt_2") != 1) {
            return;
        }
        z(iJs);
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.dl.gz.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iJs);
                JSONObject jSONObject = new JSONObject();
                i.z(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.e.m.dl(dlVarGz, jSONObject);
                if (!i.dl(gVar.gc())) {
                    gz.this.z(iJs, gVar, jSONObject);
                } else {
                    i.z(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.a.z.z().g("download_notification_try_show", jSONObject, gVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, com.ss.android.g.z.g.g gVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.gc.a.z()) {
            i.z(jSONObject, "error_code", (Object) 1004);
            return;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(i);
        if (dlVarGz == null) {
            i.z(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.g.z().gc(i) != null) {
            com.ss.android.socialbase.downloader.notification.g.z().m(i);
        }
        com.ss.android.socialbase.appdownloader.gc.z zVar = new com.ss.android.socialbase.appdownloader.gc.z(wp.getContext(), i, dlVarGz.fo(), dlVarGz.kb(), dlVarGz.gz(), dlVarGz.gk());
        zVar.z(dlVarGz.sf());
        zVar.g(dlVarGz.s());
        zVar.z(dlVarGz.p(), null, false, false);
        com.ss.android.socialbase.downloader.notification.g.z().z(zVar);
        zVar.z((com.ss.android.socialbase.downloader.gc.z) null, false);
        com.ss.android.downloadlib.a.z.z().g("download_notification_show", jSONObject, gVar);
    }

    public void z(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        if (com.ss.android.socialbase.appdownloader.gc.dl.z().z(i) != null || (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.gc.dl.z().z(i, dlVarGz.zb());
    }
}
