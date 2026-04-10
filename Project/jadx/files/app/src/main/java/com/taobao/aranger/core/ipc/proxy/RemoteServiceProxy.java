package com.taobao.aranger.core.ipc.proxy;

import android.os.IBinder;
import android.os.Parcel;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import com.taobao.aranger.intf.IRemoteService;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteServiceProxy implements IRemoteService {
    private static volatile IRemoteService sLocalRemoteService;
    private final IBinder mRemote;

    private RemoteServiceProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public static IRemoteService getProxy(IBinder iBinder) {
        if (iBinder.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null) {
            return new RemoteServiceProxy(iBinder);
        }
        if (sLocalRemoteService == null) {
            synchronized (RemoteServiceProxy.class) {
                if (sLocalRemoteService == null) {
                    sLocalRemoteService = new ARangerProvider();
                }
            }
        }
        return sLocalRemoteService;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public void connect() throws Exception {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.mRemote.transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public boolean isRemote() {
        return this.mRemote.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeStringList(list);
            this.mRemote.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public Reply sendCall(Call call) throws Exception {
        Parcel parcelObtain;
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain = !call.isOneWay() ? Parcel.obtain() : null;
        } catch (Throwable th) {
            th = th;
            parcelObtain = null;
        }
        try {
            call.writeToParcel(parcelObtain2, 0);
            this.mRemote.transact(0, parcelObtain2, parcelObtain, call.isOneWay() ? 1 : 0);
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
