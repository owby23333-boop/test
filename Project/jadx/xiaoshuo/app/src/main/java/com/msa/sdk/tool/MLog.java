package com.msa.sdk.tool;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MLog {
    private static final int DEBUG = 3;
    private static final String DEF_PROCESS = "Def";
    private static final int ERROR = 0;
    private static final int INFO = 2;
    private static final int MAX_CHAR_SIZE_PER_LOG = 3000;
    private static final String TAG = "MLog";
    private static final int VERBOSE = 4;
    private static final int WARN = 1;
    private static int sLogLevel = 1;
    private static String sPackageNameSuffix;
    private static volatile String sProcess;
    private static long sMainThreadId = Looper.getMainLooper().getThread().getId();
    private static String sPrefix = "zeus";

    public static String addAdPrefix(String str) {
        return "AD-PLUGIN-" + str;
    }

    public static void d(String str, String str2) {
        if (sLogLevel >= 3) {
            log(addAdPrefix(str), str2, 3);
        }
    }

    public static void e(String str, String str2) {
        if (sLogLevel >= 0) {
            log(addAdPrefix(str), str2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCurrentProcessName(Context context) {
        int iMyPid;
        ActivityManager activityManager;
        if (context == null) {
            return null;
        }
        try {
            iMyPid = Process.myPid();
            activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        } catch (Exception e) {
            e(TAG, "getCurrentProcessNameException", e);
        }
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return !TextUtils.isEmpty(runningAppProcessInfo.processName) ? TextUtils.equals(runningAppProcessInfo.processName, context.getPackageName()) ? DEF_PROCESS : getSuffix(runningAppProcessInfo.processName, ":") : String.valueOf(runningAppProcessInfo.pid);
            }
        }
        return null;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    private static String getPatternedMsg(String str, Throwable th) {
        return str + SignatureUtils.DELIMITER + Patterns.IP_ADDRESS.matcher(Log.getStackTraceString(th)).replaceAll("*.*.*.*");
    }

    private static String getSuffix(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return !str.contains(str2) ? str : str.substring(str.lastIndexOf(str2) + 1);
    }

    public static void i(String str, String str2) {
        if (sLogLevel >= 2) {
            log(addAdPrefix(str), str2, 2);
        }
    }

    public static void init(Context context, String str) {
        init(context, str, true);
    }

    public static boolean isDebugOn() {
        return sLogLevel >= 3;
    }

    private static void log(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int length = str2.length() / 3000;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = i2 * 3000;
            i2++;
            int iMin = Math.min(str2.length(), i2 * 3000);
            if (i3 < iMin) {
                String strSubstring = str2.substring(i3, iMin);
                if (i == 0) {
                    Log.e(str, strSubstring);
                } else if (i == 1) {
                    Log.w(str, strSubstring);
                } else if (i == 2) {
                    Log.i(str, strSubstring);
                } else if (i == 3) {
                    Log.d(str, strSubstring);
                } else if (i == 4) {
                    Log.v(str, strSubstring);
                }
            }
        }
    }

    public static void setDebugOff() {
        sLogLevel = 1;
    }

    public static void setDebugOn(boolean z) {
        if (z) {
            sLogLevel = 1000;
        } else {
            sLogLevel = 1;
        }
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static void setLogPrefix(String str) {
        sPrefix = str;
    }

    public static void v(String str, String str2) {
        if (sLogLevel >= 4) {
            log(addAdPrefix(str), str2, 4);
        }
    }

    public static void w(String str, String str2) {
        if (sLogLevel >= 1) {
            log(addAdPrefix(str), str2, 1);
        }
    }

    public static void init(final Context context, String str, boolean z) {
        if (context != null && z) {
            sPackageNameSuffix = getSuffix(context.getPackageName(), Consts.DOT);
        }
        sPrefix = str;
        new Thread(new Runnable() { // from class: com.msa.sdk.tool.MLog.1
            @Override // java.lang.Runnable
            public void run() {
                String unused = MLog.sProcess = MLog.getCurrentProcessName(context);
            }
        }).start();
    }

    public static void d(String str, String str2, Throwable th) {
        if (sLogLevel >= 3) {
            Log.d(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sLogLevel >= 0) {
            Log.e(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sLogLevel >= 2) {
            Log.i(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sLogLevel >= 4) {
            Log.v(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sLogLevel >= 1) {
            Log.w(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }
}
