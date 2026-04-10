package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] z = {"android.permission.POST_NOTIFICATIONS"};
    private DownloadHandlerService g = new DownloadHandlerService();

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
            requestPermissions(z, 1000);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.z.g("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            com.ss.android.socialbase.downloader.m.z.g("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
