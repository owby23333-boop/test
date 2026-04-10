package d.a.o;

import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private l f20726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Cache f20727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f20728u = false;

    public c(l lVar, Cache cache) {
        this.f20726s = null;
        this.f20727t = null;
        this.f20726s = lVar;
        this.f20727t = cache;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f20728u = true;
        this.f20726s.a.f588f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zEquals;
        Cache.Entry entry;
        if (this.f20728u) {
            return;
        }
        anetwork.channel.entity.h hVar = this.f20726s.a;
        RequestStatistic requestStatistic = hVar.f588f;
        if (this.f20727t != null) {
            String strG = hVar.g();
            Request requestA = this.f20726s.a.a();
            String str = requestA.getHeaders().get("Cache-Control");
            boolean zEquals2 = "no-store".equals(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zEquals2) {
                this.f20727t.remove(strG);
                zEquals = false;
                entry = null;
            } else {
                zEquals = "no-cache".equals(str);
                Cache.Entry entry2 = this.f20727t.get(strG);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.f20726s.f20759c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(entry2 != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(entry2 != null ? entry2.f560s.length : 0);
                    objArr[6] = "key";
                    objArr[7] = strG;
                    ALog.i("anet.CacheTask", "read cache", str2, objArr);
                }
                entry = entry2;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
            if (entry == null || zEquals || !entry.f()) {
                if (this.f20728u) {
                    return;
                }
                g gVar = new g(this.f20726s, zEquals2 ? null : this.f20727t, entry);
                this.f20726s.f20761e = gVar;
                gVar.run();
                return;
            }
            if (this.f20726s.f20760d.compareAndSet(false, true)) {
                this.f20726s.a();
                requestStatistic.ret = 1;
                requestStatistic.statusCode = 200;
                requestStatistic.msg = HttpConstant.SUCCESS;
                requestStatistic.protocolType = "cache";
                requestStatistic.rspEnd = jCurrentTimeMillis2;
                requestStatistic.processTime = jCurrentTimeMillis2 - requestStatistic.start;
                if (ALog.isPrintLog(2)) {
                    l lVar = this.f20726s;
                    ALog.i("anet.CacheTask", "hit fresh cache", lVar.f20759c, "URL", lVar.a.f().urlString());
                }
                this.f20726s.b.onResponseCode(200, entry.f564w);
                d.a.m.a aVar = this.f20726s.b;
                byte[] bArr = entry.f560s;
                aVar.a(1, bArr.length, ByteArray.wrap(bArr));
                this.f20726s.b.a(new DefaultFinishEvent(200, HttpConstant.SUCCESS, requestA));
            }
        }
    }
}
