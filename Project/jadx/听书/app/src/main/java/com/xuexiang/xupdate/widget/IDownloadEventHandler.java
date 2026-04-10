package com.xuexiang.xupdate.widget;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadEventHandler {
    boolean handleCompleted(File file);

    void handleError(Throwable th);

    void handleProgress(float f);

    void handleStart();
}
