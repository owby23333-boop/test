package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: compiled from: CryptoResponseBodyConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000eB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/core/net/CryptoResponseBodyConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "gson", "Lcom/google/gson/Gson;", "adapter", "Lcom/google/gson/TypeAdapter;", "token", "Lcom/google/gson/reflect/TypeToken;", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;Lcom/google/gson/reflect/TypeToken;)V", "convert", "value", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CryptoResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ResponseBodyConverter";
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final TypeToken<?> token;

    public CryptoResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, TypeToken<?> token) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(token, "token");
        this.gson = gson;
        this.adapter = adapter;
        this.token = token;
    }

    /* JADX INFO: compiled from: CryptoResponseBodyConverter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/core/net/CryptoResponseBodyConverter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return CryptoResponseBodyConverter.TAG;
        }
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody value) {
        JsonElement jsonElement;
        JsonObject asJsonObject;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            JsonObject asJsonObject2 = ((JsonElement) this.gson.fromJson(value.string(), (Class) JsonElement.class)).getAsJsonObject();
            JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject(TtmlNode.TAG_BODY);
            if (asJsonObject3 != null && (jsonElement = asJsonObject3.get("encType")) != null && !jsonElement.isJsonNull()) {
                String encryptType = jsonElement.getAsString();
                asJsonObject3.remove("data");
                String encryptData = asJsonObject3.get("encData").getAsString();
                CryptoLib cryptoLib = CryptoLib.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(encryptType, "encryptType");
                Intrinsics.checkNotNullExpressionValue(encryptData, "encryptData");
                String strDecryptData = cryptoLib.decryptData(encryptType, encryptData);
                if (StringsKt.startsWith$default((CharSequence) strDecryptData, '[', false, 2, (Object) null)) {
                    asJsonObject = ((JsonArray) this.gson.fromJson(strDecryptData, (Class) JsonArray.class)).getAsJsonArray();
                } else {
                    asJsonObject = ((JsonElement) this.gson.fromJson(strDecryptData, (Class) JsonElement.class)).getAsJsonObject();
                }
                asJsonObject3.add("data", asJsonObject);
            }
            return this.adapter.fromJsonTree(asJsonObject2);
        } finally {
            value.close();
        }
    }
}
