package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1572a = null;
    private static List<Integer> b = null;
    private static long c = -1;

    public static int myPid() {
        return Process.myPid();
    }

    public static String getCurrentProcessName() {
        String str = f1572a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processName = getProcessName(Process.myPid());
        f1572a = processName;
        return processName;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i2 = bufferedReader.read();
                if (i2 > 0) {
                    sb.append((char) i2);
                } else {
                    sb.trimToSize();
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                        return string;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return string;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                Log.e("efs.base", "get process name error", th);
                return "";
            } finally {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int i = Integer.parseInt(str);
            List<Integer> list = b;
            boolean z = false;
            if (list != null && !list.isEmpty() && c > 0 && System.currentTimeMillis() - c <= TTAdConstant.AD_MAX_EVENT_TIME) {
                z = true;
            }
            if (!z) {
                List<Integer> list2 = b;
                if (list2 != null) {
                    list2.clear();
                } else {
                    b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(i))) {
                    b.add(Integer.valueOf(i));
                }
                c = System.currentTimeMillis();
            }
            return b.contains(Integer.valueOf(i));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }
}
