package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes.dex */
public class z {
    public static int a(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 == 4) {
            return 4;
        }
        if (i2 != 5) {
            return i2;
        }
        return 5;
    }

    public static boolean a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return false;
            }
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 1;
                    }
                } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState()) {
                    int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    if (networkType == 20) {
                        return 5;
                    }
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                            return 4;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "mobile" : "5g" : UtilityImpl.NET_TYPE_4G : UtilityImpl.NET_TYPE_3G : UtilityImpl.NET_TYPE_2G : UtilityImpl.NET_TYPE_WIFI : "unknown";
    }

    public static int c(Context context) {
        return a(b(context));
    }

    public static String d(Context context) {
        return b(b(context));
    }

    public static boolean e(Context context) {
        return b(context) == 2;
    }

    public static boolean f(Context context) {
        return b(context) == 3;
    }
}
