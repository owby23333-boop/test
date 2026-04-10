package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;
    private final List<Segment> succeedSegments = new ArrayList();
    private volatile long curSegmentReadOffset = -1;

    SegmentReader(DownloadInfo downloadInfo, SegmentDispatcher segmentDispatcher, IBufferPool iBufferPool, UrlRecord urlRecord, int i2) {
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i2;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException baseException) {
        if (!DownloadUtils.isHttpsError(baseException)) {
            return false;
        }
        String str = this.urlRecord.url;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
            return false;
        }
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            try {
                Logger.i(TAG, "closeConnection: thread = " + this.threadIndex);
                iDownloadHttpConnection.end();
                iDownloadHttpConnection.cancel();
            } catch (Throwable unused) {
            }
        }
    }

    private void createConnection(Segment segment) throws BaseException {
        String strReplaceFirst;
        String str;
        IDownloadHttpConnection iDownloadHttpConnectionDownloadWithConnection;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.connectEndTime = 0L;
                this.connectStartTime = jCurrentTimeMillis;
                this.startOffsetInConnection = segment.getCurrentOffsetRead();
                this.endOffsetInConnection = segment.getEndOffset();
                if (this.endOffsetInConnection > 0 && this.startOffsetInConnection > this.endOffsetInConnection) {
                    throw new SegmentApplyException(6, "createConn, " + segment);
                }
                this.stenographer = new DownloadStenographer();
                List<HttpHeader> listAddRangeHeader = DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);
                listAddRangeHeader.add(new HttpHeader("Segment-Index", String.valueOf(segment.getIndex())));
                listAddRangeHeader.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));
                DownloadUtils.addThrottleNetSpeed(listAddRangeHeader, this.downloadInfo);
                DownloadUtils.addTTNetProtectTimeout(listAddRangeHeader, this.downloadInfo);
                String str2 = this.urlRecord.url;
                strReplaceFirst = (this.httpsToHttpRetryUsed && !TextUtils.isEmpty(str2) && str2.startsWith("https")) ? str2.replaceFirst("https", "http") : str2;
                str = this.urlRecord.ip;
                Logger.i(TAG, "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                this.curUrl = strReplaceFirst;
                this.curHostIp = str;
                iDownloadHttpConnectionDownloadWithConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), strReplaceFirst, str, listAddRangeHeader, 0, jCurrentTimeMillis - this.lastConnectStartTime > m.ag && this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0, this.downloadInfo);
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                DownloadUtils.parseException(th, "createConn");
            }
            if (iDownloadHttpConnectionDownloadWithConnection == null) {
                throw new BaseException(DownloadErrorCode.ERROR_NO_CONNECTION, new IOException("download can't continue, chunk connection is null"));
            }
            this.httpConnection = iDownloadHttpConnectionDownloadWithConnection;
            this.httpResponse = new HttpResponse(strReplaceFirst, iDownloadHttpConnectionDownloadWithConnection);
            if (this.closed) {
                throw new StreamClosedException("createConn");
            }
            if (iDownloadHttpConnectionDownloadWithConnection instanceof AbsDownloadHttpConnection) {
                this.curHostRealIp = ((AbsDownloadHttpConnection) iDownloadHttpConnectionDownloadWithConnection).getHostIp();
            }
            String str3 = "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex;
        } finally {
            this.connectEndTime = System.currentTimeMillis();
        }
    }

    private void doConnect(Segment segment) throws RetryThrowable, BaseException {
        createConnection(segment);
        this.host.onSegmentConnected(this, segment, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    private boolean download(Segment segment) throws BaseException {
        initParams();
        while (true) {
            try {
                doConnect(segment);
                loopAndRead(segment);
                return true;
            } catch (SegmentApplyException e2) {
                this.failedException = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    Logger.e(TAG, "download: e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        return false;
                    }
                    if (this.reconnect) {
                        this.reconnect = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new SegmentApplyException(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                DownloadUtils.parseException(th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !handleFailedAndCheckRetry(segment, e3)) {
                            return false;
                        }
                    }
                } finally {
                    releaseDownload();
                }
            }
        }
        return false;
    }

    private boolean handleFailedAndCheckRetry(Segment segment, BaseException baseException) {
        Logger.e(TAG, "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount);
        int i2 = this.curRetryCount;
        if (i2 < this.retryCount) {
            this.curRetryCount = i2 + 1;
            return true;
        }
        if (checkCanUseHttpsToHttpRetry(baseException)) {
            return true;
        }
        this.host.onSegmentFailed(this, this.urlRecord, segment, baseException);
        return false;
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c7, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01cb, code lost:
    
        if (r11 <= r6) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01cf, code lost:
    
        if (r11 == Long.MAX_VALUE) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01d3, code lost:
    
        if (r13 <= r11) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0202, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RESPONSE_DATA_NOT_EQUALS, java.lang.String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", java.lang.Long.valueOf(r4), java.lang.Long.valueOf(r11), java.lang.Long.valueOf(r13), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0203, code lost:
    
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x020c, code lost:
    
        if (r9 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x020e, code lost:
    
        r0 = r3.obtain();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0213, code lost:
    
        r0.size = -1;
        r9.write(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0219, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x021e, code lost:
    
        r3.recycle(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x022b, code lost:
    
        r0 = r31.setting;
        r2 = r31.downloadInfo;
        r3 = r31.curUrl;
        r6 = r31.curHostIp;
        r7 = r31.curHostRealIp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0237, code lost:
    
        if (r31.closed != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x023e, code lost:
    
        r24 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0241, code lost:
    
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0243, code lost:
    
        com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSegmentIO(r0, r2, r3, r6, r7, r24, r31.httpConnection, r31.failedException, r13 - r4, java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(r31.readEndTime - r31.readStartTime));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012e, code lost:
    
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0138, code lost:
    
        if (r11 <= 0) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013a, code lost:
    
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.segment.SegmentReader.TAG, "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0150, code lost:
    
        r31.curSegmentReadOffset = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0153, code lost:
    
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0158, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0163, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0185 A[Catch: all -> 0x027e, BaseException -> 0x0284, TryCatch #30 {BaseException -> 0x0284, all -> 0x027e, blocks: (B:87:0x0173, B:89:0x017e, B:90:0x0185, B:92:0x018b, B:94:0x0191, B:97:0x019a, B:98:0x019e), top: B:273:0x0173 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1041
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private Buffer probeFirstBuffer(IBufferPool iBufferPool, InputStream inputStream) throws Throwable {
        int i2;
        Buffer bufferObtain = iBufferPool.obtain();
        try {
            i2 = inputStream.read(bufferObtain.data);
            try {
                if (i2 == -1) {
                    throw new BaseException(DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, "probe");
                }
                bufferObtain.size = i2;
                if (i2 == -1) {
                    iBufferPool.recycle(bufferObtain);
                }
                return bufferObtain;
            } catch (Throwable th) {
                th = th;
                if (i2 == -1) {
                    iBufferPool.recycle(bufferObtain);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = -1;
        }
    }

    private long refreshSegmentEndOffset() {
        long j2 = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        if (j2 <= 0) {
            return Long.MAX_VALUE;
        }
        return j2;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1L;
        this.connectEndTime = -1L;
        this.readStartTime = -1L;
        this.readEndTime = -1L;
        closeConnection();
    }

    private void resetRetryTimes() {
        this.retryCount = this.urlRecord.isMainUrl ? this.downloadInfo.getRetryCount() : this.downloadInfo.getBackUpUrlRetryCount();
        this.curRetryCount = 0;
    }

    public boolean adjustSegmentEndOffset(long j2) {
        long j3 = this.endOffsetInConnection;
        if (j2 <= 0 && j3 > 0) {
            return false;
        }
        if (j2 > j3 && j3 > 0) {
            return false;
        }
        this.segmentNewEndOffset = j2;
        this.threadDirty = true;
        return true;
    }

    public void close() {
        Logger.i(TAG, "close: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.closed = true;
            this.threadDirty = true;
        }
        closeConnection();
        Future future = this.future;
        if (future != null) {
            this.future = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    int getCurRetryCount() {
        return this.curRetryCount;
    }

    long getCurSegmentDownloadSpeed(long j2) {
        long j3 = this.readStartTime;
        if (j3 <= 0) {
            return -1L;
        }
        long j4 = j2 - j3;
        if (j4 <= 0) {
            return -1L;
        }
        long j5 = this.curSegmentReadOffset;
        long j6 = this.startOffsetInConnection;
        if (j6 < 0 || j5 < j6) {
            return 0L;
        }
        return (j5 - j6) / j4;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    BaseException getFailedException() {
        return this.failedException;
    }

    public long getReadBytes() {
        long readingBytes;
        synchronized (this.host) {
            readingBytes = this.readBytes + getReadingBytes();
        }
        return readingBytes;
    }

    public long getReadingBytes() {
        synchronized (this.host) {
            long j2 = this.curSegmentReadOffset;
            long j3 = this.startOffsetInConnection;
            if (j3 < 0 || j2 <= j3) {
                return 0L;
            }
            return j2 - j3;
        }
    }

    long getRecentDownloadSpeed(long j2, long j3) {
        DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j2, j3);
    }

    int getRetryCount() {
        return this.retryCount;
    }

    long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    boolean isFailed() {
        return this.failed;
    }

    void markProgress(long j2) {
        long j3 = this.curSegmentReadOffset;
        DownloadStenographer downloadStenographer = this.stenographer;
        if (j3 < 0 || downloadStenographer == null) {
            return;
        }
        String str = "markProgress: curSegmentReadOffset = " + j3 + ", threadIndex = " + this.threadIndex;
        downloadStenographer.markProgress(j3, j2);
    }

    public void reconnect() {
        reconnect(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r6.curSegment = null;
        r2 = r6.host;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.run():void");
    }

    public void setExited(boolean z2) {
        this.exited = z2;
    }

    void setFailed(boolean z2) {
        this.failed = z2;
    }

    void setFuture(Future future) {
        this.future = future;
    }

    boolean switchUrlRecord(UrlRecord urlRecord) {
        int i2 = this.switchUrlTimes;
        if (i2 >= 30) {
            return false;
        }
        this.switchUrlTimes = i2 + 1;
        UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    void updateReadBytes() {
        UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                long readingBytes = getReadingBytes();
                if (readingBytes > 0) {
                    this.readBytes += readingBytes;
                    urlRecord.increaseDownloadBytes(readingBytes);
                }
                this.curSegmentReadOffset = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void reconnect(boolean z2) {
        Logger.i(TAG, "reconnect: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.changeSegment = z2;
            this.reconnect = true;
            this.threadDirty = true;
        }
        closeConnection();
        Thread thread = this.thread;
        if (thread != null) {
            try {
                String str = "reconnect: t.interrupt threadIndex = " + this.threadIndex;
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }
}
