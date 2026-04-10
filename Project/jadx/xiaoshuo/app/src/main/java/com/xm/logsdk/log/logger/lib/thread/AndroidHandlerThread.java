package com.xm.logsdk.log.logger.lib.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes8.dex */
public class AndroidHandlerThread<T> implements IMessageThread<T> {
    private static int EVENT_DO_MSG = 100;
    private IMsgCallback<T> mCallback = null;
    private Handler mHandler;

    public AndroidHandlerThread(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper()) { // from class: com.xm.logsdk.log.logger.lib.thread.AndroidHandlerThread.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (AndroidHandlerThread.this.mCallback != null) {
                    try {
                        AndroidHandlerThread.this.mCallback.handleMessage(message.obj);
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    @Override // com.xm.logsdk.log.logger.lib.thread.IMessageThread
    public void doMessage(T t) {
        doMessage(t, EVENT_DO_MSG);
    }

    public Looper getLooper() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return null;
        }
        return handler.getLooper();
    }

    public void quitSafely() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.getLooper().quitSafely();
    }

    @Override // com.xm.logsdk.log.logger.lib.thread.IMessageThread
    public void setCallback(IMsgCallback<T> iMsgCallback) {
        this.mCallback = iMsgCallback;
    }

    public void doMessage(T t, int i) {
        this.mHandler.sendMessage(Message.obtain(this.mHandler, i, t));
    }
}
