package me.jessyan.art.http.imageloader.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.x.k;
import com.bumptech.glide.load.engine.y.a;
import com.bumptech.glide.load.engine.y.e;
import com.bumptech.glide.load.engine.y.g;
import com.bumptech.glide.load.engine.y.i;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import me.jessyan.art.c.d;
import okhttp3.Dns;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
@GlideModule(glideName = "GlideArt")
public class GlideConfiguration extends com.bumptech.glide.m.a {
    static /* synthetic */ com.bumptech.glide.load.engine.y.a a(me.jessyan.art.a.a.a aVar) {
        File file = new File(aVar.c(), "Glide");
        me.jessyan.art.f.c.a(file);
        return e.a(file, 209715200L);
    }

    static /* synthetic */ boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    @Override // com.bumptech.glide.m.a
    public void applyOptions(@NonNull Context context, @NonNull com.bumptech.glide.d dVar) {
        final me.jessyan.art.a.a.a aVarA = me.jessyan.art.f.e.a(context);
        dVar.a(new a.InterfaceC0261a() { // from class: me.jessyan.art.http.imageloader.glide.b
            @Override // com.bumptech.glide.load.engine.y.a.InterfaceC0261a
            public final com.bumptech.glide.load.engine.y.a build() {
                return GlideConfiguration.a(aVarA);
            }
        });
        i iVarA = new i.a(context).a();
        int iC = iVarA.c();
        int iB = iVarA.b();
        Double.isNaN(iC);
        Double.isNaN(iB);
        dVar.a(new g((int) (r2 * 1.2d)));
        dVar.a(new k((int) (r6 * 1.2d)));
        me.jessyan.art.c.e.a aVarA2 = aVarA.imageLoader().a();
        if (aVarA2 instanceof GlideAppliesOptions) {
            ((GlideAppliesOptions) aVarA2).applyGlideOptions(context, dVar);
        }
    }

    @Override // com.bumptech.glide.m.a
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override // com.bumptech.glide.m.d
    public void registerComponents(@NonNull Context context, @NonNull com.bumptech.glide.c cVar, @NonNull Registry registry) {
        OkHttpClient.Builder builderHostnameVerifier = new OkHttpClient.Builder().hostnameVerifier(new HostnameVerifier() { // from class: me.jessyan.art.http.imageloader.glide.d
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return GlideConfiguration.a(str, sSLSession);
            }
        });
        final int i2 = 15;
        long j2 = 15;
        builderHostnameVerifier.connectTimeout(j2, TimeUnit.SECONDS).readTimeout(j2, TimeUnit.SECONDS).writeTimeout(j2, TimeUnit.SECONDS).dns(new Dns() { // from class: me.jessyan.art.http.imageloader.glide.c
            @Override // okhttp3.Dns
            public final List lookup(String str) {
                return GlideConfiguration.a(i2, str);
            }
        });
        registry.b(com.bumptech.glide.load.j.g.class, InputStream.class, new d.a(builderHostnameVerifier.build()));
    }

    static /* synthetic */ List a(int i2, final String str) throws UnknownHostException {
        return (List) Single.fromCallable(new Callable() { // from class: me.jessyan.art.http.imageloader.glide.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
        }).timeout(i2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).onErrorReturnItem(new ArrayList()).blockingGet();
    }
}
