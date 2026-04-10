package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TimeOutEnum;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class BasicHandler<T> {
    private static final String TAG = "BasicHandler";
    private FutureTask<T> mFutureTask;

    public BasicHandler(FutureTask<T> futureTask) {
        this.mFutureTask = futureTask;
    }

    public boolean cancel() {
        return this.mFutureTask.cancel(true);
    }

    public T get() {
        try {
            LoggerProxy.d(TAG, "before get");
            return this.mFutureTask.get(TimeOutEnum.DEFAULT.getMillSeconds(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            LoggerProxy.d(TAG, e2.toString());
            return null;
        } catch (ExecutionException e3) {
            LoggerProxy.d(TAG, e3.getCause().toString());
            return null;
        } catch (TimeoutException e4) {
            LoggerProxy.d(TAG, e4.toString());
            return null;
        }
    }

    public void start() {
        Thread thread = new Thread(this.mFutureTask);
        thread.setName("bdtts-BasicHandler");
        thread.start();
    }
}
