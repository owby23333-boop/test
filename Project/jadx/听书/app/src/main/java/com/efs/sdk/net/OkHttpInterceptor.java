package com.efs.sdk.net;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1599a = g.c();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        boolean z;
        h hVar;
        h hVar2;
        boolean zEnableTracer;
        String strB;
        MediaType mediaType;
        InputStream inputStreamByteStream;
        Request request = chain.request();
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            zEnableTracer = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
            if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                if (request != null) {
                    Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
                } else {
                    Log.d("NetTrace-Interceptor", "intercept request is null~");
                }
                strB = this.f1599a.b();
                try {
                    Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(strB)));
                    com.efs.sdk.net.a.a.a().a(strB).c = request.url().getUrl();
                    hVar2 = new h(this.f1599a, strB);
                } catch (Throwable th) {
                    th = th;
                    str = strB;
                    z = zEnableTracer;
                    hVar = null;
                }
                try {
                    this.f1599a.a(new b(strB, request, hVar2));
                } catch (Throwable th2) {
                    boolean z2 = zEnableTracer;
                    hVar = hVar2;
                    th = th2;
                    str = strB;
                    z = z2;
                    th.printStackTrace();
                    hVar2 = hVar;
                    zEnableTracer = z;
                    strB = str;
                }
            } else {
                Log.d("NetTrace-Interceptor", "net enable is false~");
                hVar2 = null;
                strB = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            z = false;
            hVar = null;
        }
        Response responseProceed = chain.proceed(request);
        if (!zEnableTracer) {
            try {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    return responseProceed;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return responseProceed;
            }
        }
        if (hVar2 != null && hVar2.a()) {
            hVar2.b();
            f fVar = hVar2.f1611a;
            hVar2.b.size();
            fVar.a();
        }
        Connection connection = chain.connection();
        if (connection == null) {
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        }
        this.f1599a.a(new c(strB, request, responseProceed, connection));
        ResponseBody responseBodyBody = responseProceed.body();
        if (responseBodyBody != null) {
            mediaType = responseBodyBody.get$contentType();
            inputStreamByteStream = responseBodyBody.byteStream();
        } else {
            mediaType = null;
            inputStreamByteStream = null;
        }
        f fVar2 = this.f1599a;
        String mediaType2 = mediaType != null ? mediaType.getMediaType() : null;
        String strHeader = responseProceed.header(HttpHeaders.CONTENT_ENCODING);
        new com.efs.sdk.net.a.a.c(this.f1599a, strB);
        InputStream inputStreamA = fVar2.a(strB, mediaType2, strHeader, inputStreamByteStream);
        return inputStreamA != null ? responseProceed.newBuilder().body(new a(responseBodyBody, inputStreamA)).build() : responseProceed;
    }

    static class b implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1601a;
        private final Request b;
        private h c;

        public b(String str, Request request, h hVar) {
            this.f1601a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String a() {
            return this.f1601a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b() {
            return this.b.url().getUrl();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final byte[] d() {
            OutputStream inflaterOutputStream;
            RequestBody requestBodyBody = this.b.body();
            if (requestBodyBody == null) {
                return null;
            }
            h hVar = this.c;
            String strHeader = this.b.header(HttpHeaders.CONTENT_ENCODING);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (Constants.CP_GZIP.equals(strHeader)) {
                inflaterOutputStream = e.a(byteArrayOutputStream);
            } else {
                inflaterOutputStream = "deflate".equals(strHeader) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            }
            hVar.c = new com.efs.sdk.net.a.a.a(inflaterOutputStream);
            hVar.b = byteArrayOutputStream;
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(hVar.c));
            try {
                requestBodyBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        }
    }

    static class c implements f.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1602a;
        private final Request b;
        private final Response c;
        private final Connection d;

        public c(String str, Request request, Response response, Connection connection) {
            this.f1602a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final String a() {
            return this.f1602a;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final int b() {
            return this.c.code();
        }
    }

    static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResponseBody f1600a;
        private final BufferedSource b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f1600a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentType */
        public final MediaType get$contentType() {
            return this.f1600a.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentLength */
        public final long getContentLength() {
            return this.f1600a.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: source */
        public final BufferedSource getBodySource() {
            return this.b;
        }
    }
}
