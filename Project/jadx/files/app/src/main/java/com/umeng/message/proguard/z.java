package com.umeng.message.proguard;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.impl.JUTrack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushNotifyModel.java */
/* JADX INFO: loaded from: classes3.dex */
class z {
    private static final String a = "Notify";
    private static final int b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20547c = "data";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20548d = "pkg";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UPushMessageNotifyApi.Callback f20549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final aa f20550f = new aa();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f20551g;

    public boolean b() {
        return this.f20550f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(boolean z2) throws Exception {
        Context contextB = r.b();
        String zid = UMUtils.getZid(contextB);
        if (TextUtils.isEmpty(zid)) {
            UPLog.d(a, "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(contextB).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.d(a, "appkey skip.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("zid", zid);
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("appkey", messageAppkey);
        jSONObject.put(MsgConstant.KEY_DEVICE_PUSH_SWITCH, z2 ? 1 : 0);
        JSONObject jSONObjectSendRequestBase64 = null;
        try {
            jSONObjectSendRequestBase64 = JUTrack.sendRequestBase64(jSONObject, MsgConstant.NOTIFY_SWITCH_ENDPOINT, messageAppkey);
        } catch (Exception e2) {
            UPLog.d(a, "uploadEnableState error:", e2.getMessage());
        }
        return jSONObjectSendRequestBase64 != null;
    }

    public void a() {
        if (this.f20550f.g()) {
            c.a(new Runnable() { // from class: com.umeng.message.proguard.z.1
                @Override // java.lang.Runnable
                public void run() throws Exception {
                    boolean zA = z.this.f20550f.a();
                    boolean zB = false;
                    try {
                        if (UmengMessageDeviceConfig.isOnline(r.b())) {
                            zB = z.this.b(zA);
                        }
                    } catch (Throwable th) {
                        UPLog.e(z.a, th);
                    }
                    z.this.f20550f.c(true ^ zB);
                }
            });
        }
    }

    public void a(final String str) {
        if (this.f20550f.a()) {
            if ((this.f20550f.b() || this.f20550f.d()) && this.f20550f.c()) {
                this.f20550f.a(System.currentTimeMillis());
                c.b(new Runnable() { // from class: com.umeng.message.proguard.z.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (UmengMessageDeviceConfig.isOnline(r.b())) {
                                z.this.b(str);
                            }
                        } catch (Throwable th) {
                            UPLog.e(z.a, th);
                        }
                    }
                });
            }
        }
    }

    public void a(Activity activity, final Intent intent) {
        this.f20551g = true;
        if (activity == null || intent == null) {
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        final String name = activity.getClass().getName();
        c.a(new Runnable() { // from class: com.umeng.message.proguard.z.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    z.this.a(applicationContext, intent, name);
                } catch (Throwable th) {
                    UPLog.e(z.a, th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) throws Exception {
        int length;
        Context contextB = r.b();
        String zid = UMUtils.getZid(contextB);
        int i2 = 0;
        if (TextUtils.isEmpty(zid)) {
            UPLog.d(a, "zid skip.");
            return;
        }
        String registrationId = PushAgent.getInstance(contextB).getRegistrationId();
        if (TextUtils.isEmpty(registrationId)) {
            UPLog.d(a, "deviceToken skip.");
            return;
        }
        String messageAppkey = PushAgent.getInstance(contextB).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.d(a, "appkey skip.");
            return;
        }
        String packageName = contextB.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            UPLog.d(a, "pkgName skip.");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("zid", zid);
        jSONObject.put("appkey", messageAppkey);
        jSONObject.put("package_name", packageName);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("devicetoken", registrationId);
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("sdk_version", "6.5.1");
        jSONObject.put("app_version", UmengMessageDeviceConfig.getAppVersionName(contextB));
        jSONObject.put("version_code", UmengMessageDeviceConfig.getAppVersionCode(contextB));
        jSONObject.put("ts", System.currentTimeMillis());
        JSONObject jSONObjectSendRequestBase64 = null;
        try {
            jSONObjectSendRequestBase64 = JUTrack.sendRequestBase64(jSONObject, MsgConstant.NOTIFY_REQUEST_ENDPOINT, messageAppkey);
        } catch (Exception e2) {
            UPLog.d(a, "request error:", e2.getMessage());
        }
        if (jSONObjectSendRequestBase64 == null || jSONObjectSendRequestBase64.optInt("code") == 13043) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectSendRequestBase64.optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            this.f20550f.b(false);
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject2 != null) {
            int iOptInt = jSONObjectOptJSONObject2.optInt("ipad");
            boolean z2 = jSONObjectOptJSONObject2.optInt("aps") == 1;
            this.f20550f.c(iOptInt);
            this.f20550f.b(z2);
            String strOptString = jSONObjectOptJSONObject.optString(MsgConstant.KEY_TRACE_ID);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(NativeAdvancedJsUtils.f8246p);
            if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) == 0) {
                return;
            }
            if (length > 5) {
                for (int i3 = 5; i3 < length; i3++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i3);
                    if (jSONObjectOptJSONObject3 != null) {
                        jSONObjectOptJSONObject3.put("ok", 0);
                    }
                }
            }
            int iMin = Math.min(5, length);
            int i4 = 0;
            int i5 = 0;
            while (i4 < iMin) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject4 != null) {
                    String strOptString2 = jSONObjectOptJSONObject4.optString("pkg");
                    String strOptString3 = jSONObjectOptJSONObject4.optString("activity");
                    String strOptString4 = jSONObjectOptJSONObject4.optString("appkey");
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObjectOptJSONObject4.put("ok", i2);
                    } else if (TextUtils.equals(strOptString2, packageName)) {
                        jSONObjectOptJSONObject4.put("ok", i2);
                    } else if (TextUtils.isEmpty(strOptString3)) {
                        jSONObjectOptJSONObject4.put("ok", i2);
                    } else if (TextUtils.isEmpty(strOptString4)) {
                        jSONObjectOptJSONObject4.put("ok", i2);
                    } else {
                        boolean zA = a(contextB, str, strOptString, strOptString2, strOptString3);
                        if (!zA) {
                            jSONObjectOptJSONObject4.put("msg", "cur:" + packageName + " start failed:" + strOptString2);
                        }
                        int i6 = i5 | (zA ? 1 : 0);
                        jSONObjectOptJSONObject4.put("ok", zA ? 1 : 0);
                        if (i4 < iMin - 1) {
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException unused) {
                            }
                        }
                        i5 = i6;
                    }
                }
                i4++;
                i2 = 0;
            }
            a(contextB, str, jSONArrayOptJSONArray, strOptString);
            if (i5 != 0) {
                try {
                    UPushMessageNotifyApi.Callback callback = this.f20549e;
                    if (callback != null) {
                        callback.onNotifying();
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        }
        this.f20550f.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent, String str) throws Exception {
        this.f20550f.b(System.currentTimeMillis());
        String stringExtra = intent.getStringExtra("data");
        String stringExtra2 = intent.getStringExtra("pkg");
        intent.removeExtra("data");
        intent.removeExtra("pkg");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            String strB = h.b(stringExtra2, "");
            String strB2 = h.b(stringExtra, "");
            if (!TextUtils.isEmpty(strB2) && !TextUtils.isEmpty(strB)) {
                JSONObject jSONObject = new JSONObject(strB2);
                jSONObject.put("activity", str);
                this.f20550f.a(jSONObject.toString());
                jSONObject.put(MsgConstant.KEY_ACTION_TYPE, 71);
                jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
                jSONObject.put("msg_id", "");
                jSONObject.put("pa", "");
                jSONObject.put("ts", System.currentTimeMillis());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("din", UmengMessageDeviceConfig.getImeiAes(context));
                jSONObject3.put("p_sdk_v", "6.5.1");
                jSONObject3.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(context));
                jSONObject2.put("header", jSONObject3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("push", jSONArray);
                jSONObject2.put("content", jSONObject4);
                UMWorkDispatch.sendEvent(context, MsgConstant.PUSH_LOG, q.a(), jSONObject2.toString());
                try {
                    UPushMessageNotifyApi.Callback callback = this.f20549e;
                    if (callback != null) {
                        callback.onNotified();
                        this.f20551g = false;
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            this.f20550f.b(0L);
            return;
        }
        this.f20550f.b(0L);
    }

    public void a(final boolean z2) {
        if (this.f20550f.a() == z2) {
            return;
        }
        this.f20550f.a(z2);
        c.a(new Runnable() { // from class: com.umeng.message.proguard.z.4
            @Override // java.lang.Runnable
            public void run() {
                z.this.f20550f.c(true);
                boolean zB = false;
                try {
                    if (UmengMessageDeviceConfig.isOnline(r.b())) {
                        zB = z.this.b(z2);
                    }
                } catch (Throwable th) {
                    UPLog.e(z.a, th);
                }
                z.this.f20550f.c(!zB);
            }
        });
    }

    public void a(UPushMessageNotifyApi.Callback callback) {
        this.f20549e = callback;
        if (callback == null || !this.f20551g) {
            return;
        }
        try {
            callback.onNotified();
            this.f20551g = false;
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, String str, JSONArray jSONArray, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("din", UmengMessageDeviceConfig.getImeiAes(context));
        jSONObject2.put("p_sdk_v", "6.5.1");
        jSONObject2.put("push_switch", UmengMessageDeviceConfig.isNotificationEnabled(context));
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("pa", "");
        jSONObject3.put(MsgConstant.KEY_ACTION_TYPE, 70);
        jSONObject3.put(MsgConstant.KEY_DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
        jSONObject3.put("msg_id", "");
        jSONObject3.put("activity", str);
        jSONObject3.put(MsgConstant.KEY_NOTIFY_TARGET, jSONArray);
        jSONObject3.put(MsgConstant.KEY_TRACE_ID, str2);
        jSONObject3.put("ts", System.currentTimeMillis());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray2);
        jSONObject.put("content", jSONObject4);
        UMWorkDispatch.sendEvent(context, MsgConstant.PUSH_LOG, q.a(), jSONObject.toString());
    }

    private boolean a(Context context, String str, String str2, String str3, String str4) {
        try {
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            ComponentName componentName = new ComponentName(str3, str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MsgConstant.KEY_TRACE_ID, str2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", messageAppkey);
            jSONObject2.put("pkg", context.getPackageName());
            jSONObject2.put("activity", str);
            jSONObject2.put("ok", 1);
            jSONArray.put(jSONObject2);
            jSONObject.put(MsgConstant.KEY_NOTIFY_SOURCE, jSONArray);
            String string = jSONObject.toString();
            String strA = h.a(context.getPackageName(), "");
            String strA2 = h.a(string, "");
            Intent intent = new Intent();
            intent.putExtra("data", strA2);
            intent.putExtra("pkg", strA);
            intent.setPackage(str3);
            intent.setComponent(componentName);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (this.f20550f.e()) {
                String strF = this.f20550f.f();
                if (TextUtils.isEmpty(strF)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strF);
                jSONObject.put("activity", jSONObject2.optString("activity"));
                jSONObject.put(MsgConstant.KEY_NOTIFY_SOURCE, jSONObject2.optJSONArray(MsgConstant.KEY_NOTIFY_SOURCE));
                jSONObject.put(MsgConstant.KEY_TRACE_ID, jSONObject2.optString(MsgConstant.KEY_TRACE_ID));
            }
        } catch (Throwable th) {
            UPLog.e(a, "handle msg arrived error:", th);
        }
    }
}
