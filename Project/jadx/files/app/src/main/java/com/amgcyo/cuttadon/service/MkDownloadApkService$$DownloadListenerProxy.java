package com.amgcyo.cuttadon.service;

import com.arialyy.aria.core.scheduler.AptNormalTaskListener;
import com.arialyy.aria.core.task.DownloadTask;

/* JADX INFO: loaded from: classes.dex */
public final class MkDownloadApkService$$DownloadListenerProxy extends AptNormalTaskListener<DownloadTask> {
    private MkDownloadApkService obj;

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
        this.obj = (MkDownloadApkService) obj;
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onNoSupportBreakPoint(DownloadTask downloadTask) {
        this.obj.a(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskCancel(DownloadTask downloadTask) {
        this.obj.b(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskComplete(DownloadTask downloadTask) {
        this.obj.c(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskFail(DownloadTask downloadTask, Exception exc) {
        this.obj.a(downloadTask, exc);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskRunning(DownloadTask downloadTask) {
        this.obj.d(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskStart(DownloadTask downloadTask) {
        this.obj.e(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskStop(DownloadTask downloadTask) {
        this.obj.f(downloadTask);
    }
}
