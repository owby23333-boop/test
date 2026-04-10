package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import com.umeng.message.proguard.c;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class UmengNotificationReceiver extends BroadcastReceiver {
    public static final int EXTRA_ACTION_DISMISS = 11;
    public static final String EXTRA_KEY_ACTION = "ACTION";
    public static final String EXTRA_KEY_MSG = "MSG";
    public static final String EXTRA_KEY_NOTIFICATION_ID = "NOTIFICATION_ID";
    private static final String a = "NotificationProxy";

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        c.b(new Runnable() { // from class: com.umeng.message.UmengNotificationReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (intent == null) {
                        return;
                    }
                    String stringExtra = intent.getStringExtra("MSG");
                    int intExtra = intent.getIntExtra(UmengNotificationReceiver.EXTRA_KEY_ACTION, -1);
                    UPLog.i(UmengNotificationReceiver.a, String.format(Locale.getDefault(), "onReceive[msg=%s, action=%d]", stringExtra, Integer.valueOf(intExtra)));
                    UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                    int intExtra2 = intent.getIntExtra(UmengNotificationReceiver.EXTRA_KEY_NOTIFICATION_ID, -1);
                    if (intExtra == 11) {
                        UPLog.i(UmengNotificationReceiver.a, "notification ignored");
                        if (!TextUtils.isEmpty(uMessage.msg_id)) {
                            UTrack.getInstance().trackMsgDismissed(uMessage);
                        }
                        uMessage.dismiss = true;
                        UPushMessageHandler notificationClickHandler = PushAgent.getInstance(context).getNotificationClickHandler();
                        if (notificationClickHandler != null) {
                            notificationClickHandler.handleMessage(context, uMessage);
                        }
                    }
                    MessageNotificationQueue.getInstance().remove(new UNotificationItem(intExtra2, uMessage));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
