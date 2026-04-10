package cn.bmob.v3.util;

import android.text.TextUtils;
import android.util.Log;
import cn.bmob.v3.BmobConstants;
import com.umeng.message.proguard.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class BLog {
    private static final String BOTTOM_BORDER = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final char BOTTOM_LEFT_CORNER = 9562;
    private static final int CHUNK_SIZE = 4000;
    private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════";
    private static final char HORIZONTAL_DOUBLE_LINE = 9553;
    private static final int JSON_INDENT = 4;
    private static final int MAX_METHOD_COUNT = 5;
    private static final String MIDDLE_BORDER = "╟────────────────────────────────────────────────────────────────────────────────────────";
    private static final char MIDDLE_CORNER = 9567;
    private static final int MIN_STACK_OFFSET = 3;
    private static final String SINGLE_DIVIDER = "────────────────────────────────────────────";
    private static final String TOP_BORDER = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final char TOP_LEFT_CORNER = 9556;
    private static final Settings settings = new Settings();
    private static String TAG = BmobConstants.TAG;

    public enum LogLevel {
        FULL,
        NONE
    }

    public static class Settings {
        int methodCount = 5;
        boolean showThreadInfo = true;
        LogLevel logLevel = LogLevel.NONE;

        public Settings hideThreadInfo() {
            this.showThreadInfo = false;
            return this;
        }

        public Settings setLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Settings setMethodCount(int i2) {
            BLog.validateMethodCount(i2);
            this.methodCount = i2;
            return this;
        }
    }

    private BLog() {
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    private static String formatTag(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(TAG, str)) {
            return TAG;
        }
        return TAG + "-" + str;
    }

    private static String getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private static int getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i2 = 3; i2 < stackTraceElementArr.length; i2++) {
            if (!stackTraceElementArr[i2].getClassName().equals(Log.class.getName())) {
                return i2 - 1;
            }
        }
        return -1;
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static Settings init() {
        return settings;
    }

    public static void json(String str) {
        json(TAG, str);
    }

    private static synchronized void log(int i2, String str, String str2, int i3) {
        if (settings.logLevel == LogLevel.NONE) {
            return;
        }
        logTopBorder(i2, str);
        logHeaderContent(i2, str, i3);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= CHUNK_SIZE) {
            if (i3 > 0) {
                logDivider(i2, str);
            }
            logContent(i2, str, str2);
            logBottomBorder(i2, str);
            return;
        }
        if (i3 > 0) {
            logDivider(i2, str);
        }
        for (int i4 = 0; i4 < length; i4 += CHUNK_SIZE) {
            logContent(i2, str, new String(bytes, i4, Math.min(length - i4, CHUNK_SIZE)));
        }
        logBottomBorder(i2, str);
    }

    private static void logBottomBorder(int i2, String str) {
        logChunk(i2, str, BOTTOM_BORDER);
    }

    private static void logChunk(int i2, String str, String str2) {
        String tag = formatTag(str);
        if (i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6 || i2 != 7) {
            return;
        }
        Log.wtf(tag, str2);
    }

    private static void logContent(int i2, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            logChunk(i2, str, "║ " + str3);
        }
    }

    private static void logDivider(int i2, String str) {
        logChunk(i2, str, MIDDLE_BORDER);
    }

    private static void logHeaderContent(int i2, String str, int i3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (settings.showThreadInfo) {
            logChunk(i2, str, "║ Thread: " + Thread.currentThread().getName());
            logDivider(i2, str);
        }
        int stackOffset = getStackOffset(stackTrace);
        String str2 = "";
        while (i3 > 0) {
            int i4 = i3 + stackOffset;
            str2 = str2 + "   ";
            logChunk(i2, str, "║ " + str2 + getSimpleClassName(stackTrace[i4].getClassName()) + "." + stackTrace[i4].getMethodName() + "  (" + stackTrace[i4].getFileName() + ":" + stackTrace[i4].getLineNumber() + ad.f20406s);
            i3 += -1;
        }
    }

    private static void logTopBorder(int i2, String str) {
        logChunk(i2, str, TOP_BORDER);
    }

    public static void v(String str) {
        v(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateMethodCount(int i2) {
        if (i2 < 0 || i2 > 5) {
            throw new IllegalStateException("methodCount must be > 0 and < 5");
        }
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void wtf(String str) {
        wtf(TAG, str);
    }

    public static void d(String str, String str2) {
        d(str, str2, settings.methodCount);
    }

    public static void e(String str, String str2) {
        e(str, str2, null, settings.methodCount);
    }

    public static void i(String str, String str2) {
        i(str, str2, settings.methodCount);
    }

    public static Settings init(String str) {
        if (str == null) {
            throw new NullPointerException("tag may not be null");
        }
        if (str.trim().length() == 0) {
            throw new IllegalStateException("tag may not be empty");
        }
        TAG = str;
        return settings;
    }

    public static void json(String str, String str2) {
        json(str, str2, settings.methodCount);
    }

    public static void v(String str, String str2) {
        v(str, str2, settings.methodCount);
    }

    public static void w(String str, String str2) {
        w(str, str2, settings.methodCount);
    }

    public static void wtf(String str, String str2) {
        wtf(str, str2, settings.methodCount);
    }

    public static void d(String str, int i2) {
        d(TAG, str, i2);
    }

    public static void e(Exception exc) {
        e(TAG, null, exc, settings.methodCount);
    }

    public static void i(String str, int i2) {
        i(TAG, str, i2);
    }

    public static void json(String str, int i2) {
        json(TAG, str, i2);
    }

    public static void v(String str, int i2) {
        v(TAG, str, i2);
    }

    public static void w(String str, int i2) {
        w(TAG, str, i2);
    }

    public static void wtf(String str, int i2) {
        wtf(TAG, str, i2);
    }

    public static void d(String str, String str2, int i2) {
        validateMethodCount(i2);
        log(3, str, str2, i2);
    }

    public static void e(String str, Exception exc) {
        e(str, null, exc, settings.methodCount);
    }

    public static void i(String str, String str2, int i2) {
        validateMethodCount(i2);
        log(4, str, str2, i2);
    }

    public static void json(String str, String str2, int i2) {
        validateMethodCount(i2);
        if (TextUtils.isEmpty(str2)) {
            d(str, "Empty/Null json content", i2);
            return;
        }
        try {
            if (str2.startsWith("{")) {
                d(str, new JSONObject(str2).toString(4), i2);
            } else if (str2.startsWith("[")) {
                d(str, new JSONArray(str2).toString(4), i2);
            }
        } catch (JSONException e2) {
            d(str, e2.getCause().getMessage() + "\n" + str2, i2);
        }
    }

    public static void v(String str, String str2, int i2) {
        validateMethodCount(i2);
        log(2, str, str2, i2);
    }

    public static void w(String str, String str2, int i2) {
        validateMethodCount(i2);
        log(5, str, str2, i2);
    }

    public static void wtf(String str, String str2, int i2) {
        validateMethodCount(i2);
        log(7, str, str2, i2);
    }

    public static void e(String str, int i2) {
        validateMethodCount(i2);
        e(TAG, str, i2);
    }

    public static void e(String str, String str2, int i2) {
        validateMethodCount(i2);
        e(str, str2, null, i2);
    }

    public static void e(String str, String str2, Exception exc) {
        e(str, str2, exc, settings.methodCount);
    }

    public static void e(String str, String str2, Exception exc, int i2) {
        validateMethodCount(i2);
        if (exc != null && str2 != null) {
            str2 = str2 + " : " + exc.toString();
        }
        if (exc != null && str2 == null) {
            str2 = exc.toString();
        }
        if (str2 == null) {
            str2 = "No message/exception is set";
        }
        log(6, str, str2, i2);
    }
}
