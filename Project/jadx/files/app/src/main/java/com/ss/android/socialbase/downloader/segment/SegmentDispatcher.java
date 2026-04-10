package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.expressad.d.a.b;
import com.anythink.expressad.exoplayer.i.a;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DownloadDnsManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SegmentDispatcher implements DownloadDnsManager.Callback, ISegmentCallback {
    private static final int READ_WATCH_TIME = 2000;
    private static final String TAG = "SegmentDispatcher";
    private final BufferQueue bufferQueue;
    private long connectTimeout;
    private final boolean debug;
    private final DownloadInfo downloadInfo;
    private BaseException failedException;
    private HttpResponse firstBackupUrlHttpResponse;
    private final IDownloadRunnableCallback hostCallback;
    private volatile boolean isAllContentDownloaded;
    private long lastReconnectTime;
    private HttpResponse mainUrlHttpResponse;
    private float poorSpeedRatio;
    private long readTimeout;
    private int reconnectCount;
    private final SegmentStrategy strategy;
    private long totalLength;
    private int urlIndex;
    private final MultiSegmentWriter writer;
    private volatile boolean canceled = false;
    private volatile boolean paused = false;
    private final List<SegmentReader> readers = new ArrayList();
    private final List<UrlRecord> urlRecords = new ArrayList();
    private volatile boolean needWaitDnsResolve = true;
    private final LinkedList<Segment> toDispatchSegments = new LinkedList<>();
    private final List<Segment> dispatchedSegments = new ArrayList();
    private final Object firstConnectionLock = new Object();
    private volatile boolean allReaderFailed = false;
    private final DownloadWatchDog.IWatcher connectWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.1
        private int watchTimes;

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            if (SegmentDispatcher.this.canceled || SegmentDispatcher.this.paused) {
                return -1L;
            }
            synchronized (SegmentDispatcher.this) {
                if (SegmentDispatcher.this.mainUrlHttpResponse == null && SegmentDispatcher.this.firstBackupUrlHttpResponse == null) {
                    long j2 = SegmentDispatcher.this.connectTimeout;
                    if (j2 <= 0) {
                        return -1L;
                    }
                    this.watchTimes++;
                    SegmentReader segmentReaderFindEarliestConnectTimeoutReader = SegmentDispatcher.this.findEarliestConnectTimeoutReader(false, System.currentTimeMillis(), j2);
                    if (segmentReaderFindEarliestConnectTimeoutReader == null) {
                        return j2;
                    }
                    SegmentDispatcher.this.trySwitchNextUrlForReader(segmentReaderFindEarliestConnectTimeoutReader);
                    segmentReaderFindEarliestConnectTimeoutReader.reconnect();
                    return ((long) ((this.watchTimes / SegmentDispatcher.this.urlRecords.size()) + 1)) * j2;
                }
                return -1L;
            }
        }
    };
    private final DownloadWatchDog.IWatcher readWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.2
        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            return SegmentDispatcher.this.scheduleWatchRead();
        }
    };
    private final DownloadWatchDog watchDog = new DownloadWatchDog();
    private final DownloadStenographer stenographer = new DownloadStenographer();

    public SegmentDispatcher(@NonNull DownloadInfo downloadInfo, @NonNull SegmentStrategy segmentStrategy, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.strategy = segmentStrategy;
        this.bufferQueue = new BufferQueue(this.strategy.getBufferCount(), this.strategy.getBufferSize());
        this.hostCallback = iDownloadRunnableCallback;
        this.writer = new MultiSegmentWriter(downloadInfo, iDownloadRunnableCallback, this.bufferQueue);
        this.debug = DownloadSetting.obtain(downloadInfo.getId()).optInt("debug") == 1;
    }

    private void addIpListLocked(String str, List<UrlRecord> list) {
        int iIndexOfUrl;
        if (this.debug) {
            Iterator<UrlRecord> it = list.iterator();
            while (it.hasNext()) {
                String str2 = "addIpListLocked: urlRecord = " + it.next();
            }
        }
        int ipStrategy = this.strategy.getIpStrategy();
        if ((ipStrategy == 1 || ipStrategy == 3) && (iIndexOfUrl = indexOfUrl(str)) >= 0 && iIndexOfUrl < this.urlRecords.size()) {
            this.urlRecords.addAll(iIndexOfUrl + 1, list);
        } else {
            this.urlRecords.addAll(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if ((r10.getCurrentOffsetRead() - r24.getCurrentOffsetRead()) < (r14 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader r23, com.ss.android.socialbase.downloader.segment.Segment r24) throws com.ss.android.socialbase.downloader.segment.SegmentApplyException {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader, com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private void arrangeSegmentLocked(List<Segment> list, Segment segment, boolean z2) {
        long startOffset = segment.getStartOffset();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && startOffset >= list.get(i2).getStartOffset()) {
            i2++;
        }
        list.add(i2, segment);
        if (z2) {
            segment.setIndex(size);
        }
    }

    private List<UrlRecord> assembleIpAddress(String str, List<InetAddress> list) {
        boolean z2;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.debug) {
                            String str2 = "onDnsResolved: ip = " + hostAddress;
                        }
                        UrlRecord urlRecord = new UrlRecord(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(urlRecord.ipFamily);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(urlRecord.ipFamily, linkedList);
                        }
                        linkedList.add(urlRecord);
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z2 = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((UrlRecord) linkedList2.pollFirst());
                            i2--;
                            z2 = true;
                        }
                    }
                    if (i2 <= 0) {
                        break;
                    }
                } while (z2);
                return arrayList;
            }
        }
        return null;
    }

    private void checkDownloadedBytesLocked(List<Segment> list) {
        long downloadedBytes = SegmentUtils.getDownloadedBytes(list);
        Logger.i(TAG, "checkDownloadBytes: getCurBytes = " + this.downloadInfo.getCurBytes() + ", totalBytes = " + this.downloadInfo.getTotalBytes() + ", downloadedBytes = " + downloadedBytes);
        if (downloadedBytes > this.downloadInfo.getTotalBytes() && this.downloadInfo.getTotalBytes() > 0) {
            downloadedBytes = this.downloadInfo.getTotalBytes();
        }
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes() || this.downloadInfo.getCurBytes() == downloadedBytes) {
            return;
        }
        this.downloadInfo.setCurBytes(downloadedBytes);
    }

    private void checkSegmentHttpResponseLocked(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws RetryThrowable, BaseException {
        SegmentReader segmentReader2 = segment.owner;
        if (segmentReader2 != null && segmentReader2 != segmentReader) {
            throw new SegmentApplyException(1, "segment already has an owner");
        }
        if (segmentReader.getStartOffsetInConnection() != segment.getCurrentOffsetRead()) {
            throw new SegmentApplyException(5, "applySegment");
        }
        if (!httpResponse.acceptPartial()) {
            if (segment.getCurrentOffsetRead() > 0) {
                throw new DownloadHttpException(1004, httpResponse.responseCode, "1: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
            Logger.e(TAG, "parseHttpResponse: segment.getCurrentOffsetRead = " + segment.getCurrentOffsetRead());
            if (!httpResponse.isResponseDataFromBegin()) {
                throw new DownloadHttpException(1004, httpResponse.responseCode, "2: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
        }
        if (!urlRecord.isMainUrl) {
            validateHttpResponse(httpResponse);
            if (this.firstBackupUrlHttpResponse == null) {
                this.firstBackupUrlHttpResponse = httpResponse;
                if (this.downloadInfo.getTotalBytes() <= 0) {
                    long totalLength = httpResponse.getTotalLength();
                    Logger.i(TAG, "checkSegmentHttpResponse:len=" + totalLength + ",url=" + urlRecord.url);
                    this.downloadInfo.setTotalBytes(totalLength);
                }
                synchronized (this.firstConnectionLock) {
                    this.firstConnectionLock.notify();
                }
                return;
            }
            return;
        }
        if (this.mainUrlHttpResponse == null) {
            this.mainUrlHttpResponse = httpResponse;
            synchronized (this.firstConnectionLock) {
                this.firstConnectionLock.notify();
            }
            IDownloadRunnableCallback iDownloadRunnableCallback = this.hostCallback;
            if (iDownloadRunnableCallback != null) {
                iDownloadRunnableCallback.handleFirstConnection(urlRecord.url, httpResponse.connection, segment.getCurrentOffsetRead());
            }
            long totalLength2 = httpResponse.getTotalLength();
            if (totalLength2 > 0) {
                for (Segment segment2 : this.dispatchedSegments) {
                    if (segment2.getEndOffset() <= 0 || segment2.getEndOffset() > totalLength2 - 1) {
                        segment2.setEndOffset(totalLength2 - 1);
                    }
                }
            }
        }
    }

    private void clearCoveredSegmentLocked() {
        int size;
        if (this.totalLength > 0 && (size = this.dispatchedSegments.size()) > 1) {
            ArrayList<Segment> arrayList = null;
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                Segment segment = this.dispatchedSegments.get(i2);
                Segment segment2 = this.dispatchedSegments.get(i3);
                if (segment.getCurrentOffsetRead() > segment2.getStartOffset() && segment2.getDownloadBytes() <= 0 && segment2.owner == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(segment2);
                    if (this.debug) {
                        String str = "clearCovered, covered = " + segment2 + ", prev = " + segment;
                    }
                } else if (segment2.getCurrentOffsetRead() > segment.getCurrentOffsetRead()) {
                    i2++;
                }
            }
            if (arrayList != null) {
                for (Segment segment3 : arrayList) {
                    this.dispatchedSegments.remove(segment3);
                    for (SegmentReader segmentReader : this.readers) {
                        if (segmentReader.curSegment == segment3) {
                            if (this.debug) {
                                String str2 = "clearCoveredSegmentLocked: reconnect, segment = " + segment3 + ", threadIndex = " + segmentReader.threadIndex;
                            }
                            segmentReader.reconnect(true);
                        }
                    }
                }
            }
        }
    }

    private void dispatchReadThread() {
        int threadCount;
        if (this.totalLength <= 0 || this.needWaitDnsResolve) {
            threadCount = 1;
        } else {
            threadCount = this.strategy.getThreadCount();
            int segmentMinInitSize = (int) (this.totalLength / this.strategy.getSegmentMinInitSize());
            if (threadCount > segmentMinInitSize) {
                threadCount = segmentMinInitSize;
            }
        }
        Logger.i(TAG, "dispatchReadThread: totalLength = " + this.totalLength + ", threadCount = " + threadCount);
        if (threadCount <= 0) {
            threadCount = 1;
        }
        synchronized (this) {
            while (this.readers.size() < threadCount) {
                if (!this.paused && !this.canceled) {
                    dispatchReadThreadOnce(obtainUrl());
                    if (this.strategy.segmentOneByOne()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void dispatchReadThreadOnce(UrlRecord urlRecord) {
        SegmentReader segmentReader = new SegmentReader(this.downloadInfo, this, this.bufferQueue, urlRecord, this.readers.size());
        this.readers.add(segmentReader);
        segmentReader.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(segmentReader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SegmentReader findEarliestConnectTimeoutReader(boolean z2, long j2, long j3) {
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.threadIndex != 0 || z2) {
                if (segmentReader2.connectStartTime > 0 && segmentReader2.connectEndTime <= 0 && j2 - segmentReader2.connectStartTime > j3 && (segmentReader == null || segmentReader2.connectStartTime < segmentReader.connectStartTime)) {
                    segmentReader = segmentReader2;
                }
            }
        }
        return segmentReader;
    }

    private UrlRecord findNextUrlLocked(SegmentReader segmentReader) {
        UrlRecord next;
        Iterator<UrlRecord> it = this.urlRecords.iterator();
        UrlRecord urlRecord = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != segmentReader.urlRecord && !next.isCurrentFailed()) {
                if (urlRecord == null) {
                    urlRecord = next;
                }
                if (next.getCurrentUsers() <= 0) {
                    break;
                }
            }
        }
        if (this.strategy.urlBalance()) {
            if (next != null) {
                return next;
            }
            if (this.strategy.urlBalanceStrictly()) {
                return null;
            }
        }
        return urlRecord;
    }

    private SegmentReader findPoorReadThread(long j2, long j3, long j4, int i2) {
        int i3 = 0;
        long j5 = Long.MAX_VALUE;
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            long j6 = 0;
            if (segmentReader2.readStartTime > 0) {
                i3++;
                SegmentReader segmentReader3 = segmentReader;
                if (segmentReader2.readStartTime < j2) {
                    long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j2, j3);
                    if (this.debug) {
                        String str = "findPoorReadThread: speed = " + recentDownloadSpeed + ", threadIndex = " + segmentReader2.threadIndex;
                        j6 = 0;
                    }
                    if (recentDownloadSpeed >= j6 && recentDownloadSpeed < j5) {
                        j5 = recentDownloadSpeed;
                        segmentReader = segmentReader2;
                    }
                }
                segmentReader = segmentReader3;
            }
        }
        SegmentReader segmentReader4 = segmentReader;
        if (segmentReader4 == null || i3 < i2 || j5 >= j4) {
            return null;
        }
        Logger.i(TAG, "findPoorReadThread: ----------- minSpeed = " + j5 + ", threadIndex = " + segmentReader4.threadIndex);
        return segmentReader4;
    }

    private boolean findPoorReadThreadAndReconnect(long j2, long j3) {
        long j4 = j2 - j3;
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j4, j2);
        int size = this.readers.size();
        if (size > 0) {
            recentDownloadSpeed /= (long) size;
        }
        SegmentReader segmentReaderFindPoorReadThread = findPoorReadThread(j4, j2, (long) Math.max(10.0f, recentDownloadSpeed * this.poorSpeedRatio), size / 2);
        if (segmentReaderFindPoorReadThread != null) {
            trySwitchNextUrlForReader(segmentReaderFindPoorReadThread);
            Logger.w(TAG, "handlePoorReadThread: reconnect for poor speed, threadIndex = " + segmentReaderFindPoorReadThread.threadIndex);
            segmentReaderFindPoorReadThread.reconnect();
            return true;
        }
        SegmentReader segmentReaderFindEarliestConnectTimeoutReader = findEarliestConnectTimeoutReader(true, j2, j3);
        if (segmentReaderFindEarliestConnectTimeoutReader == null) {
            return false;
        }
        trySwitchNextUrlForReader(segmentReaderFindEarliestConnectTimeoutReader);
        Logger.w(TAG, "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + segmentReaderFindEarliestConnectTimeoutReader.threadIndex);
        segmentReaderFindEarliestConnectTimeoutReader.reconnect();
        return true;
    }

    private void fixSegmentsLocked(List<Segment> list) {
        Segment segment = list.get(0);
        long startOffset = segment.getStartOffset();
        if (startOffset > 0) {
            Segment segment2 = new Segment(0L, startOffset - 1);
            String str = "fixSegmentsLocked: first = " + segment + ", add new first = " + segment2;
            arrangeSegmentLocked(list, segment2, true);
        }
        Iterator<Segment> it = list.iterator();
        if (it.hasNext()) {
            Segment next = it.next();
            while (it.hasNext()) {
                Segment next2 = it.next();
                if (next.getEndOffset() < next2.getStartOffset() - 1) {
                    Logger.w(TAG, "fixSegment: segment = " + next + ", new end = " + (next2.getStartOffset() - 1));
                    next.setEndOffset(next2.getStartOffset() - 1);
                }
                next = next2;
            }
        }
        Segment segment3 = list.get(list.size() - 1);
        long totalBytes = this.downloadInfo.getTotalBytes();
        if (totalBytes <= 0 || (segment3.getEndOffset() != -1 && segment3.getEndOffset() < totalBytes - 1)) {
            Logger.w(TAG, "fixSegment: last segment = " + segment3 + ", new end=-1");
            segment3.setEndOffset(-1L);
        }
    }

    private float getDownloadRatio(SegmentReader segmentReader, UrlRecord urlRecord) {
        long readBytes = segmentReader.getReadBytes();
        int size = this.readers.size();
        if (size <= 1) {
            size = this.strategy.getThreadCount();
        }
        float f2 = 1.0f;
        if (readBytes <= 0) {
            float mainRatio = this.strategy.getMainRatio();
            if (mainRatio <= 0.0f || mainRatio >= 1.0f) {
                mainRatio = 1.0f / size;
            }
            if (segmentReader.threadIndex == 0) {
                return mainRatio;
            }
            if (size > 1) {
                f2 = 1.0f - mainRatio;
                size--;
            }
        } else {
            long totalReadBytes = getTotalReadBytes();
            if (totalReadBytes > readBytes) {
                return readBytes / totalReadBytes;
            }
        }
        return f2 / size;
    }

    private long getRemainReadBytes(Segment segment) {
        long remainReadBytes = segment.getRemainReadBytes();
        if (remainReadBytes != -1) {
            return remainReadBytes;
        }
        long j2 = this.totalLength;
        return j2 > 0 ? j2 - segment.getCurrentOffsetRead() : remainReadBytes;
    }

    private long getTotalReadBytes() {
        Iterator<SegmentReader> it = this.readers.iterator();
        long readBytes = 0;
        while (it.hasNext()) {
            readBytes += it.next().getReadBytes();
        }
        return readBytes;
    }

    private long getUnconfirmedRemainBytes(int i2, int i3) {
        Segment segment = this.dispatchedSegments.get(i2);
        long remainReadBytes = getRemainReadBytes(segment);
        int i4 = i2 + 1;
        Segment segment2 = i4 < i3 ? this.dispatchedSegments.get(i4) : null;
        if (segment2 == null) {
            return remainReadBytes;
        }
        long startOffset = segment2.getStartOffset() - segment.getCurrentOffsetRead();
        return remainReadBytes == -1 ? startOffset : Math.min(remainReadBytes, startOffset);
    }

    private int indexOfSegmentLocked(long j2) {
        int size = this.dispatchedSegments.size();
        for (int i2 = 0; i2 < size; i2++) {
            Segment segment = this.dispatchedSegments.get(i2);
            if (segment.getStartOffset() == j2) {
                return i2;
            }
            if (segment.getStartOffset() > j2) {
                return -1;
            }
        }
        return -1;
    }

    private int indexOfUrl(String str) {
        int size = this.urlRecords.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.urlRecords.get(i2).url, str)) {
                return i2;
            }
        }
        return -1;
    }

    private void initDns() {
        List<String> backUpUrls;
        int ipStrategy = this.strategy.getIpStrategy();
        if (ipStrategy <= 0) {
            this.needWaitDnsResolve = false;
            dispatchReadThread();
            return;
        }
        DownloadDnsManager downloadDnsManager = DownloadDnsManager.getInstance();
        downloadDnsManager.resolveDnsAsync(this.downloadInfo.getUrl(), this, a.f9492f);
        if (ipStrategy <= 2 || (backUpUrls = this.downloadInfo.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                downloadDnsManager.resolveDnsAsync(str, this, a.f9492f);
            }
        }
    }

    private void initSegments(List<Segment> list) {
        this.totalLength = this.downloadInfo.getTotalBytes();
        if (this.totalLength <= 0) {
            this.totalLength = this.downloadInfo.getExpectFileLength();
            Logger.i(TAG, "initSegments: getExpectFileLength = " + this.totalLength);
        }
        synchronized (this) {
            this.toDispatchSegments.clear();
            if (list == null || list.isEmpty()) {
                arrangeSegmentLocked(this.toDispatchSegments, new Segment(0L, -1L), false);
            } else {
                Iterator<Segment> it = list.iterator();
                while (it.hasNext()) {
                    arrangeSegmentLocked(this.toDispatchSegments, new Segment(it.next()), false);
                }
                fixSegmentsLocked(this.toDispatchSegments);
                checkDownloadedBytesLocked(this.toDispatchSegments);
            }
            Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
        }
    }

    private void initUrlRecords() {
        this.urlRecords.add(new UrlRecord(this.downloadInfo.getUrl(), true));
        List<String> backUpUrls = this.downloadInfo.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.urlRecords.add(new UrlRecord(str, false));
                }
            }
        }
        this.strategy.updateUrlCount(this.urlRecords.size());
    }

    private void initWatchDog() {
        SegmentStrategy segmentStrategy = this.strategy;
        this.connectTimeout = segmentStrategy.getConnectTimeout();
        this.readTimeout = segmentStrategy.getReadTimeout();
        this.poorSpeedRatio = segmentStrategy.getPoorSpeedRatio();
        int i2 = this.reconnectCount;
        if (i2 > 0) {
            this.watchDog.addWatcher(this.connectWatcher, i2);
        }
    }

    private void initWatchDog2() {
        if (this.readTimeout > 0) {
            this.lastReconnectTime = System.currentTimeMillis();
            this.watchDog.addWatcher(this.readWatcher, 0L);
        }
    }

    private boolean isAllContentDownloaded() {
        long j2 = this.totalLength;
        if (j2 <= 0) {
            this.isAllContentDownloaded = false;
            return false;
        }
        synchronized (this) {
            long firstOffset = SegmentUtils.getFirstOffset(this.dispatchedSegments);
            Logger.i(TAG, "isAllContentDownloaded: firstOffset = " + firstOffset);
            if (firstOffset >= j2) {
                this.isAllContentDownloaded = true;
                return true;
            }
            this.isAllContentDownloaded = false;
            return false;
        }
    }

    private boolean isAllReaderFailedLocked() {
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            if (!it.next().isFailed()) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownloadSpeedPoor(SegmentReader segmentReader, long j2, long j3, long j4, double d2) {
        if (segmentReader.readStartTime <= 0) {
            return false;
        }
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j2, j3);
        int size = this.readers.size();
        long j5 = size > 0 ? recentDownloadSpeed / ((long) size) : recentDownloadSpeed;
        long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j2, j3);
        if (recentDownloadSpeed2 >= j4) {
            double d3 = recentDownloadSpeed2;
            double d4 = j5;
            Double.isNaN(d4);
            if (d3 >= d4 * d2) {
                return false;
            }
        }
        String str = "isDownloadSpeedPoor: totalSpeed = " + recentDownloadSpeed + ", threadAvgSpeed = " + j5 + ", poorSpeed = " + j4 + ", speed = " + recentDownloadSpeed2 + ",threadIndex = " + segmentReader.threadIndex;
        return true;
    }

    private void markProgress(long j2) {
        this.stenographer.markProgress(this.downloadInfo.getCurBytes(), j2);
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            it.next().markProgress(j2);
        }
    }

    private Segment obtainChildSegmentFromMaxRemain(SegmentReader segmentReader, UrlRecord urlRecord) {
        String str;
        int size = this.dispatchedSegments.size();
        long j2 = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            long unconfirmedRemainBytes = getUnconfirmedRemainBytes(i3, size);
            if (unconfirmedRemainBytes > j2) {
                i2 = i3;
                j2 = unconfirmedRemainBytes;
            }
        }
        long segmentMinSize = this.strategy.getSegmentMinSize();
        long segmentMaxSize = this.strategy.getSegmentMaxSize();
        if (i2 < 0 || j2 <= segmentMinSize) {
            return null;
        }
        Segment segment = this.dispatchedSegments.get(i2);
        int ratioSegmentStrategy = this.dispatchedSegments.size() < this.readers.size() ? 2 : this.strategy.getRatioSegmentStrategy();
        if (ratioSegmentStrategy == 1) {
            SegmentReader segmentReader2 = segment.owner;
            if (segmentReader2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j3 = jCurrentTimeMillis - 4000;
                long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j3, jCurrentTimeMillis);
                long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j3, jCurrentTimeMillis);
                float f2 = (recentDownloadSpeed <= 0 || recentDownloadSpeed2 <= 0) ? -1.0f : recentDownloadSpeed2 / (recentDownloadSpeed + recentDownloadSpeed2);
                if (f2 == -1.0f) {
                    long readBytes = segmentReader2.getReadBytes();
                    long readBytes2 = segmentReader.getReadBytes();
                    if (readBytes > 0 && readBytes2 > 0) {
                        f2 = readBytes2 / (readBytes + readBytes2);
                    }
                }
                if (f2 > 0.0f) {
                    float f3 = f2 * 0.9f;
                    long j4 = (long) (j2 * f3);
                    if (j4 < segmentMinSize) {
                        j4 = segmentMinSize;
                    }
                    if (segmentMaxSize > 0 && j4 > segmentMaxSize) {
                        j4 = segmentMaxSize;
                    }
                    long j5 = segmentMinSize / 2;
                    long j6 = j2 - j5;
                    if (j4 > j6) {
                        j4 = j6;
                    } else if (j4 < j5) {
                        j4 = j5;
                    }
                    Segment segment2 = new Segment(segment.getCurrentOffsetRead() + (j2 - j4), segment.getEndOffset());
                    Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment2 + ", maxRemainBytes = " + j2 + ", childLength = " + j4 + ", ratio = " + f3 + ", threadIndex = " + segmentReader.threadIndex);
                    return segment2;
                }
            }
            str = TAG;
        } else {
            if (ratioSegmentStrategy == 2) {
                long curBytes = this.totalLength - this.downloadInfo.getCurBytes();
                float downloadRatio = getDownloadRatio(segmentReader, urlRecord);
                long j7 = (long) (curBytes * downloadRatio);
                if (j7 < segmentMinSize) {
                    j7 = segmentMinSize;
                }
                if (segmentMaxSize > 0 && j7 > segmentMaxSize) {
                    j7 = segmentMaxSize;
                }
                long j8 = segmentMinSize / 2;
                long j9 = j2 - j8;
                if (j7 > j9) {
                    j7 = j9;
                } else if (j7 < j8) {
                    j7 = j8;
                }
                Segment segment3 = new Segment(segment.getCurrentOffsetRead() + (j2 - j7), segment.getEndOffset());
                Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment3 + ", maxRemainBytes = " + j2 + ", childLength = " + j7 + ", ratio = " + downloadRatio + ", threadIndex = " + segmentReader.threadIndex);
                return segment3;
            }
            str = TAG;
        }
        Segment segment4 = new Segment(segment.getCurrentOffsetRead() + (j2 / 2), segment.getEndOffset());
        Logger.i(str, "obtainSegment: parent = " + segment + ",child = " + segment4);
        return segment4;
    }

    private Segment obtainLeastCompetitorSegment() {
        int competitor;
        Segment segment = null;
        int i2 = Integer.MAX_VALUE;
        for (Segment segment2 : this.dispatchedSegments) {
            if (getRemainReadBytes(segment2) > 0 && (competitor = segment2.getCompetitor()) < i2) {
                segment = segment2;
                i2 = competitor;
            }
        }
        return segment;
    }

    private Segment obtainSegmentLocked(SegmentReader segmentReader, UrlRecord urlRecord) {
        while (!this.toDispatchSegments.isEmpty()) {
            Segment segmentPoll = this.toDispatchSegments.poll();
            if (segmentPoll != null) {
                arrangeSegmentLocked(this.dispatchedSegments, segmentPoll, true);
                if (getRemainReadBytes(segmentPoll) > 0 || this.totalLength <= 0) {
                    return segmentPoll;
                }
            }
        }
        clearCoveredSegmentLocked();
        Segment segmentObtainChildSegmentFromMaxRemain = obtainChildSegmentFromMaxRemain(segmentReader, urlRecord);
        if (segmentObtainChildSegmentFromMaxRemain != null && getRemainReadBytes(segmentObtainChildSegmentFromMaxRemain) > 0) {
            arrangeSegmentLocked(this.dispatchedSegments, segmentObtainChildSegmentFromMaxRemain, true);
            return segmentObtainChildSegmentFromMaxRemain;
        }
        Segment segmentObtainSegmentWhenNoNewSegment = obtainSegmentWhenNoNewSegment();
        if (segmentObtainSegmentWhenNoNewSegment != null) {
            return segmentObtainSegmentWhenNoNewSegment;
        }
        return null;
    }

    private Segment obtainSegmentWhenNoNewSegment() {
        int i2 = 0;
        while (true) {
            Segment segmentObtainLeastCompetitorSegment = obtainLeastCompetitorSegment();
            if (segmentObtainLeastCompetitorSegment == null) {
                return null;
            }
            SegmentReader segmentReader = segmentObtainLeastCompetitorSegment.owner;
            if (segmentReader == null) {
                return segmentObtainLeastCompetitorSegment;
            }
            if (segmentObtainLeastCompetitorSegment.getCompetitor() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            markProgress(jCurrentTimeMillis);
            if (jCurrentTimeMillis - segmentReader.readStartTime > a.f9492f && isDownloadSpeedPoor(segmentReader, jCurrentTimeMillis - a.f9492f, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.debug) {
                    String str = "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + segmentObtainLeastCompetitorSegment + ", owner.threadIndex = " + segmentReader.threadIndex;
                }
                return segmentObtainLeastCompetitorSegment;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.debug) {
                    String str2 = "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + segmentObtainLeastCompetitorSegment;
                }
                return segmentObtainLeastCompetitorSegment;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private UrlRecord obtainUrl() {
        UrlRecord urlRecord;
        synchronized (this) {
            int size = this.urlIndex % this.urlRecords.size();
            if (this.strategy.urlBalance()) {
                this.urlIndex++;
            }
            urlRecord = this.urlRecords.get(size);
        }
        return urlRecord;
    }

    private void onComplete() {
        Logger.i(TAG, "onComplete");
        this.bufferQueue.close();
        synchronized (this.firstConnectionLock) {
            this.firstConnectionLock.notify();
        }
    }

    private void onError(BaseException baseException) {
        Logger.e(TAG, "onError, e = " + baseException);
        this.failedException = baseException;
        this.bufferQueue.close();
        synchronized (this) {
            Iterator<SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long scheduleWatchRead() {
        if (this.canceled || this.paused) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            markProgress(jCurrentTimeMillis);
            long readTimeout = this.strategy.getReadTimeout();
            if (readTimeout > 0) {
                long j2 = this.lastReconnectTime;
                if (j2 > 0 && jCurrentTimeMillis - j2 > readTimeout && findPoorReadThreadAndReconnect(jCurrentTimeMillis, readTimeout)) {
                    this.lastReconnectTime = jCurrentTimeMillis;
                    this.reconnectCount++;
                }
            }
        }
        return a.f9492f;
    }

    private void switchToNextUrl() {
        synchronized (this) {
            this.urlIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySwitchNextUrlForReader(SegmentReader segmentReader) {
        synchronized (this) {
            UrlRecord urlRecordFindNextUrlLocked = findNextUrlLocked(segmentReader);
            if (urlRecordFindNextUrlLocked == null) {
                return false;
            }
            return segmentReader.switchUrlRecord(urlRecordFindNextUrlLocked);
        }
    }

    private void validateHttpResponse(HttpResponse httpResponse) throws BaseException {
        HttpResponse httpResponse2 = this.mainUrlHttpResponse;
        if (httpResponse2 == null && (httpResponse2 = this.firstBackupUrlHttpResponse) == null) {
            return;
        }
        long totalLength = httpResponse.getTotalLength();
        long totalLength2 = httpResponse2.getTotalLength();
        if (totalLength != totalLength2) {
            String str = "total len not equals,len=" + totalLength + ",sLen=" + totalLength2 + ",code=" + httpResponse.responseCode + ",sCode=" + httpResponse2.responseCode + ",range=" + httpResponse.getContentRange() + ",sRange = " + httpResponse2.getContentRange() + ",url = " + httpResponse.url + ",sUrl=" + httpResponse2.url;
            Logger.e(TAG, str);
            if (totalLength > 0 && totalLength2 > 0) {
                throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, str);
            }
        }
        String etag = httpResponse.getEtag();
        String etag2 = httpResponse2.getEtag();
        if (TextUtils.equals(etag, etag2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + etag + ", mainEtag = " + etag2;
        Logger.e(TAG, str2);
        if (!TextUtils.isEmpty(etag) && !TextUtils.isEmpty(etag2) && !etag.equalsIgnoreCase(etag2)) {
            throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, str2);
        }
    }

    private void waitFirstConnection() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.firstConnectionLock) {
            if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null) {
                this.firstConnectionLock.wait();
            }
        }
        if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null && (baseException = this.failedException) != null) {
            throw baseException;
        }
    }

    private void writeSegments() throws BaseException {
        try {
            this.writer.loopAndWrite(this.bufferQueue);
        } catch (StreamClosedException unused) {
        } catch (BaseException e2) {
            Logger.e(TAG, "dispatchSegments: loopAndWrite e = " + e2);
            onError(e2);
            throw e2;
        }
        if (this.paused || this.canceled) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.toDispatchSegments.isEmpty()) {
                    Segment segmentPoll = this.toDispatchSegments.poll();
                    if (segmentPoll != null) {
                        arrangeSegmentLocked(this.dispatchedSegments, segmentPoll, true);
                    }
                }
                checkDownloadedBytesLocked(this.dispatchedSegments);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.allReaderFailed || this.failedException == null) {
            if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
                DownloadMonitorHelper.monitorSegmentsError(this.downloadInfo, this.dispatchedSegments);
            }
            Logger.i(TAG, "dispatchSegments::download finished");
        } else {
            Logger.e(TAG, "dispatchSegments: loopAndWrite  failedException = " + this.failedException);
            throw this.failedException;
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void applySegment(SegmentReader segmentReader, Segment segment) throws BaseException {
        synchronized (this) {
            applySegmentLocked(segmentReader, segment);
        }
    }

    public void cancel() {
        Logger.i(TAG, b.dO);
        this.canceled = true;
        synchronized (this) {
            Iterator<SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        this.writer.cancel();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public IOutput createOutput(SegmentReader segmentReader, Segment segment) throws BaseException {
        IOutput stub;
        synchronized (this) {
            SegmentOutput segmentOutput = new SegmentOutput(this.downloadInfo, this.bufferQueue, segment);
            this.writer.assignOutput(segmentOutput);
            stub = segmentOutput.getStub();
        }
        return stub;
    }

    public boolean downloadSegments(List<Segment> list) throws InterruptedException, BaseException {
        try {
            initUrlRecords();
            initSegments(list);
            dispatchReadThread();
            initWatchDog();
            initDns();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                waitFirstConnection();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(jCurrentTimeMillis2);
                this.downloadInfo.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.paused && !this.canceled) {
                    this.hostCallback.checkSpaceOverflow(this.totalLength);
                    initWatchDog2();
                    writeSegments();
                    return true;
                }
                if (!this.paused && !this.canceled) {
                    Logger.i(TAG, "finally pause");
                    pause();
                }
                this.watchDog.release();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.downloadInfo.increaseAllConnectTime(jCurrentTimeMillis3);
                this.downloadInfo.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.paused && !this.canceled) {
                Logger.i(TAG, "finally pause");
                pause();
            }
            this.watchDog.release();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public Segment obtainSegment(SegmentReader segmentReader, UrlRecord urlRecord) {
        if (this.canceled || this.paused) {
            return null;
        }
        synchronized (this) {
            Segment segmentObtainSegmentLocked = obtainSegmentLocked(segmentReader, urlRecord);
            if (segmentObtainSegmentLocked != null) {
                segmentObtainSegmentLocked.increaseCompetitor();
                if (segmentObtainSegmentLocked.getCompetitor() > 1) {
                    return new Segment(segmentObtainSegmentLocked);
                }
            }
            return segmentObtainSegmentLocked;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback
    public void onDnsResolved(String str, List<InetAddress> list) {
        if (this.paused || this.canceled) {
            return;
        }
        List<UrlRecord> listAssembleIpAddress = null;
        try {
            listAssembleIpAddress = assembleIpAddress(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (listAssembleIpAddress != null) {
                addIpListLocked(str, listAssembleIpAddress);
                this.needWaitDnsResolve = false;
                this.strategy.updateUrlCount(this.urlRecords.size());
                dispatchReadThread();
            } else {
                this.needWaitDnsResolve = false;
                this.strategy.updateUrlCount(this.urlRecords.size());
                dispatchReadThread();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderExit(SegmentReader segmentReader) {
        Logger.i(TAG, "onReaderExit: threadIndex = " + segmentReader.threadIndex);
        synchronized (this) {
            segmentReader.setExited(true);
            this.readers.remove(segmentReader);
            clearCoveredSegmentLocked();
            if (this.readers.isEmpty()) {
                onComplete();
            } else if (isAllContentDownloaded()) {
                Iterator<SegmentReader> it = this.readers.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                onComplete();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderRun(SegmentReader segmentReader) {
        if (this.debug) {
            Logger.i(TAG, "onReaderRun, threadIndex = " + segmentReader.threadIndex);
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentConnected(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws RetryThrowable, BaseException {
        synchronized (this) {
            if (this.canceled || this.paused) {
                throw new StreamClosedException("connected");
            }
            checkSegmentHttpResponseLocked(segmentReader, segment, urlRecord, httpResponse);
            segmentReader.setFailed(false);
            if (this.totalLength <= 0) {
                this.totalLength = this.downloadInfo.getTotalBytes();
                if (this.totalLength <= 0) {
                    this.totalLength = httpResponse.getTotalLength();
                }
                dispatchReadThread();
            } else if (this.strategy.segmentOneByOne()) {
                dispatchReadThread();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentFailed(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException) {
        synchronized (this) {
            Logger.e(TAG, "onSegmentFailed: segment = " + segment + ", e = " + baseException);
            segmentReader.setFailed(true);
            if (segmentReader.threadIndex == 0) {
                this.failedException = baseException;
            }
            if (isAllReaderFailedLocked()) {
                if (this.failedException == null) {
                    this.failedException = baseException;
                }
                this.allReaderFailed = true;
                onError(this.failedException);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentRetry(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException, int i2, int i3) {
        boolean zIsResponseCodeError = DownloadUtils.isResponseCodeError(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zIsResponseCodeError = true;
        }
        if (zIsResponseCodeError || i2 >= i3) {
            trySwitchNextUrlForReader(segmentReader);
        }
    }

    public void pause() {
        Logger.i(TAG, "pause1");
        this.paused = true;
        synchronized (this) {
            Iterator<SegmentReader> it = this.readers.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        this.writer.pause();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unApplySegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            if (segment.owner == segmentReader) {
                Logger.i(TAG, "unApplySegment " + segment);
                segment.setCurrentOffsetRead(segmentReader.getCurSegmentReadOffset());
                segment.owner = null;
                segmentReader.updateReadBytes();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unObtainSegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            segment.decreaseCompetitor();
        }
    }
}
