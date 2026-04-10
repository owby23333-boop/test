package com.ss.android.downloadlib.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.z.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private static Handler z = new Handler(Looper.getMainLooper());

    public static void z(final com.ss.android.g.z.g.g gVar, final gz gzVar) {
        boolean zG = com.ss.android.socialbase.downloader.z.z.z().g();
        if (!zG && Build.VERSION.SDK_INT >= 29) {
            i.dl();
        }
        boolean zG2 = com.ss.android.socialbase.downloader.z.z.z().g();
        boolean z2 = !zG && zG2;
        if (gVar != null) {
            gVar.wp(z2);
        }
        gzVar.z(z2);
        if (gVar == null) {
            return;
        }
        g(gVar, uy(gVar));
        if (zG2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.z.z.z().z(new z.InterfaceC0484z() { // from class: com.ss.android.downloadlib.g.m.1
            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void dl() {
            }

            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void g() {
                com.ss.android.socialbase.downloader.z.z.z().g(this);
                com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.g.m.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zDl = i.dl(gVar.gc());
                        long jGc = m.gc(gVar);
                        if (!zDl || jGc >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > m.gz(gVar)) {
                                com.ss.android.downloadlib.a.z.z().z("deeplink_delay_timeout", gVar);
                                return;
                            }
                            gVar.wp(true);
                            com.ss.android.downloadlib.a.z.z().z("deeplink_delay_invoke", gVar);
                            gzVar.z(true);
                            m.g(gVar, m.uy(gVar));
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final com.ss.android.g.z.g.g gVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.g.m.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (i.dl(gVar.gc())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!gVar.qd()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                    com.ss.android.downloadlib.a.z.z().z("deeplink_success_2", jSONObject, gVar);
                    return;
                }
                m.g(gVar, i - 1);
            }
        }, fo(gVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long gz(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).z("app_link_check_timeout", 300000L);
    }

    private static int fo(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).z("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int uy(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).z("app_link_check_count", 10);
    }

    public static boolean z(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).g("app_link_opt_switch") == 1;
    }

    public static boolean g(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).g("app_link_opt_install_switch") == 1;
    }

    public static boolean dl(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).g("app_link_opt_invoke_switch") == 1;
    }

    public static boolean a(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).g("app_link_opt_dialog_switch") == 1;
    }

    public static long gc(com.ss.android.g.z.g.g gVar) {
        return gVar == null ? C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS : com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).z("app_link_opt_back_time_limit", 3) * 1000;
    }
}
