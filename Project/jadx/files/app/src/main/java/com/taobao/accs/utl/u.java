package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ChannelService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static final String NAMESPACE = "accs";
    public static boolean a = false;
    private static volatile Long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Integer f18340c;

    /* JADX INFO: compiled from: Taobao */
    public static class a implements OrangeConfigListenerV1 {
        public void onConfigUpdate(String str, boolean z2) {
            if (GlobalClientInfo.getContext() == null) {
                ALog.e("OrangeAdapter", "onConfigUpdate context null", new Object[0]);
                return;
            }
            try {
                ALog.i("OrangeAdapter", "onConfigUpdate", "namespace", str);
                if ("accs".equals(str)) {
                    u.f();
                    u.e();
                }
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "onConfigUpdate", th, new Object[0]);
            }
        }
    }

    static {
        try {
            Class.forName("com.taobao.orange.OrangeConfig");
            a = true;
        } catch (Exception unused) {
            a = false;
        }
        b = null;
        f18340c = null;
    }

    public static void a(String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (a) {
            OrangeConfig.getInstance().registerListener(strArr, orangeConfigListenerV1);
        } else {
            ALog.w("OrangeAdapter", "no orange sdk", new Object[0]);
        }
    }

    public static boolean b() {
        boolean zA;
        try {
            zA = a(GlobalClientInfo.getContext(), Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isSmartHb", th, new Object[0]);
            zA = true;
        }
        ALog.d("OrangeAdapter", "isSmartHb", "result", Boolean.valueOf(zA));
        return zA;
    }

    public static boolean c() {
        boolean zA;
        try {
            zA = a(GlobalClientInfo.getContext(), Constants.SP_KEY_BIND_SERVICE_ENABLE, true);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isBindService", th, new Object[0]);
            zA = true;
        }
        ALog.d("OrangeAdapter", "isBindService", "result", Boolean.valueOf(zA));
        return zA;
    }

    public static boolean d() {
        boolean zA;
        try {
            zA = a(GlobalClientInfo.getContext(), Constants.SP_KEY_IMPAAS_MODIFY, true);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isImpassModify", th, new Object[0]);
            zA = true;
        }
        ALog.i("OrangeAdapter", "isImpassModify", "enable", Boolean.valueOf(zA));
        return zA;
    }

    public static void e() {
        HashMap map = new HashMap();
        map.put(Constants.SP_KEY_ELECTION_ENABLE, Boolean.valueOf(a("accs", Constants.SP_KEY_ELECTION_ENABLE, String.valueOf(GlobalClientInfo.f18118d))));
        map.put(Constants.SP_KEY_HB_SMART_ENABLE, Boolean.valueOf(a("accs", "heartbeat_smart_enable", ITagManager.STATUS_TRUE)));
        map.put(Constants.SP_KEY_BIND_SERVICE_ENABLE, Boolean.valueOf(a("accs", Constants.SP_KEY_BIND_SERVICE_ENABLE, ITagManager.STATUS_TRUE)));
        map.put(Constants.SP_KEY_PULL_UP_ENABLE, Boolean.valueOf(a("accs", Constants.SP_KEY_PULL_UP_ENABLE, ITagManager.STATUS_TRUE)));
        map.put(Constants.SP_KEY_CONNECT_STATE_LISTENER_ENABLE, Boolean.valueOf(a("accs", Constants.SP_KEY_CONNECT_STATE_LISTENER_ENABLE, ITagManager.STATUS_TRUE)));
        map.put(Constants.SP_KEY_IMPAAS_MODIFY, Boolean.valueOf(a("accs", "impaas_modify", ITagManager.STATUS_TRUE)));
        try {
            a(GlobalClientInfo.getContext(), "connect_timeout", Integer.parseInt(a("accs", "connect_timeout", String.valueOf(10000))));
        } catch (NumberFormatException unused) {
            a(GlobalClientInfo.getContext(), "connect_timeout", 10000);
        }
        a(GlobalClientInfo.getContext(), map);
        a(GlobalClientInfo.getContext(), ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, UtilityImpl.b(a("accs", ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, String.valueOf(21))));
    }

    public static void f() {
        if (!a()) {
            ALog.e("OrangeAdapter", "force disable service", new Object[0]);
            ACCSManager.forceDisableService(GlobalClientInfo.getContext());
        } else if (UtilityImpl.d(GlobalClientInfo.getContext())) {
            ALog.i("OrangeAdapter", "force enable service", new Object[0]);
            ACCSManager.forceEnableService(GlobalClientInfo.getContext());
        }
    }

    public static String a(String str, String str2, String str3) {
        if (a) {
            return OrangeConfig.getInstance().getConfig(str, str2, str3);
        }
        ALog.w("OrangeAdapter", "no orange sdk", new Object[0]);
        return str3;
    }

    static long b(Context context) {
        if (b == null) {
            try {
                b = Long.valueOf(context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getLong(Constants.SP_KEY_LAST_LAUNCH_TIME, 0L));
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "getLastActiveTime", th, new Object[0]);
            }
            ALog.d("OrangeAdapter", "getLastActiveTime", "result", b);
        }
        return b.longValue();
    }

    public static long c(Context context) {
        if (f18340c == null) {
            try {
                f18340c = Integer.valueOf(context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt("connect_timeout", 10000));
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "getConnectTimeout", th, new Object[0]);
            }
            ALog.d("OrangeAdapter", "getConnectTimeout", "result", f18340c);
        }
        return f18340c.intValue();
    }

    public static boolean a() {
        boolean zBooleanValue;
        try {
            zBooleanValue = Boolean.valueOf(a("accs", "main_function_enable", ITagManager.STATUS_TRUE)).booleanValue();
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isAccsEnabled", th, new Object[0]);
            zBooleanValue = true;
        }
        ALog.i("OrangeAdapter", "isAccsEnabled", "enable", Boolean.valueOf(zBooleanValue));
        return zBooleanValue;
    }

    public static boolean a(Context context) {
        boolean zA;
        try {
            zA = a(context, Constants.SP_KEY_CONNECT_STATE_LISTENER_ENABLE, true);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isConnectStateListenerEnable", th, new Object[0]);
            zA = true;
        }
        ALog.d("OrangeAdapter", "isConnectStateListenerEnable", "result", Boolean.valueOf(zA));
        return zA;
    }

    static void a(Context context, long j2) {
        try {
            b = Long.valueOf(j2);
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            editorEdit.putLong(Constants.SP_KEY_LAST_LAUNCH_TIME, j2);
            editorEdit.apply();
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "saveLastActiveTime fail:", th, "lastLaunchTime", Long.valueOf(j2));
        }
    }

    private static boolean a(Context context, String str, boolean z2) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(str, z2);
        } catch (Exception e2) {
            ALog.e("OrangeAdapter", "getConfigFromSP fail:", e2, "key", str);
            return z2;
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            ALog.e("OrangeAdapter", "saveConfigToSP fail:", e2, "key", str, "value", Integer.valueOf(i2));
        }
        if (context == null) {
            ALog.e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
        ALog.i("OrangeAdapter", "saveConfigToSP", "key", str, "value", Integer.valueOf(i2));
    }

    private static void a(Context context, Map<String, Boolean> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                    editorEdit.putBoolean(entry.getKey(), entry.getValue().booleanValue());
                }
                editorEdit.apply();
            } catch (Exception e2) {
                ALog.e("OrangeAdapter", "saveConfigsToSP fail:", e2, "configs", map.toString());
            }
            ALog.i("OrangeAdapter", "saveConfigsToSP", "configs", map.toString());
        }
    }
}
