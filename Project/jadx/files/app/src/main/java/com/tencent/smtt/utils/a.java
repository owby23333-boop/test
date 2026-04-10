package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static int a(Context context, File file) {
        return a(context, file, 0);
    }

    public static int a(Context context, File file, int i2) {
        try {
            return a(context, file, Build.VERSION.SDK_INT >= 20 ? !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME) : false, i2);
        } catch (Exception unused) {
            TbsLog.i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    public static int a(Context context, File file, boolean z2, int i2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean zContains = file.getName().contains("tbs.org");
                    boolean zContains2 = file.getName().contains("x5.tbs.decouple");
                    if (zContains || zContains2) {
                        int iA = a(zContains2, file, i2);
                        if (iA > 0) {
                            return iA;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    boolean z3 = (Build.VERSION.SDK_INT == 23 || Build.VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z2 = false;
                        z3 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if (z2 || z3) {
                        int iB = b(file);
                        if (iB > 0) {
                            return iB;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    private static int a(boolean z2, File file, int i2) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] fileArrListFiles = parentFile.listFiles();
            Pattern patternCompile = Pattern.compile(a(z2, i2) + "(.*)");
            for (File file2 : fileArrListFiles) {
                if (patternCompile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r10) {
        /*
            r0 = 16
            char[] r1 = new char[r0]
            r1 = {x0076: FILL_ARRAY_DATA , data: [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102} // fill-array
            r2 = 32
            char[] r2 = new char[r2]
            r3 = 0
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            r10 = 8192(0x2000, float:1.148E-41)
            byte[] r10 = new byte[r10]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
        L1b:
            int r6 = r5.read(r10)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r7 = -1
            r8 = 0
            if (r6 == r7) goto L27
            r4.update(r10, r8, r6)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            goto L1b
        L27:
            byte[] r10 = r4.digest()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r4 = 0
        L2c:
            if (r8 >= r0) goto L45
            r6 = r10[r8]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            int r7 = r4 + 1
            int r9 = r6 >>> 4
            r9 = r9 & 15
            char r9 = r1[r9]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r2[r4] = r9     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            int r4 = r7 + 1
            r6 = r6 & 15
            char r6 = r1[r6]     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r2[r7] = r6     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            int r8 = r8 + 1
            goto L2c
        L45:
            java.lang.String r10 = new java.lang.String     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r10.<init>(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L68
            r5.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r0 = move-exception
            r0.printStackTrace()
        L52:
            return r10
        L53:
            r10 = move-exception
            goto L5a
        L55:
            r10 = move-exception
            r5 = r3
            goto L69
        L58:
            r10 = move-exception
            r5 = r3
        L5a:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L68
            if (r5 == 0) goto L67
            r5.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r10 = move-exception
            r10.printStackTrace()
        L67:
            return r3
        L68:
            r10 = move-exception
        L69:
            if (r5 == 0) goto L73
            r5.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r0 = move-exception
            r0.printStackTrace()
        L73:
            goto L75
        L74:
            throw r10
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.a(java.io.File):java.lang.String");
    }

    public static final String a(boolean z2) {
        return a(z2, 0);
    }

    public static final String a(boolean z2, int i2) {
        return i2 == 64 ? true : i2 == 32 ? false : b.c() ? z2 ? "x5.64.decouple.backup" : "x5.64.backup" : z2 ? "x5.decouple.backup" : "x5.backup";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        r1 = r1[1].trim();
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "getApkVersionByReadFile version is " + r1);
        r1 = java.lang.Integer.parseInt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0086, code lost:
    
        r7.close();
        r2.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.io.File r7) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.b(java.io.File):int");
    }
}
