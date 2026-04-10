package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aj;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.sdk.TbsReaderView;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.kwad.components.core.l.a {
    private boolean Ly;

    private void az(boolean z2) {
        Intent intent = getIntent();
        if (z2) {
            getActivity().startActivity((Intent) intent.getParcelableExtra("pendingIntent"));
        } else {
            String stringExtra = intent.getStringExtra(TbsReaderView.KEY_FILE_PATH);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            aj.ak(getActivity().getApplicationContext(), stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oA() {
        if (Build.VERSION.SDK_INT < 26) {
            finish();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
        intent.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        getActivity().startActivityForResult(intent, 100);
    }

    private void oz() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.ksad_request_install_title);
        builder.setMessage(R.string.ksad_request_install_content);
        builder.setNegativeButton(R.string.ksad_request_install_nagative, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.ksad_request_install_positive, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                d.this.oA();
            }
        });
        builder.create().show();
    }

    public static void register() {
        try {
            com.kwad.sdk.service.a.a(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.l.a
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 100 && i3 == -1) {
            az(this.Ly);
        }
        finish();
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.Ly = intent.getBooleanExtra("fromNotification", false);
        if (Build.VERSION.SDK_INT < 26) {
            az(this.Ly);
            finish();
        } else {
            if (this.Ly) {
                if (ai.cw(getActivity())) {
                    az(this.Ly);
                    return;
                } else {
                    oA();
                    return;
                }
            }
            if (intent.getBooleanExtra("needAllowDialog", false)) {
                oz();
            } else {
                oA();
            }
        }
    }
}
