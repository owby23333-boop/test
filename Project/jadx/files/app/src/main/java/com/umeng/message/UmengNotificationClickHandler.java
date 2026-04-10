package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UmengNotificationClickHandler implements UPushMessageHandler {
    private static final String a = "UmengNotificationClickHandler";

    private void a(Intent intent, UMessage uMessage) {
        Map<String, String> map;
        if (intent == null || uMessage == null || (map = uMessage.extra) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                intent.putExtra(key, value);
            }
        }
    }

    public void dealWithCustomAction(Context context, UMessage uMessage) {
    }

    public void dismissNotification(Context context, UMessage uMessage) {
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        try {
            if (uMessage.dismiss) {
                dismissNotification(context, uMessage);
                return;
            }
            if (!TextUtils.isEmpty(uMessage.after_open)) {
                if (TextUtils.equals("go_url", uMessage.after_open)) {
                    openUrl(context, uMessage);
                    return;
                }
                if (TextUtils.equals("go_activity", uMessage.after_open)) {
                    openActivity(context, uMessage);
                    return;
                } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_CUSTOM, uMessage.after_open)) {
                    dealWithCustomAction(context, uMessage);
                    return;
                } else if (TextUtils.equals("go_app", uMessage.after_open)) {
                    launchApp(context, uMessage);
                    return;
                }
            }
            if (uMessage.url != null && !TextUtils.isEmpty(uMessage.url.trim())) {
                openUrl(context, uMessage);
                return;
            }
            if (uMessage.activity != null && !TextUtils.isEmpty(uMessage.activity.trim())) {
                openActivity(context, uMessage);
            } else if (uMessage.custom == null || TextUtils.isEmpty(uMessage.custom.trim())) {
                launchApp(context, uMessage);
            } else {
                dealWithCustomAction(context, uMessage);
            }
        } catch (Throwable th) {
            UPLog.e(a, "handleMessage error:", th.getMessage());
        }
    }

    public void launchApp(Context context, UMessage uMessage) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                UPLog.e(a, "can't find app launch:" + context.getPackageName());
                return;
            }
            launchIntentForPackage.setPackage(null);
            launchIntentForPackage.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            a(launchIntentForPackage, uMessage);
            context.startActivity(launchIntentForPackage);
            UPLog.d(a, "start app: " + context.getPackageName());
        } catch (Throwable th) {
            UPLog.e(a, "start app error:", th.getMessage());
        }
    }

    public void openActivity(Context context, UMessage uMessage) {
        try {
            if (uMessage.activity != null && !TextUtils.isEmpty(uMessage.activity.trim())) {
                Intent intent = new Intent();
                a(intent, uMessage);
                intent.setClassName(context, uMessage.activity);
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            }
        } catch (Throwable th) {
            UPLog.e(a, "openActivity error:", th.getMessage());
        }
    }

    public void openUrl(Context context, UMessage uMessage) {
        try {
            if (uMessage.url != null && !TextUtils.isEmpty(uMessage.url.trim())) {
                UPLog.i(a, "open url:" + uMessage.url);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uMessage.url));
                a(intent, uMessage);
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            }
        } catch (Throwable th) {
            UPLog.e(a, "openUrl error:", th.getMessage());
        }
    }
}
