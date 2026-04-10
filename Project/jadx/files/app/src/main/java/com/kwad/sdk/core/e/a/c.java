package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {

    public static final class a implements c {
        private IBinder ahq;

        public a(IBinder iBinder) {
            this.ahq = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ahq;
        }

        @Override // com.kwad.sdk.core.e.a.c
        public final String getOaid() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.ahq.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Exception unused) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return null;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
    }

    String getOaid();
}
