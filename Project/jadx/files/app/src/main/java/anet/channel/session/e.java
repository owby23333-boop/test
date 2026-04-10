package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ Request a;
    final /* synthetic */ d b;

    e(d dVar, Request request) {
        this.b = dVar;
        this.a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = b.a(this.a, (RequestCb) null).a;
        if (i2 > 0) {
            this.b.notifyStatus(4, new anet.channel.entity.b(1));
        } else {
            this.b.handleCallbacks(256, new anet.channel.entity.b(256, i2, "Http connect fail"));
        }
    }
}
