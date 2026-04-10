package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements EventCb {
    final /* synthetic */ Session a;
    final /* synthetic */ SessionRequest b;

    g(SessionRequest sessionRequest, Session session) {
        this.b = sessionRequest;
        this.a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i2));
        ConnEvent connEvent = new ConnEvent();
        if (i2 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.b.f276c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.a.getRealHost(), this.a.getConnStrategy(), connEvent);
    }
}
