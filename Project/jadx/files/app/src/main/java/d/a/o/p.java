package d.a.o;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class p implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ m f20765s;

    p(m mVar) {
        this.f20765s = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f20765s.a.f20760d.compareAndSet(false, true)) {
            RequestStatistic requestStatistic = this.f20765s.a.a.f588f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                requestStatistic.rspEnd = System.currentTimeMillis();
                ALog.e("anet.UnifiedRequestTask", "task time out", this.f20765s.a.f20759c, "rs", requestStatistic);
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, requestStatistic, null));
            }
            this.f20765s.a.b();
            l lVar = this.f20765s.a;
            lVar.b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, lVar.a.a()));
        }
    }
}
