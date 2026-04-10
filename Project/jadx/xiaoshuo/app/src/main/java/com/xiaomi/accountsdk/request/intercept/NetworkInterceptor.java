package com.xiaomi.accountsdk.request.intercept;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkInterceptor {

    public static class Holder {
        private static volatile NetworkInterceptCallback sInstance = new EmptyNetworkInterceptCallback();

        private Holder() {
        }
    }

    public static NetworkInterceptCallback get() {
        return Holder.sInstance;
    }

    public static void set(NetworkInterceptCallback networkInterceptCallback) {
        NetworkInterceptCallback unused = Holder.sInstance = networkInterceptCallback;
    }
}
