package com.bykv.vk.component.ttvideo.mediakit.fetcher;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class AVMDLURLFetcherBridge implements AVMDLURLFetcherListener {
    private static final String TAG = "AVMDLURLFetcherBridge";
    private static AVMDLFetcherMakerInterface fetcherMaker;
    public String rawKey = null;
    public String fileKey = null;
    public String oldURL = null;
    String newURL = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyFetcherResult(long j, String str, String str2, String str3);

    public static void setFetcherMaker(AVMDLFetcherMakerInterface aVMDLFetcherMakerInterface) {
        if (aVMDLFetcherMakerInterface != null) {
            fetcherMaker = aVMDLFetcherMakerInterface;
        }
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.newURL;
            this.lock.unlock();
            AVMDLLog.d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.fetcher.AVMDLURLFetcherListener
    public void onCompletion(int i, String str, String str2, String[] strArr) {
        this.lock.lock();
        try {
            if (this.isFinish) {
                AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "has fetch finished not need cur completion code:%d result:%s", Integer.valueOf(i), this.newURL));
            } else {
                if (strArr != null && strArr.length > 0) {
                    this.newURL = strArr[0];
                }
                AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "receive completion code:%d result:%s", Integer.valueOf(i), this.newURL));
                this.isFinish = true;
                if (this.handle != 0) {
                    AVMDLLog.d(TAG, "start notify result");
                    _notifyFetcherResult(this.handle, str, str2, this.newURL);
                    AVMDLLog.d(TAG, "end notify result");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void release() {
        AVMDLLog.d(TAG, String.format("----start release fetcher:%s", this));
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLLog.d(TAG, String.format("remove fetcher rawkey:%s, fileKey:%s", this.rawKey, this.fileKey));
            AVMDLLog.d(TAG, String.format("****end call release:%s", this));
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j, String str, String str2, String str3) {
        int i;
        AVMDLLog.d(TAG, "----start fetch rawkey:" + str);
        if (fetcherMaker == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AVMDLLog.d(TAG, "****end fetch fail,fetcherMaker is null or rawky or filekey or originurl is null");
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        try {
            this.rawKey = str;
            this.fileKey = str2;
            this.oldURL = str3;
            AVMDLURLFetcherInterface fetcher = fetcherMaker.getFetcher(str, str2, str3);
            if (fetcher == null) {
                AVMDLLog.d(TAG, "****fail, get fetcher is null");
                return -1;
            }
            int iStart = fetcher.start(str, str2, str3, this);
            if (iStart > 0) {
                String[] uRLs = fetcher.getURLs();
                if (uRLs != null && uRLs.length != 0) {
                    if (this.handle != 0) {
                        this.newURL = uRLs[0];
                        AVMDLLog.d(TAG, "start notify result");
                        _notifyFetcherResult(this.handle, str, str2, uRLs[0]);
                        AVMDLLog.d(TAG, "end notify result");
                        i = 1;
                    }
                    this.lock.unlock();
                    AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "****call start end, result:%d", Integer.valueOf(i)));
                    return i;
                }
                AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "****end fail start ret:%d, but getURLs null", Integer.valueOf(iStart)));
                this.lock.unlock();
                return -2;
            }
            if (iStart < 0) {
                AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "****end fail start ret:%d, not need wait result", Integer.valueOf(iStart)));
                this.lock.unlock();
                return -3;
            }
            i = 0;
            this.lock.unlock();
            AVMDLLog.d(TAG, String.format(Locale.ENGLISH, "****call start end, result:%d", Integer.valueOf(i)));
            return i;
        } finally {
            this.lock.unlock();
        }
    }
}
