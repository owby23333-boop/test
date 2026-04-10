package d.a.o;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import d.a.m.b;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class m {
    protected l a;

    /* JADX INFO: compiled from: Taobao */
    class a implements b.a {
        private int a;

        a(int i2, Request request, d.a.m.a aVar) {
            this.a = 0;
            this.a = i2;
        }

        public Future a(Request request, d.a.m.a aVar) {
            if (m.this.a.f20760d.get()) {
                ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.a < d.a.m.c.a()) {
                return d.a.m.c.a(this.a).a(m.this.new a(this.a + 1, request, aVar));
            }
            m.this.a.a.a(request);
            m.this.a.b = aVar;
            Cache cacheA = d.a.j.b.i() ? anetwork.channel.cache.a.a(m.this.a.a.g(), m.this.a.a.h()) : null;
            l lVar = m.this.a;
            lVar.f20761e = cacheA != null ? new c(lVar, cacheA) : new g(lVar, null, null);
            m.this.a.f20761e.run();
            m.this.c();
            return null;
        }
    }

    public m(anetwork.channel.entity.h hVar, anetwork.channel.entity.d dVar) {
        dVar.a(hVar.f591i);
        this.a = new l(hVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a.f20762f = ThreadPoolExecutorFactory.submitScheduledTask(new p(this), this.a.a.b(), TimeUnit.MILLISECONDS);
    }

    void b() {
        if (this.a.f20760d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.a.f20759c, "URL", this.a.a.f().simpleUrlString());
            RequestStatistic requestStatistic = this.a.a.f588f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > 102400) {
                    anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.a.b();
            this.a.a();
            l lVar = this.a;
            lVar.b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, null, lVar.a.a()));
        }
    }

    public Future a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        anetwork.channel.entity.h hVar = this.a.a;
        RequestStatistic requestStatistic = hVar.f588f;
        requestStatistic.reqServiceTransmissionEnd = jCurrentTimeMillis;
        requestStatistic.start = jCurrentTimeMillis;
        requestStatistic.isReqSync = hVar.c();
        this.a.a.f588f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            this.a.a.f588f.netReqStart = Long.valueOf(this.a.a.a("f-netReqStart")).longValue();
        } catch (Exception unused) {
        }
        String strA = this.a.a.a("f-traceId");
        if (!TextUtils.isEmpty(strA)) {
            this.a.a.f588f.traceId = strA;
        }
        String strA2 = this.a.a.a("f-reqProcess");
        anetwork.channel.entity.h hVar2 = this.a.a;
        RequestStatistic requestStatistic2 = hVar2.f588f;
        requestStatistic2.process = strA2;
        requestStatistic2.pTraceId = hVar2.a("f-pTraceId");
        String str = "[traceId:" + strA + "]" + com.anythink.expressad.foundation.d.c.bT;
        l lVar = this.a;
        ALog.e("anet.UnifiedRequestTask", str, lVar.f20759c, "bizId", lVar.a.a().getBizId(), "processFrom", strA2, "url", this.a.a.g());
        if (!d.a.j.b.a(this.a.a.f())) {
            ThreadPoolExecutorFactory.submitPriorityTask(new o(this), ThreadPoolExecutorFactory.Priority.HIGH);
            return new f(this);
        }
        d dVar = new d(this.a);
        this.a.f20761e = dVar;
        dVar.f20730t = new anet.channel.request.b(ThreadPoolExecutorFactory.submitBackupTask(new n(this)), this.a.a.a().getSeq());
        c();
        return new f(this);
    }
}
