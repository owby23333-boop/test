package com.bytedance.e.e.v;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.e.e.p.bf;
import com.xiaomi.onetrack.api.at;
import com.yuewen.g72;

/* JADX INFO: loaded from: classes.dex */
public final class zk {

    /* JADX INFO: renamed from: com.bytedance.e.e.v.zk$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[bf.EnumC0073bf.values().length];
            e = iArr;
            try {
                iArr[bf.EnumC0073bf.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[bf.EnumC0073bf.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[bf.EnumC0073bf.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                e[bf.EnumC0073bf.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                e[bf.EnumC0073bf.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean bf(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }

    private static bf.EnumC0073bf d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return bf.EnumC0073bf.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return bf.EnumC0073bf.WIFI;
                }
                if (type != 0) {
                    return bf.EnumC0073bf.MOBILE;
                }
                switch (((TelephonyManager) context.getSystemService(at.d)).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return bf.EnumC0073bf.MOBILE_3G;
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return bf.EnumC0073bf.MOBILE;
                    case 13:
                        return bf.EnumC0073bf.MOBILE_4G;
                }
            }
            return bf.EnumC0073bf.NONE;
        } catch (Throwable unused) {
            return bf.EnumC0073bf.MOBILE;
        }
    }

    public static String e(Context context) {
        return e(d(context));
    }

    public static String e(bf.EnumC0073bf enumC0073bf) {
        String str;
        try {
            int i = AnonymousClass1.e[enumC0073bf.ordinal()];
            if (i == 1) {
                str = g72.g;
            } else if (i == 2) {
                str = g72.h;
            } else if (i == 3) {
                str = g72.i;
            } else if (i == 4) {
                str = g72.j;
            } else {
                if (i != 5) {
                    return "";
                }
                str = "mobile";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }
}
