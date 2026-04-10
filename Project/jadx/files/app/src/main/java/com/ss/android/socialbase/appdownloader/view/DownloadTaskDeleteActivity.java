package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.b.b;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;
import com.ss.android.socialbase.appdownloader.hj;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private jb mb;
    private Intent ox;

    private void ox() {
        Intent intent;
        if (this.mb != null || (intent = this.ox) == null) {
            return;
        }
        try {
            final boolean z2 = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                return;
            }
            String string = String.format(getString(lz.mb(this, "tt_appdownloader_notification_download_delete")), title);
            b bVarMb = hj.x().mb();
            je jeVarMb = bVarMb != null ? bVarMb.mb(this) : null;
            if (jeVarMb == null) {
                jeVarMb = new com.ss.android.socialbase.appdownloader.hj.mb(this);
            }
            if (jeVarMb != null) {
                int iMb = lz.mb(this, "tt_appdownloader_tip");
                int iMb2 = lz.mb(this, "tt_appdownloader_label_ok");
                int iMb3 = lz.mb(this, "tt_appdownloader_label_cancel");
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.CANCEL_WITH_NET_OPT, 0) == 1 && DownloadUtils.isNoWifiAndInNet() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                    z2 = true;
                }
                if (z2) {
                    iMb2 = lz.mb(this, "tt_appdownloader_label_reserve_wifi");
                    iMb3 = lz.mb(this, "tt_appdownloader_label_cancel_directly");
                    string = getResources().getString(lz.mb(this, "tt_appdownloader_resume_in_wifi"));
                }
                jeVarMb.mb(iMb).mb(string).mb(iMb2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (z2) {
                            downloadInfo.setOnlyWifi(true);
                            Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                                }
                            }, 100L);
                        } else {
                            DownloadTaskDeleteActivity.this.mb(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).ox(iMb3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        if (z2) {
                            DownloadTaskDeleteActivity.this.mb(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).mb(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.mb = jeVarMb.mb();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mb();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.ox = getIntent();
        ox();
        jb jbVar = this.mb;
        if (jbVar != null && !jbVar.ox()) {
            this.mb.mb();
        } else if (this.mb == null) {
            finish();
        }
    }

    private void mb() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(DownloadInfo downloadInfo, int i2) {
        com.ss.android.socialbase.appdownloader.b.hj hjVarOx = hj.x().ox();
        if (hjVarOx != null) {
            hjVarOx.mb(downloadInfo);
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadNotificationEventListener(i2);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(10, downloadInfo, "", "");
        }
        if (DownloadComponentManager.getAppContext() != null) {
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(i2);
        }
    }
}
