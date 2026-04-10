package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.reader.AsyncStreamReader;
import com.ss.android.socialbase.downloader.reader.IStreamReader;
import com.ss.android.socialbase.downloader.reader.SyncStreamReader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadResponseHandler {
    private static final boolean DEBUG = false;
    public static final int MIN_SYNC_STEP_BYTE = 65536;
    public static final long MIN_SYNC_TIME_MS = 500;
    private static String TAG = "ResponseHandler";
    private final AppStatusManager appStatusManager;
    private final boolean bugfixCancelThenUpdate;
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private long curOffset;
    private long debugReadTimeNs;
    private long debugSyncTimeNs;
    private long debugTotalTimeNs;
    private long debugWriteTimeNs;
    private DownloadCache downloadCache;
    private final DownloadChunk downloadChunk;
    private volatile long downloadChunkContentLen;
    private final DownloadInfo downloadInfo;
    private volatile long endOffset;
    private BaseException exception;
    private long handleStartOffset;
    private final boolean hasSyncStrategy;
    private final IDownloadHttpConnection httpConnection;
    private final boolean isMonitorRw;
    private RandomAccessOutputStream outputStream;
    private volatile boolean paused;
    private boolean rwConcurrent;
    private final DownloadSetting setting;
    private ISqlDownloadCache sqlDownloadCache;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private final String url;
    boolean openLimitSpeed = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;
    private IDownloadCache customCache = DownloadComponentManager.getDownloadCache();

    public DownloadResponseHandler(DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, DownloadChunk downloadChunk, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.url = str;
        IDownloadCache iDownloadCache = this.customCache;
        if (iDownloadCache instanceof DefaultDownloadCache) {
            DefaultDownloadCache defaultDownloadCache = (DefaultDownloadCache) iDownloadCache;
            this.downloadCache = defaultDownloadCache.getDownloadCache();
            this.sqlDownloadCache = defaultDownloadCache.getSqlDownloadCache();
        }
        this.httpConnection = iDownloadHttpConnection;
        this.downloadChunk = downloadChunk;
        this.callback = iDownloadRunnableCallback;
        this.curOffset = downloadChunk.getCurrentOffset();
        this.handleStartOffset = this.curOffset;
        if (downloadChunk.isHostChunk()) {
            this.downloadChunkContentLen = downloadChunk.getContentLength();
        } else {
            this.downloadChunkContentLen = downloadChunk.getRetainLength(false);
        }
        this.endOffset = downloadChunk.getEndOffset();
        this.appStatusManager = AppStatusManager.getInstance();
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.hasSyncStrategy = this.setting.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        if (this.hasSyncStrategy) {
            long jOptInt = this.setting.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_FG, 5000);
            long jOptInt2 = this.setting.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000);
            this.syncIntervalMsFg = Math.max(jOptInt, 500L);
            this.syncIntervalMsBg = Math.max(jOptInt2, 500L);
        } else {
            this.syncIntervalMsFg = 0L;
            this.syncIntervalMsBg = 0L;
        }
        this.isMonitorRw = this.setting.optInt(DownloadSettingKeys.MONITOR_RW) == 1;
        this.bugfixCancelThenUpdate = DownloadExpSwitchCode.isSwitchEnable(65536);
    }

    private boolean canReuseConnection() {
        return this.downloadInfo.isNeedReuseFirstConnection() && this.downloadChunk.isReuseingFirstConnection();
    }

    private void cancelConnection() {
        ExecutorService cPUThreadExecutor;
        if (this.httpConnection == null || (cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor()) == null) {
            return;
        }
        cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DownloadResponseHandler.this.httpConnection.end();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void checkAndSync(boolean z2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = jUptimeMillis - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j2 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                sync();
                this.lastSyncTimestamp = jUptimeMillis;
                return;
            }
            return;
        }
        long j3 = this.curOffset - this.lastSyncBytes;
        if (z2 || isNeedSync(j3, j2)) {
            sync();
            this.lastSyncTimestamp = jUptimeMillis;
        }
    }

    private IStreamReader createStreamReader(InputStream inputStream) {
        int writeBufferSize = DownloadComponentManager.getWriteBufferSize();
        if (this.setting.optInt("rw_concurrent", 0) == 1 && this.downloadInfo.getChunkCount() == 1 && this.downloadInfo.getTotalBytes() > 20971520) {
            try {
                AsyncStreamReader asyncStreamReader = new AsyncStreamReader(inputStream, writeBufferSize, this.setting.optInt(DownloadSettingKeys.RW_CONCURRENT_MAX_BUFFER_COUNT, 4));
                this.rwConcurrent = true;
                return asyncStreamReader;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SyncStreamReader syncStreamReader = new SyncStreamReader(inputStream, writeBufferSize);
        this.rwConcurrent = false;
        return syncStreamReader;
    }

    private boolean isNeedSync(long j2, long j3) {
        return j2 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j3 > 500;
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void sync() {
        boolean z2;
        long jNanoTime = this.isMonitorRw ? System.nanoTime() : 0L;
        try {
            this.outputStream.flushAndSync();
            z2 = true;
        } catch (Exception unused) {
            z2 = false;
        }
        if (z2) {
            this.downloadInfo.updateRealDownloadTime(true);
            boolean z3 = this.downloadInfo.getChunkCount() > 1;
            IDownloadProxy iDownloadProxy = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess());
            if (z3) {
                updateDownloadChunk(this.sqlDownloadCache);
                if (iDownloadProxy != null) {
                    iDownloadProxy.updateDownloadInfo(this.downloadInfo);
                } else {
                    this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                }
            } else if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(this.downloadInfo);
            } else {
                this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadChunk.getId(), this.curOffset);
            }
            this.lastSyncBytes = this.curOffset;
        }
        if (this.isMonitorRw) {
            this.debugSyncTimeNs += System.nanoTime() - jNanoTime;
        }
    }

    private void updateDownloadChunk(IDownloadCache iDownloadCache) {
        DownloadChunk downloadChunk;
        if (iDownloadCache == null) {
            return;
        }
        IDownloadProxy iDownloadProxy = null;
        boolean z2 = iDownloadCache instanceof SqlDownloadCache;
        if (z2 && (iDownloadProxy = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess())) == null) {
            return;
        }
        IDownloadProxy iDownloadProxy2 = iDownloadProxy;
        DownloadChunk firstReuseChunk = this.downloadChunk.isHostChunk() ? this.downloadChunk.getFirstReuseChunk() : this.downloadChunk;
        if (firstReuseChunk == null) {
            if (this.downloadChunk.isHostChunk()) {
                if (!z2 || iDownloadProxy2 == null) {
                    iDownloadCache.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                } else {
                    iDownloadProxy2.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                }
            }
            return;
        }
        firstReuseChunk.setCurrentOffset(this.curOffset);
        if (!z2 || iDownloadProxy2 == null) {
            downloadChunk = firstReuseChunk;
            iDownloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
        } else {
            iDownloadProxy2.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
            downloadChunk = firstReuseChunk;
        }
        if (downloadChunk.canRefreshCurOffsetForReuseChunk()) {
            boolean z3 = false;
            if (downloadChunk.hasNoBytesDownload()) {
                long nextChunkCurOffset = downloadChunk.getNextChunkCurOffset();
                if (nextChunkCurOffset > this.curOffset) {
                    if (!z2 || iDownloadProxy2 == null) {
                        iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                    } else {
                        iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), nextChunkCurOffset);
                    }
                    z3 = true;
                }
            }
            if (z3) {
                return;
            }
            if (!z2 || iDownloadProxy2 == null) {
                iDownloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
            } else {
                iDownloadProxy2.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getHostChunkIndex(), this.curOffset);
            }
        }
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        synchronized (this.callback) {
            this.canceled = true;
        }
        cancelConnection();
    }

    public long getCurOffset() {
        return this.curOffset;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e9 A[Catch: all -> 0x04e3, TRY_ENTER, TryCatch #2 {all -> 0x04e3, blocks: (B:177:0x02e9, B:178:0x02f0, B:207:0x0369, B:209:0x036f, B:210:0x0372, B:251:0x045e, B:252:0x0460, B:256:0x0467, B:258:0x0487, B:286:0x04d7, B:288:0x04dd, B:289:0x04e0, B:290:0x04e2), top: B:324:0x002b, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0369 A[Catch: all -> 0x04e3, TRY_ENTER, TryCatch #2 {all -> 0x04e3, blocks: (B:177:0x02e9, B:178:0x02f0, B:207:0x0369, B:209:0x036f, B:210:0x0372, B:251:0x045e, B:252:0x0460, B:256:0x0467, B:258:0x0487, B:286:0x04d7, B:288:0x04dd, B:289:0x04e0, B:290:0x04e2), top: B:324:0x002b, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03f1  */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12 */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3, types: [long] */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.handleResponse():void");
    }

    public void pause() {
        if (this.paused) {
            return;
        }
        this.paused = true;
        cancelConnection();
    }

    public void setChunkOffset(long j2, long j3, long j4) {
        this.curOffset = j2;
        this.handleStartOffset = j2;
        this.endOffset = j3;
        this.downloadChunkContentLen = j4;
    }

    public void setEndOffset(long j2, long j3) {
        this.endOffset = j2;
        this.downloadChunkContentLen = j3;
    }
}
