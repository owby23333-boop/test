package com.mibi.sdk.account;

import android.accounts.AccountsException;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.account.ILoginProvider;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class LoginProviderImpl implements ILoginProvider {
    private static final String KEY_STS_URL = "sts_url";
    private MiAccountManager mAccountManager;

    public LoginProviderImpl(Context context) {
        this.mAccountManager = MiAccountManager.get(context);
    }

    @Override // com.mibi.sdk.common.account.ILoginProvider
    public String getStsUrl(Activity activity, String str, String str2, String str3) throws IOException, AccountsException {
        try {
            return ((Bundle) this.mAccountManager.getLocalFeatures().getStsUrl(str, str2, str3, null, activity, null, null).getResult()).getString("sts_url");
        } catch (AuthenticatorException e) {
            throw e;
        } catch (OperationCanceledException e2) {
            throw e2;
        } catch (IllegalDeviceException e3) {
            throw new AccountsException(e3);
        } catch (InvalidCredentialException e4) {
            throw new AccountsException(e4);
        } catch (InvalidUserNameException e5) {
            throw new AccountsException(e5);
        } catch (AccessDeniedException e6) {
            throw new AccountsException(e6);
        } catch (AuthenticationFailureException e7) {
            throw new AccountsException(e7);
        } catch (InvalidResponseException e8) {
            throw new AccountsException(e8);
        } catch (IOException e9) {
            throw e9;
        }
    }
}
