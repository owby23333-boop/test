package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.inter.ITagManager;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    protected long A;
    protected int B;
    protected DataFrameCb C;
    protected IHeartbeat D;
    protected IAuth E;
    protected String F;
    protected ISecurity G;
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected SpdyAgent f400w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected SpdySession f401x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected volatile boolean f402y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected long f403z;

    /* JADX INFO: compiled from: Taobao */
    private class a extends anet.channel.session.a {
        private Request b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RequestCb f404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f405d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f406e = 0;

        public a(Request request, RequestCb requestCb) {
            this.b = request;
            this.f404c = requestCb;
        }

        private void a(SuperviseData superviseData, int i2, String str) {
            try {
                this.b.a.rspEnd = System.currentTimeMillis();
                if (this.b.a.isDone.get()) {
                    return;
                }
                if (i2 > 0) {
                    this.b.a.ret = 1;
                }
                this.b.a.statusCode = i2;
                this.b.a.msg = str;
                if (superviseData != null) {
                    this.b.a.rspEnd = superviseData.responseEnd;
                    this.b.a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    this.b.a.sendDataTime = superviseData.sendEnd - this.b.a.sendStart;
                    this.b.a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.b.a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.b.a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.b.a.recDataSize = this.f406e + ((long) superviseData.recvUncompressSize);
                    this.b.a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.b.a.reqHeadDeflateSize = superviseData.compressSize;
                    this.b.a.reqBodyInflateSize = superviseData.bodySize;
                    this.b.a.reqBodyDeflateSize = superviseData.bodySize;
                    this.b.a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.b.a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.b.a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.b.a.rspBodyInflateSize = this.f406e;
                    if (this.b.a.contentLength == 0) {
                        this.b.a.contentLength = superviseData.originContentLength;
                    }
                    TnetSpdySession.this.f259q.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                    TnetSpdySession.this.f259q.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z2, long j2, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z2));
            }
            this.f406e += (long) spdyByteArray.getDataLength();
            this.b.a.recDataSize += (long) spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f404c != null) {
                ByteArray byteArrayA = a.C0005a.a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f404c.onDataReceive(byteArrayA, z2);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
            this.b.a.firstDataTime = System.currentTimeMillis() - this.b.a.sendStart;
            this.f405d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.b.getSeq(), "statusCode", Integer.valueOf(this.f405d));
            ALog.i("awcn.TnetSpdySession", "", this.b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f404c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f405d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.b.a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.b.a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.b.a.contentLength = HttpHelper.parseContentLength(map);
            this.b.a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.b, this.f405d);
            TnetSpdySession.this.handleResponseHeaders(this.b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
            String msg;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.b.getSeq(), "streamId", Long.valueOf(j2), "errorCode", Integer.valueOf(i2));
            }
            if (i2 != 0) {
                this.f405d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                msg = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i2));
                if (i2 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, msg, this.b.a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.b.getSeq(), com.umeng.analytics.pro.d.aw, TnetSpdySession.this.f258p, "status code", Integer.valueOf(i2), "URL", this.b.getHttpUrl().simpleUrlString());
            } else {
                msg = HttpConstant.SUCCESS;
            }
            this.b.a.tnetErrorCode = i2;
            a(superviseData, this.f405d, msg);
            RequestCb requestCb = this.f404c;
            if (requestCb != null) {
                requestCb.onFinish(this.f405d, msg, this.b.a);
            }
            if (i2 == -2004) {
                if (!TnetSpdySession.this.f402y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f246d, TnetSpdySession.this.f253k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        this.f402y = false;
        this.A = 0L;
        this.H = 0;
        this.B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = false;
    }

    static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i2 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i2;
        return i2;
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.f258p, com.umeng.analytics.pro.d.aw, this);
        notifyStatus(7, null);
        try {
            if (this.D != null) {
                this.D.stop();
                this.D = null;
            }
            if (this.f401x != null) {
                this.f401x.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    @Override // anet.channel.Session
    public void connect() {
        int xquicCongControl;
        int i2 = this.f256n;
        int i3 = 1;
        if (i2 == 1 || i2 == 0 || i2 == 4) {
            return;
        }
        try {
            if (this.f400w == null) {
                c();
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f247e)) {
                try {
                    this.f248f = anet.channel.util.c.a(this.f247e);
                } catch (Exception unused) {
                }
            }
            String strValueOf = String.valueOf(System.currentTimeMillis());
            ALog.e("awcn.TnetSpdySession", "connect", this.f258p, Constants.KEY_HOST, this.f245c, "ip", this.f248f, "port", Integer.valueOf(this.f249g), "sessionId", strValueOf, "SpdyProtocol,", this.f252j, "proxyIp,", this.f250h, "proxyPort,", Integer.valueOf(this.f251i));
            SessionInfo sessionInfo = new SessionInfo(this.f248f, this.f249g, this.f245c + "_" + this.F, this.f250h, this.f251i, strValueOf, this, this.f252j.getTnetConType());
            sessionInfo.setConnectionTimeoutMs((int) (((float) this.f260r) * Utils.getNetworkTimeFactor()));
            if (this.f252j.isPublicKeyAuto() || this.f252j.isH2S() || this.f252j.isHTTP3()) {
                sessionInfo.setCertHost(this.f255m ? this.f247e : this.f246d);
            } else if (this.B >= 0) {
                sessionInfo.setPubKeySeqNum(this.B);
            } else {
                this.B = this.f252j.getTnetPublicKey(this.G != null ? this.G.isSecOff() : true);
                sessionInfo.setPubKeySeqNum(this.B);
            }
            if (this.f252j.isHTTP3() && (xquicCongControl = AwcnConfig.getXquicCongControl()) >= 0) {
                sessionInfo.setXquicCongControl(xquicCongControl);
            }
            this.f401x = this.f400w.createSession(sessionInfo);
            if (this.f401x.getRefCount() > 1) {
                ALog.e("awcn.TnetSpdySession", "get session ref count > 1!!!", this.f258p, new Object[0]);
                notifyStatus(0, new anet.channel.entity.b(1));
                b();
                return;
            }
            notifyStatus(1, null);
            this.f403z = System.currentTimeMillis();
            SessionStatistic sessionStatistic = this.f259q;
            if (TextUtils.isEmpty(this.f250h)) {
                i3 = 0;
            }
            sessionStatistic.isProxy = i3;
            this.f259q.isTunnel = ITagManager.STATUS_FALSE;
            this.f259q.isBackground = GlobalAppRuntimeInfo.isAppBackground();
            this.A = 0L;
        } catch (Throwable th) {
            notifyStatus(2, null);
            ALog.e("awcn.TnetSpdySession", "connect exception ", this.f258p, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            if (this.G == null) {
                return null;
            }
            return this.G.getBytes(this.a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(anet.channel.SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f259q.isKL = 1L;
                this.f262t = true;
                this.D = sessionInfo.heartbeat;
                boolean z2 = sessionInfo.isAccs;
                this.I = z2;
                if (this.D == null) {
                    if (!z2 || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new anet.channel.heartbeat.c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f256n == 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public void onDisconnect() {
        this.f402y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z2) {
        ping(z2, this.f261s);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            if (this.G == null) {
                return -1;
            }
            ISecurity iSecurity = this.G;
            Context context = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        String str;
        SpdyRequest spdyRequest;
        anet.channel.request.c cVar = anet.channel.request.c.NULL;
        RequestStatistic requestStatistic = request != null ? request.a : new RequestStatistic(this.f246d, null);
        requestStatistic.setConnType(this.f252j);
        if (requestStatistic.start == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = jCurrentTimeMillis;
            requestStatistic.start = jCurrentTimeMillis;
        }
        requestStatistic.setIPAndPort(this.f248f, this.f249g);
        requestStatistic.ipRefer = this.f253k.getIpSource();
        requestStatistic.ipType = this.f253k.getIpType();
        requestStatistic.unit = this.f254l;
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), requestStatistic);
            }
            return cVar;
        }
        try {
            if (this.f401x == null || !(this.f256n == 0 || this.f256n == 4)) {
                requestCb.onFinish(ErrorConstant.ERROR_SESSION_INVALID, ErrorConstant.getErrMsg(ErrorConstant.ERROR_SESSION_INVALID), request.a);
                return cVar;
            }
            if (this.f255m) {
                request.setDnsOptimize(this.f247e, this.f249g);
            }
            request.setUrlScheme(this.f252j.isSSL());
            URL url = request.getUrl();
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request URL", url.toString());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request Method", request.getMethod());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request headers", request.getHeaders());
            }
            if (TextUtils.isEmpty(this.f250h) || this.f251i <= 0) {
                str = "";
                spdyRequest = new SpdyRequest(url, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout());
            } else {
                str = "";
                spdyRequest = new SpdyRequest(url, url.getHost(), url.getPort(), this.f250h, this.f251i, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout(), 0);
            }
            spdyRequest.setRequestRdTimeoutMs(request.getReadTimeout());
            Map<String, String> headers = request.getHeaders();
            if (headers.containsKey(HttpConstant.HOST)) {
                HashMap map = new HashMap(request.getHeaders());
                String strRemove = map.remove(HttpConstant.HOST);
                if (this.f255m) {
                    strRemove = this.f247e;
                }
                map.put(":host", strRemove);
                spdyRequest.addHeaders(map);
            } else {
                spdyRequest.addHeaders(headers);
                spdyRequest.addHeader(":host", this.f255m ? this.f247e : request.getHost());
            }
            SpdyDataProvider spdyDataProvider = new SpdyDataProvider(request.getBodyBytes());
            request.a.sendStart = System.currentTimeMillis();
            request.a.processTime = request.a.sendStart - request.a.start;
            int iSubmitRequest = this.f401x.submitRequest(spdyRequest, spdyDataProvider, this, new a(request, requestCb));
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", str, request.getSeq(), "streamId", Integer.valueOf(iSubmitRequest));
            }
            anet.channel.request.c cVar2 = new anet.channel.request.c(this.f401x, iSubmitRequest, request.getSeq());
            try {
                this.f259q.requestCount++;
                this.f259q.stdRCount++;
                this.f403z = System.currentTimeMillis();
                if (this.D != null) {
                    this.D.reSchedule();
                }
                return cVar2;
            } catch (SpdyErrorException e2) {
                e = e2;
                cVar = cVar2;
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f258p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
                return cVar;
            } catch (Exception unused) {
                cVar = cVar2;
                requestCb.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.getErrMsg(ErrorConstant.ERROR_EXCEPTION), requestStatistic);
                return cVar;
            }
        } catch (SpdyErrorException e3) {
            e = e3;
        } catch (Exception unused2) {
        }
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
        try {
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f258p, Constants.KEY_DATA_ID, Integer.valueOf(i2), "type", Integer.valueOf(i3));
            if (this.f256n != 4 || this.f401x == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.f258p, "sendCustomFrame con invalid mStatus:" + this.f256n);
                a(i2, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                return;
            }
            if (bArr != null && bArr.length > 16384) {
                a(i2, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                return;
            }
            this.f401x.sendCustomControlFrame(i2, i3, 0, bArr == null ? 0 : bArr.length, bArr);
            this.f259q.requestCount++;
            this.f259q.cfRCount++;
            this.f403z = System.currentTimeMillis();
            if (this.D != null) {
                this.D.reSchedule();
            }
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f258p, e2, new Object[0]);
            a(i2, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e2.toString());
        } catch (Exception e3) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.f258p, e3, new Object[0]);
            a(i2, ErrorConstant.ERROR_EXCEPTION, true, e3.toString());
        }
    }

    public void setTnetPublicKey(int i2) {
        this.B = i2;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.f258p, Constants.KEY_DATA_ID, Integer.valueOf(i2));
        a(i2, i3, true, "tnet error");
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.f258p, "len", Integer.valueOf(i5), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i5 < 512) {
            String str = "";
            for (byte b : bArr) {
                str = str + Integer.toHexString(b & 255) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.f258p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i2, i3);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.f258p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL, null, "rt"));
        }
        this.f259q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j2, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.f258p, HttpConstant.HOST, this.f245c, "id", Long.valueOf(j2));
        }
        if (j2 < 0) {
            return;
        }
        this.f402y = false;
        this.H = 0;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.f258p, " errorCode:", Integer.valueOf(i2));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", null, e2, new Object[0]);
            }
        }
        if (i2 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f246d, this.f253k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f259q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.f252j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.f258p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f259q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f259q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f259q.lossRate = superviseConnectInfo.lossRate;
                    this.f259q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f259q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f259q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f259q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i2;
        }
        this.f259q.lastPingInterval = (int) (System.currentTimeMillis() - this.f403z);
        AppMonitor.getInstance().commitStat(this.f259q);
        if (anet.channel.strategy.utils.c.b(this.f259q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f259q));
        }
        AppMonitor.getInstance().commitAlarm(this.f259q.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f259q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new anet.channel.entity.b(1));
        b();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.f258p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.f252j.isHTTP3()) {
            this.f259q.scid = superviseConnectInfo.scid;
            this.f259q.dcid = superviseConnectInfo.dcid;
            this.f259q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.f258p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e2, new Object[0]);
            }
        }
        notifyStatus(2, new anet.channel.entity.b(256, i2, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.f258p, " errorId:", Integer.valueOf(i2));
        SessionStatistic sessionStatistic = this.f259q;
        sessionStatistic.errorCode = i2;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f259q);
        if (anet.channel.strategy.utils.c.b(this.f259q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f259q));
        }
        AppMonitor.getInstance().commitAlarm(this.f259q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z2, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.f258p, Constants.KEY_HOST, this.f245c, "thread", Thread.currentThread().getName());
        }
        if (z2) {
            try {
                if (this.f401x == null) {
                    if (this.f259q != null) {
                        this.f259q.closeReason = "session null";
                    }
                    ALog.e("awcn.TnetSpdySession", this.f245c + " session null", this.f258p, new Object[0]);
                    close();
                    return;
                }
                if (this.f256n == 0 || this.f256n == 4) {
                    handleCallbacks(64, null);
                    if (this.f402y) {
                        return;
                    }
                    this.f402y = true;
                    this.f259q.ppkgCount++;
                    this.f401x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", this.f245c + " submit ping ms:" + (System.currentTimeMillis() - this.f403z) + " force:" + z2, this.f258p, new Object[0]);
                    }
                    setPingTimeout(i2);
                    this.f403z = System.currentTimeMillis();
                    if (this.D != null) {
                        this.D.reSchedule();
                    }
                }
            } catch (SpdyErrorException e2) {
                if (e2.SpdyErrorGetCode() == -1104 || e2.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.f258p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.f258p, e2, new Object[0]);
            } catch (Exception e3) {
                ALog.e("awcn.TnetSpdySession", "ping", this.f258p, e3, new Object[0]);
            }
        }
    }

    private void c() {
        SpdyAgent.enableDebug = false;
        this.f400w = SpdyAgent.getInstance(this.a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.f400w.setAccsSslCallback(new j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.f400w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.f400w, new Object[0]);
            ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e2) {
            ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e2, new Object[0]);
        }
    }

    protected void b() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, null);
        this.f259q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    private void a(int i2, int i3, boolean z2, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i2, i3, z2, str);
        }
    }
}
