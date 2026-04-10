package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.downloader.e;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        g(dlVar);
    }

    private static void g(final com.ss.android.socialbase.downloader.e.dl dlVar) {
        final Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        boolean z = true;
        if (((dlVar.q() && !dlVar.iq()) || com.ss.android.socialbase.appdownloader.dl.g(dlVar.gk()) || TextUtils.isEmpty(dlVar.yt()) || !dlVar.yt().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iZ = z ? com.ss.android.socialbase.appdownloader.dl.z(contextXl, dlVar.e(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.m.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = com.ss.android.socialbase.appdownloader.a.kb().dl();
                gk gkVarFo = e.g(contextXl).fo(dlVar.e());
                if (gcVarDl == null && gkVarFo == null) {
                    return;
                }
                File file = new File(dlVar.kb(), dlVar.gz());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoZ = com.ss.android.socialbase.appdownloader.dl.z(dlVar, file);
                        if (packageInfoZ != null) {
                            String strX = (iZ == 1 || TextUtils.isEmpty(dlVar.x())) ? packageInfoZ.packageName : dlVar.x();
                            if (gcVarDl != null) {
                                gcVarDl.z(dlVar.e(), 1, strX, -3, dlVar.oz());
                            }
                            if (gkVarFo != null) {
                                gkVarFo.z(1, dlVar, strX, "");
                            }
                        }
                    } catch (Exception e) {
                        wp.z(e);
                    }
                }
            }
        });
    }
}
