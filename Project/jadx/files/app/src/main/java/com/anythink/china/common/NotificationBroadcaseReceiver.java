package com.anythink.china.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationBroadcaseReceiver extends BroadcastReceiver {
    private static final String a = NotificationBroadcaseReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        intent.getStringExtra(com.anythink.china.common.b.a.f6445d);
        String stringExtra = intent.getStringExtra(com.anythink.china.common.b.a.f6446e);
        String stringExtra2 = intent.getStringExtra(com.anythink.china.common.b.a.f6447f);
        byte b = -1;
        int intExtra = intent.getIntExtra(com.anythink.china.common.b.a.f6448g, -1);
        int iHashCode = action.hashCode();
        if (iHashCode != -1222061724) {
            if (iHashCode == 760792937 && action.equals(com.anythink.china.common.b.a.f6444c)) {
                b = 1;
            }
        } else if (action.equals(com.anythink.china.common.b.a.b)) {
            b = 0;
        }
        if (b == 0) {
            a.a(context).a(stringExtra, stringExtra2, intExtra);
        } else {
            if (b != 1) {
                return;
            }
            a.a(context).a(stringExtra, stringExtra2);
        }
    }
}
