package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.bytedance.msdk.api.reward.RewardItem;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.l;
import com.taobao.accs.utl.u;
import com.taobao.accs.utl.x;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class ACCSManagerImpl implements com.taobao.accs.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18188c = "ACCSMgrImpl_";
    private String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.taobao.accs.c f18189d;
    private int a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Random f18190e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b f18191f = new a(this);

    public ACCSManagerImpl(Context context, String str) {
        GlobalClientInfo.a = context.getApplicationContext();
        this.b = str;
        this.f18189d = new c(str);
        if (x.e(context)) {
            l.a().a(this.f18191f);
        }
        f18188c += this.b;
    }

    @Override // com.taobao.accs.b
    public void c(Context context, String str) {
        if (UtilityImpl.d(context)) {
            return;
        }
        Intent intentB = b(context, 6);
        if (intentB == null) {
            a(context, 6, str, (String) null);
            return;
        }
        String strC = this.f18189d.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        intentB.putExtra(Constants.KEY_APP_KEY, strC);
        intentB.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            a(context, Message.buildUnbindService(this.f18189d.b((String) null), this.b, intentB), 6, false);
        }
    }

    @Override // com.taobao.accs.b
    public void e(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.b
    public void b(Context context, String str) {
        if (UtilityImpl.d(context) || UtilityImpl.d(context)) {
            return;
        }
        Intent intentB = b(context, 5);
        if (intentB == null) {
            a(context, 5, str, (String) null);
            return;
        }
        String strC = this.f18189d.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        intentB.putExtra(Constants.KEY_APP_KEY, strC);
        intentB.putExtra(Constants.KEY_SERVICE_ID, str);
        if (UtilityImpl.isMainProcess(context)) {
            Message messageBuildBindService = Message.buildBindService(this.f18189d.b((String) null), this.b, intentB);
            if (messageBuildBindService != null && messageBuildBindService.getNetPermanceMonitor() != null) {
                messageBuildBindService.getNetPermanceMonitor().setDataId(messageBuildBindService.dataId);
                messageBuildBindService.getNetPermanceMonitor().setMsgType(3);
                messageBuildBindService.getNetPermanceMonitor().setHost(messageBuildBindService.host.toString());
            }
            a(context, messageBuildBindService, 5, false);
        }
        this.f18189d.b();
    }

    @Override // com.taobao.accs.b
    public void d(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Override // com.taobao.accs.b
    public void e(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (context == null) {
            return;
        }
        ALog.i(f18188c, "bindApp", Constants.KEY_APP_KEY, str);
        Message messageBuildParameterError = Message.buildParameterError(context.getPackageName(), 1);
        if (UtilityImpl.d(context)) {
            ALog.e(f18188c, "accs disabled, try enable", new Object[0]);
            UtilityImpl.focusEnableService(context);
        }
        if (TextUtils.isEmpty(str)) {
            this.f18189d.a(messageBuildParameterError, -14);
            return;
        }
        this.f18189d.c(str3);
        this.f18189d.d(str);
        UtilityImpl.c(context, str);
        if (iAppReceiver != null) {
            GlobalClientInfo.getInstance(context).setAppReceiver(this.b, iAppReceiver);
        }
        UtilityImpl.enableService(context);
        Intent intentB = b(context, 1);
        if (intentB == null) {
            return;
        }
        try {
            String str4 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
            boolean z2 = UtilityImpl.c(context) || UtilityImpl.a(Constants.SP_FILE_NAME, context) || UtilityImpl.b(Constants.SP_FILE_NAME, context);
            if (z2) {
                ALog.d(f18188c, "bindApp", "need force bind");
                intentB.putExtra(Constants.KEY_FOUCE_BIND, true);
            }
            intentB.putExtra(Constants.KEY_APP_KEY, str);
            intentB.putExtra(Constants.KEY_TTID, str3);
            intentB.putExtra("appVersion", str4);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f18189d.d();
            }
            intentB.putExtra("app_sercet", str2);
            if (UtilityImpl.isMainProcess(context)) {
                Message messageBuildBindApp = Message.buildBindApp(this.f18189d.b((String) null), this.b, context, intentB);
                if (messageBuildBindApp != null && messageBuildBindApp.getNetPermanceMonitor() != null) {
                    messageBuildBindApp.getNetPermanceMonitor().setDataId(messageBuildBindApp.dataId);
                    messageBuildBindApp.getNetPermanceMonitor().setMsgType(1);
                    messageBuildBindApp.getNetPermanceMonitor().setHost(messageBuildBindApp.host.toString());
                }
                a(context, messageBuildBindApp, 1, z2);
            } else {
                ALog.w(f18188c, "bindApp only allow in main process", new Object[0]);
            }
            this.f18189d.b();
            try {
                if (u.a) {
                    u.a(new String[]{"accs"}, new u.a());
                    u.f();
                    u.e();
                    return;
                }
                return;
            } catch (Throwable unused) {
                ALog.w(f18188c, "no orange sdk", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            ALog.e(f18188c, "bindApp exception", th, new Object[0]);
        }
        ALog.e(f18188c, "bindApp exception", th, new Object[0]);
    }

    @Override // com.taobao.accs.b
    public void d(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.b
    public void c(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    @Override // com.taobao.accs.b
    public Map<String, Boolean> c() throws Exception {
        SessionCenter.getInstance(this.f18189d.c()).forceRecreateAccsSession();
        return b();
    }

    @Override // com.taobao.accs.b
    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return b(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.b
    public String b(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return b(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.b
    public String b(Context context, ACCSManager.AccsRequest accsRequest) {
        return a(context, accsRequest, (String) null, true);
    }

    @Override // com.taobao.accs.b
    public boolean b(Context context) {
        return UtilityImpl.j(context);
    }

    private Intent b(Context context, int i2) {
        if (i2 != 1 && UtilityImpl.d(context)) {
            ALog.e(f18188c, "getIntent null command:" + i2 + " accs enabled:" + UtilityImpl.d(context), new Object[0]);
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), j.channelService);
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f18189d.c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.b);
        return intent;
    }

    @Override // com.taobao.accs.b
    public Map<String, Boolean> b() throws Exception {
        String strB = this.f18189d.b((String) null);
        HashMap map = new HashMap();
        map.put(strB, false);
        if (SessionCenter.getInstance(this.f18189d.c()).getThrowsException(strB, 60000L) != null) {
            map.put(strB, true);
        }
        ALog.d(f18188c, "getChannelState " + map.toString(), new Object[0]);
        return map;
    }

    private void a(Context context, Message message, int i2, boolean z2) {
        boolean z3;
        this.f18189d.a();
        if (message == null) {
            ALog.e(f18188c, "message is null", new Object[0]);
            this.f18189d.a(Message.buildParameterError(context.getPackageName(), i2), -2);
            return;
        }
        if (i2 == 1) {
            String packageName = message.getPackageName();
            if (this.f18189d.e(packageName) && !z2) {
                ALog.i(f18188c, "isAppBinded", Constants.KEY_PACKAGE, packageName);
                this.f18189d.a(message, 200);
                z3 = false;
            }
            z3 = true;
        } else if (i2 != 2) {
            if (i2 == 3 && this.f18189d.a(message.getPackageName(), message.userinfo) && !z2) {
                ALog.i(f18188c, message.getPackageName() + "/" + message.userinfo + " isUserBinded", "isForceBind", Boolean.valueOf(z2));
                this.f18189d.a(message, 200);
                z3 = false;
            }
            z3 = true;
        } else {
            if (this.f18189d.f(message.getPackageName())) {
                ALog.i(f18188c, message.getPackageName() + " isAppUnbinded", new Object[0]);
                this.f18189d.a(message, 200);
                z3 = false;
            }
            z3 = true;
        }
        if (z3) {
            ALog.i(f18188c, "sendControlMessage", "command", Integer.valueOf(i2));
            this.f18189d.a(message, true);
        }
    }

    @Override // com.taobao.accs.b
    public void b(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f18189d.b(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str) {
        a(context, str, false);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, boolean z2) {
        try {
            ALog.i(f18188c, "bindUser", "userId", str);
            if (UtilityImpl.d(context)) {
                ALog.e(f18188c, "accs disabled", new Object[0]);
                return;
            }
            Intent intentB = b(context, 3);
            if (intentB == null) {
                ALog.e(f18188c, "intent null", new Object[0]);
                a(context, 3, (String) null, (String) null);
                return;
            }
            String strC = this.f18189d.c();
            if (TextUtils.isEmpty(strC)) {
                ALog.e(f18188c, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.c(context) || z2) {
                ALog.i(f18188c, "force bind User", new Object[0]);
                intentB.putExtra(Constants.KEY_FOUCE_BIND, true);
                z2 = true;
            }
            intentB.putExtra(Constants.KEY_APP_KEY, strC);
            intentB.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                Message messageBuildBindUser = Message.buildBindUser(this.f18189d.b((String) null), this.b, intentB);
                if (messageBuildBindUser != null && messageBuildBindUser.getNetPermanceMonitor() != null) {
                    messageBuildBindUser.getNetPermanceMonitor().setDataId(messageBuildBindUser.dataId);
                    messageBuildBindUser.getNetPermanceMonitor().setMsgType(2);
                    messageBuildBindUser.getNetPermanceMonitor().setHost(messageBuildBindUser.host.toString());
                }
                a(context, messageBuildBindUser, 3, z2);
            }
            this.f18189d.b();
        } catch (Throwable th) {
            ALog.e(f18188c, "bindUser", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.b
    public void a(Context context) {
        if (UtilityImpl.d(context) || UtilityImpl.d(context)) {
            return;
        }
        Intent intentB = b(context, 4);
        if (intentB == null) {
            a(context, 4, (String) null, (String) null);
            return;
        }
        String strC = this.f18189d.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        intentB.putExtra(Constants.KEY_APP_KEY, strC);
        if (UtilityImpl.isMainProcess(context)) {
            a(context, Message.buildUnbindUser(this.f18189d.b((String) null), this.b, intentB), 4, false);
        }
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3) {
        return a(context, str, str2, bArr, str3, (String) null);
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return a(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.b
    public String a(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return a(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.b
    public String a(Context context, ACCSManager.AccsRequest accsRequest) {
        boolean zD;
        try {
            zD = UtilityImpl.d(context);
        } catch (Throwable th) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data " + th.toString());
            ALog.e(f18188c, "sendData", th, "dataid", accsRequest.dataId);
        }
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(f18188c, "sendData not in mainprocess", new Object[0]);
            return null;
        }
        if (!zD && accsRequest != null) {
            if (TextUtils.isEmpty(this.f18189d.c())) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data appkey null");
                ALog.e(f18188c, "sendData appkey null", new Object[0]);
                return null;
            }
            this.f18189d.a();
            Message messageBuildSendData = Message.buildSendData(this.f18189d.b((String) null), this.b, this.f18189d.e(), context, context.getPackageName(), accsRequest);
            if (messageBuildSendData != null && messageBuildSendData.getNetPermanceMonitor() != null) {
                messageBuildSendData.getNetPermanceMonitor().onSend();
            }
            if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(messageBuildSendData.serviceId)) {
                ALog.e(f18188c, "sendMessage", Constants.KEY_DATA_ID, messageBuildSendData.getDataId());
            }
            this.f18189d.a(messageBuildSendData, true);
            return accsRequest.dataId;
        }
        if (zD) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
        } else {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
        }
        ALog.e(f18188c, "sendData dataInfo null or disable:" + zD, new Object[0]);
        return null;
    }

    @Override // com.taobao.accs.b
    public String a(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z2) {
        try {
        } catch (Throwable th) {
            if (accsRequest != null) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request " + th.toString());
                ALog.e(f18188c, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest.dataId);
            }
        }
        if (accsRequest == null) {
            ALog.e(f18188c, "sendRequest request null", new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
            return null;
        }
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(f18188c, "sendRequest not in mainprocess", new Object[0]);
            return null;
        }
        if (UtilityImpl.d(context)) {
            ALog.e(f18188c, "sendRequest disable", new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        }
        if (TextUtils.isEmpty(this.f18189d.c())) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
            ALog.e(f18188c, "sendRequest appkey null", new Object[0]);
            return null;
        }
        this.f18189d.a();
        Message messageBuildRequest = Message.buildRequest(context, this.f18189d.b((String) null), this.b, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z2);
        if (messageBuildRequest != null && messageBuildRequest.getNetPermanceMonitor() != null) {
            messageBuildRequest.getNetPermanceMonitor().onSend();
        }
        this.f18189d.a(messageBuildRequest, true);
        return accsRequest.dataId;
    }

    @Override // com.taobao.accs.b
    public String a(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        boolean z2;
        try {
            if (context != null && accsRequest != null) {
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
                if (UtilityImpl.d(context)) {
                    k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse accs disable");
                    return null;
                }
                String strC = this.f18189d.c();
                if (TextUtils.isEmpty(strC)) {
                    k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                    ALog.e(f18188c, "sendPushResponse appkey null", new Object[0]);
                    return null;
                }
                TaoBaseService.ExtraInfo extraInfo2 = extraInfo == null ? new TaoBaseService.ExtraInfo() : extraInfo;
                accsRequest.host = null;
                extraInfo2.fromPackage = context.getPackageName();
                if (extraInfo2.connType == 0 || extraInfo2.fromHost == null) {
                    extraInfo2.connType = 0;
                    ALog.w(f18188c, "pushresponse use channel", Constants.KEY_HOST, extraInfo2.fromHost);
                    z2 = false;
                } else {
                    z2 = true;
                }
                ALog.i(f18188c, "sendPushResponse", "sendbyInapp", Boolean.valueOf(z2), Constants.KEY_HOST, extraInfo2.fromHost, "pkg", extraInfo2.fromPackage);
                if (z2) {
                    ALog.i(f18188c, "sendPushResponse inapp by", "app", extraInfo2.fromPackage);
                    accsRequest.host = new URL(extraInfo2.fromHost);
                    if (context.getPackageName().equals(extraInfo2.fromPackage) && UtilityImpl.isMainProcess(context)) {
                        a(context, accsRequest, context.getPackageName(), false);
                        return null;
                    }
                    Intent intent = new Intent(Constants.ACTION_SEND);
                    intent.setClassName(extraInfo2.fromPackage, j.msgService);
                    intent.putExtra("packageName", context.getPackageName());
                    intent.putExtra(Constants.KEY_SEND_REQDATA, accsRequest);
                    intent.putExtra(Constants.KEY_APP_KEY, strC);
                    intent.putExtra(Constants.KEY_CONFIG_TAG, this.b);
                    com.taobao.accs.a.a.a(context, intent);
                    return null;
                }
                Intent intentB = b(context, 100);
                if (intentB == null) {
                    k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response intent null");
                    a(context, 100, accsRequest.serviceId, accsRequest.dataId);
                    ALog.e(f18188c, "sendPushResponse input null", "context", context, "response", accsRequest, RewardItem.KEY_EXTRA_INFO, extraInfo2);
                    return null;
                }
                ALog.i(f18188c, "sendPushResponse channel by", "app", extraInfo2.fromPackage);
                intentB.setClassName(extraInfo2.fromPackage, j.channelService);
                intentB.putExtra(Constants.KEY_SEND_TYPE, Message.ReqType.REQ);
                intentB.putExtra(Constants.KEY_APP_KEY, strC);
                intentB.putExtra(Constants.KEY_USER_ID, accsRequest.userId);
                intentB.putExtra(Constants.KEY_SERVICE_ID, accsRequest.serviceId);
                intentB.putExtra("data", accsRequest.data);
                intentB.putExtra(Constants.KEY_DATA_ID, accsRequest.dataId);
                intentB.putExtra(Constants.KEY_CONFIG_TAG, this.b);
                if (!TextUtils.isEmpty(accsRequest.businessId)) {
                    intentB.putExtra(Constants.KEY_BUSINESSID, accsRequest.businessId);
                }
                if (!TextUtils.isEmpty(accsRequest.tag)) {
                    intentB.putExtra(Constants.KEY_EXT_TAG, accsRequest.tag);
                }
                if (accsRequest.target != null) {
                    intentB.putExtra(Constants.KEY_TARGET, accsRequest.target);
                }
                com.taobao.accs.a.a.a(context, intentB);
                return null;
            }
            ALog.e(f18188c, "sendPushResponse input null", "context", context, "response", accsRequest, RewardItem.KEY_EXTRA_INFO, extraInfo);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
            return null;
        } catch (Throwable th) {
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
            ALog.e(f18188c, "sendPushResponse dataid:" + accsRequest.dataId, th, new Object[0]);
            return null;
        }
    }

    @Override // com.taobao.accs.b
    public boolean a() {
        try {
            if (this.f18189d != null) {
                if (this.f18189d.f()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.taobao.accs.b
    @Deprecated
    public void a(Context context, int i2) {
        ACCSClient.setEnvironment(context, i2);
    }

    private void a(Context context, int i2, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f18189d.c());
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.b);
        intent.putExtra("errorCode", i2 == 2 ? 200 : 300);
        g.a(context, intent);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            editorEdit.putString(Constants.KEY_PROXY_HOST, str);
        }
        editorEdit.putInt(Constants.KEY_PROXY_PORT, i2);
        editorEdit.apply();
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.b, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(f18188c, "inapp only init in main process!", new Object[0]);
            return;
        }
        ALog.d(f18188c, "startInAppConnection APPKEY:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.equals(this.f18189d.c(), str)) {
            this.f18189d.c(str2);
            this.f18189d.d(str);
            UtilityImpl.c(context, str);
        }
        this.f18189d.a();
    }

    @Override // com.taobao.accs.b
    public void a(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.b, iLoginInfo);
    }

    @Override // com.taobao.accs.b
    public boolean a(String str) {
        return this.f18189d.a(str);
    }

    @Override // com.taobao.accs.b
    public boolean a(int i2) {
        return ErrorCode.isChannelError(i2);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.b
    public void a(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.b
    public void a(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            this.f18189d.a(accsConnectStateListener);
        }
    }

    @Override // com.taobao.accs.b
    public void a(String str, String str2, String str3, short s2, String str4, Map<Integer, String> map) {
        this.f18189d.a(Message.buildPushAck(this.f18189d.b((String) null), this.b, str, str2, str3, true, s2, str4, map), true);
    }

    @Override // com.taobao.accs.b
    public void a(AccsClientConfig accsClientConfig) {
        this.f18189d.a(accsClientConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.taobao.accs.c cVar) {
        ThreadPoolExecutorFactory.schedule(new b(this, cVar), this.f18190e.nextInt(6), TimeUnit.SECONDS);
    }
}
