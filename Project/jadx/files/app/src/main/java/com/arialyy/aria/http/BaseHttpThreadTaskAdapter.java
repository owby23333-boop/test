package com.arialyy.aria.http;

import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.task.AbsThreadTaskAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseHttpThreadTaskAdapter extends AbsThreadTaskAdapter {
    protected HttpTaskOption mTaskOption;

    protected BaseHttpThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
        this.mTaskOption = (HttpTaskOption) getTaskWrapper().getTaskOption();
    }

    protected AbsNormalEntity getEntity() {
        return (AbsNormalEntity) getTaskWrapper().getEntity();
    }

    protected String getFileName() {
        return getEntity().getFileName();
    }
}
