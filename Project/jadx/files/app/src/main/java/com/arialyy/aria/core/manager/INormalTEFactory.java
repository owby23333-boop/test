package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
interface INormalTEFactory<ENTITY extends AbsEntity, TASK_ENTITY extends AbsTaskWrapper<ENTITY>> {
    TASK_ENTITY create(long j2);
}
