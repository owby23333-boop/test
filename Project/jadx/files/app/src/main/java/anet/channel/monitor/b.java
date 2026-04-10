package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.anythink.expressad.video.module.a.a.m;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {
    static int a = 0;
    static long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static long f340c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static long f341d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static long f342e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static long f343f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static double f344g = 0.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static double f345h = 0.0d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static double f346i = 0.0d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static double f347j = 40.0d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f351n;

    /* JADX INFO: compiled from: Taobao */
    static class a {
        static b a = new b(null);

        a() {
        }
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f350m;
        bVar.f350m = i2 + 1;
        return i2;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e2) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f348k = false;
        } else {
            f348k = true;
        }
    }

    public void e() {
        f348k = false;
    }

    private b() {
        this.f349l = 5;
        this.f350m = 0;
        this.f351n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f346i;
    }

    public static b a() {
        return a.a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f349l;
    }

    public void a(long j2, long j3, long j4) {
        if (f348k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= m.ag || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j4, j3, j2));
        }
    }
}
