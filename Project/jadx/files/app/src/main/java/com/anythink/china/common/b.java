package com.anythink.china.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BroadcastReceiver {
    private static final String a = b.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) && intent.getData() != null) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            StringBuilder sb = new StringBuilder("onReceive: apk install success( ");
            sb.append(schemeSpecificPart);
            sb.append(ad.f20406s);
            a.a(context).b(schemeSpecificPart);
        }
    }
}
