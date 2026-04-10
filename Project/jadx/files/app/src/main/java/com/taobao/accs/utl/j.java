package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.IProcessName;
import com.umeng.message.entity.UMessage;
import java.io.File;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static String a = "";
    public static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.taobao.accs.d f18326c = null;
    public static final String channelService = "com.taobao.accs.ChannelService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f18327d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f18328e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f18329f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f18330g = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean a(Context context) {
        String str;
        if (f18330g) {
            return f18329f;
        }
        try {
            if (TextUtils.isEmpty(com.taobao.accs.client.a.f18130d)) {
                if (TextUtils.isEmpty(f18327d)) {
                    f18327d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                str = f18327d;
            } else {
                str = com.taobao.accs.client.a.f18130d;
            }
            if (TextUtils.isEmpty(f18328e)) {
                f18328e = a(context, Process.myPid());
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f18328e)) {
                f18329f = str.equalsIgnoreCase(f18328e);
                f18330g = true;
            }
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
        }
        return f18329f;
    }

    public static String b(Context context) {
        com.taobao.accs.d dVar = f18326c;
        return dVar == null ? UTDevice.getUtdid(context) : dVar.a();
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = com.taobao.accs.client.a.a(context).b().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).areNotificationsEnabled());
            } catch (Throwable th) {
                ALog.e("AdapterUtilityImpl", "Android above 7.0 isNotificationEnabled", th, new Object[0]);
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                boolean z2 = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i2), packageName)).intValue() != 0) {
                    z2 = false;
                }
                return String.valueOf(z2);
            } catch (Throwable th2) {
                ALog.e("AdapterUtilityImpl", "isNotificationEnabled", th2, new Object[0]);
            }
        }
        return "unknown";
    }

    public static String a(Context context, int i2) {
        IProcessName iProcessName = com.taobao.accs.client.a.f18132f;
        if (iProcessName != null) {
            return iProcessName.getCurrProcessName();
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com.taobao.accs.client.a.a(context).a().getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i2) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (!dataDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static final boolean a(String str, int i2) {
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        int blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        StringBuilder sb = new StringBuilder();
        sb.append("st.getAvailableBlocks()=");
        sb.append(statFs.getAvailableBlocks());
        sb.append(",st.getAvailableBlocks() * blockSize=");
        long j2 = blockSize;
        sb.append(((long) statFs.getAvailableBlocks()) * j2);
        ALog.d("FileCheckUtils", sb.toString(), new Object[0]);
        return statFs.getAvailableBlocks() > 10 && availableBlocks * j2 > ((long) i2);
    }
}
