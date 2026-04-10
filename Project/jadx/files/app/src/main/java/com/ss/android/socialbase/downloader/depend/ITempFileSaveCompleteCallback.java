package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes3.dex */
public interface ITempFileSaveCompleteCallback {
    void onFailed(BaseException baseException);

    void onSuccess();
}
