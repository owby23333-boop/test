package com.mibi.sdk.component;

import com.mibi.sdk.common.account.loader.AccountLoader;

/* JADX INFO: loaded from: classes13.dex */
public interface EntryResultCallback {
    void onEntryFailed(int i, String str);

    void onEntrySuccess(AccountLoader accountLoader);
}
