package com.mibi.sdk.rx;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes15.dex */
public class Observable<Result> {
    private InnerRxTask<Result> mInnerRxTask;

    public static class InnerRxTask<Result> extends AsyncTask<Void, Void, Emitter<Result>> {
        private Observer<Result> mObserver;
        private OnSubscribe<Result> mOnSubscribe;

        /* JADX INFO: Access modifiers changed from: private */
        public void setObserver(Observer<Result> observer) {
            this.mObserver = observer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOnSubscribe(OnSubscribe<Result> onSubscribe) {
            this.mOnSubscribe = onSubscribe;
        }

        private InnerRxTask() {
        }

        @Override // android.os.AsyncTask
        public Emitter<Result> doInBackground(Void... voidArr) {
            Emitter<Result> emitter = new Emitter<>();
            this.mOnSubscribe.call(emitter);
            return emitter;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Emitter<Result> emitter) {
            if (this.mObserver == null) {
                return;
            }
            if (emitter.isSuccess()) {
                this.mObserver.onSuccess(emitter.getResult());
            } else {
                this.mObserver.onError(emitter.getThrowable());
            }
        }
    }

    private Observable(OnSubscribe<Result> onSubscribe) {
        InnerRxTask<Result> innerRxTask = new InnerRxTask<>();
        this.mInnerRxTask = innerRxTask;
        innerRxTask.setOnSubscribe(onSubscribe);
    }

    public static <Result> Observable<Result> create(OnSubscribe<Result> onSubscribe) {
        return new Observable<>(onSubscribe);
    }

    public final void subscribe(Observer<Result> observer) {
        this.mInnerRxTask.setObserver(observer);
        this.mInnerRxTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void subscribe() {
        this.mInnerRxTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
