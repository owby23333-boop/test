package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        return (i.a((Object) method, (Object) "GET") || i.a((Object) method, (Object) "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        return i.a((Object) method, (Object) "POST") || i.a((Object) method, (Object) "PUT") || i.a((Object) method, (Object) "PATCH") || i.a((Object) method, (Object) "PROPPATCH") || i.a((Object) method, (Object) "REPORT");
    }

    public final boolean invalidatesCache(@NotNull String method) {
        return i.a((Object) method, (Object) "POST") || i.a((Object) method, (Object) "PATCH") || i.a((Object) method, (Object) "PUT") || i.a((Object) method, (Object) "DELETE") || i.a((Object) method, (Object) "MOVE");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        return !i.a((Object) method, (Object) "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        return i.a((Object) method, (Object) "PROPFIND");
    }
}
