package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes.dex */
public class h0 {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e2) {
            l0.a(e2);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
        }
        return null;
    }
}
