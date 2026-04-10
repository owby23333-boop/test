package com.xiaomi.verificationsdk.internal;

import android.os.Build;
import com.xiaomi.accountsdk.utils.AccountLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class CheckRoot {
    private static String LOG_TAG = "com.xiaomi.verificationsdk.internal.CheckRoot";

    public static synchronized boolean checkAccessRootData() {
        try {
            AccountLogger.log(LOG_TAG, "to write /data");
            if (writeFile("/data/su_test", "test_ok").booleanValue()) {
                AccountLogger.log(LOG_TAG, "write ok");
            } else {
                AccountLogger.log(LOG_TAG, "write failed");
            }
            AccountLogger.log(LOG_TAG, "to read /data");
            String file = readFile("/data/su_test");
            AccountLogger.log(LOG_TAG, "strRead=" + file);
            return "test_ok".equals(file);
        } catch (Exception e) {
            AccountLogger.log(LOG_TAG, "Unexpected error - Here is what I know: " + e.getMessage());
            return false;
        }
    }

    public static synchronized boolean checkBusybox() {
        try {
            AccountLogger.log(LOG_TAG, "to exec busybox df");
            ArrayList<String> arrayListExecuteCommand = executeCommand(new String[]{"busybox", "df"});
            if (arrayListExecuteCommand == null) {
                AccountLogger.log(LOG_TAG, "execResult=null");
                return false;
            }
            AccountLogger.log(LOG_TAG, "execResult=" + arrayListExecuteCommand.toString());
            return true;
        } catch (Exception e) {
            AccountLogger.log(LOG_TAG, "Unexpected error - Here is what I know: " + e.getMessage());
            return false;
        }
    }

    public static boolean checkDeviceDebuggable() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        AccountLogger.log(LOG_TAG, "buildTags=" + str);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean checkGetRootAuth() {
        /*
            java.lang.Class<com.xiaomi.verificationsdk.internal.CheckRoot> r0 = com.xiaomi.verificationsdk.internal.CheckRoot.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.String r3 = com.xiaomi.verificationsdk.internal.CheckRoot.LOG_TAG     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r4 = "to exec su"
            com.xiaomi.accountsdk.utils.AccountLogger.log(r3, r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r4 = "su"
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62
            java.lang.String r2 = "exit\n"
            r4.writeBytes(r2)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            r4.flush()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            int r2 = r3.waitFor()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            java.lang.String r5 = com.xiaomi.verificationsdk.internal.CheckRoot.LOG_TAG     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            java.lang.String r7 = "exitValue="
            r6.append(r7)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            r6.append(r2)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            com.xiaomi.accountsdk.utils.AccountLogger.log(r5, r6)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L97
            if (r2 != 0) goto L51
            r4.close()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> La2
            r3.destroy()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> La2
            goto L4e
        L4a:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> La2
        L4e:
            monitor-exit(r0)
            r0 = 1
            return r0
        L51:
            r4.close()     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> La2
            r3.destroy()     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> La2
            goto L5c
        L58:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La2
        L5c:
            monitor-exit(r0)
            return r1
        L5e:
            r2 = move-exception
            goto L6e
        L60:
            r1 = move-exception
            goto L99
        L62:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
            goto L6e
        L67:
            r1 = move-exception
            r3 = r2
            goto L99
        L6a:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L6e:
            java.lang.String r5 = com.xiaomi.verificationsdk.internal.CheckRoot.LOG_TAG     // Catch: java.lang.Throwable -> L97
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "Unexpected error - Here is what I know: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L97
            r6.append(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L97
            com.xiaomi.accountsdk.utils.AccountLogger.log(r5, r2)     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L8d
            r4.close()     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La2
        L8d:
            r3.destroy()     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La2
            goto L95
        L91:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La2
        L95:
            monitor-exit(r0)
            return r1
        L97:
            r1 = move-exception
            r2 = r4
        L99:
            if (r2 == 0) goto L9e
            r2.close()     // Catch: java.lang.Throwable -> La2 java.lang.Exception -> La4
        L9e:
            r3.destroy()     // Catch: java.lang.Throwable -> La2 java.lang.Exception -> La4
            goto La8
        La2:
            r1 = move-exception
            goto La9
        La4:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> La2
        La8:
            throw r1     // Catch: java.lang.Throwable -> La2
        La9:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.verificationsdk.internal.CheckRoot.checkGetRootAuth():boolean");
    }

    public static boolean checkRootPathSU() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    AccountLogger.log(LOG_TAG, "find su in : " + strArr[i]);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean checkRootWhichSU() {
        ArrayList<String> arrayListExecuteCommand = executeCommand(new String[]{"/system/xbin/which", "su"});
        if (arrayListExecuteCommand == null) {
            AccountLogger.log(LOG_TAG, "execResult=null");
            return false;
        }
        AccountLogger.log(LOG_TAG, "execResult=" + arrayListExecuteCommand.toString());
        return true;
    }

    public static boolean checkSuperuserApk() {
        try {
            if (!new File("/system/app/Superuser.apk").exists()) {
                return false;
            }
            AccountLogger.log(LOG_TAG, "/system/app/Superuser.apk exist");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ArrayList<String> executeCommand(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            AccountLogger.log(LOG_TAG, "to shell exec which for find su :");
            Process processExec = Runtime.getRuntime().exec(strArr);
            new BufferedWriter(new OutputStreamWriter(processExec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    AccountLogger.log(LOG_TAG, "–> Line received: " + line);
                    arrayList.add(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            AccountLogger.log(LOG_TAG, "–> Full response was: " + arrayList);
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isDeviceRooted() {
        return checkDeviceDebuggable() || checkSuperuserApk() || checkRootPathSU() || checkRootWhichSU() || checkAccessRootData();
    }

    public static String readFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    AccountLogger.log(LOG_TAG, str2);
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean writeFile(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
