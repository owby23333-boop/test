package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.utils.u;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends e {
    private com.kwad.sdk.core.download.kwai.a Dq;

    /* JADX INFO: Access modifiers changed from: private */
    public static String aa(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return context.getResources().getString(packageInfo.applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Dq = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.n.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = n.this.getContext();
                if (context != null) {
                    String strAa = n.aa(context);
                    if (strAa != null) {
                        str = strAa + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    u.F(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
            }
        };
        this.Cx.mApkDownloadHelper.b(this.Dq);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.kwai.a aVar = this.Dq;
        if (aVar != null) {
            this.Cx.mApkDownloadHelper.c(aVar);
        }
    }
}
