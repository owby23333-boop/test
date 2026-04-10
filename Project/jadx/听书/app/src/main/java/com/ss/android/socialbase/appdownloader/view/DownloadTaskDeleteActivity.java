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
import com.ss.android.socialbase.appdownloader.dl.a;
import com.ss.android.socialbase.appdownloader.dl.gc;
import com.ss.android.socialbase.appdownloader.dl.i;
import com.ss.android.socialbase.appdownloader.dl.wp;
import com.ss.android.socialbase.appdownloader.fo;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.e.dl;
import com.ss.android.socialbase.downloader.pf.m;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent g;
    private wp z;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

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
    protected void onResume() {
        super.onResume();
        this.g = getIntent();
        g();
        wp wpVar = this.z;
        if (wpVar != null && !wpVar.g()) {
            this.z.z();
        } else if (this.z == null) {
            finish();
        }
    }

    private void g() {
        Intent intent;
        if (this.z != null || (intent = this.g) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final dl dlVarGz = e.g(getApplicationContext()).gz(intExtra);
            if (dlVarGz == null) {
                return;
            }
            String strFo = dlVarGz.fo();
            if (TextUtils.isEmpty(strFo)) {
                com.bytedance.sdk.component.utils.wp.g("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String string = String.format(getString(fo.z(this, "tt_appdownloader_notification_download_delete")), strFo);
            a aVarG = com.ss.android.socialbase.appdownloader.a.kb().g();
            i iVarZ = aVarG != null ? aVarG.z(this) : null;
            if (iVarZ == null) {
                iVarZ = new com.ss.android.socialbase.appdownloader.a.z(this);
            }
            if (iVarZ != null) {
                int iZ = fo.z(this, "tt_appdownloader_tip");
                int iZ2 = fo.z(this, "tt_appdownloader_label_ok");
                int iZ3 = fo.z(this, "tt_appdownloader_label_cancel");
                if (com.ss.android.socialbase.downloader.i.z.z(dlVarGz.e()).z("cancel_with_net_opt", 0) == 1 && m.gz() && dlVarGz.sf() != dlVarGz.s()) {
                    z = true;
                }
                if (z) {
                    iZ2 = fo.z(this, "tt_appdownloader_label_reserve_wifi");
                    iZ3 = fo.z(this, "tt_appdownloader_label_cancel_directly");
                    string = getResources().getString(fo.z(this, "tt_appdownloader_resume_in_wifi"));
                }
                iVarZ.z(iZ).z(string).z(iZ2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.z(dlVarGz, intExtra);
                        } else {
                            dlVarGz.a(true);
                            e.g(DownloadTaskDeleteActivity.this).z(dlVarGz.e());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.g(DownloadTaskDeleteActivity.this).dl(dlVarGz.e());
                                }
                            }, 100L);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).g(iZ3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.z(dlVarGz, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).z(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.z = iVarZ.z();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(dl dlVar, int i) {
        gc gcVarDl = com.ss.android.socialbase.appdownloader.a.kb().dl();
        if (gcVarDl != null) {
            gcVarDl.z(dlVar);
        }
        gk gkVarFo = e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).fo(i);
        if (gkVarFo != null) {
            gkVarFo.z(10, dlVar, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.dl.xl() != null) {
            e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g(i);
        }
    }
}
