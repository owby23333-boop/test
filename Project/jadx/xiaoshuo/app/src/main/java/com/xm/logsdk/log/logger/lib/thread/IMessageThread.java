package com.xm.logsdk.log.logger.lib.thread;

/* JADX INFO: loaded from: classes8.dex */
public interface IMessageThread<T> {
    void doMessage(T t);

    void setCallback(IMsgCallback<T> iMsgCallback);
}
