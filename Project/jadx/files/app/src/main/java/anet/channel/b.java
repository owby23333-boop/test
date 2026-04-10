package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ anet.channel.entity.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Session f294c;

    b(Session session, int i2, anet.channel.entity.b bVar) {
        this.f294c = session;
        this.a = i2;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f294c.b != null) {
                for (EventCb eventCb : this.f294c.b.keySet()) {
                    if (eventCb != null && (this.f294c.b.get(eventCb).intValue() & this.a) != 0) {
                        try {
                            eventCb.onEvent(this.f294c, this.a, this.b);
                        } catch (Exception e2) {
                            ALog.e("awcn.Session", e2.toString(), this.f294c.f258p, new Object[0]);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            ALog.e("awcn.Session", "handleCallbacks", this.f294c.f258p, e3, new Object[0]);
        }
    }
}
