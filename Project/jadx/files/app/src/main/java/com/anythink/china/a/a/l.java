package com.anythink.china.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends IInterface {

    public static class a implements l {
        private IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.anythink.china.a.a.l
        public final String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return null;
                }
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.china.a.a.l
        public final String b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return null;
                }
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    String a();

    String b();
}
