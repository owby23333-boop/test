package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.core.c.e;
import com.ss.android.downloadlib.OrderDownloader;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import com.umeng.commonsdk.utils.d;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog = false;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", OrderDownloader.BizType.GAME, "zid"};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                return;
            }
            int iOrdinal = bs_type.ordinal();
            String str2 = iOrdinal < BUSINESS_TYPE.length ? BUSINESS_TYPE[iOrdinal] : "";
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            TagHelper.deleteModuleTag(str2 + "_" + str);
        } catch (Throwable unused) {
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> declaredConstructor;
        if (cls == null) {
            return null;
        }
        try {
            declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        }
        if (declaredConstructor == null) {
            return null;
        }
        declaredConstructor.setAccessible(true);
        try {
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = null;
        if (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        }
        return declaredMethod;
    }

    public static boolean getInitStatus() {
        boolean z2;
        synchronized (lockObject) {
            z2 = isFinish;
        }
        return z2;
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            boolean z2 = debugLog;
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String strA = aa.a(applicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(strA);
                }
            }
        }).start();
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i2, String str) {
        init(context, null, null, i2, str);
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static boolean isPreInit() {
        boolean z2;
        synchronized (PreInitLock) {
            z2 = preInitComplete;
        }
        return z2;
    }

    private static boolean isSilentMode() {
        boolean zA = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + zA);
        return zA;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(aq.f19521m);
        return !new File(sb.toString()).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(aq.f19520l);
        return !new File(sb.toString()).exists();
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            boolean z2 = debugLog;
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(applicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(applicationContext);
        l.a(applicationContext);
        if (!needSendZcfgEnv(applicationContext)) {
            FieldManager.a().a(applicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean zA = c.a();
        if (debugLog && zA) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    private static void setCheckDevice(boolean z2) {
        AnalyticsConstants.CHECK_DEVICE = z2;
    }

    public static void setEncryptEnabled(boolean z2) {
        b.a(z2);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j2) {
        com.umeng.commonsdk.statistics.a.f20048c = ((int) j2) * 1000;
    }

    public static void setLogEnabled(boolean z2) {
        try {
            debugLog = z2;
            MLog.DEBUG = z2;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z2)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z2);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z2)});
        } catch (Exception e2) {
            if (debugLog) {
                String str = "set log enabled e is " + e2;
            }
        } catch (Throwable th) {
            if (debugLog) {
                String str2 = "set log enabled e is " + th;
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        if (bs_type == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.trim().getBytes().length > 64 || str2.trim().getBytes().length > 128) {
                return;
            }
            int iOrdinal = bs_type.ordinal();
            String str3 = iOrdinal < BUSINESS_TYPE.length ? BUSINESS_TYPE[iOrdinal] : "";
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            TagHelper.setModuleTag(str3 + "_" + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z2) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z2;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.a = "native";
                com.umeng.commonsdk.statistics.a.a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_X;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_UNITY;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_REACTNATIVE;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_PHONEGAP;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_WEEX;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.a = "hybrid";
                com.umeng.commonsdk.statistics.a.a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_FLUTTER;
                com.umeng.commonsdk.statistics.a.a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.b = str2;
        com.umeng.commonsdk.statistics.a.b = str2;
    }

    public static void submitPolicyGrantResult(Context context, boolean z2) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, com.umeng.commonsdk.internal.b.a(context).a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z2) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f19994z, com.umeng.commonsdk.internal.b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    public static void init(Context context, String str, String str2, int i2, String str3) {
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        Method declaredMethod3;
        Method declaredMethod4;
        Method declaredMethod5;
        Method declaredMethod6;
        Object objInvoke2;
        Class<?> cls;
        Method declaredMethod7;
        Method declaredMethod8;
        try {
            try {
                if (debugLog) {
                    String str4 = "common type is " + SdkVersion.SDK_TYPE;
                }
            } catch (Throwable th) {
                if (debugLog) {
                    String str5 = "init e is " + th;
                }
            }
        } catch (Exception e2) {
            if (debugLog) {
                String str6 = "init e is " + e2;
            }
        }
        if (context == null) {
            boolean z2 = debugLog;
            return;
        }
        if (isInit) {
            boolean z3 = debugLog;
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        UMGlobalContext.getInstance(applicationContext);
        if (c.a()) {
            if (!isPreInit()) {
                preInitInternal(applicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.D, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            return;
        }
        try {
            if (getClass("com.umeng.umzid.ZIDManager") == null) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                            Looper.loop();
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls2 = getClass("com.umeng.message.PushAgent");
            if (cls2 != null && !checkShareSdk(cls2) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused2) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused2) {
        }
        try {
            Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
            if (cls3 != null && !checkShareSdk(cls3) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(applicationContext, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused3) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused3) {
        }
        if (!isPreInit()) {
            preInitInternal(applicationContext, str, str2);
            if (!isPreInit()) {
                return;
            }
        }
        UMEnvelopeBuild.registerNetReceiver(applicationContext);
        UMUtils.setAppkey(applicationContext, sAppkey);
        String lastAppkey = UMUtils.getLastAppkey(applicationContext);
        if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
            if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
            }
            UMUtils.setLastAppkey(applicationContext, sAppkey);
        }
        if (debugLog) {
            String str7 = "current appkey is " + sAppkey + ", last appkey is " + lastAppkey;
        }
        if (debugLog) {
            String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext);
            if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
            }
        }
        UMUtils.setChannel(applicationContext, sChannel);
        if (debugLog) {
            String str8 = "channel is " + sChannel;
        }
        try {
            Class<?> cls4 = Class.forName("com.umeng.analytics.MobclickAgent");
            if (cls4 != null) {
                Method declaredMethod9 = cls4.getDeclaredMethod("init", Context.class);
                if (declaredMethod9 != null) {
                    declaredMethod9.setAccessible(true);
                    declaredMethod9.invoke(cls4, applicationContext);
                    if (FieldManager.allow(d.F)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                        l.a(applicationContext).b(applicationContext);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                    }
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                    }
                }
                if (Class.forName("com.umeng.analytics.game.UMGameAgent") != null && (declaredMethod8 = cls4.getDeclaredMethod("setGameScenarioType", Context.class)) != null) {
                    declaredMethod8.setAccessible(true);
                    declaredMethod8.invoke(cls4, applicationContext);
                }
            }
            if (b.a.indexOf(e.a) >= 0 && (cls = Class.forName("com.umeng.analytics.MobclickAgent")) != null && (declaredMethod7 = cls.getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                declaredMethod7.setAccessible(true);
                declaredMethod7.invoke(cls, new Object[0]);
            }
        } catch (Throwable unused4) {
        }
        try {
            Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
            if (cls5 != null && (declaredMethod6 = cls5.getDeclaredMethod("getInstance", Context.class)) != null && (objInvoke2 = declaredMethod6.invoke(cls5, applicationContext)) != null) {
                Method declaredMethod10 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                if (declaredMethod10 != null) {
                    declaredMethod10.setAccessible(true);
                    declaredMethod10.invoke(objInvoke2, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                    }
                }
                Method declaredMethod11 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                if (declaredMethod11 != null) {
                    declaredMethod11.setAccessible(true);
                    declaredMethod11.invoke(objInvoke2, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    boolean z4 = debugLog;
                } else {
                    if (debugLog) {
                        String str9 = "push secret is " + str3;
                    }
                    Method declaredMethod12 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                    if (declaredMethod12 != null) {
                        declaredMethod12.setAccessible(true);
                        declaredMethod12.invoke(objInvoke2, str3);
                        if (debugLog) {
                            UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                        }
                    }
                }
            }
        } catch (Exception unused5) {
        }
        try {
            Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
            setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
            if (cls6 != null && (declaredMethod5 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(cls6, applicationContext, sAppkey);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                }
            }
        } catch (Throwable unused6) {
        }
        AnalyticsConstants.setDeviceType(i2);
        try {
            Class<?> cls7 = Class.forName("com.umeng.error.UMError");
            if (cls7 != null && (declaredMethod4 = cls7.getDeclaredMethod("init", Context.class)) != null) {
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(cls7, applicationContext);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                }
            }
        } catch (Throwable unused7) {
        }
        try {
            Class<?> cls8 = Class.forName("com.umeng.umcrash.UMCrash");
            if (cls8 != null) {
                if (SdkVersion.SDK_TYPE == 1 && (declaredMethod3 = cls8.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(cls8, true);
                }
                Method declaredMethod13 = cls8.getDeclaredMethod("init", Context.class, String.class, String.class);
                if (declaredMethod13 != null) {
                    declaredMethod13.setAccessible(true);
                    declaredMethod13.invoke(cls8, applicationContext, sAppkey, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        try {
            Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
            if (declaredMethod14 != null) {
                declaredMethod14.invoke(null, applicationContext, sAppkey, sChannel, Integer.valueOf(i2), str3);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
            }
        } catch (Throwable unused9) {
        }
        try {
            Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
            if (declaredMethod15 != null) {
                declaredMethod15.invoke(null, applicationContext, sAppkey);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
            }
        } catch (Throwable unused10) {
        }
        synchronized (lockObject) {
            isFinish = true;
        }
        if (needCheckPolicyResult(applicationContext)) {
            synchronized (lock) {
                int i3 = preInitInvokedFlag;
                int i4 = policyGrantResult;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.umeng.commonsdk.internal.a.J, preInitInvokedFlag);
                    jSONObject.put(com.umeng.commonsdk.internal.a.K, policyGrantInvokedFlag);
                    jSONObject.put("policyGrantResult", policyGrantResult);
                    UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.A, com.umeng.commonsdk.internal.b.a(applicationContext).a(), jSONObject);
                } catch (Throwable unused11) {
                }
            }
        }
        if (needSendZcfgEnv(applicationContext)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
            UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.f19984p, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
            if (FieldManager.b()) {
                UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.f19993y, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
            }
        }
        if (isDebugLog()) {
            UMConfigureInternation.doSelfCheck(applicationContext);
        }
        try {
            Context applicationContext2 = context.getApplicationContext();
            Class<?> cls9 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
            if (cls9 != null && (declaredMethod = cls9.getDeclaredMethod("getInstance", new Class[0])) != null && (objInvoke = declaredMethod.invoke(cls9, new Object[0])) != null && (declaredMethod2 = cls9.getDeclaredMethod("init", Context.class)) != null) {
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(objInvoke, applicationContext2);
            }
        } catch (Exception unused12) {
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.F, com.umeng.commonsdk.internal.b.a(context).a(), null);
        if (isInit) {
            return;
        }
        isInit = true;
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z2));
            } catch (Exception unused) {
            }
        }
    }
}
