package a0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: NetworkUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static OkHttpClient b;
    public static final MediaType a = MediaType.parse("application/json; charset=utf-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f158c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ExecutorService f159d = Executors.newCachedThreadPool();

    static {
        Executors.newScheduledThreadPool(2);
    }

    public static OkHttpClient a() {
        synchronized (f158c) {
            OkHttpClient okHttpClient = b;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient okHttpClientBuild = builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
            b = okHttpClientBuild;
            return okHttpClientBuild;
        }
    }
}
