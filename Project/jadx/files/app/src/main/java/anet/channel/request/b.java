package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);
    private final Future<?> a;
    private final String b;

    public b(Future<?> future, String str) {
        this.a = future;
        this.b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.b, new Object[0]);
            this.a.cancel(true);
        }
    }
}
