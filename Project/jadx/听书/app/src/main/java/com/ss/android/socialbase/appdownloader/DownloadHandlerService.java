package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.un;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadHandlerService extends Service {
    private static final String z = "DownloadHandlerService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.dl.z(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.m.z.z()) {
            com.ss.android.socialbase.downloader.m.z.g(z, "onStartCommand");
        }
        z(com.ss.android.socialbase.downloader.downloader.dl.xl(), intent);
        stopSelf();
        return 2;
    }

    private boolean z(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = a.kb().dl();
        gk gkVarFo = com.ss.android.socialbase.downloader.downloader.e.g(this).fo(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.i.z.z(intExtra).g("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.g.z().m(intExtra);
        }
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(intExtra);
        if (dlVarGz == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            g(context, dlVarGz, gcVarDl, gkVarFo);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            z(context, dlVarGz, gcVarDl, gkVarFo);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (dlVarGz.p() == 0) {
                return false;
            }
            z(context, dlVarGz, gcVarDl, gkVarFo);
            if (dlVarGz.no() && com.ss.android.socialbase.downloader.i.z.z(intExtra).z("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.i.z.z(intExtra).g("enable_notification_ui") >= 2 && dlVarGz.p() == -1)) {
                    com.ss.android.socialbase.downloader.notification.g.z().z(intExtra);
                    com.ss.android.socialbase.downloader.notification.g.z().m(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            dl(context, dlVarGz, gcVarDl, gkVarFo);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.g.z().z(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).z(arrayList);
                    } catch (Exception e) {
                        wp.z(e);
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (com.ss.android.socialbase.downloader.pf.m.g(context.getApplicationContext()) && dlVar.jq()) {
            dlVar.qd();
        }
    }

    private static void z(Context context, final com.ss.android.socialbase.appdownloader.dl.gc gcVar, final com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        final gk gkVarFo = com.ss.android.socialbase.downloader.downloader.e.g(context).fo(dlVar.e());
        if (gcVar == null && gkVarFo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                File file;
                PackageInfo packageInfoZ;
                try {
                    file = new File(dlVar.kb(), dlVar.gz());
                } catch (Exception e) {
                    wp.z(e);
                }
                if (file.exists()) {
                    try {
                        String str = (com.ss.android.socialbase.downloader.downloader.dl.xl() == null || (packageInfoZ = dl.z(dlVar, file)) == null) ? "" : packageInfoZ.packageName;
                        com.ss.android.socialbase.appdownloader.dl.gc gcVar2 = gcVar;
                        if (gcVar2 != null) {
                            gcVar2.z(dlVar.e(), 3, str, -3, dlVar.oz());
                        }
                        gk gkVar = gkVarFo;
                        if (gkVar != null) {
                            gkVar.z(3, dlVar, str, "");
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        wp.z(e2);
                        return;
                    }
                    wp.z(e);
                }
            }
        });
    }

    private void g(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.dl.gc gcVar, gk gkVar) {
        boolean z2;
        int iE = dlVar.e();
        un unVarWp = com.ss.android.socialbase.downloader.downloader.a.z().wp(iE);
        if (unVarWp != null) {
            try {
                z2 = unVarWp.z(dlVar);
            } catch (Throwable th) {
                wp.z(th);
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", iE);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.g.z().z(iE);
        dlVar.r();
        if (gcVar != null) {
            gcVar.z(iE, 7, "", dlVar.p(), dlVar.oz());
        }
        if (gkVar != null) {
            gkVar.z(7, dlVar, "", "");
        }
    }

    private void dl(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.dl.gc gcVar, gk gkVar) {
        int iE = dlVar.e();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", iE);
        intent.addFlags(268435456);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.g.z().z(iE);
        dlVar.r();
        if (gcVar != null) {
            gcVar.z(iE, 7, "", dlVar.p(), dlVar.oz());
        }
        if (gkVar != null) {
            gkVar.z(7, dlVar, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(android.content.Context r2, int r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.a r4 = com.ss.android.socialbase.downloader.downloader.a.z()
            com.ss.android.socialbase.downloader.a.un r4 = r4.wp(r3)
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.e r1 = com.ss.android.socialbase.downloader.downloader.e.g(r2)     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.downloader.e.dl r1 = r1.gz(r3)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L20
            boolean r4 = r4.g(r1)     // Catch: java.lang.Throwable -> L1c
            goto L21
        L1c:
            r4 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r4)
        L20:
            r4 = r0
        L21:
            if (r4 == 0) goto L24
            return
        L24:
            r4 = 1
            int r3 = com.ss.android.socialbase.appdownloader.dl.z(r2, r3, r4)
            if (r3 != 0) goto L34
            java.lang.String r3 = "Open Fail!"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.z(android.content.Context, int, boolean):void");
    }

    public static void z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.dl.gc gcVar, gk gkVar) {
        com.ss.android.socialbase.downloader.notification.z zVarGc;
        int iE = dlVar.e();
        un unVarWp = com.ss.android.socialbase.downloader.downloader.a.z().wp(iE);
        if ("application/vnd.android.package-archive".equals(dlVar.yt()) && unVarWp != null && dl.z(context, dlVar) && unVarWp.dl(dlVar)) {
        }
        boolean z2 = false;
        switch (dlVar.p()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.i.z.z(iE).g("enable_notification_ui") >= 2 && dlVar.io()) {
                    dlVar.a(false);
                }
                com.ss.android.socialbase.downloader.downloader.e.g(context).gc(iE);
                break;
            case -3:
                z(com.ss.android.socialbase.downloader.downloader.dl.xl(), iE, true);
                z(context, gcVar, dlVar);
                if (com.ss.android.socialbase.downloader.i.z.z(iE).z("notification_click_install_auto_cancel", 1) != 0 || (zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(iE)) == null) {
                    z2 = true;
                } else {
                    zVarGc.e();
                    zVarGc.z(-3, null, false, true);
                }
                if (z2) {
                    com.ss.android.socialbase.downloader.notification.g.z().z(iE);
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.a.z().gc(iE)) {
                    com.ss.android.socialbase.downloader.downloader.e.g(context).dl(iE);
                } else {
                    dl.z(dlVar, true, false);
                }
                if (gcVar != null) {
                    gcVar.z(iE, 6, "", dlVar.p(), dlVar.oz());
                }
                if (gkVar != null) {
                    gkVar.z(6, dlVar, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.ss.android.socialbase.downloader.downloader.e.g(context).z(iE);
                z(context, dlVar);
                if (gcVar != null) {
                    gcVar.z(iE, 5, "", dlVar.p(), dlVar.oz());
                }
                if (gkVar != null) {
                    gkVar.z(5, dlVar, "", "");
                }
                break;
        }
    }
}
