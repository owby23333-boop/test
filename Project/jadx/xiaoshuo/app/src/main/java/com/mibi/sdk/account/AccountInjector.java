package com.mibi.sdk.account;

import android.accounts.Account;
import android.content.Context;
import com.mibi.sdk.common.account.AccountRegistry;
import com.mibi.sdk.common.utils.MibiLog;

/* JADX INFO: loaded from: classes10.dex */
public class AccountInjector {
    private static final String TAG = "AccountInjector";

    public static void inject(Context context) {
        MibiLog.d(TAG, "inject");
        if (AccountRegistry.getAccountProvider() == null) {
            injectDefaultAccountProvider(context);
        }
        if (AccountRegistry.getLoginProvider() == null) {
            AccountRegistry.setLoginProvider(new LoginProviderImpl(context.getApplicationContext()));
        }
    }

    private static void injectDefaultAccountProvider(Context context) {
        AccountRegistry.setAccountProvider(new AccountProviderImpl(context.getApplicationContext()));
    }

    public static boolean isLogined(Context context) {
        MibiLog.d(TAG, "isLogined");
        if (AccountRegistry.getAccountProvider() == null) {
            injectDefaultAccountProvider(context);
        }
        Account[] accounts = AccountRegistry.getAccountProvider().getAccounts();
        return accounts != null && accounts.length > 0;
    }

    public static void release() {
        MibiLog.d(TAG, "clear");
        AccountRegistry.release();
    }
}
