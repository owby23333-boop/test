package com.bytedance.sdk.component.fo.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static boolean z(Context context) {
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
            wp.a("ignored", th.toString());
        }
        return false;
    }

    public static int g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
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

    public static String dl(Context context) {
        int iG = g(context);
        return iG != 2 ? iG != 3 ? iG != 4 ? iG != 5 ? "mobile" : NetworkUtil.NETWORK_CLASS_4G : "wifi" : NetworkUtil.NETWORK_CLASS_3G : "2g";
    }
}
