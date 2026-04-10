package com.umeng.message.common.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.baidu.tts.network.HttpClientUtil;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UmengMessageCallbackHandlerService;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.inter.IUTrack;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ag;
import com.umeng.message.proguard.i;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.o;
import com.umeng.message.proguard.q;
import com.umeng.message.proguard.r;
import com.umeng.message.proguard.s;
import com.umeng.message.service.UMJobIntentService;
import com.umeng.message.utils.HttpRequest;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JUTrack implements IUTrack {
    public static boolean DEBUG = false;
    private static final String a = "JUTrack";

    public static void log(Object... objArr) {
        UPLog.d(a, objArr);
    }

    public static JSONObject sendRequest(JSONObject jSONObject, String str) throws Exception {
        String strBody = HttpRequest.post(str).acceptJson().contentType("application/json").send(jSONObject.toString()).body("UTF-8");
        if (DEBUG) {
            log("sendRequest()\nurl: ", str, "\nrequest:\n", jSONObject, "\nresponse:\n", strBody);
        }
        return new JSONObject(strBody);
    }

    public static JSONObject sendRequestBase64(JSONObject jSONObject, String str, String str2) throws Exception {
        String str3 = new String(i.h(HttpRequest.post(str).acceptJson().contentType("application/json").header("appkey", str2).send(new String(i.c(jSONObject.toString().getBytes()))).body("UTF-8").getBytes()));
        if (DEBUG) {
            log("sendRequest() \nurl: ", str, "\nrequest:\n", jSONObject);
            log("response:\n", str3);
        }
        return new JSONObject(str3);
    }

    public static JSONObject sendRequestXor(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        byte[] bArrXor = xor(string.getBytes(), bytes);
        String str3 = new String(xor(HttpRequest.post(str).contentType(HttpClientUtil.APPLICATION_OCTET_STREAM).header("appkey", str2).contentLength(bArrXor.length).send(bArrXor).bytes(), bytes));
        if (DEBUG) {
            log("sendRequest() \nurl: ", str, "\nrequest:\n", jSONObject);
            log("response:\n", str3);
        }
        return new JSONObject(str3);
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ (i2 & 255));
            }
        }
        return bArr;
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void addAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        JSONObject jSONObjectSendRequest;
        String strOptString = jSONObject.optString("fail", "");
        String strOptString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(strOptString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + "添加失败");
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 1, strOptString);
            return;
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + "已经添加");
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 2, strOptString2);
            return;
        }
        try {
            jSONObjectSendRequest = sendRequest(jSONObject, MsgConstant.ALIAS_ENDPOINT);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(r.b())) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = sendRequest(r.b(), jSONObject, MsgConstant.ALIAS_ENDPOINT);
        }
        if (jSONObjectSendRequest != null && TextUtils.equals(jSONObjectSendRequest.optString("success", ""), "ok")) {
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 0, "");
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(am.aU, jSONObjectSendRequest.optLong(am.aU, 0L));
                jSONObject2.put("last_requestTime", System.currentTimeMillis());
                MessageSharedPrefs.getInstance(r.b()).setAddAliasInterval(jSONObject2.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            uPushAliasCallback.onMessage(true, "alias:" + str + "添加成功");
            return;
        }
        MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 0, 1, "网络请求失败alias:" + str + ",type:" + str2 + ",deviceToken:" + MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        StringBuilder sb = new StringBuilder();
        sb.append("alias:");
        sb.append(str);
        sb.append("添加失败");
        uPushAliasCallback.onMessage(false, sb.toString());
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void deleteAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        JSONObject jSONObjectSendRequest;
        try {
            jSONObjectSendRequest = sendRequest(jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(r.b())) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = sendRequest(r.b(), jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT);
        }
        if (jSONObjectSendRequest == null || !TextUtils.equals(jSONObjectSendRequest.getString("success"), "ok")) {
            uPushAliasCallback.onMessage(true, "alias:" + str + ",type:" + str2 + "删除失败");
            return;
        }
        MessageSharedPrefs.getInstance(r.b()).removeAlias(0, str, str2);
        MessageSharedPrefs.getInstance(r.b()).removeAlias(1, str, str2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(am.aU, jSONObjectSendRequest.optLong(am.aU, 0L));
            jSONObject2.put("last_requestTime", System.currentTimeMillis());
            MessageSharedPrefs.getInstance(r.b()).addDeleteAliasInterval(jSONObject2.toString());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        uPushAliasCallback.onMessage(true, "alias:" + str + ",type:" + str2 + "删除成功");
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void sendMsgLog(JSONObject jSONObject, String str, int i2) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(r.b()));
        jSONObject3.put("p_sdk_v", "6.5.1");
        jSONObject3.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(r.b()));
        jSONObject2.put("header", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("ts", jSONObject.getLong("ts"));
        jSONObject4.put("pa", jSONObject.getString("pa"));
        jSONObject4.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        jSONObject4.put("msg_id", jSONObject.getString("msg_id"));
        jSONObject4.put(MsgConstant.KEY_ACTION_TYPE, jSONObject.getInt(MsgConstant.KEY_ACTION_TYPE));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray);
        jSONObject2.put("content", jSONObject5);
        if (l.c(r.b())) {
            UMWorkDispatch.sendEvent(r.b(), MsgConstant.PUSH_LOG, q.a(), jSONObject2.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject3);
        jSONObject6.put("jsonBody", jSONObject5);
        jSONObject6.put("msgId", str);
        jSONObject6.put("actionType", i2);
        Intent intent = new Intent();
        intent.setPackage(r.b().getPackageName());
        intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
        intent.setAction(MsgConstant.MESSAGE_MESSAGE_SEND_ACTION);
        intent.putExtra(MsgConstant.KEY_PX_PATH, MsgConstant.UNPX_PUSH_LOGS);
        intent.putExtra(MsgConstant.KEY_SEND_MESSAGE, jSONObject6.toString());
        UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void sendMsgShow(JSONObject jSONObject, String str, int i2, String str2) throws Exception {
        Object objValueOf;
        int importance;
        NotificationManager notificationManager;
        List<NotificationChannel> notificationChannels;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(r.b()));
        jSONObject3.put("p_sdk_v", "6.5.1");
        jSONObject3.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(r.b()));
        jSONObject2.put("header", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("ts", jSONObject.getLong("ts"));
        jSONObject4.put("pa", jSONObject.getString("pa"));
        jSONObject4.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        jSONObject4.put("msg_id", jSONObject.getString("msg_id"));
        jSONObject4.put(MsgConstant.KEY_ACTION_TYPE, jSONObject.getInt(MsgConstant.KEY_ACTION_TYPE));
        JSONArray jSONArray = new JSONArray();
        Object id = "";
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) r.b().getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)) == null || (notificationChannels = notificationManager.getNotificationChannels()) == null) {
            objValueOf = "";
            importance = -1;
        } else {
            objValueOf = "";
            importance = -1;
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (TextUtils.equals(str2, notificationChannel.getId())) {
                    id = notificationChannel.getId();
                    objValueOf = String.valueOf(notificationChannel.getName());
                    importance = notificationChannel.getImportance();
                } else {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("chan_id", notificationChannel.getId());
                    jSONObject5.put("chan_name", String.valueOf(notificationChannel.getName()));
                    jSONObject5.put("chan_imp", notificationChannel.getImportance());
                    jSONArray.put(jSONObject5);
                }
            }
        }
        jSONObject4.put("chan_id", id);
        jSONObject4.put("chan_name", objValueOf);
        jSONObject4.put("chan_imp", importance);
        jSONObject4.put("ext_chan_stat", jSONArray);
        jSONObject4.put("fg_stat", o.a().c() ? 1 : 0);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject4);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("push", jSONArray2);
        jSONObject2.put("content", jSONObject6);
        if (l.c(r.b())) {
            UMWorkDispatch.sendEvent(r.b(), MsgConstant.PUSH_SHOW, q.a(), jSONObject2.toString());
            return;
        }
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("jsonHeader", jSONObject3);
        jSONObject7.put("jsonBody", jSONObject6);
        jSONObject7.put("msgId", str);
        jSONObject7.put("actionType", i2);
        Intent intent = new Intent();
        intent.setPackage(r.b().getPackageName());
        intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
        intent.setAction(MsgConstant.MESSAGE_MESSAGE_SEND_ACTION);
        intent.putExtra(MsgConstant.KEY_PX_PATH, MsgConstant.UNPX_PUSH_LOGS);
        intent.putExtra(MsgConstant.KEY_SEND_MESSAGE, jSONObject7.toString());
        UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void setAlias(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        JSONObject jSONObjectSendRequest;
        String strOptString = jSONObject.optString("fail", "");
        String strOptString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(strOptString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + "添加失败");
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 1, strOptString);
            return;
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + "已经添加");
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 2, strOptString2);
            return;
        }
        try {
            jSONObjectSendRequest = sendRequest(jSONObject, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
        } catch (Exception e2) {
            if (!(e2 instanceof UnknownHostException) || !UmengMessageDeviceConfig.isOnline(r.b())) {
                throw new Exception(e2);
            }
            jSONObjectSendRequest = sendRequest(r.b(), jSONObject, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
        }
        if (jSONObjectSendRequest != null && TextUtils.equals(jSONObjectSendRequest.optString("success", ""), "ok")) {
            MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 0, "");
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(am.aU, jSONObjectSendRequest.optLong(am.aU, 0L));
                jSONObject2.put("last_requestTime", System.currentTimeMillis());
                MessageSharedPrefs.getInstance(r.b()).setSetAliasInterval(jSONObject2.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            uPushAliasCallback.onMessage(true, "alias:" + str + "添加成功");
            return;
        }
        MessageSharedPrefs.getInstance(r.b()).addAlias(str, str2, 1, 1, "网络请求失败alias:" + str + ",type:" + str2 + ",deviceToken:" + MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        StringBuilder sb = new StringBuilder();
        sb.append("alias:");
        sb.append(str);
        sb.append("添加失败");
        uPushAliasCallback.onMessage(false, sb.toString());
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void trackAppLaunch(JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(r.b()));
        jSONObject3.put("p_sdk_v", "6.5.1");
        jSONObject3.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(r.b()));
        jSONObject2.put("header", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray);
        jSONObject2.put("content", jSONObject5);
        if (l.c(r.b())) {
            UMWorkDispatch.sendEvent(r.b(), 16386, q.a(), jSONObject2.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject3);
        jSONObject6.put("jsonBody", jSONObject5);
        Intent intent = new Intent();
        intent.setPackage(r.b().getPackageName());
        intent.setClass(r.b(), UmengMessageCallbackHandlerService.class);
        intent.setAction(MsgConstant.MESSAGE_MESSAGE_SEND_ACTION);
        intent.putExtra(MsgConstant.KEY_PX_PATH, MsgConstant.UMPX_PUSH_LAUNCH);
        intent.putExtra(MsgConstant.KEY_SEND_MESSAGE, jSONObject6.toString());
        UMJobIntentService.enqueueWork(r.b(), (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
        s.a = false;
    }

    @Override // com.umeng.message.common.inter.IUTrack
    public void trackRegister(JSONObject jSONObject, String str) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(r.b()));
        jSONObject3.put("p_sdk_v", "6.5.1");
        jSONObject3.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(r.b()));
        jSONObject2.put("header", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(r.b()).getDeviceToken());
        jSONObject4.put("old_device_token", str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray);
        jSONObject2.put("content", jSONObject5);
        if (l.c(r.b())) {
            UMWorkDispatch.sendEvent(r.b(), MsgConstant.PUSH_REGISTER, q.a(), jSONObject2.toString());
        }
    }

    public static JSONObject sendRequest(Context context, JSONObject jSONObject, String str) throws Exception {
        String host = new URL(str).getHost();
        String strA = ag.a(context, host);
        if (DEBUG) {
            log("ip:" + strA);
        }
        if (strA == null) {
            return null;
        }
        URL url = new URL(str.replaceFirst(host, strA));
        String strBody = HttpRequest.post(url).acceptJson().contentType("application/json").header(HttpConstant.HOST, host).trustHosts().send(jSONObject.toString()).body("UTF-8");
        if (DEBUG) {
            log("dns-->sendRequest()\nurl: ", url.toString(), "\nrequest:\n", jSONObject, "\nresponse:\n", strBody);
        }
        return new JSONObject(strBody);
    }
}
