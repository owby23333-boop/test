package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";
    public final RequestStatistic a;
    private HttpUrl b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpUrl f365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpUrl f366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private URL f367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BodyEntry f372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private HostnameVerifier f379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SSLSocketFactory f380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f381s;

    /* JADX INFO: compiled from: Taobao */
    public static class Builder {
        private HttpUrl a;
        private HttpUrl b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, String> f384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private BodyEntry f386g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private HostnameVerifier f389j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private SSLSocketFactory f390k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f391l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f392m;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f396q;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f382c = "GET";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, String> f383d = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f387h = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f388i = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f393n = 10000;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f394o = 10000;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private RequestStatistic f395p = null;

        public Builder addHeader(String str, String str2) {
            this.f383d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f384e == null) {
                this.f384e = new HashMap();
            }
            this.f384e.put(str, str2);
            this.b = null;
            return this;
        }

        public Request build() {
            if (this.f386g == null && this.f384e == null && Method.a(this.f382c)) {
                ALog.e("awcn.Request", "method " + this.f382c + " must have a request body", null, new Object[0]);
            }
            if (this.f386g != null && !Method.b(this.f382c)) {
                ALog.e("awcn.Request", "method " + this.f382c + " should not have a request body", null, new Object[0]);
                this.f386g = null;
            }
            BodyEntry bodyEntry = this.f386g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f386g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z2) {
            this.f396q = z2;
            return this;
        }

        public Builder setBizId(String str) {
            this.f391l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f386g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f385f = str;
            this.b = null;
            return this;
        }

        public Builder setConnectTimeout(int i2) {
            if (i2 > 0) {
                this.f393n = i2;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f383d.clear();
            if (map != null) {
                this.f383d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f389j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f382c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f382c = "POST";
            } else if ("OPTIONS".equalsIgnoreCase(str)) {
                this.f382c = "OPTIONS";
            } else if ("HEAD".equalsIgnoreCase(str)) {
                this.f382c = "HEAD";
            } else if ("PUT".equalsIgnoreCase(str)) {
                this.f382c = "PUT";
            } else if ("DELETE".equalsIgnoreCase(str)) {
                this.f382c = "DELETE";
            } else {
                this.f382c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f384e = map;
            this.b = null;
            return this;
        }

        public Builder setReadTimeout(int i2) {
            if (i2 > 0) {
                this.f394o = i2;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z2) {
            this.f387h = z2;
            return this;
        }

        public Builder setRedirectTimes(int i2) {
            this.f388i = i2;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.f395p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f392m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f390k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.a = httpUrl;
            this.b = null;
            return this;
        }

        public Builder setUrl(String str) {
            this.a = HttpUrl.parse(str);
            this.b = null;
            if (this.a != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            return str.equals("POST") || str.equals("PUT");
        }

        static boolean b(String str) {
            return a(str) || str.equals("DELETE") || str.equals("OPTIONS");
        }
    }

    private Map<String, String> a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f369g) : this.f369g;
    }

    private void b() {
        String strA = anet.channel.strategy.utils.c.a(this.f370h, getContentEncoding());
        if (!TextUtils.isEmpty(strA)) {
            if (Method.a(this.f368f) && this.f372j == null) {
                try {
                    this.f372j = new ByteArrayEntry(strA.getBytes(getContentEncoding()));
                    this.f369g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String strUrlString = this.b.urlString();
                StringBuilder sb = new StringBuilder(strUrlString);
                if (sb.indexOf("?") == -1) {
                    sb.append('?');
                } else if (strUrlString.charAt(strUrlString.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(strA);
                HttpUrl httpUrl = HttpUrl.parse(sb.toString());
                if (httpUrl != null) {
                    this.f365c = httpUrl;
                }
            }
        }
        if (this.f365c == null) {
            this.f365c = this.b;
        }
    }

    public boolean containsBody() {
        return this.f372j != null;
    }

    public String getBizId() {
        return this.f374l;
    }

    public byte[] getBodyBytes() {
        if (this.f372j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.f377o;
    }

    public String getContentEncoding() {
        String str = this.f371i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f369g);
    }

    public String getHost() {
        return this.f365c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f379q;
    }

    public HttpUrl getHttpUrl() {
        return this.f365c;
    }

    public String getMethod() {
        return this.f368f;
    }

    public int getReadTimeout() {
        return this.f378p;
    }

    public int getRedirectTimes() {
        return this.f376n;
    }

    public String getSeq() {
        return this.f375m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f380r;
    }

    public URL getUrl() {
        if (this.f367e == null) {
            HttpUrl httpUrl = this.f366d;
            if (httpUrl == null) {
                httpUrl = this.f365c;
            }
            this.f367e = httpUrl.toURL();
        }
        return this.f367e;
    }

    public String getUrlString() {
        return this.f365c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.f381s;
    }

    public boolean isRedirectEnable() {
        return this.f373k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f382c = this.f368f;
        builder.f383d = a();
        builder.f384e = this.f370h;
        builder.f386g = this.f372j;
        builder.f385f = this.f371i;
        builder.f387h = this.f373k;
        builder.f388i = this.f376n;
        builder.f389j = this.f379q;
        builder.f390k = this.f380r;
        builder.a = this.b;
        builder.b = this.f365c;
        builder.f391l = this.f374l;
        builder.f392m = this.f375m;
        builder.f393n = this.f377o;
        builder.f394o = this.f378p;
        builder.f395p = this.a;
        builder.f396q = this.f381s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.f372j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i2) {
        if (str != null) {
            if (this.f366d == null) {
                this.f366d = new HttpUrl(this.f365c);
            }
            this.f366d.replaceIpAndPort(str, i2);
        } else {
            this.f366d = null;
        }
        this.f367e = null;
        this.a.setIPAndPort(str, i2);
    }

    public void setUrlScheme(boolean z2) {
        if (this.f366d == null) {
            this.f366d = new HttpUrl(this.f365c);
        }
        this.f366d.setScheme(z2 ? "https" : "http");
        this.f367e = null;
    }

    private Request(Builder builder) {
        this.f368f = "GET";
        this.f373k = true;
        this.f376n = 0;
        this.f377o = 10000;
        this.f378p = 10000;
        this.f368f = builder.f382c;
        this.f369g = builder.f383d;
        this.f370h = builder.f384e;
        this.f372j = builder.f386g;
        this.f371i = builder.f385f;
        this.f373k = builder.f387h;
        this.f376n = builder.f388i;
        this.f379q = builder.f389j;
        this.f380r = builder.f390k;
        this.f374l = builder.f391l;
        this.f375m = builder.f392m;
        this.f377o = builder.f393n;
        this.f378p = builder.f394o;
        this.b = builder.a;
        this.f365c = builder.b;
        if (this.f365c == null) {
            b();
        }
        this.a = builder.f395p != null ? builder.f395p : new RequestStatistic(getHost(), this.f374l);
        this.f381s = builder.f396q;
    }
}
