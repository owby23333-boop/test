package k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import c.a;

/* JADX INFO: compiled from: C0027a.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public Context a;
    public c.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f20923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.a f20924d;

    /* JADX INFO: renamed from: k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: C0027a.java */
    public class ServiceConnectionC0570a implements ServiceConnection {
        public ServiceConnectionC0570a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.a c0075a;
            a aVar = a.this;
            int i2 = a.AbstractBinderC0074a.f2160s;
            if (iBinder == null) {
                c0075a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                c0075a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c.a)) ? new a.AbstractBinderC0074a.C0075a(iBinder) : (c.a) iInterfaceQueryLocalInterface;
            }
            aVar.b = c0075a;
            e.a aVar2 = a.this.f20924d;
            if (aVar2 != null) {
                aVar2.a(true);
            }
            a.this.getClass();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.this.b = null;
        }
    }

    public a(Context context, e.a aVar) {
        e.a aVar2;
        this.a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.f20924d = aVar;
        this.f20923c = new ServiceConnectionC0570a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.f20923c, 1) || (aVar2 = this.f20924d) == null) {
            return;
        }
        aVar2.d();
    }
}
