package com.bytedance.z.g.gz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.z.g.e.g;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class fo {
    public static String z(Context context) {
        return z(dl(context));
    }

    /* JADX INFO: renamed from: com.bytedance.z.g.gz.fo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[g.EnumC0229g.values().length];
            z = iArr;
            try {
                iArr[g.EnumC0229g.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[g.EnumC0229g.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[g.EnumC0229g.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[g.EnumC0229g.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[g.EnumC0229g.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String z(g.EnumC0229g enumC0229g) {
        try {
            int i = AnonymousClass1.z[enumC0229g.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "mobile" : NetworkUtil.NETWORK_CLASS_4G : NetworkUtil.NETWORK_CLASS_3G : "2g" : "wifi";
        } catch (Exception unused) {
            return "";
        }
    }

    private static g.EnumC0229g dl(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return g.EnumC0229g.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return g.EnumC0229g.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return g.EnumC0229g.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return g.EnumC0229g.MOBILE;
                        case 13:
                            return g.EnumC0229g.MOBILE_4G;
                    }
                }
                return g.EnumC0229g.MOBILE;
            }
            return g.EnumC0229g.NONE;
        } catch (Throwable unused) {
            return g.EnumC0229g.MOBILE;
        }
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
