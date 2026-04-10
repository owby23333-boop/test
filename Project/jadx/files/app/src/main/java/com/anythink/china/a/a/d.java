package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.anythink.china.a.a.c;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String a = "OaidAidlUtil";
    private static final String b = "com.huawei.hwid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6330c = "com.uodis.opendevice.OPENIDS_SERVICE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f6331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ServiceConnection f6332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f6333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.anythink.china.a.a f6334g;

    private final class a implements ServiceConnection {
        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f6333f = c.a.a(iBinder);
            try {
                if (d.this.f6333f != null) {
                    try {
                        if (d.this.f6334g != null) {
                            d.this.f6334g.a(d.this.f6333f.a(), d.this.f6333f.b());
                        }
                    } catch (RemoteException e2) {
                        if (d.this.f6334g != null) {
                            com.anythink.china.a.a aVar = d.this.f6334g;
                            e2.getMessage();
                            aVar.a();
                        }
                    } catch (Exception e3) {
                        if (d.this.f6334g != null) {
                            com.anythink.china.a.a aVar2 = d.this.f6334g;
                            e3.getMessage();
                            aVar2.a();
                        }
                    }
                }
            } finally {
                d.c(d.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f6333f = null;
        }

        private a() {
        }
    }

    public d(Context context) {
        this.f6331d = context;
    }

    static /* synthetic */ void c(d dVar) {
        ServiceConnection serviceConnection;
        Context context = dVar.f6331d;
        if (context == null || (serviceConnection = dVar.f6332e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        dVar.f6333f = null;
        dVar.f6331d = null;
        dVar.f6334g = null;
    }

    private void b() {
        ServiceConnection serviceConnection;
        Context context = this.f6331d;
        if (context == null || (serviceConnection = this.f6332e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        this.f6333f = null;
        this.f6331d = null;
        this.f6334g = null;
    }

    private boolean a() {
        byte b2 = 0;
        if (this.f6331d == null) {
            return false;
        }
        this.f6332e = new a(this, b2);
        Intent intent = new Intent(f6330c);
        intent.setPackage(b);
        return this.f6331d.bindService(intent, this.f6332e, 1);
    }

    public final void a(com.anythink.china.a.a aVar) {
        this.f6334g = aVar;
        if (this.f6331d != null) {
            this.f6332e = new a(this, (byte) 0);
            Intent intent = new Intent(f6330c);
            intent.setPackage(b);
            this.f6331d.bindService(intent, this.f6332e, 1);
        }
    }
}
