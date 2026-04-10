package com.xiaomi.ad.mediation.internal.loader;

import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.internal.DspWeight;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdBaseTask implements Comparable<AdBaseTask> {
    public String mADInfoFlag;
    public int mPriority;
    public boolean isCancelled = false;
    public List<DspWeight> mDspWeightList = new ArrayList();
    public boolean isBid = false;

    public interface AdTaskListener {
        void onExecuteFail(AdBaseTask adBaseTask, MMAdError mMAdError);

        void onExecuteSuccess(AdBaseTask adBaseTask);
    }

    public AdBaseTask(int i) {
        this.mPriority = i;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override // java.lang.Comparable
    public int compareTo(AdBaseTask adBaseTask) {
        return Integer.compare(adBaseTask.mPriority, this.mPriority);
    }

    public List<DspWeight> getDspWeightList() {
        return this.mDspWeightList;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isBid() {
        return this.isBid;
    }

    public void setBid(boolean z) {
        this.isBid = z;
    }

    public void setDspWeightList(List<DspWeight> list) {
        this.mDspWeightList = list;
    }
}
