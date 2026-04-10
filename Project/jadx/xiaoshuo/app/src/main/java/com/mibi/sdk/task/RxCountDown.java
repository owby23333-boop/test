package com.mibi.sdk.task;

import com.mibi.sdk.rx.Emitter;
import com.mibi.sdk.rx.Observable;
import com.mibi.sdk.rx.Observer;
import com.mibi.sdk.rx.OnSubscribe;

/* JADX INFO: loaded from: classes16.dex */
public class RxCountDown {
    private CounterTask mCounterTask;
    private CountListener mInnerCountListener;

    public static class CountListener implements Observer<Integer> {
        private int mCount;
        private ICountDownListener mCountDownListener;
        private RxCountDown mRxCountDown;

        /* JADX INFO: Access modifiers changed from: private */
        public void startCount() {
            this.mCountDownListener.onStart();
            this.mCountDownListener.onProgress(0L);
        }

        @Override // com.mibi.sdk.rx.Observer
        public void onError(Throwable th) {
            this.mCountDownListener.onError();
        }

        private CountListener(int i, RxCountDown rxCountDown, ICountDownListener iCountDownListener) {
            this.mCount = i;
            this.mRxCountDown = rxCountDown;
            this.mCountDownListener = iCountDownListener;
        }

        @Override // com.mibi.sdk.rx.Observer
        public void onSuccess(Integer num) {
            if (num.intValue() >= this.mCount) {
                this.mCountDownListener.onCompleted();
                return;
            }
            Integer numValueOf = Integer.valueOf(num.intValue() + 1);
            this.mCountDownListener.onProgress(numValueOf.intValue());
            this.mRxCountDown.countInterval(numValueOf.intValue());
        }
    }

    public static class CounterTask implements OnSubscribe<Integer> {
        private static final int SLEEP_PEROID_MS = 1000;
        private int mCurrentTime;

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrentTime(int i) {
            this.mCurrentTime = i;
        }

        @Override // com.mibi.sdk.rx.OnSubscribe
        public void call(Emitter<? super Integer> emitter) {
            try {
                Thread.sleep(1000L);
                emitter.onSuccess(Integer.valueOf(this.mCurrentTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
                emitter.onError(e);
            }
        }

        private CounterTask() {
        }
    }

    public interface ICountDownListener {
        void onCompleted();

        void onError();

        void onProgress(long j);

        void onStart();
    }

    private RxCountDown() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countInterval(int i) {
        if (i == 0) {
            this.mInnerCountListener.startCount();
        }
        this.mCounterTask.setCurrentTime(i);
        Observable.create(this.mCounterTask).subscribe(this.mInnerCountListener);
    }

    public static RxCountDown getTask() {
        return new RxCountDown();
    }

    public void start(int i, ICountDownListener iCountDownListener) {
        this.mInnerCountListener = new CountListener(i, this, iCountDownListener);
        this.mCounterTask = new CounterTask();
        countInterval(0);
    }
}
