package ho;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ho.k;
import ho.p;

/* JADX INFO: loaded from: classes8.dex */
public interface s extends IInterface {

    public static abstract class a extends Binder implements s {
        public a() {
            attachInterface(this, "com.xiaomi.mirror.ISynergyCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ho.a aVar;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.xiaomi.mirror.ISynergyCallback");
                return true;
            }
            parcel.enforceInterface("com.xiaomi.mirror.ISynergyCallback");
            int i3 = parcel.readInt();
            p.a aVar2 = (p.a) this;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 && (aVar = p.this.f21122b) != null) {
                        ((k.a) aVar).a(new Bundle());
                    }
                } else if (p.this.f21122b != null) {
                    j.a("RH", "onRelayEnable", (Object[]) null);
                }
            } else if (p.this.f21122b != null) {
                j.a("RH", "onRelayDisable", (Object[]) null);
            }
            return true;
        }
    }
}
