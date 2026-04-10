package com.xiaomi.accountsdk.guestaccount;

import com.xiaomi.accountsdk.guestaccount.data.GuestAccount;

/* JADX INFO: loaded from: classes5.dex */
public interface GuestAccountBackupUtil {
    GuestAccount loadGuestAccount();

    void saveGuestAccount(GuestAccount guestAccount);
}
