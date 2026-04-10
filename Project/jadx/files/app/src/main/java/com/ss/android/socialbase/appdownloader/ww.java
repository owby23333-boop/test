package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class ww {
    private long b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SoftReference<JumpUnknownSourceActivity> f18094h;
    private long hj;
    private Runnable ko;
    private final Queue<Integer> mb;
    private boolean ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Handler f18095u;

    private static class mb {
        private static final ww mb = new ww();
    }

    private ww() {
        this.mb = new ArrayDeque();
        this.ox = false;
        this.f18095u = new Handler(Looper.getMainLooper());
        this.ko = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.1
            @Override // java.lang.Runnable
            public void run() {
                ww.this.b();
            }
        };
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.appdownloader.ww.2
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (ww.this.mb.isEmpty()) {
                    return;
                }
                long jOptLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - ww.this.hj;
                if (jCurrentTimeMillis < jOptLong) {
                    if (ww.this.f18095u.hasCallbacks(ww.this.ko)) {
                        return;
                    }
                    ww.this.f18095u.postDelayed(ww.this.ko, jOptLong - jCurrentTimeMillis);
                } else {
                    ww.this.hj = System.currentTimeMillis();
                    ww.this.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.mb) {
                numPoll = this.mb.poll();
            }
            this.f18095u.removeCallbacks(this.ko);
            if (numPoll == null) {
                this.ox = false;
                return;
            }
            final Context appContext = DownloadComponentManager.getAppContext();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f18095u.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ww.this.ox(appContext, numPoll.intValue(), false);
                    }
                });
            } else {
                ox(appContext, numPoll.intValue(), false);
            }
            this.f18095u.postDelayed(this.ko, 20000L);
        }
    }

    private boolean hj() {
        return System.currentTimeMillis() - this.b < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ox(Context context, int i2, boolean z2) {
        int iOx = b.ox(context, i2, z2);
        if (iOx == 1) {
            this.ox = true;
        }
        this.b = System.currentTimeMillis();
        return iOx;
    }

    void mb(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        b();
    }

    public JumpUnknownSourceActivity ox() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f18094h;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f18094h = null;
        return jumpUnknownSourceActivity;
    }

    public static ww mb() {
        return mb.mb;
    }

    public int mb(final Context context, final int i2, final boolean z2) {
        if (z2) {
            return ox(context, i2, z2);
        }
        if (hj()) {
            this.f18095u.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ww.4
                @Override // java.lang.Runnable
                public void run() {
                    ww.this.mb(context, i2, z2);
                }
            }, 1000L);
            return 1;
        }
        if (AppStatusManager.getInstance().isAppForeground()) {
            Logger.i("leaves", "on Foreground");
            return ox(context, i2, z2);
        }
        if (ox.mb()) {
            return 1;
        }
        boolean z3 = Build.VERSION.SDK_INT < 29;
        if (this.mb.isEmpty() && !this.ox && z3) {
            return ox(context, i2, z2);
        }
        int iOptInt = DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
        synchronized (this.mb) {
            while (this.mb.size() > iOptInt) {
                this.mb.poll();
            }
        }
        if (z3) {
            this.f18095u.removeCallbacks(this.ko);
            this.f18095u.postDelayed(this.ko, DownloadSetting.obtain(i2).optLong("install_queue_timeout", 20000L));
        }
        synchronized (this.mb) {
            if (!this.mb.contains(Integer.valueOf(i2))) {
                this.mb.offer(Integer.valueOf(i2));
            }
        }
        return 1;
    }

    public void mb(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f18094h = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
