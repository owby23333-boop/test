package com.xm.logsdk.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.ArrayMap;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.yuewen.eq2;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static SimpleDateFormat S_D_FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ");
    public static final String TAG = "CrashHandler";
    private ArrayMap<String, String> infos;
    private Context mContext;
    private CrashCallback mCrashCallback;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public interface CrashCallback {
        void crash(Throwable th);
    }

    public static class SingletonHolder {
        private static final CrashHandler INSTANCE = new CrashHandler();

        private SingletonHolder() {
        }
    }

    private String getCrashInfo(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(S_D_FORMAT.format(new Date()) + SignatureUtils.DELIMITER);
        if (this.mContext != null) {
            stringBuffer.append(this.mContext.getPackageName() + SignatureUtils.DELIMITER);
        }
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            stringBuffer.append(entry.getKey() + MscKeys.KEY_VAL_SEP + entry.getValue() + SignatureUtils.DELIMITER);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        return stringBuffer.toString();
    }

    public static CrashHandler getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private boolean handleException(Throwable th) {
        if (th == null) {
            th = new Exception("异常信息为空");
        }
        this.infos.clear();
        collectDeviceInfo(this.mContext);
        Logz.crash(getCrashInfo(th));
        CrashCallback crashCallback = this.mCrashCallback;
        if (crashCallback == null) {
            return true;
        }
        crashCallback.crash(th);
        return true;
    }

    public void collectDeviceInfo(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = eq2.g;
                }
                String str2 = packageInfo.versionCode + "";
                this.infos.put("versionName", str);
                this.infos.put("versionCode", str2);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logz.e(TAG, "an error occured when collect package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get(null).toString());
            } catch (Exception e2) {
                Logz.e(TAG, "an error occured when collect crash info", e2);
            }
        }
    }

    public void init(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void printDeviceInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            sb.append(entry.getKey() + MscKeys.KEY_VAL_SEP + entry.getValue() + SignatureUtils.DELIMITER);
        }
        Logz.i(sb.toString());
    }

    public void setCrashCallback(CrashCallback crashCallback) {
        this.mCrashCallback = crashCallback;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!handleException(th) || (uncaughtExceptionHandler = this.mDefaultHandler) == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    private CrashHandler() {
        this.infos = new ArrayMap<>();
        this.mCrashCallback = null;
    }
}
