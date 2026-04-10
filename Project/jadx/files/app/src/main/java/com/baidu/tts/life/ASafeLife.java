package com.baidu.tts.life;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ASafeLife implements ILife {
    private static final String TAG = "ASafeLife";
    protected final Lock mStateLock = new ReentrantLock();
    protected final Condition mPauseCondition = this.mStateLock.newCondition();

    public interface OnPauseBeforeBlockListener {
        void onPause();
    }

    public void blockUntilAwakeFromPause(OnPauseBeforeBlockListener onPauseBeforeBlockListener) throws InterruptedException {
        try {
            this.mStateLock.lock();
            if (onPauseBeforeBlockListener != null) {
                onPauseBeforeBlockListener.onPause();
            }
            LoggerProxy.d(TAG, "before await");
            this.mPauseCondition.await();
            LoggerProxy.d(TAG, "after await");
        } finally {
            this.mStateLock.unlock();
        }
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized TtsError create() {
        return safeCreate();
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void destroy() {
        safeDestroy();
    }

    public void ifIsPausedThenBlockUntilAwake(OnPauseBeforeBlockListener onPauseBeforeBlockListener) throws InterruptedException {
        while (isPaused()) {
            blockUntilAwakeFromPause(onPauseBeforeBlockListener);
        }
    }

    public void interruptThread() {
        Thread.currentThread().interrupt();
    }

    public boolean isNeedToNotify() {
        try {
            ifIsPausedThenBlockUntilAwake(null);
        } catch (InterruptedException unused) {
            interruptThread();
        }
        return !isStopped();
    }

    public abstract boolean isPaused();

    public abstract boolean isStopped();

    @Override // com.baidu.tts.life.ILife
    public synchronized void pause() {
        safePause();
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void resume() {
        Lock lock;
        safeResume();
        try {
            try {
                this.mStateLock.lock();
                this.mPauseCondition.signalAll();
                lock = this.mStateLock;
            } catch (Exception e2) {
                e2.printStackTrace();
                lock = this.mStateLock;
            }
            lock.unlock();
        } finally {
        }
    }

    protected abstract TtsError safeCreate();

    protected abstract void safeDestroy();

    protected abstract void safePause();

    protected abstract void safeResume();

    protected abstract void safeStart();

    protected abstract void safeStop();

    @Override // com.baidu.tts.life.ILife
    public synchronized void start() {
        safeStart();
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void stop() {
        safeStop();
    }
}
