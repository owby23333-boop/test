package com.bytedance.z.g.gz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    private static String z;

    public static String z(Context context) {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        String strZ = z();
        z = strZ;
        if (!TextUtils.isEmpty(strZ)) {
            return z;
        }
        String strG = g();
        z = strG;
        if (!TextUtils.isEmpty(strG)) {
            return z;
        }
        String strDl = dl();
        z = strDl;
        return strDl;
    }

    private static String z() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    private static String g() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    private static String dl() {
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
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }
}
