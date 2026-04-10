package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface yt extends IInterface {
    void z(int i, long j, boolean z2, float f, double d, String str);

    void z(int i, Bundle bundle);

    public static abstract class z extends Binder implements yt {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static yt z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof yt)) {
                return (yt) iInterfaceQueryLocalInterface;
            }
            return new C0066z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                z(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            z(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.yt$z$z, reason: collision with other inner class name */
        static class C0066z implements yt {
            public static yt z;
            private IBinder g;

            C0066z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.embedapplog.yt
            public void z(int i, long j, boolean z2, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(i, j, z2, f, d, str);
                    } else {
                        parcelObtain2.readException();
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.embedapplog.yt
            public void z(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(i, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static yt z() {
            return C0066z.z;
        }
    }
}
