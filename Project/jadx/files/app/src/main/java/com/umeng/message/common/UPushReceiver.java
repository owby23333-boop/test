package com.umeng.message.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.proguard.f;

/* JADX INFO: loaded from: classes3.dex */
public class UPushReceiver extends BroadcastReceiver {
    private static volatile boolean a = true;

    public static void a(boolean z2) {
        a = z2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (a) {
            f.a(intent);
        }
    }

    public static boolean a() {
        return a;
    }
}
