package com.bytedance.pangle.download;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IDownloader {
    void downloader(Context context, String str, String str2, boolean z2, String str3, int i2, String str4, List<String> list, IZeusDownloadListener iZeusDownloadListener, IZeusDownloadInterceptor iZeusDownloadInterceptor);
}
