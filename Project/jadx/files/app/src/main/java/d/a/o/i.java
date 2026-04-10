package d.a.o;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ SessionCenter f20747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ HttpUrl f20748t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f20749u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ HttpUrl f20750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ boolean f20751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ g f20752x;

    i(g gVar, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z2) {
        this.f20752x = gVar;
        this.f20747s = sessionCenter;
        this.f20748t = httpUrl;
        this.f20749u = requestStatistic;
        this.f20750v = httpUrl2;
        this.f20751w = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Session session = this.f20747s.get(this.f20748t, anet.channel.entity.c.a, com.anythink.expressad.video.module.a.a.m.ag);
        this.f20749u.connWaitTime = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f20749u.spdyRequestSend = session != null;
        Session sessionA = this.f20752x.a(session, this.f20747s, this.f20750v, this.f20751w);
        g gVar = this.f20752x;
        gVar.a(sessionA, gVar.f20737s.a.a());
    }
}
