package com.mibi.sdk.account;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.mibi.sdk.common.account.IAccountProvider;
import com.mibi.sdk.common.account.IServiceTokenFuture;
import com.xiaomi.passport.accountmanager.MiAccountManager;

/* JADX INFO: loaded from: classes10.dex */
public class AccountProviderImpl implements IAccountProvider {
    private MiAccountManager mAccountManager;

    public AccountProviderImpl(Context context) {
        this.mAccountManager = MiAccountManager.get(context);
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public AccountManagerFuture<Bundle> addAccount(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.addAccount(str, str2, strArr, bundle, activity, accountManagerCallback, handler);
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public Account[] getAccounts() {
        return this.mAccountManager.getAccounts();
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public Account[] getAccountsByType(String str) {
        return this.mAccountManager.getAccountsByType(str);
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.getAuthToken(account, str, bundle, activity, accountManagerCallback, handler);
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public IServiceTokenFuture getServiceToken(Context context, String str) {
        return new ServiceTokenFutureImpl(this.mAccountManager.getServiceToken(context, str));
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public void invalidateAuthToken(String str, String str2) {
        this.mAccountManager.invalidateAuthToken(str, str2);
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public boolean isUseSystem() {
        return this.mAccountManager.isUseSystem();
    }

    @Override // com.mibi.sdk.common.account.IAccountProvider
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        return this.mAccountManager.getAuthToken(account, str, bundle, z, accountManagerCallback, handler);
    }
}
