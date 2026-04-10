package com.taobao.agoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class AgooCommondReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String strA = com.taobao.accs.client.a.a(context.getPackageName());
            intent.setFlags(0);
            intent.setClassName(context, strA);
            com.taobao.accs.a.a.a(context, intent);
        } catch (Throwable unused) {
        }
    }
}
