package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public class ly {
    public static String z(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesG.getLong("start_mills", 0L) < 900000) {
            String string = sharedPreferencesG.getString(an.Q, null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strG = g(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        if (!TextUtils.isEmpty(strG)) {
            editorEdit.putString(an.Q, strG);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strG;
    }

    private static String g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            cb.g(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return "wifi";
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
        }
        return null;
    }
}
