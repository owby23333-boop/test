package com.bytedance.z.g.z;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class z extends FileObserver {
    private volatile boolean dl;
    private final int g;
    private final dl z;

    public z(dl dlVar, String str, int i) {
        super(str, i);
        this.g = 5000;
        this.dl = true;
        if (dlVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.z = dlVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.dl && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.z != null) {
            this.dl = false;
            this.z.z(200, "/data/anr/".concat(String.valueOf(str)), 80);
            new C0231z(5000).start();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.z.g.z.z$z, reason: collision with other inner class name */
    private final class C0231z extends com.bytedance.sdk.component.uy.a.dl {
        private int g;

        C0231z(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.g = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.g);
            z.this.dl = true;
        }
    }
}
