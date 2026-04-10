package com.umeng.message.proguard;

import android.app.Notification;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageCallbackHandlerService;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.impl.JUTrack;
import com.umeng.message.common.inter.IUTrack;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ae;
import com.umeng.message.service.UMJobIntentService;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushTrackImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends UTrack {
    public static volatile boolean a = false;
    public static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20503c = "UTrack";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f20504e = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IUTrack f20505d;

    /* JADX INFO: compiled from: UPushTrackImpl.java */
    static class a {
        private static final s a = new s();

        private a() {
        }
    }

    private void e() {
        if (f()) {
            return;
        }
        if (f20504e) {
            UPLog.d(f20503c, "appCachedPushLog sending, has ignored");
            return;
        }
        UPLog.d(f20503c, "appCachedPushLog start");
        f20504e = true;
        if (l.c(r.b())) {
            c.a(new Runnable() { // from class: com.umeng.message.proguard.s.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean unused = s.f20504e = false;
                }
            }, 30L, TimeUnit.SECONDS);
            c.b(new Runnable() { // from class: com.umeng.message.proguard.s.3
                @Override // java.lang.Runnable
                public void run() {
                    s.this.c();
                    s.this.d();
                }
            });
        }
    }

    private boolean f() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(r.b()))) {
            return true;
        }
        return TextUtils.isEmpty(MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject g() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(r.b()).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(r.b());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    @Override // com.umeng.message.UTrack
    public void addAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        c.a(new Runnable() { // from class: com.umeng.message.proguard.s.6
            @Override // java.lang.Runnable
            public void run() {
                boolean z2;
                try {
                    String addAliasInterval = MessageSharedPrefs.getInstance(r.b()).getAddAliasInterval();
                    JSONObject jSONObject = null;
                    if (addAliasInterval != null && addAliasInterval.length() > 0) {
                        jSONObject = new JSONObject(addAliasInterval);
                    }
                    String strA = s.this.a(str, str2, jSONObject);
                    if (strA != null && strA.length() > 0) {
                        uPushAliasCallback.onMessage(false, strA);
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String utdid = UmengMessageDeviceConfig.getUtdid(r.b());
                String deviceToken = MessageSharedPrefs.getInstance(r.b()).getDeviceToken();
                StringBuilder sb = new StringBuilder();
                String str3 = "";
                sb.append("");
                sb.append("utdid:");
                sb.append(utdid);
                sb.append(",deviceToken:");
                sb.append(deviceToken);
                sb.append(";");
                String string = sb.toString();
                boolean z3 = true;
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                    UPLog.e(s.f20503c, "addAlias: type or alias empty.");
                    string = string + "addAlias: empty type or alias;";
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (TextUtils.isEmpty(utdid)) {
                    UPLog.e(s.f20503c, "utdid is empty.");
                    string = string + "UTDID is empty;";
                    z2 = false;
                }
                if (TextUtils.isEmpty(deviceToken)) {
                    UPLog.e(s.f20503c, "deviceToken is empty.");
                    string = string + "RegistrationId is empty;";
                    z2 = false;
                }
                if (MessageSharedPrefs.getInstance(r.b()).isAliasSet(0, str, str2)) {
                    UPLog.d(s.f20503c, String.format(Locale.ROOT, "addAlias: <%s, %s> has been synced to the server before. Ignore this request", str, str2));
                    str3 = "" + String.format("addAlias: <%s, %s> has been synced to the server before. Ignore this request;", str, str2);
                    z2 = false;
                } else {
                    z3 = false;
                }
                try {
                    JSONObject jSONObjectG = s.this.g();
                    if (z2) {
                        jSONObjectG.put("alias", str);
                        jSONObjectG.put("type", str2);
                        jSONObjectG.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(r.b()).getLastAlias(0, str2));
                        jSONObjectG.put("ts", System.currentTimeMillis());
                    } else if (z3) {
                        jSONObjectG.put("success", str3);
                    } else {
                        jSONObjectG.put("fail", string);
                    }
                    s.this.f20505d.addAlias(str, str2, jSONObjectG, uPushAliasCallback);
                } catch (Throwable th) {
                    if (th.getMessage() == null) {
                        UPushAliasCallback uPushAliasCallback2 = uPushAliasCallback;
                        if (uPushAliasCallback2 != null) {
                            uPushAliasCallback2.onMessage(false, "alias:" + str + " add failed");
                            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 1, "添加失败");
                            return;
                        }
                        return;
                    }
                    UPushAliasCallback uPushAliasCallback3 = uPushAliasCallback;
                    if (uPushAliasCallback3 != null) {
                        uPushAliasCallback3.onMessage(false, "alias:" + str + " add failed:" + th.getMessage());
                        MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 1, th.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public void deleteAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        c.a(new Runnable() { // from class: com.umeng.message.proguard.s.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z2;
                try {
                    String deleteAliasInterval = MessageSharedPrefs.getInstance(r.b()).getDeleteAliasInterval();
                    JSONObject jSONObject = null;
                    if (deleteAliasInterval != null && deleteAliasInterval.length() > 0) {
                        jSONObject = new JSONObject(deleteAliasInterval);
                    }
                    String strA = s.this.a(str, str2, jSONObject);
                    if (strA != null && strA.length() > 0) {
                        uPushAliasCallback.onMessage(false, strA);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                String str3 = "";
                if (TextUtils.isEmpty(str2)) {
                    UPLog.e(s.f20503c, "removeAlias: type empty.");
                    str3 = "removeAlias: empty type";
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(r.b()))) {
                    UPLog.e(s.f20503c, "removeAlias: utdid empty.");
                    str3 = str3 + "UTDID is empty;";
                    z2 = false;
                }
                if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(r.b()).getDeviceToken())) {
                    UPLog.e(s.f20503c, "removeAlias: deviceToken empty.");
                    str3 = str3 + "RegistrationId is empty;";
                    z2 = false;
                }
                try {
                    JSONObject jSONObjectG = s.this.g();
                    if (z2) {
                        jSONObjectG.put("alias", str);
                        jSONObjectG.put("type", str2);
                        jSONObjectG.put("ts", System.currentTimeMillis());
                    } else {
                        jSONObjectG.put("fail", str3);
                    }
                    s.this.f20505d.deleteAlias(str, str2, jSONObjectG, uPushAliasCallback);
                } catch (Throwable th2) {
                    if (th2.getMessage() == null) {
                        uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed.");
                        return;
                    }
                    uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed:" + th2.getMessage());
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public void setAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        c.a(new Runnable() { // from class: com.umeng.message.proguard.s.7
            @Override // java.lang.Runnable
            public void run() {
                String str3;
                boolean z2;
                String str4;
                boolean z3;
                try {
                    String setAliasInterval = MessageSharedPrefs.getInstance(r.b()).getSetAliasInterval();
                    JSONObject jSONObject = null;
                    if (setAliasInterval != null && setAliasInterval.length() > 0) {
                        jSONObject = new JSONObject(setAliasInterval);
                    }
                    String strA = s.this.a(str, str2, jSONObject);
                    if (strA != null && strA.length() > 0) {
                        uPushAliasCallback.onMessage(false, strA);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    UPLog.e(s.f20503c, "addExclusiveAlias: type empty.");
                    str3 = "addExclusiveAlias: empty type";
                    z2 = false;
                } else {
                    str3 = "";
                    z2 = true;
                }
                if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(r.b()))) {
                    UPLog.e(s.f20503c, "addExclusiveAlias: utdid empty.");
                    str3 = str3 + "UTDID is empty;";
                    z2 = false;
                }
                if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(r.b()).getDeviceToken())) {
                    UPLog.e(s.f20503c, "addExclusiveAlias: deviceToken empty.");
                    str3 = str3 + "RegistrationId is empty;";
                    z2 = false;
                }
                if (MessageSharedPrefs.getInstance(r.b()).isAliasSet(1, str, str2)) {
                    UPLog.d(s.f20503c, String.format("addExclusiveAlias: <%s, %s> 已经同步至服务器，忽略该请求", str, str2));
                    str4 = "" + String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ignore this request.", str, str2);
                    z3 = true;
                    z2 = false;
                } else {
                    str4 = "";
                    z3 = false;
                }
                try {
                    JSONObject jSONObjectG = s.this.g();
                    if (z2) {
                        jSONObjectG.put("alias", str);
                        jSONObjectG.put("type", str2);
                        jSONObjectG.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(r.b()).getLastAlias(1, str2));
                        jSONObjectG.put("ts", System.currentTimeMillis());
                    } else if (z3) {
                        jSONObjectG.put("success", str4);
                    } else {
                        jSONObjectG.put("fail", str3);
                    }
                    s.this.f20505d.setAlias(str, str2, jSONObjectG, uPushAliasCallback);
                } catch (Throwable th2) {
                    if (th2.getMessage() == null) {
                        uPushAliasCallback.onMessage(false, "alias:" + str + "add failed.");
                        MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 1, "添加失败");
                        return;
                    }
                    uPushAliasCallback.onMessage(false, "alias:" + str + "add failed:" + th2.getMessage());
                    MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 1, th2.getMessage());
                }
            }
        });
    }

    @Override // com.umeng.message.UTrack
    public void trackMfrPushMsgClick(UMessage uMessage) {
        if (uMessage == null || TextUtils.isEmpty(uMessage.msg_id)) {
            return;
        }
        b(uMessage.msg_id, 21, uMessage.pulledWho);
    }

    @Override // com.umeng.message.UTrack
    public void trackMsgArrival(UMessage uMessage) {
        String str;
        if (uMessage == null || (str = uMessage.msg_id) == null) {
            return;
        }
        b(str, 0, uMessage.pulledWho);
    }

    @Override // com.umeng.message.UTrack
    public void trackMsgClick(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.msg_id)) {
            b(uMessage.msg_id, 1, uMessage.pulledWho);
        }
        if (uMessage == null || TextUtils.isEmpty(uMessage.message_id)) {
            return;
        }
        b(uMessage.message_id, uMessage.task_id, "8");
    }

    @Override // com.umeng.message.UTrack
    public void trackMsgDismissed(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.msg_id)) {
            b(uMessage.msg_id, 2, uMessage.pulledWho);
        }
        if (uMessage == null || TextUtils.isEmpty(uMessage.message_id)) {
            return;
        }
        b(uMessage.message_id, uMessage.task_id, "9");
    }

    @Override // com.umeng.message.UTrack
    public void trackMsgShow(UMessage uMessage, Notification notification) {
        int i2;
        if (uMessage == null || TextUtils.isEmpty(uMessage.msg_id)) {
            return;
        }
        if (TextUtils.equals(uMessage.display_type, UMessage.DISPLAY_TYPE_NOTIFICATION)) {
            i2 = 6;
        } else if (!TextUtils.equals(uMessage.display_type, "custom")) {
            return;
        } else {
            i2 = 7;
        }
        try {
            JSONObject jSONObjectG = g();
            jSONObjectG.put("msg_id", uMessage.msg_id);
            jSONObjectG.put(MsgConstant.KEY_ACTION_TYPE, i2);
            jSONObjectG.put("ts", System.currentTimeMillis());
            jSONObjectG.put("pa", "");
            String channelId = null;
            if (Build.VERSION.SDK_INT >= 26 && notification != null) {
                channelId = notification.getChannelId();
            }
            this.f20505d.sendMsgShow(jSONObjectG, uMessage.msg_id, i2, channelId);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private s() {
        this.f20505d = new JUTrack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<ae.a> arrayListA = ae.a(r.b()).a();
            if (arrayListA == null || arrayListA.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < arrayListA.size(); i2++) {
                ae.a aVar = arrayListA.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", aVar.b);
                jSONObject.put("pa", aVar.f20439d);
                jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
                jSONObject.put("msg_id", aVar.a);
                jSONObject.put(MsgConstant.KEY_ACTION_TYPE, aVar.f20438c);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(r.b()));
            jSONObject3.put("p_sdk_v", "6.5.1");
            jSONObject3.put("umid", UmengMessageDeviceConfig.getUmid(r.b()));
            jSONObject2.put("header", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("push", jSONArray);
            jSONObject2.put("content", jSONObject4);
            if (l.c(r.b())) {
                UMWorkDispatch.sendEvent(r.b(), MsgConstant.PUSH_MESSAGE_CACHE, q.a(), jSONObject2.toString());
                return;
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject3);
            jSONObject5.put("jsonBody", jSONObject4);
            Intent intent = new Intent();
            intent.setPackage(r.b().getPackageName());
            intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
            intent.setAction(MsgConstant.MESSAGE_MESSAGE_SEND_ACTION);
            intent.putExtra(MsgConstant.KEY_PX_PATH, MsgConstant.UNPX_PUSH_LOGS);
            intent.putExtra(MsgConstant.KEY_SEND_MESSAGE, jSONObject5.toString());
            UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
        } catch (Throwable th) {
            UPLog.i(f20503c, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            ArrayList<ae.b> arrayListB = ae.a(r.b()).b();
            for (int i2 = 0; i2 < arrayListB.size(); i2++) {
                ae.b bVar = arrayListB.get(i2);
                a(bVar.a, bVar.b, bVar.f20440c);
            }
        } catch (Throwable th) {
            UPLog.i(f20503c, th);
        }
    }

    public void b(UMessage uMessage) {
        b(uMessage.recall, 5, uMessage.pulledWho);
    }

    private void b(String str, int i2, String str2) {
        a(str, i2, str2);
    }

    public static s a() {
        return a.a;
    }

    private void b(final String str, final String str2, final String str3) {
        c.b(new Runnable() { // from class: com.umeng.message.proguard.s.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.a(str, str2, str3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void a(UMessage uMessage) {
        b(uMessage.recall, 4, uMessage.pulledWho);
    }

    private void a(String str, int i2, String str2) {
        if (f()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UPLog.e(f20503c, "trackMsgDPlus: msgId empty.");
        } else {
            a(str, i2, System.currentTimeMillis(), str2);
        }
    }

    public void b() {
        e();
    }

    private void b(long j2) {
        if (a) {
            UPLog.d(f20503c, "trackAppLaunch sending, has ignored");
            return;
        }
        UPLog.d(f20503c, "trackAppLaunch start");
        a = true;
        Runnable runnable = new Runnable() { // from class: com.umeng.message.proguard.s.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.f20505d.trackAppLaunch(s.this.g());
                } catch (Exception unused) {
                    s.a = false;
                }
            }
        };
        UPLog.d(f20503c, String.format(Locale.ROOT, "trackAppLaunch(delay=%d)", Long.valueOf(j2)));
        c.a(runnable, j2, TimeUnit.MILLISECONDS);
    }

    private synchronized void a(String str, int i2, long j2, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        try {
            JSONObject jSONObjectG = g();
            jSONObjectG.put("msg_id", str);
            jSONObjectG.put(MsgConstant.KEY_ACTION_TYPE, i2);
            jSONObjectG.put("ts", j2);
            jSONObjectG.put("pa", str2);
            this.f20505d.sendMsgLog(jSONObjectG, str, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void a(String str, String str2, String str3) {
        UPLog.d(f20503c, "sendMsgLogForAgoo-->msgId:" + str + ",taskId:" + str2);
        if (str3.equalsIgnoreCase("8")) {
            TaobaoRegister.clickMessage(r.b(), str, str2);
        } else {
            TaobaoRegister.dismissMessage(r.b(), str, str2);
        }
        ae.a(r.b()).a(str, str3);
        if (!str3.equals("7")) {
            ae.a(r.b()).a(str);
        }
    }

    public static void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            Context contextB = r.b();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String strOptString = jSONObject.optString("msg_id");
                    int iOptInt = jSONObject.optInt(MsgConstant.KEY_ACTION_TYPE);
                    arrayList.add(ContentProviderOperation.newDelete(ab.f20369g).withSelection("MsgId=? And ActionType=?", new String[]{strOptString, iOptInt + ""}).build());
                    if (iOptInt != 0) {
                        arrayList.add(ContentProviderOperation.newDelete(ab.f20370h).withSelection("MsgId=?", new String[]{strOptString}).build());
                    }
                }
            }
            contextB.getContentResolver().applyBatch(ab.a, arrayList);
        } catch (Throwable th) {
            UPLog.d(f20503c, "removeCacheLog:" + th.toString());
        }
    }

    public void a(long j2) {
        if (f()) {
            return;
        }
        if (MessageSharedPrefs.getInstance(r.b()).getAppLaunchLogSendPolicy() == 1) {
            UPLog.d(f20503c, "launch_policy=1, skipped.");
        } else {
            if (MessageSharedPrefs.getInstance(r.b()).hasAppLaunchLogSentToday()) {
                return;
            }
            b(j2);
        }
    }

    public void a(final String str) {
        if (f() || MessageSharedPrefs.getInstance(r.b()).isRegistered()) {
            return;
        }
        if (b) {
            UPLog.d(f20503c, "trackRegister sending, has ignored");
            return;
        }
        UPLog.d(f20503c, "trackRegister send start");
        b = true;
        c.b(new Runnable() { // from class: com.umeng.message.proguard.s.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectG = s.this.g();
                    UPLog.d(s.f20503c, "trackRegister-->request:" + jSONObjectG.toString());
                    s.this.f20505d.trackRegister(jSONObjectG, str);
                } catch (Throwable th) {
                    s.b = false;
                    UPLog.e(s.f20503c, th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, JSONObject jSONObject) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            boolean z2 = bytes.length <= 128;
            boolean z3 = bytes2.length <= 64;
            if (!z2 || !z3) {
                return "alias长度不在0~128之间或aliasType长度不在0~64之间";
            }
            if (jSONObject == null) {
                return null;
            }
            long jOptLong = jSONObject.optLong(am.aU, 0L);
            long jOptLong2 = jSONObject.optLong("last_requestTime", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jOptLong == 0) {
                return null;
            }
            if ((jCurrentTimeMillis - jOptLong2) / 1000 < jOptLong) {
                return "interval限制";
            }
            return null;
        } catch (Throwable th) {
            UPLog.d(f20503c, "checkAlias: " + th.toString());
            return null;
        }
    }
}
