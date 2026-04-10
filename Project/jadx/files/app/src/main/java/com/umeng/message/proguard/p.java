package com.umeng.message.proguard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengIntentService;
import com.umeng.message.UmengMessageCallbackHandlerService;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengMessageService;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.XiaomiIntentService;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.service.UMJobIntentService;
import com.umeng.message.tag.TagManager;

/* JADX INFO: compiled from: UPushImpl.java */
/* JADX INFO: loaded from: classes3.dex */
class p implements UPushApi {
    private static final String a = "";
    private UPushMessageHandler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UPushMessageHandler f20494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f20498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile UPushRegisterCallback f20499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile UPushSettingCallback f20500i;

    /* JADX INFO: compiled from: UPushImpl.java */
    static class a {
        private static final p a = new p();

        private a() {
        }
    }

    private boolean b() {
        return this.f20495d;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private void c() {
        try {
            if (Build.VERSION.SDK_INT < 14) {
                UPLog.e("", "U-Push最低支持的系统版本为Android 4.0");
                return;
            }
            final Context contextB = r.b();
            if (!l.a(contextB)) {
                UPLog.e("", "AndroidManifest权限或参数错误");
                return;
            }
            final String messageAppkey = getMessageAppkey();
            final String messageSecret = getMessageSecret();
            if (!TextUtils.isEmpty(messageAppkey) && !TextUtils.isEmpty(messageSecret)) {
                l.a(r.b(), (Class<?>) UmengMessageCallbackHandlerService.class);
                if (PushAgent.DEBUG) {
                    l.d(contextB);
                }
                ALog.setUseTlog(false);
                anet.channel.util.ALog.setUseTlog(false);
                AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
                AwcnConfig.setWifiInfoEnable(false);
                AmdcRuntimeInfo.setForceHttps(true);
                final String strB = l.b(contextB);
                GlobalConfig.setCurrProcessNameImpl(new IProcessName() { // from class: com.umeng.message.proguard.p.2
                    @Override // com.taobao.accs.IProcessName
                    public String getCurrProcessName() {
                        return strB;
                    }
                });
                GlobalAppRuntimeInfo.setCurrentProcess(strB);
                ACCSClient.setEnvironment(contextB, 0);
                AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
                builder.setAppKey("umeng:" + messageAppkey).setAppSecret(messageSecret).setInappHost("umengacs.m.taobao.com").setInappPubKey(11).setChannelHost("umengjmacs.m.taobao.com").setChannelPubKey(11).setKeepAlive(this.f20495d).setAutoUnit(false).setTag("default").setPullUpEnable(this.f20496e).setAccsHeartbeatEnable(this.f20497f);
                ACCSClient.init(contextB, builder.build());
                DispatchConstants.setAmdcServerDomain(new String[]{"amdcopen.m.taobao.com", "amdc.wapa.taobao.com", "amdc.taobao.net"});
                DispatchConstants.setAmdcServerFixIp(new String[][]{new String[]{"106.11.61.135", "106.11.61.137"}, null, null});
                if (UmengMessageDeviceConfig.isMi8()) {
                    TaobaoRegister.setAgooMsgReceiveService(XiaomiIntentService.class.getName());
                } else {
                    TaobaoRegister.setAgooMsgReceiveService(UmengIntentService.class.getName());
                }
                o.a().b();
                c.b(new Runnable() { // from class: com.umeng.message.proguard.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UPLog.i("", "appkey:" + messageAppkey, " secret:" + messageSecret);
                            Context context = contextB;
                            StringBuilder sb = new StringBuilder();
                            sb.append("umeng:");
                            sb.append(messageAppkey);
                            TaobaoRegister.register(context, "default", sb.toString(), messageSecret, "android@umeng", new IRegister() { // from class: com.umeng.message.proguard.p.3.1
                                @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                                public void onFailure(String str, String str2) {
                                    UPLog.e("", "register failed! code:" + str + ", desc:" + str2);
                                    p.this.a(str, str2);
                                    UMLog.aq(t.a, 0, "\\|");
                                }

                                @Override // com.taobao.agoo.IRegister
                                public void onSuccess(String str) {
                                    UPLog.i("", "register success. deviceToken:" + str);
                                    p.this.a(str);
                                }
                            });
                        } catch (Throwable th) {
                            UPLog.e("", "register failed:" + th.getMessage());
                        }
                    }
                });
                if (l.c(contextB)) {
                    f.a();
                }
                y.a().c();
                return;
            }
            UPLog.e("", "Appkey和MessageSecret均不能为空");
        } catch (Throwable th) {
            UPLog.e("", "register error:" + th.getMessage());
        }
    }

    private void d() {
        try {
            TaobaoRegister.bindAgoo(r.b(), new ICallback() { // from class: com.umeng.message.proguard.p.4
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str, String str2) {
                    UPLog.d("", "push enable failed. code:", str, " desc:", str2);
                    Intent intent = new Intent();
                    intent.setPackage(r.b().getPackageName());
                    intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
                    intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
                    intent.putExtra("status", false);
                    intent.putExtra("s", str);
                    intent.putExtra("s1", str2);
                    UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    UPLog.d("", "push enable success.");
                    Intent intent = new Intent();
                    intent.setPackage(r.b().getPackageName());
                    intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
                    intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
                    intent.putExtra("status", true);
                    UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
                }
            });
        } catch (Exception unused) {
            UPLog.e("", "push enable failed.");
        }
    }

    private void e() {
        try {
            TaobaoRegister.unbindAgoo(r.b(), new ICallback() { // from class: com.umeng.message.proguard.p.5
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str, String str2) {
                    UPLog.e("", "push disable failed. code:", str, " desc:", str2);
                    Intent intent = new Intent();
                    intent.setPackage(r.b().getPackageName());
                    intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
                    intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
                    intent.putExtra("status", false);
                    intent.putExtra("s", str);
                    intent.putExtra("s1", str2);
                    UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    UPLog.i("", "push disable success.");
                    Intent intent = new Intent();
                    intent.setPackage(r.b().getPackageName());
                    intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
                    intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
                    intent.putExtra("status", true);
                    UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
                }
            });
        } catch (Exception unused) {
            UPLog.e("", "push disable failed.");
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().addAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().deleteAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public void disable(UPushSettingCallback uPushSettingCallback) {
        setCallback(uPushSettingCallback);
        e();
    }

    @Override // com.umeng.message.api.UPushApi
    public void enable(UPushSettingCallback uPushSettingCallback) {
        setCallback(uPushSettingCallback);
        d();
    }

    @Override // com.umeng.message.api.UPushApi
    public UPushSettingCallback getCallback() {
        return this.f20500i;
    }

    @Override // com.umeng.message.api.UPushApi
    public int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(r.b()).getDisplayNotificationNumber();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getMessageAppkey() {
        return MessageSharedPrefs.getInstance(r.b()).getMessageAppKey();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getMessageChannel() {
        String messageChannel = MessageSharedPrefs.getInstance(r.b()).getMessageChannel();
        return TextUtils.isEmpty(messageChannel) ? UmengMessageDeviceConfig.getChannel(r.b()) : messageChannel;
    }

    @Override // com.umeng.message.api.UPushApi
    public UPushMessageHandler getMessageHandler() {
        return this.b;
    }

    @Override // com.umeng.message.api.UPushApi
    public UPushMessageNotifyApi getMessageNotifyApi() {
        return y.a();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getMessageSecret() {
        String messageAppSecret = MessageSharedPrefs.getInstance(r.b()).getMessageAppSecret();
        return TextUtils.isEmpty(messageAppSecret) ? UmengMessageDeviceConfig.getMetaData(r.b(), "UMENG_MESSAGE_SECRET") : messageAppSecret;
    }

    @Override // com.umeng.message.api.UPushApi
    public int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(r.b()).getMuteDuration();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(r.b()).getNoDisturbEndHour();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(r.b()).getNoDisturbEndMinute();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(r.b()).getNoDisturbStartHour();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(r.b()).getNoDisturbStartMinute();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getNotificationChannelName() {
        String notificationChannelName = MessageSharedPrefs.getInstance(r.b()).getNotificationChannelName();
        return TextUtils.isEmpty(notificationChannelName) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : notificationChannelName;
    }

    @Override // com.umeng.message.api.UPushApi
    public UPushMessageHandler getNotificationClickHandler() {
        return this.f20494c;
    }

    @Override // com.umeng.message.api.UPushApi
    public boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(r.b()).getNotificationOnForeground();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(r.b()).getNotificationPlayLights();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(r.b()).getNotificationPlaySound();
    }

    @Override // com.umeng.message.api.UPushApi
    public int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(r.b()).getNotificationPlayVibrate();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getNotificationSilenceChannelName() {
        String notificationSilenceChannelName = MessageSharedPrefs.getInstance(r.b()).getNotificationSilenceChannelName();
        return TextUtils.isEmpty(notificationSilenceChannelName) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME : notificationSilenceChannelName;
    }

    @Override // com.umeng.message.api.UPushApi
    public String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(r.b()).getPushIntentServiceClass();
    }

    @Override // com.umeng.message.api.UPushApi
    public UPushRegisterCallback getRegisterCallback() {
        return this.f20499h;
    }

    @Override // com.umeng.message.api.UPushApi
    public String getRegistrationId() {
        return MessageSharedPrefs.getInstance(r.b()).getDeviceToken();
    }

    @Override // com.umeng.message.api.UPushApi
    public String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(r.b()).getResourcePackageName();
    }

    @Override // com.umeng.message.api.UPushApi
    public TagManager getTagManager() {
        return TagManager.getInstance(r.b());
    }

    @Override // com.umeng.message.api.UPushApi
    public boolean isPushCheck() {
        return this.f20498g;
    }

    @Override // com.umeng.message.api.UPushApi
    public void keepLowPowerMode(boolean z2) {
        this.f20495d = !z2;
    }

    @Override // com.umeng.message.api.UPushApi
    public void onAppStart() {
        c.a(new Runnable() { // from class: com.umeng.message.proguard.p.1
            @Override // java.lang.Runnable
            public void run() {
                s.a().a(10000L);
                s.a().b();
            }
        });
    }

    @Override // com.umeng.message.api.UPushApi
    public void register(UPushRegisterCallback uPushRegisterCallback) {
        setRegisterCallback(uPushRegisterCallback);
        c();
    }

    @Override // com.umeng.message.api.UPushApi
    public void setAccsHeartbeatEnable(boolean z2) {
        this.f20497f = z2;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().setAlias(str, str2, uPushAliasCallback);
    }

    @Override // com.umeng.message.api.UPushApi
    public void setCallback(UPushSettingCallback uPushSettingCallback) {
        this.f20500i = uPushSettingCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setDisplayNotificationNumber(int i2) {
        if (!l.c(r.b()) || i2 < 0 || i2 > 10) {
            return;
        }
        MessageSharedPrefs.getInstance(r.b()).setDisplayNotificationNumber(i2);
    }

    @Override // com.umeng.message.api.UPushApi
    public void setEnableForeground(Context context, boolean z2) {
        GlobalConfig.setEnableForground(context, z2);
    }

    @Override // com.umeng.message.api.UPushApi
    public void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.b = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setMuteDurationSeconds(int i2) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setMuteDuration(i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNoDisturbMode(i2, i3, i4, i5);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationChannelName(String str) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationChannelName(str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.f20494c = uPushMessageHandler;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationOnForeground(boolean z2) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationOnForeground(z2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationPlayLights(int i2) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationPlayLights(i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationPlaySound(int i2) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationPlaySound(i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationPlayVibrate(int i2) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationPlayVibrate(i2);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setNotificationSilenceChannelName(String str) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setNotificationSilenceChannelName(str);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setPullUpEnable(boolean z2) {
        this.f20496e = z2;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setPushCheck(boolean z2) {
        this.f20498g = z2;
    }

    @Override // com.umeng.message.api.UPushApi
    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setPushIntentServiceClass(cls);
        }
    }

    @Override // com.umeng.message.api.UPushApi
    public void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.f20499h = uPushRegisterCallback;
    }

    @Override // com.umeng.message.api.UPushApi
    public void setResourcePackageName(String str) {
        if (l.c(r.b())) {
            MessageSharedPrefs.getInstance(r.b()).setResourcePackageName(str);
        }
    }

    private p() {
        this.b = new UmengMessageHandler();
        this.f20494c = new UmengNotificationClickHandler();
        this.f20495d = true;
        this.f20496e = false;
        this.f20497f = false;
        this.f20498g = false;
    }

    static UPushApi a() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.setPackage(r.b().getPackageName());
        intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_REGISTRATION_ID, str);
        intent.putExtra("status", true);
        UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage(r.b().getPackageName());
        intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra("status", false);
        intent.putExtra("s", str);
        intent.putExtra("s1", str2);
        UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
    }
}
