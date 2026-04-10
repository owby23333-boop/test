package com.xiaomi.onetrack.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
class f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f7708a;

    public f(d dVar) {
        this.f7708a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("host");
            String stringExtra2 = intent.getStringExtra("packagename");
            String stringExtra3 = intent.getStringExtra("projectId");
            String stringExtra4 = intent.getStringExtra("user");
            boolean booleanExtra = intent.getBooleanExtra("logon", false);
            boolean booleanExtra2 = intent.getBooleanExtra("quickuploadon", false);
            String strE = com.xiaomi.onetrack.f.a.e();
            if (!TextUtils.isEmpty(stringExtra2) && !"".equals(stringExtra2) && strE.equals(stringExtra2)) {
                p.f7764a = booleanExtra;
                p.f7765b = booleanExtra2;
                if (booleanExtra2 && this.f7708a.a(stringExtra)) {
                    this.f7708a.a(stringExtra, stringExtra3, stringExtra4);
                }
            }
        } catch (Exception e) {
            p.b(d.f7705a, e.getMessage());
        }
    }
}
