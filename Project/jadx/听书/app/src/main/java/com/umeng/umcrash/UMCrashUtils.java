package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.kuaishou.weapon.p0.g;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";

    public static boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
                    return;
                }
                editorEdit.putInt(str, Integer.parseInt(obj.toString()));
                editorEdit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static int getInnerConfig(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return i;
        }
        try {
            return (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null) ? i : sharedPreferences.getInt(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public static void setCommonTag(String str, String str2) {
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.UMConfigure");
            if (cls2 == null || (cls = Class.forName("com.umeng.commonsdk.UMConfigure$BS_TYPE")) == null) {
                return;
            }
            Method declaredMethod = cls2.getDeclaredMethod("setModuleTag", cls, String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                for (Enum r5 : (Enum[]) cls.getEnumConstants()) {
                    if (r5 != null && r5.name().equals("APM")) {
                        declaredMethod.invoke(cls2, r5, str, str2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isHarmony(final Context context) {
        final SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0);
        } catch (Throwable unused) {
        }
        if (sharedPreferences.contains("um_apm_harmony")) {
            return sharedPreferences.getBoolean("um_apm_harmony", false);
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrashUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sharedPreferences.edit().putBoolean("um_apm_harmony", context.getString(Resources.getSystem().getIdentifier("config_os_brand", TypedValues.Custom.S_STRING, "android")).equals("harmony")).apply();
                } catch (Throwable unused2) {
                }
            }
        });
        return false;
    }

    public static String[] getActiveUser(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return (String[]) objInvoke;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap map = new HashMap();
        map.put(UMCrash.KEY_HEADER_PUID, str);
        map.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(map);
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap map = new HashMap();
            map.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(map);
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, g.c) && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String splitByByte(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        try {
            int length = str.length();
            int length2 = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String strValueOf = String.valueOf(str.charAt(i2));
                length2 += strValueOf.getBytes().length;
                if (i < length2) {
                    break;
                }
                stringBuffer.append(strValueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
