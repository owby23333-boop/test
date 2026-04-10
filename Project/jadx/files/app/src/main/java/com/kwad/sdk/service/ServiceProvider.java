package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.SdkConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ServiceProvider {
    private static SdkConfig axJ;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t2) {
            this.mProviders.put(cls, t2);
        }
    }

    @NonNull
    public static SdkConfig CF() {
        return axJ;
    }

    public static void a(SdkConfig sdkConfig) {
        axJ = sdkConfig;
    }

    public static void bE(Context context) {
        mContext = context;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    @NonNull
    public static Context getContext() {
        return mContext;
    }

    public static <T> void put(Class<T> cls, T t2) {
        ServiceProviderDelegate.INSTANCE.put(cls, t2);
    }
}
