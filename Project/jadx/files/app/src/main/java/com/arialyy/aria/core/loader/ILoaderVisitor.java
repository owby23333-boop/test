package com.arialyy.aria.core.loader;

import com.arialyy.aria.core.inf.IThreadStateManager;

/* JADX INFO: loaded from: classes2.dex */
public interface ILoaderVisitor {
    void addComponent(IThreadStateManager iThreadStateManager);

    void addComponent(IInfoTask iInfoTask);

    void addComponent(IRecordHandler iRecordHandler);

    void addComponent(IThreadTaskBuilder iThreadTaskBuilder);
}
