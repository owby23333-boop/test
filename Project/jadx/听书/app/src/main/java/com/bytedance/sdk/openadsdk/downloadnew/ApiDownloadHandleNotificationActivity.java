package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.bytedance.sdk.openadsdk.api.m;

/* JADX INFO: loaded from: classes2.dex */
public class ApiDownloadHandleNotificationActivity extends Activity {
    private static final String[] z = {"android.permission.POST_NOTIFICATIONS"};
    private ApiDownloadHandlerService g = new ApiDownloadHandlerService();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            z();
        } else {
            this.g.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    private void z() {
        try {
            ActivityCompat.requestPermissions(this, z, 1000);
        } catch (Throwable th) {
            m.g("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            m.g("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
