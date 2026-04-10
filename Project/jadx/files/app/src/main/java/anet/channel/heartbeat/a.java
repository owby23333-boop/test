package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a implements IHeartbeat, Runnable {
    Session a = null;
    volatile boolean b = false;

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b) {
            return;
        }
        this.a.ping(true);
        ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session == null) {
            throw new NullPointerException("session is null");
        }
        this.a = session;
        run();
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.b = true;
    }
}
