package com.umeng.message;

import android.app.Application;
import android.content.Context;
import anet.channel.util.ALog;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushReceiver;
import com.umeng.message.proguard.o;
import com.umeng.message.proguard.r;
import com.umeng.message.tag.TagManager;
import org.android.spdy.SpdyAgent;

/* JADX INFO: loaded from: classes3.dex */
public class PushAgent {
    public static boolean DEBUG = false;
    private static final String TAG = "PushAgent";
    private static volatile PushAgent sInstance;
    private UPushApi api;
    public boolean isZyb = true;

    static {
        ALog.setPrintLog(false);
    }

    private PushAgent(Context context) {
        try {
            r.a(context);
            o.a().a((Application) context.getApplicationContext());
            this.api = r.a();
        } catch (Throwable th) {
            UPLog.e(TAG, "PushAgent初始化失败", th.getMessage());
        }
    }

    public static PushAgent getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PushAgent.class) {
                if (sInstance == null) {
                    sInstance = new PushAgent(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private void setDebugMode(boolean z2) {
        DEBUG = z2;
        UPLog.setEnable(z2);
        com.taobao.accs.utl.ALog.setPrintLog(z2);
        ALog.setPrintLog(z2);
        SpdyAgent.enableDebug = z2;
    }

    public static void setup(Context context, String str, String str2) {
        r.a(context, str, str2);
    }

    public void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.addAlias(str, str2, uPushAliasCallback);
    }

    public void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.deleteAlias(str, str2, uPushAliasCallback);
    }

    public void disable(UPushSettingCallback uPushSettingCallback) {
        this.api.disable(uPushSettingCallback);
    }

    public void enable(UPushSettingCallback uPushSettingCallback) {
        this.api.enable(uPushSettingCallback);
    }

    public UPushSettingCallback getCallback() {
        return this.api.getCallback();
    }

    public int getDisplayNotificationNumber() {
        return this.api.getDisplayNotificationNumber();
    }

    public String getMessageAppkey() {
        return this.api.getMessageAppkey();
    }

    public String getMessageChannel() {
        return this.api.getMessageChannel();
    }

    public UPushMessageHandler getMessageHandler() {
        return this.api.getMessageHandler();
    }

    public UPushMessageNotifyApi getMessageNotifyApi() {
        return this.api.getMessageNotifyApi();
    }

    public String getMessageSecret() {
        return this.api.getMessageSecret();
    }

    public int getMuteDurationSeconds() {
        return this.api.getMuteDurationSeconds();
    }

    public int getNoDisturbEndHour() {
        return this.api.getNoDisturbEndHour();
    }

    public int getNoDisturbEndMinute() {
        return this.api.getNoDisturbEndMinute();
    }

    public int getNoDisturbStartHour() {
        return this.api.getNoDisturbStartHour();
    }

    public int getNoDisturbStartMinute() {
        return this.api.getNoDisturbStartMinute();
    }

    public String getNotificationChannelName() {
        return this.api.getNotificationChannelName();
    }

    public UPushMessageHandler getNotificationClickHandler() {
        return this.api.getNotificationClickHandler();
    }

    public boolean getNotificationOnForeground() {
        return this.api.getNotificationOnForeground();
    }

    public int getNotificationPlayLights() {
        return this.api.getNotificationPlayLights();
    }

    public int getNotificationPlaySound() {
        return this.api.getNotificationPlaySound();
    }

    public int getNotificationPlayVibrate() {
        return this.api.getNotificationPlayVibrate();
    }

    public String getNotificationSilenceChannelName() {
        return this.api.getNotificationSilenceChannelName();
    }

    public String getPushIntentServiceClass() {
        return this.api.getPushIntentServiceClass();
    }

    public UPushRegisterCallback getRegisterCallback() {
        return this.api.getRegisterCallback();
    }

    public String getRegistrationId() {
        return this.api.getRegistrationId();
    }

    public String getResourcePackageName() {
        return this.api.getResourcePackageName();
    }

    public TagManager getTagManager() {
        return this.api.getTagManager();
    }

    public boolean isPushCheck() {
        return this.api.isPushCheck();
    }

    public void keepLowPowerMode(boolean z2) {
        this.api.keepLowPowerMode(z2);
    }

    public void onAppStart() {
        this.api.onAppStart();
    }

    public void register(UPushRegisterCallback uPushRegisterCallback) {
        this.api.register(uPushRegisterCallback);
    }

    public void setAccsHeartbeatEnable(boolean z2) {
        this.api.setAccsHeartbeatEnable(z2);
    }

    public void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        this.api.setAlias(str, str2, uPushAliasCallback);
    }

    public void setCallback(UPushSettingCallback uPushSettingCallback) {
        this.api.setCallback(uPushSettingCallback);
    }

    public void setDisplayNotificationNumber(int i2) {
        this.api.setDisplayNotificationNumber(i2);
    }

    public void setEnableForeground(Context context, boolean z2) {
        this.api.setEnableForeground(context, z2);
    }

    public void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.api.setMessageHandler(uPushMessageHandler);
    }

    public void setMuteDurationSeconds(int i2) {
        this.api.setMuteDurationSeconds(i2);
    }

    public void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        this.api.setNoDisturbMode(i2, i3, i4, i5);
    }

    public void setNotificationChannelName(String str) {
        this.api.setNotificationChannelName(str);
    }

    public void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.api.setNotificationClickHandler(uPushMessageHandler);
    }

    public void setNotificationOnForeground(boolean z2) {
        this.api.setNotificationOnForeground(z2);
    }

    public void setNotificationPlayLights(int i2) {
        this.api.setNotificationPlayLights(i2);
    }

    public void setNotificationPlaySound(int i2) {
        this.api.setNotificationPlaySound(i2);
    }

    public void setNotificationPlayVibrate(int i2) {
        this.api.setNotificationPlayVibrate(i2);
    }

    public void setNotificationSilenceChannelName(String str) {
        this.api.setNotificationSilenceChannelName(str);
    }

    public void setPackageListenerEnable(boolean z2) {
        UPushReceiver.a(z2);
    }

    public void setPullUpEnable(boolean z2) {
        this.api.setPullUpEnable(z2);
    }

    public void setPushCheck(boolean z2) {
        this.api.setPushCheck(z2);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        this.api.setPushIntentServiceClass(cls);
    }

    public void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.api.setRegisterCallback(uPushRegisterCallback);
    }

    public void setResourcePackageName(String str) {
        this.api.setResourcePackageName(str);
    }

    private PushAgent() {
    }
}
