package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.impls.fv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class pf {
    private static com.ss.android.downloadlib.addownload.z.dl g;
    private static com.ss.android.downloadlib.addownload.z.a z;

    public static boolean z(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.z.a z() {
        return z;
    }

    public static void z(com.ss.android.downloadlib.addownload.z.a aVar) {
        z = aVar;
    }

    public static com.ss.android.downloadlib.addownload.z.dl g() {
        return g;
    }

    public static void z(com.ss.android.downloadlib.addownload.z.dl dlVar) {
        g = dlVar;
    }

    public static boolean z(final com.ss.android.g.z.g.g gVar, com.ss.android.socialbase.downloader.e.dl dlVar, int i, final com.ss.android.downloadlib.addownload.a.gz gzVar, final boolean z2, final com.ss.android.downloadlib.addownload.z.dl dlVar2) {
        boolean zG;
        if (gVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("tryReverseWifi nativeModel null");
            return false;
        }
        if (dlVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("tryReverseWifi info null");
            return false;
        }
        final int iE = dlVar.e();
        if (z2) {
            zG = com.ss.android.downloadlib.e.gc.dl((com.ss.android.g.z.g.z) gVar);
        } else {
            zG = com.ss.android.downloadlib.e.gc.g((com.ss.android.g.z.g.z) gVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zG ? 1 : 0));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (z2) {
            com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_switch_status", jSONObject, gVar);
        } else {
            com.ss.android.downloadlib.a.z.z().z("pause_reserve_wifi_switch_status", jSONObject, gVar);
        }
        if (!zG || !z(i) || com.ss.android.socialbase.downloader.pf.m.g(wp.getContext())) {
            return false;
        }
        if (!z2 && dlVar.sv()) {
            return false;
        }
        z(new com.ss.android.downloadlib.addownload.z.a() { // from class: com.ss.android.downloadlib.addownload.pf.1
            @Override // com.ss.android.downloadlib.addownload.z.a
            public void z() {
                pf.z((com.ss.android.downloadlib.addownload.z.a) null);
                com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iE);
                if (dlVarGz != null) {
                    dlVarGz.yx();
                    fv.z().z(dlVarGz);
                    if (z2) {
                        com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_confirm", gVar);
                    } else {
                        com.ss.android.downloadlib.a.z.z().g("pause_reserve_wifi_confirm", gVar);
                    }
                }
                gzVar.z(gVar);
            }

            @Override // com.ss.android.downloadlib.addownload.z.a
            public void g() {
                pf.z((com.ss.android.downloadlib.addownload.z.a) null);
                com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iE);
                if (dlVarGz != null) {
                    dlVarGz.qd();
                }
                if (z2) {
                    com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_cancel", gVar);
                } else {
                    com.ss.android.downloadlib.a.z.z().g("pause_reserve_wifi_cancel", gVar);
                }
                gzVar.z(gVar);
            }
        });
        if (z2 && dlVar2 != null) {
            z(new com.ss.android.downloadlib.addownload.z.dl() { // from class: com.ss.android.downloadlib.addownload.pf.2
                @Override // com.ss.android.downloadlib.addownload.z.dl
                public void delete() {
                    com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_delete", gVar);
                    dlVar2.delete();
                }
            });
        }
        if (z2) {
            TTDelegateActivity.z(gVar, "删除");
        } else {
            TTDelegateActivity.g(gVar);
        }
        return true;
    }
}
