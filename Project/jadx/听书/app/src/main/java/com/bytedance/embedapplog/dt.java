package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.embedapplog.yt;

/* JADX INFO: loaded from: classes2.dex */
public interface dt extends IInterface {
    void g(yt ytVar);

    void z(int i, long j, boolean z2, float f, double d, String str);

    void z(yt ytVar);

    public static abstract class z extends Binder implements dt {
        public static dt z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof dt)) {
                return (dt) iInterfaceQueryLocalInterface;
            }
            return new C0056z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                z(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                z(yt.z.z(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            g(yt.z.z(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.dt$z$z, reason: collision with other inner class name */
        static class C0056z implements dt {
            public static dt z;
            private IBinder g;

            C0056z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.embedapplog.dt
            public void z(int i, long j, boolean z2, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
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

            @Override // com.bytedance.embedapplog.dt
            public void z(yt ytVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(ytVar != null ? ytVar.asBinder() : null);
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(ytVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.dt
            public void g(yt ytVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(ytVar != null ? ytVar.asBinder() : null);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().g(ytVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static dt z() {
            return C0056z.z;
        }
    }
}
