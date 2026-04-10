package com.xiaomi.accountsdk.guestaccount;

import android.content.Context;
import com.xiaomi.accountsdk.guestaccount.data.GuestAccount;

/* JADX INFO: loaded from: classes5.dex */
class GuestAccountStorage {
    public GuestAccount getGuestAccount(Context context) {
        return getGuestAccount(context, null);
    }

    public void removeAll(Context context) {
        GuestAccountDatabaseHelper.getInstance(context).removeAll();
    }

    public void removeServiceToken(Context context, String str) {
        GuestAccountDatabaseHelper.getInstance(context).removeServiceToken(str);
    }

    public void savePassToken(Context context, GuestAccount guestAccount) {
        GuestAccountDatabaseHelper.getInstance(context).updatePassToken(guestAccount);
    }

    public void saveServiceToken(Context context, GuestAccount guestAccount) {
        GuestAccountDatabaseHelper.getInstance(context).updateServiceToken(guestAccount);
    }

    public GuestAccount getGuestAccount(Context context, String str) {
        return GuestAccountDatabaseHelper.getInstance(context).readGuestAccount(str);
    }
}
