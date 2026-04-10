package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.downloader.wp;
import com.ss.android.socialbase.downloader.e.dl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static volatile g dl;
    private static final Object gc = new Object();
    private final long z = 1000;
    private final Map<Integer, Long> g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f2106a = new HashSet();
    private final SparseArray<z> m = new SparseArray<>();

    static boolean g(int i) {
        return i == 1 || i == 3;
    }

    private g() {
    }

    public static g z() {
        if (dl == null) {
            synchronized (g.class) {
                if (dl == null) {
                    dl = new g();
                }
            }
        }
        return dl;
    }

    public void z(int i) {
        dl dlVarGz = e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).gz(i);
        if (dlVarGz == null) {
            return;
        }
        z(dlVarGz);
        g(dlVarGz);
    }

    void z(dl dlVar) {
        wp wpVarIo = com.ss.android.socialbase.downloader.downloader.dl.io();
        if (wpVarIo != null && dlVar.no()) {
            dlVar.m(3);
            try {
                wpVarIo.z(dlVar);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    void g(dl dlVar) {
        if (dl(dlVar)) {
            m(dlVar.e());
        }
    }

    static boolean dl(dl dlVar) {
        return dlVar.no() && g(dlVar.hn());
    }

    public void z(int i, int i2, Notification notification) {
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        if (contextXl == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.g) {
                Long l = this.g.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.g.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextXl, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.wp.z.z().z(intent);
            } else {
                contextXl.startService(intent);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.wp.z.z().z(intent);
            }
        }
    }

    public void dl(int i) {
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        if (contextXl == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextXl, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.wp.z.z().z(intent);
            } else {
                contextXl.startService(intent);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                com.ss.android.socialbase.downloader.wp.z.z().z(intent);
            }
        }
    }

    public void z(z zVar) {
        if (zVar == null) {
            return;
        }
        synchronized (this.m) {
            this.m.put(zVar.z(), zVar);
        }
    }

    public z a(int i) {
        z zVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.m) {
            zVar = this.m.get(i);
            if (zVar != null) {
                this.m.remove(i);
                com.ss.android.socialbase.downloader.m.z.z("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return zVar;
    }

    public z gc(int i) {
        z zVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.m) {
            zVar = this.m.get(i);
        }
        return zVar;
    }

    SparseArray<z> g() {
        SparseArray<z> sparseArray;
        synchronized (this.m) {
            sparseArray = this.m;
        }
        return sparseArray;
    }

    public void m(int i) {
        a(i);
        if (i != 0) {
            z().dl(i);
        }
    }
}
