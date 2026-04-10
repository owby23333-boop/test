package com.baidu.tts.factory.base;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.umeng.message.proguard.ad;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class NameThreadFactory implements ThreadFactory {
    private static final String TAG = "NameThreadFactory";
    private int mCount;
    private String mName;

    public NameThreadFactory(String str) {
        this.mName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        this.mCount++;
        String str = this.mName + ad.f20405r + this.mCount + ad.f20406s;
        thread.setName(str);
        LoggerProxy.d(TAG, "threadName=" + str);
        return thread;
    }
}
