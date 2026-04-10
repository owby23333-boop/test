package com.baidu.tts.emstatistics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.foundation.g.a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class Utility {
    private static final String KEY_LSAT_DOWNLOAD_STAT_PERIOD = "last_download_stat_period";
    private static final String KEY_LSAT_UPLOAD_STAT_TIME = "last_upload_stat_time";
    private static final String LICENCE_FILE_NAME = "baidu_tts_licence.dat";
    private static final String SHARED_PREFERENCE_NAME = "tts";
    private static final String TAG = "Utility";

    public static boolean checkPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static byte[] decrypt2BASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes(a.bN);
                return Base64.decode(bytes, 0, bytes.length, 0);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String decryptBASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes(a.bN);
                return new String(Base64.decode(bytes, 0, bytes.length, 0), a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String decryptGZIP(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i2 = gZIPInputStream.read(bArr2, 0, 1024);
                    if (i2 == -1) {
                        gZIPInputStream.close();
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return new String(byteArray, a.bN);
                    }
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static String encryptBASE64(String str) {
        if (str != null && str.length() != 0) {
            try {
                byte[] bytes = str.getBytes(a.bN);
                return new String(Base64.encode(bytes, 0, bytes.length, 0), a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] encryptGZIP(String str) {
        if (str != null && str.length() != 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes(a.bN));
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static String findWakeUpWord(String str, List<String> list) {
        if (str == null || list == null) {
            return null;
        }
        String strReplace = str.replace(" ", "");
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str2 = list.get(i2);
            int iIndexOf = strReplace.indexOf(str2);
            if (iIndexOf != -1 && iIndexOf + 2 + str2.length() <= strReplace.length()) {
                return str2;
            }
        }
        return null;
    }

    public static String getApkLibPath(Context context) {
        return context.getDir("asr", 0).getParent() + File.separator + "lib" + File.separator;
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String getApplicationName(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static Context getContext() {
        return PersistentPool.getInstance().getContext();
    }

    public static int getLastDownloadStatPeriod(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).getInt(KEY_LSAT_DOWNLOAD_STAT_PERIOD, 0);
    }

    public static long getLastUploadStatTime(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).getLong(KEY_LSAT_UPLOAD_STAT_TIME, 0L);
    }

    public static byte[] getLicenseData(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStreamOpenFileInput = null;
        try {
            try {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(LICENCE_FILE_NAME);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = fileInputStreamOpenFileInput.read(bArr);
                        if (i2 != -1) {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    if (fileInputStreamOpenFileInput == null) {
                        throw th;
                    }
                    try {
                        fileInputStreamOpenFileInput.close();
                        throw th;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception unused) {
                LoggerProxy.d(TAG, "license not found by default");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                if (fileInputStreamOpenFileInput != null) {
                    fileInputStreamOpenFileInput.close();
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] getLicenseDataFromAsset(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = context.getResources().getAssets().open(LICENCE_FILE_NAME);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = inputStreamOpen.read(bArr);
                        if (i2 != -1) {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (Exception unused) {
                    LoggerProxy.d(TAG, "license not found in assets");
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            if (0 == 0) {
                throw th;
            }
            try {
                inputStreamOpen.close();
                throw th;
            } catch (IOException e6) {
                e6.printStackTrace();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0028 -> B:49:0x0056). Please report as a decompilation issue!!! */
    public static byte[] getLicenseDataFromFile(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
            r1 = r1;
        }
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 != -1) {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    r1 = bArr;
                } catch (Exception unused) {
                    r1 = fileInputStream;
                    LoggerProxy.d(TAG, "license not found at file: " + str);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    if (r1 != 0) {
                        r1.close();
                        r1 = r1;
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    r1 = fileInputStream;
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (r1 == 0) {
                        throw th;
                    }
                    try {
                        r1.close();
                        throw th;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !UtilityImpl.NET_TYPE_WIFI.equals(activeNetworkInfo.getTypeName().toLowerCase())) ? 3 : 1;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String getOS() {
        return "Android";
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static String getPlatform(Context context) {
        return getOS() + DispatchConstants.SIGN_SPLIT_SYMBOL + Build.MODEL + DispatchConstants.SIGN_SPLIT_SYMBOL + Build.VERSION.RELEASE + DispatchConstants.SIGN_SPLIT_SYMBOL + Build.VERSION.SDK_INT + DispatchConstants.SIGN_SPLIT_SYMBOL + getNetType(context);
    }

    public static String getScreen(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static String getSdkName() {
        return "离在线融合TTS SDK";
    }

    public static String getSdkVersion() {
        return SpeechSynthesizer.VERSION_NAME;
    }

    public static String getSignatureMD5(Context context) {
        try {
            return parseSignature(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<String> getWakeUpWordFromFile(Context context) {
        InputStream inputStreamOpen;
        ArrayList arrayList = new ArrayList();
        try {
            inputStreamOpen = context.getResources().getAssets().open("wakeup.cfg");
        } catch (IOException e2) {
            e2.printStackTrace();
            inputStreamOpen = null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
        try {
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String strTrim = line.trim();
                    if (!strTrim.equals("")) {
                        arrayList.add(strTrim);
                    }
                }
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
                bufferedReader.close();
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    private static String parseSignature(byte[] bArr) {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(x509Certificate.getEncoded());
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (CertificateException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x001e -> B:23:0x0021). Please report as a decompilation issue!!! */
    public static void saveLicenseData(Context context, byte[] bArr, int i2) {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                fileOutputStreamOpenFileOutput = context.openFileOutput(LICENCE_FILE_NAME, 0);
                fileOutputStreamOpenFileOutput.write(bArr, 0, i2);
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void setLastDownloadStatPeriod(Context context, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).edit();
        editorEdit.putInt(KEY_LSAT_DOWNLOAD_STAT_PERIOD, i2);
        editorEdit.commit();
    }

    public static void setLastUploadStatTime(Context context, long j2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).edit();
        editorEdit.putLong(KEY_LSAT_UPLOAD_STAT_TIME, j2);
        editorEdit.commit();
    }

    public static String stringToMd5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                if (Integer.toHexString(bArrDigest[i2] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(bArrDigest[i2] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i2] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static short[] swapShort(byte[] bArr, int i2) {
        Short shValueOf;
        if (bArr == null || i2 < 2) {
            return null;
        }
        int i3 = i2 / 2;
        short[] sArr = new short[i3];
        ByteOrder byteOrderNativeOrder = ByteOrder.nativeOrder();
        for (int i4 = 0; i4 < i3; i4++) {
            if (byteOrderNativeOrder.equals(ByteOrder.BIG_ENDIAN)) {
                int i5 = i4 * 2;
                shValueOf = Short.valueOf((short) ((bArr[i5 + 1] & 255) | ((bArr[i5] << 8) & 255)));
            } else {
                int i6 = i4 * 2;
                shValueOf = Short.valueOf((short) ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8)));
            }
            sArr[i4] = shValueOf.shortValue();
        }
        return sArr;
    }

    private static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static String encryptBASE64(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return new String(Base64.encode(bArr, 0, bArr.length, 0), a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
