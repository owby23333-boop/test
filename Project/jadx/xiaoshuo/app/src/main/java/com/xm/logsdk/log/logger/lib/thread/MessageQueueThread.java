package com.xm.logsdk.log.logger.lib.thread;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes8.dex */
public class MessageQueueThread<T> implements IMessageThread<T> {
    private MessageQueueThread<T>.DoMessageThread mDoMessageThread;
    private ArrayDeque<T> mQeque = new ArrayDeque<>();
    private Object mLock = new Object();
    private IMsgCallback<T> mCallback = null;

    public class DoMessageThread extends Thread {
        private boolean mRuning;

        public DoMessageThread(String str) {
            super(str);
            this.mRuning = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.mRuning) {
                synchronized (MessageQueueThread.this.mLock) {
                    Object objPoll = MessageQueueThread.this.mQeque.poll();
                    if (objPoll == null) {
                        try {
                            synchronized (MessageQueueThread.this.mLock) {
                                MessageQueueThread.this.mLock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (MessageQueueThread.this.mCallback != null) {
                        MessageQueueThread.this.mCallback.handleMessage(objPoll);
                    }
                }
            }
        }
    }

    public MessageQueueThread(String str) {
        this.mDoMessageThread = null;
        MessageQueueThread<T>.DoMessageThread doMessageThread = new DoMessageThread(str);
        this.mDoMessageThread = doMessageThread;
        doMessageThread.start();
    }

    @Override // com.xm.logsdk.log.logger.lib.thread.IMessageThread
    public void doMessage(T t) {
        synchronized (this.mLock) {
            this.mQeque.add(t);
            this.mLock.notifyAll();
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.thread.IMessageThread
    public void setCallback(IMsgCallback<T> iMsgCallback) {
        this.mCallback = iMsgCallback;
    }
}
