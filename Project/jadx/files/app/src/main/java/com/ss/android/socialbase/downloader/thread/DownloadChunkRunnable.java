package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadChunkRunnable implements Runnable {
    private static final String TAG = DownloadChunkRunnable.class.getSimpleName();
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private DownloadChunk curDownloadChunk;
    private IDownloadCache downloadCache;
    private DownloadChunk downloadChunk;
    private DownloadInfo downloadInfo;
    private DownloadResponseHandler downloadResponseHandler;
    private final DownloadTask downloadTask;
    private IDownloadHttpConnection httpConnection;
    private boolean isHttpConnectionInject;
    private volatile boolean paused;

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.isHttpConnectionInject = false;
        this.downloadChunk = downloadChunk;
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
        }
        this.callback = iDownloadRunnableCallback;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.downloadChunk.setChunkRunnable(this);
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.httpConnection = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:223:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105 A[Catch: all -> 0x01bc, BaseException -> 0x01d8, TRY_ENTER, TryCatch #9 {BaseException -> 0x01d8, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00fb, B:66:0x0105, B:68:0x0109, B:79:0x0139, B:51:0x00df), top: B:208:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk r31) {
        /*
            Method dump skipped, instruction units count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk):boolean");
    }

    private String getUrl() {
        return this.downloadInfo.getConnectionUrl();
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void revertDownloadChunk(DownloadChunk downloadChunk, long j2) {
        DownloadChunk firstReuseChunk = downloadChunk.isHostChunk() ? downloadChunk.getFirstReuseChunk() : downloadChunk;
        if (firstReuseChunk == null) {
            if (downloadChunk.isHostChunk()) {
                this.downloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getChunkIndex(), j2);
            }
        } else {
            if (firstReuseChunk.canRefreshCurOffsetForReuseChunk()) {
                this.downloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), j2);
            }
            firstReuseChunk.setCurrentOffset(j2);
            this.downloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), j2);
        }
    }

    public void cancel() {
        this.canceled = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.cancel();
        }
    }

    public int getChunkIndex() {
        return this.downloadChunk.getChunkIndex();
    }

    public void pause() {
        this.paused = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.pause();
        }
    }

    public void refreshResponseHandleOffset(long j2, long j3) {
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler == null) {
            return;
        }
        downloadResponseHandler.setEndOffset(j2, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.curDownloadChunk.setDownloading(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r3.downloadChunk
            r3.curDownloadChunk = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            r1.setChunkRunnable(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.downloadChunkInner(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            r1.setDownloading(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            r1.setDownloading(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.isStoppedStatus()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r1 = r3.callback     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.DownloadChunk r2 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.getChunkIndex()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r1.getUnCompletedSubChunk(r2)     // Catch: java.lang.Throwable -> L5d
            r3.curDownloadChunk = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.isStoppedStatus()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L42
            goto L4d
        L42:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r3.curDownloadChunk
            if (r1 == 0) goto L54
            r1.setDownloading(r0)
        L54:
            r3.closeConnection()
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r3.callback
            r0.onCompleted(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.DownloadChunk r2 = r3.curDownloadChunk
            if (r2 == 0) goto L65
            r2.setDownloading(r0)
        L65:
            r3.closeConnection()
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r3.callback
            r0.onCompleted(r3)
            goto L6f
        L6e:
            throw r1
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.run():void");
    }

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadHttpConnection iDownloadHttpConnection, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this(downloadChunk, downloadTask, iDownloadRunnableCallback);
        this.httpConnection = iDownloadHttpConnection;
    }
}
