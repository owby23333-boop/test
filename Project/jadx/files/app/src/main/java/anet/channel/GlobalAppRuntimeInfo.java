package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class GlobalAppRuntimeInfo {
    private static Context a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f238g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile long f242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f243l;
    private static ENV b = ENV.ONLINE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f234c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f235d = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f239h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static SharedPreferences f240i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f241j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (f241j == null) {
                f241j = new CopyOnWriteArrayList<>();
            }
            f241j.add(str);
            f241j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f241j;
    }

    public static Context getContext() {
        return a;
    }

    public static String getCurrentProcess() {
        return f235d;
    }

    public static ENV getEnv() {
        return b;
    }

    @Deprecated
    public static long getInitTime() {
        return f242k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.a;
        }
        return -1;
    }

    public static String getTtid() {
        return f236e;
    }

    public static String getUserId() {
        return f237f;
    }

    public static String getUtdid() {
        Context context;
        if (f238g == null && (context = a) != null) {
            f238g = Utils.getDeviceId(context);
        }
        return f238g;
    }

    public static boolean isAppBackground() {
        if (a == null) {
            return true;
        }
        return f239h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f234c) || TextUtils.isEmpty(f235d)) {
            return true;
        }
        return f234c.equalsIgnoreCase(f235d);
    }

    public static void setBackground(boolean z2) {
        f239h = z2;
    }

    public static void setContext(Context context) {
        a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f235d)) {
                f235d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f234c)) {
                f234c = Utils.getMainProcessName(context);
            }
            if (f240i == null) {
                f240i = PreferenceManager.getDefaultSharedPreferences(context);
                f237f = f240i.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f235d, "TargetProcess", f234c);
        }
    }

    public static void setCurrentProcess(String str) {
        f235d = str;
    }

    public static void setEnv(ENV env) {
        b = env;
    }

    @Deprecated
    public static void setInitTime(long j2) {
        f242k = j2;
    }

    public static void setTargetProcess(String str) {
        f234c = str;
    }

    public static void setTtid(String str) {
        f236e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIndexOf = str.indexOf("@");
            String strSubstring = null;
            String strSubstring2 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            String strSubstring3 = str.substring(iIndexOf + 1);
            int iLastIndexOf = strSubstring3.lastIndexOf("_");
            if (iLastIndexOf != -1) {
                String strSubstring4 = strSubstring3.substring(0, iLastIndexOf);
                strSubstring = strSubstring3.substring(iLastIndexOf + 1);
                strSubstring3 = strSubstring4;
            }
            f243l = strSubstring;
            AmdcRuntimeInfo.setAppInfo(strSubstring3, strSubstring, strSubstring2);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f237f;
        if (str2 == null || !str2.equals(str)) {
            f237f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f240i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f238g;
        if (str2 == null || !str2.equals(str)) {
            f238g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f234c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f234c.equalsIgnoreCase(str);
    }
}
