package me.jessyan.art.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.util.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import me.jessyan.art.entity.GlideBean;
import me.jessyan.art.http.imageloader.glide.GlideConstant;
import me.jessyan.art.http.imageloader.glide.GlideFileUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: OkHttpStreamFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream>, Callback {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Call.Factory f21161s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final g f21162t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private InputStream f21163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ResponseBody f21164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private d.a<? super InputStream> f21165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile Call f21166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile boolean f21167y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile GlideBean f21168z;

    public c(Call.Factory factory, g gVar) {
        this.f21161s = factory;
        this.f21162t = gVar;
        String stringUrl = gVar.toStringUrl();
        this.f21167y = stringUrl.startsWith("https://c-res") || stringUrl.startsWith("http://c-res");
        Map<String, String> headers = gVar.getHeaders();
        if (headers == null || headers.size() <= 0) {
            return;
        }
        String str = headers.get(GlideConstant.COMIC_ID);
        String str2 = headers.get(GlideConstant.ENCRYPT_INFO);
        String str3 = headers.get(GlideConstant.ENCRYPT_TYPE);
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || str3 == null || TextUtils.isEmpty(str3)) {
            this.f21168z = null;
        } else {
            this.f21168z = new GlideBean(Integer.parseInt(str), str2, Integer.parseInt(str3));
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        Request.Builder builderUrl = new Request.Builder().url(this.f21162t.toStringUrl());
        for (Map.Entry<String, String> entry : this.f21162t.getHeaders().entrySet()) {
            builderUrl.addHeader(entry.getKey(), entry.getValue());
        }
        Request requestBuild = builderUrl.build();
        this.f21165w = aVar;
        this.f21166x = this.f21161s.newCall(requestBuild);
        this.f21166x.enqueue(this);
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        try {
            if (this.f21163u != null) {
                this.f21163u.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f21164v;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f21165w = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        Call call = this.f21166x;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return (this.f21167y || this.f21168z != null) ? DataSource.LOCAL : DataSource.REMOTE;
    }

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            y0.a.a.a(iOException, "OkHttp failed to obtain result", new Object[0]);
        }
        iOException.printStackTrace();
        this.f21165w.a((Exception) iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        this.f21164v = response.body();
        if (!response.isSuccessful()) {
            new ArrayList();
            this.f21165w.a((Exception) new HttpException(response.message(), response.code()));
            return;
        }
        ResponseBody responseBody = this.f21164v;
        k.a(responseBody);
        long contentLength = responseBody.getContentLength();
        if (this.f21167y) {
            try {
                this.f21163u = GlideFileUtil.getRemoveDataByteArray(GlideFileUtil.input2byte(this.f21164v.byteStream()));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f21165w.a(this.f21163u);
            return;
        }
        if (this.f21168z == null) {
            this.f21163u = com.bumptech.glide.util.c.a(this.f21164v.byteStream(), contentLength);
            this.f21165w.a(this.f21163u);
            return;
        }
        try {
            int encrypt_type = this.f21168z.getEncrypt_type();
            if (encrypt_type == 1) {
                this.f21163u = GlideFileUtil.getRemoveDataByteArray(this.f21168z.getId(), Integer.parseInt(this.f21168z.getEncrypt_info()), GlideFileUtil.input2byte(this.f21164v.byteStream()));
            } else if (encrypt_type == 0) {
                this.f21163u = this.f21164v.byteStream();
            }
            this.f21165w.a(this.f21163u);
        } catch (Exception e3) {
            e3.printStackTrace();
            this.f21165w.a(e3);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
