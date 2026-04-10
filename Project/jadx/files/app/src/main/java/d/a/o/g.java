package d.a.o;

import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.http.NetworkSdkSetting;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements d.a.o.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    l f20737s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Cache f20738t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Cache.Entry f20739u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    String f20741w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    volatile AtomicBoolean f20744z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ByteArrayOutputStream f20740v = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    volatile Cancelable f20742x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    volatile boolean f20743y = false;
    int A = 0;
    int B = 0;
    boolean C = false;
    boolean D = false;
    a E = null;

    g(l lVar, Cache cache, Cache.Entry entry) {
        this.f20738t = null;
        this.f20739u = null;
        this.f20741w = "other";
        this.f20744z = null;
        this.f20737s = lVar;
        this.f20744z = lVar.f20760d;
        this.f20738t = cache;
        this.f20739u = entry;
        this.f20741w = lVar.a.h().get(HttpConstant.F_REFER);
    }

    private Session b() {
        Session throwsException;
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.f20737s.a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.h hVar = this.f20737s.a;
        RequestStatistic requestStatistic = hVar.f588f;
        if (hVar.f592j != 1 || !d.a.j.b.n() || this.f20737s.a.f587e != 0 || zContainsNonDefaultPort) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        }
        HttpUrl httpUrlA = a(httpUrlF);
        try {
            throwsException = sessionCenterA.getThrowsException(httpUrlA, anet.channel.entity.c.a, 0L);
        } catch (NoAvailStrategyException unused) {
            return a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort);
        } catch (Exception unused2) {
            throwsException = null;
        }
        if (throwsException == null) {
            ThreadPoolExecutorFactory.submitPriorityTask(new i(this, sessionCenterA, httpUrlA, requestStatistic, httpUrlF, zContainsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
            return null;
        }
        ALog.i("anet.NetworkTask", "tryGetSession", this.f20737s.f20759c, "Session", throwsException);
        requestStatistic.spdyRequestSend = true;
        return throwsException;
    }

    private void c() {
        SessionCenter sessionCenterA = a();
        HttpUrl httpUrlF = this.f20737s.a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        anetwork.channel.entity.h hVar = this.f20737s.a;
        RequestStatistic requestStatistic = hVar.f588f;
        Request requestA = hVar.a();
        if (this.f20737s.a.f592j != 1 || !d.a.j.b.n() || this.f20737s.a.f587e != 0 || zContainsNonDefaultPort) {
            a(a(null, sessionCenterA, httpUrlF, zContainsNonDefaultPort), requestA);
            return;
        }
        sessionCenterA.asyncGet(a(httpUrlF), anet.channel.entity.c.a, com.anythink.expressad.video.module.a.a.m.ag, new j(this, requestStatistic, System.currentTimeMillis(), requestA, sessionCenterA, httpUrlF, zContainsNonDefaultPort));
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f20743y = true;
        if (this.f20742x != null) {
            this.f20742x.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f20743y) {
            return;
        }
        RequestStatistic requestStatistic = this.f20737s.a.f588f;
        requestStatistic.f_refer = this.f20741w;
        if (!NetworkStatusHelper.isConnected()) {
            if (d.a.j.b.k() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = -200;
                ThreadPoolExecutorFactory.submitScheduledTask(new h(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.i("anet.NetworkTask", "network unavailable", this.f20737s.f20759c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f20744z.set(true);
            this.f20737s.a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = -200;
            requestStatistic.msg = ErrorConstant.getErrMsg(-200);
            requestStatistic.rspEnd = System.currentTimeMillis();
            l lVar = this.f20737s;
            lVar.b.a(new DefaultFinishEvent(-200, null, lVar.a.a()));
            return;
        }
        if (!d.a.j.b.e() || !GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0 || AppLifecycle.isGoingForeground || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= d.a.j.b.a() || d.a.j.b.b(this.f20737s.a.f()) || d.a.j.b.a(this.f20737s.a.a().getBizId()) || this.f20737s.a.a().isAllowRequestInBg()) {
            if (ALog.isPrintLog(2)) {
                l lVar2 = this.f20737s;
                ALog.i("anet.NetworkTask", "exec request", lVar2.f20759c, "retryTimes", Integer.valueOf(lVar2.a.f587e));
            }
            if (d.a.j.b.h()) {
                c();
                return;
            }
            try {
                Session sessionB = b();
                if (sessionB == null) {
                    return;
                }
                a(sessionB, this.f20737s.a.a());
                return;
            } catch (Exception e2) {
                ALog.e("anet.NetworkTask", "send request failed.", this.f20737s.f20759c, e2, new Object[0]);
                return;
            }
        }
        this.f20744z.set(true);
        this.f20737s.a();
        if (ALog.isPrintLog(2)) {
            l lVar3 = this.f20737s;
            ALog.i("anet.NetworkTask", "request forbidden in background", lVar3.f20759c, "url", lVar3.a.f());
        }
        requestStatistic.isDone.set(true);
        requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
        requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
        requestStatistic.rspEnd = System.currentTimeMillis();
        l lVar4 = this.f20737s;
        lVar4.b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, lVar4.a.a()));
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
        exceptionStatistic.host = this.f20737s.a.f().host();
        exceptionStatistic.url = this.f20737s.a.g();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    static class a {
        int a;
        Map<String, List<String>> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<ByteArray> f20745c = new ArrayList();

        a(int i2, Map<String, List<String>> map) {
            this.a = i2;
            this.b = map;
        }

        void a() {
            Iterator<ByteArray> it = this.f20745c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }

        int a(d.a.m.a aVar, int i2) {
            aVar.onResponseCode(this.a, this.b);
            Iterator<ByteArray> it = this.f20745c.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                aVar.a(i3, i2, it.next());
                i3++;
            }
            return i3;
        }
    }

    private HttpUrl a(HttpUrl httpUrl) {
        HttpUrl httpUrl2;
        String str = this.f20737s.a.h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (httpUrl2 = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : httpUrl2;
    }

    private SessionCenter a() {
        String strA = this.f20737s.a.a("APPKEY");
        if (TextUtils.isEmpty(strA)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String strA2 = this.f20737s.a.a("ENVIRONMENT");
        if ("pre".equalsIgnoreCase(strA2)) {
            env = ENV.PREPARE;
        } else if ("test".equalsIgnoreCase(strA2)) {
            env = ENV.TEST;
        }
        if (env != NetworkSdkSetting.f594s) {
            NetworkSdkSetting.f594s = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(strA, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(strA).setEnv(env).setAuthCode(this.f20737s.a.a("AuthCode")).build();
        }
        return SessionCenter.getInstance(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Session a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z2) {
        anetwork.channel.entity.h hVar = this.f20737s.a;
        RequestStatistic requestStatistic = hVar.f588f;
        if (session == null && hVar.e() && !z2 && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, anet.channel.entity.c.b, 0L);
        }
        if (session == null) {
            ALog.i("anet.NetworkTask", "create HttpSession with local DNS", this.f20737s.f20759c, new Object[0]);
            session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.f20737s.f20759c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.i("anet.NetworkTask", "tryGetHttpSession", this.f20737s.f20759c, "Session", session);
        return session;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private anet.channel.request.Request a(anet.channel.request.Request r7) {
        /*
            r6 = this;
            d.a.o.l r0 = r6.f20737s
            anetwork.channel.entity.h r0 = r0.a
            boolean r0 = r0.i()
            if (r0 == 0) goto L3c
            d.a.o.l r0 = r6.f20737s
            anetwork.channel.entity.h r0 = r0.a
            java.lang.String r0 = r0.g()
            java.lang.String r0 = d.a.k.a.b(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
            java.util.Map r2 = r7.getHeaders()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = anet.channel.util.StringUtils.concatString(r2, r4, r0)
        L38:
            r1.addHeader(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            anetwork.channel.cache.Cache$Entry r0 = r6.f20739u
            if (r0 == 0) goto L65
            if (r1 != 0) goto L47
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
        L47:
            anetwork.channel.cache.Cache$Entry r0 = r6.f20739u
            java.lang.String r0 = r0.f561t
            if (r0 == 0) goto L52
            java.lang.String r2 = "If-None-Match"
            r1.addHeader(r2, r0)
        L52:
            anetwork.channel.cache.Cache$Entry r0 = r6.f20739u
            long r2 = r0.f562u
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L65
            java.lang.String r0 = anetwork.channel.cache.c.a(r2)
            java.lang.String r2 = "If-Modified-Since"
            r1.addHeader(r2, r0)
        L65:
            d.a.o.l r0 = r6.f20737s
            anetwork.channel.entity.h r0 = r0.a
            int r0 = r0.f587e
            if (r0 != 0) goto L84
            java.lang.String r0 = r6.f20741w
            java.lang.String r2 = "weex"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L84
            if (r1 != 0) goto L7f
            anet.channel.request.Request$Builder r0 = r7.newBuilder()
            r1 = r0
        L7f:
            r0 = 3000(0xbb8, float:4.204E-42)
            r1.setReadTimeout(r0)
        L84:
            if (r1 != 0) goto L87
            goto L8b
        L87:
            anet.channel.request.Request r7 = r1.build()
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.o.g.a(anet.channel.request.Request):anet.channel.request.Request");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Session session, Request request) {
        if (session == null || this.f20743y) {
            return;
        }
        Request requestA = a(request);
        RequestStatistic requestStatistic = this.f20737s.a.f588f;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f20742x = session.request(requestA, new k(this, requestA, requestStatistic));
    }
}
