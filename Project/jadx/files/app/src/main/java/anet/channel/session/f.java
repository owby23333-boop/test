package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ Request a;
    final /* synthetic */ RequestCb b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f412d;

    f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f412d = dVar;
        this.a = request;
        this.b = requestCb;
        this.f411c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.sendBeforeTime = System.currentTimeMillis() - this.a.a.reqStart;
        b.a(this.a, new g(this));
    }
}
