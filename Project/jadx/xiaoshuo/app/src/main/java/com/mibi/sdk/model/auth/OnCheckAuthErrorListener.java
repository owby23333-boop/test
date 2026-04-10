package com.mibi.sdk.model.auth;

import android.os.Bundle;

/* JADX INFO: loaded from: classes14.dex */
public interface OnCheckAuthErrorListener {
    void onAccountFrozen();

    void onBindPhoneCheck(Bundle bundle);

    void onPasswordCheck();

    void onSMSCodeCheck(Bundle bundle);
}
