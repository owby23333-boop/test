package com.taobao.accs.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class j extends b implements DataFrameCb {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f18223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f18224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ScheduledFuture f18225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Handler f18226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Runnable f18227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ISessionListener f18228t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f18229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Set<String> f18230v;

    /* JADX INFO: compiled from: Taobao */
    public static class a implements IAuth {
        private String a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f18231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private b f18232d;

        public a(b bVar, String str) {
            this.f18231c = bVar.d();
            this.a = bVar.c("https://" + str + "/accs/");
            this.b = bVar.f18200c;
            this.f18232d = bVar;
        }

        @Override // anet.channel.IAuth
        public void auth(Session session, IAuth.AuthCallback authCallback) {
            ALog.e(this.f18231c, BaseMonitor.ALARM_POINT_AUTH, "URL", this.a);
            session.request(new Request.Builder().setUrl(this.a).build(), new t(this, authCallback));
        }
    }

    public j(Context context, int i2, String str) {
        super(context, i2, str);
        this.f18223o = true;
        this.f18224p = 3600000L;
        this.f18226r = new Handler(Looper.getMainLooper());
        this.f18227s = new k(this);
        this.f18228t = new l(this);
        this.f18229u = new s(this);
        this.f18230v = Collections.synchronizedSet(new HashSet());
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f18229u, 120000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f18206i.isAccsHeartbeatEnable()) {
            ALog.e(d(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.f18225q;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.f18227s;
            long j2 = this.f18224p;
            this.f18225q = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.b
    public com.taobao.accs.ut.a.c c() {
        return null;
    }

    @Override // com.taobao.accs.net.b
    public String d() {
        return "InAppConn_" + this.f18210m;
    }

    @Override // com.taobao.accs.net.b
    public void e() {
        ALog.e(d(), "shut down", new Object[0]);
        this.f18223o = false;
    }

    @Override // com.taobao.accs.net.b
    public boolean m() {
        if (!this.f18204g) {
            return false;
        }
        try {
            Session session = SessionCenter.getInstance(this.f18206i.getAppKey()).get(b((String) null), ConnType.TypeLevel.SPDY, 0L);
            Object[] objArr = new Object[2];
            objArr[0] = CallMraidJS.b;
            objArr[1] = Boolean.valueOf(session == null || session.isAvailable());
            ALog.e("InAppConn_", "isConnected", objArr);
            if (session != null) {
                if (session.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3) {
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(d(), "onDataReceive", "type", Integer.valueOf(i3), "dataid", Integer.valueOf(i2));
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new q(this, i3, bArr, tnetSpdySession));
    }

    @Override // anet.channel.DataFrameCb
    public void onException(int i2, int i3, boolean z2, String str) {
        ALog.e(d(), "errorId:" + i3 + "detail:" + str + " dataId:" + i2 + " needRetry:" + z2, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new r(this, i2, z2, i3));
    }

    @Override // com.taobao.accs.net.b
    public synchronized void a() {
        ALog.d(d(), com.anythink.expressad.foundation.d.c.bT, new Object[0]);
        this.f18223o = true;
        a(this.f18201d);
    }

    @Override // com.taobao.accs.net.b
    public void b() {
        this.f18203f = 0;
    }

    @Override // com.taobao.accs.net.b
    public void c(int i2) {
        super.c(i2);
    }

    @Override // com.taobao.accs.net.b
    public void a(Message message, boolean z2) {
        if (this.f18223o && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new n(this, message), message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame() && a(message.cunstomDataId)) {
                            this.f18202e.b(message);
                        }
                        this.f18202e.a.put(message.cunstomDataId, scheduledFutureSchedule);
                    }
                    NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                    if (netPermanceMonitor != null) {
                        netPermanceMonitor.setDeviceId(UtilityImpl.k(this.f18201d));
                        netPermanceMonitor.setConnType(this.f18200c);
                        netPermanceMonitor.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.f18202e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
                ALog.e(d(), "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
                return;
            } catch (Throwable th) {
                this.f18202e.a(message, -8);
                ALog.e(d(), "send error", th, new Object[0]);
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.f18223o, new Object[0]);
    }

    public j(Context context, int i2, String str, int i3) {
        super(context, i2, str);
        this.f18223o = true;
        this.f18224p = 3600000L;
        this.f18226r = new Handler(Looper.getMainLooper());
        this.f18227s = new k(this);
        this.f18228t = new l(this);
        this.f18229u = new s(this);
        this.f18230v = Collections.synchronizedSet(new HashSet());
        c(i3);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f18229u, 120000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.b
    protected void a(String str, boolean z2, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new o(this, str, z2), j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.b
    public void a(boolean z2, boolean z3) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new p(this));
    }

    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z2, String str2) {
        Session session;
        try {
            Message messageB = this.f18202e.b(str);
            if (messageB != null && messageB.host != null && (session = SessionCenter.getInstance(this.f18206i.getAppKey()).get(messageB.host.toString(), 0L)) != null) {
                if (z2) {
                    ALog.e(d(), "close session by time out", new Object[0]);
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e2) {
            ALog.e(d(), "onTimeOut", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.b
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.f18202e.a.get(str);
        boolean zCancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (zCancel) {
            ALog.e(d(), com.anythink.expressad.d.a.b.dO, "customDataId", str);
        }
        return zCancel;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(d(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i2 = jSONObject.getInt("timeInterval");
            if (i2 == -1) {
                if (this.f18225q != null) {
                    this.f18225q.cancel(true);
                    return;
                }
                return;
            }
            long j2 = i2 * 1000;
            if (this.f18224p != j2) {
                if (i2 == 0) {
                    j2 = 3600000;
                }
                this.f18224p = j2;
                if (this.f18225q != null) {
                    this.f18225q.cancel(true);
                }
                this.f18225q = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(this.f18227s, this.f18224p, this.f18224p, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e2) {
            ALog.e(d(), "onReceiveAccsHeartbeatResp", com.anythink.core.c.e.a, e2.getMessage());
        }
    }

    @Override // com.taobao.accs.net.b
    protected void a(Context context) {
        boolean z2;
        try {
            if (this.f18204g) {
                return;
            }
            super.a(context);
            if (com.taobao.accs.utl.u.a(context)) {
                SessionCenter.getInstance(this.f18206i.getAppKey()).registerAccsSessionListener(this.f18228t);
            }
            String inappHost = this.f18206i.getInappHost();
            if (h() && this.f18206i.isKeepalive()) {
                z2 = true;
            } else {
                ALog.d(d(), "initAwcn close keepalive", new Object[0]);
                z2 = false;
            }
            a(SessionCenter.getInstance(this.f18206i.getAppKey()), inappHost, z2);
            this.f18204g = true;
            ALog.i(d(), "initAwcn success!", new Object[0]);
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z2) {
        if (this.f18230v.contains(str)) {
            return;
        }
        sessionCenter.registerSessionInfo(SessionInfo.create(str, z2, true, new a(this, str), null, this));
        sessionCenter.registerPublicKey(str, this.f18206i.getInappPubKey());
        this.f18230v.add(str);
        ALog.i(d(), "registerSessionInfo", Constants.KEY_HOST, str);
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(d(), "updateConfig null", new Object[0]);
            return;
        }
        if (accsClientConfig.equals(this.f18206i)) {
            ALog.w(d(), "updateConfig not any changed", new Object[0]);
            return;
        }
        if (!this.f18204g) {
            if (UtilityImpl.isMainProcess(this.f18201d)) {
                this.f18206i = accsClientConfig;
                a(this.f18201d);
                return;
            }
            return;
        }
        try {
            boolean z2 = true;
            ALog.w(d(), "updateConfig", "old", this.f18206i, "new", accsClientConfig);
            String inappHost = this.f18206i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f18206i.getAppKey());
            if (sessionCenter == null) {
                ALog.w(d(), "updateConfig not need update", new Object[0]);
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            ALog.w(d(), "updateConfig unregisterSessionInfo", Constants.KEY_HOST, inappHost);
            if (this.f18230v.contains(inappHost)) {
                this.f18230v.remove(inappHost);
                ALog.w(d(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
            }
            this.f18206i = accsClientConfig;
            this.b = this.f18206i.getAppKey();
            this.f18210m = this.f18206i.getTag();
            String str = ConnType.PK_ACS;
            if (this.f18206i.getInappPubKey() == 10 || this.f18206i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "update config register new conn protocol host:", this.f18206i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f18206i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
            if (!h() || !this.f18206i.isKeepalive()) {
                ALog.i(d(), "updateConfig close keepalive", new Object[0]);
                z2 = false;
            }
            a(sessionCenter, inappHost2, z2);
        } catch (Throwable th) {
            ALog.e(d(), "updateConfig", th, new Object[0]);
        }
    }
}
