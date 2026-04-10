package d.a.o;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class j implements SessionGetCallback {
    final /* synthetic */ RequestStatistic a;
    final /* synthetic */ long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Request f20753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SessionCenter f20754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ HttpUrl f20755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f20756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ g f20757g;

    j(g gVar, RequestStatistic requestStatistic, long j2, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z2) {
        this.f20757g = gVar;
        this.a = requestStatistic;
        this.b = j2;
        this.f20753c = request;
        this.f20754d = sessionCenter;
        this.f20755e = httpUrl;
        this.f20756f = z2;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        ALog.e("anet.NetworkTask", "onSessionGetFail", this.f20757g.f20737s.f20759c, "url", this.a.url);
        this.a.connWaitTime = System.currentTimeMillis() - this.b;
        g gVar = this.f20757g;
        gVar.a(gVar.a(null, this.f20754d, this.f20755e, this.f20756f), this.f20753c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.i("anet.NetworkTask", "onSessionGetSuccess", this.f20757g.f20737s.f20759c, "Session", session);
        this.a.connWaitTime = System.currentTimeMillis() - this.b;
        this.a.spdyRequestSend = true;
        this.f20757g.a(session, this.f20753c);
    }
}
