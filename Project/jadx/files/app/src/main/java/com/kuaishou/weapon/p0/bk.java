package com.kuaishou.weapon.p0;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class bk {
    public static String A() {
        try {
            String strA = bg.a("persist.service.bdroid.bdaddr");
            return TextUtils.isEmpty(strA) ? bh.f16564c : strA;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "gsm.version.baseband");
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String D() {
        try {
            return BigDecimal.valueOf((new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String E() {
        try {
            return BigDecimal.valueOf((new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String F() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? bh.a : BigDecimal.valueOf((new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String G() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? bh.a : BigDecimal.valueOf((new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static long H() {
        BufferedReader bufferedReader;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        do {
            try {
                line = bufferedReader.readLine();
                if (line != null) {
                }
            } catch (Throwable unused2) {
                if (bufferedReader == null) {
                    return 0L;
                }
            }
            try {
                bufferedReader.close();
                return 0L;
            } catch (IOException unused3) {
                return 0L;
            }
        } while (!line.contains("MemTotal"));
        long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue();
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return jLongValue;
    }

    public static String I() {
        try {
            return f.a(new File("/system/bin/app_process"));
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String J() {
        try {
            File file = new File("/system/bin/servicemanager");
            return (file.exists() && file.canRead()) ? f.a(file) : bh.f16565d;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String K() {
        try {
            File file = new File("/system/framework/framework.jar");
            return (file.exists() && file.canRead()) ? f.a(file) : bh.f16565d;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String L() {
        if (Build.VERSION.SDK_INT >= 14) {
            return Build.getRadioVersion();
        }
        return null;
    }

    private static float a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static int a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getPhoneType();
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String a() {
        try {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    private static float b(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.ydpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static String b() {
        try {
            String str = Build.BRAND;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String b(Context context) {
        String defaultUserAgent;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                    defaultUserAgent = System.getProperty("http.agent");
                }
            } else {
                defaultUserAgent = System.getProperty("http.agent");
            }
            return TextUtils.isEmpty(defaultUserAgent) ? bh.f16564c : defaultUserAgent;
        } catch (Throwable unused2) {
            return bh.f16565d;
        }
    }

    public static String c() {
        try {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String c(Context context) {
        int iIntValue;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int iWidth = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                iWidth = maximumWindowMetrics.getBounds().width();
                iIntValue = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                iWidth = point.x;
                iIntValue = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                iIntValue = 0;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                int iIntValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                iIntValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                iWidth = iIntValue2;
            }
            float fA = a(j(context));
            float fB = b(j(context));
            if (fA != 0.0f && fB != 0.0f) {
                int iRound = Math.round((iWidth / fA) * 2.54f) * 10;
                int iRound2 = Math.round((iIntValue / fB) * 2.54f) * 10;
                if (iRound > iRound2) {
                    return iRound2 + "mm * " + iRound + "mm";
                }
                return iRound + "mm * " + iRound2 + "mm";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String d() {
        try {
            String str = Build.HARDWARE;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String d(Context context) {
        int iIntValue;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            int iWidth = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                iWidth = maximumWindowMetrics.getBounds().width();
                iIntValue = maximumWindowMetrics.getBounds().height();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                iWidth = point.x;
                iIntValue = point.y;
            } else if (Build.VERSION.SDK_INT >= 17 || Build.VERSION.SDK_INT < 14) {
                iIntValue = 0;
            } else {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                int iIntValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                iIntValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                iWidth = iIntValue2;
            }
            if (iWidth > iIntValue) {
                return iIntValue + "*" + iWidth;
            }
            return iWidth + "*" + iIntValue;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e() {
        try {
            String str = Build.PRODUCT;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String e(Context context) {
        DisplayMetrics displayMetricsJ = j(context);
        if (displayMetricsJ != null) {
            return Integer.toString(displayMetricsJ.densityDpi);
        }
        return null;
    }

    public static String f() {
        try {
            String str = Build.DEVICE;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String f(Context context) {
        Process processExec;
        InputStream inputStream = null;
        str = null;
        String str = null;
        inputStream = null;
        try {
            processExec = Runtime.getRuntime().exec("cat /proc/version");
            try {
                InputStream inputStream2 = processExec.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    int i2 = inputStream2.read(bArr);
                    if (i2 <= 0) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable unused) {
                            }
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return bh.f16564c;
                    }
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    String str2 = new String(bArr2, com.anythink.expressad.foundation.g.a.bN);
                    int iIndexOf = str2.indexOf("version");
                    if (iIndexOf != -1) {
                        String[] strArrSplit = str2.substring(iIndexOf).split(" ");
                        if (1 < strArrSplit.length) {
                            str = strArrSplit[1];
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return bh.f16564c;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return str;
                } catch (Throwable unused4) {
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (processExec == null) {
                        return bh.f16565d;
                    }
                    processExec.destroy();
                    return bh.f16565d;
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            processExec = null;
        }
    }

    public static int g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            return -2;
        }
    }

    public static String g() {
        try {
            String str = Build.BOARD;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static int h(Context context) {
        try {
            return ((AudioManager) context.getSystemService(com.anythink.expressad.exoplayer.k.o.b)).getRingerMode();
        } catch (Exception unused) {
            return -2;
        }
    }

    public static String h() {
        try {
            String str = Build.HOST;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static int i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue() ? 0 : 1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String i() {
        try {
            String str = Build.USER;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    private static DisplayMetrics j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j() {
        try {
            String str = Build.TYPE;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String k() {
        try {
            String str = Build.TAGS;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String l() {
        try {
            String str = Build.BOOTLOADER;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String m() {
        try {
            String str = Build.ID;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String n() {
        try {
            String str = Build.DISPLAY;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String o() {
        try {
            String str = Build.VERSION.CODENAME;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String p() {
        try {
            String strA = bg.a("rild.libpath");
            return TextUtils.isEmpty(strA) ? bh.f16564c : strA;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String q() {
        try {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String s() {
        try {
            String str = Build.FINGERPRINT;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String t() {
        try {
            String property = System.getProperty("http.agent");
            return TextUtils.isEmpty(property) ? bh.f16564c : property;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String u() {
        Process processExec;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            processExec = Runtime.getRuntime().exec("uname -a");
            try {
                inputStream = processExec.waitFor() == 0 ? processExec.getInputStream() : processExec.getErrorStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
                } catch (Throwable unused) {
                }
                try {
                    String line = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    return line;
                } catch (Throwable unused4) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    if (processExec == null) {
                        return bh.f16565d;
                    }
                    processExec.destroy();
                    return bh.f16565d;
                }
            } catch (Throwable unused7) {
                inputStream = null;
            }
        } catch (Throwable unused8) {
            processExec = null;
            inputStream = null;
        }
    }

    public static String v() {
        try {
            String str = Build.RADIO;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String w() {
        try {
            String strA = bg.a("ro.build.description");
            return TextUtils.isEmpty(strA) ? bh.f16564c : strA;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            return TextUtils.isEmpty(str) ? bh.f16564c : str;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String y() {
        try {
            String strA = bg.a("ro.product.name");
            return TextUtils.isEmpty(strA) ? bh.f16564c : strA;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }

    public static String z() {
        try {
            String strA = bg.a("dalvik.vm.heapgrowthlimit");
            return TextUtils.isEmpty(strA) ? bh.f16564c : strA;
        } catch (Throwable unused) {
            return bh.f16565d;
        }
    }
}
