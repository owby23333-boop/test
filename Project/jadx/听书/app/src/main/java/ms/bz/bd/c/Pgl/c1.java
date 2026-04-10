package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements IInterface {
    public IBinder z;

    public c1(IBinder iBinder) {
        this.z = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.z;
    }
}
