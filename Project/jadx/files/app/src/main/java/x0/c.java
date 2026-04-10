package x0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import s0.a;

/* JADX INFO: compiled from: o_c.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements ServiceConnection {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f21743s;

    public c(b bVar) {
        this.f21743s = bVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        s0.a c0597a;
        b bVar = this.f21743s;
        int i2 = a.AbstractBinderC0596a.f21697s;
        if (iBinder == null) {
            c0597a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            c0597a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s0.a)) ? new a.AbstractBinderC0596a.C0597a(iBinder) : (s0.a) iInterfaceQueryLocalInterface;
        }
        bVar.a = c0597a;
        synchronized (this.f21743s.f21741d) {
            this.f21743s.f21741d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f21743s.a = null;
    }
}
