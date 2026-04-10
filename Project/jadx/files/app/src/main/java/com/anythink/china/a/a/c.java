package com.anythink.china.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {
        static final int a = 1;
        static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f6329c = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

        /* JADX INFO: renamed from: com.anythink.china.a.a.c$a$a, reason: collision with other inner class name */
        private static class C0145a implements c {
            private IBinder a;

            C0145a(IBinder iBinder) {
                this.a = iBinder;
            }

            private static String c() {
                return a.f6329c;
            }

            @Override // com.anythink.china.a.a.c
            public final String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f6329c);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.anythink.china.a.a.c
            public final boolean b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f6329c);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f6329c);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f6329c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0145a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface(f6329c);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f6329c);
                return true;
            }
            parcel.enforceInterface(f6329c);
            boolean zB = b();
            parcel2.writeNoException();
            parcel2.writeInt(zB ? 1 : 0);
            return true;
        }
    }

    String a();

    boolean b();
}
