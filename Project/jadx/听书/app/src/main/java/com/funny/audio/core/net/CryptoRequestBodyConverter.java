package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* JADX INFO: compiled from: CryptoRequestBodyConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\fB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/funny/audio/core/net/CryptoRequestBodyConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "gson", "Lcom/google/gson/Gson;", "adapter", "Lcom/google/gson/TypeAdapter;", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "convert", "value", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CryptoRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediaType MEDIA_TYPE = MediaType.INSTANCE.get("application/json; charset=UTF-8");
    private static final Charset UTF_8;
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public CryptoRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.gson = gson;
        this.adapter = adapter;
    }

    /* JADX INFO: compiled from: CryptoRequestBodyConverter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/funny/audio/core/net/CryptoRequestBodyConverter$Companion;", "", "()V", "MEDIA_TYPE", "Lokhttp3/MediaType;", "getMEDIA_TYPE", "()Lokhttp3/MediaType;", "UTF_8", "Ljava/nio/charset/Charset;", "getUTF_8", "()Ljava/nio/charset/Charset;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaType getMEDIA_TYPE() {
            return CryptoRequestBodyConverter.MEDIA_TYPE;
        }

        public final Charset getUTF_8() {
            return CryptoRequestBodyConverter.UTF_8;
        }
    }

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
        UTF_8 = charsetForName;
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T value) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.write(jsonWriterNewJsonWriter, value);
        jsonWriterNewJsonWriter.close();
        return RequestBody.INSTANCE.create(MEDIA_TYPE, buffer.readByteString());
    }
}
