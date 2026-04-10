package com.umeng.message.proguard;

import android.content.ContentProviderOperation;
import android.content.Context;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageCallbackHandlerService;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushLogDataProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class q implements UMLogDataProtocol {
    protected static final String a = "LogDataProtocol";
    private static final UMLogDataProtocol b = new q();

    private q() {
    }

    public static UMLogDataProtocol a() {
        return b;
    }

    private void b(Object obj) throws Exception {
        JSONObject jSONObject = new JSONObject(obj.toString());
        Context contextB = r.b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("p_sdk_v", "6.5.1");
        jSONObject2.put("din", UmengMessageDeviceConfig.getImeiAes(contextB));
        jSONObject2.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(contextB));
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("pa", "");
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, PushAgent.getInstance(contextB).getRegistrationId());
        jSONObject.put("msg_id", "");
        jSONObject.put("ts", System.currentTimeMillis());
        jSONArray.put(jSONObject);
        jSONObject3.put("push", jSONArray);
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObject2, jSONObject3, MsgConstant.UNPX_PUSH_LOGS, "p", "6.5.1");
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            jSONObjectBuildEnvelopeWithExtHeader.has("exception");
        }
    }

    private void c(Object obj) throws Exception {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject, jSONObjectOptJSONObject2, MsgConstant.UNPX_PUSH_LOGS, "p", "6.5.1")) == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
            return;
        }
        s.a(jSONObjectOptJSONObject2.getJSONArray("push"));
    }

    private void d(Object obj) throws Exception {
        int i2;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("jsonHeader");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("jsonBody");
        String strOptString = jSONObject.optString(MsgConstant.KEY_PX_PATH);
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("push");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            i2 = 0;
        } else {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(0);
            int iOptInt = jSONObject2.optInt(MsgConstant.KEY_ACTION_TYPE);
            if (iOptInt == 0) {
                ((y) PushAgent.getInstance(contextB).getMessageNotifyApi()).a(jSONObject2);
            }
            i2 = iOptInt;
        }
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject, jSONObjectOptJSONObject2, strOptString, "p", "6.5.1");
        if (jSONObjectBuildEnvelopeWithExtHeader == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception") || i2 == 6 || i2 == 7) {
            return;
        }
        UmengMessageCallbackHandlerService.removeCacheLog(contextB, jSONObjectOptJSONObject2.getJSONArray("push"));
    }

    private void e(Object obj) throws Exception {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null && (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject, jSONObjectOptJSONObject2, MsgConstant.UMPX_PUSH_REGISTER, "p", "6.5.1")) != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
            MessageSharedPrefs.getInstance(contextB).setRegistered(true);
        }
        s.b = false;
    }

    private void f(Object obj) throws Exception {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null && (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject, jSONObjectOptJSONObject2, MsgConstant.UMPX_PUSH_LAUNCH, "p", "6.5.1")) != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
            ae.a(contextB).a(System.currentTimeMillis());
            int i2 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(contextB, "launch_policy", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE));
            UPLog.i(a, "launch_policy:", Integer.valueOf(i2));
            int i3 = Integer.parseInt(UMEnvelopeBuild.imprintProperty(contextB, "tag_policy", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE));
            UPLog.i(a, "tag_policy:", Integer.valueOf(i3));
            if (i2 > 0) {
                MessageSharedPrefs.getInstance(contextB).setAppLaunchLogSendPolicy(i2);
            }
            if (i3 > 0) {
                MessageSharedPrefs.getInstance(contextB).setTagSendPolicy(i3);
            }
        }
        s.a = false;
    }

    private void g(Object obj) throws Exception {
        int i2;
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONArray jSONArrayOptJSONArray;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("push")) == null || jSONArrayOptJSONArray.length() <= 0) {
            i2 = -1;
        } else {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(0);
            int iOptInt = jSONObject2.optInt(MsgConstant.KEY_ACTION_TYPE);
            if (iOptInt != 70 && iOptInt != 71) {
                if (iOptInt == 0) {
                    ((y) PushAgent.getInstance(contextB).getMessageNotifyApi()).a(jSONObject2);
                }
                ae.a(contextB).a(jSONObject2.optString("msg_id"), iOptInt, jSONObject2.optLong("ts"), jSONObject2.optString("pa"));
            }
            i2 = iOptInt;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject2, jSONObjectOptJSONObject, MsgConstant.UNPX_PUSH_LOGS, "p", "6.5.1")) == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception") || i2 == 70 || i2 == 71) {
            return;
        }
        removeCacheData(jSONObject);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(obj.toString()).optJSONObject("content");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            Context contextB = r.b();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("push");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i2);
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
            th.printStackTrace();
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        if (obj == null) {
            return;
        }
        try {
            switch (i2) {
                case MsgConstant.PUSH_LOG /* 16385 */:
                    g(obj);
                    break;
                case 16386:
                    f(obj);
                    break;
                case MsgConstant.PUSH_REGISTER /* 16387 */:
                    e(obj);
                    break;
                case MsgConstant.PUSH_MESSAGE_HANDLER_ACTION /* 16388 */:
                    d(obj);
                    break;
                case MsgConstant.PUSH_MESSAGE_CACHE /* 16389 */:
                    c(obj);
                    break;
                case MsgConstant.PUSH_PKG_STAT /* 16390 */:
                    b(obj);
                    break;
                case MsgConstant.PUSH_SHOW /* 16391 */:
                    a(obj);
                    break;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Object obj) throws Exception {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        Context contextB = r.b();
        JSONObject jSONObject = new JSONObject(obj.toString());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(contextB, jSONObjectOptJSONObject2, jSONObjectOptJSONObject, MsgConstant.UNPX_PUSH_LOGS, "p", "6.5.1")) == null) {
            return;
        }
        jSONObjectBuildEnvelopeWithExtHeader.has("exception");
    }
}
