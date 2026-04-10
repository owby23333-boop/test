package me.jessyan.art.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.common.Constants;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: BackrunRomUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static boolean a() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase().equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI) || Build.BRAND.toLowerCase().equals("honor");
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (str != null) {
            return str.toLowerCase().equals("leeco") || Build.BRAND.toLowerCase().equals("letv");
        }
        return false;
    }

    public static boolean c() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU);
    }

    public static boolean d() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO);
    }

    public static boolean e() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("samsung");
    }

    public static void f(Context context) {
        a(context, "com.iqoo.secure");
    }

    public static void g(Context context) {
        a(context, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
    }

    public static boolean h() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI);
    }

    public static void c(Context context) {
        a(context, "com.meizu.safe");
    }

    public static void d(Context context) {
        try {
            try {
                try {
                    a(context, "com.coloros.phonemanager");
                } catch (Exception unused) {
                    a(context, "com.coloros.safecenter");
                }
            } catch (Exception unused2) {
                a(context, "com.oppo.safe");
            }
        } catch (Exception unused3) {
            a(context, "com.coloros.oppoguardelf");
        }
    }

    public static void e(Context context) {
        try {
            a(context, "com.samsung.android.sm_cn");
        } catch (Exception unused) {
            a(context, "com.samsung.android.sm");
        }
    }

    public static boolean f() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("smartisan");
    }

    public static boolean g() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO);
    }

    public static void h(Context context) {
        try {
            Intent intent = new Intent();
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(Constants.KEY_PACKAGE, context.getPackageName(), null));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context) {
        try {
            a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        } catch (Exception unused) {
            a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        }
    }

    public static void b(Context context) {
        a(context, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
    }

    private static void a(Context context, @NonNull String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
