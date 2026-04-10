package com.bytedance.pangle.gc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static List<String> g = new CopyOnWriteArrayList();
    private static String z;

    private static String z() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String z(Context context) {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    z = processName;
                }
                return z;
            }
        } catch (Throwable unused) {
        }
        try {
            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) objInvokeStaticMethod)) {
                z = (String) objInvokeStaticMethod;
            }
            return z;
        } catch (Exception e) {
            m.z(e);
            String strZ = z();
            z = strZ;
            return strZ;
        }
    }

    public static boolean g(Context context) {
        String strZ = z(context);
        return (strZ == null || !strZ.contains(":")) && strZ != null && strZ.equals(context.getPackageName());
    }

    public static String z(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1];
    }
}
