package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.fv;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.js;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.pf;
import com.bytedance.sdk.openadsdk.core.v;

/* JADX INFO: loaded from: classes2.dex */
public interface ls extends IInterface {
    Bundle g(String str, String str2, Bundle bundle) throws RemoteException;

    void g(String str, js jsVar) throws RemoteException;

    void g(String str, String str2) throws RemoteException;

    void z(String str, int i) throws RemoteException;

    void z(String str, fv fvVar) throws RemoteException;

    void z(String str, i iVar) throws RemoteException;

    void z(String str, js jsVar) throws RemoteException;

    void z(String str, p pVar) throws RemoteException;

    void z(String str, pf pfVar) throws RemoteException;

    void z(String str, v vVar) throws RemoteException;

    void z(String str, String str2) throws RemoteException;

    void z(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException;

    void z(String str, String str2, Bundle bundle) throws RemoteException;

    public static abstract class z extends Binder implements ls {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public z() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IListenerManager");
        }

        public static ls z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ls)) {
                return (ls) iInterfaceQueryLocalInterface;
            }
            return new C0185z(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IListenerManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), fv.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), pf.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), js.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    g(parcel.readString(), js.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), i.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), v.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    g(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    z(parcel.readString(), p.z.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    Bundle bundleG = g(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleG != null) {
                        parcel2.writeInt(1);
                        bundleG.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ls$z$z, reason: collision with other inner class name */
        private static class C0185z implements ls {
            public static ls z;
            private IBinder g;

            C0185z(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.g;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, fv fvVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(fvVar != null ? fvVar.asBinder() : null);
                    if (!this.g.transact(1, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, fvVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(2, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, str2, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, pf pfVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(pfVar != null ? pfVar.asBinder() : null);
                    if (!this.g.transact(3, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, pfVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(4, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, js jsVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    if (!this.g.transact(5, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, jsVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void g(String str, js jsVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(jsVar != null ? jsVar.asBinder() : null);
                    if (!this.g.transact(6, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().g(str, jsVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, String str2, long j, long j2, String str3, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.g.transact(7, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, str2, j, j2, str3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, i iVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (!this.g.transact(8, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, iVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (!this.g.transact(9, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, v vVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    if (!this.g.transact(10, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, vVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void g(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.g.transact(11, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().g(str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public void z(String str, p pVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (!this.g.transact(12, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        z.z().z(str, pVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ls
            public Bundle g(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.g.transact(13, parcelObtain, parcelObtain2, 0) && z.z() != null) {
                        return z.z().g(str, str2, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ls z() {
            return C0185z.z;
        }
    }
}
