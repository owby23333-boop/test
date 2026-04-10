package me.jessyan.retrofiturlmanager;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.retrofiturlmanager.e.e;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RetrofitUrlManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f21255i;
    private HttpUrl a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f21256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, HttpUrl> f21258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interceptor f21259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<d> f21260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f21261h;

    /* JADX INFO: renamed from: me.jessyan.retrofiturlmanager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RetrofitUrlManager.java */
    /* JADX INFO: loaded from: classes3.dex */
    class C0585a implements Interceptor {
        C0585a() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return !a.this.e() ? chain.proceed(request) : chain.proceed(a.this.b(request));
        }
    }

    /* JADX INFO: compiled from: RetrofitUrlManager.java */
    /* JADX INFO: loaded from: classes3.dex */
    private static class b {
        private static final a a = new a(null);
    }

    static {
        boolean z2;
        try {
            Class.forName("okhttp3.OkHttpClient");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f21255i = z2;
    }

    /* synthetic */ a(C0585a c0585a) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request b(Request request) {
        HttpUrl httpUrlB;
        if (request == null) {
            return null;
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        String url = request.url().getUrl();
        if (url.contains("#url_ignore")) {
            return a(builderNewBuilder, url);
        }
        String strA = a(request);
        Object[] objArrG = g();
        if (TextUtils.isEmpty(strA)) {
            a(request, "me.jessyan.retrofiturlmanager.globalDomainName", objArrG);
            httpUrlB = b();
        } else {
            a(request, strA, objArrG);
            httpUrlB = a(strA);
            builderNewBuilder.removeHeader("Domain-Name");
        }
        if (httpUrlB == null) {
            return builderNewBuilder.build();
        }
        HttpUrl httpUrlA = this.f21261h.a(httpUrlB, request.url());
        String url2 = httpUrlA.getUrl();
        if (this.f21257d) {
            String str = "The new url is { " + url2 + " }, old url is { " + request.url().getUrl() + " }";
        }
        if (objArrG != null) {
            for (Object obj : objArrG) {
                ((d) obj).a(httpUrlA, request.url());
            }
        }
        String strHeader = request.header("fc-session-id");
        if (this.f21257d) {
            String str2 = "diversion:" + strHeader;
        }
        if (strHeader != null && !TextUtils.isEmpty(strHeader) && !TextUtils.isEmpty(url2) && (url2.startsWith("https://my") || url2.startsWith("http://my"))) {
            String strHeader2 = request.header("token");
            if (this.f21257d) {
                String str3 = "my domain,token:" + strHeader2;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            builderNewBuilder.removeHeader(Constants.KEY_PACKAGE);
            builderNewBuilder.removeHeader("stamp");
            builderNewBuilder.removeHeader("time");
            builderNewBuilder.removeHeader("sign");
            builderNewBuilder.addHeader(Constants.KEY_PACKAGE, strHeader).addHeader("stamp", "").addHeader("time", String.valueOf(jCurrentTimeMillis)).addHeader("sign", a(jCurrentTimeMillis, strHeader2, strHeader));
        }
        return builderNewBuilder.url(httpUrlA).build();
    }

    public static final a f() {
        return b.a;
    }

    private Object[] g() {
        Object[] array;
        synchronized (this.f21260g) {
            array = this.f21260g.size() > 0 ? this.f21260g.toArray() : null;
        }
        return array;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.a != null;
    }

    public boolean e() {
        return this.f21256c;
    }

    private a() {
        this.f21256c = true;
        this.f21257d = false;
        this.f21258e = new HashMap();
        this.f21260g = new ArrayList();
        if (!f21255i) {
            throw new IllegalStateException("Must be dependency Okhttp");
        }
        me.jessyan.retrofiturlmanager.e.b bVar = new me.jessyan.retrofiturlmanager.e.b();
        bVar.a(this);
        a(bVar);
        this.f21259f = new C0585a();
    }

    public OkHttpClient.Builder a(OkHttpClient.Builder builder) {
        me.jessyan.retrofiturlmanager.b.a(builder, "builder cannot be null");
        return builder.addInterceptor(this.f21259f);
    }

    public static String a(long j2, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return b(str2 + "1" + j2 + "vhjJVz1St6tK7!8n#B0MqRIuE2Dh7!C#");
        }
        return b(str2 + str + "1" + j2 + "vhjJVz1St6tK7!8n#B0MqRIuE2Dh7!C#");
    }

    private Request a(Request.Builder builder, String str) {
        String[] strArrSplit = str.split("#url_ignore");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(str2);
        }
        return builder.url(stringBuffer.toString()).build();
    }

    private void a(Request request, String str, Object[] objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                ((d) obj).a(request.url(), str);
            }
        }
    }

    public HttpUrl a() {
        return this.a;
    }

    public void a(String str, String str2) {
        me.jessyan.retrofiturlmanager.b.a(str, "domainName cannot be null");
        me.jessyan.retrofiturlmanager.b.a(str2, "domainUrl cannot be null");
        synchronized (this.f21258e) {
            this.f21258e.put(str, me.jessyan.retrofiturlmanager.b.a(str2));
        }
    }

    public synchronized HttpUrl a(String str) {
        me.jessyan.retrofiturlmanager.b.a(str, "domainName cannot be null");
        return this.f21258e.get(str);
    }

    public void a(e eVar) {
        me.jessyan.retrofiturlmanager.b.a(eVar, "parser cannot be null");
        this.f21261h = eVar;
    }

    private String a(Request request) {
        List<String> listHeaders = request.headers("Domain-Name");
        if (listHeaders == null || listHeaders.size() == 0) {
            return null;
        }
        if (listHeaders.size() <= 1) {
            return request.header("Domain-Name");
        }
        throw new IllegalArgumentException("Only one Domain-Name in the headers");
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            int length = bArrDigest.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = bArrDigest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public synchronized HttpUrl b() {
        return this.f21258e.get("me.jessyan.retrofiturlmanager.globalDomainName");
    }
}
