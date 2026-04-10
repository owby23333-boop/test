package com.xiaomi.ad.mediation.internal.loader.load;

import com.xiaomi.ad.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdLoadTaskGroup extends AdLoadBaseTask {
    public long TASKTIMEOUT;
    public int adCount;
    public boolean isBid;
    public s mAdCacheItem;
    public List<AdLoadBaseTask> mTasks;

    public AdLoadTaskGroup(int i) {
        super(i);
        this.TASKTIMEOUT = 30000L;
        this.isBid = false;
        this.mTasks = new ArrayList();
    }

    public void addTask(AdLoadBaseTask adLoadBaseTask) {
        this.mTasks.add(adLoadBaseTask);
    }

    public s getAdCacheItem() {
        return this.mAdCacheItem;
    }

    public int getAdCount() {
        return this.adCount;
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.AdBaseTask
    public boolean isBid() {
        return this.isBid;
    }

    public boolean isTaskEmpty() {
        return this.mTasks.isEmpty();
    }

    public void setAdCacheItem(s sVar) {
        this.mAdCacheItem = sVar;
    }

    public void setAdCount(int i) {
        this.adCount = i;
    }

    @Override // com.xiaomi.ad.mediation.internal.loader.AdBaseTask
    public void setBid(boolean z) {
        this.isBid = z;
    }

    public void setTasktimeout(long j) {
        this.TASKTIMEOUT = j;
    }
}
