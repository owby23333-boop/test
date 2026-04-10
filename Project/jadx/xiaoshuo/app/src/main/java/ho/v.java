package ho;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ho.s;

/* JADX INFO: loaded from: classes8.dex */
public interface v extends IInterface {

    public static abstract class a extends Binder implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f21133a = 0;

        /* JADX INFO: renamed from: ho.v$a$a, reason: collision with other inner class name */
        public static class C0801a implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f21134a;

            public C0801a(IBinder iBinder) {
                this.f21134a = iBinder;
            }

            @Override // ho.v
            public final void a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.mirror.ISynergyService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.f21134a.transact(5, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f21133a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f21134a;
            }

            @Override // ho.v
            public final void b(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.mirror.ISynergyService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.f21134a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f21133a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // ho.v
            public final void c(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.mirror.ISynergyService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.f21134a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f21133a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // ho.v
            public final void a(String str, s sVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.mirror.ISynergyService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(sVar != null ? (s.a) sVar : null);
                    if (!this.f21134a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f21133a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void a(Bundle bundle);

    void a(String str, s sVar);

    void b(Bundle bundle);

    void c(Bundle bundle);
}
