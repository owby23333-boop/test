package com.xiaomi.account.utils;

import android.content.Intent;
import android.graphics.Point;
import com.xiaomi.accountsdk.utils.AccountLogger;
import java.lang.reflect.InvocationTargetException;
import miuix.android.content.MiuiIntent;

/* JADX INFO: loaded from: classes5.dex */
public class SplitUtils {
    private static final String EXTRA_KEY_EXEMPT_ADD_FORCE_SPLIT_FLAG = "exempt_add_force_split_flag";
    public static final int FLAG_MIUI_CANCEL_SPLIT = 8;
    public static final int FLAG_MIUI_FORCE_SPLIT = 16;
    public static final int FLAG_MIUI_SPLIT_ACTIVITY = 4;
    private static final String TAG = "SplitUtils";

    public static void addMiuiFlags(Intent intent, int i) {
        try {
            intent.getClass().getMethod("addMiuiFlags", Integer.TYPE).invoke(intent, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            AccountLogger.log(TAG, "reflect addMiuiFlag error: " + e);
        }
    }

    public static void clearCancelSplitFlag(Intent intent) {
        if (isIntentFromSettingSplit(intent)) {
            clearCancelSplitFlagIfExist(intent);
        }
    }

    public static void clearCancelSplitFlagIfExist(Intent intent) {
        int miuiFlags = getMiuiFlags(intent);
        if (miuiFlags == -1 || (miuiFlags & 8) == 0) {
            return;
        }
        setMiuiFlags(intent, miuiFlags ^ 8);
    }

    private static int getMiuiFlags(Intent intent) {
        try {
            return ((Integer) intent.getClass().getMethod("getMiuiFlags", new Class[0]).invoke(intent, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            AccountLogger.log(TAG, "reflect getMiuiFlags error: " + e);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCurrentDisplayMoreThanHalfScreen(android.content.Context r4) {
        /*
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>()
            android.content.Context r1 = r4.getApplicationContext()
            java.lang.String r2 = "window"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.WindowManager r1 = (android.view.WindowManager) r1
            android.view.Display r1 = r1.getDefaultDisplay()
            r1.getRealSize(r0)
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            boolean r1 = isLandscape(r0)
            r2 = 0
            if (r1 == 0) goto L30
            int r4 = r4.widthPixels
            float r4 = (float) r4
            int r0 = r0.x
        L2c:
            float r0 = (float) r0
            float r0 = r0 + r2
            float r4 = r4 / r0
            goto L45
        L30:
            int r1 = r4.widthPixels
            float r1 = (float) r1
            int r3 = r0.x
            float r3 = (float) r3
            float r3 = r3 + r2
            float r1 = r1 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L44
            int r4 = r4.heightPixels
            float r4 = (float) r4
            int r0 = r0.y
            goto L2c
        L44:
            r4 = r1
        L45:
            r0 = 1056964608(0x3f000000, float:0.5)
            boolean r4 = isInRegion(r4, r2, r0)
            if (r4 == 0) goto L4f
            r4 = 0
            return r4
        L4f:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.utils.SplitUtils.isCurrentDisplayMoreThanHalfScreen(android.content.Context):boolean");
    }

    private static boolean isInRegion(float f, float f2, float f3) {
        return f >= f2 && f < f3;
    }

    public static boolean isIntentExemptAddForceSplitFlag(Intent intent) {
        return intent.getBooleanExtra(EXTRA_KEY_EXEMPT_ADD_FORCE_SPLIT_FLAG, false);
    }

    public static boolean isIntentFromSettingSplit(Intent intent) {
        int miuiFlags = getMiuiFlags(intent);
        return (miuiFlags == -1 || (miuiFlags & 4) == 0) ? false : true;
    }

    private static boolean isLandscape(Point point) {
        return point.x > point.y;
    }

    public static void removeIntentExemptAddForceSplitFlag(Intent intent) {
        intent.removeExtra(EXTRA_KEY_EXEMPT_ADD_FORCE_SPLIT_FLAG);
    }

    public static void removeSplitModeKeyOnPad(Intent intent) {
        if (intent.hasExtra(MiuiIntent.EXTRA_SPLIT_MODE)) {
            intent.removeExtra(MiuiIntent.EXTRA_SPLIT_MODE);
        }
    }

    public static void setIntentExemptAddForceSplitFlag(Intent intent) {
        intent.putExtra(EXTRA_KEY_EXEMPT_ADD_FORCE_SPLIT_FLAG, true);
    }

    private static void setMiuiFlags(Intent intent, int i) {
        try {
            intent.getClass().getMethod("setMiuiFlags", Integer.TYPE).invoke(intent, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            AccountLogger.log(TAG, "reflect getMiuiFlags error: " + e);
        }
    }
}
