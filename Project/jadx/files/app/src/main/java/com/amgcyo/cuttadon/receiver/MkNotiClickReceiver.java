package com.amgcyo.cuttadon.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amgcyo.cuttadon.f.o;
import com.umeng.message.entity.UMessage;

/* JADX INFO: loaded from: classes.dex */
public class MkNotiClickReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int intExtra = intent.getIntExtra("type", -1);
            if (intExtra != -1) {
                ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(intExtra);
            }
            if (action.equals("notification_clicked")) {
                o.b("下载失败，请检查网络设置");
            }
            action.equals("notification_cancelled");
        }
    }
}
