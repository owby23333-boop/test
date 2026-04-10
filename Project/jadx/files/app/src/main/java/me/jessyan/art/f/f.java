package me.jessyan.art.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static boolean a;
    private static Object b;

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static boolean b(Context context) {
        if (context != null || b == null) {
            d(context);
        }
        return a;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            return false;
        }
        return connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED && connectivityManager.getBackgroundDataSetting()) {
                    a = true;
                } else {
                    a = false;
                }
            }
            b = "";
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a;
    }
}
