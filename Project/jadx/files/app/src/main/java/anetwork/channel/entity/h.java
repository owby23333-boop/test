package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private ParcelableRequest a;
    private Request b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f586d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RequestStatistic f588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f593k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f585c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f587e = 0;

    public h(ParcelableRequest parcelableRequest, int i2, boolean z2) {
        this.b = null;
        this.f586d = 0;
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.a = parcelableRequest;
        this.f592j = i2;
        this.f593k = z2;
        this.f591i = d.a.p.a.a(parcelableRequest.E, this.f592j == 0 ? "HTTP" : "DGRD");
        int i3 = parcelableRequest.B;
        this.f589g = i3 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i3;
        int i4 = parcelableRequest.C;
        this.f590h = i4 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i4;
        int i5 = parcelableRequest.f525u;
        this.f586d = (i5 < 0 || i5 > 3) ? 2 : i5;
        HttpUrl httpUrlL = l();
        this.f588f = new RequestStatistic(httpUrlL.host(), String.valueOf(parcelableRequest.D));
        this.f588f.url = httpUrlL.simpleUrlString();
        this.b = b(httpUrlL);
    }

    private Request b(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.a.f529y).setBody(this.a.f524t).setReadTimeout(this.f590h).setConnectTimeout(this.f589g).setRedirectEnable(this.a.f528x).setRedirectTimes(this.f585c).setBizId(this.a.D).setSeq(this.f591i).setRequestStatistic(this.f588f);
        requestStatistic.setParams(this.a.A);
        String str = this.a.f527w;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(c(httpUrl));
        return requestStatistic.build();
    }

    private HttpUrl l() {
        HttpUrl httpUrl = HttpUrl.parse(this.a.f526v);
        if (httpUrl == null) {
            throw new IllegalArgumentException("url is invalid. url=" + this.a.f526v);
        }
        if (!d.a.j.b.m()) {
            ALog.i("anet.RequestConfig", "request ssl disabled.", this.f591i, new Object[0]);
            httpUrl.downgradeSchemeAndLock();
        } else if (ITagManager.STATUS_FALSE.equalsIgnoreCase(this.a.a("EnableSchemeReplace"))) {
            httpUrl.lockScheme();
        }
        return httpUrl;
    }

    public Request a() {
        return this.b;
    }

    public boolean c() {
        return this.f593k;
    }

    public boolean d() {
        return this.f587e < this.f586d;
    }

    public boolean e() {
        return d.a.j.b.j() && !ITagManager.STATUS_FALSE.equalsIgnoreCase(this.a.a("EnableHttpDns")) && (d.a.j.b.d() || this.f587e == 0);
    }

    public HttpUrl f() {
        return this.b.getHttpUrl();
    }

    public String g() {
        return this.b.getUrlString();
    }

    public Map<String, String> h() {
        return this.b.getHeaders();
    }

    public boolean i() {
        return !ITagManager.STATUS_FALSE.equalsIgnoreCase(this.a.a("EnableCookie"));
    }

    public boolean j() {
        return ITagManager.STATUS_TRUE.equals(this.a.a("CheckContentLength"));
    }

    public void k() {
        this.f587e++;
        this.f588f.retryTimes = this.f587e;
    }

    private Map<String, String> c(HttpUrl httpUrl) {
        String strHost = httpUrl.host();
        boolean z2 = !anet.channel.strategy.utils.c.a(strHost);
        if (strHost.length() > 2 && strHost.charAt(0) == '[' && strHost.charAt(strHost.length() - 1) == ']' && anet.channel.strategy.utils.c.b(strHost.substring(1, strHost.length() - 1))) {
            z2 = false;
        }
        HashMap map = new HashMap();
        Map<String, String> map2 = this.a.f530z;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                if (!HttpConstant.HOST.equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean zEqualsIgnoreCase = ITagManager.STATUS_TRUE.equalsIgnoreCase(this.a.a("KeepCustomCookie"));
                    if (!HttpConstant.COOKIE.equalsIgnoreCase(key) || zEqualsIgnoreCase) {
                        map.put(key, entry.getValue());
                    }
                } else if (!z2) {
                    map.put(HttpConstant.HOST, entry.getValue());
                }
            }
        }
        return map;
    }

    public void a(Request request) {
        this.b = request;
    }

    public String a(String str) {
        return this.a.a(str);
    }

    public void a(HttpUrl httpUrl) {
        ALog.i("anet.RequestConfig", "redirect", this.f591i, "to url", httpUrl.toString());
        this.f585c++;
        this.f588f.url = httpUrl.simpleUrlString();
        this.b = b(httpUrl);
    }

    public int b() {
        return this.f590h * (this.f586d + 1);
    }
}
