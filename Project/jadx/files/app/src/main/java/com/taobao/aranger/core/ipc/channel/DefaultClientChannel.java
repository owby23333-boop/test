package com.taobao.aranger.core.ipc.channel;

import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.proxy.ClientServiceProxy;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultClientChannel extends BaseClientChannel {
    private final IClientService clientService;

    public DefaultClientChannel(IBinder iBinder) {
        this.clientService = ClientServiceProxy.getProxy(iBinder);
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        try {
            this.clientService.recycle(list);
        } catch (Exception e2) {
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            }
            if (!(e2 instanceof RemoteException)) {
                throw new IPCException(9, e2);
            }
            throw new IPCException(27, e2);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.BaseClientChannel
    public Reply internalSendCallback(Callback callback) throws IPCException {
        try {
            return this.clientService.sendCallback(callback);
        } catch (Exception e2) {
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            }
            if (e2 instanceof RemoteException) {
                throw new IPCException(2, e2);
            }
            throw new IPCException(9, e2);
        }
    }
}
