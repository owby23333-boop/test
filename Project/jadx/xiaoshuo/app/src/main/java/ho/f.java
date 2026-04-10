package ho;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ho.g;
import ho.h;

/* JADX INFO: loaded from: classes8.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f21107a = 0;

        /* JADX INFO: renamed from: ho.f$a$a, reason: collision with other inner class name */
        public static class C0800a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f21108a;

            public C0800a(IBinder iBinder) {
                this.f21108a = iBinder;
            }

            @Override // ho.f
            public final int a(d dVar, h hVar, g gVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.dist.handoff.IAppHandoffService");
                    parcelObtain.writeInt(1);
                    dVar.writeToParcel(parcelObtain, 0);
                    parcelObtain.writeStrongBinder(hVar != null ? (h.a) hVar : null);
                    parcelObtain.writeStrongBinder(gVar != null ? (g.a) gVar : null);
                    parcelObtain.writeInt(i);
                    if (!this.f21108a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.f21107a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f21108a;
            }

            @Override // ho.f
            public final void a(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.dist.handoff.IAppHandoffService");
                    parcelObtain.writeInt(i);
                    if (!this.f21108a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.f21107a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // ho.f
            public final void a(int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.dist.handoff.IAppHandoffService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f21108a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i4 = a.f21107a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // ho.f
            public final void a(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.dist.handoff.IAppHandoffService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f21108a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i = a.f21107a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    int a(d dVar, h hVar, g gVar, int i);

    void a(int i);

    void a(int i, int i2, int i3);

    void a(boolean z);
}
