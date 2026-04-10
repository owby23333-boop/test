package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes9.dex */
public class f1 implements IInterface {
    public IBinder e;

    public f1(IBinder iBinder) {
        this.e = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.e;
    }
}
