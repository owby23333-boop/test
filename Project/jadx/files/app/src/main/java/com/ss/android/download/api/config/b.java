package com.ss.android.download.api.config;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void mb(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void mb(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2);
}
