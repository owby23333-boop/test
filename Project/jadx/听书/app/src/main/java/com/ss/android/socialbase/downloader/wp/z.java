package com.ss.android.socialbase.downloader.wp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.e.dl;
import com.ss.android.socialbase.downloader.g.gc;
import com.ss.android.socialbase.downloader.pf.m;
import com.ss.android.socialbase.downloader.v.e;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static volatile z e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile e f2115a;
    private volatile long g;
    private volatile long z;
    private long dl = 1000;
    private final SparseArray<Notification> gc = new SparseArray<>(2);
    private AtomicBoolean m = new AtomicBoolean(false);

    public static z z() {
        if (e == null) {
            synchronized (z.class) {
                if (e == null) {
                    e = new z();
                }
            }
        }
        return e;
    }

    public void g() {
        if (this.m.compareAndSet(false, true)) {
            this.f2115a = new e("DownloaderNotifyThread");
            this.f2115a.z();
            long jZ = com.ss.android.socialbase.downloader.i.z.dl().z("notification_time_window", 1000L);
            this.dl = jZ;
            if (jZ < 0 || jZ > 1200) {
                this.dl = 1000L;
            }
        }
    }

    public void z(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        g();
        if (this.f2115a == null) {
            return;
        }
        this.f2115a.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.wp.z.1
            @Override // java.lang.Runnable
            public void run() {
                z.this.g(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        dl dlVarGz;
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        if (contextXl == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextXl.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 == -2 || intExtra2 == -3) {
                    z(notificationManager, intExtra, notification);
                    return;
                } else {
                    z(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).e(intExtra) && (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).gz(intExtra)) != null && dlVarGz.z() && System.currentTimeMillis() - this.g > this.dl) {
                g(notificationManager, intExtra, notification);
                dlVarGz.g();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                g(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (m.z(contextXl, g.b) && (connectivityManager = (ConnectivityManager) contextXl.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(gc.z)) {
                        arrayList.add(gc.z);
                    }
                    arrayList.add("mime_type_plg");
                    com.ss.android.socialbase.downloader.downloader.e.g(contextXl).z(arrayList);
                    com.ss.android.socialbase.downloader.downloader.e.g(contextXl).g(arrayList);
                    return;
                }
                return;
            } catch (Exception e2) {
                wp.z(e2);
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).z();
            } catch (Exception e3) {
                wp.z(e3);
            }
        }
    }

    private void z(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.gc) {
            int iIndexOfKey = this.gc.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.gc.size()) {
                this.gc.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.dl - (System.currentTimeMillis() - this.z);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.g = jCurrentTimeMillis2;
            this.z = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                g(notificationManager, i, notification);
            } else if (this.f2115a != null) {
                synchronized (this.gc) {
                    this.gc.put(i, notification);
                }
                this.f2115a.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.wp.z.2
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.gc) {
            notification = this.gc.get(i);
            this.gc.remove(i);
        }
        if (notification != null) {
            g(notificationManager, i, notification);
        }
    }

    private void g(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.z < jCurrentTimeMillis) {
                this.z = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void g(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
