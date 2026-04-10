package com.bykv.vk.component.ttvideo.mediakit.net;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    private static native void _notifyParserResultV2(long j, String str, String str2, long j2, String str3, int i);

    public int start(long j, String str) {
        int i = v2Usable ? parserResult(j, str, 2) : 0;
        return i <= 0 ? parserResult(j, str, 1) : i;
    }

    private int parserResult(long j, String str, int i) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        boolean z2 = true;
        int i2 = 0;
        AVMDLDNSParserBridge aVMDLDNSParserBridge = null;
        try {
            try {
                this.host = str;
                AVMDLDNSInfo aVMDLDNSInfo = IPCache.getInstance().get(str);
                if (aVMDLDNSInfo != null) {
                    this.ipList = aVMDLDNSInfo.mIpList;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String.format("get result from cache expiredT:%d curT:%d ", Long.valueOf(aVMDLDNSInfo.mExpiredTime), Long.valueOf(jCurrentTimeMillis));
                    if (aVMDLDNSInfo.mExpiredTime <= jCurrentTimeMillis) {
                        String.format("cache has expired need try call but not need listener", new Object[0]);
                        z = true;
                    } else {
                        z = false;
                    }
                    try {
                        long j2 = this.handle;
                        if (j2 != 0) {
                            if (i == 1) {
                                v2Usable = false;
                                _notifyParserResult(j2, str, this.ipList, aVMDLDNSInfo.mExpiredTime, null);
                            } else {
                                v2Usable = true;
                                _notifyParserResultV2(j2, str, this.ipList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
                            }
                        }
                        i2 = 1;
                        z2 = z;
                    } catch (UnsatisfiedLinkError e) {
                        e = e;
                        z2 = z;
                        AVMDLLog.e(TAG, e.toString());
                        if (v2Usable) {
                            v2Usable = false;
                        }
                    }
                } else {
                    aVMDLDNSParserBridge = this;
                }
            } finally {
                this.lock.unlock();
            }
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
        }
        if (z2) {
            String.format("call add host to parser listener:%s", aVMDLDNSParserBridge);
            AVMDLDNSParser.getInstance().addHost(str, aVMDLDNSParserBridge);
        }
        String.format("****call start end, listener:%s", aVMDLDNSParserBridge);
        return i2;
    }

    boolean isFinish() {
        return this.isFinish;
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.ipList;
        } finally {
            this.lock.unlock();
        }
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        if (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) {
            return null;
        }
        return backUpIp.mIpList;
    }

    public void release() {
        String.format("----start release:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("remove host:%s", this.host);
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parserResult(int r17, java.lang.String r18, java.lang.String r19, long r20, java.lang.String r22, int r23, int r24) {
        /*
            r16 = this;
            r1 = r16
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.lock()
            r0 = 0
            boolean r2 = r1.isFinish     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L8f
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r6 = "receive completion code:%d result:%s type:%d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r0] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            boolean r7 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r7 == 0) goto L24
            java.lang.String r7 = "null"
            goto L26
        L24:
            r7 = r19
        L26:
            r3[r5] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r23)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r4] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            boolean r2 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r6 = 0
            if (r2 == 0) goto L65
            r2 = 5
            int r2 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getIntValue(r2)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r2 != r5) goto L65
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r2 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3 = r18
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r2 = r2.getBackUpIp(r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            if (r2 == 0) goto L67
            java.lang.String r8 = r2.mIpList     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            int r2 = r2.mType     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r10 = "get backup ip, result:%s type:%d"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r11[r0] = r8     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r11[r5] = r12     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r15 = r2
            r12 = r6
            r11 = r8
            goto L6d
        L65:
            r3 = r18
        L67:
            r11 = r19
            r12 = r20
            r15 = r23
        L6d:
            r1.ipList = r11     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r1.isFinish = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            long r8 = r1.handle     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto La6
            r2 = r24
            if (r2 != r4) goto L85
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r10 = r18
            r14 = r22
            _notifyParserResultV2(r8, r10, r11, r12, r14, r15)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            goto La6
        L85:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r10 = r18
            r14 = r22
            _notifyParserResult(r8, r10, r11, r12, r14)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            goto La6
        L8f:
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String r6 = "has finished not nedd cur completion code:%d result:%s expiredTime:%d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r0] = r7     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r5] = r19     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.Long r5 = java.lang.Long.valueOf(r20)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> Lac java.lang.UnsatisfiedLinkError -> Lae
        La6:
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.unlock()
            return
        Lac:
            r0 = move-exception
            goto Lb7
        Lae:
            boolean r2 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto Lb4
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> Lac
        Lb4:
            r1.isFinish = r0     // Catch: java.lang.Throwable -> Lac
            goto La6
        Lb7:
            java.util.concurrent.locks.Lock r2 = r1.lock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(int, java.lang.String, java.lang.String, long, java.lang.String, int, int):void");
    }
}
