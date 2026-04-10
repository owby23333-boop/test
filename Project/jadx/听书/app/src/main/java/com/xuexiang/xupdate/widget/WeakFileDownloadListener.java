package com.xuexiang.xupdate.widget;

import com.xuexiang.xupdate.service.OnFileDownloadListener;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class WeakFileDownloadListener implements OnFileDownloadListener {
    private WeakReference<IDownloadEventHandler> mDownloadHandlerRef;

    public WeakFileDownloadListener(IDownloadEventHandler iDownloadEventHandler) {
        this.mDownloadHandlerRef = new WeakReference<>(iDownloadEventHandler);
    }

    @Override // com.xuexiang.xupdate.service.OnFileDownloadListener
    public void onStart() {
        if (getEventHandler() != null) {
            getEventHandler().handleStart();
        }
    }

    @Override // com.xuexiang.xupdate.service.OnFileDownloadListener
    public void onProgress(float f, long j) {
        if (getEventHandler() != null) {
            getEventHandler().handleProgress(f);
        }
    }

    @Override // com.xuexiang.xupdate.service.OnFileDownloadListener
    public boolean onCompleted(File file) {
        if (getEventHandler() != null) {
            return getEventHandler().handleCompleted(file);
        }
        return true;
    }

    @Override // com.xuexiang.xupdate.service.OnFileDownloadListener
    public void onError(Throwable th) {
        if (getEventHandler() != null) {
            getEventHandler().handleError(th);
        }
    }

    private IDownloadEventHandler getEventHandler() {
        WeakReference<IDownloadEventHandler> weakReference = this.mDownloadHandlerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
