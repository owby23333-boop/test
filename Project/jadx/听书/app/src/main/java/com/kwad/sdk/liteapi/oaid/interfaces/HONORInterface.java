package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;

/* JADX INFO: loaded from: classes4.dex */
public interface HONORInterface extends IInterface {
    void getBoos(HONORProxyInterface hONORProxyInterface);

    void getIDs(HONORProxyInterface hONORProxyInterface);

    public static class a extends Binder implements HONORInterface {
        private IBinder aGc;

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getIDs(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aGc.transact(2, parcelObtain, parcelObtain2, 0);
                LiteApiLogger.d("HONORDeviceIDHelper", "gets + " + this.aGc);
                parcelObtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getBoos(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aGc.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
