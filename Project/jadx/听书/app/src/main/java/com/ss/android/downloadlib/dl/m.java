package com.ss.android.downloadlib.dl;

import android.content.Context;
import com.ss.android.downloadlib.addownload.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m implements com.ss.android.socialbase.appdownloader.dl.gc {
    private Context z;

    public m(Context context) {
        this.z = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public void z(Context context, String str) {
        com.ss.android.downloadlib.z.z().z(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public void z(int i, int i2, String str, int i3, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        com.ss.android.g.z.g.g gVarZ;
        Context context = this.z;
        if (context == null || (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(i)) == null || dlVarGz.p() == 0 || (gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVarGz)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.z.z(dlVarGz, gVarZ);
            if ("application/vnd.android.package-archive".equals(dlVarGz.yt())) {
                com.ss.android.downloadlib.addownload.z.z().z(dlVarGz, gVarZ.g(), gVarZ.wp(), gVarZ.gc(), dlVarGz.fo(), gVarZ.a(), dlVarGz.v());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.a.z.z().z("download_notification", "download_notification_install", com.ss.android.downloadlib.z.g(new JSONObject(), dlVarGz), gVarZ);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.a.z.z().z("download_notification", "download_notification_pause", gVarZ);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.a.z.z().z("download_notification", "download_notification_continue", gVarZ);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.a.z.z().z("download_notification", "download_notification_click", gVarZ);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public boolean z(int i, boolean z) {
        if (wp.pf() != null) {
            return wp.pf().z(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        com.ss.android.downloadlib.gz.z().z(dlVar);
        if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.a.z.z().z(dlVar, new com.ss.android.socialbase.downloader.gc.z(1012, ""));
        } else {
            com.ss.android.downloadlib.a.z.z().g(dlVar, new com.ss.android.socialbase.downloader.gc.z(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public void z(int i, int i2, String str, String str2, String str3) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        Context context = this.z;
        if (context == null || (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(i)) == null || dlVarGz.p() != -3) {
            return;
        }
        dlVarGz.e(str2);
        com.ss.android.downloadlib.addownload.g.z().z(this.z, dlVarGz);
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.gc
    public boolean z() {
        return com.ss.android.downloadlib.addownload.g.z().g();
    }
}
