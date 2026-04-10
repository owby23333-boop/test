package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static ExecutorService f244v = Executors.newSingleThreadExecutor();
    public Context a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConnType f252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IConnStrategy f253k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f255m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected Runnable f257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f258p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SessionStatistic f259q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f260r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f261s;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Future<?> f265x;
    Map<EventCb, Integer> b = new LinkedHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f264w = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f254l = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f256n = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f262t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f263u = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<Long> f266y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f267z = 0;

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;
        static final String[] a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i2) {
            return a[i2];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z2 = false;
        this.f255m = false;
        this.a = context;
        this.f247e = aVar.a();
        this.f248f = this.f247e;
        this.f249g = aVar.b();
        this.f252j = aVar.c();
        this.f245c = aVar.f();
        String str = this.f245c;
        this.f246d = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f261s = aVar.e();
        this.f260r = aVar.d();
        this.f253k = aVar.a;
        IConnStrategy iConnStrategy = this.f253k;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z2 = true;
        }
        this.f255m = z2;
        this.f258p = aVar.h();
        this.f259q = new SessionStatistic(aVar);
        this.f259q.host = this.f246d;
    }

    public static void configTnetALog(Context context, String str, int i2, int i3) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i2, i3);
        }
    }

    protected void a() {
        Future<?> future;
        if (this.f257o == null || (future = this.f265x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z2) {
        this.f262t = z2;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f253k;
    }

    public ConnType getConnType() {
        return this.f252j;
    }

    public String getHost() {
        return this.f245c;
    }

    public String getIp() {
        return this.f247e;
    }

    public int getPort() {
        return this.f249g;
    }

    public String getRealHost() {
        return this.f246d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f254l;
    }

    public void handleCallbacks(int i2, anet.channel.entity.b bVar) {
        f244v.submit(new b(this, i2, bVar));
    }

    public void handleResponseCode(Request request, int i2) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.f266y == null) {
                    this.f266y = new LinkedList();
                }
                if (this.f266y.size() < 5) {
                    this.f266y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long jLongValue = this.f266y.remove(0).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - jLongValue <= 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f266y.clear();
                    } else {
                        this.f266y.add(Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (StringUtils.isStringEqual(this.f254l, singleHeaderFieldByKey)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f267z > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.f267z = jCurrentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i2, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.f258p, "status", a.a(i2));
        if (i2 == this.f256n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.f258p, new Object[0]);
            return;
        }
        this.f256n = i2;
        switch (this.f256n) {
            case 0:
                handleCallbacks(1, bVar);
                break;
            case 2:
                handleCallbacks(256, bVar);
                break;
            case 4:
                this.f254l = StrategyCenter.getInstance().getUnitByHost(this.f246d);
                handleCallbacks(512, bVar);
                break;
            case 5:
                handleCallbacks(1024, bVar);
                break;
            case 6:
                onDisconnect();
                if (!this.f264w) {
                    handleCallbacks(2, bVar);
                }
                break;
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z2) {
    }

    public void ping(boolean z2, int i2) {
    }

    public void registerEventcb(int i2, EventCb eventCb) {
        Map<EventCb, Integer> map = this.b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
    }

    public void setPingTimeout(int i2) {
        if (this.f257o == null) {
            this.f257o = getRecvTimeOutRunnable();
        }
        a();
        Runnable runnable = this.f257o;
        if (runnable != null) {
            this.f265x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i2, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.f258p + '|' + this.f252j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f252j, session.f252j);
    }
}
