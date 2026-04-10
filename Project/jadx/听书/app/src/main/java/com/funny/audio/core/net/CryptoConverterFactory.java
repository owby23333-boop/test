package com.funny.audio.core.net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: CryptoConverterFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JI\u0010\n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J7\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u0017\u0012\u0002\b\u00030\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0002\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/funny/audio/core/net/CryptoConverterFactory;", "Lretrofit2/Converter$Factory;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "_gson", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "requestBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "type", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "", "methodAnnotations", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "responseBodyConverter", "Lokhttp3/ResponseBody;", "annotations", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CryptoConverterFactory extends Converter.Factory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Gson _gson;

    /* JADX INFO: renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson;

    /* JADX INFO: compiled from: CryptoConverterFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/core/net/CryptoConverterFactory$Companion;", "", "()V", "create", "Lcom/funny/audio/core/net/CryptoConverterFactory;", "gson", "Lcom/google/gson/Gson;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CryptoConverterFactory create() {
            return create(new Gson());
        }

        public final CryptoConverterFactory create(Gson gson) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            return new CryptoConverterFactory(gson);
        }
    }

    public CryptoConverterFactory(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.funny.audio.core.net.CryptoConverterFactory$gson$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                Gson gson2 = this.this$0._gson;
                Intrinsics.checkNotNull(gson2);
                return gson2;
            }
        });
        this._gson = gson;
    }

    public final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(methodAnnotations, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        TypeAdapter adapter = getGson().getAdapter(TypeToken.get(type));
        Gson gson = getGson();
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
        return new CryptoRequestBodyConverter(gson, adapter);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        TypeToken<?> token = TypeToken.get(type);
        TypeAdapter adapter = getGson().getAdapter(token);
        Gson gson = getGson();
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
        Intrinsics.checkNotNullExpressionValue(token, "token");
        return new CryptoResponseBodyConverter(gson, adapter, token);
    }
}
