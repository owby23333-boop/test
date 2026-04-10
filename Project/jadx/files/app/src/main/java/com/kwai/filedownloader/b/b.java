package com.kwai.filedownloader.b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.b.a;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.kwai.filedownloader.b.b$a$a, reason: collision with other inner class name */
        static class C0466a implements b {
            public static b aGR;
            private IBinder mRemote;

            C0466a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void HZ() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || a.Ia() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.Ia().HZ();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void a(com.kwai.filedownloader.b.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || a.Ia() == null) {
                        return;
                    }
                    a.Ia().a(aVar);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean ai(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().ai(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(com.kwai.filedownloader.b.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || a.Ia() == null) {
                        return;
                    }
                    a.Ia().b(aVar);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void b(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i5 = 1;
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    if (bVar != null) {
                        parcelObtain.writeInt(1);
                        bVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z4) {
                        i5 = 0;
                    }
                    parcelObtain.writeInt(i5);
                    try {
                        if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || a.Ia() == null) {
                            parcelObtain2.readException();
                        } else {
                            a.Ia().b(str, str2, z2, i2, i3, i4, z3, bVar, z4);
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cQ(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cQ(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cR(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cR(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final long cS(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cS(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cw(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cw(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final byte cx(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cx(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readByte();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean cy(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().cy(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final boolean isIdle() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && a.Ia() != null) {
                        return a.Ia().isIdle();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void pauseAllTasks() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || a.Ia() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.Ia().pauseAllTasks();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void startForeground(int i2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(i2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, parcelObtain, null, 1) || a.Ia() == null) {
                        return;
                    }
                    a.Ia().startForeground(i2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.kwai.filedownloader.b.b
            public final void stopForeground(boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(13, parcelObtain, null, 1) || a.Ia() == null) {
                        return;
                    }
                    a.Ia().stopForeground(z2);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        public static b Ia() {
            return C0466a.aGR;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0466a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    a(a.AbstractBinderC0464a.c(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    b(a.AbstractBinderC0464a.c(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean zAi = ai(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAi ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwai.filedownloader.c.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean zCw = cw(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCw ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    pauseAllTasks();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean zCQ = cQ(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCQ ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long jCR = cR(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jCR);
                    return true;
                case 9:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    long jCS = cS(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jCS);
                    return true;
                case 10:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    byte bCx = cx(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(bCx);
                    return true;
                case 11:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean zIsIdle = isIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsIdle ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean zCy = cy(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCy ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    HZ();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void HZ();

    void a(com.kwai.filedownloader.b.a aVar);

    boolean ai(String str, String str2);

    void b(com.kwai.filedownloader.b.a aVar);

    void b(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4);

    boolean cQ(int i2);

    long cR(int i2);

    long cS(int i2);

    boolean cw(int i2);

    byte cx(int i2);

    boolean cy(int i2);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i2, Notification notification);

    void stopForeground(boolean z2);
}
