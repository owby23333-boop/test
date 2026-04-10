package com.ss.android.downloadad.api;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface ox {
    Dialog mb(Context context, String str, boolean z2, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2);

    Dialog mb(Context context, String str, boolean z2, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, IDownloadButtonClickListener iDownloadButtonClickListener);

    boolean mb(long j2);

    boolean mb(long j2, int i2);

    boolean mb(Context context, long j2, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2);

    boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);

    boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener);
}
