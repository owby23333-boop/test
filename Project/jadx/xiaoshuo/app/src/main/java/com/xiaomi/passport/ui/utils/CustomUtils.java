package com.xiaomi.passport.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.xiaomi.passport.ui.license.LoginAgreementAndPrivacy;
import com.yuewen.kl2;

/* JADX INFO: loaded from: classes8.dex */
public class CustomUtils {
    public static boolean CHECK_PHONE_NUM_LENGTH = false;
    public static boolean CUSTOM_LICENSE = false;
    public static LoginAgreementAndPrivacy CUSTOM_LOGIN_AGREEMENT_PRIVACY = null;
    public static boolean ENTER_PHAUTH_DIRECTLY = false;
    public static boolean FORMAT_PHONE_NUM = false;
    public static boolean HEADER_HELP_BY_TEXT = false;
    public static boolean HIDE_COUNTRY_CODE = false;
    public static boolean HIDE_USER_NAME = false;
    public static boolean IS_DIALOG_STYLE = false;
    public static boolean PROTOCAL_CONTENT_WITH_EXTRA = false;
    public static int QUERY_PHONE_ACCOUNT_SECOND = 10;
    public static boolean SEND_TICKET_TIME_ACCUMULATE = true;
    public static boolean SHOW_AGREENMENT_PROTOCAL_BY_DIALOG = false;
    public static boolean SHOW_CUSTOM_TOAST = false;
    public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;
    public static boolean UNIFORM_LOGIN_AND_REGISTER = false;
    public static boolean USE_VERIFY_CODE_VIEW = false;

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point.y;
    }

    public static int getScreeWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static boolean isChangeDensity(Context context) {
        return ((double) (((float) getScreeWidth(context)) / ((float) getHeight(context)))) >= 0.5d;
    }

    public static boolean phoneNumberIsChinaButNotVerify(String str, String str2) {
        return str.equals("+86") && str2.length() < 11;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setStatusBarDarkMode(boolean r8, android.app.Activity r9) {
        /*
            r0 = 1
            r1 = 0
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "get"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L45
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch: java.lang.Throwable -> L45
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L45
            r3.setAccessible(r0)     // Catch: java.lang.Throwable -> L45
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = "ro.miui.ui.version.name"
            r4[r1] = r5     // Catch: java.lang.Throwable -> L45
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L45
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "V6"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r3 != 0) goto L43
            java.lang.String r3 = "V7"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r3 != 0) goto L43
            java.lang.String r3 = "V8"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r3 != 0) goto L43
            java.lang.String r3 = "V9"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L49
        L43:
            r2 = r0
            goto L4a
        L45:
            r2 = move-exception
            r2.printStackTrace()
        L49:
            r2 = r1
        L4a:
            if (r2 == 0) goto L92
            android.view.Window r2 = r9.getWindow()
            java.lang.Class r2 = r2.getClass()
            java.lang.String r3 = "android.view.MiuiWindowManager$LayoutParams"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = "EXTRA_FLAG_STATUS_BAR_DARK_MODE"
            java.lang.reflect.Field r4 = r3.getField(r4)     // Catch: java.lang.Exception -> L8e
            int r3 = r4.getInt(r3)     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = "setExtraFlags"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L8e
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L8e
            r6[r1] = r7     // Catch: java.lang.Exception -> L8e
            r6[r0] = r7     // Catch: java.lang.Exception -> L8e
            java.lang.reflect.Method r2 = r2.getMethod(r4, r6)     // Catch: java.lang.Exception -> L8e
            android.view.Window r4 = r9.getWindow()     // Catch: java.lang.Exception -> L8e
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L8e
            if (r8 == 0) goto L7d
            r6 = r3
            goto L7e
        L7d:
            r6 = r1
        L7e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L8e
            r5[r1] = r6     // Catch: java.lang.Exception -> L8e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L8e
            r5[r0] = r1     // Catch: java.lang.Exception -> L8e
            r2.invoke(r4, r5)     // Catch: java.lang.Exception -> L8e
            goto L92
        L8e:
            r0 = move-exception
            r0.printStackTrace()
        L92:
            android.view.Window r9 = r9.getWindow()
            android.view.View r0 = r9.getDecorView()
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r9.addFlags(r1)
            int r9 = r0.getSystemUiVisibility()
            if (r8 == 0) goto La8
            r8 = r9 | 8192(0x2000, float:1.148E-41)
            goto Laa
        La8:
            r8 = r9 & (-8193(0xffffffffffffdfff, float:NaN))
        Laa:
            r0.setSystemUiVisibility(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.utils.CustomUtils.setStatusBarDarkMode(boolean, android.app.Activity):void");
    }

    public static void setStatusBarTranslucent(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(TTAdConstant.EXT_PLUGIN_UNINSTALL);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
