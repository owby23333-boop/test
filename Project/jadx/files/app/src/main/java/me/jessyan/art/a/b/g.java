package me.jessyan.art.a.b;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import me.jessyan.art.e.c;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: ClientModule.java */
/* JADX INFO: loaded from: classes3.dex */
@Module
public abstract class g {

    /* JADX INFO: compiled from: ClientModule.java */
    public interface a {
        void a(@NonNull Context context, @NonNull OkHttpClient.Builder builder);
    }

    /* JADX INFO: compiled from: ClientModule.java */
    public interface b {
        void a(@NonNull Context context, @NonNull Retrofit.Builder builder);
    }

    /* JADX INFO: compiled from: ClientModule.java */
    public interface c {
        RxCache a(@NonNull Context context, @NonNull RxCache.Builder builder);
    }

    @Provides
    @Singleton
    static Retrofit a(Application application, @Nullable b bVar, Retrofit.Builder builder, OkHttpClient okHttpClient, HttpUrl httpUrl, Gson gson) {
        builder.baseUrl(httpUrl).client(okHttpClient);
        if (bVar != null) {
            bVar.a(application, builder);
        }
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson));
        return builder.build();
    }

    @Provides
    @Singleton
    static Retrofit.Builder b() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    static OkHttpClient a(Application application, @Nullable a aVar, OkHttpClient.Builder builder, Interceptor interceptor, @Nullable List<Interceptor> list, @Nullable final me.jessyan.art.c.b bVar, ExecutorService executorService) {
        builder.connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).cache(null).addNetworkInterceptor(interceptor);
        if (bVar != null) {
            builder.addInterceptor(new Interceptor() { // from class: me.jessyan.art.a.b.a
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    return chain.proceed(bVar.a(chain, chain.request()));
                }
            });
        }
        if (list != null) {
            Iterator<Interceptor> it = list.iterator();
            while (it.hasNext()) {
                builder.addInterceptor(it.next());
            }
        }
        builder.dispatcher(new Dispatcher(executorService));
        if (aVar != null) {
            aVar.a(application, builder);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    static OkHttpClient.Builder a() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    static RxCache a(Application application, @Nullable c cVar, @Named("RxCacheDirectory") File file, Gson gson) {
        RxCache.Builder builder = new RxCache.Builder();
        RxCache rxCacheA = cVar != null ? cVar.a(application, builder) : null;
        return rxCacheA != null ? rxCacheA : builder.persistence(file, new GsonSpeaker(gson));
    }

    @Provides
    @Singleton
    @Named("RxCacheDirectory")
    static File a(File file) {
        File file2 = new File(file, "RxCache");
        me.jessyan.art.f.c.a(file2);
        return file2;
    }

    @Provides
    @Singleton
    static me.jessyan.art.e.c a(Application application, me.jessyan.art.e.b bVar) {
        c.b bVarB = me.jessyan.art.e.c.b();
        bVarB.a(application);
        bVarB.a(bVar);
        return bVarB.a();
    }
}
