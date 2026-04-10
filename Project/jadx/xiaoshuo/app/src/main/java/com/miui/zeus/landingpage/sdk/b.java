package com.miui.zeus.landingpage.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f7190b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BroadcastReceiver f7191a = new a(this);

    public class a extends BroadcastReceiver {
        public a(b bVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data;
            if (intent == null || !TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction()) || (data = intent.getData()) == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            k.a().d.remove(schemeSpecificPart);
        }
    }
}
