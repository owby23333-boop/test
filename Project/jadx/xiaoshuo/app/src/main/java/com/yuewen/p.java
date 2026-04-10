package com.yuewen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class p {
    public static void a(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length == 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean a(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3)) {
                if (!networkCapabilities.hasTransport(4)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            h.a(e);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.core.content.ContextCompat");
        } catch (Exception unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("androidx.core.content.ContextCompat");
            } catch (Exception unused2) {
            }
        }
        if (cls == null) {
            return true;
        }
        try {
            if (((Integer) cls.getMethod("checkSelfPermission", Context.class, String.class).invoke(null, context, str)).intValue() == 0) {
                return true;
            }
            h.a("You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
            return false;
        } catch (Exception e) {
            h.a(e.toString());
            return true;
        }
    }
}
