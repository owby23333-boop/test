package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* JADX INFO: loaded from: classes.dex */
public class f0 {
    private static boolean a = false;
    private static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f1769c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f1770d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1771e = true;

    public static String a() {
        if (!a) {
            d();
        }
        return b;
    }

    public static String b() {
        try {
            if (!a) {
                d();
            }
            Configuration configuration = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getResources().getConfiguration();
            String strValueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : f1769c;
            Logger.e("MCC", "config=" + configuration.mcc + ",sMCC=" + f1769c);
            if (f1771e) {
                return strValueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f1771e ? "有SIM卡" : "无SIM卡,MCC返回null");
            Logger.e("MCC", sb.toString());
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        if (!a) {
            d();
        }
        return f1770d;
    }

    private static void d() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() == null || a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    f1771e = false;
                }
                Logger.e("MCC", f1771e ? "有SIM卡" : "无SIM卡");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            String strSubstring2 = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                b = simOperatorName;
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                f1769c = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                f1770d = strSubstring;
            }
        } catch (Throwable unused4) {
        }
        a = true;
    }
}
