package anet.channel.request;

import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);
    private final int a;
    private final SpdySession b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f397c;

    public c(SpdySession spdySession, int i2, String str) {
        this.b = spdySession;
        this.a = i2;
        this.f397c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        try {
            if (this.b == null || this.a == 0) {
                return;
            }
            ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f397c, "streamId", Integer.valueOf(this.a));
            this.b.streamReset(this.a, 5);
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f397c, e2, "errorCode", Integer.valueOf(e2.SpdyErrorGetCode()));
        }
    }
}
