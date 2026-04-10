package retrofit2;

import com.baidu.mobads.sdk.internal.bw;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes2.dex */
public final class Response<T> {
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    private Response(okhttp3.Response response, T t2, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t2;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> error(int i2, ResponseBody responseBody) {
        if (i2 >= 400) {
            return error(responseBody, new Response.Builder().code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> Response<T> success(T t2) {
        return success(t2, new Response.Builder().code(200).message(bw.f12977k).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(T t2, Headers headers) {
        Utils.checkNotNull(headers, "headers == null");
        return success(t2, new Response.Builder().code(200).message(bw.f12977k).protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Utils.checkNotNull(responseBody, "body == null");
        Utils.checkNotNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t2, okhttp3.Response response) {
        Utils.checkNotNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t2, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
