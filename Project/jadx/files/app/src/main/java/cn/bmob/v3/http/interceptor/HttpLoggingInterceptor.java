package cn.bmob.v3.http.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

/* JADX INFO: loaded from: classes.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: cn.bmob.v3.http.interceptor.HttpLoggingInterceptor.Logger.1
            @Override // cn.bmob.v3.http.interceptor.HttpLoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(str, 4, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
    }

    private static String protocol(Protocol protocol) {
        return protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z2 = level == Level.BODY;
        boolean z3 = z2 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        boolean z4 = requestBodyBody != null;
        Connection connection = chain.connection();
        String str = "--> " + request.method() + ' ' + request.url() + ' ' + protocol(connection != null ? connection.getProtocol() : Protocol.HTTP_1_1);
        if (!z3 && z4) {
            str = str + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(str);
        if (z3) {
            if (z4) {
                if (requestBodyBody.getContentType() != null) {
                    this.logger.log("Content-Type: " + requestBodyBody.getContentType());
                }
                if (requestBodyBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strName = headers.name(i2);
                if (!"Content-Type".equalsIgnoreCase(strName) && !"Content-Length".equalsIgnoreCase(strName)) {
                    this.logger.log(strName + ": " + headers.value(i2));
                }
            }
            if (!z2 || !z4) {
                this.logger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType mediaType = requestBodyBody.getContentType();
                if (mediaType != null) {
                    charset = mediaType.charset(UTF8);
                }
                this.logger.log("");
                this.logger.log(buffer.readString(charset));
                this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
            }
        }
        long jNanoTime = System.nanoTime();
        Response responseProceed = chain.proceed(request);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
        long contentLength = responseProceed.body().getContentLength();
        String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
        Logger logger = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("<-- ");
        sb.append(responseProceed.code());
        sb.append(' ');
        sb.append(responseProceed.message());
        sb.append(' ');
        sb.append(responseProceed.request().url());
        sb.append(" (");
        sb.append(millis);
        sb.append("ms");
        sb.append(z3 ? "" : ", " + str2 + " body");
        sb.append(')');
        logger.log(sb.toString());
        return responseProceed;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }
}
