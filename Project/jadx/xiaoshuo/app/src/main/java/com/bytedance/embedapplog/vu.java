package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.duokan.reader.ui.util.AdHelper;
import com.xiaomi.onetrack.api.at;
import com.yuewen.g72;

/* JADX INFO: loaded from: classes.dex */
public class vu {
    private static String bf(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            tx.bf(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return g72.g;
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService(at.d)).getNetworkType()) {
        }
        return null;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferences.getLong("start_mills", 0L) < AdHelper.e) {
            String string = sharedPreferences.getString("access", null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strBf = bf(context);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!TextUtils.isEmpty(strBf)) {
            editorEdit.putString("access", strBf);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strBf;
    }
}
