package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile h f1772c;
    private volatile String a = "";
    private volatile ExecutorService b = ThreadHelper.initSingleThreadExecutor("gaid", 2, new a(this));

    class a implements RejectedExecutionHandler {
        a(h hVar) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    private class b implements Callable<String> {
        private b() {
        }

        /* synthetic */ b(h hVar, a aVar) {
            this();
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    Logger.d("gaid-", "getAdvertisingId: " + id);
                    h.b(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                if (advertisingIdInfo2 != null) {
                    h.this.a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            Logger.d("AdvertisingIdHelper", "mGAId:" + h.this.a + " , get gaid consume time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return h.this.a;
        }
    }

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("gaid", str);
    }

    public static h c() {
        if (f1772c == null) {
            synchronized (h.class) {
                if (f1772c == null) {
                    f1772c = new h();
                }
            }
        }
        return f1772c;
    }

    public String a() {
        try {
            this.a = e0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("gaid", "");
            Logger.d("gaid", "--==-- getGAIdTimeOut-mGAId = " + this.a);
            if (TextUtils.isEmpty(this.a)) {
                synchronized (this) {
                    if (this.b != null) {
                        FutureTask futureTask = new FutureTask(new b(this, null));
                        this.b.execute(futureTask);
                        this.a = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
                        if (!TextUtils.isEmpty(this.a)) {
                            this.b.shutdown();
                            this.b = null;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.a;
    }

    public void b() {
        synchronized (this) {
            try {
                this.a = e0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("gaid", "");
                Logger.d("gaid", "--==-- initGAIdByAsyc-mGAId = " + this.a);
                if (TextUtils.isEmpty(this.a) && this.b != null) {
                    this.b.execute(new FutureTask(new b(this, null)));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
