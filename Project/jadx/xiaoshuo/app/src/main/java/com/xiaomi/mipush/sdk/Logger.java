package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        LoggerInterface loggerInterface = sUserLogger;
        boolean z = loggerInterface != null;
        boolean z2 = sDisablePushLog;
        boolean z3 = true ^ z2;
        if (!(z2 ? false : z)) {
            loggerInterface = null;
        }
        com.xiaomi.channel.commonutils.logger.b.a(new ej(loggerInterface, z3 ? ek.a(context) : null));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
