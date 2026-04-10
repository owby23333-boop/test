package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.IUmengInAppMessageCallback;
import com.umeng.message.inapp.IUmengInAppMsgCloseCallback;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.inapp.UImageLoadTask;
import com.umeng.message.inapp.UmengCardMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UmengCardMessageBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements IUmengInAppMessageCallback, UImageLoadTask.ImageLoaderCallback {
    private static final String a = "com.umeng.message.proguard.v";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f20523f = 10;
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UInAppMessage f20526e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f20527g;

    public v(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.b = activity;
        this.f20524c = str;
        this.f20527g = iUmengInAppMsgCloseCallback;
    }

    private boolean a(String str) {
        if (!UmengMessageDeviceConfig.getAppVersionCode(this.b).equals(InAppMessageManager.getInstance(this.b).g())) {
            InAppMessageManager.getInstance(this.b).d("");
        }
        InAppMessageManager.getInstance(this.b).e(UmengMessageDeviceConfig.getAppVersionCode(this.b));
        String strF = InAppMessageManager.getInstance(this.b).f();
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(strF)) {
            try {
                jSONArray = new JSONArray(strF);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(str);
            InAppMessageManager.getInstance(this.b).d(jSONArray2.toString());
            return true;
        }
        if (a(jSONArray, str)) {
            return true;
        }
        if (jSONArray.length() >= 10) {
            return false;
        }
        jSONArray.put(str);
        InAppMessageManager.getInstance(this.b).d(jSONArray.toString());
        return true;
    }

    private void b() {
        try {
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.a(this.f20527g);
            Bundle bundle = new Bundle();
            bundle.putString("label", this.f20524c);
            bundle.putString("msg", this.f20526e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.b).getFragmentManager(), this.f20524c);
            InAppMessageManager.getInstance(this.b).a(this.f20526e.msg_id, 1);
            InAppMessageManager.getInstance(this.b).f(this.f20524c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.umeng.message.inapp.IUmengInAppMessageCallback
    public void onCardMessage(UInAppMessage uInAppMessage) {
        UInAppMessage uInAppMessage2;
        String strC = InAppMessageManager.getInstance(this.b).c(this.f20524c);
        if (TextUtils.isEmpty(strC)) {
            uInAppMessage2 = null;
        } else {
            try {
                uInAppMessage2 = new UInAppMessage(new JSONObject(strC));
            } catch (JSONException e2) {
                e2.printStackTrace();
                uInAppMessage2 = null;
            }
        }
        if (uInAppMessage != null) {
            if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                InAppMessageManager.getInstance(this.b).a(new File(l.a(this.b, uInAppMessage2.msg_id)));
            }
            this.f20526e = uInAppMessage;
        } else if (uInAppMessage2 == null) {
            return;
        } else {
            this.f20526e = uInAppMessage2;
        }
        if (this.f20526e.show_type == 1 && !b(this.f20524c)) {
            InAppMessageManager.getInstance(this.b).a(this.f20526e.msg_id, 0);
        }
        if (InAppMessageManager.getInstance(this.b).b(this.f20526e) && InAppMessageManager.getInstance(this.b).c(this.f20526e)) {
            UInAppMessage uInAppMessage3 = this.f20526e;
            int i2 = uInAppMessage3.msg_type;
            if (i2 == 5 || i2 == 6) {
                InAppMessageManager.getInstance(this.b).a(this.f20526e, this.f20524c);
                b();
            } else {
                UImageLoadTask uImageLoadTask = new UImageLoadTask(this.b, uInAppMessage3);
                uImageLoadTask.a(this);
                uImageLoadTask.execute(this.f20526e.image_url);
            }
        }
    }

    @Override // com.umeng.message.inapp.UImageLoadTask.ImageLoaderCallback
    public void onLoadImage(Bitmap[] bitmapArr) {
        if (!this.f20525d) {
            a(bitmapArr[0]);
        }
        InAppMessageManager.getInstance(this.b).a(this.f20526e, this.f20524c);
    }

    @Override // com.umeng.message.inapp.IUmengInAppMessageCallback
    public void onSplashMessage(UInAppMessage uInAppMessage) {
    }

    public v(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f20524c = str;
        this.f20525d = true;
    }

    private boolean b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.b).g(str));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private boolean a(JSONArray jSONArray, String str) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                if (jSONArray.getString(i2).equals(str)) {
                    return true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public void a() {
        if (TextUtils.isEmpty(this.f20524c.trim())) {
            if (PushAgent.DEBUG) {
                Toast.makeText(this.b, "插屏消息的标签不能为空", 1).show();
            }
            UMLog.mutlInfo(a, 0, "插屏消息的标签不能为空");
        } else {
            if (a(this.f20524c)) {
                if (InAppMessageManager.a) {
                    x.a(this.b).a(this.f20524c, this);
                    return;
                } else if (System.currentTimeMillis() - InAppMessageManager.getInstance(this.b).b(this.f20524c) > InAppMessageManager.b) {
                    x.a(this.b).a(this.f20524c, this);
                    return;
                } else {
                    onCardMessage(null);
                    return;
                }
            }
            UMLog.mutlInfo(a, 0, "插屏消息的最大标签数为 10");
        }
    }

    private void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.a(this.f20527g);
            Bundle bundle = new Bundle();
            bundle.putString("label", this.f20524c);
            bundle.putString("msg", this.f20526e.getRaw().toString());
            bundle.putByteArray("bitmapByte", byteArray);
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.b).getFragmentManager(), this.f20524c);
            InAppMessageManager.getInstance(this.b).a(this.f20526e.msg_id, 1);
            InAppMessageManager.getInstance(this.b).f(this.f20524c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
