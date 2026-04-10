package retrofit2;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes2.dex */
final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType */
        public MediaType get$contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z2;
        if (headers != null) {
            this.requestBuilder.headers(headers);
        }
        if (z3) {
            this.formBuilder = new FormBody.Builder();
        } else if (z4) {
            this.multipartBuilder = new MultipartBody.Builder();
            this.multipartBuilder.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String str, boolean z2) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                canonicalizeForPath(buffer, str, iCharCount, length, z2);
                return buffer.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    void addFormField(String str, String str2, boolean z2) {
        if (z2) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.requestBuilder.addHeader(str, str2);
            return;
        }
        MediaType mediaType = MediaType.parse(str2);
        if (mediaType != null) {
            this.contentType = mediaType;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    void addPathParam(String str, String str2, boolean z2) {
        String str3 = this.relativeUrl;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.relativeUrl = str3.replace("{" + str + "}", canonicalizeForPath(str2, z2));
    }

    void addQueryParam(String str, String str2, boolean z2) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.urlBuilder = this.baseUrl.newBuilder(str3);
            if (this.urlBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z2) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    Request build() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.baseUrl.resolve(this.relativeUrl);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        RequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.build();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.requestBuilder.addHeader("Content-Type", mediaType.getMediaType());
            }
        }
        return this.requestBuilder.url(httpUrlResolve).method(this.method, contentTypeOverridingRequestBody).build();
    }

    void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    private static void canonicalizeForPath(Buffer buffer, String str, int i2, int i3, boolean z2) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z2 || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        int i4 = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) HEX_DIGITS[(i4 >> 4) & 15]);
                        buffer.writeByte((int) HEX_DIGITS[i4 & 15]);
                    }
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }
}
