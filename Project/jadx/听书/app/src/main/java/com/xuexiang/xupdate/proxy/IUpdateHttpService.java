package com.xuexiang.xupdate.proxy;

import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdateHttpService {

    public interface Callback {
        void onError(Throwable th);

        void onSuccess(String str);
    }

    public interface DownloadCallback {
        void onError(Throwable th);

        void onProgress(float f, long j);

        void onStart();

        void onSuccess(File file);
    }

    void asyncGet(String str, Map<String, Object> map, Callback callback);

    void asyncPost(String str, Map<String, Object> map, Callback callback);

    void cancelDownload(String str);

    void download(String str, String str2, String str3, DownloadCallback downloadCallback);
}
