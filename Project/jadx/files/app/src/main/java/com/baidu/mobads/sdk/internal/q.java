package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q implements ICommonModuleObj {
    private static volatile q a;
    private CustomNotification b = new CustomNotification();

    private q() {
    }

    public static q a() {
        if (a == null) {
            synchronized (q.class) {
                if (a == null) {
                    a = new q();
                }
            }
        }
        return a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        return this.b.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString(URLPackage.KEY_CHANNEL_ID), jSONObject.optString("ticker"), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean("autoCancel"), jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS), jSONObject.optInt("smallIcon"), jSONObject.optString(NativeAdvancedJsUtils.f8246p), (PendingIntent) jSONObject.opt("pendingIntent"));
    }
}
