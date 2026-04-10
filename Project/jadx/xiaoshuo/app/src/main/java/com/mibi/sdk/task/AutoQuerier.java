package com.mibi.sdk.task;

import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.task.RxCountDown;

/* JADX INFO: loaded from: classes16.dex */
public class AutoQuerier {
    private static final String TAG = "AutoQuerier";
    private AutoQuerierCallback mAutoQuerierback;
    private RxCountDown.ICountDownListener mICountDownListener = new RxCountDown.ICountDownListener() { // from class: com.mibi.sdk.task.AutoQuerier.1
        @Override // com.mibi.sdk.task.RxCountDown.ICountDownListener
        public void onCompleted() {
            AutoQuerier.this.mAutoQuerierback.onProgressUpdate(AutoQuerier.this.mQueryIndex);
            AutoQuerier.access$008(AutoQuerier.this);
            AutoQuerier.this.mAutoQuerierback.onComplete();
        }

        @Override // com.mibi.sdk.task.RxCountDown.ICountDownListener
        public void onError() {
            MibiLog.d(AutoQuerier.TAG, "count down error");
            throw new IllegalStateException();
        }

        @Override // com.mibi.sdk.task.RxCountDown.ICountDownListener
        public void onProgress(long j) {
        }

        @Override // com.mibi.sdk.task.RxCountDown.ICountDownListener
        public void onStart() {
        }
    };
    private int mQueryIndex = 0;
    private int[] mQueryInterval;

    public interface AutoQuerierCallback {
        void onComplete();

        void onProgressUpdate(long j);

        void onStart();
    }

    public AutoQuerier(int[] iArr, AutoQuerierCallback autoQuerierCallback) {
        this.mQueryInterval = iArr;
        this.mAutoQuerierback = autoQuerierCallback;
    }

    public static /* synthetic */ int access$008(AutoQuerier autoQuerier) {
        int i = autoQuerier.mQueryIndex;
        autoQuerier.mQueryIndex = i + 1;
        return i;
    }

    public boolean hasNext() {
        return this.mQueryIndex < this.mQueryInterval.length;
    }

    public boolean query() {
        if (!hasNext()) {
            this.mAutoQuerierback.onComplete();
            return false;
        }
        if (this.mQueryIndex == 0) {
            this.mAutoQuerierback.onStart();
        }
        RxCountDown.getTask().start(this.mQueryInterval[this.mQueryIndex], this.mICountDownListener);
        return true;
    }
}
