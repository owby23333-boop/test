package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public class TTTransparentActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z();
    }

    private void z() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
