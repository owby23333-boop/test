package cn.bmob.v3.util;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.bmob.v3.Bmob;

/* JADX INFO: loaded from: classes.dex */
public class ManifestUtils {
    private static final String TAG = "bmob";
    private static String displayName = null;
    private static int iconId = 0;
    private static final Object lock = new Object();
    static int versionCode = -1;
    static String versionName;

    public static boolean detectNetWork(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return getPermissionData(context).contains("android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable();
    }

    private static ApplicationInfo getApplicationInfo(Context context, int i2) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static Context getContext() {
        return Bmob.getApplicationContext();
    }

    public static String getDisplayName() {
        synchronized (lock) {
            if (displayName == null) {
                displayName = getContext().getPackageManager().getApplicationLabel(getContext().getApplicationInfo()).toString();
            }
        }
        return displayName;
    }

    public static int getIconId() {
        synchronized (lock) {
            if (iconId == 0) {
                iconId = getContext().getApplicationInfo().icon;
            }
        }
        return iconId;
    }

    public static Bundle getMetaData() {
        ApplicationInfo applicationInfo = getApplicationInfo(getContext(), 128);
        if (applicationInfo != null) {
            return applicationInfo.metaData;
        }
        return null;
    }

    public static String getNetType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "4";
        }
        if ("WIFI".equals(activeNetworkInfo.getTypeName())) {
            return "3";
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        return !TextUtils.isEmpty(extraInfo) ? (extraInfo.equals("3gwap") || extraInfo.equals("3gnet")) ? "2" : (extraInfo.equals("uninet") || extraInfo.equals("uniwap") || extraInfo.equals("cmwap") || extraInfo.equals("cmnet") || extraInfo.equals("ctwap") || extraInfo.equals("ctnet")) ? "1" : "4" : "4";
    }

    private static PackageInfo getPackageInfo(String str) {
        try {
            return getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static PackageManager getPackageManager() {
        return getContext().getPackageManager();
    }

    public static String getPermissionData(Context context) {
        String[] strArr;
        PackageManager packageManager = context.getPackageManager();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            strArr = null;
        }
        if (strArr != null) {
            for (String str : strArr) {
                stringBuffer.append(str);
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    private static ActivityInfo getReceiverInfo(Class<? extends BroadcastReceiver> cls) {
        try {
            return getPackageManager().getReceiverInfo(new ComponentName(getContext(), cls), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ServiceInfo getServiceInfo(Class<? extends Service> cls) {
        try {
            return getPackageManager().getServiceInfo(new ComponentName(getContext(), cls), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int getVersionCode() {
        synchronized (lock) {
            if (versionCode == -1) {
                try {
                    versionCode = getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e2) {
                    BLog.e("bmob", "Couldn't find info about own package", e2);
                }
            }
        }
        return versionCode;
    }

    public static String getVersionName() {
        synchronized (lock) {
            if (versionName == null) {
                try {
                    versionName = getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    BLog.e("bmob", "Couldn't find info about own package", e2);
                }
            }
        }
        return versionName;
    }

    public static String getMetaData(String str) {
        Bundle metaData = getMetaData();
        if (metaData != null) {
            return metaData.getString(str);
        }
        return null;
    }
}
