package okhttp3.internal.cache;

import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.umeng.message.utils.HttpRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.text.n;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Response cacheResponse;

    @Nullable
    private final Request networkRequest;

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", "response", "Lokhttp3/Response;", TTLogUtil.TAG_EVENT_REQUEST, "Lokhttp3/Request;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isCacheable(@org.jetbrains.annotations.NotNull okhttp3.Response r5, @org.jetbrains.annotations.NotNull okhttp3.Request r6) {
            /*
                r4 = this;
                int r0 = r5.code()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L5b
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L5b
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L5b
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L5b
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L5b
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L5b
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L31
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L5b
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L5b
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L5b
                switch(r0) {
                    case 300: goto L5b;
                    case 301: goto L5b;
                    case 302: goto L31;
                    default: goto L30;
                }
            L30:
                return r2
            L31:
                r0 = 2
                r1 = 0
                java.lang.String r3 = "Expires"
                java.lang.String r0 = okhttp3.Response.header$default(r5, r3, r1, r0, r1)
                if (r0 != 0) goto L5b
                okhttp3.CacheControl r0 = r5.cacheControl()
                int r0 = r0.maxAgeSeconds()
                r1 = -1
                if (r0 != r1) goto L5b
                okhttp3.CacheControl r0 = r5.cacheControl()
                boolean r0 = r0.getIsPublic()
                if (r0 != 0) goto L5b
                okhttp3.CacheControl r0 = r5.cacheControl()
                boolean r0 = r0.getIsPrivate()
                if (r0 != 0) goto L5b
                return r2
            L5b:
                okhttp3.CacheControl r5 = r5.cacheControl()
                boolean r5 = r5.noStore()
                if (r5 != 0) goto L70
                okhttp3.CacheControl r5 = r6.cacheControl()
                boolean r5 = r5.noStore()
                if (r5 != 0) goto L70
                r2 = 1
            L70:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Companion.isCacheable(okhttp3.Response, okhttp3.Request):boolean");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: CacheStrategy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", TTLogUtil.TAG_EVENT_REQUEST, "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;

        @NotNull
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j2, @NotNull Request request, @Nullable Response response) {
            this.nowMillis = j2;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            Response response2 = this.cacheResponse;
            if (response2 != null) {
                this.sentRequestMillis = response2.sentRequestAtMillis();
                this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
                Headers headers = this.cacheResponse.headers();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String strName = headers.name(i2);
                    String strValue = headers.value(i2);
                    if (n.b(strName, HttpRequest.HEADER_DATE, true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(strValue);
                        this.servedDateString = strValue;
                    } else if (n.b(strName, HttpRequest.HEADER_EXPIRES, true)) {
                        this.expires = DatesKt.toHttpDateOrNull(strValue);
                    } else if (n.b(strName, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(strValue);
                        this.lastModifiedString = strValue;
                    } else if (n.b(strName, HttpRequest.HEADER_ETAG, true)) {
                        this.etag = strValue;
                    } else if (n.b(strName, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(strValue, -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i2 = this.ageSeconds;
            if (i2 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i2));
            }
            long j2 = this.receivedResponseMillis;
            return jMax + (j2 - this.sentRequestMillis) + (this.nowMillis - j2);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.INSTANCE.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j2 = millis2 + jCacheResponseAge;
                if (j2 < millis + jComputeFreshnessLifetime) {
                    Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j2 >= jComputeFreshnessLifetime) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builderNewBuilder.build());
                }
            }
            String str = this.etag;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = HttpRequest.HEADER_IF_NONE_MATCH;
            } else if (this.lastModified != null) {
                str = this.lastModifiedString;
            } else {
                if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                }
                str = this.servedDateString;
            }
            Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            builderNewBuilder2.addLenient$okhttp(str2, str);
            return new CacheStrategy(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            }
            Date date3 = this.servedDate;
            long time2 = (date3 != null ? date3.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
            if (time2 > 0) {
                return time2 / ((long) 10);
            }
            return 0L;
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header(HttpRequest.HEADER_IF_NONE_MATCH) == null) ? false : true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy cacheStrategyComputeCandidate = computeCandidate();
            return (cacheStrategyComputeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) ? cacheStrategyComputeCandidate : new CacheStrategy(null, null);
        }

        @NotNull
        /* JADX INFO: renamed from: getRequest$okhttp, reason: from getter */
        public final Request getRequest() {
            return this.request;
        }
    }

    public CacheStrategy(@Nullable Request request, @Nullable Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
