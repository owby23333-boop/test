package com.xiaomi.ad.mediation.internal.loader.load;

import com.xiaomi.ad.common.util.ExecutorUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.mediation.MMAdCombinedError;
import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.internal.loader.AdBaseTask;
import java.util.Collections;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class AdSerialLoadTaskGroup extends AdLoadTaskGroup implements AdBaseTask.AdTaskListener {
    public static final String TAG = "AdSerialLoadTaskGroup";
    public AdBaseTask.AdTaskListener mAdTaskListener;
    public AdLoadBaseTask mCurrentTask;
    public MMAdCombinedError mError;
    public boolean mTaskTimeOut;
    public Future mTimeOut;

    public AdSerialLoadTaskGroup(int i) {
        super(i);
        this.mTaskTimeOut = true;
    }

    private void cancelAllRunTask() {
        if (this.mCurrentTask != null) {
            MLog.d(TAG, " Serial cancel serial load Task   : " + this.mCurrentTask.mADInfoFlag + " priority =" + this.mCurrentTask.mPriority);
            this.mCurrentTask.cancel();
        }
    }

    private void cancleTimeOutRunable() {
        Future future = this.mTimeOut;
        if (future != null) {
            future.cancel(true);
        }
        this.mTaskTimeOut = false;
    }

    private void executeNextTask() {
        AdLoadBaseTask adLoadBaseTask = this.mTasks.get(0);
        this.mCurrentTask = adLoadBaseTask;
        if (adLoadBaseTask != null) {
            adLoadBaseTask.execute(this);
            MLog.d(TAG, "Start to execute next task in serial task group ，task priority -> " + this.mCurrentTask.mPriority);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serialLoadTaskTimeOut() {
        cancelAllRunTask();
        if (this.mAdTaskListener != null) {
            MLog.d(TAG, "Serial task load time out ,no dsp load success, notify load fail");
            this.mAdTaskListener.onExecuteFail(this, new MMAdError(-200));
        }
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.load.AdLoadBaseTask
    public void execute(AdBaseTask.AdTaskListener adTaskListener) {
        MLog.d(TAG, "Start serial task group");
        if (this.mCurrentTask != null || this.mTasks.isEmpty()) {
            AdBaseTask.AdTaskListener adTaskListener2 = this.mAdTaskListener;
            if (adTaskListener2 != null) {
                adTaskListener2.onExecuteFail(this, new MMAdError(MMAdError.LOAD_GENERATE_ERROR));
                return;
            }
            return;
        }
        this.mTimeOut = ExecutorUtils.WORKING_EXECUTOR.schedule(new Runnable() { // from class: com.xiaomi.ad.mediation.internal.loader.load.AdSerialLoadTaskGroup.1
            @Override // java.lang.Runnable
            public void run() {
                if (AdSerialLoadTaskGroup.this.mTaskTimeOut) {
                    AdSerialLoadTaskGroup.this.serialLoadTaskTimeOut();
                }
            }
        }, this.TASKTIMEOUT, TimeUnit.MILLISECONDS);
        Collections.sort(this.mTasks);
        this.mError = new MMAdCombinedError(-300);
        this.mAdTaskListener = adTaskListener;
        executeNextTask();
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.AdBaseTask.AdTaskListener
    public void onExecuteFail(AdBaseTask adBaseTask, MMAdError mMAdError) {
        this.mTasks.remove(adBaseTask);
        MMAdCombinedError mMAdCombinedError = this.mError;
        if (mMAdCombinedError != null) {
            mMAdCombinedError.addError(mMAdError);
        }
        if (!this.mTasks.isEmpty()) {
            MLog.w(TAG, "Failed to load one dsp in serial task group, error : " + mMAdError.toString());
            executeNextTask();
            return;
        }
        MLog.w(TAG, "Failed to execute serial task group, error : " + mMAdError.toString());
        cancleTimeOutRunable();
        AdBaseTask.AdTaskListener adTaskListener = this.mAdTaskListener;
        if (adTaskListener != null) {
            adTaskListener.onExecuteFail(this, this.mError);
        }
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.AdBaseTask.AdTaskListener
    public void onExecuteSuccess(AdBaseTask adBaseTask) {
        MLog.d(TAG, "Success to execute serial task group");
        this.mTasks.remove(adBaseTask);
        StringBuilder sb = new StringBuilder();
        sb.append("remove task  priority");
        sb.append(adBaseTask != null ? adBaseTask.getPriority() : 0);
        MLog.d(TAG, sb.toString());
        AdBaseTask.AdTaskListener adTaskListener = this.mAdTaskListener;
        if (adTaskListener != null) {
            adTaskListener.onExecuteSuccess(this);
        }
        cancleTimeOutRunable();
    }
}
