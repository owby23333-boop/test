package com.arialyy.aria.core.task;

import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.config.BaseTaskConfig;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsThreadTaskAdapter implements IThreadTaskAdapter {
    protected String TAG = CommonUtil.getClassName((Class) getClass());
    private IThreadTaskObserver mObserver;
    protected BandwidthLimiter mSpeedBandUtil;
    private SubThreadConfig mThreadConfig;
    private ThreadRecord mThreadRecord;
    private IThreadTask mThreadTask;
    private AbsTaskWrapper mWrapper;

    protected AbsThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        this.mThreadRecord = subThreadConfig.record;
        this.mWrapper = subThreadConfig.taskWrapper;
        this.mThreadConfig = subThreadConfig;
        if (getTaskConfig().getMaxSpeed() > 0) {
            this.mSpeedBandUtil = new BandwidthLimiter(getTaskConfig().getMaxSpeed(), subThreadConfig.startThreadNum);
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void attach(IThreadTaskObserver iThreadTaskObserver) {
        this.mObserver = iThreadTaskObserver;
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void call(IThreadTask iThreadTask) throws Exception {
        this.mThreadTask = iThreadTask;
        handlerThreadTask();
    }

    protected void complete() {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateCompleteState();
        }
    }

    protected void fail(AriaException ariaException, boolean z2) {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateFailState(ariaException, z2);
        }
    }

    protected long getRangeProgress() {
        return this.mObserver.getThreadProgress();
    }

    protected BaseTaskConfig getTaskConfig() {
        return getTaskWrapper().getConfig();
    }

    protected AbsTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    protected SubThreadConfig getThreadConfig() {
        return this.mThreadConfig;
    }

    protected ThreadRecord getThreadRecord() {
        return this.mThreadRecord;
    }

    protected IThreadTask getThreadTask() {
        return this.mThreadTask;
    }

    protected abstract void handlerThreadTask();

    protected void progress(long j2) {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateProgress(j2);
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void setMaxSpeed(int i2) {
        if (this.mSpeedBandUtil == null) {
            this.mSpeedBandUtil = new BandwidthLimiter(getTaskConfig().getMaxSpeed(), getThreadConfig().startThreadNum);
        }
        this.mSpeedBandUtil.setMaxRate(i2);
    }
}
