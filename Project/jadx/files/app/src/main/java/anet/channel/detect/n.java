package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static d a = new d();
    private static ExceptionDetector b = new ExceptionDetector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f312c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f313d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f313d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                a.b();
                b.a();
                f312c.a();
            }
        } catch (Exception e2) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f313d.get()) {
            b.a(requestStatistic);
        }
    }
}
