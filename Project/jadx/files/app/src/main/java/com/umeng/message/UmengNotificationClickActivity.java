package com.umeng.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class UmengNotificationClickActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = 1;
            attributes.height = 1;
            attributes.gravity = 8388659;
            window.setAttributes(attributes);
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("MSG");
            if (stringExtra != null && stringExtra.length() != 0) {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                UTrack.getInstance().trackMsgClick(uMessage);
                Context applicationContext = getApplicationContext();
                UPushMessageHandler notificationClickHandler = PushAgent.getInstance(applicationContext).getNotificationClickHandler();
                if (notificationClickHandler != null) {
                    notificationClickHandler.handleMessage(applicationContext, uMessage);
                } else {
                    UPLog.i("NotificationClick", "handle == null skipped!");
                }
                MessageNotificationQueue.getInstance().remove(new UNotificationItem(intent.getIntExtra(UmengNotificationReceiver.EXTRA_KEY_NOTIFICATION_ID, -1), uMessage));
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
