package com.xiaomi.ad.mediation.internal.loader.loadandshow;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdLoadAndShowTaskGroup extends AdLoadAndShowBaseTask {
    public List<AdLoadAndShowBaseTask> mTasks;

    public AdLoadAndShowTaskGroup(int i) {
        super(i);
        this.mTasks = new ArrayList();
    }

    public void addTask(AdLoadAndShowBaseTask adLoadAndShowBaseTask) {
        this.mTasks.add(adLoadAndShowBaseTask);
    }

    public boolean isTaskEmpty() {
        return this.mTasks.isEmpty();
    }
}
