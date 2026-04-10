package com.baidu.tts.tools.cuid.util_GP;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class DeviceIdUtil {
    private static final boolean DEBUG = false;
    static final int SDK_ANDROID_M = 23;
    private static final String TAG = "DeviceId";

    private DeviceIdUtil() {
    }

    static boolean checkSelfPermission(Context context, String str) {
        return context != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    static String getFileContent(File file) throws Throwable {
        FileReader fileReader;
        char[] cArr;
        CharArrayWriter charArrayWriter;
        try {
            fileReader = new FileReader(file);
        } catch (Exception e2) {
            e = e2;
            fileReader = null;
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            try {
                cArr = new char[8192];
                charArrayWriter = new CharArrayWriter();
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                int i2 = fileReader.read(cArr);
                if (i2 <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, i2);
                th = th2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                        handleThrowable(e3);
                    }
                }
                throw th;
            }
            String string = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Exception e4) {
                handleThrowable(e4);
            }
            return string;
        } catch (Exception e5) {
            e = e5;
            handleThrowable(e);
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e6) {
                    handleThrowable(e6);
                }
            }
            return null;
        }
    }

    static String getSystemSettingValue(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e2) {
            handleThrowable(e2);
            return null;
        }
    }

    static void handleThrowable(Throwable th) {
    }

    static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasWriteSettingsPermission(Context context) {
        return checkSelfPermission(context, "android.permission.WRITE_SETTINGS");
    }

    static boolean isLegalSrc(String str, int i2) {
        if (TextUtils.isEmpty(str) || i2 == 0) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]{1,5}$");
    }

    static String toHexString(byte[] bArr, String str, boolean z2) {
        return MD5Util.toHexString(bArr, str, z2);
    }

    static String toMd5(byte[] bArr, boolean z2) {
        return MD5Util.toMd5(bArr, z2);
    }

    static boolean tryPutSystemSettingValue(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e2) {
            handleThrowable(e2);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0030 -> B:36:0x0033). Please report as a decompilation issue!!! */
    static void writeToFile(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e2) {
            handleThrowable(e2);
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (SecurityException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            handleThrowable(e5);
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (SecurityException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
