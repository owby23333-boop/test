package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes8.dex */
public final class NotificationClickedActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f7407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f73a;

    private void a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    com.xiaomi.channel.commonutils.logger.b.m107a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.c("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = BadgeDrawable.TOP_START;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f73a = handler;
        handler.postDelayed(new y(this), 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        z zVar = new z(this);
        this.f7407a = zVar;
        try {
            com.xiaomi.push.l.a(this, zVar, intentFilter, c.a(this), null, 4);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f73a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.f7407a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a(getIntent());
    }
}
