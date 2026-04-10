package com.funny.audio;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.InputStream;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* JADX INFO: compiled from: GlideOkHttpModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/funny/audio/GlideOkHttpModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "_coverImageClient", "Lokhttp3/OkHttpClient;", d.R, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coverImageInterceptor", "Lokhttp3/Interceptor;", "getCoverImageClient", "registerComponents", "", "glide", "Lcom/bumptech/glide/Glide;", "registry", "Lcom/bumptech/glide/Registry;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlideOkHttpModule extends AppGlideModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String cacheDir = "imageCaches";
    private OkHttpClient _coverImageClient;
    private Context context;
    private Interceptor coverImageInterceptor = new Interceptor() { // from class: com.funny.audio.GlideOkHttpModule$$ExternalSyntheticLambda0
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return GlideOkHttpModule.coverImageInterceptor$lambda$0(chain);
        }
    };

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    /* JADX INFO: compiled from: GlideOkHttpModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/GlideOkHttpModule$Companion;", "", "()V", "cacheDir", "", "getCacheDir", "()Ljava/lang/String;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getCacheDir() {
            return GlideOkHttpModule.cacheDir;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response coverImageInterceptor$lambda$0(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().build());
    }

    public final OkHttpClient getCoverImageClient() {
        OkHttpClient okHttpClient = this._coverImageClient;
        if (okHttpClient != null) {
            Intrinsics.checkNotNull(okHttpClient);
            return okHttpClient;
        }
        synchronized (this) {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            this._coverImageClient = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 2L, TimeUnit.MINUTES)).proxy(Proxy.NO_PROXY).addInterceptor(this.coverImageInterceptor).cache(new Cache(new File(context.getCacheDir(), cacheDir), 629145600L)).build();
            Unit unit = Unit.INSTANCE;
        }
        OkHttpClient okHttpClient2 = this._coverImageClient;
        Intrinsics.checkNotNull(okHttpClient2);
        return okHttpClient2;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glide, "glide");
        Intrinsics.checkNotNullParameter(registry, "registry");
        this.context = context;
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(getCoverImageClient()));
    }
}
