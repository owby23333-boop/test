package com.funny.audio.core.net;

import android.app.Application;
import android.net.TrafficStats;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: ApiServiceFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/funny/audio/core/net/ApiServiceFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_client", "Lokhttp3/OkHttpClient;", "cacheControlInterceptor", "Lokhttp3/Interceptor;", "cacheDir", "getCacheDir", "staticApiInterceptor", "staticBaseUrlMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "createService", ExifInterface.GPS_DIRECTION_TRUE, "app", "Landroid/app/Application;", NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/Class;", "baseUrl", "staticBaseUrl", "(Landroid/app/Application;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "getHttpClient", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApiServiceFactory {
    private static OkHttpClient _client;
    public static final ApiServiceFactory INSTANCE = new ApiServiceFactory();
    private static final String cacheDir = "httpCaches";
    private static HashMap<String, String> staticBaseUrlMap = new HashMap<>();
    private static final String TAG = "API";
    private static Interceptor cacheControlInterceptor = new Interceptor() { // from class: com.funny.audio.core.net.ApiServiceFactory$$ExternalSyntheticLambda0
        @Override // okhttp3.Interceptor
        public final okhttp3.Response intercept(Interceptor.Chain chain) {
            return ApiServiceFactory.cacheControlInterceptor$lambda$0(chain);
        }
    };
    private static Interceptor staticApiInterceptor = new Interceptor() { // from class: com.funny.audio.core.net.ApiServiceFactory$$ExternalSyntheticLambda1
        @Override // okhttp3.Interceptor
        public final okhttp3.Response intercept(Interceptor.Chain chain) {
            return ApiServiceFactory.staticApiInterceptor$lambda$1(chain);
        }
    };

    private ApiServiceFactory() {
    }

    public final String getCacheDir() {
        return cacheDir;
    }

    public final String getTAG() {
        return TAG;
    }

    public static /* synthetic */ Object createService$default(ApiServiceFactory apiServiceFactory, Application application, Class cls, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return apiServiceFactory.createService(application, cls, str, str2);
    }

    public final <T> T createService(Application app, Class<T> service, String baseUrl, String staticBaseUrl) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        String str = StringsKt.trimEnd(baseUrl, '/') + "/";
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(str).client(getHttpClient(app)).addConverterFactory(CryptoConverterFactory.INSTANCE.create()).addCallAdapterFactory(new DirectCallAdapterFactory()).build();
        URI uri = new URI(str);
        String str2 = uri.getHost() + uri.getPort();
        if (!staticBaseUrlMap.containsKey(str2)) {
            String str3 = staticBaseUrl;
            if (!(str3 == null || str3.length() == 0)) {
                staticBaseUrlMap.put(str2, StringsKt.trimEnd(staticBaseUrl, '/') + "/");
            }
        }
        return (T) retrofitBuild.create(service);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final okhttp3.Response cacheControlInterceptor$lambda$0(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        okhttp3.Response responseProceed = chain.proceed(request);
        String string = responseProceed.cacheControl().toString();
        String str = string;
        if (str == null || str.length() == 0) {
            string = request.cacheControl().toString();
        }
        return responseProceed.isSuccessful() ? responseProceed.newBuilder().header(HttpHeaders.CACHE_CONTROL, string).removeHeader(HttpHeaders.PRAGMA).build() : responseProceed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final okhttp3.Response staticApiInterceptor$lambda$1(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl httpUrlUrl = request.url();
        String url = httpUrlUrl.getUrl();
        URI uri = new URI(url);
        String str = staticBaseUrlMap.get(uri.getHost() + uri.getPort());
        CacheControl cacheControl = request.cacheControl();
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            if (StringsKt.startsWith$default(url, str, false, 2, (Object) null)) {
                return chain.proceed(request);
            }
            if (StringsKt.endsWith$default(url, ".json", false, 2, (Object) null)) {
                String strTrimStart = StringsKt.trimStart(httpUrlUrl.encodedPath(), '/');
                Request.Builder builderNewBuilder = request.newBuilder();
                String str3 = str + strTrimStart;
                String str4 = TAG;
                Log.i(str4, "切换到静态服务地址：" + str3);
                Request requestBuild = builderNewBuilder.url(str3).cacheControl(cacheControl).build();
                TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
                okhttp3.Response responseProceed = chain.proceed(requestBuild);
                if (responseProceed.code() != 404) {
                    return responseProceed;
                }
                Log.i(str4, "静态服务地址（404）" + str3);
                responseProceed.close();
                Request requestBuild2 = chain.request().newBuilder().url(httpUrlUrl).cacheControl(cacheControl).build();
                Log.i(str4, "静态切换回原地址：" + str3 + " -------> " + httpUrlUrl);
                return chain.proceed(requestBuild2);
            }
            return chain.proceed(request);
        }
        return chain.proceed(request);
    }

    private final OkHttpClient getHttpClient(Application app) {
        OkHttpClient okHttpClient = _client;
        if (okHttpClient != null) {
            Intrinsics.checkNotNull(okHttpClient);
            return okHttpClient;
        }
        synchronized (this) {
            _client = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 2L, TimeUnit.MINUTES)).proxy(Proxy.NO_PROXY).addInterceptor(staticApiInterceptor).addInterceptor(cacheControlInterceptor).addInterceptor(new HeaderInterceptor()).cache(new Cache(new File(app.getCacheDir(), cacheDir), 314572800L)).build();
            Unit unit = Unit.INSTANCE;
        }
        OkHttpClient okHttpClient2 = _client;
        Intrinsics.checkNotNull(okHttpClient2);
        return okHttpClient2;
    }
}
