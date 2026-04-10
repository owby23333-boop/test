package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.downloader.dl;
import com.ss.android.socialbase.downloader.downloader.pf;
import com.ss.android.socialbase.downloader.g.gc;
import com.ss.android.socialbase.downloader.pf.m;
import com.ss.android.socialbase.downloader.v.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2104a = true;
    private static int dl = -1;
    private static volatile long e = 0;
    private static long fo = 900;
    private static int g = -1;
    private static boolean gc = false;
    private static boolean gz = false;
    private static volatile long m = 0;
    private static final String z = "DownloadNotificationService";
    private final SparseArray<Notification> kb = new SparseArray<>(2);
    private e uy;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
        dl.z(this);
        com.ss.android.socialbase.downloader.i.z zVarDl = com.ss.android.socialbase.downloader.i.z.dl();
        int iZ = zVarDl.z("download_service_foreground", 0);
        if ((iZ == 1 || iZ == 3) && g == -1) {
            g = 0;
        }
        if ((iZ == 2 || iZ == 3) && dl == -1) {
            dl = 0;
        }
        gc = zVarDl.g("non_going_notification_foreground", false);
        gz = zVarDl.g("notify_too_fast", false);
        long jZ = zVarDl.z("notification_time_window", 900L);
        fo = jZ;
        if (jZ < 0 || jZ > 1200) {
            fo = 900L;
        }
    }

    private void a() {
        if (this.uy == null) {
            e eVar = new e("DownloaderNotifyThread");
            this.uy = eVar;
            eVar.z();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.uy;
        if (eVar != null) {
            try {
                eVar.g();
            } catch (Throwable unused) {
            }
            this.uy = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        z(intent);
        return 2;
    }

    private void z(final Intent intent) {
        e eVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (eVar = this.uy) == null) {
            return;
        }
        eVar.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra == 0 || notification == null || notificationManager == null) {
                        return;
                    }
                    if (intExtra2 != 4) {
                        if (intExtra2 == -2 || intExtra2 == -3) {
                            if (DownloadNotificationService.gz) {
                                DownloadNotificationService.this.z(notificationManager, intExtra, notification);
                                return;
                            } else {
                                if (DownloadNotificationService.this.uy != null) {
                                    DownloadNotificationService.this.uy.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.g(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                        }
                        if (DownloadNotificationService.gz) {
                            DownloadNotificationService.this.z(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.g(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (com.ss.android.socialbase.downloader.downloader.e.g(dl.xl()).e(intExtra)) {
                        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(dl.xl()).gz(intExtra);
                        if (DownloadNotificationService.gz) {
                            if (dlVarGz == null || !dlVarGz.z() || System.currentTimeMillis() - DownloadNotificationService.e <= DownloadNotificationService.fo) {
                                return;
                            }
                            DownloadNotificationService.this.g(notificationManager, intExtra, notification);
                            dlVarGz.g();
                            return;
                        }
                        if (dlVarGz == null || !dlVarGz.z()) {
                            return;
                        }
                        DownloadNotificationService.this.g(notificationManager, intExtra, notification);
                        dlVarGz.g();
                        return;
                    }
                    return;
                }
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.g(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (m.z((Context) DownloadNotificationService.this, com.kuaishou.weapon.p0.g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(gc.z)) {
                                arrayList.add(gc.z);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                com.ss.android.socialbase.downloader.downloader.e.g(applicationContext).z(arrayList);
                                com.ss.android.socialbase.downloader.downloader.e.g(applicationContext).g(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        wp.z(e2);
                        return;
                    }
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        com.ss.android.socialbase.downloader.downloader.e.g(DownloadNotificationService.this).z();
                    } catch (Exception e3) {
                        wp.z(e3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.kb) {
            int iIndexOfKey = this.kb.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.kb.size()) {
                this.kb.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = fo - (System.currentTimeMillis() - m);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            e = jCurrentTimeMillis2;
            m = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                g(notificationManager, i, notification);
            } else if (this.uy != null) {
                synchronized (this.kb) {
                    this.kb.put(i, notification);
                }
                this.uy.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.z(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.kb) {
            notification = this.kb.get(i);
            this.kb.remove(i);
        }
        if (notification != null) {
            g(notificationManager, i, notification);
        }
    }

    private boolean z(int i, Notification notification) {
        int i2;
        int i3;
        if (!f2104a || (i2 = g) == i || (i3 = dl) == i) {
            return false;
        }
        if (i2 == 0 || i3 == 0) {
            return ((gc && (notification.flags & 2) == 0) || TextUtils.isEmpty(notification.getChannelId())) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(NotificationManager notificationManager, int i, Notification notification) {
        if (z(i, notification)) {
            try {
                boolean z2 = false;
                boolean z3 = a.z().z(i) == 1 && !m.dl();
                if ((!z3 && g == 0) || (z3 && dl == 0)) {
                    z2 = true;
                }
                if (z2) {
                    pf pfVarDl = a.z().dl(i);
                    if (pfVarDl.e() && !pfVarDl.g()) {
                        com.ss.android.socialbase.downloader.m.z.dl(z, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z3);
                        if (z3) {
                            dl = i;
                        } else {
                            g = i;
                        }
                        pfVarDl.z(i, notification);
                    } else {
                        com.ss.android.socialbase.downloader.m.z.dl(z, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z3)));
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        } else if ((g == i || dl == i) && gc && (notification.flags & 2) == 0) {
            g(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (m < jCurrentTimeMillis) {
                m = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(NotificationManager notificationManager, int i) {
        boolean z2;
        z zVarValueAt;
        int iZ;
        int i2 = g;
        if (i2 == i || dl == i) {
            boolean z3 = true;
            if (i2 == i) {
                g = 0;
                z2 = false;
            } else {
                dl = 0;
                z2 = true;
            }
            try {
                pf pfVarDl = a.z().dl(i);
                if (!pfVarDl.g()) {
                    f2104a = false;
                    com.ss.android.socialbase.downloader.m.z.a(z, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z2);
                }
                com.ss.android.socialbase.downloader.m.z.dl(z, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z2);
                pfVarDl.z(false, true);
            } catch (Throwable th) {
                wp.z(th);
            }
            try {
                notificationManager.cancel(i);
            } catch (Throwable unused) {
            }
            if (f2104a) {
                try {
                    SparseArray<z> sparseArrayG = g.z().g();
                    if (sparseArrayG != null) {
                        for (int size = sparseArrayG.size() - 1; size >= 0; size--) {
                            zVarValueAt = sparseArrayG.valueAt(size);
                            if (zVarValueAt != null && (iZ = zVarValueAt.z()) != i && iZ != g && iZ != dl && zVarValueAt.gz()) {
                                if ((a.z().z(zVarValueAt.z()) == 1 && !m.dl()) == z2) {
                                    break;
                                }
                            }
                        }
                        zVarValueAt = null;
                    } else {
                        zVarValueAt = null;
                    }
                    if (zVarValueAt != null) {
                        int iZ2 = zVarValueAt.z();
                        try {
                            notificationManager.cancel(iZ2);
                        } catch (Throwable th2) {
                            wp.z(th2);
                        }
                        if (com.ss.android.socialbase.downloader.downloader.e.g(this).m(iZ2) != 1) {
                            z3 = false;
                        }
                        com.ss.android.socialbase.downloader.m.z.dl(z, "doCancel, updateNotification id = ".concat(String.valueOf(iZ2)));
                        zVarValueAt.z((com.ss.android.socialbase.downloader.gc.z) null, z3);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    wp.z(th3);
                    return;
                }
            }
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused2) {
        }
    }
}
