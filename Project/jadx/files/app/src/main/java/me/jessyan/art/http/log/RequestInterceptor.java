package me.jessyan.art.http.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.jessyan.art.f.j;
import me.jessyan.art.f.k;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes3.dex */
@Singleton
public class RequestInterceptor implements Interceptor {

    @Nullable
    @Inject
    me.jessyan.art.c.b a;

    @Inject
    b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    Level f21184c;

    public enum Level {
        NONE,
        REQUEST,
        RESPONSE,
        ALL
    }

    @Inject
    public RequestInterceptor() {
    }

    @Nullable
    private String a(Request request, Response response, boolean z2) throws IOException {
        try {
            ResponseBody responseBodyBody = response.newBuilder().build().body();
            BufferedSource bufferedSourceSource = responseBodyBody.getBodySource();
            bufferedSourceSource.request(Long.MAX_VALUE);
            return a(responseBodyBody, response.headers().get("Content-Encoding"), bufferedSourceSource.getBufferField().clone());
        } catch (IOException e2) {
            e2.printStackTrace();
            return "{\"error\": \"" + e2.getMessage() + "\"}";
        }
    }

    public static boolean b(MediaType mediaType) {
        if (mediaType == null || mediaType.subtype() == null) {
            return false;
        }
        return mediaType.subtype().toLowerCase().contains(com.baidu.mobads.sdk.internal.a.f12785f);
    }

    public static boolean c(MediaType mediaType) {
        if (mediaType == null || mediaType.subtype() == null) {
            return false;
        }
        return mediaType.subtype().toLowerCase().contains("json");
    }

    public static boolean d(MediaType mediaType) {
        if (mediaType == null || mediaType.type() == null) {
            return false;
        }
        return f(mediaType) || e(mediaType) || c(mediaType) || a(mediaType) || b(mediaType) || g(mediaType);
    }

    public static boolean e(MediaType mediaType) {
        if (mediaType == null || mediaType.subtype() == null) {
            return false;
        }
        return mediaType.subtype().toLowerCase().contains("plain");
    }

    public static boolean f(MediaType mediaType) {
        if (mediaType == null || mediaType.type() == null) {
            return false;
        }
        return mediaType.type().equals("text");
    }

    public static boolean g(MediaType mediaType) {
        if (mediaType == null || mediaType.subtype() == null) {
            return false;
        }
        return mediaType.subtype().toLowerCase().contains("xml");
    }

    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        Level level = this.f21184c;
        boolean z2 = true;
        if (level == Level.ALL || (level != Level.NONE && level == Level.REQUEST)) {
            if (request.body() == null || !d(request.body().get$contentType())) {
                this.b.a(request);
            } else {
                this.b.a(request, a(request));
            }
        }
        Level level2 = this.f21184c;
        if (level2 != Level.ALL && (level2 == Level.NONE || level2 != Level.RESPONSE)) {
            z2 = false;
        }
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        try {
            Response responseProceed = chain.proceed(request);
            long jNanoTime2 = z2 ? System.nanoTime() : 0L;
            ResponseBody responseBodyBody = responseProceed.body();
            String strA = null;
            if (responseBodyBody != null && d(responseBodyBody.contentType())) {
                strA = a(request, responseProceed, z2);
            }
            if (z2) {
                List<String> listEncodedPathSegments = request.url().encodedPathSegments();
                String string = responseProceed.headers().toString();
                int iCode = responseProceed.code();
                boolean zIsSuccessful = responseProceed.isSuccessful();
                String strMessage = responseProceed.message();
                String url = responseProceed.request().url().getUrl();
                if (responseBodyBody == null || !d(responseBodyBody.contentType())) {
                    this.b.a(TimeUnit.NANOSECONDS.toMillis(jNanoTime2 - jNanoTime), zIsSuccessful, iCode, string, listEncodedPathSegments, strMessage, url);
                } else {
                    this.b.a(TimeUnit.NANOSECONDS.toMillis(jNanoTime2 - jNanoTime), zIsSuccessful, iCode, string, responseBodyBody.contentType(), strA, listEncodedPathSegments, strMessage, url);
                }
            }
            me.jessyan.art.c.b bVar = this.a;
            return bVar != null ? bVar.a(strA, chain, responseProceed) : responseProceed;
        } catch (Exception e2) {
            y0.a.a.c("Http Error: " + e2, new Object[0]);
            throw e2;
        }
    }

    private String a(ResponseBody responseBody, String str, Buffer buffer) {
        Charset charsetForName = Charset.forName("UTF-8");
        MediaType mediaTypeContentType = responseBody.contentType();
        if (mediaTypeContentType != null) {
            charsetForName = mediaTypeContentType.charset(charsetForName);
        }
        if (str != null && str.equalsIgnoreCase("gzip")) {
            return k.a(buffer.readByteArray(), a(charsetForName));
        }
        if (str != null && str.equalsIgnoreCase("zlib")) {
            return k.b(buffer.readByteArray(), a(charsetForName));
        }
        return buffer.readString(charsetForName);
    }

    public static String a(Request request) throws UnsupportedEncodingException {
        try {
            RequestBody requestBodyBody = request.newBuilder().build().body();
            if (requestBodyBody == null) {
                return "";
            }
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            Charset charsetForName = Charset.forName("UTF-8");
            MediaType contentType = requestBodyBody.get$contentType();
            if (contentType != null) {
                charsetForName = contentType.charset(charsetForName);
            }
            String string = buffer.readString(charsetForName);
            if (j.a(string)) {
                string = URLDecoder.decode(string, a(charsetForName));
            }
            return me.jessyan.art.f.b.a(string);
        } catch (IOException e2) {
            e2.printStackTrace();
            return "{\"error\": \"" + e2.getMessage() + "\"}";
        }
    }

    public static boolean a(MediaType mediaType) {
        if (mediaType == null || mediaType.subtype() == null) {
            return false;
        }
        return mediaType.subtype().toLowerCase().contains("x-www-form-urlencoded");
    }

    public static String a(Charset charset) {
        String string = charset.toString();
        int iIndexOf = string.indexOf("[");
        return iIndexOf == -1 ? string : string.substring(iIndexOf + 1, string.length() - 1);
    }
}
