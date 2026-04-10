package com.bytedance.msdk.gz;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static volatile gz dl;
    private volatile String z = "";
    private volatile ExecutorService g = com.bytedance.msdk.z.gc.m.z("gaid", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.gz.gz.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    public static gz z() {
        if (dl == null) {
            synchronized (gz.class) {
                if (dl == null) {
                    dl = new gz();
                }
            }
        }
        return dl;
    }

    private gz() {
    }

    public String g() {
        try {
            this.z = l.z("tt_device_info", com.bytedance.msdk.core.g.getContext()).g("gaid", "");
            com.bytedance.msdk.z.gc.dl.z("gaid", "--==-- getGAIdTimeOut-mGAId = " + this.z);
            if (TextUtils.isEmpty(this.z)) {
                synchronized (this) {
                    if (this.g != null) {
                        FutureTask futureTask = new FutureTask(new z());
                        this.g.execute(futureTask);
                        this.z = (String) futureTask.get(1L, TimeUnit.MICROSECONDS);
                        if (!TextUtils.isEmpty(this.z)) {
                            this.g.shutdown();
                            this.g = null;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.z;
    }

    public synchronized void dl() {
        try {
            this.z = l.z("tt_device_info", com.bytedance.msdk.core.g.getContext()).g("gaid", "");
            com.bytedance.msdk.z.gc.dl.z("gaid", "--==-- initGAIdByAsyc-mGAId = " + this.z);
            if (TextUtils.isEmpty(this.z) && this.g != null) {
                this.g.execute(new FutureTask(new z()));
            }
        } catch (Throwable unused) {
        }
    }

    private class z implements Callable<String> {
        private z() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.g.getContext());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.msdk.z.gc.dl.z("gaid-", "getAdvertisingId: ".concat(String.valueOf(id)));
                    gz.g(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.g.getContext());
                if (advertisingIdInfo2 != null) {
                    gz.this.z = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.msdk.z.gc.dl.z("AdvertisingIdHelper", "mGAId:" + gz.this.z + " , get gaid consume time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return gz.this.z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l.z("tt_device_info", com.bytedance.msdk.core.g.getContext()).z("gaid", str);
    }
}
