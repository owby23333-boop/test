package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d extends Session {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private SSLSocketFactory f410w;

    public d(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        if (this.f253k == null) {
            String str = this.f245c;
            this.f252j = (str == null || !str.startsWith("https")) ? ConnType.HTTP : ConnType.HTTPS;
        } else if (AwcnConfig.isHttpsSniEnable() && this.f252j.equals(ConnType.HTTPS)) {
            this.f410w = new anet.channel.util.j(this.f246d);
        }
    }

    @Override // anet.channel.Session
    public void close() {
        notifyStatus(6, null);
    }

    @Override // anet.channel.Session
    public void connect() {
        try {
            if (this.f253k != null && this.f253k.getIpSource() == 1) {
                notifyStatus(4, new anet.channel.entity.b(1));
                return;
            }
            Request.Builder redirectEnable = new Request.Builder().setUrl(this.f245c).setSeq(this.f258p).setConnectTimeout((int) (this.f260r * Utils.getNetworkTimeFactor())).setReadTimeout((int) (this.f261s * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
            if (this.f410w != null) {
                redirectEnable.setSslSocketFactory(this.f410w);
            }
            if (this.f255m) {
                redirectEnable.addHeader(HttpConstant.HOST, this.f247e);
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f247e)) {
                try {
                    this.f248f = anet.channel.util.c.a(this.f247e);
                } catch (Exception unused) {
                }
            }
            ALog.i("awcn.HttpSession", "HttpSession connect", null, Constants.KEY_HOST, this.f245c, "ip", this.f248f, "port", Integer.valueOf(this.f249g));
            Request requestBuild = redirectEnable.build();
            requestBuild.setDnsOptimize(this.f248f, this.f249g);
            ThreadPoolExecutorFactory.submitPriorityTask(new e(this, requestBuild), ThreadPoolExecutorFactory.Priority.LOW);
        } catch (Throwable th) {
            ALog.e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.f256n == 4;
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        anet.channel.request.b bVar = anet.channel.request.b.NULL;
        Request.Builder builderNewBuilder = null;
        RequestStatistic requestStatistic = request != null ? request.a : new RequestStatistic(this.f246d, null);
        requestStatistic.setConnType(this.f252j);
        if (requestStatistic.start == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = jCurrentTimeMillis;
            requestStatistic.start = jCurrentTimeMillis;
        }
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), requestStatistic);
            }
            return bVar;
        }
        try {
            if (request.getSslSocketFactory() == null && this.f410w != null) {
                builderNewBuilder = request.newBuilder().setSslSocketFactory(this.f410w);
            }
            if (this.f255m) {
                if (builderNewBuilder == null) {
                    builderNewBuilder = request.newBuilder();
                }
                builderNewBuilder.addHeader(HttpConstant.HOST, this.f247e);
            }
            if (builderNewBuilder != null) {
                request = builderNewBuilder.build();
            }
            if (this.f248f == null) {
                String strHost = request.getHttpUrl().host();
                if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(strHost)) {
                    try {
                        this.f248f = anet.channel.util.c.a(strHost);
                    } catch (Exception unused) {
                    }
                }
            }
            request.setDnsOptimize(this.f248f, this.f249g);
            request.setUrlScheme(this.f252j.isSSL());
            if (this.f253k != null) {
                request.a.setIpInfo(this.f253k.getIpSource(), this.f253k.getIpType());
            } else {
                request.a.setIpInfo(1, 1);
            }
            request.a.unit = this.f254l;
            return new anet.channel.request.b(ThreadPoolExecutorFactory.submitPriorityTask(new f(this, request, requestCb, requestStatistic), anet.channel.util.h.a(request)), request.getSeq());
        } catch (Throwable th) {
            if (requestCb == null) {
                return bVar;
            }
            requestCb.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, th.toString()), requestStatistic);
            return bVar;
        }
    }

    @Override // anet.channel.Session
    public void close(boolean z2) {
        this.f262t = false;
        close();
    }
}
