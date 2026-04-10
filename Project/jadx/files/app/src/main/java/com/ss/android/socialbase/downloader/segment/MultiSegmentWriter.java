package com.ss.android.socialbase.downloader.segment;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class MultiSegmentWriter {
    private static final boolean DEBUG = false;
    private static final int MIN_CACHE_BYTES = 65536;
    private static final int MIN_CACHE_TIME_MS = 100;
    private static final int MIN_SYNC_STEP_BYTE = 65536;
    private static final long MIN_SYNC_TIME_MS = 500;
    private static final String TAG = "MultiSegmentWriter";
    private final IDownloadRunnableCallback callback;
    private final DownloadInfo downloadInfo;
    private BaseException exception;
    private final boolean hasSyncStrategy;
    private final boolean isMonitorRw;
    private final IBufferPool pool;
    private final DownloadSetting setting;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private long syncTimeNs;
    private final List<SegmentOutput> outputs = new LinkedList();
    private final List<SegmentOutput> doneOutputs = new ArrayList();
    private volatile boolean threadDirty = false;
    private volatile boolean paused = false;
    private volatile boolean canceled = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
    private final AppStatusManager appStatusManager = AppStatusManager.getInstance();

    MultiSegmentWriter(DownloadInfo downloadInfo, IDownloadRunnableCallback iDownloadRunnableCallback, IBufferPool iBufferPool) {
        this.downloadInfo = downloadInfo;
        this.callback = iDownloadRunnableCallback;
        this.pool = iBufferPool;
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
    }

    private void checkAndSync(long j2, boolean z2) throws IOException {
        long j3 = j2 - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j3 > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                flushAndSync();
                this.lastSyncTimestamp = j2;
                return;
            }
            return;
        }
        long curBytes = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
        if (z2 || isNeedSync(curBytes, j3)) {
            flushAndSync();
            this.lastSyncTimestamp = j2;
        }
    }

    private void close(List<SegmentOutput> list) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    private void flush(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    private void flushAndSync() throws IOException {
        boolean z2 = this.isMonitorRw;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        List<SegmentOutput> list = this.outputs;
        List<SegmentOutput> list2 = this.doneOutputs;
        Map<Long, Segment> segmentMap = iDownloadCache.getSegmentMap(downloadInfo.getId());
        if (segmentMap == null) {
            segmentMap = new HashMap<>(4);
        }
        boolean z3 = false;
        synchronized (this) {
            flush(list);
            try {
                sync(list);
                z3 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            updateSegmentToMap(list, segmentMap);
            if (list2.size() > 0) {
                close(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z3) {
            downloadInfo.updateRealDownloadTime(true);
            iDownloadCache.updateSegments(downloadInfo.getId(), segmentMap);
            iDownloadCache.updateDownloadInfo(downloadInfo);
            this.lastSyncBytes = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.syncTimeNs += System.nanoTime() - jNanoTime;
        }
    }

    private boolean isNeedSync(long j2, long j3) {
        return j2 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j3 > 500;
    }

    private void outputDone(IOutput iOutput) {
        synchronized (this) {
            this.doneOutputs.add((SegmentOutput) iOutput);
        }
    }

    private void sync(List<SegmentOutput> list) throws IOException {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            it.next().sync();
        }
    }

    private void updateSegmentToMap(List<SegmentOutput> list, Map<Long, Segment> map) {
        Iterator<SegmentOutput> it = list.iterator();
        while (it.hasNext()) {
            Segment segment = it.next().getSegment();
            Segment segment2 = map.get(Long.valueOf(segment.getStartOffset()));
            if (segment2 == null) {
                map.put(Long.valueOf(segment.getStartOffset()), new Segment(segment));
            } else {
                segment2.setCurrentOffset(segment.getCurrentOffset());
                segment2.setEndOffset(segment.getEndOffset());
            }
        }
    }

    void assignOutput(SegmentOutput segmentOutput) {
        synchronized (this) {
            this.outputs.add(segmentOutput);
        }
    }

    public void cancel() {
        this.canceled = true;
        this.threadDirty = true;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
    
        if (r13 <= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
    
        r3.onProgress(r13);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f9 A[Catch: all -> 0x03d9, TryCatch #26 {all -> 0x03d9, blocks: (B:153:0x01f5, B:155:0x01f9, B:158:0x01ff, B:160:0x0205, B:161:0x0208, B:162:0x021e, B:199:0x02a1, B:200:0x02a3, B:239:0x0328, B:241:0x0332, B:243:0x0336, B:280:0x03b7, B:282:0x03bd, B:283:0x03c0, B:284:0x03d8), top: B:358:0x0027, inners: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0205 A[Catch: all -> 0x03d9, TryCatch #26 {all -> 0x03d9, blocks: (B:153:0x01f5, B:155:0x01f9, B:158:0x01ff, B:160:0x0205, B:161:0x0208, B:162:0x021e, B:199:0x02a1, B:200:0x02a3, B:239:0x0328, B:241:0x0332, B:243:0x0336, B:280:0x03b7, B:282:0x03bd, B:283:0x03c0, B:284:0x03d8), top: B:358:0x0027, inners: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054 A[Catch: all -> 0x0037, BaseException -> 0x003e, StreamClosedException -> 0x0045, TRY_ENTER, TRY_LEAVE, TryCatch #38 {StreamClosedException -> 0x0045, BaseException -> 0x003e, all -> 0x0037, blocks: (B:11:0x0032, B:23:0x0054), top: B:383:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0332 A[Catch: all -> 0x03d9, TryCatch #26 {all -> 0x03d9, blocks: (B:153:0x01f5, B:155:0x01f9, B:158:0x01ff, B:160:0x0205, B:161:0x0208, B:162:0x021e, B:199:0x02a1, B:200:0x02a3, B:239:0x0328, B:241:0x0332, B:243:0x0336, B:280:0x03b7, B:282:0x03bd, B:283:0x03c0, B:284:0x03d8), top: B:358:0x0027, inners: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03bd A[Catch: all -> 0x03d9, TryCatch #26 {all -> 0x03d9, blocks: (B:153:0x01f5, B:155:0x01f9, B:158:0x01ff, B:160:0x0205, B:161:0x0208, B:162:0x021e, B:199:0x02a1, B:200:0x02a3, B:239:0x0328, B:241:0x0332, B:243:0x0336, B:280:0x03b7, B:282:0x03bd, B:283:0x03c0, B:284:0x03d8), top: B:358:0x0027, inners: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x022f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0365 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x02b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x024e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x02cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v6, types: [long] */
    /* JADX WARN: Type inference failed for: r15v8, types: [long] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1134
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.MultiSegmentWriter.loopAndWrite(com.ss.android.socialbase.downloader.segment.IInput):void");
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}
