package com.ss.android.downloadlib.g;

import android.os.Build;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.downloader.z.z;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    public static void z(final com.ss.android.g.z.g.g gVar, final com.ss.android.downloadlib.guide.install.z zVar) {
        boolean zG = com.ss.android.socialbase.downloader.z.z.z().g();
        if (!zG && Build.VERSION.SDK_INT >= 29) {
            i.dl();
        }
        boolean zG2 = com.ss.android.socialbase.downloader.z.z.z().g();
        if (!zG && zG2 && gVar != null) {
            gVar.wp(true);
        }
        zVar.z();
        com.ss.android.socialbase.downloader.m.z.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zG2)));
        if (zG2) {
            return;
        }
        com.ss.android.socialbase.downloader.z.z.z().z(new z.InterfaceC0484z() { // from class: com.ss.android.downloadlib.g.dl.1
            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void dl() {
            }

            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void g() {
                com.ss.android.socialbase.downloader.m.z.g("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.z.z.z().g(this);
                if (i.g(gVar)) {
                    return;
                }
                gVar.i(true);
                com.ss.android.downloadlib.a.z.z().z("install_delay_invoke", gVar);
                zVar.z();
            }
        });
    }
}
