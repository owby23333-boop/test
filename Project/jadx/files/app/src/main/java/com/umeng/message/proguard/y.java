package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushNotifyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class y implements UPushMessageNotifyApi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile y f20546c;
    private final z a = new z();
    private volatile boolean b;

    private y() {
    }

    public static y a() {
        if (f20546c == null) {
            synchronized (y.class) {
                if (f20546c == null) {
                    f20546c = new y();
                }
            }
        }
        return f20546c;
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public boolean isEnabled() {
        return this.a.b();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setCallback(UPushMessageNotifyApi.Callback callback) {
        this.a.a(callback);
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public void setEnable(boolean z2) {
        this.a.a(z2);
    }

    public void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public void a(String str) {
        this.a.a(str);
    }

    public void a(Activity activity, Intent intent) {
        this.a.a(activity, intent);
    }
}
