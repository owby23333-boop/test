package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.d;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b implements IHeartbeat, Runnable {
    private Session a;
    private volatile long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f336c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f337d = 0;

    b() {
    }

    private void a(long j2) {
        try {
            this.b = System.currentTimeMillis() + j2;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j2 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.a.f258p, e2, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.b = System.currentTimeMillis() + this.f337d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f336c) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.b - 1000) {
            a(this.b - jCurrentTimeMillis);
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            Session session = this.a;
            ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session.f258p, d.aw, session);
            this.a.close(false);
        } else {
            if (ALog.isPrintLog(1)) {
                Session session2 = this.a;
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session2.f258p, d.aw, session2);
            }
            this.a.ping(true);
            a(this.f337d);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.a = session;
        this.f337d = session.getConnStrategy().getHeartbeat();
        if (this.f337d <= 0) {
            this.f337d = 45000L;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.f258p, d.aw, session, am.aU, Long.valueOf(this.f337d));
        a(this.f337d);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.a;
        if (session == null) {
            return;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.f258p, d.aw, session);
        this.f336c = true;
    }
}
