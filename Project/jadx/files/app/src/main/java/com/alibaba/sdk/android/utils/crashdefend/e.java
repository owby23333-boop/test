package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashDefendUtils.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    static void a(Context context, a aVar, List<c> list) {
        if (context == null) {
            return;
        }
        synchronized (list) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.a);
                    }
                    if (list != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            for (c cVar : list) {
                                if (cVar != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("sdkId", cVar.f56c);
                                    jSONObject2.put(Constants.KEY_SDK_VERSION, cVar.f57d);
                                    jSONObject2.put("crashLimit", cVar.b);
                                    jSONObject2.put("crashCount", cVar.crashCount);
                                    jSONObject2.put("waitTime", cVar.f2247c);
                                    jSONObject2.put("registerSerialNumber", cVar.f55b);
                                    jSONObject2.put("startSerialNumber", cVar.a);
                                    jSONObject2.put("restoreCount", cVar.f2248d);
                                    jSONArray.put(jSONObject2);
                                }
                            }
                            jSONObject.put("sdkList", jSONArray);
                        } catch (JSONException unused) {
                        }
                    }
                    String string = jSONObject.toString();
                    fileOutputStreamOpenFileOutput = a(context) ? context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info", 0) : context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info_" + b(context), 0);
                    fileOutputStreamOpenFileOutput.write(string.getBytes());
                } catch (IOException unused2) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Exception unused4) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String b(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String strD = d(context);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String strC = c();
        return !TextUtils.isEmpty(strC) ? strC : c(context);
    }

    private static String c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private static String d(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "getProcessNameByActivityThread error: " + e2;
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c() throws java.lang.Throwable {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L3b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            goto L3c
        L39:
            r2 = move-exception
            goto L4b
        L3b:
            r0 = r1
        L3c:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
            goto L60
        L42:
            r0 = move-exception
            r0.printStackTrace()
            goto L60
        L47:
            r0 = move-exception
            goto L65
        L49:
            r2 = move-exception
            r0 = r1
        L4b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "getProcessNameByPid error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L61
            r3.append(r2)     // Catch: java.lang.Throwable -> L61
            r3.toString()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
        L60:
            return r1
        L61:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L65:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r1 = move-exception
            r1.printStackTrace()
        L6f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.c():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0049 A[EXC_TOP_SPLITTER, PHI: r1
  0x0049: PHI (r1v5 java.io.FileInputStream) = 
  (r1v1 java.io.FileInputStream)
  (r1v2 java.io.FileInputStream)
  (r1v3 java.io.FileInputStream)
  (r1v14 java.io.FileInputStream)
 binds: [B:23:0x0050, B:25:0x0053, B:29:0x006b, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean m38a(android.content.Context r9, com.alibaba.sdk.android.utils.crashdefend.a r10, java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r11) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.e.m38a(android.content.Context, com.alibaba.sdk.android.utils.crashdefend.a, java.util.List):boolean");
    }

    private static boolean a(Context context) {
        return context.getPackageName().equalsIgnoreCase(b(context));
    }
}
