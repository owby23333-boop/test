package com.liulishuo.filedownloader.f0;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.f0.a;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* JADX INFO: compiled from: IFileDownloadIPCService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {
    long a(int i2) throws RemoteException;

    void a(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException;

    void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException;

    void b(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException;

    boolean b(int i2) throws RemoteException;

    boolean b(String str, String str2) throws RemoteException;

    boolean c(int i2) throws RemoteException;

    long e(int i2) throws RemoteException;

    void f() throws RemoteException;

    byte getStatus(int i2) throws RemoteException;

    boolean isIdle() throws RemoteException;

    boolean pause(int i2) throws RemoteException;

    void pauseAllTasks() throws RemoteException;

    void startForeground(int i2, Notification notification) throws RemoteException;

    void stopForeground(boolean z2) throws RemoteException;

    /* JADX INFO: compiled from: IFileDownloadIPCService.java */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0489a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    b(a.AbstractBinderC0487a.a(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    a(a.AbstractBinderC0487a.a(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zB = b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? FileDownloadHeader.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zPause = pause(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPause ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    pauseAllTasks();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zB2 = b(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zB2 ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    long jE = e(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jE);
                    return true;
                case 9:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    long jA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jA);
                    return true;
                case 10:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    byte status = getStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(status);
                    return true;
                case 11:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zIsIdle = isIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsIdle ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean zC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    f();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.liulishuo.filedownloader.f0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IFileDownloadIPCService.java */
        private static class C0489a implements b {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f17202s;

            C0489a(IBinder iBinder) {
                this.f17202s = iBinder;
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public void a(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f17202s.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f17202s;
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public void b(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f17202s.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public byte getStatus(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    this.f17202s.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public boolean pause(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    this.f17202s.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public void pauseAllTasks() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f17202s.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public void stopForeground(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.f17202s.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.f0.b
            public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i5 = 1;
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    if (fileDownloadHeader != null) {
                        parcelObtain.writeInt(1);
                        fileDownloadHeader.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z4) {
                        i5 = 0;
                    }
                    parcelObtain.writeInt(i5);
                    this.f17202s.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
