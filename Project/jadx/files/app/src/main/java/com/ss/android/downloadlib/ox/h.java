package com.ss.android.downloadlib.ox;

import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* JADX INFO: loaded from: classes3.dex */
public class h implements AppStatusManager.AppStatusChangeListener {
    private long mb;

    private static class mb {
        private static h mb = new h();
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.mb = System.currentTimeMillis();
    }

    public void ox(hj hjVar) {
        if (hjVar == null) {
            return;
        }
        mb(hjVar, com.ss.android.downloadlib.addownload.x.lz().optInt("check_an_result_delay", 1200) > 0 ? r1 : 1200);
    }

    private h() {
        this.mb = 0L;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static h mb() {
        return mb.mb;
    }

    public void mb(final hj hjVar, final long j2) {
        if (hjVar == null) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - h.this.mb <= j2) {
                    hjVar.mb(true);
                } else {
                    hjVar.mb(false);
                }
            }
        }, j2);
    }

    public void mb(hj hjVar) {
        mb(hjVar, 5000L);
    }
}
