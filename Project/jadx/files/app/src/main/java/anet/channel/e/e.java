package anet.channel.e;

import androidx.core.view.InputDeviceCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import java.util.List;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ NetworkStatusHelper.NetworkStatus b;

    e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.a = list;
        this.b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        IConnStrategy iConnStrategy = (IConnStrategy) this.a.get(0);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a("https://" + a.b, "Http3Detect" + a.f321h.getAndIncrement(), a.b(iConnStrategy)));
        tnetSpdySession.registerEventcb(InputDeviceCompat.SOURCE_KEYBOARD, new f(this, iConnStrategy));
        tnetSpdySession.f259q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
