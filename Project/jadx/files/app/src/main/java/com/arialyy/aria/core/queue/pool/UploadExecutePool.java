package com.arialyy.aria.core.queue.pool;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.task.AbsTask;

/* JADX INFO: loaded from: classes2.dex */
public class UploadExecutePool<TASK extends AbsTask> extends BaseExecutePool<TASK> {
    @Override // com.arialyy.aria.core.queue.pool.BaseExecutePool
    protected int getMaxSize() {
        return AriaConfig.getInstance().getUConfig().getMaxTaskNum();
    }
}
