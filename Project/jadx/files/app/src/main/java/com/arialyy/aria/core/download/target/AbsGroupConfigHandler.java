package com.arialyy.aria.core.download.target;

import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsNormalTarget;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.event.ErrorEvent;
import com.arialyy.aria.core.inf.AbsTarget;
import com.arialyy.aria.core.inf.IConfigHandler;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.task.DownloadGroupTask;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbsGroupConfigHandler<TARGET extends AbsTarget> implements IConfigHandler {
    protected String TAG = CommonUtil.getClassName((Class) getClass());
    private SubTaskManager mSubTaskManager;
    private TARGET mTarget;
    private DGTaskWrapper mWrapper;

    /* JADX WARN: Multi-variable type inference failed */
    AbsGroupConfigHandler(TARGET target, long j2) {
        this.mTarget = target;
        this.mWrapper = (DGTaskWrapper) TaskWrapperManager.getInstance().getGroupWrapper(DGTaskWrapper.class, j2);
        if (this.mTarget instanceof AbsNormalTarget) {
            if (j2 < 0) {
                this.mWrapper.setErrorEvent(new ErrorEvent(j2, "任务id为空"));
            } else if (((DownloadGroupEntity) this.mWrapper.getEntity()).getId() < 0) {
                this.mWrapper.setErrorEvent(new ErrorEvent(j2, "任务信息不存在"));
            }
        }
        this.mTarget.setTaskWrapper(this.mWrapper);
        if (getEntity() != null) {
            getTaskWrapper().setDirPathTemp(getEntity().getDirPath());
        }
    }

    SubTaskManager getSubTaskManager() {
        if (this.mSubTaskManager == null) {
            this.mSubTaskManager = new SubTaskManager(getTaskWrapper());
        }
        return this.mSubTaskManager;
    }

    TARGET getTarget() {
        return this.mTarget;
    }

    DGTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean isRunning() {
        DownloadGroupTask task = DGroupTaskQueue.getInstance().getTask(getEntity().getKey());
        return task != null && task.isRunning();
    }

    TARGET setDirPath(String str) {
        this.mWrapper.setDirPathTemp(str);
        return this.mTarget;
    }

    void setGroupAlias(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getEntity().setAlias(str);
    }

    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public boolean taskExists() {
        return getEntity().getId() != -1 && DbEntity.checkDataExist(DownloadGroupEntity.class, "rowid=?", String.valueOf(getEntity().getId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.arialyy.aria.core.inf.IConfigHandler
    public DownloadGroupEntity getEntity() {
        return (DownloadGroupEntity) this.mWrapper.getEntity();
    }
}
