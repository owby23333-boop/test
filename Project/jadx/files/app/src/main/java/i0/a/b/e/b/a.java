package i0.a.b.e.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import i0.a.b.e.a.a;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f20866e = false;
    private i0.a.b.e.a.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ServiceConnection f20867c;
    private Context a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f20868d = null;

    /* JADX INFO: renamed from: i0.a.b.e.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpenDeviceId.java */
    class ServiceConnectionC0569a implements ServiceConnection {
        ServiceConnectionC0569a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.b = a.AbstractBinderC0567a.a(iBinder);
            if (a.this.f20868d != null) {
                a.this.f20868d.a("Deviceid Service Connected", a.this);
            }
            a.this.a("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.this.b = null;
            a.this.a("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: compiled from: OpenDeviceId.java */
    public interface b<T> {
        void a(T t2, a aVar);
    }

    public boolean b() {
        try {
            if (this.b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public int a(Context context, b<String> bVar) {
        if (context != null) {
            this.a = context;
            this.f20868d = bVar;
            this.f20867c = new ServiceConnectionC0569a();
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.a.bindService(intent, this.f20867c, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        boolean z2 = f20866e;
    }

    public String a() {
        if (this.a != null) {
            try {
                if (this.b != null) {
                    return this.b.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        boolean z2 = f20866e;
    }
}
