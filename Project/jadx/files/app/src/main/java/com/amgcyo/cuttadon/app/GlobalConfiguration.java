package com.amgcyo.cuttadon.app;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import com.google.gson.GsonBuilder;
import io.rx_cache2.internal.RxCache;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import me.jessyan.art.a.b.b;
import me.jessyan.art.a.b.g;
import me.jessyan.art.a.b.o;
import me.jessyan.art.http.imageloader.glide.GlideImageLoaderStrategy;
import me.jessyan.art.http.log.RequestInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class GlobalConfiguration implements me.jessyan.art.d.e {
    static /* synthetic */ void a(Context context, Retrofit.Builder builder) {
    }

    static /* synthetic */ boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    @Override // me.jessyan.art.d.e
    public void a(@NonNull Context context, @NonNull o.b bVar) {
        bVar.a(RequestInterceptor.Level.NONE);
        y0.a.a.a("Release 时, 让框架不再打印 Http 请求和响应的信息", new Object[0]);
        bVar.a(com.amgcyo.cuttadon.utils.otherutils.g.k());
        bVar.a(new GlideImageLoaderStrategy());
        bVar.a(new l(context));
        bVar.a(new n());
        bVar.a(new b.a() { // from class: com.amgcyo.cuttadon.app.b
            @Override // me.jessyan.art.a.b.b.a
            public final void a(Context context2, GsonBuilder gsonBuilder) {
                gsonBuilder.serializeNulls().enableComplexMapKeySerialization();
            }
        });
        bVar.a(new g.b() { // from class: com.amgcyo.cuttadon.app.c
            @Override // me.jessyan.art.a.b.g.b
            public final void a(Context context2, Retrofit.Builder builder) {
                GlobalConfiguration.a(context2, builder);
            }
        });
        bVar.a(new g.a() { // from class: com.amgcyo.cuttadon.app.f
            @Override // me.jessyan.art.a.b.g.a
            public final void a(Context context2, OkHttpClient.Builder builder) {
                GlobalConfiguration.a(context2, builder);
            }
        });
        bVar.a(new g.c() { // from class: com.amgcyo.cuttadon.app.e
            @Override // me.jessyan.art.a.b.g.c
            public final RxCache a(Context context2, RxCache.Builder builder) {
                return GlobalConfiguration.a(context2, builder);
            }
        });
    }

    @Override // me.jessyan.art.d.e
    public void b(@NonNull Context context, @NonNull List<me.jessyan.art.base.f.e> list) {
        list.add(new j());
    }

    @Override // me.jessyan.art.d.e
    public void c(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> list) {
        list.add(new i());
    }

    static /* synthetic */ void a(Context context, OkHttpClient.Builder builder) {
        SSLSocketFactory sSLSocketFactoryH = com.amgcyo.cuttadon.utils.otherutils.g.H();
        if (sSLSocketFactoryH != null) {
            builder.sslSocketFactory(sSLSocketFactoryH, (X509TrustManager) com.amgcyo.cuttadon.utils.otherutils.g.S()[0]);
        }
        builder.hostnameVerifier(new HostnameVerifier() { // from class: com.amgcyo.cuttadon.app.d
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return GlobalConfiguration.a(str, sSLSession);
            }
        });
        builder.addInterceptor(new m());
        me.jessyan.progressmanager.b.a().a(builder);
        me.jessyan.retrofiturlmanager.a.f().a(builder);
    }

    static /* synthetic */ RxCache a(Context context, RxCache.Builder builder) {
        builder.useExpiredDataIfLoaderNotAvailable(true);
        return null;
    }

    @Override // me.jessyan.art.d.e
    public void a(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> list) {
        list.add(new k());
    }
}
