package me.jessyan.progressmanager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: ProgressManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile b f21215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f21216g;
    private final Map<String, List<me.jessyan.progressmanager.a>> a = new WeakHashMap();
    private final Map<String, List<me.jessyan.progressmanager.a>> b = new WeakHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21219e = TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f21217c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Interceptor f21218d = new a();

    /* JADX INFO: compiled from: ProgressManager.java */
    class a implements Interceptor {
        a() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            b bVar = b.this;
            return bVar.a(chain.proceed(bVar.a(chain.request())));
        }
    }

    static {
        boolean z2;
        try {
            Class.forName("okhttp3.OkHttpClient");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f21216g = z2;
    }

    private b() {
    }

    public static final b a() {
        if (f21215f == null) {
            if (!f21216g) {
                throw new IllegalStateException("Must be dependency Okhttp");
            }
            synchronized (b.class) {
                if (f21215f == null) {
                    f21215f = new b();
                }
            }
        }
        return f21215f;
    }

    private boolean b(Response response) {
        String strValueOf = String.valueOf(response.code());
        if (TextUtils.isEmpty(strValueOf)) {
            return false;
        }
        return strValueOf.contains("301") || strValueOf.contains("302") || strValueOf.contains("303") || strValueOf.contains("307");
    }

    public OkHttpClient.Builder a(OkHttpClient.Builder builder) {
        return builder.addNetworkInterceptor(this.f21218d);
    }

    public Request a(Request request) {
        if (request == null) {
            return request;
        }
        String url = request.url().getUrl();
        Request requestA = a(url, request);
        if (requestA.body() == null || !this.a.containsKey(url)) {
            return requestA;
        }
        return requestA.newBuilder().method(requestA.method(), new me.jessyan.progressmanager.body.a(this.f21217c, requestA.body(), this.a.get(url), this.f21219e)).build();
    }

    private Request a(String str, Request request) {
        return !str.contains("?JessYan=") ? request : request.newBuilder().url(str.substring(0, str.indexOf("?JessYan="))).header("JessYan", str).build();
    }

    public Response a(Response response) {
        if (response == null) {
            return response;
        }
        String url = response.request().url().getUrl();
        if (!TextUtils.isEmpty(response.request().header("JessYan"))) {
            url = response.request().header("JessYan");
        }
        if (b(response)) {
            a(this.a, response, url);
            return a(response, a(this.b, response, url));
        }
        if (response.body() == null || !this.b.containsKey(url)) {
            return response;
        }
        return response.newBuilder().body(new me.jessyan.progressmanager.body.b(this.f21217c, response.body(), this.b.get(url), this.f21219e)).build();
    }

    private Response a(Response response, String str) {
        return (TextUtils.isEmpty(str) || !str.contains("?JessYan=")) ? response : response.newBuilder().header("Location", str).build();
    }

    private String a(Map<String, List<me.jessyan.progressmanager.a>> map, Response response, String str) {
        List<me.jessyan.progressmanager.a> list = map.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        String strHeader = response.header("Location");
        if (TextUtils.isEmpty(strHeader)) {
            return strHeader;
        }
        if (str.contains("?JessYan=") && !strHeader.contains("?JessYan=")) {
            strHeader = strHeader + str.substring(str.indexOf("?JessYan="), str.length());
        }
        if (!map.containsKey(strHeader)) {
            map.put(strHeader, list);
            return strHeader;
        }
        List<me.jessyan.progressmanager.a> list2 = map.get(strHeader);
        for (me.jessyan.progressmanager.a aVar : list) {
            if (!list2.contains(aVar)) {
                list2.add(aVar);
            }
        }
        return strHeader;
    }
}
