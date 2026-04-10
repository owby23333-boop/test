package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.mit.IPCMonitor;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRemoteChannel implements IChannel {
    private void commitIPCState(IPCMonitor.IpcState ipcState, IPCException iPCException, long j2, long j3) throws IPCException {
        ipcState.setResult(iPCException != null ? iPCException.getErrorCode() : 0);
        ipcState.setDegrade(MixRemoteChannel.isDegrade);
        ipcState.setCostTime(System.currentTimeMillis() - (j2 + j3));
        ipcState.setInvokeTime(j3);
        ipcState.commit();
        if (iPCException != null) {
            throw iPCException;
        }
    }

    public final void connect() throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(6);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            internalConnect();
            e = null;
        } catch (IPCException e2) {
            e = e2;
        }
        commitIPCState(ipcState, e, jCurrentTimeMillis, 0L);
    }

    abstract void internalConnect() throws IPCException;

    abstract Reply internalSendCall(Call call) throws IPCException;

    public final void recycleRemote(List<String> list) throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(4);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            internalRecycle(list);
            e = null;
        } catch (IPCException e2) {
            e = e2;
        }
        commitIPCState(ipcState, e, jCurrentTimeMillis, 0L);
    }

    public final Reply sendCall(Call call) throws IPCException {
        IPCMonitor.IpcState ipcState;
        Reply replyInternalSendCall;
        long j2;
        IPCException iPCException;
        Reply reply;
        int type = call.getObjectWrapper().getType();
        if (type == 0) {
            ipcState = new IPCMonitor.IpcState(0);
        } else if (type != 1) {
            ipcState = new IPCMonitor.IpcState(2);
            ipcState.setMethodName(call.getMethodWrapper().getName());
        } else {
            ipcState = new IPCMonitor.IpcState(1);
            ipcState.setMethodName(call.getMethodWrapper().getName());
        }
        IPCMonitor.IpcState ipcState2 = ipcState;
        ipcState2.setServiceName(call.getObjectWrapper().getName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long invokeTime = 0;
        try {
            replyInternalSendCall = internalSendCall(call);
            try {
                ipcState2.setDataSize(call.getDataSize());
                invokeTime = replyInternalSendCall.getInvokeTime();
                j2 = invokeTime;
                reply = replyInternalSendCall;
                iPCException = replyInternalSendCall.isError() ? new IPCException(replyInternalSendCall.getErrorCode(), replyInternalSendCall.getErrorMessage()) : null;
            } catch (IPCException e2) {
                e = e2;
                j2 = invokeTime;
                Reply reply2 = replyInternalSendCall;
                iPCException = e;
                reply = reply2;
            }
        } catch (IPCException e3) {
            e = e3;
            replyInternalSendCall = null;
        }
        commitIPCState(ipcState2, iPCException, jCurrentTimeMillis, j2);
        return reply;
    }
}
