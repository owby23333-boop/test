package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.y;

/* JADX INFO: loaded from: classes4.dex */
public class d extends i {
    private boolean Tv;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    public static void register() {
        try {
            com.kwad.sdk.service.c.a(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            this.Tv = intent.getBooleanExtra("fromNotification", false);
            if (this.Tv) {
                if (y.cM(getActivity())) {
                    aI(this.Tv);
                    return;
                } else {
                    ra();
                    return;
                }
            }
            if (intent.getBooleanExtra("needAllowDialog", false)) {
                qZ();
            } else {
                ra();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void qZ() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.ksad_request_install_title);
        builder.setMessage(R.string.ksad_request_install_content);
        builder.setNegativeButton(R.string.ksad_request_install_nagative, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.ksad_request_install_positive, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.ra();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
        intent.addFlags(67108864);
        getActivity().startActivityForResult(intent, 100);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            aI(this.Tv);
        }
        finish();
    }

    private void aI(boolean z) {
        Intent intent = getIntent();
        if (z) {
            getActivity().startActivity((Intent) intent.getParcelableExtra("pendingIntent"));
        } else {
            String stringExtra = intent.getStringExtra("filePath");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            as.he(stringExtra);
        }
    }
}
