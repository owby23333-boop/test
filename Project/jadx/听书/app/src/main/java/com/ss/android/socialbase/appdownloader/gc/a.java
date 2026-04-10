package com.ss.android.socialbase.appdownloader.gc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.dl.pf;
import com.ss.android.socialbase.appdownloader.fo;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AlertDialog f2034a = null;
    private static com.ss.android.socialbase.appdownloader.view.z dl = null;
    private static List<pf> g = new ArrayList();
    private static final String z = "a";

    public static boolean z() {
        try {
            return g();
        } catch (Throwable th) {
            wp.z(th);
            return true;
        }
    }

    private static boolean g() {
        return ((NotificationManager) com.ss.android.socialbase.downloader.downloader.dl.xl().getSystemService("notification")).areNotificationsEnabled();
    }

    public static synchronized void z(boolean z2) {
        try {
            AlertDialog alertDialog = f2034a;
            if (alertDialog != null) {
                alertDialog.cancel();
                f2034a = null;
            }
            for (pf pfVar : g) {
                if (pfVar != null) {
                    if (z2) {
                        pfVar.z();
                    } else {
                        pfVar.g();
                    }
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static synchronized void z(final Activity activity, final pf pfVar) {
        if (pfVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    int iZ = fo.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), "tt_appdownloader_notification_request_title");
                    int iZ2 = fo.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), "tt_appdownloader_notification_request_message");
                    int iZ3 = fo.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), "tt_appdownloader_notification_request_btn_yes");
                    int iZ4 = fo.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), "tt_appdownloader_notification_request_btn_no");
                    g.add(pfVar);
                    AlertDialog alertDialog = f2034a;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f2034a = new AlertDialog.Builder(activity).setTitle(iZ).setMessage(iZ2).setPositiveButton(iZ3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.gc.a.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                a.g(activity, pfVar);
                                dialogInterface.cancel();
                                AlertDialog unused = a.f2034a = null;
                            }
                        }).setNegativeButton(iZ4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.gc.a.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                a.z(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.gc.a.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    a.z(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                wp.z(th);
                z(false);
                return;
            }
        }
        pfVar.g();
    }

    public static void g(Activity activity, pf pfVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = z;
                    com.ss.android.socialbase.appdownloader.view.z zVar = (com.ss.android.socialbase.appdownloader.view.z) fragmentManager.findFragmentByTag(str);
                    dl = zVar;
                    if (zVar == null) {
                        dl = new com.ss.android.socialbase.appdownloader.view.z();
                        fragmentManager.beginTransaction().add(dl, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            wp.z(th);
                        }
                    }
                    dl.z();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    wp.z(th2);
                    pfVar.z();
                    return;
                } catch (Throwable th3) {
                    wp.z(th3);
                    return;
                }
            }
        }
        pfVar.z();
    }

    public static void z(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.ss.android.socialbase.downloader.i.z.z(i).g("enable_target_34") <= 0 || z()) {
            return;
        }
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        try {
            Intent intent = new Intent(contextXl, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(268435456);
            contextXl.startActivity(intent);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.z.gc(z, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
