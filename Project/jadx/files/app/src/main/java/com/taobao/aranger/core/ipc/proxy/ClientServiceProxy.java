package com.taobao.aranger.core.ipc.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ClientServiceProxy extends Binder implements IClientService {
    private final IBinder mRemote;

    private ClientServiceProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public static IClientService getProxy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(Constants.CLIENT_SERVICE_DESCRIPTOR);
        return iInterfaceQueryLocalInterface instanceof IClientService ? (IClientService) iInterfaceQueryLocalInterface : new ClientServiceProxy(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        if (!this.mRemote.isBinderAlive()) {
            throw new IPCException(5, "the remote binder is not alive");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeStringList(list);
            this.mRemote.transact(4, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IClientService
    public Reply sendCallback(Callback callback) throws Exception {
        Parcel parcelObtain;
        if (!this.mRemote.isBinderAlive()) {
            throw new IPCException(5, "the remote binder is not alive");
        }
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain = !callback.isOneWay() ? Parcel.obtain() : null;
        } catch (Throwable th) {
            th = th;
            parcelObtain = null;
        }
        try {
            callback.writeToParcel(parcelObtain2, 0);
            this.mRemote.transact(3, parcelObtain2, parcelObtain, callback.isOneWay() ? 1 : 0);
            Reply result = (parcelObtain == null || parcelObtain.dataSize() == 0) ? Reply.obtain().setResult(null) : Reply.CREATOR.createFromParcel(parcelObtain);
            parcelObtain2.recycle();
            if (parcelObtain != null) {
                parcelObtain.recycle();
            }
            return result;
        } catch (Throwable th2) {
            th = th2;
            parcelObtain2.recycle();
            if (parcelObtain != null) {
                parcelObtain.recycle();
            }
            throw th;
        }
    }
}
