package com.mibi.sdk.common.account;

import android.accounts.AccountsException;
import android.app.Activity;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public interface ILoginProvider {
    String getStsUrl(Activity activity, String str, String str2, String str3) throws IOException, AccountsException;
}
