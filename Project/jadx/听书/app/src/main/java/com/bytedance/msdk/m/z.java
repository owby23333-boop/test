package com.bytedance.msdk.m;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.api.a.uy;
import com.bytedance.msdk.core.z.z.gc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.BuildConfig;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z() {
        try {
            if (com.bytedance.msdk.z.gc.dl.g() && uy.z()) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    private static synchronized void g() {
        if (com.bytedance.msdk.core.g.getContext() == null) {
            return;
        }
        com.bytedance.msdk.e.z.g.z().gc();
    }

    private static int dl(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            if (strArrSplit[i].length() != strArrSplit2[i].length()) {
                return strArrSplit[i].length() > strArrSplit2[i].length() ? 1 : -1;
            }
            int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (strArrSplit.length == strArrSplit2.length) {
            return 0;
        }
        return strArrSplit.length > strArrSplit2.length ? 1 : -1;
    }

    public static boolean z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals(MediationConstant.ADN_ADMOB) || str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "klevin":
                if (dl(str2, "2.11.0.3") != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.11.0.3，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.11.0.3，当前是" + str2);
                break;
                break;
            case "sigmob":
                if (dl(str2, "4.24.0") != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.24.0，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.24.0，当前是" + str2);
                break;
                break;
            case "xiaomi":
                if (dl(str2, "2.11.0.3.32") != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于2.11.0.3.32，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于2.11.0.3.32，当前是" + str2);
                break;
                break;
            case "ks":
                if (dl(str2, BuildConfig.VERSION_NAME) != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于4.6.30.1，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于4.6.30.1，当前是" + str2);
                break;
                break;
            case "gdt":
                if (dl(str2, "4.642.1512") != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.642.1512，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.642.1512，当前是" + str2);
                break;
                break;
            case "unity":
                if (dl(str2, "4.3.0") != 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "unity版本不符合，要求等于4.3.0，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "unity版本正常，要求等于4.3.0，当前是" + str2);
                break;
                break;
            case "mintegral":
                if (!TextUtils.isEmpty(str2) && str2.contains("16.6.57")) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于16.6.57，当前是" + str2);
                    break;
                } else {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于16.6.57，当前是" + str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "klevin":
                if (a("2.11.0.3", str2)) {
                    z("klevinAdapter", "2.11.0.3", str2);
                    break;
                } else {
                    g("klevinAdapter", "2.11.0.3", str2);
                    return false;
                }
                break;
            case "sigmob":
                if (a("4.24.0", str2)) {
                    z("sigmobAdapter", "4.24.0", str2);
                    break;
                } else {
                    g("sigmobAdapter", "4.24.0", str2);
                    return false;
                }
                break;
            case "xiaomi":
                if (a("2.11.0.3.32", str2)) {
                    z("xiaomiAdapter", "2.11.0.3.32", str2);
                    break;
                } else {
                    g("xiaomiAdapter", "2.11.0.3.32", str2);
                    return false;
                }
                break;
            case "ks":
                if (gc.dl(MediationConstant.ADN_KS) != null) {
                    return false;
                }
                if (a(BuildConfig.VERSION_NAME, str2)) {
                    z("ksAdapter", BuildConfig.VERSION_NAME, str2);
                } else {
                    g("ksAdapter", BuildConfig.VERSION_NAME, str2);
                    return false;
                }
                break;
                break;
            case "gdt":
                if (gc.dl(MediationConstant.ADN_GDT) != null) {
                    return false;
                }
                if (a("4.642.1512", str2)) {
                    z("gdtAdapter", "4.642.1512", str2);
                } else {
                    g("gdtAdapter", "4.642.1512", str2);
                    return false;
                }
                break;
                break;
            case "admob":
                if (a("17.2.0", str2)) {
                    z("admobAdapter", "17.2.0", str2);
                    break;
                } else {
                    g("admobAdapter", "17.2.0", str2);
                    return false;
                }
                break;
            case "baidu":
                if (a("9.3941", str2)) {
                    z("baiduAdapter", "9.3941", str2);
                    break;
                } else {
                    g("baiduAdapter", "9.3941", str2);
                    return false;
                }
                break;
            case "unity":
                if (a("4.3.0", str2)) {
                    z("unityAdapter", "4.3.0", str2);
                    break;
                } else {
                    g("unityAdapter", "4.3.0", str2);
                    return false;
                }
                break;
            case "mintegral":
                if (a("16.6.57", str2)) {
                    z("mtgAdapter", "16.6.57", str2);
                    break;
                } else {
                    g("mtgAdapter", "16.6.57", str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static void z(String str, String str2, String str3) {
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void g(String str, String str2, String str3) {
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }

    private static boolean a(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() == strArrSplit[i].length() && strArrSplit[i].compareTo(strArrSplit2[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
