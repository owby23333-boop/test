package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements EventCb {
    final /* synthetic */ HorseRaceStat a;
    final /* synthetic */ long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ l.e f309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ d f311f;

    h(d dVar, HorseRaceStat horseRaceStat, long j2, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f311f = dVar;
        this.a = horseRaceStat;
        this.b = j2;
        this.f308c = str;
        this.f309d = eVar;
        this.f310e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (this.a.connTime != 0) {
            return;
        }
        this.a.connTime = System.currentTimeMillis() - this.b;
        if (i2 != 1) {
            HorseRaceStat horseRaceStat = this.a;
            horseRaceStat.connErrorCode = bVar.b;
            synchronized (horseRaceStat) {
                this.a.notify();
            }
            return;
        }
        ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f308c, new Object[0]);
        this.a.connRet = 1;
        HttpUrl httpUrl = HttpUrl.parse(session.getHost() + this.f309d.f485c);
        if (httpUrl == null) {
            return;
        }
        this.f310e.request(new Request.Builder().setUrl(httpUrl).setReadTimeout(this.f309d.b.f464d).setRedirectEnable(false).setSeq(this.f308c).build(), new i(this));
    }
}
