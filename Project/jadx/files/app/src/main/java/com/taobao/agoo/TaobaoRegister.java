package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* JADX INFO: loaded from: classes3.dex */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static boolean isRegisterSuccess;
    private static com.taobao.agoo.a.b mRequestListener;

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    public static void clickMessage(Context context, String str, String str2) {
        clickMessage(context, str, str2, 0, 0L);
    }

    public static void dismissMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "dismissMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = "9";
                AgooFactory agooFactory = new AgooFactory();
                agooFactory.init(context, notifManager, null);
                agooFactory.updateMsgStatus(str, "9");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "dismissMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void exposureMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "exposureMessage", "msgid", str, AgooConstants.MESSAGE_EXT, str2);
            }
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = AgooConstants.ACK_REMOVE_PACKAGE;
                new AgooFactory().init(context, notifManager, null);
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e(TAG, "exposureMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isRegisterSuccess() {
        return isRegisterSuccess;
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i2) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i2);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        register(context, "default", str, str2, str3, iRegister);
    }

    public static synchronized void removeAlias(Context context, String str, ICallback iCallback) {
        String strF;
        String strA;
        ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
        try {
            strF = Config.f(context);
            strA = Config.a(context);
        } catch (Throwable th) {
            ALog.e(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
        }
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strF) && context != null && !TextUtils.isEmpty(str)) {
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, strA, Config.b(context));
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
            GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
            String strB = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.c(strA, strF, str), null));
            if (TextUtils.isEmpty(strB)) {
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "accs channel disabled!");
                }
            } else if (iCallback != null) {
                mRequestListener.a.put(strB, iCallback);
            }
            return;
        }
        if (iCallback != null) {
            iCallback.onFailure("504.1", "input params null!!");
        }
        ALog.e(TAG, "setAlias param null", "appkey", strA, "deviceId", strF, "alias", str, "context", context);
    }

    public static void removeAllAlias(Context context, ICallback iCallback) {
        ALog.i(TAG, "removeAllAlias", new Object[0]);
        try {
            String strF = Config.f(context);
            String strA = Config.a(context);
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strF) && context != null) {
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, strA, Config.b(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
                String strB = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.a(strA, strF), null));
                if (TextUtils.isEmpty(strB)) {
                    if (iCallback != null) {
                        iCallback.onFailure("504.1", "accs channel disabled!");
                        return;
                    }
                    return;
                } else {
                    if (iCallback != null) {
                        mRequestListener.a.put(strB, iCallback);
                        return;
                    }
                    return;
                }
            }
            if (iCallback != null) {
                iCallback.onFailure("504.1", "input params null!!");
            }
            ALog.e(TAG, "setAlias param null", "appkey", strA, "deviceId", strF, "context", context);
        } catch (Throwable th) {
            ALog.e(TAG, "removeAllAlias", th, new Object[0]);
        }
    }

    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z2) {
        String strF;
        String strA;
        String strK;
        try {
            strF = Config.f(context);
            strA = Config.a(context);
            strK = UtilityImpl.k(context);
        } catch (Throwable th) {
            ALog.e(TAG, "sendSwitch", th, new Object[0]);
        }
        if (!TextUtils.isEmpty(strA) && context != null && (!TextUtils.isEmpty(strF) || !TextUtils.isEmpty(strK))) {
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, strA, Config.b(context));
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
            GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
            String strB = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.d.a(strA, strF, strK, z2), null));
            if (TextUtils.isEmpty(strB)) {
                if (iCallback != null) {
                    iCallback.onFailure("503.2", "accs channel disabled!");
                }
            } else if (iCallback != null) {
                mRequestListener.a.put(strB, iCallback);
            }
            return;
        }
        if (iCallback != null) {
            iCallback.onFailure("503.3", "input params null!!");
        }
        ALog.e(TAG, "sendSwitch param null", "appkey", strA, "deviceId", strF, "context", context, com.taobao.agoo.a.a.d.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z2));
    }

    public static synchronized void setAccsConfigTag(Context context, String str) {
        Config.a = str;
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            throw new RuntimeException("accs config not exist!! please set accs config first!!");
        }
        ALog.i(TAG, "setAccsConfigTag", "config", configByTag.toString());
        com.taobao.accs.client.a.f18129c = configByTag.getAuthCode();
        Config.setAgooAppKey(context, configByTag.getAppKey());
        j.b = configByTag.getAppSecret();
        if (!TextUtils.isEmpty(j.b)) {
            com.taobao.accs.client.a.a = 2;
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        com.taobao.accs.client.a.b = str;
    }

    public static synchronized void setAlias(Context context, String str, ICallback iCallback) {
        ALog.i(TAG, "setAlias", "alias", str);
        String strF = Config.f(context);
        String strA = Config.a(context);
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strF) || context == null || TextUtils.isEmpty(str)) {
            if (iCallback != null) {
                iCallback.onFailure("504.1", "input params null!!");
            }
            ALog.e(TAG, "setAlias param null", "appkey", strA, "deviceId", strF, "alias", str, "context", context);
            return;
        }
        try {
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
        } catch (Throwable th) {
            ALog.e(TAG, "setAlias", th, new Object[0]);
        }
        if (com.taobao.agoo.a.b.b.d(str)) {
            ALog.i(TAG, "setAlias already set", "alias", str);
            if (iCallback != null) {
                iCallback.onSuccess();
            }
            return;
        }
        com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, strA, Config.b(context));
        if (com.taobao.agoo.a.b.b.b(context.getPackageName())) {
            GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
            String strB = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.a(strA, strF, str), null));
            if (TextUtils.isEmpty(strB)) {
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "accs channel disabled!");
                }
            } else if (iCallback != null) {
                iCallback.extra = str;
                mRequestListener.a.put(strB, iCallback);
            }
        } else if (iCallback != null) {
            iCallback.onFailure("504.1", "bindApp first!!");
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i2) {
        ACCSClient.setEnvironment(context, i2);
    }

    public static void setIsRegisterSuccess(boolean z2) {
        isRegisterSuccess = z2;
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i2) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z2) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z2) {
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.k(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.k(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void clickMessage(android.content.Context r21, java.lang.String r22, java.lang.String r23, int r24, long r25) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.clickMessage(android.content.Context, java.lang.String, java.lang.String, int, long):void");
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        if (context != null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    ALog.isUseTlog = false;
                    anet.channel.util.ALog.setUseTlog(false);
                }
                ALog.i(TAG, com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, Constants.KEY_APP_KEY, str2, Constants.KEY_CONFIG_TAG, str);
                Context applicationContext = context.getApplicationContext();
                Config.a = str;
                Config.setAgooAppKey(context, str2);
                j.b = str3;
                if (!TextUtils.isEmpty(str3)) {
                    com.taobao.accs.client.a.a = 2;
                }
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                if (configByTag == null) {
                    new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                } else {
                    com.taobao.accs.client.a.f18129c = configByTag.getAuthCode();
                }
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                accsInstance.a(applicationContext, str2, str3, str4, new h(applicationContext, context, iRegister, str2, str4, accsInstance));
                return;
            }
        }
        ALog.e(TAG, "register params null", "appkey", str2, Constants.KEY_CONFIG_TAG, str);
    }

    public static synchronized void removeAlias(Context context, ICallback iCallback) {
        String strF;
        String strG;
        String strA;
        ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
        try {
            strF = Config.f(context);
            strG = Config.g(context);
            strA = Config.a(context);
        } catch (Throwable th) {
            ALog.e(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, th, new Object[0]);
        }
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strF) && context != null && !TextUtils.isEmpty(strG)) {
            com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, strA, Config.b(context));
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
            GlobalClientInfo.getInstance(context).registerListener("AgooDeviceCmd", mRequestListener);
            String strB = accsInstance.b(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.a.b(strA, strF, strG), null));
            if (TextUtils.isEmpty(strB)) {
                if (iCallback != null) {
                    iCallback.onFailure("504.1", "accs channel disabled!");
                }
            } else if (iCallback != null) {
                mRequestListener.a.put(strB, iCallback);
            }
            return;
        }
        if (iCallback != null) {
            iCallback.onFailure("504.1", "input params null!!");
        }
        ALog.e(TAG, "setAlias param null", "appkey", strA, "deviceId", strF, com.taobao.agoo.a.a.a.JSON_PUSH_USER_TOKEN, strG, "context", context);
    }
}
