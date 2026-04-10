package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
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

/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static Boolean mb;

    public static boolean b(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static boolean h() {
        for (String str : new String[]{mb("2f7362696e2f7375"), mb("2f73797374656d2f62696e2f7375"), mb("2f73797374656d2f7862696e2f7375"), mb("2f646174612f6c6f63616c2f7862696e2f7375"), mb("2f646174612f6c6f63616c2f62696e2f7375"), mb("2f73797374656d2f73642f7862696e2f7375"), mb("2f73797374656d2f62696e2f6661696c736166652f7375"), mb("2f646174612f6c6f63616c2f7375")}) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static int hj() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, mb("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    public static boolean mb() {
        Boolean bool = mb;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static boolean ox() {
        if (hj() == 0) {
            return true;
        }
        return h();
    }

    private static boolean u() {
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
                if (str.contains(mb("636f6d2e73617572696b2e737562737472617465")) || str.contains(mb("58706f7365644272696467652e6a6172")) || str.contains(mb("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static synchronized void mb(@NonNull Context context) {
        if (mb == null) {
            mb = Boolean.valueOf((ox() || ox(context) || b(context) || !hj(context) || b() || h(context)) ? false : true);
        }
    }

    public static boolean ox(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static boolean b() {
        try {
            InetAddress.getByName(mb("3132372e302e302e31"));
            new Socket(mb("3132372e302e302e31"), Integer.parseInt(mb("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean hj(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String mb(@NonNull String str) {
        return DownloadUtils.hexToString(str);
    }

    @WorkerThread
    public static boolean h(Context context) {
        return u() || u(context);
    }

    private static boolean u(Context context) {
        List listAsList = Arrays.asList(mb("64652e726f62762e616e64726f69642e78706f736564"), mb("636f6d2e746f706a6f686e77752e6d616769736b"), mb("696f2e76612e6578706f736564"), mb("636f6d2e77696e642e636f74746572"), mb("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), mb("6d652e7765697368752e657870"), mb("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }
}
