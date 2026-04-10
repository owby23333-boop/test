package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
final class b {
    private static final Pattern bfl = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    private static boolean hS(String str) {
        if (str == null) {
            return false;
        }
        return bfl.matcher(str).matches();
    }

    public static String hT(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\\s+");
        return (strArrSplit.length >= 5 && hS(strArrSplit[4])) ? strArrSplit[4] : "";
    }

    public static String fl(int i) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 24) & 255));
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
