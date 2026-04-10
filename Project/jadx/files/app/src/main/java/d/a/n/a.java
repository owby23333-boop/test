package d.a.n;

import anet.channel.monitor.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    static AtomicBoolean a = new AtomicBoolean(false);

    public static synchronized void a() {
        if (a.compareAndSet(false, true)) {
            b.a().d();
        }
    }
}
