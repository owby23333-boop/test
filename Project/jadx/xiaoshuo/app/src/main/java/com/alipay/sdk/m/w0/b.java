package com.alipay.sdk.m.w0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.v0.a;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String e = "OpenDeviceId library";
    public static boolean f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.v0.a f1974b;
    public ServiceConnection c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1973a = null;
    public InterfaceC0044b d = null;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f1974b = a.AbstractBinderC0041a.a(iBinder);
            if (b.this.d != null) {
                b.this.d.a("Deviceid Service Connected", b.this);
            }
            b.this.b("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f1974b = null;
            b.this.b("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.w0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0044b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.f1973a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.v0.a aVar = this.f1974b;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String c() {
        if (this.f1973a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.v0.a aVar = this.f1974b;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (RemoteException e2) {
            a("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            a("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public String d() {
        Context context = this.f1973a;
        if (context == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        b("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            com.alipay.sdk.m.v0.a aVar = this.f1974b;
            if (aVar != null) {
                return aVar.b(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            a("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean e() {
        try {
            if (this.f1974b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.f1974b.c();
        } catch (RemoteException unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.f1973a.unbindService(this.c);
            b("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.f1974b = null;
    }

    public int a(Context context, InterfaceC0044b<String> interfaceC0044b) {
        if (context != null) {
            this.f1973a = context;
            this.d = interfaceC0044b;
            this.c = new a();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f1973a.bindService(intent, this.c, 1)) {
                b("bindService Successful!");
                return 1;
            }
            b("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public final void b(String str) {
        if (f) {
            Log.i(e, str);
        }
    }

    public String a() {
        Context context = this.f1973a;
        if (context != null) {
            String packageName = context.getPackageName();
            b("liufeng, getAAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    com.alipay.sdk.m.v0.a aVar = this.f1974b;
                    if (aVar == null) {
                        return null;
                    }
                    String strA = aVar.a(packageName);
                    return ((strA == null || "".equals(strA)) && this.f1974b.c(packageName)) ? this.f1974b.a(packageName) : strA;
                } catch (RemoteException unused) {
                    a("getAAID error, RemoteException!");
                    return null;
                }
            }
            b("input package is null!");
            return null;
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f = z;
    }

    public final void a(String str) {
        if (f) {
            Log.e(e, str);
        }
    }
}
