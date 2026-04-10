package n0.a.a.a.a.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IAdvertisingIdService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {
    boolean b(boolean z2) throws RemoteException;

    String getId() throws RemoteException;

    /* JADX INFO: renamed from: n0.a.a.a.a.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IAdvertisingIdService.java */
    public static abstract class AbstractBinderC0586a extends Binder implements a {

        /* JADX INFO: renamed from: n0.a.a.a.a.a.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IAdvertisingIdService.java */
        private static class C0587a implements a {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public static a f21265t;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private IBinder f21266s;

            C0587a(IBinder iBinder) {
                this.f21266s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21266s;
            }

            @Override // n0.a.a.a.a.a.a.a.a
            public boolean b(boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.f21266s.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0586a.a() != null) {
                        return AbstractBinderC0586a.a().b(z2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // n0.a.a.a.a.a.a.a.a
            public String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f21266s.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0586a.a() != null) {
                        return AbstractBinderC0586a.a().getId();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0587a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a a() {
            return C0587a.f21265t;
        }
    }
}
