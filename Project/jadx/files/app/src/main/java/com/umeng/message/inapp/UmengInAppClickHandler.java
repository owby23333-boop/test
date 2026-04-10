package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;

/* JADX INFO: loaded from: classes3.dex */
public class UmengInAppClickHandler implements UInAppHandler {
    private static final String a = "com.umeng.message.inapp.UmengInAppClickHandler";
    private String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20313c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20314d = null;

    @Override // com.umeng.message.inapp.UInAppHandler
    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i2) {
        switch (i2) {
            case 16:
                this.b = uInAppMessage.action_type;
                this.f20313c = uInAppMessage.action_activity;
                this.f20314d = uInAppMessage.action_url;
                break;
            case 17:
                this.b = uInAppMessage.bottom_action_type;
                this.f20313c = uInAppMessage.bottom_action_activity;
                this.f20314d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.b = uInAppMessage.plainTextActionType;
                this.f20313c = uInAppMessage.plainTextActivity;
                this.f20314d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.b = uInAppMessage.customButtonActionType;
                this.f20313c = uInAppMessage.customButtonActivity;
                this.f20314d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.b)) {
            openActivity(activity, this.f20313c);
        } else if (TextUtils.equals("go_url", this.b)) {
            openUrl(activity, this.f20314d);
        } else {
            TextUtils.equals("go_app", this.b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(a, 2, "打开Activity: " + str);
                Intent intent = new Intent();
                intent.setClassName(activity, str);
                intent.setFlags(536870912);
                activity.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void openUrl(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(a, 2, "打开链接: " + str);
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
