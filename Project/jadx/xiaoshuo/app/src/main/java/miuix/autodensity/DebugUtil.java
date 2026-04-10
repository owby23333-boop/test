package miuix.autodensity;

import android.text.TextUtils;
import android.util.Log;
import miuix.core.util.SystemProperties;

/* JADX INFO: loaded from: classes7.dex */
public class DebugUtil {
    static final String TAG = "AutoDensity";
    private static String sAutoDensityDebug;
    private static volatile float sDebugAutoDensityScale;

    public static float getAutoDensityScaleInDebugMode() {
        return sDebugAutoDensityScale;
    }

    public static void initAutoDensityDebugEnable() {
        String str;
        try {
            str = SystemProperties.get("log.tag.autodensity.debug.enable");
            sAutoDensityDebug = str;
            if (str == null) {
                str = "0";
            }
        } catch (Exception e) {
            Log.i(TAG, "can not access property log.tag.autodensity.enable, undebugable", e);
            str = "";
        }
        Log.d(TAG, "autodensity debugEnable = " + str);
        try {
            sDebugAutoDensityScale = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            sDebugAutoDensityScale = 0.0f;
        }
    }

    public static boolean isDisableAutoDensityInDebugMode() {
        return sDebugAutoDensityScale < 0.0f;
    }

    public static void printDensityLog(String str) {
        if (sDebugAutoDensityScale < 0.0f || TextUtils.isEmpty(sAutoDensityDebug)) {
            return;
        }
        Log.d(TAG, str);
    }
}
