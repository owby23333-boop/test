package com.funny.audio.core.net;

import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: DirectCallAdapterFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/core/net/DirectCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getResponseType", "type", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DirectCallAdapterFactory extends CallAdapter.Factory {
    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        final Type responseType = getResponseType(returnType);
        return new CallAdapter<Object, Object>() { // from class: com.funny.audio.core.net.DirectCallAdapterFactory.get.1
            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: responseType, reason: from getter */
            public Type get$responseType() {
                return responseType;
            }

            @Override // retrofit2.CallAdapter
            public Object adapt(Call<Object> call) {
                Intrinsics.checkNotNullParameter(call, "call");
                try {
                    System.currentTimeMillis();
                    Object objBody = call.execute().body();
                    System.currentTimeMillis();
                    return objBody;
                } catch (Exception e) {
                    Log.d("NET", "网络请求发生异常！" + e.getMessage());
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    private final Type getResponseType(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type type2 = ((WildcardType) type).getUpperBounds()[0];
        Intrinsics.checkNotNullExpressionValue(type2, "{\n            type.upperBounds[0]\n        }");
        return type2;
    }
}
