package com.xiaomi.ad.mediation.internal.loader.loadandshow;

import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.mediation.MMAdCombinedError;
import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.internal.loader.AdBaseTask;
import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public class AdSerialLoadAndShowTaskGroup extends AdLoadAndShowTaskGroup implements AdBaseTask.AdTaskListener {
    public static final String TAG = "AdSerialLoadAndShowTaskGroup";
    public AdLoadAndShowInteractionListener mAdInteractionListener;
    public AdLoadAndShowBaseTask mCurrentTask;
    public MMAdCombinedError mError;
    public AdBaseTask.AdTaskListener mTaskListener;

    public AdSerialLoadAndShowTaskGroup(int i) {
        super(i);
    }

    private void executeNextTask() {
        MLog.d(TAG, "Start to execute next task in serial task group");
        AdLoadAndShowBaseTask adLoadAndShowBaseTask = this.mTasks.get(0);
        this.mCurrentTask = adLoadAndShowBaseTask;
        adLoadAndShowBaseTask.execute(this, this.mAdInteractionListener);
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.loadandshow.AdLoadAndShowBaseTask
    public <T extends AdLoadAndShowInteractionListener> void execute(AdBaseTask.AdTaskListener adTaskListener, T t) {
        if (this.mCurrentTask != null || this.mTasks.isEmpty()) {
            AdBaseTask.AdTaskListener adTaskListener2 = this.mTaskListener;
            if (adTaskListener2 != null) {
                adTaskListener2.onExecuteFail(this, new MMAdError(MMAdError.LOAD_GENERATE_ERROR));
                return;
            }
            return;
        }
        Collections.sort(this.mTasks);
        this.mError = new MMAdCombinedError(-300);
        this.mTaskListener = adTaskListener;
        this.mAdInteractionListener = t;
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
        AdBaseTask.AdTaskListener adTaskListener = this.mTaskListener;
        if (adTaskListener != null) {
            adTaskListener.onExecuteFail(adBaseTask, this.mError);
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
        AdBaseTask.AdTaskListener adTaskListener = this.mTaskListener;
        if (adTaskListener != null) {
            adTaskListener.onExecuteSuccess(adBaseTask);
        }
    }
}
