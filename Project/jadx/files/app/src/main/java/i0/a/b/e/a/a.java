package i0.a.b.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceidInterface.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: i0.a.b.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static abstract class AbstractBinderC0567a extends Binder implements a {

        /* JADX INFO: renamed from: i0.a.b.e.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceidInterface.java */
        private static class C0568a implements a {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f20865s;

            C0568a(IBinder iBinder) {
                this.f20865s = iBinder;
            }

            @Override // i0.a.b.e.a.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    this.f20865s.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20865s;
            }

            @Override // i0.a.b.e.a.a
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    this.f20865s.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0568a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    String a() throws RemoteException;

    boolean c() throws RemoteException;
}
