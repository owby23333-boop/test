package ho;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ho.k;

/* JADX INFO: loaded from: classes8.dex */
public abstract class o extends Binder implements IInterface {
    public o() {
        attachInterface(this, "com.xiaomi.mirror.IRelayCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.xiaomi.mirror.IRelayCallback");
            if (u.this.f21130b != null) {
                j.a("RH", "onRelayEnable", (Object[]) null);
            }
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface("com.xiaomi.mirror.IRelayCallback");
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            a aVar = u.this.f21130b;
            if (aVar != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                ((k.a) aVar).a(bundle);
            }
            return true;
        }
        if (i != 3) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.xiaomi.mirror.IRelayCallback");
            return true;
        }
        parcel.enforceInterface("com.xiaomi.mirror.IRelayCallback");
        if (u.this.f21130b != null) {
            j.a("RH", "onRelayDisable", (Object[]) null);
        }
        return true;
    }
}
