package com.yuewen;

import android.content.Context;
import java.net.URI;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
public class sg1 {
    public static sg1 d = new sg1(com.duokan.core.app.b.get());
    public static final ThreadSafeClientConnManager e;
    public static final /* synthetic */ boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17446a;
    public final HashMap<String, DefaultHttpClient> c = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultHttpClient f17447b = e("", a.f17448a);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f17448a = "Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17449b = 20000;
        public static final int c = 20000;
        public static final int d = 100;
        public static final int e = 50;
    }

    public static class b extends DefaultRedirectHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ boolean f17450a = false;

        @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
        public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
            URI uriResolve;
            HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
            try {
                uriResolve = URIUtils.resolve(new URI(httpHost.toURI()), super.getLocationURI(httpResponse, httpContext));
            } catch (Exception e) {
                e.printStackTrace();
                uriResolve = null;
            }
            if (uriResolve == null || fh1.e(uriResolve.toString())) {
                try {
                    String value = httpResponse.getFirstHeader("Location").getValue();
                    if (value == null) {
                        return null;
                    }
                    uriResolve = URIUtils.resolve(new URI(httpHost.toURI()), new URI(fh1.h(httpResponse, value)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (uriResolve != null) {
                httpContext.setAttribute("_http.redirect_location", uriResolve.toString());
                if (httpResponse.getStatusLine().getStatusCode() == 301) {
                    httpContext.setAttribute("_http.permanent_redirect_location", uriResolve.toString());
                }
            }
            return uriResolve;
        }

        @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return super.isRedirectRequested(httpResponse, httpContext);
        }

        public b() {
        }
    }

    public class c extends DefaultHttpClient {
        public c(ThreadSafeClientConnManager threadSafeClientConnManager, HttpParams httpParams) {
            super(threadSafeClientConnManager, httpParams);
        }

        @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
        public HttpContext createHttpContext() {
            if (com.duokan.core.app.b.get() == null || com.duokan.core.app.b.get().isWebAccessEnabled()) {
                return super.createHttpContext();
            }
            throw new RuntimeException("http connection is disabled.");
        }
    }

    static {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        e = new ThreadSafeClientConnManager(c(null), schemeRegistry);
    }

    public sg1(Context context) {
        this.f17446a = context;
    }

    public static sg1 a() {
        return d;
    }

    public static BasicHttpParams c(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        if (str != null) {
            HttpProtocolParams.setUserAgent(basicHttpParams, str);
        }
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        ConnManagerParams.setTimeout(basicHttpParams, 60000L);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 100);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(50));
        return basicHttpParams;
    }

    public synchronized DefaultHttpClient b() {
        return this.f17447b;
    }

    public synchronized DefaultHttpClient d(String str) {
        return e(str, a.f17448a);
    }

    public synchronized DefaultHttpClient e(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (this.c.containsKey(str)) {
            return null;
        }
        BasicHttpParams basicHttpParamsC = c(str2);
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        c cVar = new c(e, basicHttpParamsC);
        cVar.setRedirectHandler(new b());
        this.c.put(str, cVar);
        return cVar;
    }
}
