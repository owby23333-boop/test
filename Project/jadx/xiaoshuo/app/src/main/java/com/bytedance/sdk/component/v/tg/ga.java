package com.bytedance.sdk.component.v.tg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.api.at;
import com.yuewen.g72;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static int bf(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                switch (((TelephonyManager) context.getSystemService(at.d)).getNetworkType()) {
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
                    case 18:
                    case 19:
                        return 5;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName)) {
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                                }
                            }
                            return 3;
                        }
                        return 1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static String d(Context context) {
        int iBf = bf(context);
        return iBf != 2 ? iBf != 3 ? iBf != 4 ? iBf != 5 ? "mobile" : g72.j : g72.g : g72.i : g72.h;
    }

    public static boolean e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            Log.e("ignored", th.toString());
        }
        return false;
    }
}
