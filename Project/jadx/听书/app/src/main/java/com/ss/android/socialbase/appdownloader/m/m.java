package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.wp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private static Boolean z;

    public static boolean z() {
        Boolean bool = z;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static synchronized void z(Context context) {
        if (z == null) {
            z = Boolean.valueOf((g() || g(context) || dl(context) || !a(context) || dl() || gc(context)) ? false : true);
        }
    }

    public static boolean g() {
        if (a() == 0) {
            return true;
        }
        return gc();
    }

    public static boolean g(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static int a() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, z("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    private static boolean gc() {
        String[] strArr = {z("2f7362696e2f7375"), z("2f73797374656d2f62696e2f7375"), z("2f73797374656d2f7862696e2f7375"), z("2f646174612f6c6f63616c2f7862696e2f7375"), z("2f646174612f6c6f63616c2f62696e2f7375"), z("2f73797374656d2f73642f7862696e2f7375"), z("2f73797374656d2f62696e2f6661696c736166652f7375"), z("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean dl(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static boolean a(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    public static boolean dl() {
        try {
            InetAddress.getByName(z("3132372e302e302e31"));
            new Socket(z("3132372e302e302e31"), Integer.parseInt(z("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean gc(Context context) {
        return m() || m(context);
    }

    private static boolean m() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(z("636f6d2e73617572696b2e737562737472617465")) || str.contains(z("58706f7365644272696467652e6a6172")) || str.contains(z("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean m(Context context) {
        List listAsList = Arrays.asList(z("64652e726f62762e616e64726f69642e78706f736564"), z("636f6d2e746f706a6f686e77752e6d616769736b"), z("696f2e76612e6578706f736564"), z("636f6d2e77696e642e636f74746572"), z("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), z("6d652e7765697368752e657870"), z("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                wp.z(e);
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    private static String z(String str) {
        return com.ss.android.socialbase.downloader.pf.m.z(str);
    }
}
