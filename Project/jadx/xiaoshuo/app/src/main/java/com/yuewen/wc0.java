package com.yuewen;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.core.app.AppWrapper;
import com.duokan.core.sys.SystemInfoHelper;
import com.duokan.reader.BaseEnv;
import com.duokan.reader.BasePrivacyManager;
import com.duokan.reader.ReaderEnv;
import com.mi.mibridge.DeviceLevel;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class wc0 extends SystemInfoHelper {
    public static ActivityManager.MemoryInfo A = null;
    public static final String t = "DeviceUtils";
    public static final int u = -1;
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = 4;
    public static int z = -1;

    public static String O() {
        return SystemInfoHelper.y();
    }

    public static String P(String str, String str2) {
        if (!SystemInfoHelper.n) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CHANNEL_NAME : ");
        sb.append(str);
        sb.append(SignatureUtils.DELIMITER);
        sb.append("CHANNEL_DIST : ");
        sb.append(str2);
        sb.append("/");
        sb.append(ReaderEnv.get().f0());
        sb.append("\nDevice_Id : ");
        sb.append(BaseEnv.get().b0());
        List list = Collections.EMPTY_LIST;
        if (list.size() > 0) {
            sb.append("\nIM1 : ");
            sb.append((String) list.get(0));
            if (list.size() > 1) {
                sb.append("\nIM2 : ");
                sb.append((String) list.get(1));
            }
        }
        sb.append("\nOA : ");
        sb.append(U());
        sb.append("\nAndroid_id : ");
        sb.append(ReaderEnv.get().getAndroidId());
        sb.append("\nAndroid_id_md5 : ");
        sb.append(ReaderEnv.get().G3());
        sb.append("\nSS : ");
        sb.append(u73.f(2));
        sb.append("\nMem : ");
        sb.append(R() / 1048576);
        sb.append("MB, level=");
        sb.append(Q());
        sb.append(", sys level=");
        sb.append(DeviceLevel.getDeviceLevel(1));
        sb.append(", midd STD =" + DeviceLevel.MIDDLE);
        sb.append("\nDisplay : ");
        sb.append(ge0.o());
        sb.append(", density=");
        sb.append(ge0.b());
        sb.append("(");
        sb.append(ge0.c());
        sb.append(")");
        return sb.toString();
    }

    public static int Q() {
        if (z == -1 && BasePrivacyManager.o().w()) {
            int deviceLevel = DeviceLevel.getDeviceLevel(1);
            if (deviceLevel != DeviceLevel.UNKNOWN) {
                if (deviceLevel == DeviceLevel.LOW) {
                    z = 2;
                } else if (deviceLevel == DeviceLevel.MIDDLE) {
                    z = 3;
                } else if (deviceLevel == DeviceLevel.HIGH) {
                    z = 4;
                }
            }
            long jR = R();
            if (z == -1) {
                if (jR < 2147483648L) {
                    z = 1;
                } else if (jR <= 4294967296L) {
                    z = 2;
                } else if (jR <= 6442450944L) {
                    z = 3;
                } else {
                    z = 4;
                }
            }
            if (qt1.g()) {
                qt1.c(t, "-->getDeviceLevel(): level=", Integer.valueOf(deviceLevel), ", result=", Integer.valueOf(z), ", size=", Long.valueOf(jR));
            }
        }
        return z;
    }

    public static long R() {
        if (A == null) {
            X();
        }
        return A.totalMem;
    }

    public static String S() {
        if (!SystemInfoHelper.n) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", String.class, String.class);
            String str = (String) declaredMethod.invoke(cls, "ro.product.marketname", "");
            try {
                if (TextUtils.isEmpty(str)) {
                    return (String) declaredMethod.invoke(cls, "ro.product.model", "");
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            return str;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            return "";
        }
    }

    public static ActivityManager.MemoryInfo T() {
        X();
        return A;
    }

    public static String U() {
        return SystemInfoHelper.F();
    }

    public static boolean V() {
        int iQ = Q();
        return iQ < 4 && iQ != -1;
    }

    public static boolean W() {
        int iQ = Q();
        return iQ <= 2 && iQ != -1;
    }

    public static void X() {
        ActivityManager activityManager = (ActivityManager) AppWrapper.v().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (A == null) {
            A = new ActivityManager.MemoryInfo();
        }
        activityManager.getMemoryInfo(A);
    }
}
