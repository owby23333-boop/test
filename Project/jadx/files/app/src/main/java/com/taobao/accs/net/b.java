package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.anythink.core.api.ATAdConst;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static int f18199n;
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f18200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f18201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.taobao.accs.data.d f18202e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.taobao.accs.client.b f18205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AccsClientConfig f18206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f18207j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18210m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Runnable f18214r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ScheduledFuture<?> f18215s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f18203f = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f18211o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected volatile boolean f18204g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f18208k = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18212p = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected LinkedHashMap<Integer, Message> f18209l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList<AccsConnectStateListener> f18213q = new ArrayList<>();

    protected b(Context context, int i2, String str) {
        this.b = "";
        this.f18200c = i2;
        this.f18201d = context.getApplicationContext();
        this.f18206i = AccsClientConfig.getConfigByTag(str);
        if (this.f18206i == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                this.f18206i = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (AccsException e2) {
                ALog.e(d(), "BaseConnection build config", e2, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.f18206i;
        if (accsClientConfig != null) {
            this.f18210m = accsClientConfig.getTag();
            this.b = this.f18206i.getAppKey();
        }
        this.f18202e = new com.taobao.accs.data.d(context, this);
        this.f18202e.b = this.f18200c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    protected String a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z2);

    protected void a(String str, boolean z2, long j2) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this, str, z2), j2, TimeUnit.MILLISECONDS);
    }

    public abstract void a(String str, boolean z2, String str2);

    public abstract void a(boolean z2, boolean z3);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z2) {
        if (!message.isAck && !UtilityImpl.j(this.f18201d)) {
            ALog.e(d(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.f18202e.a(message, -13);
            return;
        }
        long jA = message.getType() != 2 ? this.f18202e.f18173d.a(message.serviceId, message.bizId) : 0L;
        if (jA == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.f18202e.a(message, ErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (jA == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.f18202e.a(message, ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (jA > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.f18211o;
            if (jCurrentTimeMillis > j2) {
                message.delyTime = jA;
            } else {
                message.delyTime = (j2 + jA) - System.currentTimeMillis();
            }
            this.f18211o = System.currentTimeMillis() + message.delyTime;
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if ("accs".equals(message.serviceId)) {
            ALog.e(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
        }
        try {
            if (TextUtils.isEmpty(this.f18207j)) {
                this.f18207j = UtilityImpl.k(this.f18201d);
            }
            if (message.isTimeOut()) {
                this.f18202e.a(message, -9);
            } else {
                a(message, z2);
            }
        } catch (RejectedExecutionException unused) {
            this.f18202e.a(message, ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.e(d(), "sendMessage ready queue full", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    protected String c(String str) {
        String strEncode;
        String strK = UtilityImpl.k(this.f18201d);
        try {
            strEncode = URLEncoder.encode(strK);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
            strEncode = strK;
        }
        String strA = UtilityImpl.a(this.f18201d, i(), this.f18206i.getAppSecret(), strK, this.f18210m);
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(strEncode);
        sb.append("&2=");
        sb.append(strA);
        sb.append("&3=");
        sb.append(i());
        if (this.f18208k != null) {
            sb.append("&4=");
            sb.append(this.f18208k);
        }
        sb.append("&5=");
        sb.append(this.f18200c);
        sb.append("&6=");
        sb.append(UtilityImpl.g(this.f18201d));
        sb.append("&7=");
        sb.append(UtilityImpl.a());
        sb.append("&8=");
        sb.append(this.f18200c == 1 ? "1.1.2" : 221);
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f18201d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.m(this.f18201d));
        sb.append("&14=");
        sb.append(this.a);
        sb.append("&15=");
        sb.append(UtilityImpl.c(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.c(Build.BRAND));
        sb.append("&17=");
        sb.append("221");
        sb.append("&19=");
        sb.append(!l() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f18206i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    protected void f() {
        if (this.f18214r == null) {
            this.f18214r = new d(this);
        }
        g();
        this.f18215s = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.f18214r, 40000L, TimeUnit.MILLISECONDS);
    }

    protected void g() {
        ScheduledFuture<?> scheduledFuture = this.f18215s;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    protected boolean h() {
        return true;
    }

    public String i() {
        return this.b;
    }

    public com.taobao.accs.client.b j() {
        if (this.f18205h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.f18210m);
            this.f18205h = new com.taobao.accs.client.b(this.f18201d, this.f18210m);
        }
        return this.f18205h;
    }

    public void k() {
        try {
            ThreadPoolExecutorFactory.schedule(new e(this), 10000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }

    public boolean l() {
        return 2 == this.f18206i.getSecurity();
    }

    public boolean m() {
        return false;
    }

    protected ArrayList<AccsConnectStateListener> n() {
        return this.f18213q;
    }

    protected boolean a(Message message, int i2) {
        boolean z2 = true;
        try {
        } catch (Throwable th) {
            th = th;
            z2 = false;
        }
        if (message.retryTimes > 3) {
            return false;
        }
        message.retryTimes++;
        message.delyTime = i2;
        ALog.e(d(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
        b(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().take_date = 0L;
                message.getNetPermanceMonitor().to_tnet_date = 0L;
                message.getNetPermanceMonitor().retry_times = message.retryTimes;
                if (message.retryTimes == 1) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.f18202e.a(message, -8);
            ALog.e(d(), "reSend error", th, new Object[0]);
        }
        return z2;
        this.f18202e.a(message, -8);
        ALog.e(d(), "reSend error", th, new Object[0]);
        return z2;
    }

    protected void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            if (AccsClientConfig.mEnv == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (AccsClientConfig.mEnv == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.b).setAppSecret(this.f18206i.getAppSecret()).setAuthCode(this.f18206i.getAuthCode()).setEnv(env).setTag(this.f18206i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f18206i.getInappPubKey() == 10 || this.f18206i.getInappPubKey() == 11) {
                str = ConnType.PK_OPEN;
            }
            ALog.i(d(), "init awcn register new conn protocol host:", this.f18206i.getInappHost());
            StrategyTemplate.getInstance().registerConnProtocol(this.f18206i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    protected void b(int i2) {
        if (i2 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i2));
            Message message = this.f18209l.get(Integer.valueOf(i2));
            if (message != null) {
                a(message, 5000);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }
        }
    }

    public void c(int i2) {
        f18199n = i2 != 1 ? 0 : 1;
    }

    public String b(String str) {
        String inappHost = this.f18206i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String string = sb.toString();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append(inappHost);
            return sb2.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return string;
        }
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f18213q) {
            this.f18213q.add(accsConnectStateListener);
        }
    }

    public void b(Message message, int i2) {
        this.f18202e.a(message, i2);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.f18213q) {
            this.f18213q.remove(accsConnectStateListener);
        }
    }
}
