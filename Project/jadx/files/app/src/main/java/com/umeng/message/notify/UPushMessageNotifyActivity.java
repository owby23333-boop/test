package com.umeng.message.notify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.proguard.y;

/* JADX INFO: loaded from: classes3.dex */
public final class UPushMessageNotifyActivity extends Activity {
    private void a(Intent intent) {
        try {
            y yVarA = y.a();
            yVarA.c();
            yVarA.a(this, intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
