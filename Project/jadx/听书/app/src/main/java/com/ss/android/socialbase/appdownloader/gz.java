package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.z.z;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2037a;
    private long dl;
    private Runnable e;
    private boolean g;
    private SoftReference<JumpUnknownSourceActivity> gc;
    private Handler m;
    private final Queue<Integer> z;

    private gz() {
        this.z = new ArrayDeque();
        this.g = false;
        this.m = new Handler(Looper.getMainLooper());
        this.e = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gz.1
            @Override // java.lang.Runnable
            public void run() {
                gz.this.dl();
            }
        };
        com.ss.android.socialbase.downloader.z.z.z().z(new z.InterfaceC0484z() { // from class: com.ss.android.socialbase.appdownloader.gz.2
            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void dl() {
            }

            @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
            public void g() {
                if (gz.this.z.isEmpty()) {
                    return;
                }
                long jZ = com.ss.android.socialbase.downloader.i.z.dl().z("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - gz.this.f2037a;
                if (jCurrentTimeMillis < jZ) {
                    if (gz.this.m.hasCallbacks(gz.this.e)) {
                        return;
                    }
                    gz.this.m.postDelayed(gz.this.e, jZ - jCurrentTimeMillis);
                } else {
                    gz.this.f2037a = System.currentTimeMillis();
                    gz.this.dl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.z.z.z().g()) {
            synchronized (this.z) {
                numPoll = this.z.poll();
            }
            this.m.removeCallbacks(this.e);
            if (numPoll != null) {
                final Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.m.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gz.3
                        @Override // java.lang.Runnable
                        public void run() {
                            gz.this.g(contextXl, numPoll.intValue(), false);
                        }
                    });
                } else {
                    g(contextXl, numPoll.intValue(), false);
                }
                this.m.postDelayed(this.e, 20000L);
                return;
            }
            this.g = false;
        }
    }

    void z(com.ss.android.socialbase.downloader.e.dl dlVar, String str) {
        if (dlVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        dl();
    }

    private static class z {
        private static final gz z = new gz();
    }

    public static gz z() {
        return z.z;
    }

    public int z(final Context context, final int i, final boolean z2) {
        if (z2) {
            return g(context, i, z2);
        }
        if (a()) {
            this.m.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.gz.4
                @Override // java.lang.Runnable
                public void run() {
                    gz.this.z(context, i, z2);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.z.z.z().g()) {
            com.ss.android.socialbase.downloader.m.z.dl("leaves", "on Foreground");
            return g(context, i, z2);
        }
        if (g.z()) {
            return 1;
        }
        boolean z3 = Build.VERSION.SDK_INT < 29;
        if (this.z.isEmpty() && !this.g && z3) {
            return g(context, i, z2);
        }
        int iZ = com.ss.android.socialbase.downloader.i.z.dl().z("install_queue_size", 3);
        synchronized (this.z) {
            while (this.z.size() > iZ) {
                this.z.poll();
            }
        }
        if (z3) {
            this.m.removeCallbacks(this.e);
            this.m.postDelayed(this.e, com.ss.android.socialbase.downloader.i.z.z(i).z("install_queue_timeout", 20000L));
        }
        synchronized (this.z) {
            if (!this.z.contains(Integer.valueOf(i))) {
                this.z.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean a() {
        return System.currentTimeMillis() - this.dl < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(Context context, int i, boolean z2) {
        int iG = dl.g(context, i, z2);
        if (iG == 1) {
            this.g = true;
        }
        this.dl = System.currentTimeMillis();
        return iG;
    }

    public void z(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.gc = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity g() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.gc;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.gc = null;
        return jumpUnknownSourceActivity;
    }
}
