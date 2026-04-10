package cn.bmob.v3.http.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public class GzipRequestInterceptor implements Interceptor {
    private RequestBody gzip(final RequestBody requestBody) {
        return new RequestBody() { // from class: cn.bmob.v3.http.interceptor.GzipRequestInterceptor.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType getContentType() {
                return requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        };
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return (request.body() == null || request.header("Accept-Encoding") != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header("Accept-Encoding", "gzip").method(request.method(), gzip(request.body())).build());
    }
}
