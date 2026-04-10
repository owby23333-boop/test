package com.taobao.aranger.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.core.common.g.g;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class IPCUtils {
    private static String sCurrentProcessName;
    private static Set<String> providerInfoSet = new CopyOnWriteArraySet();
    private static List<ProviderInfo> providerInfoList = new CopyOnWriteArrayList();

    public static String getAuthorityWithoutUserId(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(64) + 1);
    }

    private static Uri getContentAuthorities(String str) {
        return Uri.parse("content://" + str);
    }

    public static String getCurrentProcessName() {
        String str = sCurrentProcessName;
        if (str == null || str.length() == 0) {
            sCurrentProcessName = getProcessName(Process.myPid());
        }
        return sCurrentProcessName;
    }

    private static String getProcessName(int i2) throws Throwable {
        FileInputStream fileInputStream;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) ARanger.getContext().getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i2) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/" + i2 + "/cmdline");
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            int i3 = fileInputStream.read(bArr);
            if (i3 <= 0) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                if (bArr[i4] <= 0) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            String str = new String(bArr, 0, i3);
            try {
                fileInputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return str;
        } catch (Exception unused2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String getProcessNameFromUri(Uri uri) {
        for (ProviderInfo providerInfo : providerInfoList) {
            if (getContentAuthorities(providerInfo.authority).equals(uri)) {
                return providerInfo.processName;
            }
        }
        return null;
    }

    public static int getUserIdFromAuthority(String str, int i2) {
        int iLastIndexOf;
        if (str == null || (iLastIndexOf = str.lastIndexOf(64)) == -1) {
            return i2;
        }
        try {
            return Integer.parseInt(str.substring(0, iLastIndexOf));
        } catch (NumberFormatException unused) {
            return g.f7504i;
        }
    }

    public static boolean isProcessAlive(ComponentName componentName) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            if (!providerInfoSet.contains(componentName.getPackageName())) {
                providerInfoSet.add(componentName.getPackageName());
                Collections.addAll(providerInfoList, ARanger.getContext().getPackageManager().getPackageInfo(componentName.getPackageName(), 8).providers);
            }
            str = "";
            for (ProviderInfo providerInfo : providerInfoList) {
                if (providerInfo.name.equals(componentName.getClassName())) {
                    str = providerInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str) || (runningAppProcesses = ((ActivityManager) ARanger.getContext().getSystemService("activity")).getRunningAppProcesses()) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (it.next().processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Uri queryContentAuthorityFromProvider(ComponentName componentName) throws IPCException {
        try {
            if (!providerInfoSet.contains(componentName.getPackageName())) {
                providerInfoSet.add(componentName.getPackageName());
                Collections.addAll(providerInfoList, ARanger.getContext().getPackageManager().getPackageInfo(componentName.getPackageName(), 8).providers);
            }
            for (ProviderInfo providerInfo : providerInfoList) {
                if (providerInfo.name.equals(componentName.getClassName())) {
                    return getContentAuthorities(providerInfo.authority);
                }
            }
            throw new IPCException(29, "can't find authorities in the " + componentName.getClass() + ", please check the provider is correct.");
        } catch (Exception e2) {
            throw new IPCException(30, e2);
        }
    }
}
