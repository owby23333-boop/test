package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class SessionRequest {
    SessionCenter a;
    e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SessionInfo f276c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile Session f278e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile Future f284k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f277d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f279f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    HashMap<SessionGetCallback, c> f280g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    SessionConnStat f281h = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f285l = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    interface IConnCb {
        void onDisConnect(Session session, long j2, int i2);

        void onFailed(Session session, long j2, int i2, int i3);

        void onSuccess(Session session, long j2);
    }

    /* JADX INFO: compiled from: Taobao */
    class a implements IConnCb {
        boolean a = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<anet.channel.entity.a> f287d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private anet.channel.entity.a f288e;

        a(Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.f286c = context;
            this.f287d = list;
            this.f288e = aVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(Session session, long j2, int i2) {
            SessionInfo sessionInfo;
            boolean zIsAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.d("awcn.SessionRequest", "Connect Disconnect", this.f288e.h(), com.umeng.analytics.pro.d.aw, session, Constants.KEY_HOST, SessionRequest.this.a(), "appIsBg", Boolean.valueOf(zIsAppBackground), "isHandleFinish", Boolean.valueOf(this.a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.b.b(sessionRequest, session);
            if (this.a) {
                return;
            }
            this.a = true;
            if (session.f262t) {
                if (zIsAppBackground && ((sessionInfo = SessionRequest.this.f276c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f288e.h(), com.umeng.analytics.pro.d.aw, session);
                    return;
                }
                if (!NetworkStatusHelper.isConnected()) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f288e.h(), com.umeng.analytics.pro.d.aw, session);
                    return;
                }
                try {
                    ALog.d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f288e.h(), new Object[0]);
                    int accsReconnectionDelayPeriod = 10000;
                    if (SessionRequest.this.f276c != null && SessionRequest.this.f276c.isAccs) {
                        accsReconnectionDelayPeriod = AwcnConfig.getAccsReconnectionDelayPeriod();
                    }
                    i iVar = new i(this, session);
                    double dRandom = Math.random();
                    double d2 = accsReconnectionDelayPeriod;
                    Double.isNaN(d2);
                    ThreadPoolExecutorFactory.submitScheduledTask(iVar, (long) (dRandom * d2), TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j2, int i2, int i3) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.f288e.h(), com.umeng.analytics.pro.d.aw, session, Constants.KEY_HOST, SessionRequest.this.a(), "isHandleFinish", Boolean.valueOf(this.a));
            }
            if (SessionRequest.this.f279f) {
                SessionRequest.this.f279f = false;
                return;
            }
            if (this.a) {
                return;
            }
            this.a = true;
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.b.b(sessionRequest, session);
            if (!session.f263u || !NetworkStatusHelper.isConnected() || this.f287d.isEmpty()) {
                SessionRequest.this.c();
                SessionRequest.this.a(session, i2, i3);
                synchronized (SessionRequest.this.f280g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f280g.entrySet()) {
                        c value = entry.getValue();
                        if (value.b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetFail();
                        }
                    }
                    SessionRequest.this.f280g.clear();
                }
                return;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.f288e.h(), Constants.KEY_HOST, SessionRequest.this.a());
            }
            anet.channel.entity.a aVar = this.f288e;
            if (aVar.b == aVar.f324c && (i3 == -2003 || i3 == -2410)) {
                ListIterator<anet.channel.entity.a> listIterator = this.f287d.listIterator();
                while (listIterator.hasNext()) {
                    if (session.getIp().equals(listIterator.next().a.getIp())) {
                        listIterator.remove();
                    }
                }
            }
            if (anet.channel.strategy.utils.c.b(session.getIp())) {
                ListIterator<anet.channel.entity.a> listIterator2 = this.f287d.listIterator();
                while (listIterator2.hasNext()) {
                    if (anet.channel.strategy.utils.c.b(listIterator2.next().a.getIp())) {
                        listIterator2.remove();
                    }
                }
            }
            if (!this.f287d.isEmpty()) {
                anet.channel.entity.a aVarRemove = this.f287d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f286c;
                sessionRequest2.a(context, aVarRemove, sessionRequest2.new a(context, this.f287d, aVarRemove), aVarRemove.h());
                return;
            }
            SessionRequest.this.c();
            SessionRequest.this.a(session, i2, i3);
            synchronized (SessionRequest.this.f280g) {
                for (Map.Entry<SessionGetCallback, c> entry2 : SessionRequest.this.f280g.entrySet()) {
                    c value2 = entry2.getValue();
                    if (value2.b.compareAndSet(false, true)) {
                        ThreadPoolExecutorFactory.removeScheduleTask(value2);
                        entry2.getKey().onSessionGetFail();
                    }
                }
                SessionRequest.this.f280g.clear();
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j2) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.f288e.h(), com.umeng.analytics.pro.d.aw, session, Constants.KEY_HOST, SessionRequest.this.a());
            try {
                if (SessionRequest.this.f279f) {
                    SessionRequest.this.f279f = false;
                    session.close(false);
                    return;
                }
                SessionRequest.this.b.a(SessionRequest.this, session);
                SessionRequest.this.a(session);
                synchronized (SessionRequest.this.f280g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f280g.entrySet()) {
                        c value = entry.getValue();
                        if (value.b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.f280g.clear();
                }
            } catch (Exception e2) {
                ALog.e("awcn.SessionRequest", "[onSuccess]:", this.f288e.h(), e2, new Object[0]);
            } finally {
                SessionRequest.this.c();
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    private class b implements Runnable {
        String a;

        b(String str) {
            this.a = null;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.f277d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f281h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f281h.start;
                if (SessionRequest.this.f278e != null) {
                    SessionRequest.this.f278e.f263u = false;
                    SessionRequest.this.f278e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f281h.syncValueFromSession(sessionRequest.f278e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f281h);
                SessionRequest.this.a(false);
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    protected class c implements Runnable {
        SessionGetCallback a;
        AtomicBoolean b = new AtomicBoolean(false);

        protected c(SessionGetCallback sessionGetCallback) {
            this.a = null;
            this.a = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.f280g) {
                    SessionRequest.this.f280g.remove(this.a);
                }
                this.a.onSessionGetFail();
            }
        }
    }

    SessionRequest(String str, SessionCenter sessionCenter) {
        this.f282i = str;
        String str2 = this.f282i;
        this.f283j = str2.substring(str2.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.a = sessionCenter;
        this.f276c = sessionCenter.f273g.b(this.f283j);
        this.b = sessionCenter.f271e;
    }

    protected synchronized void b(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        Session sessionA = this.b.a(this, i2);
        if (sessionA != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            sessionGetCallback.onSessionGetSuccess(sessionA);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f282i, "type", Integer.valueOf(i2));
        if (this.f277d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, a());
            if (b() == i2) {
                c cVar = new c(sessionGetCallback);
                synchronized (this.f280g) {
                    this.f280g.put(sessionGetCallback, cVar);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(cVar, j2, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
            return;
        }
        a(true);
        this.f284k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        this.f281h = new SessionConnStat();
        this.f281h.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> listA = a(i2, str);
        if (listA.isEmpty()) {
            ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f282i, "type", Integer.valueOf(i2));
            c();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        List<anet.channel.entity.a> listA2 = a(listA, str);
        try {
            anet.channel.entity.a aVarRemove = listA2.remove(0);
            a(context, aVarRemove, new a(context, listA2, aVarRemove), aVarRemove.h());
            c cVar2 = new c(sessionGetCallback);
            synchronized (this.f280g) {
                this.f280g.put(sessionGetCallback, cVar2);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            c();
        }
        return;
    }

    void c() {
        a(false);
        synchronized (this.f285l) {
            this.f285l.notifyAll();
        }
    }

    protected String a() {
        return this.f282i;
    }

    void a(boolean z2) {
        this.f277d = z2;
        if (z2) {
            return;
        }
        if (this.f284k != null) {
            this.f284k.cancel(true);
            this.f284k = null;
        }
        this.f278e = null;
    }

    private void c(Session session, int i2, String str) {
        SessionInfo sessionInfo = this.f276c;
        if (sessionInfo == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
        intent.putExtra("command", 103);
        intent.putExtra(Constants.KEY_HOST, session.getHost());
        intent.putExtra(Constants.KEY_CENTER_HOST, true);
        boolean zIsAvailable = session.isAvailable();
        if (!zIsAvailable) {
            intent.putExtra("errorCode", i2);
            intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
        }
        intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, zIsAvailable);
        intent.putExtra(Constants.KEY_TYPE_INAPP, true);
        this.a.f274h.notifyListener(intent);
    }

    protected synchronized void a(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        Session sessionA = this.b.a(this, i2);
        if (sessionA != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(sessionA);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f282i, "type", Integer.valueOf(i2));
        if (this.f277d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, a());
            if (sessionGetCallback != null) {
                if (b() == i2) {
                    c cVar = new c(sessionGetCallback);
                    synchronized (this.f280g) {
                        this.f280g.put(sessionGetCallback, cVar);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar, j2, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        a(true);
        this.f284k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        this.f281h = new SessionConnStat();
        this.f281h.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> listA = a(i2, str);
        if (!listA.isEmpty()) {
            List<anet.channel.entity.a> listA2 = a(listA, str);
            try {
                anet.channel.entity.a aVarRemove = listA2.remove(0);
                a(context, aVarRemove, new a(context, listA2, aVarRemove), aVarRemove.h());
                if (sessionGetCallback != null) {
                    c cVar2 = new c(sessionGetCallback);
                    synchronized (this.f280g) {
                        this.f280g.put(sessionGetCallback, cVar2);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j2, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                c();
            }
            return;
        }
        ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f282i, "type", Integer.valueOf(i2));
        c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    protected void b(boolean z2) {
        ALog.d("awcn.SessionRequest", "closeSessions", this.a.f269c, Constants.KEY_HOST, this.f282i, "autoCreate", Boolean.valueOf(z2));
        if (!z2 && this.f278e != null) {
            this.f278e.f263u = false;
            this.f278e.close(false);
        }
        List<Session> listA = this.b.a(this);
        if (listA != null) {
            for (Session session : listA) {
                if (session != null) {
                    session.close(z2);
                }
            }
        }
    }

    void a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f282i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f281h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f281h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f281h.start;
        AppMonitor.getInstance().commitStat(this.f281h);
    }

    protected int b() {
        Session session = this.f278e;
        if (session != null) {
            return session.f252j.getType();
        }
        return -1;
    }

    private void b(Session session, int i2, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context == null || (sessionInfo = this.f276c) == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent(Constants.ACTION_RECEIVE);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context, com.taobao.accs.utl.j.msgService);
            intent.putExtra("command", 103);
            intent.putExtra(Constants.KEY_HOST, session.getHost());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean zIsAvailable = session.isAvailable();
            if (!zIsAvailable) {
                intent.putExtra("errorCode", i2);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, zIsAvailable);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            if (Build.VERSION.SDK_INT >= 26) {
                context.bindService(intent, new h(this, intent, context), 1);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    void a(Session session, int i2, int i3) {
        if (256 != i2 || i3 == -2613 || i3 == -2601) {
            return;
        }
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f282i;
        alarmObject.errorCode = String.valueOf(i3);
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        SessionConnStat sessionConnStat = this.f281h;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i3);
        this.f281h.errorCode = String.valueOf(i3);
        this.f281h.totalTime = System.currentTimeMillis() - this.f281h.start;
        this.f281h.syncValueFromSession(session);
        AppMonitor.getInstance().commitStat(this.f281h);
    }

    private List<IConnStrategy> a(int i2, String str) {
        HttpUrl httpUrl;
        List<IConnStrategy> connStrategyListByHost = Collections.EMPTY_LIST;
        try {
            httpUrl = HttpUrl.parse(a());
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
        if (httpUrl == null) {
            return Collections.EMPTY_LIST;
        }
        connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(httpUrl.host());
        if (!connStrategyListByHost.isEmpty()) {
            boolean zEqualsIgnoreCase = "https".equalsIgnoreCase(httpUrl.scheme());
            boolean zB = anet.channel.util.c.b();
            ListIterator<IConnStrategy> listIterator = connStrategyListByHost.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                ConnType connTypeValueOf = ConnType.valueOf(next.getProtocol());
                if (connTypeValueOf != null) {
                    if (connTypeValueOf.isSSL() == zEqualsIgnoreCase && (i2 == anet.channel.entity.c.f328c || connTypeValueOf.getType() == i2)) {
                        if (zB && anet.channel.strategy.utils.c.b(next.getIp())) {
                            listIterator.remove();
                        }
                    }
                    listIterator.remove();
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", connStrategyListByHost);
        }
        return connStrategyListByHost;
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            IConnStrategy iConnStrategy = list.get(i2);
            int retryTimes = iConnStrategy.getRetryTimes();
            int i4 = i3;
            for (int i5 = 0; i5 <= retryTimes; i5++) {
                i4++;
                anet.channel.entity.a aVar = new anet.channel.entity.a(a(), str + "_" + i4, iConnStrategy);
                aVar.b = i5;
                aVar.f324c = retryTimes;
                arrayList.add(aVar);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType connTypeC = aVar.c();
        if (context != null && !connTypeC.isHttpType()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, aVar);
            tnetSpdySession.initConfig(this.a.f270d);
            tnetSpdySession.initSessionInfo(this.f276c);
            tnetSpdySession.setTnetPublicKey(this.a.f273g.c(this.f283j));
            this.f278e = tnetSpdySession;
        } else {
            this.f278e = new anet.channel.session.d(context, aVar);
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, HttpConstant.HOST, a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), com.umeng.analytics.pro.d.aw, this.f278e);
        a(this.f278e, iConnCb, System.currentTimeMillis());
        this.f278e.connect();
        SessionConnStat sessionConnStat = this.f281h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f281h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", aVar.a());
        }
    }

    private void a(Session session, IConnCb iConnCb, long j2) {
        if (iConnCb == null) {
            return;
        }
        session.registerEventcb(EventType.ALL, new f(this, iConnCb, j2));
        session.registerEventcb(1792, new g(this, session));
    }

    protected void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, Constants.KEY_HOST, this.f282i);
        b(true);
    }

    protected void a(long j2) throws InterruptedException, TimeoutException {
        ALog.d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j2));
        if (j2 <= 0) {
            return;
        }
        synchronized (this.f285l) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j2;
            while (this.f277d) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 >= jCurrentTimeMillis) {
                    break;
                } else {
                    this.f285l.wait(jCurrentTimeMillis - jCurrentTimeMillis2);
                }
            }
            if (this.f277d) {
                throw new TimeoutException();
            }
        }
    }

    void a(Session session, int i2, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            b(session, i2, str);
        }
        c(session, i2, str);
    }
}
