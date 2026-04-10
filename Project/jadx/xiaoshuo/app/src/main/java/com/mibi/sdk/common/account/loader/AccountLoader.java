package com.mibi.sdk.common.account.loader;

import android.content.Context;
import android.os.Parcelable;
import com.mibi.sdk.common.account.AccountToken;
import com.mibi.sdk.common.exception.PaymentException;

/* JADX INFO: loaded from: classes13.dex */
public interface AccountLoader extends Parcelable {
    AccountToken getAccountToken();

    String getUserId();

    boolean isAccountChanged(Context context);

    void load(Context context) throws PaymentException;

    void reload(Context context) throws PaymentException;
}
