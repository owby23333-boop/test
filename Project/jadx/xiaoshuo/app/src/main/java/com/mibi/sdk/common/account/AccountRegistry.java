package com.mibi.sdk.common.account;

/* JADX INFO: loaded from: classes13.dex */
public final class AccountRegistry {
    private static IAccountProvider sAccountProvider;
    private static ILoginProvider sLoginProvider;

    private AccountRegistry() {
    }

    public static IAccountProvider getAccountProvider() {
        return sAccountProvider;
    }

    public static ILoginProvider getLoginProvider() {
        return sLoginProvider;
    }

    public static void release() {
        releaseAccountProvider();
    }

    public static void releaseAccountProvider() {
        sAccountProvider = null;
    }

    public static void releaseLoginProvider() {
        sLoginProvider = null;
    }

    public static void setAccountProvider(IAccountProvider iAccountProvider) {
        sAccountProvider = iAccountProvider;
    }

    public static void setLoginProvider(ILoginProvider iLoginProvider) {
        sLoginProvider = iLoginProvider;
    }
}
