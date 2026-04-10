package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
class b implements com.tencent.smtt.export.external.interfaces.DownloadListener {
    private DownloadListener a;
    private WebView b;

    public b(WebView webView, DownloadListener downloadListener, boolean z2) {
        this.a = downloadListener;
        this.b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        onDownloadStart(str, null, null, str2, str3, str4, j2, null, null);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j2, String str6, String str7) {
        DownloadListener downloadListener = this.a;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str3, str4, str5, j2);
            return;
        }
        if (QbSdk.canOpenMimeFileType(this.b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.b.getContext().startActivity(intent);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j2, int i2) {
    }
}
