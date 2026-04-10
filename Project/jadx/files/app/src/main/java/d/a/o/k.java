package d.a.o;

import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ConnType;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import com.anythink.core.api.ATAdConst;
import com.arialyy.aria.core.inf.IOptionConstant;
import d.a.o.g;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class k implements RequestCb {
    final /* synthetic */ Request a;
    final /* synthetic */ RequestStatistic b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f20758c;

    k(g gVar, Request request, RequestStatistic requestStatistic) {
        this.f20758c = gVar;
        this.a = request;
        this.b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z2) {
        if (this.f20758c.f20744z.get()) {
            return;
        }
        g gVar = this.f20758c;
        if (gVar.B == 0) {
            ALog.i("anet.NetworkTask", "[onDataReceive] receive first data chunk!", gVar.f20737s.f20759c, new Object[0]);
        }
        if (z2) {
            ALog.i("anet.NetworkTask", "[onDataReceive] receive last data chunk!", this.f20758c.f20737s.f20759c, new Object[0]);
        }
        g gVar2 = this.f20758c;
        gVar2.B++;
        try {
            if (gVar2.E != null) {
                gVar2.E.f20745c.add(byteArray);
                if (this.b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z2) {
                    this.f20758c.B = this.f20758c.E.a(this.f20758c.f20737s.b, this.f20758c.A);
                    this.f20758c.C = true;
                    this.f20758c.D = this.f20758c.B > 1;
                    this.f20758c.E = null;
                }
            } else {
                gVar2.f20737s.b.a(gVar2.B, gVar2.A, byteArray);
                this.f20758c.D = true;
            }
            if (this.f20758c.f20740v != null) {
                this.f20758c.f20740v.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z2) {
                    String strG = this.f20758c.f20737s.a.g();
                    this.f20758c.f20739u.f560s = this.f20758c.f20740v.toByteArray();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.f20758c.f20738t.put(strG, this.f20758c.f20739u);
                    ALog.i("anet.NetworkTask", "write cache", this.f20758c.f20737s.f20759c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, Integer.valueOf(this.f20758c.f20739u.f560s.length), "key", strG);
                }
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkTask", "[onDataReceive] error.", this.f20758c.f20737s.f20759c, e2, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String strValueOf;
        DefaultFinishEvent defaultFinishEvent;
        if (this.f20758c.f20744z.getAndSet(true)) {
            return;
        }
        int i3 = 3;
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkTask", "[onFinish]", this.f20758c.f20737s.f20759c, "code", Integer.valueOf(i2), "msg", str);
        }
        if (i2 < 0) {
            try {
                if (this.f20758c.f20737s.a.d()) {
                    if (!this.f20758c.C && !this.f20758c.D) {
                        ALog.e("anet.NetworkTask", "clear response buffer and retry", this.f20758c.f20737s.f20759c, new Object[0]);
                        if (this.f20758c.E != null) {
                            if (!this.f20758c.E.f20745c.isEmpty()) {
                                i3 = 4;
                            }
                            requestStatistic.roaming = i3;
                            this.f20758c.E.a();
                            this.f20758c.E = null;
                        }
                        if (this.f20758c.f20737s.a.f587e == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i2;
                        }
                        this.f20758c.f20737s.a.k();
                        this.f20758c.f20737s.f20760d = new AtomicBoolean();
                        this.f20758c.f20737s.f20761e = new g(this.f20758c.f20737s, this.f20758c.f20738t, this.f20758c.f20739u);
                        if (requestStatistic.tnetErrorCode != 0) {
                            strValueOf = i2 + com.anythink.expressad.foundation.g.a.bQ + requestStatistic.protocolType + com.anythink.expressad.foundation.g.a.bQ + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            strValueOf = String.valueOf(i2);
                        }
                        requestStatistic.appendErrorTrace(strValueOf);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += jCurrentTimeMillis - requestStatistic.start;
                        requestStatistic.start = jCurrentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f20758c.f20737s.f20761e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":回调后触发重试";
                    if (this.f20758c.D) {
                        requestStatistic.roaming = 2;
                    } else if (this.f20758c.C) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.e("anet.NetworkTask", "Cannot retry request after onHeader/onDataReceived callback!", this.f20758c.f20737s.f20759c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (this.f20758c.E != null) {
            this.f20758c.E.a(this.f20758c.f20737s.b, this.f20758c.A);
        }
        this.f20758c.f20737s.a();
        requestStatistic.isDone.set(true);
        if (this.f20758c.f20737s.a.j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            ALog.e("anet.NetworkTask", "received data length not match with content-length", this.f20758c.f20737s.f20759c, "content-length", Integer.valueOf(this.f20758c.A), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f20758c.f20737s.a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            i2 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
        }
        if (i2 != 304 || this.f20758c.f20739u == null) {
            defaultFinishEvent = new DefaultFinishEvent(i2, str, this.a);
        } else {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.a);
        }
        this.f20758c.f20737s.b.a(defaultFinishEvent);
        if (i2 >= 0) {
            anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f20758c.f20741w, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f20758c.f20744z.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkTask", "onResponseCode", this.a.getSeq(), "code", Integer.valueOf(i2));
            ALog.i("anet.NetworkTask", "onResponseCode", this.a.getSeq(), IOptionConstant.headers, map);
        }
        if (HttpHelper.checkRedirect(this.a, i2) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl httpUrl = HttpUrl.parse(singleHeaderFieldByKey);
            if (httpUrl != null) {
                if (this.f20758c.f20744z.compareAndSet(false, true)) {
                    httpUrl.lockScheme();
                    this.f20758c.f20737s.a.a(httpUrl);
                    this.f20758c.f20737s.f20760d = new AtomicBoolean();
                    l lVar = this.f20758c.f20737s;
                    lVar.f20761e = new g(lVar, null, null);
                    this.b.recordRedirect(i2, httpUrl.simpleUrlString());
                    this.b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f20758c.f20737s.f20761e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.e("anet.NetworkTask", "redirect url is invalid!", this.a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f20758c.f20737s.a();
            d.a.k.a.a(this.f20758c.f20737s.a.g(), map);
            this.f20758c.A = HttpHelper.parseContentLength(map);
            String strG = this.f20758c.f20737s.a.g();
            if (this.f20758c.f20739u != null && i2 == 304) {
                this.f20758c.f20739u.f564w.putAll(map);
                Cache.Entry entryA = anetwork.channel.cache.c.a(map);
                if (entryA != null && entryA.f563v > this.f20758c.f20739u.f563v) {
                    this.f20758c.f20739u.f563v = entryA.f563v;
                }
                this.f20758c.f20737s.b.onResponseCode(200, this.f20758c.f20739u.f564w);
                this.f20758c.f20737s.b.a(1, this.f20758c.f20739u.f560s.length, ByteArray.wrap(this.f20758c.f20739u.f560s));
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f20758c.f20738t.put(strG, this.f20758c.f20739u);
                ALog.i("anet.NetworkTask", "update cache", this.f20758c.f20737s.f20759c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "key", strG);
                return;
            }
            if (this.f20758c.f20738t != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f20758c.f20738t.remove(strG);
                } else {
                    g gVar = this.f20758c;
                    Cache.Entry entryA2 = anetwork.channel.cache.c.a(map);
                    gVar.f20739u = entryA2;
                    if (entryA2 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        this.f20758c.f20740v = new ByteArrayOutputStream(this.f20758c.A != 0 ? this.f20758c.A : 5120);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.b.protocolType));
            if (!ConnType.PK_OPEN.equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && d.a.j.b.l() && this.f20758c.A <= 131072) {
                this.f20758c.E = new g.a(i2, map);
            } else {
                this.f20758c.f20737s.b.onResponseCode(i2, map);
                this.f20758c.C = true;
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkTask", "[onResponseCode] error.", this.f20758c.f20737s.f20759c, e2, new Object[0]);
        }
    }
}
