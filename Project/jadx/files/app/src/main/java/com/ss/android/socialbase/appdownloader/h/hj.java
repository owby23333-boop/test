package com.ss.android.socialbase.appdownloader.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.b.o;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private static com.ss.android.socialbase.appdownloader.view.mb b = null;
    private static AlertDialog hj = null;
    private static final String mb = "hj";
    private static List<o> ox = new ArrayList();

    public static void ox(@NonNull Activity activity, @NonNull o oVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    b = (com.ss.android.socialbase.appdownloader.view.mb) fragmentManager.findFragmentByTag(mb);
                    if (b == null) {
                        b = new com.ss.android.socialbase.appdownloader.view.mb();
                        fragmentManager.beginTransaction().add(b, mb).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    b.mb();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    oVar.mb();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        oVar.mb();
    }

    public static boolean mb() {
        try {
            return NotificationManagerCompat.from(DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void mb(boolean z2) {
        try {
            if (hj != null) {
                hj.cancel();
                hj = null;
            }
            for (o oVar : ox) {
                if (oVar != null) {
                    if (z2) {
                        oVar.mb();
                    } else {
                        oVar.ox();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void mb(@NonNull final Activity activity, @NonNull final o oVar) {
        if (oVar == null) {
            return;
        }
        if (activity != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                mb(false);
            }
            if (!activity.isFinishing()) {
                int iMb = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                int iMb2 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                int iMb3 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                int iMb4 = lz.mb(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                ox.add(oVar);
                if (hj == null || !hj.isShowing()) {
                    hj = new AlertDialog.Builder(activity).setTitle(iMb).setMessage(iMb2).setPositiveButton(iMb3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            hj.ox(activity, oVar);
                            dialogInterface.cancel();
                            AlertDialog unused = hj.hj = null;
                        }
                    }).setNegativeButton(iMb4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            hj.mb(false);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.h.hj.1
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4) {
                                return false;
                            }
                            if (keyEvent.getAction() == 1) {
                                hj.mb(false);
                            }
                            return true;
                        }
                    }).setCancelable(false).show();
                }
                return;
            }
        }
        oVar.ox();
    }
}
