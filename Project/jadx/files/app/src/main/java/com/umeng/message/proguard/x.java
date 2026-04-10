package com.umeng.message.proguard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.impl.JUTrack;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.IUmengInAppMessageCallback;
import com.umeng.message.inapp.InAppMessageManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UmengInAppMessageTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class x {
    private static final String a = "com.umeng.message.proguard.x";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f20535c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static x f20536d;
    private Context b;

    private x(Context context) {
        this.b = context.getApplicationContext();
    }

    private void c() {
        if (f20535c) {
            UMLog.mutlInfo(a, 2, "sendInAppCacheLog已经在队列里，忽略该请求");
            return;
        }
        f20535c = true;
        UMLog.mutlInfo(a, 2, "sendInAppCacheLog开始");
        c.b(new Runnable() { // from class: com.umeng.message.proguard.x.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        for (u uVar : InAppMessageManager.getInstance(x.this.b).j()) {
                            JSONObject jSONObjectB = x.this.b(uVar.b, uVar.f20515c, uVar.f20516d, uVar.f20517e, uVar.f20518f, uVar.f20519g, uVar.f20520h, uVar.f20521i, uVar.f20522j);
                            if (jSONObjectB != null && TextUtils.equals(jSONObjectB.getString("success"), "ok")) {
                                InAppMessageManager.getInstance(x.this.b).h(uVar.b);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    boolean unused = x.f20535c = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        if (InAppMessageManager.a) {
            jSONObject.put(MsgConstant.KEY_INAPP_PMODE, "0");
        } else {
            jSONObject.put(MsgConstant.KEY_INAPP_PMODE, "1");
        }
        return jSONObject;
    }

    public static x a(Context context) {
        if (f20536d == null) {
            synchronized (x.class) {
                if (f20536d == null) {
                    f20536d = new x(context.getApplicationContext());
                }
            }
        }
        return f20536d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("msg_id", str);
        jSONObject.put(MsgConstant.INAPP_MSG_TYPE, i2);
        jSONObject.put(MsgConstant.INAPP_NUM_DISPLAY, i3);
        jSONObject.put(MsgConstant.INAPP_NUM_OPEN_FULL, i4);
        jSONObject.put(MsgConstant.INAPP_NUM_OPEN_TOP, i5);
        jSONObject.put(MsgConstant.INAPP_NUM_OPEN_BUTTOM, i6);
        jSONObject.put(MsgConstant.INAPP_NUM_CLOSE, i7);
        jSONObject.put(MsgConstant.INAPP_NUM_DURATION, i8);
        jSONObject.put(MsgConstant.INAPP_NUM_CUSTOM, i9);
        return JUTrack.sendRequest(jSONObject, MsgConstant.STATS_ENDPOINT);
    }

    public void a(final IUmengInAppMessageCallback iUmengInAppMessageCallback) {
        c();
        c.b(new Runnable() { // from class: com.umeng.message.proguard.x.1
            @Override // java.lang.Runnable
            public void run() {
                UInAppMessage uInAppMessage;
                UMLog.mutlInfo(x.a, 2, "get splash message begin");
                try {
                    JSONObject jSONObjectSendRequest = JUTrack.sendRequest(x.this.b(), MsgConstant.SPLASH_MSG_ENDPOINT);
                    if (jSONObjectSendRequest != null && TextUtils.equals(jSONObjectSendRequest.getString("success"), "ok")) {
                        UMLog.mutlInfo(x.a, 2, "get splash message success" + jSONObjectSendRequest);
                        JSONObject jSONObject = jSONObjectSendRequest.getJSONObject("data");
                        InAppMessageManager.b = jSONObject.getInt("pduration") * 1000;
                        InAppMessageManager.f20280c = jSONObject.getInt("sduration") * 1000;
                        iUmengInAppMessageCallback.onSplashMessage(new UInAppMessage(jSONObject.getJSONObject("launch")));
                        InAppMessageManager.getInstance(x.this.b).c();
                        return;
                    }
                    if (jSONObjectSendRequest == null || !TextUtils.equals(jSONObjectSendRequest.getString("success"), "fail") || !TextUtils.equals(jSONObjectSendRequest.getString("error"), "no message")) {
                        iUmengInAppMessageCallback.onSplashMessage(null);
                        return;
                    }
                    String strE = InAppMessageManager.getInstance(x.this.b).e();
                    if (TextUtils.isEmpty(strE)) {
                        return;
                    }
                    try {
                        uInAppMessage = new UInAppMessage(new JSONObject(strE));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        uInAppMessage = null;
                    }
                    if (uInAppMessage != null) {
                        InAppMessageManager.getInstance(x.this.b).a(new File(l.a(x.this.b, uInAppMessage.msg_id)));
                        InAppMessageManager.getInstance(x.this.b).a((UInAppMessage) null);
                    }
                } catch (Exception e3) {
                    iUmengInAppMessageCallback.onSplashMessage(null);
                    e3.printStackTrace();
                }
            }
        });
    }

    void a(final String str, final IUmengInAppMessageCallback iUmengInAppMessageCallback) {
        c();
        c.b(new Runnable() { // from class: com.umeng.message.proguard.x.2
            @Override // java.lang.Runnable
            public void run() {
                UInAppMessage uInAppMessage;
                UMLog.mutlInfo(x.a, 2, "get card message begin");
                try {
                    JSONObject jSONObjectB = x.this.b();
                    jSONObjectB.put("label", str);
                    JSONObject jSONObjectSendRequest = JUTrack.sendRequest(jSONObjectB, MsgConstant.CARD_MSG_ENDPOINT);
                    if (jSONObjectSendRequest != null && TextUtils.equals(jSONObjectSendRequest.getString("success"), "ok")) {
                        UMLog.mutlInfo(x.a, 2, "get card message success" + jSONObjectSendRequest);
                        JSONObject jSONObject = jSONObjectSendRequest.getJSONObject("data");
                        InAppMessageManager.b = jSONObject.getInt("pduration") * 1000;
                        InAppMessageManager.f20280c = jSONObject.getInt("sduration") * 1000;
                        iUmengInAppMessageCallback.onCardMessage(new UInAppMessage(jSONObject.getJSONObject("card")));
                        InAppMessageManager.getInstance(x.this.b).a(jSONObjectB.optString("label", ""));
                        return;
                    }
                    if (jSONObjectSendRequest == null || !TextUtils.equals(jSONObjectSendRequest.getString("success"), "fail") || !TextUtils.equals(jSONObjectSendRequest.getString("error"), "no message")) {
                        iUmengInAppMessageCallback.onCardMessage(null);
                        return;
                    }
                    String strC = InAppMessageManager.getInstance(x.this.b).c(str);
                    if (TextUtils.isEmpty(strC)) {
                        return;
                    }
                    try {
                        uInAppMessage = new UInAppMessage(new JSONObject(strC));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        uInAppMessage = null;
                    }
                    if (uInAppMessage != null) {
                        InAppMessageManager.getInstance(x.this.b).a(new File(l.a(x.this.b, uInAppMessage.msg_id)));
                        InAppMessageManager.getInstance(x.this.b).a((UInAppMessage) null, str);
                    }
                } catch (Exception e3) {
                    iUmengInAppMessageCallback.onCardMessage(null);
                    e3.printStackTrace();
                }
            }
        });
    }

    public void a(final String str, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9) {
        c.b(new Runnable() { // from class: com.umeng.message.proguard.x.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMLog.mutlInfo(x.a, 2, "track in app msg begin");
                    JSONObject jSONObjectB = x.this.b(str, i2, i3, i4, i5, i6, i7, i8, i9);
                    if (jSONObjectB == null || !TextUtils.equals(jSONObjectB.getString("success"), "ok")) {
                        return;
                    }
                    UMLog.mutlInfo(x.a, 2, "track in app msg success");
                } catch (Exception e2) {
                    InAppMessageManager.getInstance(x.this.b).a(str, i2, i3, i4, i5, i6, i7, i8, i9);
                    e2.printStackTrace();
                }
            }
        });
    }
}
