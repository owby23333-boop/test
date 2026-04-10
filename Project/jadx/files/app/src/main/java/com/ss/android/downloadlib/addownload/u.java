package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface u {
    long hj();

    u mb(long j2);

    u mb(IDownloadButtonClickListener iDownloadButtonClickListener);

    u mb(OnItemClickListener onItemClickListener);

    void mb();

    void mb(boolean z2);

    boolean mb(int i2);

    u ox(int i2, DownloadStatusChangeListener downloadStatusChangeListener);

    u ox(Context context);

    u ox(DownloadController downloadController);

    u ox(DownloadEventConfig downloadEventConfig);

    u ox(DownloadModel downloadModel);

    void ox(int i2);

    boolean ox();

    void ww();
}
