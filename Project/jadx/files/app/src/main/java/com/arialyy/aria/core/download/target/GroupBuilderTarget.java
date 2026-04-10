package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.HttpOption;
import com.arialyy.aria.core.download.AbsGroupTaskWrapper;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.manager.SubTaskManager;
import com.arialyy.aria.util.ALog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupBuilderTarget extends AbsBuilderTarget<GroupBuilderTarget> {
    private HttpGroupConfigHandler<GroupBuilderTarget> mConfigHandler = new HttpGroupConfigHandler<>(this, -1);

    GroupBuilderTarget(List<String> list) {
        this.mConfigHandler.setGroupUrl(list);
        getTaskWrapper().setRequestType(2);
        getTaskWrapper().setNewTask(true);
    }

    public SubTaskManager getSubTaskManager() {
        return this.mConfigHandler.getSubTaskManager();
    }

    public GroupBuilderTarget ignoreTaskOccupy() {
        ((AbsGroupTaskWrapper) getTaskWrapper()).setIgnoreTaskOccupy(true);
        return this;
    }

    public GroupBuilderTarget option(HttpOption httpOption) {
        if (httpOption == null) {
            throw new NullPointerException("任务配置为空");
        }
        getTaskWrapper().getOptionParams().setParams(httpOption);
        return this;
    }

    public GroupBuilderTarget setDirPath(String str) {
        return this.mConfigHandler.setDirPath(str);
    }

    public GroupBuilderTarget setFileSize(long j2) {
        if (j2 <= 0) {
            ALog.e(this.TAG, "文件大小不能小于 0");
            return this;
        }
        if (getEntity().getFileSize() <= 1 || getEntity().getFileSize() != j2) {
            getEntity().setFileSize(j2);
        }
        return this;
    }

    public GroupBuilderTarget setGroupAlias(String str) {
        this.mConfigHandler.setGroupAlias(str);
        return this;
    }

    public GroupBuilderTarget setSubFileName(List<String> list) {
        return (GroupBuilderTarget) this.mConfigHandler.setSubFileName(list);
    }

    @Deprecated
    public GroupBuilderTarget setSubTaskFileName(List<String> list) {
        return setSubFileName(list);
    }

    public GroupBuilderTarget unknownSize() {
        ((DGTaskWrapper) getTaskWrapper()).setUnknownSize(true);
        return this;
    }
}
