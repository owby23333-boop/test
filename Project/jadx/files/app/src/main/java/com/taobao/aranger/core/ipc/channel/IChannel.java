package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.exception.IPCException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
interface IChannel {
    void internalRecycle(List<String> list) throws IPCException;
}
