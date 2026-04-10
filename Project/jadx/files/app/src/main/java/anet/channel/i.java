package anet.channel;

import anet.channel.SessionRequest;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ Session a;
    final /* synthetic */ SessionRequest.a b;

    i(SessionRequest.a aVar, Session session) {
        this.b = aVar;
        this.a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SessionRequest.this.a(this.b.f286c, this.a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.a.f269c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
