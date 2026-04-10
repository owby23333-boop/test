package com.xm.logsdk.log;

import android.app.Application;
import android.util.Log;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xm.logsdk.log.logger.collator.ILogCollator;
import com.xm.logsdk.log.logger.lib.Logger;
import com.xm.logsdk.log.logger.lib.StringBuilderPool;
import com.xm.logsdk.log.logger.lib.thread.AndroidHandlerThread;
import com.xm.logsdk.log.logger.lib.thread.IMsgCallback;

/* JADX INFO: loaded from: classes8.dex */
public class Logz {
    public static LogzConfig sLogConfig = new LogzConfig();
    private static volatile boolean sInit = false;

    private static void additionalLogInfo(StringBuilder sb, int i) {
        if (sLogConfig.isEnableClassInfoPrint() && sb != null) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (i < 0 || i >= stackTrace.length) {
                    return;
                }
                String fileName = stackTrace[i].getFileName();
                String methodName = stackTrace[i].getMethodName();
                int lineNumber = stackTrace[i].getLineNumber();
                String str = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
                sb.append("[(");
                sb.append(fileName);
                sb.append(":");
                sb.append(lineNumber);
                sb.append(")#");
                sb.append(str);
                sb.append("] ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void crash(String str) {
        sLogConfig.setCrashLogger();
        log(6, "crash", str, null);
    }

    public static void d(String str) {
        log(3, "", str, null);
    }

    public static void e(String str) {
        log(6, "", str, null);
    }

    public static void i(String str) {
        log(4, "", str, null);
    }

    public static void initCrashHandler(Application application) {
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(application.getApplicationContext());
        LogzConfig logzConfig = sLogConfig;
        if (logzConfig != null) {
            crashHandler.setCrashCallback(logzConfig.getCrashCallback());
        }
    }

    public static void initDefaultLogger(LogzConfig logzConfig) {
        if (sInit) {
            return;
        }
        sInit = true;
        sLogConfig = logzConfig;
        if (logzConfig == null) {
            sLogConfig = new LogzConfig();
        }
        sLogConfig.build();
        AndroidHandlerThread androidHandlerThread = new AndroidHandlerThread("LogCollatorThread");
        androidHandlerThread.setCallback(new IMsgCallback() { // from class: com.xm.logsdk.log.Logz.1
            @Override // com.xm.logsdk.log.logger.lib.thread.IMsgCallback
            public void handleMessage(Object obj) {
                for (ILogCollator iLogCollator : Logz.sLogConfig.getLogCollator()) {
                    if (iLogCollator != null) {
                        iLogCollator.collatingLog(Logz.sLogConfig.getLogDir(), Logz.sLogConfig.getMaxSizeM());
                    }
                }
            }
        });
        androidHandlerThread.doMessage(null);
        androidHandlerThread.quitSafely();
        CrashHandler.getInstance().setCrashCallback(sLogConfig.getCrashCallback());
        i("=========================== init v1.0.0===========================\n");
    }

    public static void log(int i, String str, String str2, Throwable th) {
        LogzConfig logzConfig = sLogConfig;
        log(i, str, str2, th, logzConfig != null ? logzConfig.getClassInStackIndex() : 6);
    }

    private static void print(int i, String str, StringBuilder sb) {
        for (Logger logger : sLogConfig.getLoggers()) {
            if (logger != null) {
                logger.append(i, str, sb);
            }
        }
    }

    public static void v(String str) {
        log(2, "", str, null);
    }

    public static void w(String str) {
        log(5, "", str, null);
    }

    public static void d(String str, String str2) {
        log(3, str, str2, null);
    }

    public static void e(String str, String str2) {
        log(6, str, str2, null);
    }

    public static void i(String str, String str2) {
        log(4, str, str2, null);
    }

    public static void v(String str, String str2) {
        log(2, str, str2, null);
    }

    public static void w(String str, String str2) {
        log(5, str, str2, null);
    }

    public static void crash(String str, Throwable th) {
        sLogConfig.setCrashLogger();
        log(6, "crash", str, th);
    }

    public static void d(String str, String str2, Throwable th) {
        log(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        log(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        log(4, str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        log(2, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        log(5, str, str2, th);
    }

    public static void d(String str, Throwable th) {
        log(3, "", str, th);
    }

    public static void e(String str, Throwable th) {
        log(6, "", str, th);
    }

    public static void i(String str, Throwable th) {
        log(4, "", str, th);
    }

    public static void log(int i, String str, String str2, Throwable th, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sLogConfig.getLogPre());
        if (str == null || str.isEmpty()) {
            str = "";
        }
        sb.append(str);
        String string = sb.toString();
        StringBuilder sbObtain = StringBuilderPool.obtain();
        additionalLogInfo(sbObtain, i2);
        if (str2 != null) {
            sbObtain.append(str2);
        }
        if (th != null) {
            sbObtain.append(SignatureUtils.DELIMITER);
            sbObtain.append(Log.getStackTraceString(th));
        }
        print(i, string, sbObtain);
        StringBuilderPool.recycle(sbObtain);
    }

    public static void v(String str, Throwable th) {
        log(2, "", str, th);
    }

    public static void w(String str, Throwable th) {
        log(5, "", str, th);
    }
}
