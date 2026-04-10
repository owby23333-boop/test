package com.xiaomi.accountsdk.guestaccount;

import android.content.Context;
import android.content.SharedPreferences;
import com.market.sdk.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class SharedPreferencesUtils {
    private static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences("uuid_data", 0);
    }

    public static String getUUID(Context context) {
        return getSP(context).getString(Constants.EXTRA_UUID, "");
    }

    public static void saveUUID(Context context, String str) {
        getSP(context).edit().putString(Constants.EXTRA_UUID, str).commit();
    }
}
